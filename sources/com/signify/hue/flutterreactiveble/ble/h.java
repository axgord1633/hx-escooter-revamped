package com.signify.hue.flutterreactiveble.ble;

import r2.e;

public final /* synthetic */ class h implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DeviceConnector f3897e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f3898f;

    public /* synthetic */ h(DeviceConnector deviceConnector, String str) {
        this.f3897e = deviceConnector;
        this.f3898f = str;
    }

    public final void accept(Object obj) {
        DeviceConnector.m27establishConnection$lambda4(this.f3897e, this.f3898f, (EstablishConnectionResult) obj);
    }
}
