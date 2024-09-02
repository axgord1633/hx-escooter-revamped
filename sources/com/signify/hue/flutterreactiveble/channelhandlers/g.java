package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ble.ScanInfo;
import r2.e;

public final /* synthetic */ class g implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ScanDevicesHandler f3939e;

    public /* synthetic */ g(ScanDevicesHandler scanDevicesHandler) {
        this.f3939e = scanDevicesHandler;
    }

    public final void accept(Object obj) {
        ScanDevicesHandler.m63startDeviceScan$lambda3$lambda1(this.f3939e, (ScanInfo) obj);
    }
}
