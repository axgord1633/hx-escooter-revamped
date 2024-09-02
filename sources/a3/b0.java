package a3;

import m2.n;
import m2.p;
import p2.c;

public final class b0<T> extends a<T, T> {

    static final class a<T> implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f72e;

        /* renamed from: f  reason: collision with root package name */
        c f73f;

        a(p<? super T> pVar) {
            this.f72e = pVar;
        }

        public void a() {
            this.f72e.a();
        }

        public void c(c cVar) {
            this.f73f = cVar;
            this.f72e.c(this);
        }

        public void d(T t5) {
        }

        public void dispose() {
            this.f73f.dispose();
        }

        public boolean f() {
            return this.f73f.f();
        }

        public void onError(Throwable th) {
            this.f72e.onError(th);
        }
    }

    public b0(n<T> nVar) {
        super(nVar);
    }

    public void v0(p<? super T> pVar) {
        this.f24e.g(new a(pVar));
    }
}
