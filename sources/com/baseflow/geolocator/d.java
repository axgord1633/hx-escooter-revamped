package com.baseflow.geolocator;

import io.flutter.plugin.common.MethodChannel;
import m0.a;
import m0.b;

public final /* synthetic */ class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3225a;

    public /* synthetic */ d(MethodChannel.Result result) {
        this.f3225a = result;
    }

    public final void a(b bVar) {
        this.f3225a.error(bVar.toString(), bVar.f(), (Object) null);
    }
}
