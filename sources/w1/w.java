package w1;

import g0.c;
import h0.a;
import m2.q;

public final class w implements c<v> {

    /* renamed from: a  reason: collision with root package name */
    private final a<t> f7540a;

    /* renamed from: b  reason: collision with root package name */
    private final a<q> f7541b;

    public w(a<t> aVar, a<q> aVar2) {
        this.f7540a = aVar;
        this.f7541b = aVar2;
    }

    public static w a(a<t> aVar, a<q> aVar2) {
        return new w(aVar, aVar2);
    }

    public static v c(t tVar, q qVar) {
        return new v(tVar, qVar);
    }

    /* renamed from: b */
    public v get() {
        return c(this.f7540a.get(), this.f7541b.get());
    }
}
