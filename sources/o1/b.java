package o1;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m2.p;
import o1.a;
import p2.c;
import v0.f0;

public final class b<T> extends d<T> {

    /* renamed from: j  reason: collision with root package name */
    private static final Object[] f6120j = new Object[0];

    /* renamed from: k  reason: collision with root package name */
    static final a[] f6121k = new a[0];

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<T> f6122e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a<T>[]> f6123f;

    /* renamed from: g  reason: collision with root package name */
    final Lock f6124g;

    /* renamed from: h  reason: collision with root package name */
    final Lock f6125h;

    /* renamed from: i  reason: collision with root package name */
    long f6126i;

    static final class a<T> implements c, a.C0093a<T> {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f6127e;

        /* renamed from: f  reason: collision with root package name */
        final b<T> f6128f;

        /* renamed from: g  reason: collision with root package name */
        boolean f6129g;

        /* renamed from: h  reason: collision with root package name */
        boolean f6130h;

        /* renamed from: i  reason: collision with root package name */
        a<T> f6131i;

        /* renamed from: j  reason: collision with root package name */
        boolean f6132j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f6133k;

        /* renamed from: l  reason: collision with root package name */
        long f6134l;

        a(p<? super T> pVar, b<T> bVar) {
            this.f6127e = pVar;
            this.f6128f = bVar;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            test(r0);
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f6133k
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f6133k     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                return
            L_0x000c:
                boolean r0 = r4.f6129g     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                return
            L_0x0012:
                o1.b<T> r0 = r4.f6128f     // Catch:{ all -> 0x003a }
                java.util.concurrent.locks.Lock r1 = r0.f6124g     // Catch:{ all -> 0x003a }
                r1.lock()     // Catch:{ all -> 0x003a }
                long r2 = r0.f6126i     // Catch:{ all -> 0x003a }
                r4.f6134l = r2     // Catch:{ all -> 0x003a }
                java.util.concurrent.atomic.AtomicReference<T> r0 = r0.f6122e     // Catch:{ all -> 0x003a }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003a }
                r1.unlock()     // Catch:{ all -> 0x003a }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f6130h = r2     // Catch:{ all -> 0x003a }
                r4.f6129g = r1     // Catch:{ all -> 0x003a }
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0039
                r4.test(r0)
                r4.b()
            L_0x0039:
                return
            L_0x003a:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: o1.b.a.a():void");
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
                boolean r0 = r2.f6133k
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                o1.a<T> r0 = r2.f6131i     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f6130h = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f6131i = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.c(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: o1.b.a.b():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.f6132j = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(T r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.f6133k
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.f6132j
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.f6133k     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.f6134l     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.f6130h     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                o1.a<T> r4 = r2.f6131i     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                o1.a r4 = new o1.a     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.f6131i = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.b(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.f6129g = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.f6132j = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o1.b.a.c(java.lang.Object, long):void");
        }

        public void dispose() {
            if (!this.f6133k) {
                this.f6133k = true;
                this.f6128f.U0(this);
            }
        }

        public boolean f() {
            return this.f6133k;
        }

        public boolean test(T t5) {
            if (this.f6133k) {
                return false;
            }
            this.f6127e.d(t5);
            return false;
        }
    }

    b() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f6124g = reentrantReadWriteLock.readLock();
        this.f6125h = reentrantReadWriteLock.writeLock();
        this.f6123f = new AtomicReference<>(f6121k);
        this.f6122e = new AtomicReference<>();
    }

    b(T t5) {
        this();
        if (t5 != null) {
            this.f6122e.lazySet(t5);
            return;
        }
        throw new NullPointerException("defaultValue == null");
    }

    public static <T> b<T> R0() {
        return new b<>();
    }

    public static <T> b<T> S0(T t5) {
        return new b<>(t5);
    }

    public boolean O0() {
        return ((a[]) this.f6123f.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public void Q0(a<T> aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f6123f.get();
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!f0.a(this.f6123f, aVarArr, aVarArr2));
    }

    public T T0() {
        return this.f6122e.get();
    }

    /* access modifiers changed from: package-private */
    public void U0(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f6123f.get();
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
                        aVarArr2 = f6121k;
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
        } while (!f0.a(this.f6123f, aVarArr, aVarArr2));
    }

    /* access modifiers changed from: package-private */
    public void V0(T t5) {
        this.f6125h.lock();
        this.f6126i++;
        this.f6122e.lazySet(t5);
        this.f6125h.unlock();
    }

    public void accept(T t5) {
        if (t5 != null) {
            V0(t5);
            for (a c5 : (a[]) this.f6123f.get()) {
                c5.c(t5, this.f6126i);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        a aVar = new a(pVar, this);
        pVar.c(aVar);
        Q0(aVar);
        if (aVar.f6133k) {
            U0(aVar);
        } else {
            aVar.a();
        }
    }
}
