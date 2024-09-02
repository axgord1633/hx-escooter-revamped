package o3;

import kotlin.jvm.internal.k;
import o3.g;
import v3.p;

public abstract class a implements g.b {

    /* renamed from: e  reason: collision with root package name */
    private final g.c<?> f6152e;

    public a(g.c<?> cVar) {
        k.e(cVar, "key");
        this.f6152e = cVar;
    }

    public <E extends g.b> E d(g.c<E> cVar) {
        return g.b.a.b(this, cVar);
    }

    public g.c<?> getKey() {
        return this.f6152e;
    }

    public g h(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    public g n(g gVar) {
        return g.b.a.d(this, gVar);
    }

    public <R> R q(R r5, p<? super R, ? super g.b, ? extends R> pVar) {
        return g.b.a.a(this, r5, pVar);
    }
}
