package com.signify.hue.flutterreactiveble.ble;

import java.util.UUID;
import r2.f;
import v3.q;

public final /* synthetic */ class i0 implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UUID f3902e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f3903f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f3904g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ q f3905h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ byte[] f3906i;

    public /* synthetic */ i0(UUID uuid, int i5, String str, q qVar, byte[] bArr) {
        this.f3902e = uuid;
        this.f3903f = i5;
        this.f3904g = str;
        this.f3905h = qVar;
        this.f3906i = bArr;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m39executeWriteOperation$lambda20(this.f3902e, this.f3903f, this.f3904g, this.f3905h, this.f3906i, (EstablishConnectionResult) obj);
    }
}
