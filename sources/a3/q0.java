package a3;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import v0.f0;

public final class q0<T> extends h3.a<T> implements s2.f {

    /* renamed from: i  reason: collision with root package name */
    static final b f311i = new j();

    /* renamed from: e  reason: collision with root package name */
    final n<T> f312e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<g<T>> f313f;

    /* renamed from: g  reason: collision with root package name */
    final b<T> f314g;

    /* renamed from: h  reason: collision with root package name */
    final n<T> f315h;

    static abstract class a<T> extends AtomicReference<d> implements e<T> {

        /* renamed from: e  reason: collision with root package name */
        d f316e;

        /* renamed from: f  reason: collision with root package name */
        int f317f;

        a() {
            d dVar = new d((Object) null);
            this.f316e = dVar;
            set(dVar);
        }

        /* access modifiers changed from: package-private */
        public final void a(d dVar) {
            this.f316e.set(dVar);
            this.f316e = dVar;
            this.f317f++;
        }

        /* access modifiers changed from: package-private */
        public Object b(Object obj) {
            return obj;
        }

        public final void c() {
            a(new d(b(g3.h.i())));
            l();
        }

        /* access modifiers changed from: package-private */
        public d d() {
            return (d) get();
        }

        /* access modifiers changed from: package-private */
        public Object e(Object obj) {
            return obj;
        }

        public final void error(Throwable th) {
            a(new d(b(g3.h.m(th))));
            l();
        }

        public final void f(T t5) {
            a(new d(b(g3.h.q(t5))));
            k();
        }

        /* access modifiers changed from: package-private */
        public final void g() {
            this.f317f--;
            h((d) ((d) get()).get());
        }

        /* access modifiers changed from: package-private */
        public final void h(d dVar) {
            set(dVar);
        }

