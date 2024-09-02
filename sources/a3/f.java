package a3;

import m2.k;
import m2.n;
import m2.p;
import m2.r;
import m2.t;
import u2.c;

public final class f<T> extends r<Long> implements c<Long> {

    /* renamed from: e  reason: collision with root package name */
    final n<T> f131e;

    static final class a implements p<Object>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super Long> f132e;

        /* renamed from: f  reason: collision with root package name */
        p2.c f133f;

        /* renamed from: g  reason: collision with root package name */
        long f134g;

        a(t<? super Long> tVar) {
            this.f132e = tVar;
        }

        public void a() {
            this.f133f = s2.c.DISPOSED;
            this.f132e.b(Long.valueOf(this.f134g));
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f133f, cVar)) {
                this.f133f = cVar;
                this.f132e.c(this);
            }
        }

        public void d(Object obj) {
            this.f134g++;
        }

        public void dispose() {
            this.f133f.dispose();
            this.f133f = s2.c.DISPOSED;
        }

        public boolean f() {
            return this.f133f.f();
        }

        public void onError(Throwable th) {
            this.f133f = s2.c.DISPOSED;
            this.f132e.onError(th);
        }
    }

    public f(n<T> nVar) {
        this.f131e = nVar;
    }

    public void D(t<? super Long> tVar) {
        this.f131e.g(new a(tVar));
    }

    public k<Long> a() {
        return j3.a.o(new e(this.f131e));
    }
}
