package a3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.n;
import m2.p;
import v0.f0;

public final class k0<T> extends h3.a<T> implements m0<T> {

    /* renamed from: e  reason: collision with root package name */
    final n<T> f219e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<b<T>> f220f;

    /* renamed from: g  reason: collision with root package name */
    final n<T> f221g;

    static final class a<T> extends AtomicReference<Object> implements p2.c {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f222e;

        a(p<? super T> pVar) {
            this.f222e = pVar;
        }

        /* access modifiers changed from: package-private */
        public void a(b<T> bVar) {
            if (!compareAndSet((Object) null, bVar)) {
                bVar.e(this);
            }
        }

        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((b) andSet).e(this);
            }
        }

        public boolean f() {
            return get() == this;
        }
    }

    static final class b<T> implements p<T>, p2.c {

        /* renamed from: i  reason: collision with root package name */
        static final a[] f223i = new a[0];

        /* renamed from: j  reason: collision with root package name */
        static final a[] f224j = new a[0];

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<b<T>> f225e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<a<T>[]> f226f = new AtomicReference<>(f223i);

        /* renamed from: g  reason: collision with root package name */
        final AtomicBoolean f227g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<p2.c> f228h = new AtomicReference<>();

        b(AtomicReference<b<T>> atomicReference) {
            this.f225e = atomicReference;
            this.f227g = new AtomicBoolean();
        }

        public void a() {
            f0.a(this.f225e, this, (Object) null);
            for (a aVar : (a[]) this.f226f.getAndSet(f224j)) {
                aVar.f222e.a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<T> aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f226f.get();
                if (aVarArr == f224j) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!f0.a(this.f226f, aVarArr, aVarArr2));
            return true;
        }

        public void c(p2.c cVar) {
            s2.c.o(this.f228h, cVar);
        }

        public void d(T t5) {
            for (a aVar : (a[]) this.f226f.get()) {
                aVar.f222e.d(t5);
            }
        }

        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.f226f;
            a[] aVarArr = f224j;
            if (((a[]) atomicReference.getAndSet(aVarArr)) != aVarArr) {
                f0.a(this.f225e, this, (Object) null);
                s2.c.c(this.f228h);
            }
        }

        /* access modifiers changed from: package-private */
        public void e(a<T> aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f226f.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i5 = -1;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (aVarArr[i6].equals(aVar)) {
                            i5 = i6;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (i5 >= 0) {
                        if (length == 1) {
                            aVarArr2 = f223i;
                        } else {
                            a[] aVarArr3 = new a[(length - 1)];
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
            } while (!f0.a(this.f226f, aVarArr, aVarArr2));
        }

        public boolean f() {
            return this.f226f.get() == f224j;
        }

        public void onError(Throwable th) {
            f0.a(this.f225e, this, (Object) null);
            a[] aVarArr = (a[]) this.f226f.getAndSet(f224j);
            if (aVarArr.length != 0) {
                for (a aVar : aVarArr) {
                    aVar.f222e.onError(th);
                }
                return;
            }
            j3.a.r(th);
        }
    }

    static final class c<T> implements n<T> {

        /* renamed from: e  reason: collision with root package name */
        private final AtomicReference<b<T>> f229e;

        c(AtomicReference<b<T>> atomicReference) {
            this.f229e = atomicReference;
        }

        public void g(p<? super T> pVar) {
            a aVar = new a(pVar);
            pVar.c(aVar);
            while (true) {
                b bVar = this.f229e.get();
                if (bVar == null || bVar.f()) {
                    b bVar2 = new b(this.f229e);
                    if (!f0.a(this.f229e, bVar, bVar2)) {
                        continue;
                    } else {
                        bVar = bVar2;
                    }
                }
                if (bVar.b(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }

    private k0(n<T> nVar, n<T> nVar2, AtomicReference<b<T>> atomicReference) {
        this.f221g = nVar;
        this.f219e = nVar2;
        this.f220f = atomicReference;
    }

    public static <T> h3.a<T> T0(n<T> nVar) {
        AtomicReference atomicReference = new AtomicReference();
        return j3.a.k(new k0(new c(atomicReference), nVar, atomicReference));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Q0(r2.e<? super p2.c> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<a3.k0$b<T>> r0 = r4.f220f
            java.lang.Object r0 = r0.get()
            a3.k0$b r0 = (a3.k0.b) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.f()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            a3.k0$b r1 = new a3.k0$b
            java.util.concurrent.atomic.AtomicReference<a3.k0$b<T>> r2 = r4.f220f
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<a3.k0$b<T>> r2 = r4.f220f
            boolean r0 = v0.f0.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f227g
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f227g
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            r5.accept(r0)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            m2.n<T> r5 = r4.f219e
            r5.g(r0)
        L_0x003f:
            return
        L_0x0040:
            r5 = move-exception
            q2.b.b(r5)
            java.lang.RuntimeException r5 = g3.f.d(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.k0.Q0(r2.e):void");
    }

    public n<T> e() {
        return this.f219e;
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f221g.g(pVar);
    }
}
