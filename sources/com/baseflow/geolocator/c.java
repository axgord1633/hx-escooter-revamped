package com.baseflow.geolocator;

import android.location.Location;
import io.flutter.plugin.common.MethodChannel;
import n0.g0;
import n0.y;

public final /* synthetic */ class c implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3224a;

    public /* synthetic */ c(MethodChannel.Result result) {
        this.f3224a = result;
    }

    public final void a(Location location) {
        this.f3224a.success(y.b(location));
    }
}
