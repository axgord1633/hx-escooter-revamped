package x2;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m2.g;
import u2.f;
import u2.h;
import u2.i;
import u4.c;
import v0.f0;

public final class e<T, U> extends a<T, U> {

    static final class a<T, U> extends AtomicReference<c> implements g<U>, p2.c {

        /* renamed from: e  reason: collision with root package name */
        final long f7643e;

        /* renamed from: f  reason: collision with root package name */
        final b<T, U> f7644f;

        /* renamed from: g  reason: collision with root package name */
        final int f7645g;

        /* renamed from: h  reason: collision with root package name */
        final int f7646h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f7647i;

        /* renamed from: j  reason: collision with root package name */
        volatile i<U> f7648j;

        /* renamed from: k  reason: collision with root package name */
        long f7649k;

        /* renamed from: l  reason: collision with root package name */
        int f7650l;

        a(b<T, U> bVar, long j5) {
            this.f7643e = j5;
            this.f7644f = bVar;
            int i5 = bVar.f7657i;
            this.f7646h = i5;
            this.f7645g = i5 >> 2;
        }

        public void a() {
            this.f7647i = true;
            this.f7644f.j();
        }

        /* access modifiers changed from: package-private */
        public void b(long j5) {
            if (this.f7650l != 1) {
                long j6 = this.f7649k + j5;
                if (j6 >= ((long) this.f7645g)) {
                    this.f7649k = 0;
                    ((c) get()).f(j6);
                    return;
                }
                this.f7649k = j6;
            }
        }

        public void d(U u5) {
            if (this.f7650l != 2) {
                this.f7644f.p(u5, this);
            } else {
                this.f7644f.j();
            }
        }

        public void dispose() {
            f3.g.c(this);
        }

        public void e(c cVar) {
            if (f3.g.o(this, cVar)) {
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int i5 = fVar.i(7);
                    if (i5 == 1) {
                        this.f7650l = i5;
                        this.f7648j = fVar;
                        this.f7647i = true;
                        this.f7644f.j();
                        return;
                    } else if (i5 == 2) {
                        this.f7650l = i5;
                        this.f7648j = fVar;
                    }
                }
                cVar.f((long) this.f7646h);
            }
        }

        public boolean f() {
            return get() == f3.g.CANCELLED;
        }

