package e4;

import c4.e;
import c4.k;
import c4.k0;
import c4.l;
import c4.m;
import c4.n;
import kotlin.coroutines.jvm.internal.h;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.v;
import m3.k;
import m3.q;

public abstract class a<E> extends c<E> implements f<E> {

    /* renamed from: e4.a$a  reason: collision with other inner class name */
    private static final class C0075a<E> implements g<E> {

        /* renamed from: a  reason: collision with root package name */
        public final a<E> f4505a;

        /* renamed from: b  reason: collision with root package name */
        private Object f4506b = b.f4515d;

        public C0075a(a<E> aVar) {
            this.f4505a = aVar;
        }

        private final boolean b(Object obj) {
            if (!(obj instanceof j)) {
                return true;
            }
            j jVar = (j) obj;
            if (jVar.f4538h == null) {
                return false;
            }
            throw a0.a(jVar.C());
        }

        private final Object c(o3.d<? super Boolean> dVar) {
            Object obj;
            l a5 = n.a(c.b(dVar));
            b bVar = new b(this, a5);
            while (true) {
                if (this.f4505a.p(bVar)) {
                    this.f4505a.w(a5, bVar);
                    break;
                }
                Object v5 = this.f4505a.v();
                d(v5);
                if (v5 instanceof j) {
                    j jVar = (j) v5;
                    if (jVar.f4538h == null) {
                        k.a aVar = k.f5898e;
                        obj = kotlin.coroutines.jvm.internal.b.a(false);
                    } else {
                        k.a aVar2 = k.f5898e;
                        obj = m3.l.a(jVar.C());
                    }
                    a5.resumeWith(k.a(obj));
                } else if (v5 != b.f4515d) {
                    Boolean a6 = kotlin.coroutines.jvm.internal.b.a(true);
                    v3.l<E, q> lVar = this.f4505a.f4519b;
                    a5.f(a6, lVar != null ? v.a(lVar, v5, a5.getContext()) : null);
                }
            }
            Object w4 = a5.w();
            if (w4 == d.c()) {
                h.c(dVar);
            }
            return w4;
        }

        public Object a(o3.d<? super Boolean> dVar) {
            Object obj = this.f4506b;
            b0 b0Var = b.f4515d;
            if (obj == b0Var) {
                obj = this.f4505a.v();
                this.f4506b = obj;
                if (obj == b0Var) {
                    return c(dVar);
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(b(obj));
        }

        public final void d(Object obj) {
            this.f4506b = obj;
        }

        public E next() {
            E e5 = this.f4506b;
            if (!(e5 instanceof j)) {
                E e6 = b.f4515d;
                if (e5 != e6) {
                    this.f4506b = e6;
                    return e5;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw a0.a(((j) e5).C());
        }
    }

    private static class b<E> extends o<E> {

        /* renamed from: h  reason: collision with root package name */
        public final C0075a<E> f4507h;

        /* renamed from: i  reason: collision with root package name */
        public final c4.k<Boolean> f4508i;

        public b(C0075a<E> aVar, c4.k<? super Boolean> kVar) {
            this.f4507h = aVar;
            this.f4508i = kVar;
        }

        public void a(E e5) {
            this.f4507h.d(e5);
            this.f4508i.p(m.f3144a);
        }

        public b0 d(E e5, o.b bVar) {
            if (this.f4508i.k(Boolean.TRUE, (Object) null, y(e5)) == null) {
                return null;
            }
            return m.f3144a;
        }

        public String toString() {
            return "ReceiveHasNext@" + k0.b(this);
        }

        public void x(j<?> jVar) {
            Object a5 = jVar.f4538h == null ? k.a.a(this.f4508i, Boolean.FALSE, (Object) null, 2, (Object) null) : this.f4508i.o(jVar.C());
            if (a5 != null) {
                this.f4507h.d(jVar);
                this.f4508i.p(a5);
            }
        }

        public v3.l<Throwable, q> y(E e5) {
            v3.l<E, q> lVar = this.f4507h.f4505a.f4519b;
            if (lVar != null) {
                return v.a(lVar, e5, this.f4508i.getContext());
            }
            return null;
        }
    }

    private final class c extends e {

        /* renamed from: e  reason: collision with root package name */
        private final o<?> f4509e;

        public c(o<?> oVar) {
            this.f4509e = oVar;
        }

        public void a(Throwable th) {
            if (this.f4509e.s()) {
                a.this.t();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return q.f5904a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f4509e + ']';
        }
    }

    public static final class d extends o.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f4511d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(o oVar, a aVar) {
            super(oVar);
            this.f4511d = aVar;
        }

        /* renamed from: i */
        public Object g(o oVar) {
            if (this.f4511d.s()) {
                return null;
            }
            return kotlinx.coroutines.internal.n.a();
        }
    }

    public a(v3.l<? super E, q> lVar) {
        super(lVar);
    }

    /* access modifiers changed from: private */
    public final boolean p(o<? super E> oVar) {
        boolean q5 = q(oVar);
        if (q5) {
            u();
        }
        return q5;
    }

    /* access modifiers changed from: private */
    public final void w(c4.k<?> kVar, o<?> oVar) {
        kVar.c(new c(oVar));
    }

    public final g<E> iterator() {
        return new C0075a(this);
    }

    /* access modifiers changed from: protected */
    public q<E> l() {
        q<E> l5 = super.l();
        if (l5 != null && !(l5 instanceof j)) {
            t();
        }
        return l5;
    }

    /* access modifiers changed from: protected */
    public boolean q(o<? super E> oVar) {
        int v5;
        o o5;
        if (r()) {
            kotlinx.coroutines.internal.m e5 = e();
            do {
                o5 = e5.o();
                if (!(!(o5 instanceof s))) {
                    return false;
                }
            } while (!o5.h(oVar, e5));
        } else {
            kotlinx.coroutines.internal.m e6 = e();
            d dVar = new d(oVar, this);
            do {
                o o6 = e6.o();
                if (!(!(o6 instanceof s))) {
                    return false;
                }
                v5 = o6.v(oVar, e6, dVar);
                if (v5 != 1) {
                }
            } while (v5 != 2);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract boolean r();

    /* access modifiers changed from: protected */
    public abstract boolean s();

    /* access modifiers changed from: protected */
    public void t() {
    }

    /* access modifiers changed from: protected */
    public void u() {
    }

    /* access modifiers changed from: protected */
    public Object v() {
        while (true) {
            s m5 = m();
            if (m5 == null) {
                return b.f4515d;
            }
            if (m5.y((o.b) null) != null) {
                m5.w();
                return m5.x();
            }
            m5.z();
        }
    }
}
