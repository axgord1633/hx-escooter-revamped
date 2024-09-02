package f3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import t2.b;
import u4.c;

public class f extends AtomicInteger implements c {

    /* renamed from: e  reason: collision with root package name */
    c f4621e;

    /* renamed from: f  reason: collision with root package name */
    long f4622f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<c> f4623g = new AtomicReference<>();

    /* renamed from: h  reason: collision with root package name */
    final AtomicLong f4624h = new AtomicLong();

    /* renamed from: i  reason: collision with root package name */
    final AtomicLong f4625i = new AtomicLong();

    /* renamed from: j  reason: collision with root package name */
    final boolean f4626j;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f4627k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f4628l;

    public f(boolean z4) {
        this.f4626j = z4;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (getAndIncrement() == 0) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int i5 = 1;
        c cVar = null;
        long j5 = 0;
        do {
            c cVar2 = this.f4623g.get();
            if (cVar2 != null) {
                cVar2 = this.f4623g.getAndSet((Object) null);
            }
            long j6 = this.f4624h.get();
            if (j6 != 0) {
                j6 = this.f4624h.getAndSet(0);
            }
            long j7 = this.f4625i.get();
            if (j7 != 0) {
                j7 = this.f4625i.getAndSet(0);
            }
            c cVar3 = this.f4621e;
            if (this.f4627k) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.f4621e = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long j8 = this.f4622f;
                if (j8 != Long.MAX_VALUE) {
                    j8 = g3.c.b(j8, j6);
                    if (j8 != Long.MAX_VALUE) {
                        j8 -= j7;
                        if (j8 < 0) {
                            g.m(j8);
                            j8 = 0;
                        }
                    }
                    this.f4622f = j8;
                }
                if (cVar2 != null) {
                    if (cVar3 != null && this.f4626j) {
                        cVar3.cancel();
                    }
                    this.f4621e = cVar2;
                    if (j8 != 0) {
                        j5 = g3.c.b(j5, j8);
                        cVar = cVar2;
                    }
                } else if (!(cVar3 == null || j6 == 0)) {
                    j5 = g3.c.b(j5, j6);
                    cVar = cVar3;
                }
            }
            i5 = addAndGet(-i5);
        } while (i5 != 0);
        if (j5 != 0) {
            cVar.f(j5);
        }
    }

    public final boolean c() {
        return this.f4627k;
    }

    public void cancel() {
        if (!this.f4627k) {
            this.f4627k = true;
            a();
        }
    }

    public final void d(long j5) {
        if (!this.f4628l) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                g3.c.a(this.f4625i, j5);
                a();
                return;
            }
            long j6 = this.f4622f;
            if (j6 != Long.MAX_VALUE) {
                long j7 = j6 - j5;
                if (j7 < 0) {
                    g.m(j7);
                    j7 = 0;
                }
                this.f4622f = j7;
            }
            if (decrementAndGet() != 0) {
                b();
            }
        }
    }

    public final void e(c cVar) {
        if (this.f4627k) {
            cVar.cancel();
            return;
        }
        b.e(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            c andSet = this.f4623g.getAndSet(cVar);
            if (andSet != null && this.f4626j) {
                andSet.cancel();
            }
            a();
            return;
        }
        c cVar2 = this.f4621e;
        if (cVar2 != null && this.f4626j) {
            cVar2.cancel();
        }
        this.f4621e = cVar;
        long j5 = this.f4622f;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j5 != 0) {
            cVar.f(j5);
        }
    }

    public final void f(long j5) {
        if (g.p(j5) && !this.f4628l) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                g3.c.a(this.f4624h, j5);
                a();
                return;
            }
            long j6 = this.f4622f;
            if (j6 != Long.MAX_VALUE) {
                long b5 = g3.c.b(j6, j5);
                this.f4622f = b5;
                if (b5 == Long.MAX_VALUE) {
                    this.f4628l = true;
                }
            }
            c cVar = this.f4621e;
            if (decrementAndGet() != 0) {
                b();
            }
            if (cVar != null) {
                cVar.f(j5);
            }
        }
    }
}
