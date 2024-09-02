package a3;

import java.util.concurrent.atomic.AtomicBoolean;
import m2.n;
import m2.p;
import m2.q;
import p2.c;

public final class e1<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final q f126f;

    static final class a<T> extends AtomicBoolean implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f127e;

        /* renamed from: f  reason: collision with root package name */
        final q f128f;

        /* renamed from: g  reason: collision with root package name */
        c f129g;

        /* renamed from: a3.e1$a$a  reason: collision with other inner class name */
        final class C0004a implements Runnable {
            C0004a() {
            }

            public void run() {
                a.this.f129g.dispose();
            }
        }

        a(p<? super T> pVar, q qVar) {
            this.f127e = pVar;
            this.f128f = qVar;
        }

        public void a() {
            if (!get()) {
                this.f127e.a();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f129g, cVar)) {
                this.f129g = cVar;
                this.f127e.c(this);
            }
        }

        public void d(T t5) {
            if (!get()) {
                this.f127e.d(t5);
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f128f.c(new C0004a());
            }
        }

        public boolean f() {
            return get();
        }

        public void onError(Throwable th) {
            if (get()) {
                j3.a.r(th);
            } else {
                this.f127e.onError(th);
            }
        }
    }

    public e1(n<T> nVar, q qVar) {
        super(nVar);
        this.f126f = qVar;
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar, this.f126f));
    }
}
