package a3;

import g3.b;
import g3.g;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import p2.c;

public final class x0<T, U> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final n<? extends U> f436f;

    static final class a<T, U> extends AtomicInteger implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f437e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<c> f438f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        final a<T, U>.a f439g = new C0010a();

        /* renamed from: h  reason: collision with root package name */
        final b f440h = new b();

        /* renamed from: a3.x0$a$a  reason: collision with other inner class name */
        final class C0010a extends AtomicReference<c> implements p<U> {
            C0010a() {
            }

            public void a() {
                a.this.b();
            }

            public void c(c cVar) {
                s2.c.o(this, cVar);
            }

            public void d(U u5) {
                s2.c.c(this);
                a.this.b();
            }

            public void onError(Throwable th) {
                a.this.e(th);
            }
        }

        a(p<? super T> pVar) {
            this.f437e = pVar;
        }

        public void a() {
            s2.c.c(this.f439g);
            g.a(this.f437e, this, this.f440h);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            s2.c.c(this.f438f);
            g.a(this.f437e, this, this.f440h);
        }

        public void c(c cVar) {
            s2.c.o(this.f438f, cVar);
        }

        public void d(T t5) {
            g.e(this.f437e, t5, this, this.f440h);
        }

        public void dispose() {
            s2.c.c(this.f438f);
            s2.c.c(this.f439g);
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th) {
            s2.c.c(this.f438f);
            g.c(this.f437e, th, this, this.f440h);
        }

        public boolean f() {
            return s2.c.i(this.f438f.get());
        }

        public void onError(Throwable th) {
            s2.c.c(this.f439g);
            g.c(this.f437e, th, this, this.f440h);
        }
    }

    public x0(n<T> nVar, n<? extends U> nVar2) {
        super(nVar);
        this.f436f = nVar2;
    }

    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar);
        pVar.c(aVar);
        this.f436f.g(aVar.f439g);
        this.f24e.g(aVar);
    }
}
