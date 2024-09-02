package q0;

import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public final class m implements FlutterPlugin, ActivityAware {

    /* renamed from: a  reason: collision with root package name */
    private q f6616a;

    /* renamed from: b  reason: collision with root package name */
    private MethodChannel f6617b;

    /* renamed from: c  reason: collision with root package name */
    private PluginRegistry.Registrar f6618c;

    /* renamed from: d  reason: collision with root package name */
    private ActivityPluginBinding f6619d;

    /* renamed from: e  reason: collision with root package name */
    private l f6620e;

    private void a() {
        ActivityPluginBinding activityPluginBinding = this.f6619d;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.f6616a);
            this.f6619d.removeRequestPermissionsResultListener(this.f6616a);
        }
    }

    private void b() {
        PluginRegistry.Registrar registrar = this.f6618c;
        if (registrar != null) {
            registrar.addActivityResultListener(this.f6616a);
            this.f6618c.addRequestPermissionsResultListener(this.f6616a);
            return;
        }
        ActivityPluginBinding activityPluginBinding = this.f6619d;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.f6616a);
            this.f6619d.addRequestPermissionsResultListener(this.f6616a);
        }
    }

    private void c(Context context, BinaryMessenger binaryMessenger) {
        this.f6617b = new MethodChannel(binaryMessenger, "flutter.baseflow.com/permissions/methods");
        l lVar = new l(context, new a(), this.f6616a, new u());
        this.f6620e = lVar;
        this.f6617b.setMethodCallHandler(lVar);
    }

    private void d(Activity activity) {
        q qVar = this.f6616a;
        if (qVar != null) {
            qVar.h(activity);
        }
    }

    private void e() {
        this.f6617b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f6617b = null;
        this.f6620e = null;
    }

    private void f() {
        q qVar = this.f6616a;
        if (qVar != null) {
            qVar.h((Activity) null);
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        d(activityPluginBinding.getActivity());
        this.f6619d = activityPluginBinding;
        b();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f6616a = new q(flutterPluginBinding.getApplicationContext());
        c(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        f();
        a();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        e();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
