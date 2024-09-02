package a3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import p2.c;
import r2.f;
import u2.d;
import u2.h;
import u2.i;
import v0.f0;

public final class v<T, U> extends a<T, U> {

    /* renamed from: f  reason: collision with root package name */
    final f<? super T, ? extends n<? extends U>> f367f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f368g;

    /* renamed from: h  reason: collision with root package name */
    final int f369h;

    /* renamed from: i  reason: collision with root package name */
    final int f370i;

    static final class a<T, U> extends AtomicReference<c> implements p<U> {

        /* renamed from: e  reason: collision with root package name */
        final long f371e;

        /* renamed from: f  reason: collision with root package name */
        final b<T, U> f372f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f373g;

        /* renamed from: h  reason: collision with root package name */
        volatile i<U> f374h;

        /* renamed from: i  reason: collision with root package name */
        int f375i;

        a(b<T, U> bVar, long j5) {
            this.f371e = j5;
            this.f372f = bVar;
        }

        public void a() {
            this.f373g = true;
            this.f372f.h();
        }

        public void b() {
            s2.c.c(this);
        }

        public void c(c cVar) {
            if (s2.c.o(this, cVar) && (cVar instanceof d)) {
                d dVar = (d) cVar;
                int i5 = dVar.i(7);
                if (i5 == 1) {
                    this.f375i = i5;
                    this.f374h = dVar;
                    this.f373g = true;
                    this.f372f.h();
                } else if (i5 == 2) {
                    this.f375i = i5;
                    this.f374h = dVar;
                }
            }
        }

        public void d(U u5) {
            if (this.f375i == 0) {
                this.f372f.l(u5, this);
            } else {
                this.f372f.h();
            }
        }

        public void onError(Throwable th) {
            if (this.f372f.f385l.a(th)) {
                b<T, U> bVar = this.f372f;
                if (!bVar.f380g) {
                    bVar.g();
                }
                this.f373g = true;
                this.f372f.h();
                return;
            }
            j3.a.r(th);
        }
    }

    static final class b<T, U> extends AtomicInteger implements c, p<T> {

        /* renamed from: u  reason: collision with root package name */
        static final a<?, ?>[] f376u = new a[0];

        /* renamed from: v  reason: collision with root package name */
        static final a<?, ?>[] f377v = new a[0];

        /* renamed from: e  reason: collision with root package name */
        final p<? super U> f378e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<? extends U>> f379f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f380g;

        /* renamed from: h  reason: collision with root package name */
        final int f381h;

        /* renamed from: i  reason: collision with root package name */
        final int f382i;

        /* renamed from: j  reason: collision with root package name */
        volatile h<U> f383j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f384k;

        /* renamed from: l  reason: collision with root package name */
        final g3.b f385l = new g3.b();

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f386m;

        /* renamed from: n  reason: collision with root package name */
        final AtomicReference<a<?, ?>[]> f387n;

        /* renamed from: o  reason: collision with root package name */
        c f388o;

        /* renamed from: p  reason: collision with root package name */
        long f389p;

        /* renamed from: q  reason: collision with root package name */
        long f390q;

        /* renamed from: r  reason: collision with root package name */
        int f391r;

        /* renamed from: s  reason: collision with root package name */
        Queue<n<? extends U>> f392s;

        /* renamed from: t  reason: collision with root package name */
        int f393t;

        b(p<? super U> pVar, f<? super T, ? extends n<? extends U>> fVar, boolean z4, int i5, int i6) {
            this.f378e = pVar;
            this.f379f = fVar;
            this.f380g = z4;
            this.f381h = i5;
            this.f382i = i6;
            if (i5 != Integer.MAX_VALUE) {
                this.f392s = new ArrayDeque(i5);
            }
            this.f387n = new AtomicReference<>(f376u);
        }

