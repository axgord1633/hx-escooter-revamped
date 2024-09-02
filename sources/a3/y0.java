package a3;

import m2.n;
import m2.p;
import p2.c;
import q2.b;
import r2.h;

public final class y0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final h<? super T> f443f;

    static final class a<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f444e;

        /* renamed from: f  reason: collision with root package name */
        final h<? super T> f445f;

        /* renamed from: g  reason: collision with root package name */
        c f446g;

        /* renamed from: h  reason: collision with root package name */
        boolean f447h;

        a(p<? super T> pVar, h<? super T> hVar) {
            this.f444e = pVar;
            this.f445f = hVar;
        }

        public void a() {
            if (!this.f447h) {
                this.f447h = true;
                this.f444e.a();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f446g, cVar)) {
                this.f446g = cVar;
                this.f444e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f447h) {
                this.f444e.d(t5);
                try {
                    if (this.f445f.test(t5)) {
                        this.f447h = true;
                        this.f446g.dispose();
                        this.f444e.a();
                    }
                } catch (Throwable th) {
                    b.b(th);
                    this.f446g.dispose();
                    onError(th);
                }
            }
        }

        public void dispose() {
            this.f446g.dispose();
        }

        public boolean f() {
            return this.f446g.f();
        }

        public void onError(Throwable th) {
            if (!this.f447h) {
                this.f447h = true;
                this.f444e.onError(th);
                return;
            }
            j3.a.r(th);
        }
    }

    public y0(n<T> nVar, h<? super T> hVar) {
        super(nVar);
        this.f443f = hVar;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f443f));
    }
}
