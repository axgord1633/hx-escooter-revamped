package a3;

import m2.n;
import m2.p;
import p2.c;
import q2.b;
import r2.f;

public final class j0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super Throwable, ? extends T> f208f;

    static final class a<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f209e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super Throwable, ? extends T> f210f;

        /* renamed from: g  reason: collision with root package name */
        c f211g;

        a(p<? super T> pVar, f<? super Throwable, ? extends T> fVar) {
            this.f209e = pVar;
            this.f210f = fVar;
        }

        public void a() {
            this.f209e.a();
        }

        public void c(c cVar) {
            if (s2.c.q(this.f211g, cVar)) {
                this.f211g = cVar;
                this.f209e.c(this);
            }
        }

        public void d(T t5) {
            this.f209e.d(t5);
        }

        public void dispose() {
            this.f211g.dispose();
        }

        public boolean f() {
            return this.f211g.f();
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.f210f.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f209e.onError(nullPointerException);
                    return;
                }
                this.f209e.d(apply);
                this.f209e.a();
            } catch (Throwable th2) {
                b.b(th2);
                this.f209e.onError(new q2.a(th, th2));
            }
        }
    }

    public j0(n<T> nVar, f<? super Throwable, ? extends T> fVar) {
        super(nVar);
        this.f208f = fVar;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f208f));
    }
}
