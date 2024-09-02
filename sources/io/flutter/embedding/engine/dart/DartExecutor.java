package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StringCodec;
import io.flutter.plugin.common.a;
import io.flutter.util.TraceSection;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.List;

public class DartExecutor implements BinaryMessenger {
    private static final String TAG = "DartExecutor";
    private final AssetManager assetManager;
    private final BinaryMessenger binaryMessenger;
    private final DartMessenger dartMessenger;
    private final FlutterJNI flutterJNI;
    private boolean isApplicationRunning = false;
    private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler;
    /* access modifiers changed from: private */
    public String isolateServiceId;
    /* access modifiers changed from: private */
    public IsolateServiceIdListener isolateServiceIdListener;

    public static class DartCallback {
        public final AssetManager androidAssetManager;
        public final FlutterCallbackInformation callbackHandle;
        public final String pathToBundle;

        public DartCallback(AssetManager assetManager, String str, FlutterCallbackInformation flutterCallbackInformation) {
            this.androidAssetManager = assetManager;
            this.pathToBundle = str;
            this.callbackHandle = flutterCallbackInformation;
        }

        public String toString() {
            return "DartCallback( bundle path: " + this.pathToBundle + ", library path: " + this.callbackHandle.callbackLibraryPath + ", function: " + this.callbackHandle.callbackName + " )";
        }
    }

    public static class DartEntrypoint {
        public final String dartEntrypointFunctionName;
        public final String dartEntrypointLibrary;
        public final String pathToBundle;

        public DartEntrypoint(String str, String str2) {
            this.pathToBundle = str;
            this.dartEntrypointLibrary = null;
            this.dartEntrypointFunctionName = str2;
        }

        public DartEntrypoint(String str, String str2, String str3) {
            this.pathToBundle = str;
            this.dartEntrypointLibrary = str2;
            this.dartEntrypointFunctionName = str3;
        }

        public static DartEntrypoint createDefault() {
            FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
            if (flutterLoader.initialized()) {
                return new DartEntrypoint(flutterLoader.findAppBundlePath(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DartEntrypoint dartEntrypoint = (DartEntrypoint) obj;
            if (!this.pathToBundle.equals(dartEntrypoint.pathToBundle)) {
                return false;
            }
            return this.dartEntrypointFunctionName.equals(dartEntrypoint.dartEntrypointFunctionName);
        }

        public int hashCode() {
            return (this.pathToBundle.hashCode() * 31) + this.dartEntrypointFunctionName.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.pathToBundle + ", function: " + this.dartEntrypointFunctionName + " )";
        }
    }

    private static class DefaultBinaryMessenger implements BinaryMessenger {
        private final DartMessenger messenger;

        private DefaultBinaryMessenger(DartMessenger dartMessenger) {
            this.messenger = dartMessenger;
        }

        public void disableBufferingIncomingMessages() {
            this.messenger.disableBufferingIncomingMessages();
        }

        public void enableBufferingIncomingMessages() {
            this.messenger.enableBufferingIncomingMessages();
        }

        public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
            return a.c(this);
        }

        public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            return this.messenger.makeBackgroundTaskQueue(taskQueueOptions);
        }

        public void send(String str, ByteBuffer byteBuffer) {
            this.messenger.send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
        }

        public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            this.messenger.send(str, byteBuffer, binaryReply);
        }

        public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
            this.messenger.setMessageHandler(str, binaryMessageHandler);
        }

