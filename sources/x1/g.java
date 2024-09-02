package x1;

import java.util.concurrent.atomic.AtomicLong;
import m2.l;
import m2.p;
import m2.q;
import p2.c;
import u1.b;
import v1.j;

class g<T> implements Comparable<g> {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLong f7613h = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private final long f7614e = f7613h.getAndIncrement();

    /* renamed from: f  reason: collision with root package name */
    final j<T> f7615f;

    /* renamed from: g  reason: collision with root package name */
    final l<T> f7616g;

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ j f7617e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ q f7618f;

        /* renamed from: x1.g$a$a  reason: collision with other inner class name */
        class C0123a implements p<T> {
            C0123a() {
            }

            public void a() {
                g.this.f7616g.a();
            }

            public void c(c cVar) {
                g.this.f7616g.c(cVar);
            }

            public void d(T t5) {
                g.this.f7616g.d(t5);
            }

            public void onError(Throwable th) {
                g.this.f7616g.e(th);
            }
        }

        a(j jVar, q qVar) {
            this.f7617e = jVar;
            this.f7618f = qVar;
        }

        public void run() {
            g.this.f7615f.h(this.f7617e).K0(this.f7618f).g(new C0123a());
        }
    }

    g(j<T> jVar, l<T> lVar) {
        this.f7615f = jVar;
        this.f7616g = lVar;
    }

    /* renamed from: c */
    public int compareTo(g gVar) {
        int compareTo = this.f7615f.compareTo(gVar.f7615f);
        if (compareTo != 0 || gVar.f7615f == this.f7615f) {
            return compareTo;
        }
        return this.f7614e < gVar.f7614e ? -1 : 1;
    }

    public void f(j jVar, q qVar) {
        if (this.f7616g.f()) {
            b.r(this.f7615f);
            jVar.release();
            return;
        }
        qVar.c(new a(jVar, qVar));
    }
}
