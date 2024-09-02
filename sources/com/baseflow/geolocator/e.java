package com.baseflow.geolocator;

import io.flutter.plugin.common.MethodChannel;
import m0.a;
import m0.b;

public final /* synthetic */ class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3226a;

    public /* synthetic */ e(MethodChannel.Result result) {
        this.f3226a = result;
    }

    public final void a(b bVar) {
        this.f3226a.error(bVar.toString(), bVar.f(), (Object) null);
    }
}
