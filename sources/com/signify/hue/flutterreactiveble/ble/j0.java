package com.signify.hue.flutterreactiveble.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import r2.f;
import v3.q;

public final /* synthetic */ class j0 implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ q f3908e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ EstablishConnectionResult f3909f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ byte[] f3910g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f3911h;

    public /* synthetic */ j0(q qVar, EstablishConnectionResult establishConnectionResult, byte[] bArr, String str) {
        this.f3908e = qVar;
        this.f3909f = establishConnectionResult;
        this.f3910g = bArr;
        this.f3911h = str;
    }

    public final Object apply(Object obj) {
        return ReactiveBleClient.m40executeWriteOperation$lambda20$lambda19(this.f3908e, this.f3909f, this.f3910g, this.f3911h, (BluetoothGattCharacteristic) obj);
    }
}
