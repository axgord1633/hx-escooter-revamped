package y2;

import m2.i;
import m2.j;
import m2.k;
import m2.p;
import p2.c;
import v2.f;

public final class g<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final j<T> f7822e;

    static final class a<T> extends f<T> implements i<T> {

        /* renamed from: g  reason: collision with root package name */
        c f7823g;

        a(p<? super T> pVar) {
            super(pVar);
        }

        public void a() {
            e();
        }

        public void b(T t5) {
            g(t5);
        }

        public void c(c cVar) {
            if (s2.c.q(this.f7823g, cVar)) {
                this.f7823g = cVar;
                this.f7264e.c(this);
            }
        }

        public void dispose() {
            super.dispose();
            this.f7823g.dispose();
        }

        public void onError(Throwable th) {
            h(th);
        }
    }

    public g(j<T> jVar) {
        this.f7822e = jVar;
    }

    public static <T> i<T> O0(p<? super T> pVar) {
        return new a(pVar);
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f7822e.b(O0(pVar));
    }
}
