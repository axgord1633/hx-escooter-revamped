package com.baseflow.geolocator;

import android.location.Location;
import io.flutter.plugin.common.MethodChannel;
import n0.g0;
import n0.p;

public final /* synthetic */ class h implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f3229a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean[] f3230b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f3231c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3232d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f3233e;

    public /* synthetic */ h(j jVar, boolean[] zArr, p pVar, String str, MethodChannel.Result result) {
        this.f3229a = jVar;
        this.f3230b = zArr;
        this.f3231c = pVar;
        this.f3232d = str;
        this.f3233e = result;
    }

    public final void a(Location location) {
        this.f3229a.j(this.f3230b, this.f3231c, this.f3232d, this.f3233e, location);
    }
}
