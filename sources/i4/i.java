package i4;

import j4.c;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import l4.d;
import l4.g;

public final class i {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f5086g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.E("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    private final int f5087a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5088b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f5089c;

    /* renamed from: d  reason: collision with root package name */
    private final Deque<l4.c> f5090d;

    /* renamed from: e  reason: collision with root package name */
    final d f5091e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5092f;

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                i4.i r0 = i4.i.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.a(r1)
                r2 = -1
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                i4.i r2 = i4.i.this
                monitor-enter(r2)
                i4.i r3 = i4.i.this     // Catch:{ InterruptedException -> 0x002a }
                int r0 = (int) r0     // Catch:{ InterruptedException -> 0x002a }
                r3.wait(r4, r0)     // Catch:{ InterruptedException -> 0x002a }
                goto L_0x002a
            L_0x0028:
                r0 = move-exception
                goto L_0x002c
            L_0x002a:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                goto L_0x0000
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: i4.i.a.run():void");
        }
    }

    public i() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public i(int i5, long j5, TimeUnit timeUnit) {
        this.f5089c = new a();
        this.f5090d = new ArrayDeque();
        this.f5091e = new d();
        this.f5087a = i5;
        this.f5088b = timeUnit.toNanos(j5);
        if (j5 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j5);
        }
    }

    private int e(l4.c cVar, long j5) {
        List<Reference<g>> list = cVar.f5787n;
        int i5 = 0;
        while (i5 < list.size()) {
            Reference reference = list.get(i5);
            if (reference.get() != null) {
                i5++;
            } else {
                p4.i.l().t("A connection to " + cVar.p().a().l() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f5816a);
                list.remove(i5);
                cVar.f5784k = true;
                if (list.isEmpty()) {
                    cVar.f5788o = j5 - this.f5088b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public long a(long j5) {
        synchronized (this) {
            l4.c cVar = null;
            long j6 = Long.MIN_VALUE;
            int i5 = 0;
            int i6 = 0;
            for (l4.c next : this.f5090d) {
                if (e(next, j5) > 0) {
                    i6++;
                } else {
                    i5++;
                    long j7 = j5 - next.f5788o;
                    if (j7 > j6) {
                        cVar = next;
                        j6 = j7;
                    }
                }
            }
            long j8 = this.f5088b;
            if (j6 < j8) {
                if (i5 <= this.f5087a) {
                    if (i5 > 0) {
                        long j9 = j8 - j6;
                        return j9;
                    } else if (i6 > 0) {
                        return j8;
                    } else {
                        this.f5092f = false;
                        return -1;
                    }
                }
            }
            this.f5090d.remove(cVar);
            c.f(cVar.q());
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(l4.c cVar) {
        if (cVar.f5784k || this.f5087a == 0) {
            this.f5090d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Socket c(a aVar, g gVar) {
        for (l4.c next : this.f5090d) {
            if (next.l(aVar, (b0) null) && next.n() && next != gVar.d()) {
                return gVar.m(next);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public l4.c d(a aVar, g gVar, b0 b0Var) {
        for (l4.c next : this.f5090d) {
            if (next.l(aVar, b0Var)) {
                gVar.a(next, true);
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void f(l4.c cVar) {
        if (!this.f5092f) {
            this.f5092f = true;
            f5086g.execute(this.f5089c);
        }
        this.f5090d.add(cVar);
    }
}
