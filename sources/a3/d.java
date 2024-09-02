package a3;

import g3.e;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import p2.c;
import r2.f;
import u2.i;

public final class d<T, U> extends a<T, U> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends n<? extends U>> f83f;

    /* renamed from: g  reason: collision with root package name */
    final int f84g;

    /* renamed from: h  reason: collision with root package name */
    final e f85h;

    static final class a<T, R> extends AtomicInteger implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super R> f86e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<? extends R>> f87f;

        /* renamed from: g  reason: collision with root package name */
        final int f88g;

        /* renamed from: h  reason: collision with root package name */
        final g3.b f89h = new g3.b();

        /* renamed from: i  reason: collision with root package name */
        final C0003a<R> f90i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f91j;

        /* renamed from: k  reason: collision with root package name */
        i<T> f92k;

        /* renamed from: l  reason: collision with root package name */
        c f93l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f94m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f95n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f96o;

        /* renamed from: p  reason: collision with root package name */
        int f97p;

        /* renamed from: a3.d$a$a  reason: collision with other inner class name */
        static final class C0003a<R> extends AtomicReference<c> implements p<R> {

            /* renamed from: e  reason: collision with root package name */
            final p<? super R> f98e;

            /* renamed from: f  reason: collision with root package name */
            final a<?, R> f99f;

            C0003a(p<? super R> pVar, a<?, R> aVar) {
                this.f98e = pVar;
                this.f99f = aVar;
            }

            public void a() {
                a<?, R> aVar = this.f99f;
                aVar.f94m = false;
                aVar.b();
            }

            /* access modifiers changed from: package-private */
            public void b() {
                s2.c.c(this);
            }

            public void c(c cVar) {
                s2.c.l(this, cVar);
            }

            public void d(R r5) {
                this.f98e.d(r5);
            }

            public void onError(Throwable th) {
                a<?, R> aVar = this.f99f;
                if (aVar.f89h.a(th)) {
                    if (!aVar.f91j) {
                        aVar.f93l.dispose();
                    }
                    aVar.f94m = false;
                    aVar.b();
                    return;
                }
                j3.a.r(th);
            }
        }

        a(p<? super R> pVar, f<? super T, ? extends n<? extends R>> fVar, int i5, boolean z4) {
            this.f86e = pVar;
            this.f87f = fVar;
            this.f88g = i5;
            this.f91j = z4;
            this.f90i = new C0003a<>(pVar, this);
        }

        public void a() {
            this.f95n = true;
            b();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                p<? super R> pVar = this.f86e;
                i<T> iVar = this.f92k;
                g3.b bVar = this.f89h;
                while (true) {
                    if (!this.f94m) {
                        if (!this.f96o) {
                            if (!this.f91j && ((Throwable) bVar.get()) != null) {
                                iVar.clear();
                                this.f96o = true;
                                break;
                            }
                            boolean z4 = this.f95n;
                            try {
                                T poll = iVar.poll();
                                boolean z5 = poll == null;
                                if (z4 && z5) {
                                    this.f96o = true;
                                    Throwable b5 = bVar.b();
                                    if (b5 != null) {
                                        pVar.onError(b5);
                                        return;
                                    } else {
                                        pVar.a();
                                        return;
                                    }
                                } else if (!z5) {
                                    try {
                                        n nVar = (n) t2.b.e(this.f87f.apply(poll), "The mapper returned a null ObservableSource");
                                        if (nVar instanceof Callable) {
                                            try {
                                                Object call = ((Callable) nVar).call();
                                                if (call != null && !this.f96o) {
                                                    pVar.d(call);
                                                }
                                            } catch (Throwable th) {
                                                q2.b.b(th);
                                                bVar.a(th);
                                            }
                                        } else {
                                            this.f94m = true;
                                            nVar.g(this.f90i);
                                        }
                                    } catch (Throwable th2) {
                                        q2.b.b(th2);
                                        this.f96o = true;
                                        this.f93l.dispose();
                                        iVar.clear();
                                        bVar.a(th2);
                                    }
                                }
                            } catch (Throwable th3) {
                                q2.b.b(th3);
                                this.f96o = true;
                                this.f93l.dispose();
                                bVar.a(th3);
                            }
                        } else {
                            iVar.clear();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                pVar.onError(bVar.b());
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f93l, cVar)) {
                this.f93l = cVar;
                if (cVar instanceof u2.d) {
                    u2.d dVar = (u2.d) cVar;
                    int i5 = dVar.i(3);
                    if (i5 == 1) {
                        this.f97p = i5;
                        this.f92k = dVar;
                        this.f95n = true;
                        this.f86e.c(this);
                        b();
                        return;
                    } else if (i5 == 2) {
                        this.f97p = i5;
                        this.f92k = dVar;
                        this.f86e.c(this);
                        return;
                    }
                }
                this.f92k = new c3.c(this.f88g);
                this.f86e.c(this);
            }
        }

        public void d(T t5) {
            if (this.f97p == 0) {
                this.f92k.offer(t5);
            }
            b();
        }

        public void dispose() {
            this.f96o = true;
            this.f93l.dispose();
            this.f90i.b();
        }

        public boolean f() {
            return this.f96o;
        }

        public void onError(Throwable th) {
            if (this.f89h.a(th)) {
                this.f95n = true;
                b();
                return;
            }
            j3.a.r(th);
        }
    }

    static final class b<T, U> extends AtomicInteger implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super U> f100e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<? extends U>> f101f;

        /* renamed from: g  reason: collision with root package name */
        final a<U> f102g;

        /* renamed from: h  reason: collision with root package name */
        final int f103h;

        /* renamed from: i  reason: collision with root package name */
        i<T> f104i;

        /* renamed from: j  reason: collision with root package name */
        c f105j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f106k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f107l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f108m;

        /* renamed from: n  reason: collision with root package name */
        int f109n;

        static final class a<U> extends AtomicReference<c> implements p<U> {

            /* renamed from: e  reason: collision with root package name */
            final p<? super U> f110e;

            /* renamed from: f  reason: collision with root package name */
            final b<?, ?> f111f;

            a(p<? super U> pVar, b<?, ?> bVar) {
                this.f110e = pVar;
                this.f111f = bVar;
            }

            public void a() {
                this.f111f.e();
            }

            /* access modifiers changed from: package-private */
            public void b() {
                s2.c.c(this);
            }

            public void c(c cVar) {
                s2.c.l(this, cVar);
            }

            public void d(U u5) {
                this.f110e.d(u5);
            }

            public void onError(Throwable th) {
                this.f111f.dispose();
                this.f110e.onError(th);
            }
        }

        b(p<? super U> pVar, f<? super T, ? extends n<? extends U>> fVar, int i5) {
            this.f100e = pVar;
            this.f101f = fVar;
            this.f103h = i5;
            this.f102g = new a<>(pVar, this);
        }

        public void a() {
            if (!this.f108m) {
                this.f108m = true;
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                while (!this.f107l) {
                    if (!this.f106k) {
                        boolean z4 = this.f108m;
                        try {
                            T poll = this.f104i.poll();
                            boolean z5 = poll == null;
                            if (z4 && z5) {
                                this.f107l = true;
                                this.f100e.a();
                                return;
                            } else if (!z5) {
                                try {
                                    n nVar = (n) t2.b.e(this.f101f.apply(poll), "The mapper returned a null ObservableSource");
                                    this.f106k = true;
                                    nVar.g(this.f102g);
                                } catch (Throwable th) {
                                    q2.b.b(th);
                                    dispose();
                                    this.f104i.clear();
                                    this.f100e.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            q2.b.b(th2);
                            dispose();
                            this.f104i.clear();
                            this.f100e.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f104i.clear();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f105j, cVar)) {
                this.f105j = cVar;
                if (cVar instanceof u2.d) {
                    u2.d dVar = (u2.d) cVar;
                    int i5 = dVar.i(3);
                    if (i5 == 1) {
                        this.f109n = i5;
                        this.f104i = dVar;
                        this.f108m = true;
                        this.f100e.c(this);
                        b();
                        return;
                    } else if (i5 == 2) {
                        this.f109n = i5;
                        this.f104i = dVar;
                        this.f100e.c(this);
                        return;
                    }
                }
                this.f104i = new c3.c(this.f103h);
                this.f100e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f108m) {
                if (this.f109n == 0) {
                    this.f104i.offer(t5);
                }
                b();
            }
        }

        public void dispose() {
            this.f107l = true;
            this.f102g.b();
            this.f105j.dispose();
            if (getAndIncrement() == 0) {
                this.f104i.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f106k = false;
            b();
        }

        public boolean f() {
            return this.f107l;
        }

        public void onError(Throwable th) {
            if (this.f108m) {
                j3.a.r(th);
                return;
            }
            this.f108m = true;
            dispose();
            this.f100e.onError(th);
        }
    }

    public d(n<T> nVar, f<? super T, ? extends n<? extends U>> fVar, int i5, e eVar) {
        super(nVar);
        this.f83f = fVar;
        this.f85h = eVar;
        this.f84g = Math.max(8, i5);
    }

    public void v0(p<? super U> pVar) {
        if (!s0.b(this.f24e, pVar, this.f83f)) {
            if (this.f85h == e.IMMEDIATE) {
                this.f24e.g(new b(new i3.c(pVar), this.f83f, this.f84g));
            } else {
                this.f24e.g(new a(pVar, this.f83f, this.f84g, this.f85h == e.END));
            }
        }
    }
}
