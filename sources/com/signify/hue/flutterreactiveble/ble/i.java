package com.signify.hue.flutterreactiveble.ble;

import r2.e;

public final /* synthetic */ class i implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DeviceConnector f3900e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f3901f;

    public /* synthetic */ i(DeviceConnector deviceConnector, String str) {
        this.f3900e = deviceConnector;
        this.f3901f = str;
    }

    public final void accept(Object obj) {
        DeviceConnector.m28establishConnection$lambda5(this.f3900e, this.f3901f, (Throwable) obj);
    }
}
