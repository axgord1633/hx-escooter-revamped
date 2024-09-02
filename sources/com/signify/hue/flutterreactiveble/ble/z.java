package com.signify.hue.flutterreactiveble.ble;

import java.util.UUID;
import r2.f;

public final /* synthetic */ class z implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UUID f3926e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f3927f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f3928g;

    public /* synthetic */ z(UUID uuid, int i5, String str) {
        this.f3926e = uuid;
        this.f3927f = i5;
        this.f3928g = str;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m45readCharacteristic$lambda11(this.f3926e, this.f3927f, this.f3928g, (EstablishConnectionResult) obj);
    }
}
