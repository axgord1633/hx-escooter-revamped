package c4;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.internal.f;
import kotlinx.coroutines.internal.k;
import o3.b;
import o3.d;
import o3.e;
import o3.g;

public abstract class c0 extends o3.a implements e {

    /* renamed from: f  reason: collision with root package name */
    public static final a f3106f = new a((g) null);

    public static final class a extends b<e, c0> {

        /* renamed from: c4.c0$a$a  reason: collision with other inner class name */
        static final class C0059a extends l implements v3.l<g.b, c0> {

            /* renamed from: e  reason: collision with root package name */
            public static final C0059a f3107e = new C0059a();

            C0059a() {
                super(1);
            }

            /* renamed from: a */
            public final c0 invoke(g.b bVar) {
                if (bVar instanceof c0) {
                    return (c0) bVar;
                }
                return null;
            }
        }

        private a() {
            super(e.f6158d, C0059a.f3107e);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public c0() {
        super(e.f6158d);
    }

    public final <T> d<T> C(d<? super T> dVar) {
        return new f(this, dVar);
    }

    public abstract void M(o3.g gVar, Runnable runnable);

    public boolean N(o3.g gVar) {
        return true;
    }

    public c0 O(int i5) {
        kotlinx.coroutines.internal.l.a(i5);
        return new k(this, i5);
    }

    public <E extends g.b> E d(g.c<E> cVar) {
        return e.a.a(this, cVar);
    }

    public o3.g h(g.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this);
    }

    public final void v(d<?> dVar) {
        ((f) dVar).r();
    }
}
