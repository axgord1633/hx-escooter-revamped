package q1;

import android.bluetooth.BluetoothGattCharacteristic;

public class c extends f {

    /* renamed from: e  reason: collision with root package name */
    private final BluetoothGattCharacteristic f6626e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6627f;

    public c(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5, Throwable th) {
        super(a(bluetoothGattCharacteristic, i5), th);
        this.f6626e = bluetoothGattCharacteristic;
        this.f6627f = i5;
    }

    private static String a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i5) {
        return b(i5) + " (code " + i5 + ") with characteristic UUID " + bluetoothGattCharacteristic.getUuid();
    }

    private static String b(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? "Unknown error" : "Cannot write client characteristic config descriptor" : "Cannot find client characteristic config descriptor" : "Cannot set local notification";
    }
}
