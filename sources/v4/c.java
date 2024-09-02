package v4;

import android.app.Activity;
import androidx.appcompat.app.f;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class c implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {

    /* renamed from: a  reason: collision with root package name */
    private b f7280a;

    /* renamed from: b  reason: collision with root package name */
    private ActivityPluginBinding f7281b;

    static {
        f.B(true);
    }

    private void b(BinaryMessenger binaryMessenger) {
        new MethodChannel(binaryMessenger, "plugins.hunghd.vn/image_cropper").setMethodCallHandler(this);
    }

    public b a(Activity activity) {
        b bVar = new b(activity);
        this.f7280a = bVar;
        return bVar;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        a(activityPluginBinding.getActivity());
        this.f7281b = activityPluginBinding;
        activityPluginBinding.addActivityResultListener(this.f7280a);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        b(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        this.f7281b.removeActivityResultListener(this.f7280a);
        this.f7281b = null;
        this.f7280a = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("cropImage")) {
            this.f7280a.j(methodCall, result);
        } else if (methodCall.method.equals("recoverImage")) {
            this.f7280a.h(methodCall, result);
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
