package com.signify.hue.flutterreactiveble.ble;

import r2.e;

public final /* synthetic */ class j implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DeviceConnector f3907e;

    public /* synthetic */ j(DeviceConnector deviceConnector) {
        this.f3907e = deviceConnector;
    }

    public final void accept(Object obj) {
        DeviceConnector.m29establishConnection$lambda6(this.f3907e, (EstablishConnectionResult) obj);
    }
}
