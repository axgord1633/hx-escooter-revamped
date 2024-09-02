package o3;

import kotlin.jvm.internal.k;
import o3.g;

public interface e extends g.b {

    /* renamed from: d  reason: collision with root package name */
    public static final b f6158d = b.f6159e;

    public static final class a {
        public static <E extends g.b> E a(e eVar, g.c<E> cVar) {
            k.e(cVar, "key");
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                if (!bVar.a(eVar.getKey())) {
                    return null;
                }
                E b5 = bVar.b(eVar);
                if (b5 instanceof g.b) {
                    return b5;
                }
                return null;
            } else if (e.f6158d != cVar) {
                return null;
            } else {
                k.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
        }

        public static g b(e eVar, g.c<?> cVar) {
            k.e(cVar, "key");
            if (!(cVar instanceof b)) {
                return e.f6158d == cVar ? h.f6161e : eVar;
            }
            b bVar = (b) cVar;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.f6161e;
        }
    }

    public static final class b implements g.c<e> {

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ b f6159e = new b();

        private b() {
        }
    }

    <T> d<T> C(d<? super T> dVar);

    void v(d<?> dVar);
}
