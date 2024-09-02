package v1;

import android.bluetooth.BluetoothGatt;
import g0.c;
import h0.a;
import m2.q;
import t1.i1;

public final class m implements c<l> {

    /* renamed from: a  reason: collision with root package name */
    private final a<i1> f7221a;

    /* renamed from: b  reason: collision with root package name */
    private final a<BluetoothGatt> f7222b;

    /* renamed from: c  reason: collision with root package name */
    private final a<u1.c> f7223c;

    /* renamed from: d  reason: collision with root package name */
    private final a<x> f7224d;

    /* renamed from: e  reason: collision with root package name */
    private final a<q> f7225e;

    /* renamed from: f  reason: collision with root package name */
    private final a<q> f7226f;

    /* renamed from: g  reason: collision with root package name */
    private final a<n> f7227g;

    public m(a<i1> aVar, a<BluetoothGatt> aVar2, a<u1.c> aVar3, a<x> aVar4, a<q> aVar5, a<q> aVar6, a<n> aVar7) {
        this.f7221a = aVar;
        this.f7222b = aVar2;
        this.f7223c = aVar3;
        this.f7224d = aVar4;
        this.f7225e = aVar5;
        this.f7226f = aVar6;
        this.f7227g = aVar7;
    }

    public static m a(a<i1> aVar, a<BluetoothGatt> aVar2, a<u1.c> aVar3, a<x> aVar4, a<q> aVar5, a<q> aVar6, a<n> aVar7) {
        return new m(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static l c(i1 i1Var, BluetoothGatt bluetoothGatt, u1.c cVar, x xVar, q qVar, q qVar2, a<n> aVar) {
        return new l(i1Var, bluetoothGatt, cVar, xVar, qVar, qVar2, aVar);
    }

    /* renamed from: b */
    public l get() {
        return c(this.f7221a.get(), this.f7222b.get(), this.f7223c.get(), this.f7224d.get(), this.f7225e.get(), this.f7226f.get(), this.f7227g);
    }
}
