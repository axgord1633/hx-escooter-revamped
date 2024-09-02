package q1;

import a2.a;
import android.bluetooth.BluetoothGatt;
import u1.b;

public class k extends f {

    /* renamed from: e  reason: collision with root package name */
    private final BluetoothGatt f6634e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6635f;

    /* renamed from: g  reason: collision with root package name */
    private final l f6636g;

    public k(BluetoothGatt bluetoothGatt, int i5, l lVar) {
        super(a(bluetoothGatt, i5, lVar));
        this.f6634e = bluetoothGatt;
        this.f6635f = i5;
        this.f6636g = lVar;
    }

    public k(BluetoothGatt bluetoothGatt, l lVar) {
        this(bluetoothGatt, -1, lVar);
    }

    private static String a(BluetoothGatt bluetoothGatt, int i5, l lVar) {
        if (i5 == -1) {
            return String.format("GATT exception from MAC address %s, with type %s", new Object[]{c(bluetoothGatt), lVar});
        }
        return String.format("GATT exception from %s, status %d (%s), type %s. (Look up status 0x%02x here %s)", new Object[]{b.c(bluetoothGatt), Integer.valueOf(i5), a.a(i5), lVar, Integer.valueOf(i5), "https://cs.android.com/android/platform/superproject/+/master:packages/modules/Bluetooth/system/stack/include/gatt_api.h"});
    }

    private static String c(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null || bluetoothGatt.getDevice() == null) {
            return null;
        }
        return bluetoothGatt.getDevice().getAddress();
    }

    public l b() {
        return this.f6636g;
    }
}
