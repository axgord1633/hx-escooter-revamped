package com.signify.hue.flutterreactiveble.ble;

import r2.f;

public final /* synthetic */ class v implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3921e;

    public /* synthetic */ v(String str) {
        this.f3921e = str;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m48readCharacteristic$lambda11$lambda10$lambda9(this.f3921e, (byte[]) obj);
    }
}
