package o3;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import o3.e;
import v3.p;

public interface g {

    public static final class a {

        /* renamed from: o3.g$a$a  reason: collision with other inner class name */
        static final class C0096a extends l implements p<g, b, g> {

            /* renamed from: e  reason: collision with root package name */
            public static final C0096a f6160e = new C0096a();

            C0096a() {
                super(2);
            }

            /* renamed from: a */
            public final g invoke(g gVar, b bVar) {
                c cVar;
                k.e(gVar, "acc");
                k.e(bVar, "element");
                g h5 = gVar.h(bVar.getKey());
                h hVar = h.f6161e;
                if (h5 == hVar) {
                    return bVar;
                }
                e.b bVar2 = e.f6158d;
                e eVar = (e) h5.d(bVar2);
                if (eVar == null) {
                    cVar = new c(h5, bVar);
                } else {
                    g h6 = h5.h(bVar2);
                    if (h6 == hVar) {
                        return new c(bVar, eVar);
                    }
                    cVar = new c(new c(h6, bVar), eVar);
                }
                return cVar;
            }
        }

        public static g a(g gVar, g gVar2) {
            k.e(gVar2, "context");
            return gVar2 == h.f6161e ? gVar : (g) gVar2.q(gVar, C0096a.f6160e);
        }
    }

    public interface b extends g {

        public static final class a {
            public static <R> R a(b bVar, R r5, p<? super R, ? super b, ? extends R> pVar) {
                k.e(pVar, "operation");
                return pVar.invoke(r5, bVar);
            }

            public static <E extends b> E b(b bVar, c<E> cVar) {
                k.e(cVar, "key");
                if (!k.a(bVar.getKey(), cVar)) {
                    return null;
                }
                k.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static g c(b bVar, c<?> cVar) {
                k.e(cVar, "key");
                return k.a(bVar.getKey(), cVar) ? h.f6161e : bVar;
            }

            public static g d(b bVar, g gVar) {
                k.e(gVar, "context");
                return a.a(bVar, gVar);
            }
        }

        <E extends b> E d(c<E> cVar);

        c<?> getKey();
    }

    public interface c<E extends b> {
    }

    <E extends b> E d(c<E> cVar);

    g h(c<?> cVar);

    g n(g gVar);

    <R> R q(R r5, p<? super R, ? super b, ? extends R> pVar);
}
