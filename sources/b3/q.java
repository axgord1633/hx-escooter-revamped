package b3;

import g3.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import m2.r;
import m2.t;
import m2.v;
import p2.c;

public final class q<T> extends r<T> {

    /* renamed from: e  reason: collision with root package name */
    final v<T> f3029e;

    /* renamed from: f  reason: collision with root package name */
    final long f3030f;

    /* renamed from: g  reason: collision with root package name */
    final TimeUnit f3031g;

    /* renamed from: h  reason: collision with root package name */
    final m2.q f3032h;

    /* renamed from: i  reason: collision with root package name */
    final v<? extends T> f3033i;

    static final class a<T> extends AtomicReference<c> implements t<T>, Runnable, c {

        /* renamed from: e  reason: collision with root package name */
        final t<? super T> f3034e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<c> f3035f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        final C0055a<T> f3036g;

        /* renamed from: h  reason: collision with root package name */
        v<? extends T> f3037h;

        /* renamed from: i  reason: collision with root package name */
        final long f3038i;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f3039j;

        /* renamed from: b3.q$a$a  reason: collision with other inner class name */
        static final class C0055a<T> extends AtomicReference<c> implements t<T> {

            /* renamed from: e  reason: collision with root package name */
            final t<? super T> f3040e;

            C0055a(t<? super T> tVar) {
                this.f3040e = tVar;
            }

            public void b(T t5) {
                this.f3040e.b(t5);
            }

            public void c(c cVar) {
                s2.c.o(this, cVar);
            }

            public void onError(Throwable th) {
                this.f3040e.onError(th);
            }
        }

        a(t<? super T> tVar, v<? extends T> vVar, long j5, TimeUnit timeUnit) {
            this.f3034e = tVar;
            this.f3037h = vVar;
            this.f3038i = j5;
            this.f3039j = timeUnit;
            if (vVar != null) {
                this.f3036g = new C0055a<>(tVar);
            } else {
                this.f3036g = null;
            }
        }

        public void b(T t5) {
            c cVar = (c) get();
            s2.c cVar2 = s2.c.DISPOSED;
            if (cVar != cVar2 && compareAndSet(cVar, cVar2)) {
                s2.c.c(this.f3035f);
                this.f3034e.b(t5);
            }
        }

        public void c(c cVar) {
            s2.c.o(this, cVar);
        }

        public void dispose() {
            s2.c.c(this);
            s2.c.c(this.f3035f);
            C0055a<T> aVar = this.f3036g;
            if (aVar != null) {
                s2.c.c(aVar);
            }
        }

        public boolean f() {
            return s2.c.i((c) get());
        }

        public void onError(Throwable th) {
            c cVar = (c) get();
            s2.c cVar2 = s2.c.DISPOSED;
            if (cVar == cVar2 || !compareAndSet(cVar, cVar2)) {
                j3.a.r(th);
                return;
            }
            s2.c.c(this.f3035f);
            this.f3034e.onError(th);
        }

        public void run() {
            c cVar = (c) get();
            s2.c cVar2 = s2.c.DISPOSED;
            if (cVar != cVar2 && compareAndSet(cVar, cVar2)) {
                if (cVar != null) {
                    cVar.dispose();
                }
                v<? extends T> vVar = this.f3037h;
                if (vVar == null) {
                    this.f3034e.onError(new TimeoutException(f.c(this.f3038i, this.f3039j)));
                    return;
                }
                this.f3037h = null;
                vVar.d(this.f3036g);
            }
        }
    }

    public q(v<T> vVar, long j5, TimeUnit timeUnit, m2.q qVar, v<? extends T> vVar2) {
        this.f3029e = vVar;
        this.f3030f = j5;
        this.f3031g = timeUnit;
        this.f3032h = qVar;
        this.f3033i = vVar2;
    }

    /* access modifiers changed from: protected */
    public void D(t<? super T> tVar) {
        a aVar = new a(tVar, this.f3033i, this.f3030f, this.f3031g);
        tVar.c(aVar);
        s2.c.l(aVar.f3035f, this.f3032h.d(aVar, this.f3030f, this.f3031g));
        this.f3029e.d(aVar);
    }
}
