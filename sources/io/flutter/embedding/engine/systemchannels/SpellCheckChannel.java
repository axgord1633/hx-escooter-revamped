package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;

public class SpellCheckChannel {
    private static final String TAG = "SpellCheckChannel";
    public final MethodChannel channel;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;
    /* access modifiers changed from: private */
    public SpellCheckMethodHandler spellCheckMethodHandler;

    public interface SpellCheckMethodHandler {
        void initiateSpellCheck(String str, String str2, MethodChannel.Result result);
    }

    public SpellCheckChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (SpellCheckChannel.this.spellCheckMethodHandler == null) {
                    Log.v(SpellCheckChannel.TAG, "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                    return;
                }
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(SpellCheckChannel.TAG, "Received '" + str + "' message.");
                str.hashCode();
                if (!str.equals("SpellCheck.initiateSpellCheck")) {
                    result.notImplemented();
                    return;
                }
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    SpellCheckChannel.this.spellCheckMethodHandler.initiateSpellCheck((String) arrayList.get(0), (String) arrayList.get(1), result);
                } catch (IllegalStateException e5) {
                    result.error("error", e5.getMessage(), (Object) null);
                }
            }
        };
        this.parsingMethodHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/spellcheck", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void setSpellCheckMethodHandler(SpellCheckMethodHandler spellCheckMethodHandler2) {
        this.spellCheckMethodHandler = spellCheckMethodHandler2;
    }
}
