package com.signify.hue.flutterreactiveble.ble;

import r2.f;

public final /* synthetic */ class x implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3923e;

    public /* synthetic */ x(String str) {
        this.f3923e = str;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m41executeWriteOperation$lambda20$lambda19$lambda18(this.f3923e, (byte[]) obj);
    }
}
