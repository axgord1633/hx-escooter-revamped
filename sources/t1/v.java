package t1;

import g0.c;
import h0.a;
import v1.k;
import x1.d;

public final class v implements c<u> {

    /* renamed from: a  reason: collision with root package name */
    private final a<d> f6999a;

    /* renamed from: b  reason: collision with root package name */
    private final a<k> f7000b;

    public v(a<d> aVar, a<k> aVar2) {
        this.f6999a = aVar;
        this.f7000b = aVar2;
    }

    public static v a(a<d> aVar, a<k> aVar2) {
        return new v(aVar, aVar2);
    }

    public static u c(d dVar, k kVar) {
        return new u(dVar, kVar);
    }

    /* renamed from: b */
    public u get() {
        return c(this.f6999a.get(), this.f7000b.get());
    }
}
