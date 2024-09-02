package v1;

import android.bluetooth.BluetoothGatt;
import m2.r;
import q1.l;
import r1.s;
import t1.i1;

public class e extends s<Long> {

    /* renamed from: i  reason: collision with root package name */
    private final int f7185i;

    /* renamed from: j  reason: collision with root package name */
    private final x f7186j;

    e(i1 i1Var, BluetoothGatt bluetoothGatt, x xVar, int i5, x xVar2) {
        super(bluetoothGatt, i1Var, l.f6648m, xVar);
        this.f7185i = i5;
        this.f7186j = xVar2;
    }

    private static String o(int i5) {
        return i5 != 0 ? i5 != 2 ? "CONNECTION_PRIORITY_HIGH" : "CONNECTION_PRIORITY_LOW_POWER" : "CONNECTION_PRIORITY_BALANCED";
    }

    /* access modifiers changed from: protected */
    public r<Long> l(i1 i1Var) {
        x xVar = this.f7186j;
        return r.I(xVar.f7252a, xVar.f7253b, xVar.f7254c);
    }

    /* access modifiers changed from: protected */
    public boolean m(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.requestConnectionPriority(this.f7185i);
    }

    public String toString() {
        return "ConnectionPriorityChangeOperation{" + super.toString() + ", connectionPriority=" + o(this.f7185i) + ", successTimeout=" + this.f7186j + '}';
    }
}
