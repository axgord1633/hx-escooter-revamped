package com.baseflow.geolocator;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baseflow.geolocator.GeolocatorLocationService;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import n0.k;
import n0.m;
import o0.b;

public class a implements FlutterPlugin, ActivityAware {

    /* renamed from: a  reason: collision with root package name */
    private final b f3210a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final k f3211b = new k();

    /* renamed from: c  reason: collision with root package name */
    private final m f3212c = new m();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public GeolocatorLocationService f3213d;

    /* renamed from: e  reason: collision with root package name */
    private j f3214e;

    /* renamed from: f  reason: collision with root package name */
    private m f3215f;

    /* renamed from: g  reason: collision with root package name */
    private final ServiceConnection f3216g = new C0061a();

    /* renamed from: h  reason: collision with root package name */
    private b f3217h;

    /* renamed from: i  reason: collision with root package name */
    private PluginRegistry.Registrar f3218i;

    /* renamed from: j  reason: collision with root package name */
    private ActivityPluginBinding f3219j;

    /* renamed from: com.baseflow.geolocator.a$a  reason: collision with other inner class name */
    class C0061a implements ServiceConnection {
        C0061a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("FlutterGeolocator", "Geolocator foreground service connected");
            if (iBinder instanceof GeolocatorLocationService.a) {
                a.this.g(((GeolocatorLocationService.a) iBinder).a());
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("FlutterGeolocator", "Geolocator foreground service disconnected");
            if (a.this.f3213d != null) {
                a.this.f3213d.m((Activity) null);
                GeolocatorLocationService unused = a.this.f3213d = null;
            }
        }
    }

    private void d(Context context) {
        context.bindService(new Intent(context, GeolocatorLocationService.class), this.f3216g, 1);
    }

    private void e() {
        ActivityPluginBinding activityPluginBinding = this.f3219j;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.f3211b);
            this.f3219j.removeRequestPermissionsResultListener(this.f3210a);
        }
    }

    private void f() {
        Log.d("FlutterGeolocator", "Disposing Geolocator services");
        j jVar = this.f3214e;
        if (jVar != null) {
            jVar.x();
            this.f3214e.v((Activity) null);
            this.f3214e = null;
        }
        m mVar = this.f3215f;
        if (mVar != null) {
            mVar.i();
            this.f3215f.g((GeolocatorLocationService) null);
            this.f3215f = null;
        }
        b bVar = this.f3217h;
        if (bVar != null) {
            bVar.b((Context) null);
            this.f3217h.d();
            this.f3217h = null;
        }
        GeolocatorLocationService geolocatorLocationService = this.f3213d;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.m((Activity) null);
        }
    }

    /* access modifiers changed from: private */
    public void g(GeolocatorLocationService geolocatorLocationService) {
        Log.d("FlutterGeolocator", "Initializing Geolocator services");
        this.f3213d = geolocatorLocationService;
        geolocatorLocationService.g();
        m mVar = this.f3215f;
        if (mVar != null) {
            mVar.g(geolocatorLocationService);
        }
    }

    private void h() {
        PluginRegistry.Registrar registrar = this.f3218i;
        if (registrar != null) {
            registrar.addActivityResultListener(this.f3211b);
            this.f3218i.addRequestPermissionsResultListener(this.f3210a);
            return;
        }
        ActivityPluginBinding activityPluginBinding = this.f3219j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.f3211b);
            this.f3219j.addRequestPermissionsResultListener(this.f3210a);
        }
    }

    private void i(Context context) {
        GeolocatorLocationService geolocatorLocationService = this.f3213d;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.h();
        }
        context.unbindService(this.f3216g);
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Log.d("FlutterGeolocator", "Attaching Geolocator to activity");
        this.f3219j = activityPluginBinding;
        h();
        j jVar = this.f3214e;
        if (jVar != null) {
            jVar.v(activityPluginBinding.getActivity());
        }
        m mVar = this.f3215f;
        if (mVar != null) {
            mVar.f(activityPluginBinding.getActivity());
        }
        GeolocatorLocationService geolocatorLocationService = this.f3213d;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.m(this.f3219j.getActivity());
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        j jVar = new j(this.f3210a, this.f3211b, this.f3212c);
        this.f3214e = jVar;
        jVar.w(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        m mVar = new m(this.f3210a);
        this.f3215f = mVar;
        mVar.h(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        b bVar = new b();
        this.f3217h = bVar;
        bVar.b(flutterPluginBinding.getApplicationContext());
        this.f3217h.c(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        d(flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromActivity() {
        Log.d("FlutterGeolocator", "Detaching Geolocator from activity");
        e();
        j jVar = this.f3214e;
        if (jVar != null) {
            jVar.v((Activity) null);
        }
        m mVar = this.f3215f;
        if (mVar != null) {
            mVar.f((Activity) null);
        }
        GeolocatorLocationService geolocatorLocationService = this.f3213d;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.m((Activity) null);
        }
        if (this.f3219j != null) {
            this.f3219j = null;
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        i(flutterPluginBinding.getApplicationContext());
        f();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
