package t1;

import g0.c;
import h0.a;
import m2.q;

public final class j1 implements c<i1> {

    /* renamed from: a  reason: collision with root package name */
    private final a<q> f6938a;

    /* renamed from: b  reason: collision with root package name */
    private final a<a> f6939b;

    /* renamed from: c  reason: collision with root package name */
    private final a<y> f6940c;

    /* renamed from: d  reason: collision with root package name */
    private final a<q0> f6941d;

    public j1(a<q> aVar, a<a> aVar2, a<y> aVar3, a<q0> aVar4) {
        this.f6938a = aVar;
        this.f6939b = aVar2;
        this.f6940c = aVar3;
        this.f6941d = aVar4;
    }

    public static j1 a(a<q> aVar, a<a> aVar2, a<y> aVar3, a<q0> aVar4) {
        return new j1(aVar, aVar2, aVar3, aVar4);
    }

    public static i1 c(q qVar, a aVar, Object obj, Object obj2) {
        return new i1(qVar, aVar, (y) obj, (q0) obj2);
    }

    /* renamed from: b */
    public i1 get() {
        return c(this.f6938a.get(), this.f6939b.get(), this.f6940c.get(), this.f6941d.get());
    }
}
