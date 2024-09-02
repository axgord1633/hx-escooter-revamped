package io.flutter.embedding.engine.systemchannels;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class KeyboardChannel {
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    public KeyboardMethodHandler keyboardMethodHandler;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;

    public interface KeyboardMethodHandler {
        Map<Long, Long> getKeyboardState();
    }

    public KeyboardChannel(BinaryMessenger binaryMessenger) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            Map<Long, Long> pressedState = new HashMap();

            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (KeyboardChannel.this.keyboardMethodHandler != null) {
                    String str = methodCall.method;
                    str.hashCode();
                    if (!str.equals("getKeyboardState")) {
                        result.notImplemented();
                        return;
                    }
                    try {
                        this.pressedState = KeyboardChannel.this.keyboardMethodHandler.getKeyboardState();
                    } catch (IllegalStateException e5) {
                        result.error("error", e5.getMessage(), (Object) null);
                    }
                }
                result.success(this.pressedState);
            }
        };
        this.parsingMethodHandler = r02;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter/keyboard", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void setKeyboardMethodHandler(KeyboardMethodHandler keyboardMethodHandler2) {
        this.keyboardMethodHandler = keyboardMethodHandler2;
    }
}
