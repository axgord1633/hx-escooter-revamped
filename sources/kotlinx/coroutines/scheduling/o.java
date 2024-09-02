package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class o {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5689b;

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f5690c;

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f5691d;

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f5692e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<h> f5693a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;

    static {
        Class<o> cls = o.class;
        f5689b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f5690c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f5691d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f5692e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public static /* synthetic */ h b(o oVar, h hVar, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return oVar.a(hVar, z4);
    }

    private final h c(h hVar) {
        boolean z4 = true;
        if (hVar.f5678f.b() != 1) {
            z4 = false;
        }
        if (z4) {
            f5692e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i5 = this.producerIndex & 127;
        while (this.f5693a.get(i5) != null) {
            Thread.yield();
        }
        this.f5693a.lazySet(i5, hVar);
        f5690c.incrementAndGet(this);
        return null;
    }

    private final void d(h hVar) {
        if (hVar != null) {
            boolean z4 = true;
            if (hVar.f5678f.b() != 1) {
                z4 = false;
            }
            if (z4) {
                f5692e.decrementAndGet(this);
            }
        }
    }

    private final h i() {
        h andSet;
        while (true) {
            int i5 = this.consumerIndex;
            if (i5 - this.producerIndex == 0) {
                return null;
            }
            int i6 = i5 & 127;
            if (f5691d.compareAndSet(this, i5, i5 + 1) && (andSet = this.f5693a.getAndSet(i6, (Object) null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(d dVar) {
        h i5 = i();
        if (i5 == null) {
            return false;
        }
        dVar.a(i5);
        return true;
    }

    private final long m(o oVar, boolean z4) {
        h hVar;
        do {
            hVar = (h) oVar.lastScheduledTask;
            if (hVar == null) {
                return -2;
            }
            if (z4) {
                boolean z5 = true;
                if (hVar.f5678f.b() != 1) {
                    z5 = false;
                }
                if (!z5) {
                    return -2;
                }
            }
            long a5 = l.f5685e.a() - hVar.f5677e;
            long j5 = l.f5681a;
            if (a5 < j5) {
                return j5 - a5;
            }
        } while (!b.a(f5689b, oVar, hVar, (Object) null));
        b(this, hVar, false, 2, (Object) null);
        return -1;
    }

    public final h a(h hVar, boolean z4) {
        if (z4) {
            return c(hVar);
        }
        h hVar2 = (h) f5689b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(d dVar) {
        h hVar = (h) f5689b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (j(dVar));
    }

    public final h h() {
        h hVar = (h) f5689b.getAndSet(this, (Object) null);
        return hVar == null ? i() : hVar;
    }

    public final long k(o oVar) {
        int i5 = oVar.consumerIndex;
        int i6 = oVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = oVar.f5693a;
        while (true) {
            boolean z4 = true;
            if (i5 == i6) {
                break;
            }
            int i7 = i5 & 127;
            if (oVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i7);
            if (hVar != null) {
                if (hVar.f5678f.b() != 1) {
                    z4 = false;
                }
                if (z4 && n.a(atomicReferenceArray, i7, hVar, (Object) null)) {
                    f5692e.decrementAndGet(oVar);
                    b(this, hVar, false, 2, (Object) null);
                    return -1;
                }
            }
            i5++;
        }
        return m(oVar, true);
    }

    public final long l(o oVar) {
        h i5 = oVar.i();
        if (i5 == null) {
            return m(oVar, false);
        }
        b(this, i5, false, 2, (Object) null);
        return -1;
    }
}
