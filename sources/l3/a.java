package l3;

import g3.a;
import g3.f;
import g3.h;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m2.p;
import p2.c;
import t2.b;
import v0.f0;

public final class a<T> extends d<T> {

    /* renamed from: l  reason: collision with root package name */
    private static final Object[] f5731l = new Object[0];

    /* renamed from: m  reason: collision with root package name */
    static final C0087a[] f5732m = new C0087a[0];

    /* renamed from: n  reason: collision with root package name */
    static final C0087a[] f5733n = new C0087a[0];

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<Object> f5734e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<C0087a<T>[]> f5735f;

    /* renamed from: g  reason: collision with root package name */
    final ReadWriteLock f5736g;

    /* renamed from: h  reason: collision with root package name */
    final Lock f5737h;

    /* renamed from: i  reason: collision with root package name */
    final Lock f5738i;

    /* renamed from: j  reason: collision with root package name */
    final AtomicReference<Throwable> f5739j;

    /* renamed from: k  reason: collision with root package name */
    long f5740k;

    /* renamed from: l3.a$a  reason: collision with other inner class name */
    static final class C0087a<T> implements c, a.C0080a<Object> {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f5741e;

        /* renamed from: f  reason: collision with root package name */
        final a<T> f5742f;

        /* renamed from: g  reason: collision with root package name */
        boolean f5743g;

        /* renamed from: h  reason: collision with root package name */
        boolean f5744h;

        /* renamed from: i  reason: collision with root package name */
        g3.a<Object> f5745i;

        /* renamed from: j  reason: collision with root package name */
        boolean f5746j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f5747k;

        /* renamed from: l  reason: collision with root package name */
        long f5748l;

        C0087a(p<? super T> pVar, a<T> aVar) {
            this.f5741e = pVar;
            this.f5742f = aVar;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f5747k
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f5747k     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.f5743g     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                l3.a<T> r0 = r4.f5742f     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f5737h     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.f5740k     // Catch:{ all -> 0x003e }
                r4.f5748l = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f5734e     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f5744h = r2     // Catch:{ all -> 0x003e }
                r4.f5743g = r1     // Catch:{ all -> 0x003e }
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x003d
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003a
                return
            L_0x003a:
                r4.b()
            L_0x003d:
                return
            L_0x003e:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: l3.a.C0087a.a():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.c(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f5747k
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                g3.a<java.lang.Object> r0 = r2.f5745i     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f5744h = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f5745i = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.c(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: l3.a.C0087a.b():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.f5746j = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(java.lang.Object r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.f5747k
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.f5746j
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.f5747k     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.f5748l     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.f5744h     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                g3.a<java.lang.Object> r4 = r2.f5745i     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                g3.a r4 = new g3.a     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.f5745i = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.b(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.f5743g = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.f5746j = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l3.a.C0087a.c(java.lang.Object, long):void");
        }

        public void dispose() {
            if (!this.f5747k) {
                this.f5747k = true;
                this.f5742f.T0(this);
            }
        }

        public boolean f() {
            return this.f5747k;
        }

        public boolean test(Object obj) {
            return this.f5747k || h.c(obj, this.f5741e);
        }
    }

    a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f5736g = reentrantReadWriteLock;
        this.f5737h = reentrantReadWriteLock.readLock();
        this.f5738i = reentrantReadWriteLock.writeLock();
        this.f5735f = new AtomicReference<>(f5732m);
        this.f5734e = new AtomicReference<>();
        this.f5739j = new AtomicReference<>();
    }

    a(T t5) {
        this();
        this.f5734e.lazySet(b.e(t5, "defaultValue is null"));
    }

    public static <T> a<T> Q0() {
        return new a<>();
    }

    public static <T> a<T> R0(T t5) {
        return new a<>(t5);
    }

    /* access modifiers changed from: package-private */
    public boolean P0(C0087a<T> aVar) {
        C0087a[] aVarArr;
        C0087a[] aVarArr2;
        do {
            aVarArr = (C0087a[]) this.f5735f.get();
            if (aVarArr == f5733n) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C0087a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!f0.a(this.f5735f, aVarArr, aVarArr2));
        return true;
    }

    public T S0() {
        Object obj = this.f5734e.get();
        if (h.o(obj) || h.p(obj)) {
            return null;
        }
        return h.n(obj);
    }

    /* access modifiers changed from: package-private */
    public void T0(C0087a<T> aVar) {
        C0087a<T>[] aVarArr;
        C0087a[] aVarArr2;
        do {
            aVarArr = (C0087a[]) this.f5735f.get();
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
                        aVarArr2 = f5732m;
                    } else {
                        C0087a[] aVarArr3 = new C0087a[(length - 1)];
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
        } while (!f0.a(this.f5735f, aVarArr, aVarArr2));
    }

    /* access modifiers changed from: package-private */
    public void U0(Object obj) {
        this.f5738i.lock();
        this.f5740k++;
        this.f5734e.lazySet(obj);
        this.f5738i.unlock();
    }

    /* access modifiers changed from: package-private */
    public C0087a<T>[] V0(Object obj) {
        AtomicReference<C0087a<T>[]> atomicReference = this.f5735f;
        C0087a<T>[] aVarArr = f5733n;
        C0087a<T>[] aVarArr2 = (C0087a[]) atomicReference.getAndSet(aVarArr);
        if (aVarArr2 != aVarArr) {
            U0(obj);
        }
        return aVarArr2;
    }

    public void a() {
        if (f0.a(this.f5739j, (Object) null, f.f4747a)) {
            Object i5 = h.i();
            for (C0087a c5 : V0(i5)) {
                c5.c(i5, this.f5740k);
            }
        }
    }

    public void c(c cVar) {
        if (this.f5739j.get() != null) {
            cVar.dispose();
        }
    }

    public void d(T t5) {
        b.e(t5, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f5739j.get() == null) {
            Object q5 = h.q(t5);
            U0(q5);
            for (C0087a c5 : (C0087a[]) this.f5735f.get()) {
                c5.c(q5, this.f5740k);
            }
        }
    }

    public void onError(Throwable th) {
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!f0.a(this.f5739j, (Object) null, th)) {
            j3.a.r(th);
            return;
        }
        Object m5 = h.m(th);
        for (C0087a c5 : V0(m5)) {
            c5.c(m5, this.f5740k);
        }
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        C0087a aVar = new C0087a(pVar, this);
        pVar.c(aVar);
        if (!P0(aVar)) {
            Throwable th = this.f5739j.get();
            if (th == f.f4747a) {
                pVar.a();
            } else {
                pVar.onError(th);
            }
        } else if (aVar.f5747k) {
            T0(aVar);
        } else {
            aVar.a();
        }
    }
}
