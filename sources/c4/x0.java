package c4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.internal.q;
import o3.g;

public abstract class x0 extends y0 implements n0 {

    /* renamed from: j  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3190j;

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3191k;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;
    private volatile /* synthetic */ Object _queue = null;

    public static abstract class a implements Runnable, Comparable<a>, u0, h0 {
        private volatile Object _heap;

        /* renamed from: e  reason: collision with root package name */
        public long f3192e;

        /* renamed from: f  reason: collision with root package name */
        private int f3193f;

        public void c(g0<?> g0Var) {
            if (this._heap != a1.f3100a) {
                this._heap = g0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj != a1.f3100a) {
                b bVar = obj instanceof b ? (b) obj : null;
                if (bVar != null) {
                    bVar.g(this);
                }
                this._heap = a1.f3100a;
            }
        }

        public int getIndex() {
            return this.f3193f;
        }

        public g0<?> i() {
            Object obj = this._heap;
            if (obj instanceof g0) {
                return (g0) obj;
            }
            return null;
        }

        /* renamed from: l */
        public int compareTo(a aVar) {
            int i5 = ((this.f3192e - aVar.f3192e) > 0 ? 1 : ((this.f3192e - aVar.f3192e) == 0 ? 0 : -1));
            if (i5 > 0) {
                return 1;
            }
            return i5 < 0 ? -1 : 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0046, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
            return r8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized int m(long r8, c4.x0.b r10, c4.x0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7._heap     // Catch:{ all -> 0x004b }
                kotlinx.coroutines.internal.b0 r1 = c4.a1.f3100a     // Catch:{ all -> 0x004b }
                if (r0 != r1) goto L_0x000c
                r8 = 2
            L_0x000a:
                monitor-exit(r7)
                return r8
            L_0x000c:
                monitor-enter(r10)     // Catch:{ all -> 0x004b }
                kotlinx.coroutines.internal.h0 r0 = r10.b()     // Catch:{ all -> 0x0048 }
                c4.x0$a r0 = (c4.x0.a) r0     // Catch:{ all -> 0x0048 }
                boolean r11 = r11.g0()     // Catch:{ all -> 0x0048 }
                if (r11 == 0) goto L_0x001d
                r8 = 1
                monitor-exit(r10)     // Catch:{ all -> 0x004b }
                monitor-exit(r7)
                return r8
            L_0x001d:
                r1 = 0
                if (r0 != 0) goto L_0x0024
            L_0x0021:
                r10.f3194b = r8     // Catch:{ all -> 0x0048 }
                goto L_0x0037
            L_0x0024:
                long r3 = r0.f3192e     // Catch:{ all -> 0x0048 }
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L_0x002d
                goto L_0x002e
            L_0x002d:
                r8 = r3
            L_0x002e:
                long r3 = r10.f3194b     // Catch:{ all -> 0x0048 }
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L_0x0037
                goto L_0x0021
            L_0x0037:
                long r8 = r7.f3192e     // Catch:{ all -> 0x0048 }
                long r3 = r10.f3194b     // Catch:{ all -> 0x0048 }
                long r8 = r8 - r3
                int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r8 >= 0) goto L_0x0042
                r7.f3192e = r3     // Catch:{ all -> 0x0048 }
            L_0x0042:
                r10.a(r7)     // Catch:{ all -> 0x0048 }
                monitor-exit(r10)     // Catch:{ all -> 0x004b }
                r8 = 0
                goto L_0x000a
            L_0x0048:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x004b }
                throw r8     // Catch:{ all -> 0x004b }
            L_0x004b:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: c4.x0.a.m(long, c4.x0$b, c4.x0):int");
        }

        public final boolean n(long j5) {
            return j5 - this.f3192e >= 0;
        }

