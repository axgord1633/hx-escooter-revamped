package t1;

import g0.c;
import h0.a;
import m2.q;
import t1.c;

public final class t implements c<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<x1.a> f6989a;

    /* renamed from: b  reason: collision with root package name */
    private final a<c.a> f6990b;

    /* renamed from: c  reason: collision with root package name */
    private final a<q> f6991c;

    public t(a<x1.a> aVar, a<c.a> aVar2, a<q> aVar3) {
        this.f6989a = aVar;
        this.f6990b = aVar2;
        this.f6991c = aVar3;
    }

    public static t a(a<x1.a> aVar, a<c.a> aVar2, a<q> aVar3) {
        return new t(aVar, aVar2, aVar3);
    }

    public static s c(x1.a aVar, c.a aVar2, q qVar) {
        return new s(aVar, aVar2, qVar);
    }

    /* renamed from: b */
    public s get() {
        return c(this.f6989a.get(), this.f6990b.get(), this.f6991c.get());
    }
}
