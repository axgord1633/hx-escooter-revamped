package com.baseflow.geolocator;

import android.location.Location;
import io.flutter.plugin.common.EventChannel;
import n0.g0;
import n0.y;

public final /* synthetic */ class k implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f3246a;

    public /* synthetic */ k(EventChannel.EventSink eventSink) {
        this.f3246a = eventSink;
    }

    public final void a(Location location) {
        this.f3246a.success(y.b(location));
    }
}
