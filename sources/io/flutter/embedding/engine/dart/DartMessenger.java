package io.flutter.embedding.engine.dart;

import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.a;
import io.flutter.util.TraceSection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    private static final String TAG = "DartMessenger";
    private Map<String, List<BufferedMessageInfo>> bufferedMessages;
    private WeakHashMap<BinaryMessenger.TaskQueue, DartMessengerTaskQueue> createdTaskQueues;
    private final AtomicBoolean enableBufferingIncomingMessages;
    private final FlutterJNI flutterJNI;
    private final Object handlersLock;
    private final Map<String, HandlerInfo> messageHandlers;
    private int nextReplyId;
    private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
    private final DartMessengerTaskQueue platformTaskQueue;
    private TaskQueueFactory taskQueueFactory;

    private static class BufferedMessageInfo {
        public final ByteBuffer message;
        long messageData;
        int replyId;

        BufferedMessageInfo(ByteBuffer byteBuffer, int i5, long j5) {
            this.message = byteBuffer;
            this.replyId = i5;
            this.messageData = j5;
        }
    }

    static class ConcurrentTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;

        ConcurrentTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        public void dispatch(Runnable runnable) {
            this.executor.execute(runnable);
        }
    }

    interface DartMessengerTaskQueue {
        void dispatch(Runnable runnable);
    }

    private static class DefaultTaskQueueFactory implements TaskQueueFactory {
        ExecutorService executorService = FlutterInjector.instance().executorService();

        DefaultTaskQueueFactory() {
        }

        public DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            return taskQueueOptions.getIsSerial() ? new SerialTaskQueue(this.executorService) : new ConcurrentTaskQueue(this.executorService);
        }
    }

    private static class HandlerInfo {
        public final BinaryMessenger.BinaryMessageHandler handler;
        public final DartMessengerTaskQueue taskQueue;

        HandlerInfo(BinaryMessenger.BinaryMessageHandler binaryMessageHandler, DartMessengerTaskQueue dartMessengerTaskQueue) {
            this.handler = binaryMessageHandler;
            this.taskQueue = dartMessengerTaskQueue;
        }
    }

    static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final FlutterJNI flutterJNI;
        private final int replyId;

        Reply(FlutterJNI flutterJNI2, int i5) {
            this.flutterJNI = flutterJNI2;
            this.replyId = i5;
        }

        public void reply(ByteBuffer byteBuffer) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            } else if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }

    static class SerialTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;
        private final AtomicBoolean isRunning = new AtomicBoolean(false);
        private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        SerialTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        /* access modifiers changed from: private */
        /* renamed from: flush */
        public void lambda$flush$1() {
            if (this.isRunning.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.queue.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.isRunning.set(false);
                    if (!this.queue.isEmpty()) {
                        this.executor.execute(new b(this));
                    }
                }
            }
        }

        public void dispatch(Runnable runnable) {
            this.queue.add(runnable);
            this.executor.execute(new c(this));
        }
    }

    interface TaskQueueFactory {
        DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions);
    }

    private static class TaskQueueToken implements BinaryMessenger.TaskQueue {
        private TaskQueueToken() {
        }
    }

    DartMessenger(FlutterJNI flutterJNI2) {
        this(flutterJNI2, new DefaultTaskQueueFactory());
    }

    DartMessenger(FlutterJNI flutterJNI2, TaskQueueFactory taskQueueFactory2) {
        this.messageHandlers = new HashMap();
        this.bufferedMessages = new HashMap();
        this.handlersLock = new Object();
        this.enableBufferingIncomingMessages = new AtomicBoolean(false);
        this.pendingReplies = new HashMap();
        this.nextReplyId = 1;
        this.platformTaskQueue = new PlatformTaskQueue();
        this.createdTaskQueues = new WeakHashMap<>();
        this.flutterJNI = flutterJNI2;
        this.taskQueueFactory = taskQueueFactory2;
    }

    private void dispatchMessageToQueue(String str, HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i5, long j5) {
        HandlerInfo handlerInfo2 = handlerInfo;
        DartMessengerTaskQueue dartMessengerTaskQueue = handlerInfo2 != null ? handlerInfo2.taskQueue : null;
        TraceSection.beginAsyncSection("PlatformChannel ScheduleHandler on " + str, i5);
        a aVar = new a(this, str, i5, handlerInfo, byteBuffer, j5);
        if (dartMessengerTaskQueue == null) {
            dartMessengerTaskQueue = this.platformTaskQueue;
        }
        dartMessengerTaskQueue.dispatch(aVar);
    }

    private static void handleError(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() != null) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
            return;
        }
        throw error;
    }

    private void invokeHandler(HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i5) {
        if (handlerInfo != null) {
            try {
                Log.v(TAG, "Deferring to registered handler to process message.");
                handlerInfo.handler.onMessage(byteBuffer, new Reply(this.flutterJNI, i5));
            } catch (Exception e5) {
                Log.e(TAG, "Uncaught exception in binary message listener", e5);
            } catch (Error e6) {
                handleError(e6);
            }
        } else {
            Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i5);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchMessageToQueue$0(String str, int i5, HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j5) {
        TraceSection.endAsyncSection("PlatformChannel ScheduleHandler on " + str, i5);
        TraceSection.begin("DartMessenger#handleMessageFromDart on " + str);
        try {
            invokeHandler(handlerInfo, byteBuffer, i5);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.flutterJNI.cleanupMessageData(j5);
            TraceSection.end();
        }
    }

    public void disableBufferingIncomingMessages() {
        Map<String, List<BufferedMessageInfo>> map;
        synchronized (this.handlersLock) {
            this.enableBufferingIncomingMessages.set(false);
            map = this.bufferedMessages;
            this.bufferedMessages = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            for (BufferedMessageInfo bufferedMessageInfo : (List) next.getValue()) {
                dispatchMessageToQueue((String) next.getKey(), (HandlerInfo) null, bufferedMessageInfo.message, bufferedMessageInfo.replyId, bufferedMessageInfo.messageData);
            }
        }
    }

    public void enableBufferingIncomingMessages() {
        this.enableBufferingIncomingMessages.set(true);
    }

    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    public void handleMessageFromDart(String str, ByteBuffer byteBuffer, int i5, long j5) {
        HandlerInfo handlerInfo;
        boolean z4;
        Log.v(TAG, "Received message from Dart over channel '" + str + "'");
        synchronized (this.handlersLock) {
            handlerInfo = this.messageHandlers.get(str);
            z4 = this.enableBufferingIncomingMessages.get() && handlerInfo == null;
            if (z4) {
                if (!this.bufferedMessages.containsKey(str)) {
                    this.bufferedMessages.put(str, new LinkedList());
                }
                this.bufferedMessages.get(str).add(new BufferedMessageInfo(byteBuffer, i5, j5));
            }
        }
        if (!z4) {
            dispatchMessageToQueue(str, handlerInfo, byteBuffer, i5, j5);
        }
    }

    public void handlePlatformMessageResponse(int i5, ByteBuffer byteBuffer) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.pendingReplies.remove(Integer.valueOf(i5));
        if (remove != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                remove.reply(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            } catch (Exception e5) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", e5);
            } catch (Error e6) {
                handleError(e6);
            }
        }
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return a.c(this);
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        DartMessengerTaskQueue makeBackgroundTaskQueue = this.taskQueueFactory.makeBackgroundTaskQueue(taskQueueOptions);
        TaskQueueToken taskQueueToken = new TaskQueueToken();
        this.createdTaskQueues.put(taskQueueToken, makeBackgroundTaskQueue);
        return taskQueueToken;
    }

    public void send(String str, ByteBuffer byteBuffer) {
        Log.v(TAG, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        TraceSection.begin("DartMessenger#send on " + str);
        try {
            Log.v(TAG, "Sending message with callback over channel '" + str + "'");
            int i5 = this.nextReplyId;
            this.nextReplyId = i5 + 1;
            if (binaryReply != null) {
                this.pendingReplies.put(Integer.valueOf(i5), binaryReply);
            }
            if (byteBuffer == null) {
                this.flutterJNI.dispatchEmptyPlatformMessage(str, i5);
            } else {
                this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i5);
            }
        } finally {
            TraceSection.end();
        }
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        setMessageHandler(str, binaryMessageHandler, (BinaryMessenger.TaskQueue) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        r10 = r10.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r10.hasNext() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r11 = (io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r10.next();
        dispatchMessageToQueue(r9, r8.messageHandlers.get(r9), r11.message, r11.replyId, r11.messageData);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMessageHandler(java.lang.String r9, io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler r10, io.flutter.plugin.common.BinaryMessenger.TaskQueue r11) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x002a
            java.lang.String r10 = "DartMessenger"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Removing handler for channel '"
            r11.append(r0)
            r11.append(r9)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            io.flutter.Log.v(r10, r11)
            java.lang.Object r0 = r8.handlersLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r10 = r8.messageHandlers     // Catch:{ all -> 0x0027 }
            r10.remove(r9)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r9
        L_0x002a:
            r0 = 0
            if (r11 == 0) goto L_0x0041
            java.util.WeakHashMap<io.flutter.plugin.common.BinaryMessenger$TaskQueue, io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue> r0 = r8.createdTaskQueues
            java.lang.Object r11 = r0.get(r11)
            r0 = r11
            io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue r0 = (io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue) r0
            if (r0 == 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue)."
            r9.<init>(r10)
            throw r9
        L_0x0041:
            java.lang.String r11 = "DartMessenger"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Setting handler for channel '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            io.flutter.Log.v(r11, r1)
            java.lang.Object r11 = r8.handlersLock
            monitor-enter(r11)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r1 = r8.messageHandlers     // Catch:{ all -> 0x009c }
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r2 = new io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo     // Catch:{ all -> 0x009c }
            r2.<init>(r10, r0)     // Catch:{ all -> 0x009c }
            r1.put(r9, r2)     // Catch:{ all -> 0x009c }
            java.util.Map<java.lang.String, java.util.List<io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo>> r10 = r8.bufferedMessages     // Catch:{ all -> 0x009c }
            java.lang.Object r10 = r10.remove(r9)     // Catch:{ all -> 0x009c }
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x009c }
            if (r10 != 0) goto L_0x0075
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            return
        L_0x0075:
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            java.util.Iterator r10 = r10.iterator()
        L_0x007a:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x009b
            java.lang.Object r11 = r10.next()
            io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo r11 = (io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r11
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r0 = r8.messageHandlers
            java.lang.Object r0 = r0.get(r9)
            r3 = r0
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r3 = (io.flutter.embedding.engine.dart.DartMessenger.HandlerInfo) r3
            java.nio.ByteBuffer r4 = r11.message
            int r5 = r11.replyId
            long r6 = r11.messageData
            r1 = r8
            r2 = r9
            r1.dispatchMessageToQueue(r2, r3, r4, r5, r6)
            goto L_0x007a
        L_0x009b:
            return
        L_0x009c:
            r9 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.dart.DartMessenger.setMessageHandler(java.lang.String, io.flutter.plugin.common.BinaryMessenger$BinaryMessageHandler, io.flutter.plugin.common.BinaryMessenger$TaskQueue):void");
    }
}