        public void onError(Throwable th) {
            lazySet(f3.g.CANCELLED);
            this.f7644f.n(this, th);
        }
    }

    static final class b<T, U> extends AtomicInteger implements g<T>, c {

        /* renamed from: v  reason: collision with root package name */
        static final a<?, ?>[] f7651v = new a[0];

        /* renamed from: w  reason: collision with root package name */
        static final a<?, ?>[] f7652w = new a[0];

        /* renamed from: e  reason: collision with root package name */
        final u4.b<? super U> f7653e;

        /* renamed from: f  reason: collision with root package name */
        final r2.f<? super T, ? extends u4.a<? extends U>> f7654f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f7655g;

        /* renamed from: h  reason: collision with root package name */
        final int f7656h;

        /* renamed from: i  reason: collision with root package name */
        final int f7657i;

        /* renamed from: j  reason: collision with root package name */
        volatile h<U> f7658j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f7659k;

        /* renamed from: l  reason: collision with root package name */
        final g3.b f7660l = new g3.b();

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f7661m;

        /* renamed from: n  reason: collision with root package name */
        final AtomicReference<a<?, ?>[]> f7662n;

        /* renamed from: o  reason: collision with root package name */
        final AtomicLong f7663o;

        /* renamed from: p  reason: collision with root package name */
        c f7664p;

        /* renamed from: q  reason: collision with root package name */
        long f7665q;

        /* renamed from: r  reason: collision with root package name */
        long f7666r;

        /* renamed from: s  reason: collision with root package name */
        int f7667s;

        /* renamed from: t  reason: collision with root package name */
        int f7668t;

        /* renamed from: u  reason: collision with root package name */
        final int f7669u;

        b(u4.b<? super U> bVar, r2.f<? super T, ? extends u4.a<? extends U>> fVar, boolean z4, int i5, int i6) {
            AtomicReference<a<?, ?>[]> atomicReference = new AtomicReference<>();
            this.f7662n = atomicReference;
            this.f7663o = new AtomicLong();
            this.f7653e = bVar;
            this.f7654f = fVar;
            this.f7655g = z4;
            this.f7656h = i5;
            this.f7657i = i6;
            this.f7669u = Math.max(1, i5 >> 1);
            atomicReference.lazySet(f7651v);
        }

        public void a() {
            if (!this.f7659k) {
                this.f7659k = true;
                j();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f7662n.get();
                if (aVarArr == f7652w) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!f0.a(this.f7662n, aVarArr, aVarArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f7661m) {
                h();
                return true;
            } else if (this.f7655g || this.f7660l.get() == null) {
                return false;
            } else {
                h();
                Throwable b5 = this.f7660l.b();
                if (b5 != g3.f.f4747a) {
                    this.f7653e.onError(b5);
                }
                return true;
            }
        }

        public void cancel() {
            h<U> hVar;
            if (!this.f7661m) {
                this.f7661m = true;
                this.f7664p.cancel();
                i();
                if (getAndIncrement() == 0 && (hVar = this.f7658j) != null) {
                    hVar.clear();
                }
            }
        }

        public void d(T t5) {
            if (!this.f7659k) {
                try {
                    u4.a aVar = (u4.a) t2.b.e(this.f7654f.apply(t5), "The mapper returned a null Publisher");
                    if (aVar instanceof Callable) {
                        try {
                            Object call = ((Callable) aVar).call();
                            if (call != null) {
                                q(call);
                            } else if (this.f7656h != Integer.MAX_VALUE && !this.f7661m) {
                                int i5 = this.f7668t + 1;
                                this.f7668t = i5;
                                int i6 = this.f7669u;
                                if (i5 == i6) {
                                    this.f7668t = 0;
                                    this.f7664p.f((long) i6);
                                }
                            }
                        } catch (Throwable th) {
                            q2.b.b(th);
                            this.f7660l.a(th);
                            j();
                        }
                    } else {
                        long j5 = this.f7665q;
                        this.f7665q = 1 + j5;
                        a aVar2 = new a(this, j5);
                        if (b(aVar2)) {
                            aVar.a(aVar2);
                        }
                    }
                } catch (Throwable th2) {
                    q2.b.b(th2);
                    this.f7664p.cancel();
                    onError(th2);
                }
            }
        }

        public void e(c cVar) {
            if (f3.g.q(this.f7664p, cVar)) {
                this.f7664p = cVar;
                this.f7653e.e(this);
                if (!this.f7661m) {
                    int i5 = this.f7656h;
                    cVar.f(i5 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i5);
                }
            }
        }

        public void f(long j5) {
            if (f3.g.p(j5)) {
                g3.c.a(this.f7663o, j5);
                j();
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            h<U> hVar = this.f7658j;
            if (hVar != null) {
                hVar.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2 = (a[]) this.f7662n.get();
            a<?, ?>[] aVarArr3 = f7652w;
            if (aVarArr2 != aVarArr3 && (aVarArr = (a[]) this.f7662n.getAndSet(aVarArr3)) != aVarArr3) {
                for (a<?, ?> dispose : aVarArr) {
                    dispose.dispose();
                }
                Throwable b5 = this.f7660l.b();
                if (b5 != null && b5 != g3.f.f4747a) {
                    j3.a.r(b5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            if (getAndIncrement() == 0) {
                k();
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            long j5;
            boolean z4;
            long j6;
            long j7;
            int i5;
            long j8;
            u4.b<? super U> bVar = this.f7653e;
            int i6 = 1;
            while (!c()) {
                h<U> hVar = this.f7658j;
                long j9 = this.f7663o.get();
                boolean z5 = j9 == Long.MAX_VALUE;
                long j10 = 0;
                long j11 = 0;
                if (hVar != null) {
                    while (true) {
                        long j12 = 0;
                        U u5 = null;
                        while (true) {
                            if (j9 == 0) {
                                break;
                            }
                            U poll = hVar.poll();
                            if (!c()) {
                                if (poll == null) {
                                    u5 = poll;
                                    break;
                                }
                                bVar.d(poll);
                                j11++;
                                j12++;
                                j9--;
                                u5 = poll;
                            } else {
                                return;
                            }
                        }
                        if (j12 != 0) {
                            j9 = z5 ? Long.MAX_VALUE : this.f7663o.addAndGet(-j12);
                        }
                        if (j9 == 0 || u5 == null) {
                            break;
                        }
                    }
                }
                boolean z6 = this.f7659k;
                h<U> hVar2 = this.f7658j;
                a[] aVarArr = (a[]) this.f7662n.get();
                int length = aVarArr.length;
                if (!z6 || ((hVar2 != null && !hVar2.isEmpty()) || length != 0)) {
                    int i7 = i6;
                    if (length != 0) {
                        long j13 = this.f7666r;
                        int i8 = this.f7667s;
                        if (length <= i8 || aVarArr[i8].f7643e != j13) {
                            if (length <= i8) {
                                i8 = 0;
                            }
                            for (int i9 = 0; i9 < length && aVarArr[i8].f7643e != j13; i9++) {
                                i8++;
                                if (i8 == length) {
                                    i8 = 0;
                                }
                            }
                            this.f7667s = i8;
                            this.f7666r = aVarArr[i8].f7643e;
                        }
                        int i10 = i8;
                        boolean z7 = false;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                z4 = z7;
                                break;
                            } else if (!c()) {
                                a aVar = aVarArr[i10];
                                U u6 = null;
                                while (!c()) {
                                    i<U> iVar = aVar.f7648j;
                                    int i12 = length;
                                    if (iVar != null) {
                                        U u7 = u6;
                                        long j14 = j10;
                                        while (true) {
                                            if (j5 == j10) {
                                                break;
                                            }
                                            try {
                                                U poll2 = iVar.poll();
                                                if (poll2 == null) {
                                                    u7 = poll2;
                                                    j10 = 0;
                                                    break;
                                                }
                                                bVar.d(poll2);
                                                if (!c()) {
                                                    j5--;
                                                    j14++;
                                                    u7 = poll2;
                                                    j10 = 0;
                                                } else {
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                Throwable th2 = th;
                                                q2.b.b(th2);
                                                aVar.dispose();
                                                this.f7660l.a(th2);
                                                if (!this.f7655g) {
                                                    this.f7664p.cancel();
                                                }
                                                if (!c()) {
                                                    o(aVar);
                                                    i11++;
                                                    z7 = true;
                                                    i5 = 1;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        if (j14 != j10) {
                                            j5 = !z5 ? this.f7663o.addAndGet(-j14) : Long.MAX_VALUE;
                                            aVar.b(j14);
                                            j8 = 0;
                                        } else {
                                            j8 = j10;
                                        }
                                        if (!(j5 == j8 || u7 == null)) {
                                            length = i12;
                                            u6 = u7;
                                            j10 = 0;
                                        }
                                    }
                                    boolean z8 = aVar.f7647i;
                                    i<U> iVar2 = aVar.f7648j;
                                    if (z8 && (iVar2 == null || iVar2.isEmpty())) {
                                        o(aVar);
                                        if (!c()) {
                                            j11++;
                                            z7 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j5 == 0) {
                                        z4 = z7;
                                        break;
                                    }
                                    i10++;
                                    if (i10 == i12) {
                                        i10 = 0;
                                    }
                                    i5 = 1;
                                    i11 += i5;
                                    length = i12;
                                    j10 = 0;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        this.f7667s = i10;
                        this.f7666r = aVarArr[i10].f7643e;
                        j7 = j11;
                        j6 = 0;
                    } else {
                        j6 = 0;
                        j7 = j11;
                        z4 = false;
                    }
                    if (j7 != j6 && !this.f7661m) {
                        this.f7664p.f(j7);
                    }
                    if (z4) {
                        i6 = i7;
                    } else {
                        i6 = addAndGet(-i7);
                        if (i6 == 0) {
                            return;
                        }
                    }
                } else {
                    Throwable b5 = this.f7660l.b();
                    if (b5 == g3.f.f4747a) {
                        return;
                    }
                    if (b5 == null) {
                        bVar.a();
                        return;
                    } else {
                        bVar.onError(b5);
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public i<U> l(a<T, U> aVar) {
            i<U> iVar = aVar.f7648j;
            if (iVar != null) {
                return iVar;
            }
            c3.b bVar = new c3.b(this.f7657i);
            aVar.f7648j = bVar;
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public i<U> m() {
            h<U> hVar = this.f7658j;
            if (hVar == null) {
                hVar = this.f7656h == Integer.MAX_VALUE ? new c3.c<>(this.f7657i) : new c3.b<>(this.f7656h);
                this.f7658j = hVar;
            }
            return hVar;
        }

        /* access modifiers changed from: package-private */
        public void n(a<T, U> aVar, Throwable th) {
            if (this.f7660l.a(th)) {
                aVar.f7647i = true;
                if (!this.f7655g) {
                    this.f7664p.cancel();
                    for (a dispose : (a[]) this.f7662n.getAndSet(f7652w)) {
                        dispose.dispose();
                    }
                }
                j();
                return;
            }
            j3.a.r(th);
        }

        /* access modifiers changed from: package-private */
        public void o(a<T, U> aVar) {
            a<T, U>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = (a[]) this.f7662n.get();
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
                            aVarArr2 = f7651v;
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
            } while (!f0.a(this.f7662n, aVarArr, aVarArr2));
        }

        public void onError(Throwable th) {
            if (this.f7659k) {
                j3.a.r(th);
            } else if (this.f7660l.a(th)) {
                this.f7659k = true;
                if (!this.f7655g) {
                    for (a dispose : (a[]) this.f7662n.getAndSet(f7652w)) {
                        dispose.dispose();
                    }
                }
                j();
            } else {
                j3.a.r(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void p(U u5, a<T, U> aVar) {
            q2.c cVar;
            if (get() != 0 || !compareAndSet(0, 1)) {
                i iVar = aVar.f7648j;
                if (iVar == null) {
                    iVar = new c3.b(this.f7657i);
                    aVar.f7648j = iVar;
                }
                if (!iVar.offer(u5)) {
                    cVar = new q2.c("Inner queue full?!");
                } else {
                    if (getAndIncrement() != 0) {
                        return;
                    }
                    k();
                    return;
                }
            } else {
                long j5 = this.f7663o.get();
                i<U> iVar2 = aVar.f7648j;
                if (j5 == 0 || (iVar2 != null && !iVar2.isEmpty())) {
                    if (iVar2 == null) {
                        iVar2 = l(aVar);
                    }
                    if (!iVar2.offer(u5)) {
                        cVar = new q2.c("Inner queue full?!");
                    }
                } else {
                    this.f7653e.d(u5);
                    if (j5 != Long.MAX_VALUE) {
                        this.f7663o.decrementAndGet();
                    }
                    aVar.b(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                k();
                return;
            }
            onError(cVar);
        }

        /* access modifiers changed from: package-private */
        public void q(U u5) {
            IllegalStateException illegalStateException;
            if (get() == 0 && compareAndSet(0, 1)) {
                long j5 = this.f7663o.get();
                i iVar = this.f7658j;
                if (j5 == 0 || (iVar != null && !iVar.isEmpty())) {
                    if (iVar == null) {
                        iVar = m();
                    }
                    if (!iVar.offer(u5)) {
                        illegalStateException = new IllegalStateException("Scalar queue full?!");
                    }
                } else {
                    this.f7653e.d(u5);
                    if (j5 != Long.MAX_VALUE) {
                        this.f7663o.decrementAndGet();
                    }
                    if (this.f7656h != Integer.MAX_VALUE && !this.f7661m) {
                        int i5 = this.f7668t + 1;
                        this.f7668t = i5;
                        int i6 = this.f7669u;
                        if (i5 == i6) {
                            this.f7668t = 0;
                            this.f7664p.f((long) i6);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                k();
                return;
            } else if (!m().offer(u5)) {
                illegalStateException = new IllegalStateException("Scalar queue full?!");
            } else {
                if (getAndIncrement() != 0) {
                    return;
                }
                k();
                return;
            }
            onError(illegalStateException);
        }
    }

    public static <T, U> g<T> k(u4.b<? super U> bVar, r2.f<? super T, ? extends u4.a<? extends U>> fVar, boolean z4, int i5, int i6) {
        return new b(bVar, fVar, z4, i5, i6);
    }
}
