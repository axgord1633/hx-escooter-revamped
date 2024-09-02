package com.signify.hue.flutterreactiveble.ble;

import kotlin.jvm.internal.l;
import v3.a;

final class DeviceConnector$lazyConnection$1 extends l implements a<l3.a<EstablishConnectionResult>> {
    final /* synthetic */ DeviceConnector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceConnector$lazyConnection$1(DeviceConnector deviceConnector) {
        super(0);
        this.this$0 = deviceConnector;
    }

    public final l3.a<EstablishConnectionResult> invoke() {
        DeviceConnector deviceConnector = this.this$0;
        deviceConnector.setConnectionDisposable$reactive_ble_mobile_release(deviceConnector.establishConnection(deviceConnector.device));
        return this.this$0.connectDeviceSubject;
    }
}
