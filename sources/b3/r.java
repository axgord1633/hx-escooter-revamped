package b3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import m2.q;
import m2.t;
import p2.c;

public final class r extends m2.r<Long> {

    /* renamed from: e  reason: collision with root package name */
    final long f3041e;

    /* renamed from: f  reason: collision with root package name */
    final TimeUnit f3042f;

    /* renamed from: g  reason: collision with root package name */
    final q f3043g;

    static final class a extends AtomicReference<c> implements c, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final t<? super Long> f3044e;

        a(t<? super Long> tVar) {
            this.f3044e = tVar;
        }

        /* access modifiers changed from: package-private */
        public void a(c cVar) {
            s2.c.l(this, cVar);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void run() {
            this.f3044e.b(0L);
        }
    }

    public r(long j5, TimeUnit timeUnit, q qVar) {
        this.f3041e = j5;
        this.f3042f = timeUnit;
        this.f3043g = qVar;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super Long> tVar) {
        a aVar = new a(tVar);
        tVar.c(aVar);
        aVar.a(this.f3043g.d(aVar, this.f3041e, this.f3042f));
    }
}
