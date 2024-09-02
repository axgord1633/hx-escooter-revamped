package t1;

import g0.c;
import h0.a;

public final class p0 implements c<o0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<i1> f6978a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Integer> f6979b;

    public p0(a<i1> aVar, a<Integer> aVar2) {
        this.f6978a = aVar;
        this.f6979b = aVar2;
    }

    public static p0 a(a<i1> aVar, a<Integer> aVar2) {
        return new p0(aVar, aVar2);
    }

    public static o0 c(i1 i1Var, int i5) {
        return new o0(i1Var, i5);
    }

    /* renamed from: b */
    public o0 get() {
        return c(this.f6978a.get(), this.f6979b.get().intValue());
    }
}
