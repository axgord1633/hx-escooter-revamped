package g2;

import android.app.Activity;
import g2.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import kotlin.jvm.internal.k;

public final class g implements FlutterPlugin, a.c, ActivityAware {

    /* renamed from: a  reason: collision with root package name */
    private f f4738a;

    public void a(a.b bVar) {
        f fVar = this.f4738a;
        k.b(fVar);
        k.b(bVar);
        fVar.d(bVar);
    }

    public a.C0079a isEnabled() {
        f fVar = this.f4738a;
        k.b(fVar);
        return fVar.b();
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        k.e(activityPluginBinding, "binding");
        f fVar = this.f4738a;
        if (fVar != null) {
            fVar.c(activityPluginBinding.getActivity());
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        d.d(flutterPluginBinding.getBinaryMessenger(), this);
        this.f4738a = new f();
    }

    public void onDetachedFromActivity() {
        f fVar = this.f4738a;
        if (fVar != null) {
            fVar.c((Activity) null);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        d.d(flutterPluginBinding.getBinaryMessenger(), (a.c) null);
        this.f4738a = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        k.e(activityPluginBinding, "binding");
        onAttachedToActivity(activityPluginBinding);
    }
}
