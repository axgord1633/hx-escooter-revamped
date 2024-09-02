package i3;

import g3.a;
import g3.h;
import m2.p;

public final class c<T> implements p<T>, p2.c {

    /* renamed from: e  reason: collision with root package name */
    final p<? super T> f4955e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f4956f;

    /* renamed from: g  reason: collision with root package name */
    p2.c f4957g;

    /* renamed from: h  reason: collision with root package name */
    boolean f4958h;

    /* renamed from: i  reason: collision with root package name */
    a<Object> f4959i;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f4960j;

    public c(p<? super T> pVar) {
        this(pVar, false);
    }

    public c(p<? super T> pVar, boolean z4) {
        this.f4955e = pVar;
        this.f4956f = z4;
    }

    public void a() {
        if (!this.f4960j) {
            synchronized (this) {
                if (!this.f4960j) {
                    if (this.f4958h) {
                        a<Object> aVar = this.f4959i;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f4959i = aVar;
                        }
                        aVar.b(h.i());
                        return;
                    }
                    this.f4960j = true;
                    this.f4958h = true;
                    this.f4955e.a();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f4959i;
                if (aVar == null) {
                    this.f4958h = false;
                    return;
                }
                this.f4959i = null;
            }
        } while (!aVar.a(this.f4955e));
    }

    public void c(p2.c cVar) {
        if (s2.c.q(this.f4957g, cVar)) {
            this.f4957g = cVar;
            this.f4955e.c(this);
        }
    }

    public void d(T t5) {
        if (!this.f4960j) {
            if (t5 == null) {
                this.f4957g.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f4960j) {
                    if (this.f4958h) {
                        a<Object> aVar = this.f4959i;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f4959i = aVar;
                        }
                        aVar.b(h.q(t5));
                        return;
                    }
                    this.f4958h = true;
                    this.f4955e.d(t5);
                    b();
                }
            }
        }
    }

    public void dispose() {
        this.f4957g.dispose();
    }

    public boolean f() {
        return this.f4957g.f();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        j3.a.r(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f4955e.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f4960j
            if (r0 == 0) goto L_0x0008
            j3.a.r(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f4960j     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f4958h     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f4960j = r1     // Catch:{ all -> 0x0044 }
            g3.a<java.lang.Object> r0 = r2.f4959i     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            g3.a r0 = new g3.a     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f4959i = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = g3.h.m(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f4956f     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.b(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.d(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f4960j = r1     // Catch:{ all -> 0x0044 }
            r2.f4958h = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            j3.a.r(r3)
            return
        L_0x003e:
            m2.p<? super T> r0 = r2.f4955e
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.c.onError(java.lang.Throwable):void");
    }
}
