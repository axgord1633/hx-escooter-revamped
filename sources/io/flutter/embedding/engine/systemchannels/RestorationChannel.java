package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class RestorationChannel {
    private static final String TAG = "RestorationChannel";
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public boolean engineHasProvidedData;
    /* access modifiers changed from: private */
    public boolean frameworkHasRequestedData;
    private final MethodChannel.MethodCallHandler handler;
    /* access modifiers changed from: private */
    public MethodChannel.Result pendingFrameworkRestorationChannelRequest;
    /* access modifiers changed from: private */
    public byte[] restorationData;
    public final boolean waitForRestorationData;

    public RestorationChannel(DartExecutor dartExecutor, boolean z4) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z4);
    }

    RestorationChannel(MethodChannel methodChannel, boolean z4) {
        this.engineHasProvidedData = false;
        this.frameworkHasRequestedData = false;
        AnonymousClass2 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                Map access$300;
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                str.hashCode();
                if (str.equals("get")) {
                    boolean unused = RestorationChannel.this.frameworkHasRequestedData = true;
                    if (!RestorationChannel.this.engineHasProvidedData) {
                        RestorationChannel restorationChannel = RestorationChannel.this;
                        if (restorationChannel.waitForRestorationData) {
                            MethodChannel.Result unused2 = restorationChannel.pendingFrameworkRestorationChannelRequest = result;
                            return;
                        }
                    }
                    RestorationChannel restorationChannel2 = RestorationChannel.this;
                    access$300 = restorationChannel2.packageData(restorationChannel2.restorationData);
                } else if (!str.equals("put")) {
                    result.notImplemented();
                    return;
                } else {
                    byte[] unused3 = RestorationChannel.this.restorationData = (byte[]) obj;
                    access$300 = null;
                }
                result.success(access$300);
            }
        };
        this.handler = r02;
        this.channel = methodChannel;
        this.waitForRestorationData = z4;
        methodChannel.setMethodCallHandler(r02);
    }

    /* access modifiers changed from: private */
    public Map<String, Object> packageData(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void clearData() {
        this.restorationData = null;
    }

    public byte[] getRestorationData() {
        return this.restorationData;
    }

    public void setRestorationData(final byte[] bArr) {
        this.engineHasProvidedData = true;
        MethodChannel.Result result = this.pendingFrameworkRestorationChannelRequest;
        if (result != null) {
            result.success(packageData(bArr));
            this.pendingFrameworkRestorationChannelRequest = null;
        } else if (this.frameworkHasRequestedData) {
            this.channel.invokeMethod("push", packageData(bArr), new MethodChannel.Result() {
                public void error(String str, String str2, Object obj) {
                    Log.e(RestorationChannel.TAG, "Error " + str + " while sending restoration data to framework: " + str2);
                }

                public void notImplemented() {
                }

                public void success(Object obj) {
                    byte[] unused = RestorationChannel.this.restorationData = bArr;
                }
            });
            return;
        }
        this.restorationData = bArr;
    }
}
