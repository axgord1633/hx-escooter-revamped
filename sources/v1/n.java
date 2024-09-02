package v1;

import android.bluetooth.BluetoothGatt;
import m2.r;
import q1.l;
import r1.s;
import t1.i1;

public class n extends s<Integer> {
    n(i1 i1Var, BluetoothGatt bluetoothGatt, x xVar) {
        super(bluetoothGatt, i1Var, l.f6646k, xVar);
    }

    /* access modifiers changed from: protected */
    public r<Integer> l(i1 i1Var) {
        return i1Var.h().L();
    }

    /* access modifiers changed from: protected */
    public boolean m(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readRemoteRssi();
    }

    public String toString() {
        return "ReadRssiOperation{" + super.toString() + '}';
    }
}