        public final void i(c<T> cVar) {
            if (cVar.getAndIncrement() == 0) {
                int i5 = 1;
                do {
                    d dVar = (d) cVar.a();
                    if (dVar == null) {
                        dVar = d();
                        cVar.f320g = dVar;
                    }
                    while (!cVar.f()) {
                        d dVar2 = (d) dVar.get();
                        if (dVar2 == null) {
                            cVar.f320g = dVar;
                            i5 = cVar.addAndGet(-i5);
                        } else if (g3.h.c(e(dVar2.f322e), cVar.f319f)) {
                            cVar.f320g = null;
                            return;
                        } else {
                            dVar = dVar2;
                        }
                    }
                    cVar.f320g = null;
                    return;
                } while (i5 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public final void j() {
            d dVar = (d) get();
            if (dVar.f322e != null) {
                d dVar2 = new d((Object) null);
                dVar2.lazySet(dVar.get());
                set(dVar2);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void k();

        /* access modifiers changed from: package-private */
        public void l() {
            j();
        }
    }

    interface b<T> {
        e<T> call();
    }

    static final class c<T> extends AtomicInteger implements p2.c {

        /* renamed from: e  reason: collision with root package name */
        final g<T> f318e;

        /* renamed from: f  reason: collision with root package name */
        final p<? super T> f319f;

        /* renamed from: g  reason: collision with root package name */
        Object f320g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f321h;

        c(g<T> gVar, p<? super T> pVar) {
            this.f318e = gVar;
            this.f319f = pVar;
        }

        /* access modifiers changed from: package-private */
        public <U> U a() {
            return this.f320g;
        }

        public void dispose() {
            if (!this.f321h) {
                this.f321h = true;
                this.f318e.e(this);
                this.f320g = null;
            }
        }

        public boolean f() {
            return this.f321h;
        }
    }

    static final class d extends AtomicReference<d> {

        /* renamed from: e  reason: collision with root package name */
        final Object f322e;

        d(Object obj) {
            this.f322e = obj;
        }
    }

    interface e<T> {
        void c();

        void error(Throwable th);

        void f(T t5);

        void i(c<T> cVar);
    }

    static final class f<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f323a;

        f(int i5) {
            this.f323a = i5;
        }

        public e<T> call() {
            return new i(this.f323a);
        }
    }

    static final class g<T> extends AtomicReference<p2.c> implements p<T>, p2.c {

        /* renamed from: i  reason: collision with root package name */
        static final c[] f324i = new c[0];

        /* renamed from: j  reason: collision with root package name */
        static final c[] f325j = new c[0];

        /* renamed from: e  reason: collision with root package name */
        final e<T> f326e;

        /* renamed from: f  reason: collision with root package name */
        boolean f327f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<c[]> f328g = new AtomicReference<>(f324i);

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f329h = new AtomicBoolean();

        g(e<T> eVar) {
            this.f326e = eVar;
        }

        public void a() {
            if (!this.f327f) {
                this.f327f = true;
                this.f326e.c();
                h();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            do {
                cVarArr = this.f328g.get();
                if (cVarArr == f325j) {
                    return false;
                }
                int length = cVarArr.length;
                cVarArr2 = new c[(length + 1)];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
            } while (!f0.a(this.f328g, cVarArr, cVarArr2));
            return true;
        }

        public void c(p2.c cVar) {
            if (s2.c.o(this, cVar)) {
                g();
            }
        }

        public void d(T t5) {
            if (!this.f327f) {
                this.f326e.f(t5);
                g();
            }
        }

        public void dispose() {
            this.f328g.set(f325j);
            s2.c.c(this);
        }

        /* access modifiers changed from: package-private */
        public void e(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            do {
                cVarArr = this.f328g.get();
                int length = cVarArr.length;
                if (length != 0) {
                    int i5 = -1;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (cVarArr[i6].equals(cVar)) {
                            i5 = i6;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (i5 >= 0) {
                        if (length == 1) {
                            cVarArr2 = f324i;
                        } else {
                            c[] cVarArr3 = new c[(length - 1)];
                            System.arraycopy(cVarArr, 0, cVarArr3, 0, i5);
                            System.arraycopy(cVarArr, i5 + 1, cVarArr3, i5, (length - i5) - 1);
                            cVarArr2 = cVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!f0.a(this.f328g, cVarArr, cVarArr2));
        }

        public boolean f() {
            return this.f328g.get() == f325j;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            for (c i5 : this.f328g.get()) {
                this.f326e.i(i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            for (c i5 : this.f328g.getAndSet(f325j)) {
                this.f326e.i(i5);
            }
        }

        public void onError(Throwable th) {
            if (!this.f327f) {
                this.f327f = true;
                this.f326e.error(th);
                h();
                return;
            }
            j3.a.r(th);
        }
    }

    static final class h<T> implements n<T> {

        /* renamed from: e  reason: collision with root package name */
        private final AtomicReference<g<T>> f330e;

        /* renamed from: f  reason: collision with root package name */
        private final b<T> f331f;

        h(AtomicReference<g<T>> atomicReference, b<T> bVar) {
            this.f330e = atomicReference;
            this.f331f = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(m2.p<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<a3.q0$g<T>> r0 = r3.f330e
                java.lang.Object r0 = r0.get()
                a3.q0$g r0 = (a3.q0.g) r0
                if (r0 != 0) goto L_0x0020
                a3.q0$b<T> r0 = r3.f331f
                a3.q0$e r0 = r0.call()
                a3.q0$g r1 = new a3.q0$g
                r1.<init>(r0)
                java.util.concurrent.atomic.AtomicReference<a3.q0$g<T>> r0 = r3.f330e
                r2 = 0
                boolean r0 = v0.f0.a(r0, r2, r1)
                if (r0 != 0) goto L_0x001f
                goto L_0x0000
            L_0x001f:
                r0 = r1
            L_0x0020:
                a3.q0$c r1 = new a3.q0$c
                r1.<init>(r0, r4)
                r4.c(r1)
                r0.b(r1)
                boolean r4 = r1.f()
                if (r4 == 0) goto L_0x0035
                r0.e(r1)
                return
            L_0x0035:
                a3.q0$e<T> r4 = r0.f326e
                r4.i(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a3.q0.h.g(m2.p):void");
        }
    }

    static final class i<T> extends a<T> {

        /* renamed from: g  reason: collision with root package name */
        final int f332g;

        i(int i5) {
            this.f332g = i5;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            if (this.f317f > this.f332g) {
                g();
            }
        }
    }

    static final class j implements b<Object> {
        j() {
        }

        public e<Object> call() {
            return new k(16);
        }
    }

    static final class k<T> extends ArrayList<Object> implements e<T> {

        /* renamed from: e  reason: collision with root package name */
        volatile int f333e;

        k(int i5) {
            super(i5);
        }

        public void c() {
            add(g3.h.i());
            this.f333e++;
        }

        public void error(Throwable th) {
            add(g3.h.m(th));
            this.f333e++;
        }

        public void f(T t5) {
            add(g3.h.q(t5));
            this.f333e++;
        }

        public void i(c<T> cVar) {
            if (cVar.getAndIncrement() == 0) {
                p<? super T> pVar = cVar.f319f;
                int i5 = 1;
                while (!cVar.f()) {
                    int i6 = this.f333e;
                    Integer num = (Integer) cVar.a();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i6) {
                        if (!g3.h.c(get(intValue), pVar) && !cVar.f()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    cVar.f320g = Integer.valueOf(intValue);
                    i5 = cVar.addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                }
            }
        }
    }

    private q0(n<T> nVar, n<T> nVar2, AtomicReference<g<T>> atomicReference, b<T> bVar) {
        this.f315h = nVar;
        this.f312e = nVar2;
        this.f313f = atomicReference;
        this.f314g = bVar;
    }

    public static <T> h3.a<T> T0(n<T> nVar, int i5) {
        return i5 == Integer.MAX_VALUE ? V0(nVar) : U0(nVar, new f(i5));
    }

    static <T> h3.a<T> U0(n<T> nVar, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return j3.a.k(new q0(new h(atomicReference, bVar), nVar, atomicReference, bVar));
    }

    public static <T> h3.a<T> V0(n<? extends T> nVar) {
        return U0(nVar, f311i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Q0(r2.e<? super p2.c> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<a3.q0$g<T>> r0 = r4.f313f
            java.lang.Object r0 = r0.get()
            a3.q0$g r0 = (a3.q0.g) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.f()
            if (r1 == 0) goto L_0x0025
        L_0x0010:
            a3.q0$b<T> r1 = r4.f314g
            a3.q0$e r1 = r1.call()
            a3.q0$g r2 = new a3.q0$g
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<a3.q0$g<T>> r1 = r4.f313f
            boolean r0 = v0.f0.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0024
            goto L_0x0000
        L_0x0024:
            r0 = r2
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f329h
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0039
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f329h
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0039
            r1 = r2
            goto L_0x003a
        L_0x0039:
            r1 = r3
        L_0x003a:
            r5.accept(r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0044
            m2.n<T> r5 = r4.f312e
            r5.g(r0)
        L_0x0044:
            return
        L_0x0045:
            r5 = move-exception
            if (r1 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f329h
            r0.compareAndSet(r2, r3)
        L_0x004d:
            q2.b.b(r5)
            java.lang.RuntimeException r5 = g3.f.d(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.q0.Q0(r2.e):void");
    }

    public void b(p2.c cVar) {
        f0.a(this.f313f, (g) cVar, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f315h.g(pVar);
    }
}
