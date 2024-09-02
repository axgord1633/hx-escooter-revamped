package a3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.k;
import m2.n;
import m2.p;
import m2.t;
import m2.v;
import p2.b;
import p2.c;
import r2.f;
import v0.f0;

public final class w<T, R> extends a<T, R> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends v<? extends R>> f413f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f414g;

    static final class a<T, R> extends AtomicInteger implements p<T>, c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super R> f415e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f416f;

        /* renamed from: g  reason: collision with root package name */
        final b f417g = new b();

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f418h = new AtomicInteger(1);

        /* renamed from: i  reason: collision with root package name */
        final g3.b f419i = new g3.b();

        /* renamed from: j  reason: collision with root package name */
        final f<? super T, ? extends v<? extends R>> f420j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<c3.c<R>> f421k = new AtomicReference<>();

        /* renamed from: l  reason: collision with root package name */
        c f422l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f423m;

        /* renamed from: a3.w$a$a  reason: collision with other inner class name */
        final class C0009a extends AtomicReference<c> implements t<R>, c {
            C0009a() {
            }

            public void b(R r5) {
                a.this.j(this, r5);
            }

            public void c(c cVar) {
                s2.c.o(this, cVar);
            }

            public void dispose() {
                s2.c.c(this);
            }

            public boolean f() {
                return s2.c.i((c) get());
            }

            public void onError(Throwable th) {
                a.this.i(this, th);
            }
        }

        a(p<? super R> pVar, f<? super T, ? extends v<? extends R>> fVar, boolean z4) {
            this.f415e = pVar;
            this.f420j = fVar;
            this.f416f = z4;
        }

        public void a() {
            this.f418h.decrementAndGet();
            e();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            c3.c cVar = this.f421k.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        public void c(c cVar) {
            if (s2.c.q(this.f422l, cVar)) {
                this.f422l = cVar;
                this.f415e.c(this);
            }
        }

        public void d(T t5) {
            try {
                v vVar = (v) t2.b.e(this.f420j.apply(t5), "The mapper returned a null SingleSource");
                this.f418h.getAndIncrement();
                C0009a aVar = new C0009a();
                if (!this.f423m && this.f417g.b(aVar)) {
                    vVar.d(aVar);
                }
            } catch (Throwable th) {
                q2.b.b(th);
                this.f422l.dispose();
                onError(th);
            }
        }

        public void dispose() {
            this.f423m = true;
            this.f422l.dispose();
            this.f417g.dispose();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        public boolean f() {
            return this.f423m;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            p<? super R> pVar = this.f415e;
            AtomicInteger atomicInteger = this.f418h;
            AtomicReference<c3.c<R>> atomicReference = this.f421k;
            int i5 = 1;
            while (!this.f423m) {
                if (this.f416f || ((Throwable) this.f419i.get()) == null) {
                    boolean z4 = false;
                    boolean z5 = atomicInteger.get() == 0;
                    c3.c cVar = atomicReference.get();
                    Object poll = cVar != null ? cVar.poll() : null;
                    if (poll == null) {
                        z4 = true;
                    }
                    if (z5 && z4) {
                        Throwable b5 = this.f419i.b();
                        if (b5 != null) {
                            pVar.onError(b5);
                            return;
                        } else {
                            pVar.a();
                            return;
                        }
                    } else if (z4) {
                        i5 = addAndGet(-i5);
                        if (i5 == 0) {
                            return;
                        }
                    } else {
                        pVar.d(poll);
                    }
                } else {
                    Throwable b6 = this.f419i.b();
                    b();
                    pVar.onError(b6);
                    return;
                }
            }
            b();
        }

        /* access modifiers changed from: package-private */
        public c3.c<R> h() {
            c3.c<R> cVar;
            do {
                c3.c<R> cVar2 = this.f421k.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new c3.c<>(k.h());
            } while (!f0.a(this.f421k, (Object) null, cVar));
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public void i(a<T, R>.a aVar, Throwable th) {
            this.f417g.a(aVar);
            if (this.f419i.a(th)) {
                if (!this.f416f) {
                    this.f422l.dispose();
                    this.f417g.dispose();
                }
                this.f418h.decrementAndGet();
                e();
                return;
            }
            j3.a.r(th);
        }

        /* access modifiers changed from: package-private */
        public void j(a<T, R>.a aVar, R r5) {
            this.f417g.a(aVar);
            if (get() == 0) {
                boolean z4 = false;
                if (compareAndSet(0, 1)) {
                    this.f415e.d(r5);
                    if (this.f418h.decrementAndGet() == 0) {
                        z4 = true;
                    }
                    c3.c cVar = this.f421k.get();
                    if (!z4 || (cVar != null && !cVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        g();
                    }
                    Throwable b5 = this.f419i.b();
                    if (b5 != null) {
                        this.f415e.onError(b5);
                        return;
                    } else {
                        this.f415e.a();
                        return;
                    }
                }
            }
            c3.c h5 = h();
            synchronized (h5) {
                h5.offer(r5);
            }
            this.f418h.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            g();
        }

        public void onError(Throwable th) {
            this.f418h.decrementAndGet();
            if (this.f419i.a(th)) {
                if (!this.f416f) {
                    this.f417g.dispose();
                }
                e();
                return;
            }
            j3.a.r(th);
        }
    }

    public w(n<T> nVar, f<? super T, ? extends v<? extends R>> fVar, boolean z4) {
        super(nVar);
        this.f413f = fVar;
        this.f414g = z4;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super R> pVar) {
        this.f24e.g(new a(pVar, this.f413f, this.f414g));
    }
}
