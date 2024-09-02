package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.f;
import androidx.lifecycle.j;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;

public class FilePickerPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {

    /* renamed from: i  reason: collision with root package name */
    private static String f3827i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f3828j = false;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f3829k = false;

    /* renamed from: a  reason: collision with root package name */
    private ActivityPluginBinding f3830a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f3831b;

    /* renamed from: c  reason: collision with root package name */
    private Application f3832c;

    /* renamed from: d  reason: collision with root package name */
    private FlutterPlugin.FlutterPluginBinding f3833d;

    /* renamed from: e  reason: collision with root package name */
    private f f3834e;

    /* renamed from: f  reason: collision with root package name */
    private LifeCycleObserver f3835f;

    /* renamed from: g  reason: collision with root package name */
    private Activity f3836g;

    /* renamed from: h  reason: collision with root package name */
    private MethodChannel f3837h;

    private class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

        /* renamed from: e  reason: collision with root package name */
        private final Activity f3838e;

        LifeCycleObserver(Activity activity) {
            this.f3838e = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f3838e == activity && activity.getApplicationContext() != null) {
                ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onCreate(j jVar) {
        }

        public void onDestroy(j jVar) {
            onActivityDestroyed(this.f3838e);
        }

        public void onPause(j jVar) {
        }

        public void onResume(j jVar) {
        }

        public void onStart(j jVar) {
        }

        public void onStop(j jVar) {
            onActivityStopped(this.f3838e);
        }
    }

    class a implements EventChannel.StreamHandler {
        a() {
        }

        public void onCancel(Object obj) {
            FilePickerPlugin.this.f3831b.n((EventChannel.EventSink) null);
        }

        public void onListen(Object obj, EventChannel.EventSink eventSink) {
            FilePickerPlugin.this.f3831b.n(eventSink);
        }
    }

    private static class b implements MethodChannel.Result {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final MethodChannel.Result f3841a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f3842b = new Handler(Looper.getMainLooper());

        class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Object f3843e;

            a(Object obj) {
                this.f3843e = obj;
            }

            public void run() {
                b.this.f3841a.success(this.f3843e);
            }
        }

        /* renamed from: com.mr.flutter.plugin.filepicker.FilePickerPlugin$b$b  reason: collision with other inner class name */
        class C0067b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f3845e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ String f3846f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ Object f3847g;

            C0067b(String str, String str2, Object obj) {
                this.f3845e = str;
                this.f3846f = str2;
                this.f3847g = obj;
            }

            public void run() {
                b.this.f3841a.error(this.f3845e, this.f3846f, this.f3847g);
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                b.this.f3841a.notImplemented();
            }
        }

        b(MethodChannel.Result result) {
            this.f3841a = result;
        }

        public void error(String str, String str2, Object obj) {
            this.f3842b.post(new C0067b(str, str2, obj));
        }

        public void notImplemented() {
            this.f3842b.post(new c());
        }

        public void success(Object obj) {
            this.f3842b.post(new a(obj));
        }
    }

    private static String b(String str) {
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1349088399:
                if (str.equals("custom")) {
                    c5 = 0;
                    break;
                }
                break;
            case 96748:
                if (str.equals("any")) {
                    c5 = 1;
                    break;
                }
                break;
            case 99469:
                if (str.equals("dir")) {
                    c5 = 2;
                    break;
                }
                break;
            case 93166550:
                if (str.equals("audio")) {
                    c5 = 3;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c5 = 4;
                    break;
                }
                break;
            case 103772132:
                if (str.equals("media")) {
                    c5 = 5;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c5 = 6;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 1:
                return "*/*";
            case 2:
                return "dir";
            case 3:
                return "audio/*";
            case 4:
                return "image/*";
            case 5:
                return "image/*,video/*";
            case 6:
                return "video/*";
            default:
                return null;
        }
    }

    private void c(BinaryMessenger binaryMessenger, Application application, Activity activity, PluginRegistry.Registrar registrar, ActivityPluginBinding activityPluginBinding) {
        this.f3836g = activity;
        this.f3832c = application;
        this.f3831b = new b(activity);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "miguelruivo.flutter.plugins.filepicker");
        this.f3837h = methodChannel;
        methodChannel.setMethodCallHandler(this);
        new EventChannel(binaryMessenger, "miguelruivo.flutter.plugins.filepickerevent").setStreamHandler(new a());
        LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity);
        this.f3835f = lifeCycleObserver;
        if (registrar != null) {
            application.registerActivityLifecycleCallbacks(lifeCycleObserver);
            registrar.addActivityResultListener(this.f3831b);
            registrar.addRequestPermissionsResultListener(this.f3831b);
            return;
        }
        activityPluginBinding.addActivityResultListener(this.f3831b);
        activityPluginBinding.addRequestPermissionsResultListener(this.f3831b);
        f activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
        this.f3834e = activityLifecycle;
        activityLifecycle.a(this.f3835f);
    }

    private void d() {
        this.f3830a.removeActivityResultListener(this.f3831b);
        this.f3830a.removeRequestPermissionsResultListener(this.f3831b);
        this.f3830a = null;
        LifeCycleObserver lifeCycleObserver = this.f3835f;
        if (lifeCycleObserver != null) {
            this.f3834e.c(lifeCycleObserver);
            this.f3832c.unregisterActivityLifecycleCallbacks(this.f3835f);
        }
        this.f3834e = null;
        this.f3831b.n((EventChannel.EventSink) null);
        this.f3831b = null;
        this.f3837h.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f3837h = null;
        this.f3832c = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.f3830a = activityPluginBinding;
        c(this.f3833d.getBinaryMessenger(), (Application) this.f3833d.getApplicationContext(), this.f3830a.getActivity(), (PluginRegistry.Registrar) null, this.f3830a);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f3833d = flutterPluginBinding;
    }

    public void onDetachedFromActivity() {
        d();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f3833d = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String[] strArr;
        String str;
        if (this.f3836g == null) {
            result.error("no_activity", "file picker plugin requires a foreground activity", (Object) null);
            return;
        }
        b bVar = new b(result);
        HashMap hashMap = (HashMap) methodCall.arguments;
        String str2 = methodCall.method;
        if (str2 == null || !str2.equals("clear")) {
            String b5 = b(methodCall.method);
            f3827i = b5;
            if (b5 == null) {
                bVar.notImplemented();
            } else if (b5 != "dir") {
                f3828j = ((Boolean) hashMap.get("allowMultipleSelection")).booleanValue();
                f3829k = ((Boolean) hashMap.get("withData")).booleanValue();
                strArr = c.f((ArrayList) hashMap.get("allowedExtensions"));
                str = methodCall.method;
                if (str == null && !str.equals("custom") && (strArr == null || strArr.length == 0)) {
                    bVar.error("FilePicker", "Unsupported filter. Make sure that you are only using the extension without the dot, (ie., jpg instead of .jpg). This could also have happened because you are using an unsupported file extension.  If the problem persists, you may want to consider using FileType.all instead.", (Object) null);
                    return;
                } else {
                    this.f3831b.q(f3827i, f3828j, f3829k, strArr, bVar);
                    return;
                }
            }
            strArr = null;
            str = methodCall.method;
            if (str == null && !str.equals("custom")) {
            }
            this.f3831b.q(f3827i, f3828j, f3829k, strArr, bVar);
            return;
        }
        bVar.success(Boolean.valueOf(c.a(this.f3836g.getApplicationContext())));
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
