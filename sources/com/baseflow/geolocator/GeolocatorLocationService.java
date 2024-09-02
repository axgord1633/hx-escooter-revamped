package com.baseflow.geolocator;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import io.flutter.plugin.common.EventChannel;
import n0.b;
import n0.d;
import n0.k;
import n0.p;
import n0.z;

public class GeolocatorLocationService extends Service {

    /* renamed from: e  reason: collision with root package name */
    private final String f3196e = "GeolocatorLocationService:Wakelock";

    /* renamed from: f  reason: collision with root package name */
    private final String f3197f = "GeolocatorLocationService:WifiLock";

    /* renamed from: g  reason: collision with root package name */
    private final a f3198g = new a(this);

    /* renamed from: h  reason: collision with root package name */
    private boolean f3199h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f3200i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f3201j = 0;

    /* renamed from: k  reason: collision with root package name */
    private Activity f3202k = null;

    /* renamed from: l  reason: collision with root package name */
    private k f3203l = null;

    /* renamed from: m  reason: collision with root package name */
    private p f3204m;

    /* renamed from: n  reason: collision with root package name */
    private PowerManager.WakeLock f3205n = null;

    /* renamed from: o  reason: collision with root package name */
    private WifiManager.WifiLock f3206o = null;

    /* renamed from: p  reason: collision with root package name */
    private b f3207p = null;

    class a extends Binder {

        /* renamed from: b  reason: collision with root package name */
        private final GeolocatorLocationService f3208b;

        a(GeolocatorLocationService geolocatorLocationService) {
            this.f3208b = geolocatorLocationService;
        }

        public GeolocatorLocationService a() {
            return this.f3208b;
        }
    }

    private void k(d dVar) {
        WifiManager wifiManager;
        PowerManager powerManager;
        l();
        if (dVar.d() && (powerManager = (PowerManager) getApplicationContext().getSystemService("power")) != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "GeolocatorLocationService:Wakelock");
            this.f3205n = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            this.f3205n.acquire();
        }
        if (dVar.e() && (wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi")) != null) {
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "GeolocatorLocationService:WifiLock");
            this.f3206o = createWifiLock;
            createWifiLock.setReferenceCounted(false);
            this.f3206o.acquire();
        }
    }

    private void l() {
        PowerManager.WakeLock wakeLock = this.f3205n;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f3205n.release();
            this.f3205n = null;
        }
        WifiManager.WifiLock wifiLock = this.f3206o;
        if (wifiLock != null && wifiLock.isHeld()) {
            this.f3206o.release();
            this.f3206o = null;
        }
    }

    public boolean c(boolean z4) {
        return z4 ? this.f3201j == 1 : this.f3200i == 0;
    }

    public void d(d dVar) {
        b bVar = this.f3207p;
        if (bVar != null) {
            bVar.f(dVar, this.f3199h);
            k(dVar);
        }
    }

    public void e() {
        if (this.f3199h) {
            Log.d("FlutterGeolocator", "Stop service in foreground.");
            if (Build.VERSION.SDK_INT >= 24) {
                stopForeground(1);
            } else {
                stopForeground(true);
            }
            l();
            this.f3199h = false;
            this.f3207p = null;
        }
    }

    public void f(d dVar) {
        if (this.f3207p != null) {
            Log.d("FlutterGeolocator", "Service already in foreground mode.");
            d(dVar);
        } else {
            Log.d("FlutterGeolocator", "Start service in foreground mode.");
            b bVar = new b(getApplicationContext(), "geolocator_channel_01", 75415, dVar);
            this.f3207p = bVar;
            bVar.d("Background Location");
            startForeground(75415, this.f3207p.a());
            this.f3199h = true;
        }
        k(dVar);
    }

    public void g() {
        this.f3200i++;
        Log.d("FlutterGeolocator", "Flutter engine connected. Connected engine count " + this.f3200i);
    }

    public void h() {
        this.f3200i--;
        Log.d("FlutterGeolocator", "Flutter engine disconnected. Connected engine count " + this.f3200i);
    }

    public void m(Activity activity) {
        this.f3202k = activity;
    }

    public void n(boolean z4, z zVar, EventChannel.EventSink eventSink) {
        this.f3201j++;
        k kVar = this.f3203l;
        if (kVar != null) {
            p a5 = kVar.a(getApplicationContext(), Boolean.TRUE.equals(Boolean.valueOf(z4)), zVar);
            this.f3204m = a5;
            this.f3203l.e(a5, this.f3202k, new l0.a(eventSink), new l0.b(eventSink));
        }
    }

    public void o() {
        k kVar;
        this.f3201j--;
        Log.d("FlutterGeolocator", "Stopping location service.");
        p pVar = this.f3204m;
        if (pVar != null && (kVar = this.f3203l) != null) {
            kVar.f(pVar);
        }
    }

    public IBinder onBind(Intent intent) {
        Log.d("FlutterGeolocator", "Binding to location service.");
        return this.f3198g;
    }

    public void onCreate() {
        super.onCreate();
        Log.d("FlutterGeolocator", "Creating service.");
        this.f3203l = new k();
    }

    public void onDestroy() {
        Log.d("FlutterGeolocator", "Destroying location service.");
        o();
        e();
        this.f3203l = null;
        this.f3207p = null;
        Log.d("FlutterGeolocator", "Destroyed location service.");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i5, int i6) {
        return 1;
    }

    public boolean onUnbind(Intent intent) {
        Log.d("FlutterGeolocator", "Unbinding from location service.");
        return super.onUnbind(intent);
    }
}
