package com.baseflow.geolocator;

import io.flutter.plugin.common.EventChannel;
import m0.a;
import m0.b;

public final /* synthetic */ class l implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f3247a;

    public /* synthetic */ l(EventChannel.EventSink eventSink) {
        this.f3247a = eventSink;
    }

    public final void a(b bVar) {
        this.f3247a.error(bVar.toString(), bVar.f(), (Object) null);
    }
}
