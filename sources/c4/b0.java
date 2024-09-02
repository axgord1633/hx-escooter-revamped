package c4;

import kotlin.jvm.internal.l;
import kotlin.jvm.internal.q;
import o3.d;
import o3.e;
import o3.g;
import o3.h;
import v3.p;

public final class b0 {

    static final class a extends l implements p<g, g.b, g> {

        /* renamed from: e  reason: collision with root package name */
        public static final a f3102e = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final g invoke(g gVar, g.b bVar) {
            return bVar instanceof a0 ? gVar.n(((a0) bVar).m()) : gVar.n(bVar);
        }
    }

    static final class b extends l implements p<g, g.b, g> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ q<g> f3103e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f3104f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(q<g> qVar, boolean z4) {
            super(2);
            this.f3103e = qVar;
            this.f3104f = z4;
        }

        /* renamed from: a */
        public final g invoke(g gVar, g.b bVar) {
            if (!(bVar instanceof a0)) {
                return gVar.n(bVar);
            }
            g.b d5 = ((g) this.f3103e.f5571e).d(bVar.getKey());
            if (d5 == null) {
                a0 a0Var = (a0) bVar;
                if (this.f3104f) {
                    a0Var = a0Var.m();
                }
                return gVar.n(a0Var);
            }
            q<g> qVar = this.f3103e;
            qVar.f5571e = ((g) qVar.f5571e).h(bVar.getKey());
            return gVar.n(((a0) bVar).D(d5));
        }
    }

    static final class c extends l implements p<Boolean, g.b, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public static final c f3105e = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z4, g.b bVar) {
            return Boolean.valueOf(z4 || (bVar instanceof a0));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (g.b) obj2);
        }
    }

    private static final g a(g gVar, g gVar2, boolean z4) {
        boolean c5 = c(gVar);
        boolean c6 = c(gVar2);
        if (!c5 && !c6) {
            return gVar.n(gVar2);
        }
        q qVar = new q();
        qVar.f5571e = gVar2;
        h hVar = h.f6161e;
        g gVar3 = (g) gVar.q(hVar, new b(qVar, z4));
        if (c6) {
            qVar.f5571e = ((g) qVar.f5571e).q(hVar, a.f3102e);
        }
        return gVar3.n((g) qVar.f5571e);
    }

    public static final String b(g gVar) {
        return null;
    }

    private static final boolean c(g gVar) {
        return ((Boolean) gVar.q(Boolean.FALSE, c.f3105e)).booleanValue();
    }

    public static final g d(g0 g0Var, g gVar) {
        g a5 = a(g0Var.i(), gVar, true);
        return (a5 == t0.a() || a5.d(e.f6158d) != null) ? a5 : a5.n(t0.a());
    }

    public static final e2<?> e(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof p0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof e2) {
                return (e2) eVar;
            }
        }
        return null;
    }

    public static final e2<?> f(d<?> dVar, g gVar, Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.e)) {
            return null;
        }
        if (!(gVar.d(f2.f3121e) != null)) {
            return null;
        }
        e2<?> e5 = e((kotlin.coroutines.jvm.internal.e) dVar);
        if (e5 != null) {
            e5.F0(gVar, obj);
        }
        return e5;
    }
}