        public void a() {
            if (!this.f384k) {
                this.f384k = true;
                h();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f387n.get();
                if (aVarArr == f377v) {
                    aVar.b();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!f0.a(this.f387n, aVarArr, aVarArr2));
            return true;
        }

        public void c(c cVar) {
            if (s2.c.q(this.f388o, cVar)) {
                this.f388o = cVar;
                this.f378e.c(this);
            }
        }

        public void d(T t5) {
            if (!this.f384k) {
                try {
                    n nVar = (n) t2.b.e(this.f379f.apply(t5), "The mapper returned a null ObservableSource");
                    if (this.f381h != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i5 = this.f393t;
                            if (i5 == this.f381h) {
                                this.f392s.offer(nVar);
                                return;
                            }
                            this.f393t = i5 + 1;
                        }
                    }
                    k(nVar);
                } catch (Throwable th) {
                    q2.b.b(th);
                    this.f388o.dispose();
                    onError(th);
                }
            }
        }

        public void dispose() {
            Throwable b5;
            if (!this.f386m) {
                this.f386m = true;
                if (g() && (b5 = this.f385l.b()) != null && b5 != g3.f.f4747a) {
                    j3.a.r(b5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.f386m) {
                return true;
            }
            Throwable th = (Throwable) this.f385l.get();
            if (this.f380g || th == null) {
                return false;
            }
            g();
            Throwable b5 = this.f385l.b();
            if (b5 != g3.f.f4747a) {
                this.f378e.onError(b5);
            }
            return true;
        }

        public boolean f() {
            return this.f386m;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            a<?, ?>[] aVarArr;
            this.f388o.dispose();
            a<?, ?>[] aVarArr2 = (a[]) this.f387n.get();
            a<?, ?>[] aVarArr3 = f377v;
            if (aVarArr2 == aVarArr3 || (aVarArr = (a[]) this.f387n.getAndSet(aVarArr3)) == aVarArr3) {
                return false;
            }
            for (a<?, ?> b5 : aVarArr) {
                b5.b();
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (getAndIncrement() == 0) {
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int i5;
            int i6;
            p<? super U> pVar = this.f378e;
            int i7 = 1;
            while (!e()) {
                h<U> hVar = this.f383j;
                if (hVar != null) {
                    while (!e()) {
                        U poll = hVar.poll();
                        if (poll != null) {
                            pVar.d(poll);
                        }
                    }
                    return;
                }
                boolean z4 = this.f384k;
                h<U> hVar2 = this.f383j;
                a[] aVarArr = (a[]) this.f387n.get();
                int length = aVarArr.length;
                int i8 = 0;
                if (this.f381h != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i5 = this.f392s.size();
                    }
                } else {
                    i5 = 0;
                }
                if (!z4 || !((hVar2 == null || hVar2.isEmpty()) && length == 0 && i5 == 0)) {
                    if (length != 0) {
                        long j5 = this.f390q;
                        int i9 = this.f391r;
                        if (length <= i9 || aVarArr[i9].f371e != j5) {
                            if (length <= i9) {
                                i9 = 0;
                            }
                            for (int i10 = 0; i10 < length && aVarArr[i9].f371e != j5; i10++) {
                                i9++;
                                if (i9 == length) {
                                    i9 = 0;
                                }
                            }
                            this.f391r = i9;
                            this.f390q = aVarArr[i9].f371e;
                        }
                        int i11 = 0;
                        int i12 = 0;
                        while (i11 < length) {
                            if (!e()) {
                                a aVar = aVarArr[i9];
                                i<U> iVar = aVar.f374h;
                                if (iVar != null) {
                                    while (true) {
                                        try {
                                            U poll2 = iVar.poll();
                                            if (poll2 == null) {
                                                break;
                                            }
                                            pVar.d(poll2);
                                            if (e()) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            q2.b.b(th);
                                            aVar.b();
                                            this.f385l.a(th);
                                            if (!e()) {
                                                j(aVar);
                                                i12++;
                                                i6 = i9 + 1;
                                                if (i6 != length) {
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                                boolean z5 = aVar.f373g;
                                i<U> iVar2 = aVar.f374h;
                                if (z5 && (iVar2 == null || iVar2.isEmpty())) {
                                    j(aVar);
                                    if (!e()) {
                                        i12++;
                                    } else {
                                        return;
                                    }
                                }
                                i6 = i9 + 1;
                                if (i6 != length) {
                                    i11++;
                                }
                                i6 = 0;
                                i11++;
                            } else {
                                return;
                            }
                        }
                        this.f391r = i9;
                        this.f390q = aVarArr[i9].f371e;
                        i8 = i12;
                    }
                    if (i8 == 0) {
                        i7 = addAndGet(-i7);
                        if (i7 == 0) {
                            return;
                        }
                    } else if (this.f381h != Integer.MAX_VALUE) {
                        while (true) {
                            int i13 = i8 - 1;
                            if (i8 == 0) {
                                continue;
                                break;
                            }
                            synchronized (this) {
                                n poll3 = this.f392s.poll();
                                if (poll3 == null) {
                                    this.f393t--;
                                } else {
                                    k(poll3);
                                }
                            }
                            i8 = i13;
                        }
                        while (true) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    Throwable b5 = this.f385l.b();
                    if (b5 == g3.f.f4747a) {
                        return;
                    }
                    if (b5 == null) {
                        pVar.a();
                        return;
                    } else {
                        pVar.onError(b5);
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j(a<T, U> aVar) {
            a<T, U>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = (a[]) this.f387n.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i5 = -1;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (aVarArr[i6] == aVar) {
                            i5 = i6;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (i5 >= 0) {
                        if (length == 1) {
                            aVarArr2 = f376u;
                        } else {
                            a<?, ?>[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i5);
                            System.arraycopy(aVarArr, i5 + 1, aVarArr3, i5, (length - i5) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!f0.a(this.f387n, aVarArr, aVarArr2));
        }

        /* access modifiers changed from: package-private */
        public void k(n<? extends U> nVar) {
            n<? extends U> poll;
            while (nVar instanceof Callable) {
                if (m((Callable) nVar) && this.f381h != Integer.MAX_VALUE) {
                    boolean z4 = false;
                    synchronized (this) {
                        poll = this.f392s.poll();
                        if (poll == null) {
                            this.f393t--;
                            z4 = true;
                        }
                    }
                    if (z4) {
                        h();
                        return;
                    }
                    nVar = poll;
                } else {
                    return;
                }
            }
            long j5 = this.f389p;
            this.f389p = 1 + j5;
            a aVar = new a(this, j5);
            if (b(aVar)) {
                nVar.g(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void l(U u5, a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                i iVar = aVar.f374h;
                if (iVar == null) {
                    iVar = new c3.c(this.f382i);
                    aVar.f374h = iVar;
                }
                iVar.offer(u5);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.f378e.d(u5);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            i();
        }

        /* access modifiers changed from: package-private */
        public boolean m(Callable<? extends U> callable) {
            try {
                Object call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    h<U> hVar = this.f383j;
                    if (hVar == null) {
                        hVar = this.f381h == Integer.MAX_VALUE ? new c3.c<>(this.f382i) : new c3.b<>(this.f381h);
                        this.f383j = hVar;
                    }
                    if (!hVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.f378e.d(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                i();
                return true;
            } catch (Throwable th) {
                q2.b.b(th);
                this.f385l.a(th);
                h();
                return true;
            }
        }

        public void onError(Throwable th) {
            if (this.f384k) {
                j3.a.r(th);
            } else if (this.f385l.a(th)) {
                this.f384k = true;
                h();
            } else {
                j3.a.r(th);
            }
        }
    }

    public v(n<T> nVar, f<? super T, ? extends n<? extends U>> fVar, boolean z4, int i5, int i6) {
        super(nVar);
        this.f367f = fVar;
        this.f368g = z4;
        this.f369h = i5;
        this.f370i = i6;
    }

    public void v0(p<? super U> pVar) {
        if (!s0.b(this.f24e, pVar, this.f367f)) {
            this.f24e.g(new b(pVar, this.f367f, this.f368g, this.f369h, this.f370i));
        }
    }
}
