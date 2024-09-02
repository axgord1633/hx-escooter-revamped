package com.signify.hue.flutterreactiveble.ble;

import java.util.List;
import r2.h;

public final /* synthetic */ class b implements h {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3882e;

    public /* synthetic */ b(String str) {
        this.f3882e = str;
    }

    public final boolean test(Object obj) {
        return DeviceConnector.m32waitUntilFirstOfQueue$lambda13(this.f3882e, (List) obj);
    }
}
