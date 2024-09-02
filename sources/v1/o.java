package v1;

import android.bluetooth.BluetoothGatt;
import g0.c;
import h0.a;
import t1.i1;

public final class o implements c<n> {

    /* renamed from: a  reason: collision with root package name */
    private final a<i1> f7228a;

    /* renamed from: b  reason: collision with root package name */
    private final a<BluetoothGatt> f7229b;

    /* renamed from: c  reason: collision with root package name */
    private final a<x> f7230c;

    public o(a<i1> aVar, a<BluetoothGatt> aVar2, a<x> aVar3) {
        this.f7228a = aVar;
        this.f7229b = aVar2;
        this.f7230c = aVar3;
    }

    public static o a(a<i1> aVar, a<BluetoothGatt> aVar2, a<x> aVar3) {
        return new o(aVar, aVar2, aVar3);
    }

    public static n c(i1 i1Var, BluetoothGatt bluetoothGatt, x xVar) {
        return new n(i1Var, bluetoothGatt, xVar);
    }

    /* renamed from: b */
    public n get() {
        return c(this.f7228a.get(), this.f7229b.get(), this.f7230c.get());
    }
}
