package a3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import m2.q;
import p2.c;

public final class h<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final long f162f;

    /* renamed from: g  reason: collision with root package name */
    final TimeUnit f163g;

    /* renamed from: h  reason: collision with root package name */
    final q f164h;

    static final class a<T> extends AtomicReference<c> implements Runnable, c {

        /* renamed from: e  reason: collision with root package name */
        final T f165e;

        /* renamed from: f  reason: collision with root package name */
        final long f166f;

        /* renamed from: g  reason: collision with root package name */
        final b<T> f167g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f168h = new AtomicBoolean();

        a(T t5, long j5, b<T> bVar) {
            this.f165e = t5;
            this.f166f = j5;
            this.f167g = bVar;
        }

        public void a(c cVar) {
            s2.c.l(this, cVar);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return get() == s2.c.DISPOSED;
        }

        public void run() {
            if (this.f168h.compareAndSet(false, true)) {
                this.f167g.b(this.f166f, this.f165e, this);
            }
        }
    }

    static final class b<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f169e;

        /* renamed from: f  reason: collision with root package name */
        final long f170f;

        /* renamed from: g  reason: collision with root package name */
        final TimeUnit f171g;

        /* renamed from: h  reason: collision with root package name */
        final q.c f172h;

        /* renamed from: i  reason: collision with root package name */
        c f173i;

        /* renamed from: j  reason: collision with root package name */
        c f174j;

        /* renamed from: k  reason: collision with root package name */
        volatile long f175k;

        /* renamed from: l  reason: collision with root package name */
        boolean f176l;

        b(p<? super T> pVar, long j5, TimeUnit timeUnit, q.c cVar) {
            this.f169e = pVar;
            this.f170f = j5;
            this.f171g = timeUnit;
            this.f172h = cVar;
        }

        public void a() {
            if (!this.f176l) {
                this.f176l = true;
                c cVar = this.f174j;
                if (cVar != null) {
                    cVar.dispose();
                }
                a aVar = (a) cVar;
                if (aVar != null) {
                    aVar.run();
                }
                this.f169e.a();
                this.f172h.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j5, T t5, a<T> aVar) {
            if (j5 == this.f175k) {
                this.f169e.d(t5);
                aVar.dispose();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f173i, cVar)) {
                this.f173i = cVar;
                this.f169e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f176l) {
                long j5 = this.f175k + 1;
                this.f175k = j5;
                c cVar = this.f174j;
                if (cVar != null) {
                    cVar.dispose();
                }
                a aVar = new a(t5, j5, this);
                this.f174j = aVar;
                aVar.a(this.f172h.c(aVar, this.f170f, this.f171g));
            }
        }

        public void dispose() {
            this.f173i.dispose();
            this.f172h.dispose();
        }

        public boolean f() {
            return this.f172h.f();
        }

        public void onError(Throwable th) {
            if (this.f176l) {
                j3.a.r(th);
                return;
            }
            c cVar = this.f174j;
            if (cVar != null) {
                cVar.dispose();
            }
            this.f176l = true;
            this.f169e.onError(th);
            this.f172h.dispose();
        }
    }

    public h(n<T> nVar, long j5, TimeUnit timeUnit, q qVar) {
        super(nVar);
        this.f162f = j5;
        this.f163g = timeUnit;
        this.f164h = qVar;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new b(new i3.c(pVar), this.f162f, this.f163g, this.f164h.a()));
    }
}