        public void setIndex(int i5) {
            this.f3193f = i5;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f3192e + ']';
        }
    }

    public static final class b extends g0<a> {

        /* renamed from: b  reason: collision with root package name */
        public long f3194b;

        public b(long j5) {
            this.f3194b = j5;
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<x0> cls2 = x0.class;
        f3190j = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        f3191k = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
    }

    private final void c0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f3190j, this, (Object) null, a1.f3101b)) {
                    return;
                }
            } else if (obj instanceof q) {
                ((q) obj).d();
                return;
            } else if (obj != a1.f3101b) {
                q qVar = new q(8, true);
                qVar.a((Runnable) obj);
                if (androidx.concurrent.futures.b.a(f3190j, this, obj, qVar)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable d0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof q) {
                q qVar = (q) obj;
                Object j5 = qVar.j();
                if (j5 != q.f5624h) {
                    return (Runnable) j5;
                }
                androidx.concurrent.futures.b.a(f3190j, this, obj, qVar.i());
            } else if (obj == a1.f3101b) {
                return null;
            } else {
                if (androidx.concurrent.futures.b.a(f3190j, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean f0(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (g0()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f3190j, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof q) {
                q qVar = (q) obj;
                int a5 = qVar.a(runnable);
                if (a5 == 0) {
                    return true;
                }
                if (a5 == 1) {
                    androidx.concurrent.futures.b.a(f3190j, this, obj, qVar.i());
                } else if (a5 == 2) {
                    return false;
                }
            } else if (obj == a1.f3101b) {
                return false;
            } else {
                q qVar2 = new q(8, true);
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (androidx.concurrent.futures.b.a(f3190j, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    /* access modifiers changed from: private */
    public final boolean g0() {
        return this._isCompleted;
    }

    private final void j0() {
        a aVar;
        c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar != null && (aVar = (a) bVar.i()) != null) {
                Z(nanoTime, aVar);
            } else {
                return;
            }
        }
    }

    private final int m0(long j5, a aVar) {
        if (g0()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            androidx.concurrent.futures.b.a(f3191k, this, (Object) null, new b(j5));
            Object obj = this._delayed;
            k.b(obj);
            bVar = (b) obj;
        }
        return aVar.m(j5, bVar, this);
    }

    private final void n0(boolean z4) {
        this._isCompleted = z4 ? 1 : 0;
    }

    private final boolean o0(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar != null ? (a) bVar.e() : null) == aVar;
    }

    public final void M(g gVar, Runnable runnable) {
        e0(runnable);
    }

    /* access modifiers changed from: protected */
    public long S() {
        a aVar;
        if (super.S() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof q)) {
                return obj == a1.f3101b ? Long.MAX_VALUE : 0;
            }
            if (!((q) obj).g()) {
                return 0;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (aVar = (a) bVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j5 = aVar.f3192e;
        c.a();
        return f.b(j5 - System.nanoTime(), 0);
    }

    public void e0(Runnable runnable) {
        if (f0(runnable)) {
            a0();
        } else {
            l0.f3140l.e0(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean h0() {
        if (!W()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof q) {
                return ((q) obj).g();
            }
            if (obj != a1.f3101b) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long i0() {
        /*
            r9 = this;
            boolean r0 = r9.X()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r9._delayed
            c4.x0$b r0 = (c4.x0.b) r0
            if (r0 == 0) goto L_0x0045
            boolean r3 = r0.d()
            if (r3 != 0) goto L_0x0045
            c4.c.a()
            long r3 = java.lang.System.nanoTime()
        L_0x001c:
            monitor-enter(r0)
            kotlinx.coroutines.internal.h0 r5 = r0.b()     // Catch:{ all -> 0x0042 }
            r6 = 0
            if (r5 != 0) goto L_0x0026
        L_0x0024:
            monitor-exit(r0)
            goto L_0x003d
        L_0x0026:
            c4.x0$a r5 = (c4.x0.a) r5     // Catch:{ all -> 0x0042 }
            boolean r7 = r5.n(r3)     // Catch:{ all -> 0x0042 }
            r8 = 0
            if (r7 == 0) goto L_0x0034
            boolean r5 = r9.f0(r5)     // Catch:{ all -> 0x0042 }
            goto L_0x0035
        L_0x0034:
            r5 = r8
        L_0x0035:
            if (r5 == 0) goto L_0x0024
            kotlinx.coroutines.internal.h0 r5 = r0.h(r8)     // Catch:{ all -> 0x0042 }
            r6 = r5
            goto L_0x0024
        L_0x003d:
            c4.x0$a r6 = (c4.x0.a) r6
            if (r6 != 0) goto L_0x001c
            goto L_0x0045
        L_0x0042:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0045:
            java.lang.Runnable r0 = r9.d0()
            if (r0 == 0) goto L_0x004f
            r0.run()
            return r1
        L_0x004f:
            long r0 = r9.S()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.x0.i0():long");
    }

    /* access modifiers changed from: protected */
    public final void k0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void l0(long j5, a aVar) {
        int m02 = m0(j5, aVar);
        if (m02 != 0) {
            if (m02 == 1) {
                Z(j5, aVar);
            } else if (m02 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (o0(aVar)) {
            a0();
        }
    }

    public void shutdown() {
        c2.f3110a.b();
        n0(true);
        c0();
        do {
        } while (i0() <= 0);
        j0();
    }
}
