package com.signify.hue.flutterreactiveble.channelhandlers;

import r2.f;

public final /* synthetic */ class a implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BleStatusHandler f3931e;

    public /* synthetic */ a(BleStatusHandler bleStatusHandler) {
        this.f3931e = bleStatusHandler;
    }

    public final Object apply(Object obj) {
        return BleStatusHandler.m57listenToBleStatus$lambda0(this.f3931e, (Long) obj);
    }
}
