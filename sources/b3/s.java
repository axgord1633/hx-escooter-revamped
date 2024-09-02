package b3;

import f3.c;
import m2.f;
import m2.t;
import m2.v;
import u4.b;

public final class s<T> extends f<T> {

    /* renamed from: f  reason: collision with root package name */
    final v<? extends T> f3045f;

    static final class a<T> extends c<T> implements t<T> {

        /* renamed from: g  reason: collision with root package name */
        p2.c f3046g;

        a(b<? super T> bVar) {
            super(bVar);
        }

        public void b(T t5) {
            h(t5);
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f3046g, cVar)) {
                this.f3046g = cVar;
                this.f4615e.e(this);
            }
        }

        public void cancel() {
            super.cancel();
            this.f3046g.dispose();
        }

        public void onError(Throwable th) {
            this.f4615e.onError(th);
        }
    }

    public s(v<? extends T> vVar) {
        this.f3045f = vVar;
    }

    public void j(b<? super T> bVar) {
        this.f3045f.d(new a(bVar));
    }
}
