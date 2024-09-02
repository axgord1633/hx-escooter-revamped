package v1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import m2.r;
import q1.l;
import r1.s;
import t1.i1;
import u1.b;
import y1.f;

public class a extends s<byte[]> {

    /* renamed from: i  reason: collision with root package name */
    private final BluetoothGattCharacteristic f7168i;

    a(i1 i1Var, BluetoothGatt bluetoothGatt, x xVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGatt, i1Var, l.f6639d, xVar);
        this.f7168i = bluetoothGattCharacteristic;
    }

    /* access modifiers changed from: protected */
    public r<byte[]> l(i1 i1Var) {
        return i1Var.c().I(f.a(this.f7168i.getUuid())).L().v(f.c());
    }

    /* access modifiers changed from: protected */
    public boolean m(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readCharacteristic(this.f7168i);
    }

    public String toString() {
        return "CharacteristicReadOperation{" + super.toString() + ", characteristic=" + b.t(this.f7168i, false) + '}';
    }
}
