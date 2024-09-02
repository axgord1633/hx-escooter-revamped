package com.signify.hue.flutterreactiveble.ble.extensions;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import b2.a;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.k;
import m2.r;
import m2.v;
import p1.n0;
import p1.q0;

public final class RxBleConnectionExtensionKt {
    public static final r<BluetoothGattCharacteristic> resolveCharacteristic(n0 n0Var, UUID uuid, int i5) {
        k.e(n0Var, "<this>");
        k.e(uuid, "uuid");
        r<R> r5 = n0Var.d().r(new a(uuid, i5));
        k.d(r5, "discoverServices().flatM…    }.single())\n        }");
        return r5;
    }

    /* access modifiers changed from: private */
    /* renamed from: resolveCharacteristic$lambda-2  reason: not valid java name */
    public static final v m56resolveCharacteristic$lambda2(UUID uuid, int i5, q0 q0Var) {
        k.e(uuid, "$uuid");
        k.e(q0Var, "services");
        List<BluetoothGattService> a5 = q0Var.a();
        k.d(a5, "services.bluetoothGattServices");
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattService characteristics : a5) {
            List<BluetoothGattCharacteristic> characteristics2 = characteristics.getCharacteristics();
            k.d(characteristics2, "service.characteristics");
            ArrayList arrayList2 = new ArrayList();
            for (T next : characteristics2) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) next;
                if (k.a(bluetoothGattCharacteristic.getUuid(), uuid) && bluetoothGattCharacteristic.getInstanceId() == i5) {
                    arrayList2.add(next);
                }
            }
            boolean unused = s.j(arrayList, arrayList2);
        }
        return r.u(v.s(arrayList));
    }

    public static final r<byte[]> writeCharWithResponse(n0 n0Var, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        k.e(n0Var, "<this>");
        k.e(bluetoothGattCharacteristic, "characteristic");
        k.e(bArr, "value");
        bluetoothGattCharacteristic.setWriteType(2);
        r<byte[]> f5 = n0Var.f(bluetoothGattCharacteristic, bArr);
        k.d(f5, "writeCharacteristic(characteristic, value)");
        return f5;
    }

    public static final r<byte[]> writeCharWithoutResponse(n0 n0Var, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        k.e(n0Var, "<this>");
        k.e(bluetoothGattCharacteristic, "characteristic");
        k.e(bArr, "value");
        bluetoothGattCharacteristic.setWriteType(1);
        r<byte[]> f5 = n0Var.f(bluetoothGattCharacteristic, bArr);
        k.d(f5, "writeCharacteristic(characteristic, value)");
        return f5;
    }
}
