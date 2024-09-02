package kotlinx.coroutines.internal;

import c4.c0;
import c4.m0;
import c4.n0;
import o3.g;

public final class k extends c0 implements Runnable, n0 {

    /* renamed from: g  reason: collision with root package name */
    private final c0 f5608g;

    /* renamed from: h  reason: collision with root package name */
    private final int f5609h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ n0 f5610i;

    /* renamed from: j  reason: collision with root package name */
    private final p<Runnable> f5611j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f5612k;
    private volatile int runningWorkers;

    public k(c0 c0Var, int i5) {
        this.f5608g = c0Var;
        this.f5609h = i5;
        n0 n0Var = c0Var instanceof n0 ? (n0) c0Var : null;
        this.f5610i = n0Var == null ? m0.a() : n0Var;
        this.f5611j = new p<>(false);
        this.f5612k = new Object();
    }

    private final boolean P(Runnable runnable) {
        this.f5611j.a(runnable);
        return this.runningWorkers >= this.f5609h;
    }

    private final boolean Q() {
        synchronized (this.f5612k) {
            if (this.runningWorkers >= this.f5609h) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    public void M(g gVar, Runnable runnable) {
        if (!P(runnable) && Q()) {
            this.f5608g.M(this, this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r1 = r4.f5612k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.runningWorkers--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r4.f5611j.c() != 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.runningWorkers++;
        r2 = m3.q.f5904a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f5611j
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L_0x002a
            r2.run()     // Catch:{ all -> 0x0010 }
            goto L_0x0016
        L_0x0010:
            r2 = move-exception
            o3.h r3 = o3.h.f6161e
            c4.f0.a(r3, r2)
        L_0x0016:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L_0x0002
            c4.c0 r2 = r4.f5608g
            boolean r2 = r2.N(r4)
            if (r2 == 0) goto L_0x0002
            c4.c0 r0 = r4.f5608g
            r0.M(r4, r4)
            return
        L_0x002a:
            java.lang.Object r1 = r4.f5612k
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + -1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f5611j     // Catch:{ all -> 0x0047 }
            int r2 = r2.c()     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x003d
            monitor-exit(r1)
            return
        L_0x003d:
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            m3.q r2 = m3.q.f5904a     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            goto L_0x0001
        L_0x0047:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.run():void");
    }
}
