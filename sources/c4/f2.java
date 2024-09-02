package c4;

import o3.g;
import v3.p;

final class f2 implements g.b, g.c<f2> {

    /* renamed from: e  reason: collision with root package name */
    public static final f2 f3121e = new f2();

    private f2() {
    }

    public <E extends g.b> E d(g.c<E> cVar) {
        return g.b.a.b(this, cVar);
    }

    public g.c<?> getKey() {
        return this;
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
