package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalizationChannel {
    private static final String TAG = "LocalizationChannel";
    public final MethodChannel channel;
    public final MethodChannel.MethodCallHandler handler;
    /* access modifiers changed from: private */
    public LocalizationMessageHandler localizationMessageHandler;

    public interface LocalizationMessageHandler {
        String getStringResource(String str, String str2);
    }

    public LocalizationChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (LocalizationChannel.this.localizationMessageHandler != null) {
                    String str = methodCall.method;
                    str.hashCode();
                    if (!str.equals("Localization.getStringResource")) {
                        result.notImplemented();
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) methodCall.arguments();
                    try {
                        result.success(LocalizationChannel.this.localizationMessageHandler.getStringResource(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
                    } catch (JSONException e5) {
                        result.error("error", e5.getMessage(), (Object) null);
                    }
                }
            }
        };
        this.handler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void sendLocales(List<Locale> list) {
        Log.v(TAG, "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale next : list) {
            Log.v(TAG, "Locale (Language: " + next.getLanguage() + ", Country: " + next.getCountry() + ", Variant: " + next.getVariant() + ")");
            arrayList.add(next.getLanguage());
            arrayList.add(next.getCountry());
            arrayList.add(next.getScript());
            arrayList.add(next.getVariant());
        }
        this.channel.invokeMethod("setLocale", arrayList);
    }

    public void setLocalizationMessageHandler(LocalizationMessageHandler localizationMessageHandler2) {
        this.localizationMessageHandler = localizationMessageHandler2;
    }
}
