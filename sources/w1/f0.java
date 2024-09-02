package w1;

import g0.c;
import h0.a;

public final class f0 implements c<e0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<y1.f0> f7499a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g> f7500b;

    /* renamed from: c  reason: collision with root package name */
    private final a<a0> f7501c;

    public f0(a<y1.f0> aVar, a<g> aVar2, a<a0> aVar3) {
        this.f7499a = aVar;
        this.f7500b = aVar2;
        this.f7501c = aVar3;
    }

    public static f0 a(a<y1.f0> aVar, a<g> aVar2, a<a0> aVar3) {
        return new f0(aVar, aVar2, aVar3);
    }

    public static e0 c(y1.f0 f0Var, g gVar, a0 a0Var) {
        return new e0(f0Var, gVar, a0Var);
    }

    /* renamed from: b */
    public e0 get() {
        return c(this.f7499a.get(), this.f7500b.get(), this.f7501c.get());
    }
}
