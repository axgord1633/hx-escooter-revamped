package com.signify.hue.flutterreactiveble.ble;

import java.util.UUID;
import r2.f;

public final /* synthetic */ class e0 implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ReactiveBleClient f3888e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ UUID f3889f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f3890g;

    public /* synthetic */ e0(ReactiveBleClient reactiveBleClient, UUID uuid, int i5) {
        this.f3888e = reactiveBleClient;
        this.f3889f = uuid;
        this.f3890g = i5;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m53setupNotification$lambda12(this.f3888e, this.f3889f, this.f3890g, (EstablishConnectionResult) obj);
    }
}