        public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
            this.messenger.setMessageHandler(str, binaryMessageHandler, taskQueue);
        }
    }

    public interface IsolateServiceIdListener {
        void onIsolateServiceIdAvailable(String str);
    }

    public DartExecutor(FlutterJNI flutterJNI2, AssetManager assetManager2) {
        AnonymousClass1 r02 = new BinaryMessenger.BinaryMessageHandler() {
            public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
                String unused = DartExecutor.this.isolateServiceId = StringCodec.INSTANCE.decodeMessage(byteBuffer);
                if (DartExecutor.this.isolateServiceIdListener != null) {
                    DartExecutor.this.isolateServiceIdListener.onIsolateServiceIdAvailable(DartExecutor.this.isolateServiceId);
                }
            }
        };
        this.isolateChannelMessageHandler = r02;
        this.flutterJNI = flutterJNI2;
        this.assetManager = assetManager2;
        DartMessenger dartMessenger2 = new DartMessenger(flutterJNI2);
        this.dartMessenger = dartMessenger2;
        dartMessenger2.setMessageHandler("flutter/isolate", r02);
        this.binaryMessenger = new DefaultBinaryMessenger(dartMessenger2);
        if (flutterJNI2.isAttached()) {
            this.isApplicationRunning = true;
        }
    }

    @Deprecated
    public void disableBufferingIncomingMessages() {
        this.dartMessenger.disableBufferingIncomingMessages();
    }

    @Deprecated
    public void enableBufferingIncomingMessages() {
        this.dartMessenger.enableBufferingIncomingMessages();
    }

    public void executeDartCallback(DartCallback dartCallback) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        TraceSection.begin("DartExecutor#executeDartCallback");
        try {
            Log.v(TAG, "Executing Dart callback: " + dartCallback);
            FlutterJNI flutterJNI2 = this.flutterJNI;
            String str = dartCallback.pathToBundle;
            FlutterCallbackInformation flutterCallbackInformation = dartCallback.callbackHandle;
            flutterJNI2.runBundleAndSnapshotFromLibrary(str, flutterCallbackInformation.callbackName, flutterCallbackInformation.callbackLibraryPath, dartCallback.androidAssetManager, (List<String>) null);
            this.isApplicationRunning = true;
        } finally {
            TraceSection.end();
        }
    }

    public void executeDartEntrypoint(DartEntrypoint dartEntrypoint) {
        executeDartEntrypoint(dartEntrypoint, (List<String>) null);
    }

    public void executeDartEntrypoint(DartEntrypoint dartEntrypoint, List<String> list) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        TraceSection.begin("DartExecutor#executeDartEntrypoint");
        try {
            Log.v(TAG, "Executing Dart entrypoint: " + dartEntrypoint);
            this.flutterJNI.runBundleAndSnapshotFromLibrary(dartEntrypoint.pathToBundle, dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, this.assetManager, list);
            this.isApplicationRunning = true;
        } finally {
            TraceSection.end();
        }
    }

    public BinaryMessenger getBinaryMessenger() {
        return this.binaryMessenger;
    }

    public String getIsolateServiceId() {
        return this.isolateServiceId;
    }

    public int getPendingChannelResponseCount() {
        return this.dartMessenger.getPendingChannelResponseCount();
    }

    public boolean isExecutingDart() {
        return this.isApplicationRunning;
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return a.c(this);
    }

    @Deprecated
    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return this.binaryMessenger.makeBackgroundTaskQueue(taskQueueOptions);
    }

    public void notifyLowMemoryWarning() {
        if (this.flutterJNI.isAttached()) {
            this.flutterJNI.notifyLowMemoryWarning();
        }
    }

    public void onAttachedToJNI() {
        Log.v(TAG, "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler(this.dartMessenger);
    }

    public void onDetachedFromJNI() {
        Log.v(TAG, "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler((PlatformMessageHandler) null);
    }

    @Deprecated
    public void send(String str, ByteBuffer byteBuffer) {
        this.binaryMessenger.send(str, byteBuffer);
    }

    @Deprecated
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        this.binaryMessenger.send(str, byteBuffer, binaryReply);
    }

    public void setIsolateServiceIdListener(IsolateServiceIdListener isolateServiceIdListener2) {
        String str;
        this.isolateServiceIdListener = isolateServiceIdListener2;
        if (isolateServiceIdListener2 != null && (str = this.isolateServiceId) != null) {
            isolateServiceIdListener2.onIsolateServiceIdAvailable(str);
        }
    }

    @Deprecated
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.binaryMessenger.setMessageHandler(str, binaryMessageHandler);
    }

    @Deprecated
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.binaryMessenger.setMessageHandler(str, binaryMessageHandler, taskQueue);
    }
}
