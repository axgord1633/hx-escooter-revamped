package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ble.ConnectionUpdate;
import r2.e;

public final /* synthetic */ class f implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DeviceConnectionHandler f3938e;

    public /* synthetic */ f(DeviceConnectionHandler deviceConnectionHandler) {
        this.f3938e = deviceConnectionHandler;
    }

    public final void accept(Object obj) {
        DeviceConnectionHandler.m62listenToConnectionChanges$lambda1(this.f3938e, (ConnectionUpdate) obj);
    }
}
