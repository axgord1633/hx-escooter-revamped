package w1;

import g0.c;
import h0.a;
import y1.h0;

public final class h implements c<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<h0> f7508a;

    /* renamed from: b  reason: collision with root package name */
    private final a<k> f7509b;

    public h(a<h0> aVar, a<k> aVar2) {
        this.f7508a = aVar;
        this.f7509b = aVar2;
    }

    public static h a(a<h0> aVar, a<k> aVar2) {
        return new h(aVar, aVar2);
    }

    public static g c(h0 h0Var, k kVar) {
        return new g(h0Var, kVar);
    }

    /* renamed from: b */
    public g get() {
        return c(this.f7508a.get(), this.f7509b.get());
    }
}
