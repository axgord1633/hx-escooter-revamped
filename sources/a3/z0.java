package a3;

import m2.n;
import m2.p;
import p2.c;
import q2.b;
import r2.h;

public final class z0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final h<? super T> f449f;

    static final class a<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f450e;

        /* renamed from: f  reason: collision with root package name */
        final h<? super T> f451f;

        /* renamed from: g  reason: collision with root package name */
        c f452g;

        /* renamed from: h  reason: collision with root package name */
        boolean f453h;

        a(p<? super T> pVar, h<? super T> hVar) {
            this.f450e = pVar;
            this.f451f = hVar;
        }

        public void a() {
            if (!this.f453h) {
                this.f453h = true;
                this.f450e.a();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f452g, cVar)) {
                this.f452g = cVar;
                this.f450e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f453h) {
                try {
                    if (!this.f451f.test(t5)) {
                        this.f453h = true;
                        this.f452g.dispose();
                        this.f450e.a();
                        return;
                    }
                    this.f450e.d(t5);
                } catch (Throwable th) {
                    b.b(th);
                    this.f452g.dispose();
                    onError(th);
                }
            }
        }

        public void dispose() {
            this.f452g.dispose();
        }

        public boolean f() {
            return this.f452g.f();
        }

        public void onError(Throwable th) {
            if (this.f453h) {
                j3.a.r(th);
                return;
            }
            this.f453h = true;
            this.f450e.onError(th);
        }
    }

    public z0(n<T> nVar, h<? super T> hVar) {
        super(nVar);
        this.f449f = hVar;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f449f));
    }
}
