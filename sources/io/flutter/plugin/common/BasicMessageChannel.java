package io.flutter.plugin.common;

import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    private static final String TAG = "BasicMessageChannel#";
    /* access modifiers changed from: private */
    public final MessageCodec<T> codec;
    private final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    public final String name;
    private final BinaryMessenger.TaskQueue taskQueue;

    private final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        private IncomingMessageHandler(MessageHandler<T> messageHandler) {
            this.handler = messageHandler;
        }

        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(byteBuffer), new Reply<T>() {
                    public void reply(T t5) {
                        binaryReply.reply(BasicMessageChannel.this.codec.encodeMessage(t5));
                    }
                });
            } catch (RuntimeException e5) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message", e5);
                binaryReply.reply((ByteBuffer) null);
            }
        }
    }

    private final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        private IncomingReplyHandler(Reply<T> reply) {
            this.callback = reply;
        }

        public void reply(ByteBuffer byteBuffer) {
            try {
                this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(byteBuffer));
            } catch (RuntimeException e5) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message reply", e5);
            }
        }
    }

    public interface MessageHandler<T> {
        void onMessage(T t5, Reply<T> reply);
    }

    public interface Reply<T> {
        void reply(T t5);
    }

    public BasicMessageChannel(BinaryMessenger binaryMessenger, String str, MessageCodec<T> messageCodec) {
        this(binaryMessenger, str, messageCodec, (BinaryMessenger.TaskQueue) null);
    }

    public BasicMessageChannel(BinaryMessenger binaryMessenger, String str, MessageCodec<T> messageCodec, BinaryMessenger.TaskQueue taskQueue2) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = messageCodec;
        this.taskQueue = taskQueue2;
    }

    private static ByteBuffer packetFromEncodedMessage(ByteBuffer byteBuffer) {
        byteBuffer.flip();
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(remaining);
        allocateDirect.put(bArr);
        return allocateDirect;
    }

    public static void resizeChannelBuffer(BinaryMessenger binaryMessenger, String str, int i5) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, packetFromEncodedMessage(StandardMethodCodec.INSTANCE.encodeMethodCall(new MethodCall("resize", Arrays.asList(new Object[]{str, Integer.valueOf(i5)})))));
    }

    public static void setWarnsOnChannelOverflow(BinaryMessenger binaryMessenger, String str, boolean z4) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, packetFromEncodedMessage(StandardMethodCodec.INSTANCE.encodeMethodCall(new MethodCall("overflow", Arrays.asList(new Object[]{str, Boolean.valueOf(!z4)})))));
    }

    public void resizeChannelBuffer(int i5) {
        resizeChannelBuffer(this.messenger, this.name, i5);
    }

    public void send(T t5) {
        send(t5, (Reply) null);
    }

    public void send(T t5, Reply<T> reply) {
        BinaryMessenger binaryMessenger = this.messenger;
        String str = this.name;
        ByteBuffer encodeMessage = this.codec.encodeMessage(t5);
        IncomingReplyHandler incomingReplyHandler = null;
        if (reply != null) {
            incomingReplyHandler = new IncomingReplyHandler(reply);
        }
        binaryMessenger.send(str, encodeMessage, incomingReplyHandler);
    }

    public void setMessageHandler(MessageHandler<T> messageHandler) {
        IncomingMessageHandler incomingMessageHandler = null;
        if (this.taskQueue != null) {
            BinaryMessenger binaryMessenger = this.messenger;
            String str = this.name;
            if (messageHandler != null) {
                incomingMessageHandler = new IncomingMessageHandler(messageHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingMessageHandler, this.taskQueue);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.messenger;
        String str2 = this.name;
        if (messageHandler != null) {
            incomingMessageHandler = new IncomingMessageHandler(messageHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingMessageHandler);
    }

    public void setWarnsOnChannelOverflow(boolean z4) {
        setWarnsOnChannelOverflow(this.messenger, this.name, z4);
    }
}
