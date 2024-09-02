package kotlinx.coroutines.internal;

import c4.b2;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import o3.g;
import v3.p;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f5592a = new b0("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final p<Object, g.b, Object> f5593b = a.f5596e;

    /* renamed from: c  reason: collision with root package name */
    private static final p<b2<?>, g.b, b2<?>> f5594c = b.f5597e;

    /* renamed from: d  reason: collision with root package name */
    private static final p<i0, g.b, i0> f5595d = c.f5598e;

    static final class a extends l implements p<Object, g.b, Object> {

        /* renamed from: e  reason: collision with root package name */
        public static final a f5596e = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Object invoke(Object obj, g.b bVar) {
            if (!(bVar instanceof b2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    static final class b extends l implements p<b2<?>, g.b, b2<?>> {

        /* renamed from: e  reason: collision with root package name */
        public static final b f5597e = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final b2<?> invoke(b2<?> b2Var, g.b bVar) {
            if (b2Var != null) {
                return b2Var;
            }
            if (bVar instanceof b2) {
                return (b2) bVar;
            }
            return null;
        }
    }

    static final class c extends l implements p<i0, g.b, i0> {

        /* renamed from: e  reason: collision with root package name */
        public static final c f5598e = new c();

        c() {
            super(2);
        }

        /* renamed from: a */
        public final i0 invoke(i0 i0Var, g.b bVar) {
            if (bVar instanceof b2) {
                b2 b2Var = (b2) bVar;
                i0Var.a(b2Var, b2Var.E(i0Var.f5604a));
            }
            return i0Var;
        }
    }

    public static final void a(g gVar, Object obj) {
        if (obj != f5592a) {
            if (obj instanceof i0) {
                ((i0) obj).b(gVar);
                return;
            }
            Object q5 = gVar.q(null, f5594c);
            if (q5 != null) {
                ((b2) q5).g(gVar, obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }

    public static final Object b(g gVar) {
        Object q5 = gVar.q(0, f5593b);
        k.b(q5);
        return q5;
    }

    public static final Object c(g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        return obj == 0 ? f5592a : obj instanceof Integer ? gVar.q(new i0(gVar, ((Number) obj).intValue()), f5595d) : ((b2) obj).E(gVar);
    }
}
