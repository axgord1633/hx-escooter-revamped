package v1;

import android.bluetooth.BluetoothManager;
import g0.c;
import h0.a;
import m2.q;
import t1.i1;
import t1.l;

public final class h implements c<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<i1> f7206a;

    /* renamed from: b  reason: collision with root package name */
    private final a<t1.a> f7207b;

    /* renamed from: c  reason: collision with root package name */
    private final a<String> f7208c;

    /* renamed from: d  reason: collision with root package name */
    private final a<BluetoothManager> f7209d;

    /* renamed from: e  reason: collision with root package name */
    private final a<q> f7210e;

    /* renamed from: f  reason: collision with root package name */
    private final a<x> f7211f;

    /* renamed from: g  reason: collision with root package name */
    private final a<l> f7212g;

    public h(a<i1> aVar, a<t1.a> aVar2, a<String> aVar3, a<BluetoothManager> aVar4, a<q> aVar5, a<x> aVar6, a<l> aVar7) {
        this.f7206a = aVar;
        this.f7207b = aVar2;
        this.f7208c = aVar3;
        this.f7209d = aVar4;
        this.f7210e = aVar5;
        this.f7211f = aVar6;
        this.f7212g = aVar7;
    }

    public static h a(a<i1> aVar, a<t1.a> aVar2, a<String> aVar3, a<BluetoothManager> aVar4, a<q> aVar5, a<x> aVar6, a<l> aVar7) {
        return new h(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static g c(i1 i1Var, t1.a aVar, String str, BluetoothManager bluetoothManager, q qVar, x xVar, l lVar) {
        return new g(i1Var, aVar, str, bluetoothManager, qVar, xVar, lVar);
    }

    /* renamed from: b */
    public g get() {
        return c(this.f7206a.get(), this.f7207b.get(), this.f7208c.get(), this.f7209d.get(), this.f7210e.get(), this.f7211f.get(), this.f7212g.get());
    }
}
