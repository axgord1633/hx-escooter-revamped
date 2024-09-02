package com.signify.hue.flutterreactiveble.ble;

import r2.a;

public final /* synthetic */ class l implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceConnector f3913a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3914b;

    public /* synthetic */ l(DeviceConnector deviceConnector, String str) {
        this.f3913a = deviceConnector;
        this.f3914b = str;
    }

    public final void run() {
        DeviceConnector.m23disconnectDevice$lambda0(this.f3913a, this.f3914b);
    }
}
