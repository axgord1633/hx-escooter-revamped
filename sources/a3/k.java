package a3;

import m2.n;
import m2.p;
import p2.c;
import s2.g;

public final class k<T, U> extends m2.k<T> {

    /* renamed from: e  reason: collision with root package name */
    final n<? extends T> f212e;

    /* renamed from: f  reason: collision with root package name */
    final n<U> f213f;

    final class a implements p<U> {

        /* renamed from: e  reason: collision with root package name */
        final g f214e;

        /* renamed from: f  reason: collision with root package name */
        final p<? super T> f215f;

        /* renamed from: g  reason: collision with root package name */
        boolean f216g;

        /* renamed from: a3.k$a$a  reason: collision with other inner class name */
        final class C0007a implements p<T> {
            C0007a() {
            }

            public void a() {
                a.this.f215f.a();
            }

            public void c(c cVar) {
                a.this.f214e.b(cVar);
            }

            public void d(T t5) {
                a.this.f215f.d(t5);
            }

            public void onError(Throwable th) {
                a.this.f215f.onError(th);
            }
        }

        a(g gVar, p<? super T> pVar) {
            this.f214e = gVar;
            this.f215f = pVar;
        }

        public void a() {
            if (!this.f216g) {
                this.f216g = true;
                k.this.f212e.g(new C0007a());
            }
        }

        public void c(c cVar) {
            this.f214e.b(cVar);
        }

        public void d(U u5) {
            a();
        }

        public void onError(Throwable th) {
            if (this.f216g) {
                j3.a.r(th);
                return;
            }
            this.f216g = true;
            this.f215f.onError(th);
        }
    }

    public k(n<? extends T> nVar, n<U> nVar2) {
        this.f212e = nVar;
        this.f213f = nVar2;
    }

    public void v0(p<? super T> pVar) {
        g gVar = new g();
        pVar.c(gVar);
        this.f213f.g(new a(gVar, pVar));
    }
}
