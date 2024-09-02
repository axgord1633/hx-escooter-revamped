package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.BleClient;
import com.signify.hue.flutterreactiveble.ble.BleStatus;
import io.flutter.plugin.common.EventChannel;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m2.n;
import o2.a;
import p2.c;

public final class BleStatusHandler implements EventChannel.StreamHandler {
    public static final Companion Companion = new Companion((g) null);
    private static final long delayListenBleStatus = 500;
    private final BleClient bleClient;
    private final p2.g subscriptionDisposable = new p2.g();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public BleStatusHandler(BleClient bleClient2) {
        k.e(bleClient2, "bleClient");
        this.bleClient = bleClient2;
    }

    private final c listenToBleStatus(EventChannel.EventSink eventSink) {
        c t02 = m2.k.I0(delayListenBleStatus, TimeUnit.MILLISECONDS).y0(new a(this)).f0(a.a()).t0(new b(eventSink), new c(eventSink));
        k.d(t02, "timer(delayListenBleStat…l)\n                    })");
        return t02;
    }

    /* access modifiers changed from: private */
    /* renamed from: listenToBleStatus$lambda-0  reason: not valid java name */
    public static final n m57listenToBleStatus$lambda0(BleStatusHandler bleStatusHandler, Long l5) {
        k.e(bleStatusHandler, "this$0");
        k.e(l5, "it");
        return bleStatusHandler.bleClient.observeBleStatus();
    }

    /* access modifiers changed from: private */
    /* renamed from: listenToBleStatus$lambda-1  reason: not valid java name */
    public static final void m58listenToBleStatus$lambda1(EventChannel.EventSink eventSink, BleStatus bleStatus) {
        k.e(eventSink, "$eventSink");
        eventSink.success(((ProtobufModel.BleStatusInfo) ProtobufModel.BleStatusInfo.newBuilder().setStatus(bleStatus.getCode()).build()).toByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: listenToBleStatus$lambda-2  reason: not valid java name */
    public static final void m59listenToBleStatus$lambda2(EventChannel.EventSink eventSink, Throwable th) {
        k.e(eventSink, "$eventSink");
        eventSink.error("ObserveBleStatusFailure", th.getMessage(), (Object) null);
    }

    public void onCancel(Object obj) {
        this.subscriptionDisposable.a((c) null);
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.subscriptionDisposable.a(eventSink != null ? listenToBleStatus(eventSink) : null);
    }
}
