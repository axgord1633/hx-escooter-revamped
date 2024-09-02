package kotlinx.coroutines.scheduling;

import c4.k0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import m3.q;

public final class a implements Executor, Closeable {

    /* renamed from: l  reason: collision with root package name */
    public static final C0086a f5641l = new C0086a((g) null);

    /* renamed from: m  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f5642m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: n  reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f5643n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: o  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f5644o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: p  reason: collision with root package name */
    public static final b0 f5645p = new b0("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* renamed from: e  reason: collision with root package name */
    public final int f5646e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5647f;

    /* renamed from: g  reason: collision with root package name */
    public final long f5648g;

    /* renamed from: h  reason: collision with root package name */
    public final String f5649h;

    /* renamed from: i  reason: collision with root package name */
    public final d f5650i;

    /* renamed from: j  reason: collision with root package name */
    public final d f5651j;

    /* renamed from: k  reason: collision with root package name */
    public final y<c> f5652k;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: kotlinx.coroutines.scheduling.a$a  reason: collision with other inner class name */
    public static final class C0086a {
        private C0086a() {
        }

        public /* synthetic */ C0086a(g gVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5653a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f5653a = iArr;
        }
    }

    public final class c extends Thread {

        /* renamed from: l  reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f5654l = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: e  reason: collision with root package name */
        public final o f5655e;

        /* renamed from: f  reason: collision with root package name */
        public d f5656f;

        /* renamed from: g  reason: collision with root package name */
        private long f5657g;

        /* renamed from: h  reason: collision with root package name */
        private long f5658h;

        /* renamed from: i  reason: collision with root package name */
        private int f5659i;
        private volatile int indexInArray;

        /* renamed from: j  reason: collision with root package name */
        public boolean f5660j;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f5655e = new o();
            this.f5656f = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f5645p;
            this.f5659i = w3.c.f7584e.b();
        }

        public c(a aVar, int i5) {
            this();
            o(i5);
        }

        private final void b(int i5) {
            if (i5 != 0) {
                a.f5643n.addAndGet(a.this, -2097152);
                if (this.f5656f != d.TERMINATED) {
                    this.f5656f = d.DORMANT;
                }
            }
        }

        private final void c(int i5) {
            if (i5 != 0 && s(d.BLOCKING)) {
                a.this.B();
            }
        }

        private final void d(h hVar) {
            int b5 = hVar.f5678f.b();
            i(b5);
            c(b5);
            a.this.v(hVar);
            b(b5);
        }

        private final h e(boolean z4) {
            h m5;
            h m6;
            if (z4) {
                boolean z5 = k(a.this.f5646e * 2) == 0;
                if (z5 && (m6 = m()) != null) {
                    return m6;
                }
                h h5 = this.f5655e.h();
                if (h5 != null) {
                    return h5;
                }
                if (!z5 && (m5 = m()) != null) {
                    return m5;
                }
            } else {
                h m7 = m();
                if (m7 != null) {
                    return m7;
                }
            }
            return t(false);
        }

        private final void i(int i5) {
            this.f5657g = 0;
            if (this.f5656f == d.PARKING) {
                this.f5656f = d.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != a.f5645p;
        }

        private final void l() {
            if (this.f5657g == 0) {
                this.f5657g = System.nanoTime() + a.this.f5648g;
            }
            LockSupport.parkNanos(a.this.f5648g);
            if (System.nanoTime() - this.f5657g >= 0) {
                this.f5657g = 0;
                u();
            }
        }

        private final h m() {
            d dVar;
            if (k(2) == 0) {
                h hVar = (h) a.this.f5650i.d();
                if (hVar != null) {
                    return hVar;
                }
                dVar = a.this.f5651j;
            } else {
                h hVar2 = (h) a.this.f5651j.d();
                if (hVar2 != null) {
                    return hVar2;
                }
                dVar = a.this.f5650i;
            }
            return (h) dVar.d();
        }

        private final void n() {
            loop0:
            while (true) {
                boolean z4 = false;
                while (!a.this.isTerminated() && this.f5656f != d.TERMINATED) {
                    h f5 = f(this.f5660j);
                    if (f5 != null) {
                        this.f5658h = 0;
                        d(f5);
                    } else {
                        this.f5660j = false;
                        if (this.f5658h == 0) {
                            r();
                        } else if (!z4) {
                            z4 = true;
                        } else {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f5658h);
                            this.f5658h = 0;
                        }
                    }
                }
            }
            s(d.TERMINATED);
        }

        private final boolean q() {
            boolean z4;
            if (this.f5656f != d.CPU_ACQUIRED) {
                a aVar = a.this;
                while (true) {
                    long j5 = aVar.controlState;
                    if (((int) ((9223367638808264704L & j5) >> 42)) != 0) {
                        if (a.f5643n.compareAndSet(aVar, j5, j5 - 4398046511104L)) {
                            z4 = true;
                            break;
                        }
                    } else {
                        z4 = false;
                        break;
                    }
                }
                if (!z4) {
                    return false;
                }
                this.f5656f = d.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                a.this.n(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.isTerminated() && this.f5656f != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final h t(boolean z4) {
            int i5 = (int) (a.this.controlState & 2097151);
            if (i5 < 2) {
                return null;
            }
            int k5 = k(i5);
            a aVar = a.this;
            long j5 = Long.MAX_VALUE;
            for (int i6 = 0; i6 < i5; i6++) {
                k5++;
                if (k5 > i5) {
                    k5 = 1;
                }
                c b5 = aVar.f5652k.b(k5);
                if (!(b5 == null || b5 == this)) {
                    o oVar = this.f5655e;
                    o oVar2 = b5.f5655e;
                    long k6 = z4 ? oVar.k(oVar2) : oVar.l(oVar2);
                    if (k6 == -1) {
                        return this.f5655e.h();
                    }
                    if (k6 > 0) {
                        j5 = Math.min(j5, k6);
                    }
                }
            }
            if (j5 == Long.MAX_VALUE) {
                j5 = 0;
            }
            this.f5658h = j5;
            return null;
        }

        private final void u() {
            a aVar = a.this;
            synchronized (aVar.f5652k) {
                if (!aVar.isTerminated()) {
                    if (((int) (aVar.controlState & 2097151)) > aVar.f5646e) {
                        if (f5654l.compareAndSet(this, -1, 1)) {
                            int i5 = this.indexInArray;
                            o(0);
                            aVar.q(this, i5, 0);
                            int andDecrement = (int) (a.f5643n.getAndDecrement(aVar) & 2097151);
                            if (andDecrement != i5) {
                                c b5 = aVar.f5652k.b(andDecrement);
                                k.b(b5);
                                c cVar = b5;
                                aVar.f5652k.c(i5, cVar);
                                cVar.o(i5);
                                aVar.q(cVar, andDecrement, i5);
                            }
                            aVar.f5652k.c(andDecrement, null);
                            q qVar = q.f5904a;
                            this.f5656f = d.TERMINATED;
                        }
                    }
                }
            }
        }

        public final h f(boolean z4) {
            h hVar;
            if (q()) {
                return e(z4);
            }
            if (!z4 || (hVar = this.f5655e.h()) == null) {
                hVar = (h) a.this.f5651j.d();
            }
            return hVar == null ? t(true) : hVar;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final int k(int i5) {
            int i6 = this.f5659i;
            int i7 = i6 ^ (i6 << 13);
            int i8 = i7 ^ (i7 >> 17);
            int i9 = i8 ^ (i8 << 5);
            this.f5659i = i9;
            int i10 = i5 - 1;
            return (i10 & i5) == 0 ? i9 & i10 : (i9 & Integer.MAX_VALUE) % i5;
        }

        public final void o(int i5) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f5649h);
            sb.append("-worker-");
            sb.append(i5 == 0 ? "TERMINATED" : String.valueOf(i5));
            setName(sb.toString());
            this.indexInArray = i5;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.f5656f;
            boolean z4 = dVar2 == d.CPU_ACQUIRED;
            if (z4) {
                a.f5643n.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f5656f = dVar;
            }
            return z4;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i5, int i6, long j5, String str) {
        this.f5646e = i5;
        this.f5647f = i6;
        this.f5648g = j5;
        this.f5649h = str;
        boolean z4 = true;
        if (i5 >= 1) {
            if (i6 >= i5) {
                if (i6 <= 2097150) {
                    if (j5 <= 0 ? false : z4) {
                        this.f5650i = new d();
                        this.f5651j = new d();
                        this.parkedWorkersStack = 0;
                        this.f5652k = new y<>(i5 + 1);
                        this.controlState = ((long) i5) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i6 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i6 + " should be greater than or equals to core pool size " + i5).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i5 + " should be at least 1").toString());
    }

    private final h C(c cVar, h hVar, boolean z4) {
        if (cVar == null || cVar.f5656f == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f5678f.b() == 0 && cVar.f5656f == d.BLOCKING) {
            return hVar;
        }
        cVar.f5660j = true;
        return cVar.f5655e.a(hVar, z4);
    }

    private final boolean D(long j5) {
        if (f.a(((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21)), 0) < this.f5646e) {
            int d5 = d();
            if (d5 == 1 && this.f5646e > 1) {
                d();
            }
            if (d5 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean E(a aVar, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j5 = aVar.controlState;
        }
        return aVar.D(j5);
    }

    private final boolean F() {
        c m5;
        do {
            m5 = m();
            if (m5 == null) {
                return false;
            }
        } while (!c.f5654l.compareAndSet(m5, -1, 0));
        LockSupport.unpark(m5);
        return true;
    }

    private final boolean b(h hVar) {
        boolean z4 = true;
        if (hVar.f5678f.b() != 1) {
            z4 = false;
        }
        return (z4 ? this.f5651j : this.f5650i).a(hVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int d() {
        /*
            r10 = this;
            kotlinx.coroutines.internal.y<kotlinx.coroutines.scheduling.a$c> r0 = r10.f5652k
            monitor-enter(r0)
            boolean r1 = r10.isTerminated()     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x000c
            r1 = -1
        L_0x000a:
            monitor-exit(r0)
            return r1
        L_0x000c:
            long r1 = r10.controlState     // Catch:{ all -> 0x007a }
            r3 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r1 & r3
            int r5 = (int) r5     // Catch:{ all -> 0x007a }
            r6 = 4398044413952(0x3ffffe00000, double:2.1729226538177E-311)
            long r1 = r1 & r6
            r6 = 21
            long r1 = r1 >> r6
            int r1 = (int) r1     // Catch:{ all -> 0x007a }
            int r1 = r5 - r1
            r2 = 0
            int r1 = y3.f.a(r1, r2)     // Catch:{ all -> 0x007a }
            int r6 = r10.f5646e     // Catch:{ all -> 0x007a }
            if (r1 < r6) goto L_0x002b
            monitor-exit(r0)
            return r2
        L_0x002b:
            int r6 = r10.f5647f     // Catch:{ all -> 0x007a }
            if (r5 < r6) goto L_0x0031
            monitor-exit(r0)
            return r2
        L_0x0031:
            long r5 = r10.controlState     // Catch:{ all -> 0x007a }
            long r5 = r5 & r3
            int r5 = (int) r5     // Catch:{ all -> 0x007a }
            r6 = 1
            int r5 = r5 + r6
            if (r5 <= 0) goto L_0x0043
            kotlinx.coroutines.internal.y<kotlinx.coroutines.scheduling.a$c> r7 = r10.f5652k     // Catch:{ all -> 0x007a }
            java.lang.Object r7 = r7.b(r5)     // Catch:{ all -> 0x007a }
            if (r7 != 0) goto L_0x0043
            r7 = r6
            goto L_0x0044
        L_0x0043:
            r7 = r2
        L_0x0044:
            if (r7 == 0) goto L_0x006e
            kotlinx.coroutines.scheduling.a$c r7 = new kotlinx.coroutines.scheduling.a$c     // Catch:{ all -> 0x007a }
            r7.<init>(r10, r5)     // Catch:{ all -> 0x007a }
            kotlinx.coroutines.internal.y<kotlinx.coroutines.scheduling.a$c> r8 = r10.f5652k     // Catch:{ all -> 0x007a }
            r8.c(r5, r7)     // Catch:{ all -> 0x007a }
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = f5643n     // Catch:{ all -> 0x007a }
            long r8 = r8.incrementAndGet(r10)     // Catch:{ all -> 0x007a }
            long r3 = r3 & r8
            int r3 = (int) r3     // Catch:{ all -> 0x007a }
            if (r5 != r3) goto L_0x005b
            r2 = r6
        L_0x005b:
            if (r2 == 0) goto L_0x0062
            r7.start()     // Catch:{ all -> 0x007a }
            int r1 = r1 + r6
            goto L_0x000a
        L_0x0062:
            java.lang.String r1 = "Failed requirement."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007a }
            r2.<init>(r1)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x006e:
            java.lang.String r1 = "Failed requirement."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007a }
            r2.<init>(r1)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x007a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.a.d():int");
    }

    private final c g() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !k.a(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void j(a aVar, Runnable runnable, i iVar, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            iVar = l.f5686f;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        aVar.h(runnable, iVar, z4);
    }

    private final int l(c cVar) {
        int g5;
        do {
            Object h5 = cVar.h();
            if (h5 == f5645p) {
                return -1;
            }
            if (h5 == null) {
                return 0;
            }
            cVar = (c) h5;
            g5 = cVar.g();
        } while (g5 == 0);
        return g5;
    }

    private final c m() {
        while (true) {
            long j5 = this.parkedWorkersStack;
            c b5 = this.f5652k.b((int) (2097151 & j5));
            if (b5 == null) {
                return null;
            }
            long j6 = (2097152 + j5) & -2097152;
            int l5 = l(b5);
            if (l5 >= 0) {
                if (f5642m.compareAndSet(this, j5, ((long) l5) | j6)) {
                    b5.p(f5645p);
                    return b5;
                }
            }
        }
    }

    private final void z(boolean z4) {
        long addAndGet = f5643n.addAndGet(this, 2097152);
        if (!z4 && !F() && !D(addAndGet)) {
            F();
        }
    }

    public final void B() {
        if (!F() && !E(this, 0, 1, (Object) null)) {
            F();
        }
    }

    public void close() {
        w(10000);
    }

    public final h e(Runnable runnable, i iVar) {
        long a5 = l.f5685e.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a5, iVar);
        }
        h hVar = (h) runnable;
        hVar.f5677e = a5;
        hVar.f5678f = iVar;
        return hVar;
    }

    public void execute(Runnable runnable) {
        j(this, runnable, (i) null, false, 6, (Object) null);
    }

    public final void h(Runnable runnable, i iVar, boolean z4) {
        c4.c.a();
        h e5 = e(runnable, iVar);
        c g5 = g();
        h C = C(g5, e5, z4);
        if (C == null || b(C)) {
            boolean z5 = z4 && g5 != null;
            if (e5.f5678f.b() != 0) {
                z(z5);
            } else if (!z5) {
                B();
            }
        } else {
            throw new RejectedExecutionException(this.f5649h + " was terminated");
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean n(c cVar) {
        long j5;
        int g5;
        if (cVar.h() != f5645p) {
            return false;
        }
        do {
            j5 = this.parkedWorkersStack;
            g5 = cVar.g();
            cVar.p(this.f5652k.b((int) (2097151 & j5)));
        } while (!f5642m.compareAndSet(this, j5, ((2097152 + j5) & -2097152) | ((long) g5)));
        return true;
    }

    public final void q(c cVar, int i5, int i6) {
        while (true) {
            long j5 = this.parkedWorkersStack;
            int i7 = (int) (2097151 & j5);
            long j6 = (2097152 + j5) & -2097152;
            if (i7 == i5) {
                i7 = i6 == 0 ? l(cVar) : i6;
            }
            if (i7 >= 0) {
                if (f5642m.compareAndSet(this, j5, j6 | ((long) i7))) {
                    return;
                }
            }
        }
    }

    public String toString() {
        char c5;
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        int a5 = this.f5652k.a();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < a5; i10++) {
            c b5 = this.f5652k.b(i10);
            if (b5 != null) {
                int f5 = b5.f5655e.f();
                int i11 = b.f5653a[b5.f5656f.ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        i6++;
                        sb = new StringBuilder();
                        sb.append(f5);
                        c5 = 'b';
                    } else if (i11 == 3) {
                        i5++;
                        sb = new StringBuilder();
                        sb.append(f5);
                        c5 = 'c';
                    } else if (i11 == 4) {
                        i8++;
                        if (f5 > 0) {
                            sb = new StringBuilder();
                            sb.append(f5);
                            c5 = 'd';
                        }
                    } else if (i11 == 5) {
                        i9++;
                    }
                    sb.append(c5);
                    arrayList.add(sb.toString());
                } else {
                    i7++;
                }
            }
        }
        long j5 = this.controlState;
        return this.f5649h + '@' + k0.b(this) + "[Pool Size {core = " + this.f5646e + ", max = " + this.f5647f + "}, Worker States {CPU = " + i5 + ", blocking = " + i6 + ", parked = " + i7 + ", dormant = " + i8 + ", terminated = " + i9 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f5650i.c() + ", global blocking queue size = " + this.f5651j.c() + ", Control State {created workers= " + ((int) (2097151 & j5)) + ", blocking tasks = " + ((int) ((4398044413952L & j5) >> 21)) + ", CPUs acquired = " + (this.f5646e - ((int) ((9223367638808264704L & j5) >> 42))) + "}]";
    }

    public final void v(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            c4.c.a();
            throw th;
        }
        c4.c.a();
    }

    public final void w(long j5) {
        int i5;
        h hVar;
        if (f5644o.compareAndSet(this, 0, 1)) {
            c g5 = g();
            synchronized (this.f5652k) {
                i5 = (int) (this.controlState & 2097151);
            }
            if (1 <= i5) {
                int i6 = 1;
                while (true) {
                    c b5 = this.f5652k.b(i6);
                    k.b(b5);
                    c cVar = b5;
                    if (cVar != g5) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j5);
                        }
                        cVar.f5655e.g(this.f5651j);
                    }
                    if (i6 == i5) {
                        break;
                    }
                    i6++;
                }
            }
            this.f5651j.b();
            this.f5650i.b();
            while (true) {
                if (g5 != null) {
                    hVar = g5.f(true);
                    if (hVar != null) {
                        continue;
                        v(hVar);
                    }
                }
                hVar = (h) this.f5650i.d();
                if (hVar == null && (hVar = (h) this.f5651j.d()) == null) {
                    break;
                }
                v(hVar);
            }
            if (g5 != null) {
                g5.s(d.TERMINATED);
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }
}
