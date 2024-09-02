package com.signify.hue.flutterreactiveble.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import r2.f;

public final /* synthetic */ class b0 implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EstablishConnectionResult f3883e;

    public /* synthetic */ b0(EstablishConnectionResult establishConnectionResult) {
        this.f3883e = establishConnectionResult;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m55setupNotificationOrIndication$lambda21(this.f3883e, (BluetoothGattCharacteristic) obj);
    }
}
