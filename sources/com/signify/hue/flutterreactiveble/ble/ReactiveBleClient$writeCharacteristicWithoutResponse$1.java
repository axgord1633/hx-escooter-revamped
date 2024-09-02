package com.signify.hue.flutterreactiveble.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import com.signify.hue.flutterreactiveble.ble.extensions.RxBleConnectionExtensionKt;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import m2.r;
import p1.n0;
import v3.q;

/* synthetic */ class ReactiveBleClient$writeCharacteristicWithoutResponse$1 extends j implements q<n0, BluetoothGattCharacteristic, byte[], r<byte[]>> {
    public static final ReactiveBleClient$writeCharacteristicWithoutResponse$1 INSTANCE = new ReactiveBleClient$writeCharacteristicWithoutResponse$1();

    ReactiveBleClient$writeCharacteristicWithoutResponse$1() {
        super(3, RxBleConnectionExtensionKt.class, "writeCharWithoutResponse", "writeCharWithoutResponse(Lcom/polidea/rxandroidble2/RxBleConnection;Landroid/bluetooth/BluetoothGattCharacteristic;[B)Lio/reactivex/Single;", 1);
    }

    public final r<byte[]> invoke(n0 n0Var, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        k.e(n0Var, "p0");
        k.e(bluetoothGattCharacteristic, "p1");
        k.e(bArr, "p2");
        return RxBleConnectionExtensionKt.writeCharWithoutResponse(n0Var, bluetoothGattCharacteristic, bArr);
    }
}
