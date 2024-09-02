package b3;

import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import m2.r;
import m2.t;
import m2.v;
import p2.c;
import v2.i;

public final class d<T, U> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f2984e;

    /* renamed from: f  reason: collision with root package name */
    final n<U> f2985f;

    static final class a<T, U> extends AtomicReference<c> implements p<U>, c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f2986e;

        /* renamed from: f  reason: collision with root package name */
        final v<T> f2987f;

        /* renamed from: g  reason: collision with root package name */
        boolean f2988g;

        a(t<? super T> tVar, v<T> vVar) {
            this.f2986e = tVar;
            this.f2987f = vVar;
        }

        public void a() {
            if (!this.f2988g) {
                this.f2988g = true;
                this.f2987f.d(new i(this, this.f2986e));
            }
        }

        public void c(c cVar) {
            if (s2.c.n(this, cVar)) {
                this.f2986e.c(this);
            }
        }

        public void d(U u5) {
            ((c) get()).dispose();
            a();
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            if (this.f2988g) {
                j3.a.r(th);
                return;
            }
            this.f2988g = true;
            this.f2986e.onError(th);
        }
    }

    public d(v<T> vVar, n<U> nVar) {
        this.f2984e = vVar;
        this.f2985f = nVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        this.f2985f.g(new a(tVar, this.f2984e));
    }
}
