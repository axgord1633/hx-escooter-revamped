package com.signify.hue.flutterreactiveble.ble;

import r2.f;

public final /* synthetic */ class a0 implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ConnectionPriority f3880e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f3881f;

    public /* synthetic */ a0(ConnectionPriority connectionPriority, String str) {
        this.f3880e = connectionPriority;
        this.f3881f = str;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m49requestConnectionPriority$lambda24(this.f3880e, this.f3881f, (EstablishConnectionResult) obj);
    }
}
