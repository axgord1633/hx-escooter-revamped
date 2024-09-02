package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import java.util.Map;
import m0.c;
import n0.d;
import n0.k;
import n0.p;
import n0.z;
import o0.b;

class m implements EventChannel.StreamHandler {

    /* renamed from: a  reason: collision with root package name */
    private final b f3248a;

    /* renamed from: b  reason: collision with root package name */
    private EventChannel f3249b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3250c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f3251d;

    /* renamed from: e  reason: collision with root package name */
    private GeolocatorLocationService f3252e;

    /* renamed from: f  reason: collision with root package name */
    private k f3253f = new k();

    /* renamed from: g  reason: collision with root package name */
    private p f3254g;

    public m(b bVar) {
        this.f3248a = bVar;
    }

    private void c(boolean z4) {
        k kVar;
        Log.e("FlutterGeolocator", "Geolocator position updates stopped");
        GeolocatorLocationService geolocatorLocationService = this.f3252e;
        if (geolocatorLocationService == null || !geolocatorLocationService.c(z4)) {
            Log.e("FlutterGeolocator", "There is still another flutter engine connected, not stopping location service");
        } else {
            this.f3252e.o();
            this.f3252e.e();
        }
        p pVar = this.f3254g;
        if (pVar != null && (kVar = this.f3253f) != null) {
            kVar.f(pVar);
            this.f3254g = null;
        }
    }

    public void f(Activity activity) {
        if (!(activity != null || this.f3254g == null || this.f3249b == null)) {
            i();
        }
        this.f3251d = activity;
    }

    public void g(GeolocatorLocationService geolocatorLocationService) {
        this.f3252e = geolocatorLocationService;
    }

    /* access modifiers changed from: package-private */
    public void h(Context context, BinaryMessenger binaryMessenger) {
        if (this.f3249b != null) {
            Log.w("FlutterGeolocator", "Setting a event call handler before the last was disposed.");
            i();
        }
        EventChannel eventChannel = new EventChannel(binaryMessenger, "flutter.baseflow.com/geolocator_updates_android");
        this.f3249b = eventChannel;
        eventChannel.setStreamHandler(this);
        this.f3250c = context;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.f3249b == null) {
            Log.d("FlutterGeolocator", "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        c(false);
        this.f3249b.setStreamHandler((EventChannel.StreamHandler) null);
        this.f3249b = null;
    }

    public void onCancel(Object obj) {
        c(true);
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        d dVar = null;
        try {
            if (!this.f3248a.d(this.f3250c)) {
                m0.b bVar = m0.b.permissionDenied;
                eventSink.error(bVar.toString(), bVar.f(), (Object) null);
            } else if (this.f3252e == null) {
                Log.e("FlutterGeolocator", "Location background service has not started correctly");
            } else {
                Map map = (Map) obj;
                boolean z4 = false;
                if (!(map == null || map.get("forceLocationManager") == null)) {
                    z4 = ((Boolean) map.get("forceLocationManager")).booleanValue();
                }
                z e5 = z.e(map);
                if (map != null) {
                    dVar = d.g((Map) map.get("foregroundNotificationConfig"));
                }
                if (dVar != null) {
                    Log.e("FlutterGeolocator", "Geolocator position updates started using Android foreground service");
                    this.f3252e.n(z4, e5, eventSink);
                    this.f3252e.f(dVar);
                    return;
                }
                Log.e("FlutterGeolocator", "Geolocator position updates started");
                p a5 = this.f3253f.a(this.f3250c, Boolean.TRUE.equals(Boolean.valueOf(z4)), e5);
                this.f3254g = a5;
                this.f3253f.e(a5, this.f3251d, new k(eventSink), new l(eventSink));
            }
        } catch (c unused) {
            m0.b bVar2 = m0.b.permissionDefinitionsNotFound;
            eventSink.error(bVar2.toString(), bVar2.f(), (Object) null);
        }
    }
}
