package t1;

import g0.c;
import h0.a;
import p1.n0;

public final class m0 implements c<l0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<n0> f6968a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Integer> f6969b;

    public m0(a<n0> aVar, a<Integer> aVar2) {
        this.f6968a = aVar;
        this.f6969b = aVar2;
    }

    public static m0 a(a<n0> aVar, a<Integer> aVar2) {
        return new m0(aVar, aVar2);
    }

    public static l0 c(n0 n0Var, int i5) {
        return new l0(n0Var, i5);
    }

    /* renamed from: b */
    public l0 get() {
        return c(this.f6968a.get(), this.f6969b.get().intValue());
    }
}
