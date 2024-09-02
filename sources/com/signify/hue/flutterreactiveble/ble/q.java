package com.signify.hue.flutterreactiveble.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import r2.f;

public final /* synthetic */ class q implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EstablishConnectionResult f3919e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f3920f;

    public /* synthetic */ q(EstablishConnectionResult establishConnectionResult, String str) {
        this.f3919e = establishConnectionResult;
        this.f3920f = str;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m46readCharacteristic$lambda11$lambda10(this.f3919e, this.f3920f, (BluetoothGattCharacteristic) obj);
    }
}
