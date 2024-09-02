package com.signify.hue.flutterreactiveble.ble;

import java.util.List;
import r2.h;

public final /* synthetic */ class m implements h {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3915e;

    public /* synthetic */ m(String str) {
        this.f3915e = str;
    }

    public final boolean test(Object obj) {
        return DeviceConnector.m31waitUntilFirstOfQueue$lambda12(this.f3915e, (List) obj);
    }
}
