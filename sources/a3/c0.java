package a3;

import m2.b;
import m2.k;
import m2.n;
import m2.p;
import u2.c;

public final class c0<T> extends m2.a implements c<T> {

    /* renamed from: e  reason: collision with root package name */
    final n<T> f80e;

    static final class a<T> implements p<T>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final b f81e;

        /* renamed from: f  reason: collision with root package name */
        p2.c f82f;

        a(b bVar) {
            this.f81e = bVar;
        }

        public void a() {
            this.f81e.a();
        }

        public void c(p2.c cVar) {
            this.f82f = cVar;
            this.f81e.c(this);
        }

        public void d(T t5) {
        }

        public void dispose() {
            this.f82f.dispose();
        }

        public boolean f() {
            return this.f82f.f();
        }

        public void onError(Throwable th) {
            this.f81e.onError(th);
        }
    }

    public c0(n<T> nVar) {
        this.f80e = nVar;
    }

    public k<T> a() {
        return j3.a.o(new b0(this.f80e));
    }

    public void m(b bVar) {
        this.f80e.g(new a(bVar));
    }
}
