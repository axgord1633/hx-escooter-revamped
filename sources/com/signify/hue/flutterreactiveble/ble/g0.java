package com.signify.hue.flutterreactiveble.ble;

import r2.e;

public final /* synthetic */ class g0 implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3896e;

    public /* synthetic */ g0(String str) {
        this.f3896e = str;
    }

    public final void accept(Object obj) {
        ReactiveBleClient.m36connectToDevice$lambda4(this.f3896e, (EstablishConnectionResult) obj);
    }
}
