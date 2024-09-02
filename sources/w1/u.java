package w1;

import g0.c;
import h0.a;
import y1.f0;
import y1.w;

public final class u implements c<t> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f0> f7534a;

    /* renamed from: b  reason: collision with root package name */
    private final a<w> f7535b;

    public u(a<f0> aVar, a<w> aVar2) {
        this.f7534a = aVar;
        this.f7535b = aVar2;
    }

    public static u a(a<f0> aVar, a<w> aVar2) {
        return new u(aVar, aVar2);
    }

    public static t c(f0 f0Var, w wVar) {
        return new t(f0Var, wVar);
    }

    /* renamed from: b */
    public t get() {
        return c(this.f7534a.get(), this.f7535b.get());
    }
}
