package x1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import m2.k;
import m2.l;
import m2.q;
import q1.f;
import r2.d;
import t1.m;
import t1.z;
import v1.j;

public class e implements d, m {

    /* renamed from: e  reason: collision with root package name */
    private final String f7594e;

    /* renamed from: f  reason: collision with root package name */
    private final z f7595f;

    /* renamed from: g  reason: collision with root package name */
    private i3.a<f> f7596g;

    /* renamed from: h  reason: collision with root package name */
    final h f7597h = new h();

    /* renamed from: i  reason: collision with root package name */
    private final Future<?> f7598i;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f7599j = true;

    /* renamed from: k  reason: collision with root package name */
    private f f7600k = null;

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ q f7601e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f7602f;

        a(q qVar, String str) {
            this.f7601e = qVar;
            this.f7602f = str;
        }

        public void run() {
            while (true) {
                if (!e.this.f7599j) {
                    break;
                }
                try {
                    g<?> d5 = e.this.f7597h.d();
                    j<T> jVar = d5.f7615f;
                    long currentTimeMillis = System.currentTimeMillis();
                    u1.b.s(jVar);
                    u1.b.q(jVar);
                    j jVar2 = new j();
                    d5.f(jVar2, this.f7601e);
                    jVar2.a();
                    u1.b.n(jVar, currentTimeMillis, System.currentTimeMillis());
                } catch (InterruptedException e5) {
                    synchronized (e.this) {
                        if (!e.this.f7599j) {
                            break;
                        }
                        r1.q.e(e5, "Error while processing connection operation queue", new Object[0]);
                    }
                }
            }
            e.this.d();
            r1.q.p("Terminated (%s)", u1.b.d(this.f7602f));
        }
    }

    class b implements m2.m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f7604a;

        class a implements d {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ g f7606e;

            a(g gVar) {
                this.f7606e = gVar;
            }

            public void cancel() {
                if (e.this.f7597h.c(this.f7606e)) {
                    u1.b.p(b.this.f7604a);
                }
            }
        }

        b(j jVar) {
            this.f7604a = jVar;
        }

        public void a(l<T> lVar) {
            g gVar = new g(this.f7604a, lVar);
            lVar.g(new a(gVar));
            u1.b.o(this.f7604a);
            e.this.f7597h.a(gVar);
        }
    }

    class c extends i3.a<f> {
        c() {
        }

        public void a() {
        }

        /* renamed from: e */
        public void d(f fVar) {
            e.this.e(fVar);
        }

        public void onError(Throwable th) {
        }
    }

    e(String str, z zVar, ExecutorService executorService, q qVar) {
        this.f7594e = str;
        this.f7595f = zVar;
        this.f7598i = executorService.submit(new a(qVar, str));
    }

    public synchronized <T> k<T> a(j<T> jVar) {
        if (!this.f7599j) {
            return k.G(this.f7600k);
        }
        return k.m(new b(jVar));
    }

    public void b() {
        this.f7596g.dispose();
        this.f7596g = null;
        e(new q1.e(this.f7594e, -1));
    }

    public void c() {
        this.f7596g = (i3.a) this.f7595f.a().x0(new c());
    }

    /* access modifiers changed from: package-private */
    public synchronized void d() {
        while (!this.f7597h.b()) {
            this.f7597h.e().f7616g.e(this.f7600k);
        }
    }

    public synchronized void e(f fVar) {
        if (this.f7600k == null) {
            r1.q.c(fVar, "Connection operations queue to be terminated (%s)", u1.b.d(this.f7594e));
            this.f7599j = false;
            this.f7600k = fVar;
            this.f7598i.cancel(true);
        }
    }
}
