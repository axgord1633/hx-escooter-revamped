package com.signify.hue.flutterreactiveble.ble;

import r2.e;

public final /* synthetic */ class p implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DeviceConnector f3918e;

    public /* synthetic */ p(DeviceConnector deviceConnector) {
        this.f3918e = deviceConnector;
    }

    public final void accept(Object obj) {
        DeviceConnector$connectionStatusUpdates$2.m35invoke$lambda2(this.f3918e, (ConnectionUpdate) obj);
    }
}
