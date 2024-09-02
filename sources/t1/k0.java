package t1;

import g0.c;
import h0.a;
import p1.n0;
import v1.k;
import x1.d;

public final class k0 implements c<j0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<d> f6945a;

    /* renamed from: b  reason: collision with root package name */
    private final a<l0> f6946b;

    /* renamed from: c  reason: collision with root package name */
    private final a<n0> f6947c;

    /* renamed from: d  reason: collision with root package name */
    private final a<k> f6948d;

    public k0(a<d> aVar, a<l0> aVar2, a<n0> aVar3, a<k> aVar4) {
        this.f6945a = aVar;
        this.f6946b = aVar2;
        this.f6947c = aVar3;
        this.f6948d = aVar4;
    }

    public static k0 a(a<d> aVar, a<l0> aVar2, a<n0> aVar3, a<k> aVar4) {
        return new k0(aVar, aVar2, aVar3, aVar4);
    }

    public static j0 c(d dVar, Object obj, n0 n0Var, k kVar) {
        return new j0(dVar, (l0) obj, n0Var, kVar);
    }

    /* renamed from: b */
    public j0 get() {
        return c(this.f6945a.get(), this.f6946b.get(), this.f6947c.get(), this.f6948d.get());
    }
}
