package a3;

import m2.p;
import p2.c;
import q2.b;
import r2.e;

public final class n<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final e<? super T> f251f;

    /* renamed from: g  reason: collision with root package name */
    final e<? super Throwable> f252g;

    /* renamed from: h  reason: collision with root package name */
    final r2.a f253h;

    /* renamed from: i  reason: collision with root package name */
    final r2.a f254i;

    static final class a<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f255e;

        /* renamed from: f  reason: collision with root package name */
        final e<? super T> f256f;

        /* renamed from: g  reason: collision with root package name */
        final e<? super Throwable> f257g;

        /* renamed from: h  reason: collision with root package name */
        final r2.a f258h;

        /* renamed from: i  reason: collision with root package name */
        final r2.a f259i;

        /* renamed from: j  reason: collision with root package name */
        c f260j;

        /* renamed from: k  reason: collision with root package name */
        boolean f261k;

        a(p<? super T> pVar, e<? super T> eVar, e<? super Throwable> eVar2, r2.a aVar, r2.a aVar2) {
            this.f255e = pVar;
            this.f256f = eVar;
            this.f257g = eVar2;
            this.f258h = aVar;
            this.f259i = aVar2;
        }

        public void a() {
            if (!this.f261k) {
                try {
                    this.f258h.run();
                    this.f261k = true;
                    this.f255e.a();
                    try {
                        this.f259i.run();
                    } catch (Throwable th) {
                        b.b(th);
                        j3.a.r(th);
                    }
                } catch (Throwable th2) {
                    b.b(th2);
                    onError(th2);
                }
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f260j, cVar)) {
                this.f260j = cVar;
                this.f255e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f261k) {
                try {
                    this.f256f.accept(t5);
                    this.f255e.d(t5);
                } catch (Throwable th) {
                    b.b(th);
                    this.f260j.dispose();
                    onError(th);
                }
            }
        }

        public void dispose() {
            this.f260j.dispose();
        }

        public boolean f() {
            return this.f260j.f();
        }

        public void onError(Throwable th) {
            if (this.f261k) {
                j3.a.r(th);
                return;
            }
            this.f261k = true;
            try {
                this.f257g.accept(th);
            } catch (Throwable th2) {
                b.b(th2);
                th = new q2.a(th, th2);
            }
            this.f255e.onError(th);
            try {
                this.f259i.run();
            } catch (Throwable th3) {
                b.b(th3);
                j3.a.r(th3);
            }
        }
    }

    public n(m2.n<T> nVar, e<? super T> eVar, e<? super Throwable> eVar2, r2.a aVar, r2.a aVar2) {
        super(nVar);
        this.f251f = eVar;
        this.f252g = eVar2;
        this.f253h = aVar;
        this.f254i = aVar2;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f251f, this.f252g, this.f253h, this.f254i));
    }
}
