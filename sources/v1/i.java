package v1;

import android.bluetooth.BluetoothGatt;
import m2.r;
import q1.l;
import r1.s;
import t1.i1;

public class i extends s<Integer> {

    /* renamed from: i  reason: collision with root package name */
    private final int f7213i;

    i(i1 i1Var, BluetoothGatt bluetoothGatt, x xVar, int i5) {
        super(bluetoothGatt, i1Var, l.f6647l, xVar);
        this.f7213i = i5;
    }

    /* access modifiers changed from: protected */
    public r<Integer> l(i1 i1Var) {
        return i1Var.g().L();
    }

    /* access modifiers changed from: protected */
    public boolean m(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.requestMtu(this.f7213i);
    }

    public String toString() {
        return "MtuRequestOperation{" + super.toString() + ", mtu=" + this.f7213i + '}';
    }
}
