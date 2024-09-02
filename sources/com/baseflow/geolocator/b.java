package com.baseflow.geolocator;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import n0.b0;

public class b implements EventChannel.StreamHandler {

    /* renamed from: a  reason: collision with root package name */
    private EventChannel f3221a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3222b;

    /* renamed from: c  reason: collision with root package name */
    private b0 f3223c;

    private void a() {
        b0 b0Var;
        Context context = this.f3222b;
        if (context != null && (b0Var = this.f3223c) != null) {
            context.unregisterReceiver(b0Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        this.f3222b = context;
    }

    /* access modifiers changed from: package-private */
    public void c(Context context, BinaryMessenger binaryMessenger) {
        if (this.f3221a != null) {
            Log.w("LocationServiceHandler", "Setting a event call handler before the last was disposed.");
            d();
        }
        EventChannel eventChannel = new EventChannel(binaryMessenger, "flutter.baseflow.com/geolocator_service_updates_android");
        this.f3221a = eventChannel;
        eventChannel.setStreamHandler(this);
        this.f3222b = context;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f3221a != null) {
            a();
            this.f3221a.setStreamHandler((EventChannel.StreamHandler) null);
            this.f3221a = null;
        }
    }

    public void onCancel(Object obj) {
        a();
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        if (this.f3222b != null) {
            IntentFilter intentFilter = new IntentFilter("android.location.PROVIDERS_CHANGED");
            intentFilter.addAction("android.intent.action.PROVIDER_CHANGED");
            b0 b0Var = new b0(eventSink);
            this.f3223c = b0Var;
            this.f3222b.registerReceiver(b0Var, intentFilter);
        }
    }
}
