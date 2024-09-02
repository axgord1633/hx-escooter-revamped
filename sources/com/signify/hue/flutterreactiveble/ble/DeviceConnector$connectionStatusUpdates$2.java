package com.signify.hue.flutterreactiveble.ble;

import com.signify.hue.flutterreactiveble.model.ConnectionStateKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import p1.n0;
import p2.c;
import v3.a;

final class DeviceConnector$connectionStatusUpdates$2 extends l implements a<c> {
    final /* synthetic */ DeviceConnector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceConnector$connectionStatusUpdates$2(DeviceConnector deviceConnector) {
        super(0);
        this.this$0 = deviceConnector;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final ConnectionUpdate m33invoke$lambda0(DeviceConnector deviceConnector, n0.a aVar) {
        k.e(deviceConnector, "this$0");
        k.e(aVar, "it");
        String c5 = deviceConnector.device.c();
        k.d(c5, "device.macAddress");
        return new ConnectionUpdateSuccess(c5, ConnectionStateKt.toConnectionState(aVar).getCode());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final ConnectionUpdate m34invoke$lambda1(DeviceConnector deviceConnector, Throwable th) {
        k.e(deviceConnector, "this$0");
        k.e(th, "it");
        String c5 = deviceConnector.device.c();
        k.d(c5, "device.macAddress");
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        return new ConnectionUpdateError(c5, message);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m35invoke$lambda2(DeviceConnector deviceConnector, ConnectionUpdate connectionUpdate) {
        k.e(deviceConnector, "this$0");
        v3.l access$getUpdateListeners$p = deviceConnector.updateListeners;
        k.d(connectionUpdate, "it");
        access$getUpdateListeners$p.invoke(connectionUpdate);
    }

    public final c invoke() {
        return this.this$0.device.d().r0(this.this$0.device.getConnectionState()).Z(new n(this.this$0)).h0(new o(this.this$0)).s0(new p(this.this$0));
    }
}
