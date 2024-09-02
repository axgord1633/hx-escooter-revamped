package a3;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.n;
import m2.p;
import r2.f;
import s2.g;

public final class a1<T, U, V> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final n<U> f48f;

    /* renamed from: g  reason: collision with root package name */
    final f<? super T, ? extends n<V>> f49g;

    /* renamed from: h  reason: collision with root package name */
    final n<? extends T> f50h;

    static final class a extends AtomicReference<p2.c> implements p<Object>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final d f51e;

        /* renamed from: f  reason: collision with root package name */
        final long f52f;

        a(long j5, d dVar) {
            this.f52f = j5;
            this.f51e = dVar;
        }

        public void a() {
            Object obj = get();
            s2.c cVar = s2.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f51e.e(this.f52f);
            }
        }

        public void c(p2.c cVar) {
            s2.c.o(this, cVar);
        }

        public void d(Object obj) {
            p2.c cVar = (p2.c) get();
            s2.c cVar2 = s2.c.DISPOSED;
            if (cVar != cVar2) {
                cVar.dispose();
                lazySet(cVar2);
                this.f51e.e(this.f52f);
            }
        }

        public void dispose() {
            s2.c.c(this);
        }

        public boolean f() {
            return s2.c.i((p2.c) get());
        }

        public void onError(Throwable th) {
            Object obj = get();
            s2.c cVar = s2.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f51e.b(this.f52f, th);
                return;
            }
            j3.a.r(th);
        }
    }

    static final class b<T> extends AtomicReference<p2.c> implements p<T>, p2.c, d {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f53e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<?>> f54f;

        /* renamed from: g  reason: collision with root package name */
        final g f55g = new g();

        /* renamed from: h  reason: collision with root package name */
        final AtomicLong f56h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<p2.c> f57i;

        /* renamed from: j  reason: collision with root package name */
        n<? extends T> f58j;

        b(p<? super T> pVar, f<? super T, ? extends n<?>> fVar, n<? extends T> nVar) {
            this.f53e = pVar;
            this.f54f = fVar;
            this.f58j = nVar;
            this.f56h = new AtomicLong();
            this.f57i = new AtomicReference<>();
        }

        public void a() {
            if (this.f56h.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f55g.dispose();
                this.f53e.a();
                this.f55g.dispose();
            }
        }

        public void b(long j5, Throwable th) {
            if (this.f56h.compareAndSet(j5, Long.MAX_VALUE)) {
                s2.c.c(this);
                this.f53e.onError(th);
                return;
            }
            j3.a.r(th);
        }

        public void c(p2.c cVar) {
            s2.c.o(this.f57i, cVar);
        }

        public void d(T t5) {
            long j5 = this.f56h.get();
            if (j5 != Long.MAX_VALUE) {
                long j6 = 1 + j5;
                if (this.f56h.compareAndSet(j5, j6)) {
                    p2.c cVar = (p2.c) this.f55g.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.f53e.d(t5);
                    try {
                        n nVar = (n) t2.b.e(this.f54f.apply(t5), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j6, this);
                        if (this.f55g.a(aVar)) {
                            nVar.g(aVar);
                        }
                    } catch (Throwable th) {
                        q2.b.b(th);
                        this.f57i.get().dispose();
                        this.f56h.getAndSet(Long.MAX_VALUE);
                        this.f53e.onError(th);
                    }
                }
            }
        }

        public void dispose() {
            s2.c.c(this.f57i);
            s2.c.c(this);
            this.f55g.dispose();
        }

        public void e(long j5) {
            if (this.f56h.compareAndSet(j5, Long.MAX_VALUE)) {
                s2.c.c(this.f57i);
                n<? extends T> nVar = this.f58j;
                this.f58j = null;
                nVar.g(new b1(this.f53e, this));
            }
        }

        public boolean f() {
            return s2.c.i((p2.c) get());
        }

        /* access modifiers changed from: package-private */
        public void g(n<?> nVar) {
            if (nVar != null) {
                a aVar = new a(0, this);
                if (this.f55g.a(aVar)) {
                    nVar.g(aVar);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f56h.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f55g.dispose();
                this.f53e.onError(th);
                this.f55g.dispose();
                return;
            }
            j3.a.r(th);
        }
    }

    static final class c<T> extends AtomicLong implements p<T>, p2.c, d {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f59e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<?>> f60f;

        /* renamed from: g  reason: collision with root package name */
        final g f61g = new g();

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<p2.c> f62h = new AtomicReference<>();

        c(p<? super T> pVar, f<? super T, ? extends n<?>> fVar) {
            this.f59e = pVar;
            this.f60f = fVar;
        }

        public void a() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f61g.dispose();
                this.f59e.a();
            }
        }

        public void b(long j5, Throwable th) {
            if (compareAndSet(j5, Long.MAX_VALUE)) {
                s2.c.c(this.f62h);
                this.f59e.onError(th);
                return;
            }
            j3.a.r(th);
        }

        public void c(p2.c cVar) {
            s2.c.o(this.f62h, cVar);
        }

        public void d(T t5) {
            long j5 = get();
            if (j5 != Long.MAX_VALUE) {
                long j6 = 1 + j5;
                if (compareAndSet(j5, j6)) {
                    p2.c cVar = (p2.c) this.f61g.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.f59e.d(t5);
                    try {
                        n nVar = (n) t2.b.e(this.f60f.apply(t5), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j6, this);
                        if (this.f61g.a(aVar)) {
                            nVar.g(aVar);
                        }
                    } catch (Throwable th) {
                        q2.b.b(th);
                        this.f62h.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.f59e.onError(th);
                    }
                }
            }
        }

        public void dispose() {
            s2.c.c(this.f62h);
            this.f61g.dispose();
        }

        public void e(long j5) {
            if (compareAndSet(j5, Long.MAX_VALUE)) {
                s2.c.c(this.f62h);
                this.f59e.onError(new TimeoutException());
            }
        }

        public boolean f() {
            return s2.c.i(this.f62h.get());
        }

        /* access modifiers changed from: package-private */
        public void g(n<?> nVar) {
            if (nVar != null) {
                a aVar = new a(0, this);
                if (this.f61g.a(aVar)) {
                    nVar.g(aVar);
                }
            }
        }

        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f61g.dispose();
                this.f59e.onError(th);
                return;
            }
            j3.a.r(th);
        }
    }

    interface d extends c1 {
        void b(long j5, Throwable th);
    }

    public a1(k<T> kVar, n<U> nVar, f<? super T, ? extends n<V>> fVar, n<? extends T> nVar2) {
        super(kVar);
        this.f48f = nVar;
        this.f49g = fVar;
        this.f50h = nVar2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: a3.a1$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: a3.a1$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: a3.a1$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: a3.a1$b} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v0(m2.p<? super T> r4) {
        /*
            r3 = this;
            m2.n<? extends T> r0 = r3.f50h
            if (r0 != 0) goto L_0x0014
            a3.a1$c r0 = new a3.a1$c
            r2.f<? super T, ? extends m2.n<V>> r1 = r3.f49g
            r0.<init>(r4, r1)
            r4.c(r0)
            m2.n<U> r4 = r3.f48f
            r0.g(r4)
            goto L_0x0025
        L_0x0014:
            a3.a1$b r0 = new a3.a1$b
            r2.f<? super T, ? extends m2.n<V>> r1 = r3.f49g
            m2.n<? extends T> r2 = r3.f50h
            r0.<init>(r4, r1, r2)
            r4.c(r0)
            m2.n<U> r4 = r3.f48f
            r0.g(r4)
        L_0x0025:
            m2.n<T> r4 = r3.f24e
            r4.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.a1.v0(m2.p):void");
    }
}
