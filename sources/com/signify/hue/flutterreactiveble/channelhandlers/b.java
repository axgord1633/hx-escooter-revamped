package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ble.BleStatus;
import io.flutter.plugin.common.EventChannel;
import r2.e;

public final /* synthetic */ class b implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f3932e;

    public /* synthetic */ b(EventChannel.EventSink eventSink) {
        this.f3932e = eventSink;
    }

    public final void accept(Object obj) {
        BleStatusHandler.m58listenToBleStatus$lambda1(this.f3932e, (BleStatus) obj);
    }
}
