package com.signify.hue.flutterreactiveble.channelhandlers;

import io.flutter.plugin.common.EventChannel;
import r2.e;

public final /* synthetic */ class c implements e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f3933e;

    public /* synthetic */ c(EventChannel.EventSink eventSink) {
        this.f3933e = eventSink;
    }

    public final void accept(Object obj) {
        BleStatusHandler.m59listenToBleStatus$lambda2(this.f3933e, (Throwable) obj);
    }
}
