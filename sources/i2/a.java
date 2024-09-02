package i2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.WindowManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.k;

public final class a implements FlutterPlugin {

    /* renamed from: a  reason: collision with root package name */
    private MethodChannel f4950a;

    private final void a(BinaryMessenger binaryMessenger, Context context) {
        this.f4950a = new MethodChannel(binaryMessenger, "dev.fluttercommunity.plus/device_info");
        PackageManager packageManager = context.getPackageManager();
        k.d(packageManager, "context.packageManager");
        Object systemService = context.getSystemService("window");
        k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        c cVar = new c(packageManager, (WindowManager) systemService);
        MethodChannel methodChannel = this.f4950a;
        if (methodChannel == null) {
            k.o("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(cVar);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        k.d(binaryMessenger, "binding.binaryMessenger");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        k.d(applicationContext, "binding.applicationContext");
        a(binaryMessenger, applicationContext);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f4950a;
        if (methodChannel == null) {
            k.o("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
