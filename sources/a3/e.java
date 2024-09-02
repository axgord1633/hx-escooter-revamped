package a3;

import m2.n;
import m2.p;
import p2.c;

public final class e<T> extends a<T, Long> {

    static final class a implements p<Object>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super Long> f122e;

        /* renamed from: f  reason: collision with root package name */
        c f123f;

        /* renamed from: g  reason: collision with root package name */
        long f124g;

        a(p<? super Long> pVar) {
            this.f122e = pVar;
        }

        public void a() {
            this.f122e.d(Long.valueOf(this.f124g));
            this.f122e.a();
        }

        public void c(c cVar) {
            if (s2.c.q(this.f123f, cVar)) {
                this.f123f = cVar;
                this.f122e.c(this);
            }
        }

        public void d(Object obj) {
            this.f124g++;
        }

        public void dispose() {
            this.f123f.dispose();
        }

        public boolean f() {
            return this.f123f.f();
        }

        public void onError(Throwable th) {
            this.f122e.onError(th);
        }
    }

    public e(n<T> nVar) {
        super(nVar);
    }

    public void v0(p<? super Long> pVar) {
        this.f24e.g(new a(pVar));
    }
}
