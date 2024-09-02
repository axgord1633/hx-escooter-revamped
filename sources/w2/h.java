package w2;

import m2.b;
import m2.c;
import m2.k;
import m2.p;

public final class h<T> extends k<T> {

    /* renamed from: e  reason: collision with root package name */
    final c f7575e;

    static final class a extends v2.c<Void> implements b {

        /* renamed from: e  reason: collision with root package name */
        final p<?> f7576e;

        /* renamed from: f  reason: collision with root package name */
        p2.c f7577f;

        a(p<?> pVar) {
            this.f7576e = pVar;
        }

        public void a() {
            this.f7576e.a();
        }

        /* renamed from: b */
        public Void poll() {
            return null;
        }

        public void c(p2.c cVar) {
            if (s2.c.q(this.f7577f, cVar)) {
                this.f7577f = cVar;
                this.f7576e.c(this);
            }
        }

        public void clear() {
        }

        public void dispose() {
            this.f7577f.dispose();
        }

        public boolean f() {
            return this.f7577f.f();
        }

        public int i(int i5) {
            return i5 & 2;
        }

        public boolean isEmpty() {
            return true;
        }

        public void onError(Throwable th) {
            this.f7576e.onError(th);
        }
    }

    public h(c cVar) {
        this.f7575e = cVar;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f7575e.b(new a(pVar));
    }
}
