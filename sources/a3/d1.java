package a3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.p;
import m2.q;
import p2.c;
import s2.d;

public final class d1 extends k<Long> {

    /* renamed from: e  reason: collision with root package name */
    final q f118e;

    /* renamed from: f  reason: collision with root package name */
    final long f119f;

    /* renamed from: g  reason: collision with root package name */
    final TimeUnit f120g;

    static final class a extends AtomicReference<c> implements c, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final p<? super Long> f121e;

        a(p<? super Long> pVar) {
            this.f121e = pVar;
        }

        public void a(c cVar) {
            s2.c.p(this, cVar);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return get() == s2.c.DISPOSED;
        }

        public void run() {
            if (!f()) {
                this.f121e.d(0L);
                lazySet(d.INSTANCE);
                this.f121e.a();
            }
        }
    }

    public d1(long j5, TimeUnit timeUnit, q qVar) {
        this.f119f = j5;
        this.f120g = timeUnit;
        this.f118e = qVar;
    }

    public void v0(p<? super Long> pVar) {
        a aVar = new a(pVar);
        pVar.c(aVar);
        aVar.a(this.f118e.d(aVar, this.f119f, this.f120g));
    }
}
