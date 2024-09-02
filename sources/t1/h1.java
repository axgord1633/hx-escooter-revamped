package t1;

import android.bluetooth.BluetoothGatt;
import g0.c;
import h0.a;
import m2.q;
import v1.k;
import x1.d;

public final class h1 implements c<g1> {

    /* renamed from: a  reason: collision with root package name */
    private final a<d> f6895a;

    /* renamed from: b  reason: collision with root package name */
    private final a<i1> f6896b;

    /* renamed from: c  reason: collision with root package name */
    private final a<BluetoothGatt> f6897c;

    /* renamed from: d  reason: collision with root package name */
    private final a<k1> f6898d;

    /* renamed from: e  reason: collision with root package name */
    private final a<d1> f6899e;

    /* renamed from: f  reason: collision with root package name */
    private final a<n0> f6900f;

    /* renamed from: g  reason: collision with root package name */
    private final a<u> f6901g;

    /* renamed from: h  reason: collision with root package name */
    private final a<k> f6902h;

    /* renamed from: i  reason: collision with root package name */
    private final a<Object> f6903i;

    /* renamed from: j  reason: collision with root package name */
    private final a<q> f6904j;

    /* renamed from: k  reason: collision with root package name */
    private final a<b0> f6905k;

    public h1(a<d> aVar, a<i1> aVar2, a<BluetoothGatt> aVar3, a<k1> aVar4, a<d1> aVar5, a<n0> aVar6, a<u> aVar7, a<k> aVar8, a<Object> aVar9, a<q> aVar10, a<b0> aVar11) {
        this.f6895a = aVar;
        this.f6896b = aVar2;
        this.f6897c = aVar3;
        this.f6898d = aVar4;
        this.f6899e = aVar5;
        this.f6900f = aVar6;
        this.f6901g = aVar7;
        this.f6902h = aVar8;
        this.f6903i = aVar9;
        this.f6904j = aVar10;
        this.f6905k = aVar11;
    }

    public static h1 a(a<d> aVar, a<i1> aVar2, a<BluetoothGatt> aVar3, a<k1> aVar4, a<d1> aVar5, a<n0> aVar6, a<u> aVar7, a<k> aVar8, a<Object> aVar9, a<q> aVar10, a<b0> aVar11) {
        return new h1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11);
    }

    public static g1 c(d dVar, i1 i1Var, BluetoothGatt bluetoothGatt, Object obj, Object obj2, Object obj3, Object obj4, k kVar, a<Object> aVar, q qVar, b0 b0Var) {
        return new g1(dVar, i1Var, bluetoothGatt, (k1) obj, (d1) obj2, (n0) obj3, (u) obj4, kVar, aVar, qVar, b0Var);
    }

    /* renamed from: b */
    public g1 get() {
        return c(this.f6895a.get(), this.f6896b.get(), this.f6897c.get(), this.f6898d.get(), this.f6899e.get(), this.f6900f.get(), this.f6901g.get(), this.f6902h.get(), this.f6903i, this.f6904j.get(), this.f6905k.get());
    }
}
