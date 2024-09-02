package t1;

import g0.c;
import h0.a;
import v1.g;

public final class x implements c<w> {

    /* renamed from: a  reason: collision with root package name */
    private final a<x1.a> f7012a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g> f7013b;

    public x(a<x1.a> aVar, a<g> aVar2) {
        this.f7012a = aVar;
        this.f7013b = aVar2;
    }

    public static x a(a<x1.a> aVar, a<g> aVar2) {
        return new x(aVar, aVar2);
    }

    public static w c(x1.a aVar, g gVar) {
        return new w(aVar, gVar);
    }

    /* renamed from: b */
    public w get() {
        return c(this.f7012a.get(), this.f7013b.get());
    }
}
