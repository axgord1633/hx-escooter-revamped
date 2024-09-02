package o3;

import kotlin.jvm.internal.k;
import o3.g;
import o3.g.b;
import v3.l;

public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* renamed from: e  reason: collision with root package name */
    private final l<g.b, E> f6153e;

    /* renamed from: f  reason: collision with root package name */
    private final g.c<?> f6154f;

    public b(g.c<B> cVar, l<? super g.b, ? extends E> lVar) {
        k.e(cVar, "baseKey");
        k.e(lVar, "safeCast");
        this.f6153e = lVar;
        this.f6154f = cVar instanceof b ? ((b) cVar).f6154f : cVar;
    }

    public final boolean a(g.c<?> cVar) {
        k.e(cVar, "key");
        return cVar == this || this.f6154f == cVar;
    }

    public final E b(g.b bVar) {
        k.e(bVar, "element");
        return (g.b) this.f6153e.invoke(bVar);
    }
}
