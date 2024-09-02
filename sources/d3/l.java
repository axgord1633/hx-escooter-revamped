package d3;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p2.c;
import s2.b;

public final class l extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, c {

    /* renamed from: f  reason: collision with root package name */
    static final Object f4410f = new Object();

    /* renamed from: g  reason: collision with root package name */
    static final Object f4411g = new Object();

    /* renamed from: h  reason: collision with root package name */
    static final Object f4412h = new Object();

    /* renamed from: i  reason: collision with root package name */
    static final Object f4413i = new Object();

    /* renamed from: e  reason: collision with root package name */
    final Runnable f4414e;

    public l(Runnable runnable, b bVar) {
        super(3);
        this.f4414e = runnable;
        lazySet(0, bVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f4413i) {
                if (obj == f4411g) {
                    future.cancel(false);
                    return;
                } else if (obj == f4412h) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public Object call() {
        run();
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r7 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r7.get(r0)
            java.lang.Object r2 = f4413i
            r3 = 0
            if (r1 == r2) goto L_0x0031
            java.lang.Object r2 = f4411g
            if (r1 == r2) goto L_0x0031
            java.lang.Object r4 = f4412h
            if (r1 != r4) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            r5 = 2
            java.lang.Object r5 = r7.get(r5)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            if (r5 == r6) goto L_0x0020
            r5 = r0
            goto L_0x0021
        L_0x0020:
            r5 = r3
        L_0x0021:
            if (r5 == 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            boolean r0 = r7.compareAndSet(r0, r1, r2)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0031
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r5)
        L_0x0031:
            java.lang.Object r0 = r7.get(r3)
            java.lang.Object r1 = f4413i
            if (r0 == r1) goto L_0x004b
            java.lang.Object r1 = f4410f
            if (r0 == r1) goto L_0x004b
            if (r0 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            boolean r1 = r7.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0031
            s2.b r0 = (s2.b) r0
            r0.a(r7)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.l.dispose():void");
    }

    public boolean f() {
        Object obj = get(0);
        return obj == f4410f || obj == f4413i;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.f4414e.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == f4410f || !compareAndSet(0, obj3, f4413i) || obj3 == null)) {
                ((b) obj3).a(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f4411g || obj2 == f4412h || compareAndSet(1, obj2, f4413i)) {
                    throw th;
                }
                obj2 = get(1);
                break;
            } while (compareAndSet(1, obj2, f4413i));
            throw th;
        }
        lazySet(2, (Object) null);
        Object obj4 = get(0);
        if (!(obj4 == f4410f || !compareAndSet(0, obj4, f4413i) || obj4 == null)) {
            ((b) obj4).a(this);
        }
        do {
            obj = get(1);
            if (obj == f4411g || obj == f4412h || compareAndSet(1, obj, f4413i)) {
            }
            obj = get(1);
            return;
        } while (compareAndSet(1, obj, f4413i));
    }
}
