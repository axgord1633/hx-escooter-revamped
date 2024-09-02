package v1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import m2.r;
import q1.l;
import r1.s;
import t1.i1;
import u1.b;
import y1.f;

public class b extends s<byte[]> {

    /* renamed from: i  reason: collision with root package name */
    private final BluetoothGattCharacteristic f7169i;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f7170j;

    b(i1 i1Var, BluetoothGatt bluetoothGatt, x xVar, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        super(bluetoothGatt, i1Var, l.f6640e, xVar);
        this.f7169i = bluetoothGattCharacteristic;
        this.f7170j = bArr;
    }

    /* access modifiers changed from: protected */
    public r<byte[]> l(i1 i1Var) {
        return i1Var.d().I(f.a(this.f7169i.getUuid())).L().v(f.c());
    }

    /* access modifiers changed from: protected */
    public boolean m(BluetoothGatt bluetoothGatt) {
        this.f7169i.setValue(this.f7170j);
        return bluetoothGatt.writeCharacteristic(this.f7169i);
    }

    public String toString() {
        return "CharacteristicWriteOperation{" + super.toString() + ", characteristic=" + new b.a(this.f7169i.getUuid(), this.f7170j, true) + '}';
    }
}
