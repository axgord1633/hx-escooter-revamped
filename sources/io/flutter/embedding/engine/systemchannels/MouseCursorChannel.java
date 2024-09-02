package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;

public class MouseCursorChannel {
    private static final String TAG = "MouseCursorChannel";
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    public MouseCursorMethodHandler mouseCursorMethodHandler;
    private final MethodChannel.MethodCallHandler parsingMethodCallHandler;

    public interface MouseCursorMethodHandler {
        void activateSystemCursor(String str);
    }

    public MouseCursorChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (MouseCursorChannel.this.mouseCursorMethodHandler != null) {
                    String str = methodCall.method;
                    Log.v(MouseCursorChannel.TAG, "Received '" + str + "' message.");
                    char c5 = 65535;
                    try {
                        if (str.hashCode() == -1307105544) {
                            if (str.equals("activateSystemCursor")) {
                                c5 = 0;
                            }
                        }
                        if (c5 == 0) {
                            try {
                                MouseCursorChannel.this.mouseCursorMethodHandler.activateSystemCursor((String) ((HashMap) methodCall.arguments).get("kind"));
                                result.success(Boolean.TRUE);
                            } catch (Exception e5) {
                                result.error("error", "Error when setting cursors: " + e5.getMessage(), (Object) null);
                            }
                        }
                    } catch (Exception e6) {
                        result.error("error", "Unhandled error: " + e6.getMessage(), (Object) null);
                    }
                }
            }
        };
        this.parsingMethodCallHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void setMethodHandler(MouseCursorMethodHandler mouseCursorMethodHandler2) {
        this.mouseCursorMethodHandler = mouseCursorMethodHandler2;
    }

    public void synthesizeMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.parsingMethodCallHandler.onMethodCall(methodCall, result);
    }
}
