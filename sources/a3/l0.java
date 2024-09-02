package a3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import p2.c;
import s2.f;
import v0.f0;

public final class l0<T> extends h3.a<T> implements f {

    /* renamed from: e  reason: collision with root package name */
    final n<T> f236e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<b<T>> f237f = new AtomicReference<>();

    static final class a<T> extends AtomicReference<b<T>> implements c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f238e;

        a(p<? super T> pVar, b<T> bVar) {
            this.f238e = pVar;
            lazySet(bVar);
        }

        public void dispose() {
            b bVar = (b) getAndSet((Object) null);
            if (bVar != null) {
                bVar.e(this);
            }
        }

        public boolean f() {
            return get() == null;
        }
    }

    static final class b<T> extends AtomicReference<a<T>[]> implements p<T>, c {

        /* renamed from: i  reason: collision with root package name */
        static final a[] f239i = new a[0];

        /* renamed from: j  reason: collision with root package name */
        static final a[] f240j = new a[0];

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f241e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<b<T>> f242f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<c> f243g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f244h;

        b(AtomicReference<b<T>> atomicReference) {
            this.f242f = atomicReference;
            this.f243g = new AtomicReference<>();
            lazySet(f239i);
        }

        public void a() {
            this.f243g.lazySet(s2.c.DISPOSED);
            for (a aVar : (a[]) getAndSet(f240j)) {
                aVar.f238e.a();
            }
        }

        public boolean b(a<T> aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) get();
                if (aVarArr == f240j) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        public void c(c cVar) {
            s2.c.o(this.f243g, cVar);
        }

        public void d(T t5) {
            for (a aVar : (a[]) get()) {
                aVar.f238e.d(t5);
            }
        }

        public void dispose() {
            getAndSet(f240j);
            f0.a(this.f242f, this, (Object) null);
            s2.c.c(this.f243g);
        }

        public void e(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) get();
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
                        aVarArr2 = f239i;
                        if (length != 1) {
                            aVarArr2 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, i5);
                            System.arraycopy(aVarArr, i5 + 1, aVarArr2, i5, (length - i5) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        public boolean f() {
            return get() == f240j;
        }

        public void onError(Throwable th) {
            this.f244h = th;
            this.f243g.lazySet(s2.c.DISPOSED);
            for (a aVar : (a[]) getAndSet(f240j)) {
                aVar.f238e.onError(th);
            }
        }
    }

    public l0(n<T> nVar) {
        this.f236e = nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Q0(r2.e<? super p2.c> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<a3.l0$b<T>> r0 = r4.f237f
            java.lang.Object r0 = r0.get()
            a3.l0$b r0 = (a3.l0.b) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.f()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            a3.l0$b r1 = new a3.l0$b
            java.util.concurrent.atomic.AtomicReference<a3.l0$b<T>> r2 = r4.f237f
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<a3.l0$b<T>> r2 = r4.f237f
            boolean r0 = v0.f0.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f241e
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f241e
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            r5.accept(r0)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            m2.n<T> r5 = r4.f236e
            r5.g(r0)
        L_0x003f:
            return
        L_0x0040:
            r5 = move-exception
            q2.b.b(r5)
            java.lang.RuntimeException r5 = g3.f.d(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.l0.Q0(r2.e):void");
    }

    public void b(c cVar) {
        f0.a(this.f237f, (b) cVar, (Object) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v0(m2.p<? super T> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<a3.l0$b<T>> r0 = r3.f237f
            java.lang.Object r0 = r0.get()
            a3.l0$b r0 = (a3.l0.b) r0
            if (r0 != 0) goto L_0x001b
            a3.l0$b r1 = new a3.l0$b
            java.util.concurrent.atomic.AtomicReference<a3.l0$b<T>> r2 = r3.f237f
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<a3.l0$b<T>> r2 = r3.f237f
            boolean r0 = v0.f0.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001a
            goto L_0x0000
        L_0x001a:
            r0 = r1
        L_0x001b:
            a3.l0$a r1 = new a3.l0$a
            r1.<init>(r4, r0)
            r4.c(r1)
            boolean r2 = r0.b(r1)
            if (r2 == 0) goto L_0x0033
            boolean r4 = r1.f()
            if (r4 == 0) goto L_0x0032
            r0.e(r1)
        L_0x0032:
            return
        L_0x0033:
            java.lang.Throwable r0 = r0.f244h
            if (r0 == 0) goto L_0x003b
            r4.onError(r0)
            goto L_0x003e
        L_0x003b:
            r4.a()
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.l0.v0(m2.p):void");
    }
}
