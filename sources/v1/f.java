package v1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import m2.r;
import q1.l;
import r1.s;
import t1.i1;
import u1.b;

public class f extends s<byte[]> {

    /* renamed from: i  reason: collision with root package name */
    private final BluetoothGattDescriptor f7187i;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f7188j;

    /* renamed from: k  reason: collision with root package name */
    private final int f7189k;

    f(i1 i1Var, BluetoothGatt bluetoothGatt, x xVar, int i5, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        super(bluetoothGatt, i1Var, l.f6644i, xVar);
        this.f7189k = i5;
        this.f7187i = bluetoothGattDescriptor;
        this.f7188j = bArr;
    }

    /* access modifiers changed from: protected */
    public r<byte[]> l(i1 i1Var) {
        return i1Var.f().I(y1.f.b(this.f7187i)).L().v(y1.f.c());
    }

    /* access modifiers changed from: protected */
    public boolean m(BluetoothGatt bluetoothGatt) {
        this.f7187i.setValue(this.f7188j);
        BluetoothGattCharacteristic characteristic = this.f7187i.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(this.f7189k);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(this.f7187i);
        characteristic.setWriteType(writeType);
        return writeDescriptor;
    }

    public String toString() {
        return "DescriptorWriteOperation{" + super.toString() + ", descriptor=" + new b.a(this.f7187i.getUuid(), this.f7188j, true) + '}';
    }
}
