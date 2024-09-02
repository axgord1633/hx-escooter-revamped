package a3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import l3.e;
import m2.k;
import m2.n;
import m2.p;
import p2.c;

public final class f1<T, B> extends a<T, k<T>> {

    /* renamed from: f  reason: collision with root package name */
    final n<B> f137f;

    /* renamed from: g  reason: collision with root package name */
    final int f138g;

    static final class a<T, B> extends i3.a<B> {

        /* renamed from: f  reason: collision with root package name */
        final b<T, B> f139f;

        /* renamed from: g  reason: collision with root package name */
        boolean f140g;

        a(b<T, B> bVar) {
            this.f139f = bVar;
        }

        public void a() {
            if (!this.f140g) {
                this.f140g = true;
                this.f139f.e();
            }
        }

        public void d(B b5) {
            if (!this.f140g) {
                this.f139f.h();
            }
        }

        public void onError(Throwable th) {
            if (this.f140g) {
                j3.a.r(th);
                return;
            }
            this.f140g = true;
            this.f139f.g(th);
        }
    }

    static final class b<T, B> extends AtomicInteger implements p<T>, c, Runnable {

        /* renamed from: o  reason: collision with root package name */
        static final Object f141o = new Object();

        /* renamed from: e  reason: collision with root package name */
        final p<? super k<T>> f142e;

        /* renamed from: f  reason: collision with root package name */
        final int f143f;

        /* renamed from: g  reason: collision with root package name */
        final a<T, B> f144g = new a<>(this);

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<c> f145h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        final AtomicInteger f146i = new AtomicInteger(1);

        /* renamed from: j  reason: collision with root package name */
        final c3.a<Object> f147j = new c3.a<>();

        /* renamed from: k  reason: collision with root package name */
        final g3.b f148k = new g3.b();

        /* renamed from: l  reason: collision with root package name */
        final AtomicBoolean f149l = new AtomicBoolean();

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f150m;

        /* renamed from: n  reason: collision with root package name */
        e<T> f151n;

        b(p<? super k<T>> pVar, int i5) {
            this.f142e = pVar;
            this.f143f = i5;
        }

        public void a() {
            this.f144g.dispose();
            this.f150m = true;
            b();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                p<? super k<T>> pVar = this.f142e;
                c3.a<Object> aVar = this.f147j;
                g3.b bVar = this.f148k;
                int i5 = 1;
                while (this.f146i.get() != 0) {
                    e<T> eVar = this.f151n;
                    boolean z4 = this.f150m;
                    if (!z4 || bVar.get() == null) {
                        Object poll = aVar.poll();
                        boolean z5 = poll == null;
                        if (z4 && z5) {
                            Throwable b5 = bVar.b();
                            if (b5 == null) {
                                if (eVar != null) {
                                    this.f151n = null;
                                    eVar.a();
                                }
                                pVar.a();
                                return;
                            }
                            if (eVar != null) {
                                this.f151n = null;
                                eVar.onError(b5);
                            }
                            pVar.onError(b5);
                            return;
                        } else if (z5) {
                            i5 = addAndGet(-i5);
                            if (i5 == 0) {
                                return;
                            }
                        } else if (poll != f141o) {
                            eVar.d(poll);
                        } else {
                            if (eVar != null) {
                                this.f151n = null;
                                eVar.a();
                            }
                            if (!this.f149l.get()) {
                                e<T> P0 = e.P0(this.f143f, this);
                                this.f151n = P0;
                                this.f146i.getAndIncrement();
                                pVar.d(P0);
                            }
                        }
                    } else {
                        aVar.clear();
                        Throwable b6 = bVar.b();
                        if (eVar != null) {
                            this.f151n = null;
                            eVar.onError(b6);
                        }
                        pVar.onError(b6);
                        return;
                    }
                }
                aVar.clear();
                this.f151n = null;
            }
        }

        public void c(c cVar) {
            if (s2.c.o(this.f145h, cVar)) {
                h();
            }
        }

        public void d(T t5) {
            this.f147j.offer(t5);
            b();
        }

        public void dispose() {
            if (this.f149l.compareAndSet(false, true)) {
                this.f144g.dispose();
                if (this.f146i.decrementAndGet() == 0) {
                    s2.c.c(this.f145h);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            s2.c.c(this.f145h);
            this.f150m = true;
            b();
        }

        public boolean f() {
            return this.f149l.get();
        }

        /* access modifiers changed from: package-private */
        public void g(Throwable th) {
            s2.c.c(this.f145h);
            if (this.f148k.a(th)) {
                this.f150m = true;
                b();
                return;
            }
            j3.a.r(th);
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.f147j.offer(f141o);
            b();
        }

        public void onError(Throwable th) {
            this.f144g.dispose();
            if (this.f148k.a(th)) {
                this.f150m = true;
                b();
                return;
            }
            j3.a.r(th);
        }

        public void run() {
            if (this.f146i.decrementAndGet() == 0) {
                s2.c.c(this.f145h);
            }
        }
    }

    public f1(n<T> nVar, n<B> nVar2, int i5) {
        super(nVar);
        this.f137f = nVar2;
        this.f138g = i5;
    }

    public void v0(p<? super k<T>> pVar) {
        b bVar = new b(pVar, this.f138g);
        pVar.c(bVar);
        this.f137f.g(bVar.f144g);
        this.f24e.g(bVar);
    }
}
