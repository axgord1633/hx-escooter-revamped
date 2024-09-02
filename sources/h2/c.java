package h2;

import android.content.Context;
import android.os.Build;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.k;

public final class c implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    private MethodChannel f4837a;

    /* renamed from: b  reason: collision with root package name */
    private a f4838b;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        k.d(applicationContext, "flutterPluginBinding.applicationContext");
        this.f4838b = new a(applicationContext);
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "application_icon");
        this.f4837a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f4837a;
        if (methodChannel == null) {
            k.o("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        k.e(methodCall, "call");
        k.e(result, "result");
        int i5 = Build.VERSION.SDK_INT;
        a aVar = null;
        String str = methodCall.method;
        if (i5 >= 26) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1743687096:
                        if (str.equals("bitmapIcon")) {
                            a aVar2 = this.f4838b;
                            if (aVar2 == null) {
                                k.o("iconLoader");
                            } else {
                                aVar = aVar2;
                            }
                            result.success(aVar.f());
                            return;
                        }
                        return;
                    case 693698649:
                        if (str.equals("adaptiveForeground")) {
                            a aVar3 = this.f4838b;
                            if (aVar3 == null) {
                                k.o("iconLoader");
                            } else {
                                aVar = aVar3;
                            }
                            result.success(aVar.d());
                            return;
                        }
                        return;
                    case 1505897417:
                        if (str.equals("hasAdaptiveIcon")) {
                            a aVar4 = this.f4838b;
                            if (aVar4 == null) {
                                k.o("iconLoader");
                            } else {
                                aVar = aVar4;
                            }
                            result.success(Boolean.valueOf(aVar.b()));
                            return;
                        }
                        return;
                    case 1672014916:
                        if (str.equals("adaptiveBackground")) {
                            a aVar5 = this.f4838b;
                            if (aVar5 == null) {
                                k.o("iconLoader");
                            } else {
                                aVar = aVar5;
                            }
                            result.success(aVar.c());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } else if (str != null) {
            switch (str.hashCode()) {
                case -1743687096:
                    if (str.equals("bitmapIcon")) {
                        a aVar6 = this.f4838b;
                        if (aVar6 == null) {
                            k.o("iconLoader");
                        } else {
                            aVar = aVar6;
                        }
                        result.success(aVar.f());
                        return;
                    }
                    return;
                case 693698649:
                    if (!str.equals("adaptiveForeground")) {
                        return;
                    }
                    break;
                case 1505897417:
                    if (str.equals("hasAdaptiveIcon")) {
                        result.success(Boolean.FALSE);
                        return;
                    }
                    return;
                case 1672014916:
                    if (!str.equals("adaptiveBackground")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            result.notImplemented();
        }
    }
}
