package com.signify.hue.flutterreactiveble.ble;

import r2.f;

public final /* synthetic */ class y implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f3924e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f3925f;

    public /* synthetic */ y(int i5, String str) {
        this.f3924e = i5;
        this.f3925f = str;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m42negotiateMtuSize$lambda15(this.f3924e, this.f3925f, (EstablishConnectionResult) obj);
    }
}
