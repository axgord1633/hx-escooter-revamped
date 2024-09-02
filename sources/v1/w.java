package v1;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.TimeUnit;
import m2.q;
import m2.r;
import m2.v;
import p1.q0;
import q1.g;
import q1.l;
import r1.s;
import t1.i1;
import u1.c;

public class w extends s<q0> {

    /* renamed from: i  reason: collision with root package name */
    final BluetoothGatt f7250i;

    /* renamed from: j  reason: collision with root package name */
    final c f7251j;

    w(i1 i1Var, BluetoothGatt bluetoothGatt, c cVar, x xVar) {
        super(bluetoothGatt, i1Var, l.f6638c, xVar);
        this.f7250i = bluetoothGatt;
        this.f7251j = cVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(q0 q0Var) {
        this.f7251j.m(q0Var, this.f7250i.getDevice());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ q0 t(BluetoothGatt bluetoothGatt) {
        return new q0(bluetoothGatt.getServices());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ v v(BluetoothGatt bluetoothGatt, q qVar) {
        return bluetoothGatt.getServices().size() == 0 ? r.o(new g(bluetoothGatt, l.f6638c)) : r.I(5, TimeUnit.SECONDS, qVar).r(new u(bluetoothGatt));
    }

    /* access modifiers changed from: protected */
    public r<q0> l(i1 i1Var) {
        return i1Var.i().L().n(new s(this));
    }

    /* access modifiers changed from: protected */
    public boolean m(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.discoverServices();
    }

    /* access modifiers changed from: protected */
    public r<q0> n(BluetoothGatt bluetoothGatt, i1 i1Var, q qVar) {
        return r.i(new t(bluetoothGatt, qVar));
    }

    public String toString() {
        return "ServiceDiscoveryOperation{" + super.toString() + '}';
    }
}
