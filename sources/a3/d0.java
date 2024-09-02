package a3;

import d3.o;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.p;
import m2.q;
import p2.c;

public final class d0 extends k<Long> {

    /* renamed from: e  reason: collision with root package name */
    final q f112e;

    /* renamed from: f  reason: collision with root package name */
    final long f113f;

    /* renamed from: g  reason: collision with root package name */
    final long f114g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f115h;

    static final class a extends AtomicReference<c> implements c, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final p<? super Long> f116e;

        /* renamed from: f  reason: collision with root package name */
        long f117f;

        a(p<? super Long> pVar) {
            this.f116e = pVar;
        }

        public void a(c cVar) {
            s2.c.o(this, cVar);
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return get() == s2.c.DISPOSED;
        }

        public void run() {
            if (get() != s2.c.DISPOSED) {
                p<? super Long> pVar = this.f116e;
                long j5 = this.f117f;
                this.f117f = 1 + j5;
                pVar.d(Long.valueOf(j5));
            }
        }
    }

    public d0(long j5, long j6, TimeUnit timeUnit, q qVar) {
        this.f113f = j5;
        this.f114g = j6;
        this.f115h = timeUnit;
        this.f112e = qVar;
    }

    public void v0(p<? super Long> pVar) {
        a aVar = new a(pVar);
        pVar.c(aVar);
        q qVar = this.f112e;
        if (qVar instanceof o) {
            q.c a5 = qVar.a();
            aVar.a(a5);
            a5.d(aVar, this.f113f, this.f114g, this.f115h);
            return;
        }
        aVar.a(qVar.e(aVar, this.f113f, this.f114g, this.f115h));
    }
}
