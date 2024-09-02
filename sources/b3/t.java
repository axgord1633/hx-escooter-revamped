package b3;

import m2.k;
import m2.p;
import m2.v;
import p2.c;
import v2.f;

public final class t<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<? extends T> f3047e;

    static final class a<T> extends f<T> implements m2.t<T> {

        /* renamed from: g  reason: collision with root package name */
        c f3048g;

        a(p<? super T> pVar) {
            super(pVar);
        }

        public void b(T t5) {
            g(t5);
        }

        public void c(c cVar) {
            if (s2.c.q(this.f3048g, cVar)) {
                this.f3048g = cVar;
                this.f7264e.c(this);
            }
        }

        public void dispose() {
            super.dispose();
            this.f3048g.dispose();
        }

        public void onError(Throwable th) {
            h(th);
        }
    }

    public t(v<? extends T> vVar) {
        this.f3047e = vVar;
    }

    public static <T> m2.t<T> O0(p<? super T> pVar) {
        return new a(pVar);
    }

    public void v0(p<? super T> pVar) {
        this.f3047e.d(O0(pVar));
    }
}
