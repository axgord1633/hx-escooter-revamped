package y1;

import g0.c;
import h0.a;
import m2.k;
import m2.q;
import p1.e0;

public final class s implements c<r> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f0> f7778a;

    /* renamed from: b  reason: collision with root package name */
    private final a<k<e0.b>> f7779b;

    /* renamed from: c  reason: collision with root package name */
    private final a<k<Boolean>> f7780c;

    /* renamed from: d  reason: collision with root package name */
    private final a<w> f7781d;

    /* renamed from: e  reason: collision with root package name */
    private final a<q> f7782e;

    public s(a<f0> aVar, a<k<e0.b>> aVar2, a<k<Boolean>> aVar3, a<w> aVar4, a<q> aVar5) {
        this.f7778a = aVar;
        this.f7779b = aVar2;
        this.f7780c = aVar3;
        this.f7781d = aVar4;
        this.f7782e = aVar5;
    }

    public static s a(a<f0> aVar, a<k<e0.b>> aVar2, a<k<Boolean>> aVar3, a<w> aVar4, a<q> aVar5) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static r c(f0 f0Var, k<e0.b> kVar, k<Boolean> kVar2, w wVar, q qVar) {
        return new r(f0Var, kVar, kVar2, wVar, qVar);
    }

    /* renamed from: b */
    public r get() {
        return c(this.f7778a.get(), this.f7779b.get(), this.f7780c.get(), this.f7781d.get(), this.f7782e.get());
    }
}
