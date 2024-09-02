package a3;

import m2.n;
import m2.p;
import p2.c;

public final class t0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final long f356f;

    static final class a<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f357e;

        /* renamed from: f  reason: collision with root package name */
        long f358f;

        /* renamed from: g  reason: collision with root package name */
        c f359g;

        a(p<? super T> pVar, long j5) {
            this.f357e = pVar;
            this.f358f = j5;
        }

        public void a() {
            this.f357e.a();
        }

        public void c(c cVar) {
            if (s2.c.q(this.f359g, cVar)) {
                this.f359g = cVar;
                this.f357e.c(this);
            }
        }

        public void d(T t5) {
            long j5 = this.f358f;
            if (j5 != 0) {
                this.f358f = j5 - 1;
            } else {
                this.f357e.d(t5);
            }
        }

        public void dispose() {
            this.f359g.dispose();
        }

        public boolean f() {
            return this.f359g.f();
        }

        public void onError(Throwable th) {
            this.f357e.onError(th);
        }
    }

    public t0(n<T> nVar, long j5) {
        super(nVar);
        this.f356f = j5;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f356f));
    }
}
