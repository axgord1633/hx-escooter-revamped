package kotlinx.coroutines.internal;

import c4.f0;
import kotlin.jvm.internal.l;
import m3.q;
import o3.g;

public final class v {

    static final class a extends l implements v3.l<Throwable, q> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ v3.l<E, q> f5636e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ E f5637f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ g f5638g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(v3.l<? super E, q> lVar, E e5, g gVar) {
            super(1);
            this.f5636e = lVar;
            this.f5637f = e5;
            this.f5638g = gVar;
        }

        public final void a(Throwable th) {
            v.b(this.f5636e, this.f5637f, this.f5638g);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return q.f5904a;
        }
    }

    public static final <E> v3.l<Throwable, q> a(v3.l<? super E, q> lVar, E e5, g gVar) {
        return new a(lVar, e5, gVar);
    }

    public static final <E> void b(v3.l<? super E, q> lVar, E e5, g gVar) {
        j0 c5 = c(lVar, e5, (j0) null);
        if (c5 != null) {
            f0.a(gVar, c5);
        }
    }

    public static final <E> j0 c(v3.l<? super E, q> lVar, E e5, j0 j0Var) {
        try {
            lVar.invoke(e5);
        } catch (Throwable th) {
            if (j0Var == null || j0Var.getCause() == th) {
                return new j0("Exception in undelivered element handler for " + e5, th);
            }
            b.a(j0Var, th);
        }
        return j0Var;
    }

    public static /* synthetic */ j0 d(v3.l lVar, Object obj, j0 j0Var, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            j0Var = null;
        }
        return c(lVar, obj, j0Var);
    }
}
