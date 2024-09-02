package x1;

import m2.k;
import m2.l;
import m2.m;
import m2.q;
import p2.d;
import v1.j;

public class b implements a {

    /* renamed from: e  reason: collision with root package name */
    final h f7586e = new h();

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ q f7587e;

        a(q qVar) {
            this.f7587e = qVar;
        }

        public void run() {
            while (true) {
                try {
                    g<?> d5 = b.this.f7586e.d();
                    j<T> jVar = d5.f7615f;
                    long currentTimeMillis = System.currentTimeMillis();
                    u1.b.s(jVar);
                    u1.b.q(jVar);
                    j jVar2 = new j();
                    d5.f(jVar2, this.f7587e);
                    jVar2.a();
                    u1.b.n(jVar, currentTimeMillis, System.currentTimeMillis());
                } catch (InterruptedException e5) {
                    r1.q.e(e5, "Error while processing client operation queue", new Object[0]);
                }
            }
        }
    }

    /* renamed from: x1.b$b  reason: collision with other inner class name */
    class C0122b implements m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f7589a;

        /* renamed from: x1.b$b$a */
        class a implements r2.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f7591a;

            a(g gVar) {
                this.f7591a = gVar;
            }

            public void run() {
                if (b.this.f7586e.c(this.f7591a)) {
                    u1.b.p(C0122b.this.f7589a);
                }
            }
        }

        C0122b(j jVar) {
            this.f7589a = jVar;
        }

        public void a(l<T> lVar) {
            g gVar = new g(this.f7589a, lVar);
            lVar.c(d.c(new a(gVar)));
            u1.b.o(this.f7589a);
            b.this.f7586e.a(gVar);
        }
    }

    public b(q qVar) {
        new Thread(new a(qVar)).start();
    }

    public <T> k<T> a(j<T> jVar) {
        return k.m(new C0122b(jVar));
    }
}
