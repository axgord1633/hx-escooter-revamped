package b3;

import java.util.concurrent.atomic.AtomicReference;
import m2.q;
import m2.r;
import m2.t;
import m2.v;
import p2.c;

public final class p<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f3023e;

    /* renamed from: f  reason: collision with root package name */
    final q f3024f;

    static final class a<T> extends AtomicReference<c> implements t<T>, c, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f3025e;

        /* renamed from: f  reason: collision with root package name */
        final q f3026f;

        /* renamed from: g  reason: collision with root package name */
        T f3027g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f3028h;

        a(t<? super T> tVar, q qVar) {
            this.f3025e = tVar;
            this.f3026f = qVar;
        }

        public void b(T t5) {
            this.f3027g = t5;
            s2.c.l(this, this.f3026f.c(this));
        }

        public void c(c cVar) {
            if (s2.c.o(this, cVar)) {
                this.f3025e.c(this);
            }
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            this.f3028h = th;
            s2.c.l(this, this.f3026f.c(this));
        }

        public void run() {
            Throwable th = this.f3028h;
            if (th != null) {
                this.f3025e.onError(th);
            } else {
                this.f3025e.b(this.f3027g);
            }
        }
    }

    public p(v<T> vVar, q qVar) {
        this.f3023e = vVar;
        this.f3024f = qVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f3023e.d(new a(tVar, this.f3024f));
    }
}
