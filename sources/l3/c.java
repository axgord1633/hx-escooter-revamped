package l3;

import g3.a;
import g3.h;
import m2.p;

final class c<T> extends d<T> implements a.C0080a<Object> {

    /* renamed from: e  reason: collision with root package name */
    final d<T> f5755e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5756f;

    /* renamed from: g  reason: collision with root package name */
    a<Object> f5757g;

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f5758h;

    c(d<T> dVar) {
        this.f5755e = dVar;
    }

    /* access modifiers changed from: package-private */
    public void P0() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f5757g;
                if (aVar == null) {
                    this.f5756f = false;
                    return;
                }
                this.f5757g = null;
            }
            aVar.c(this);
        }
        while (true) {
        }
    }

    public void a() {
        if (!this.f5758h) {
            synchronized (this) {
                if (!this.f5758h) {
                    this.f5758h = true;
                    if (this.f5756f) {
                        a<Object> aVar = this.f5757g;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f5757g = aVar;
                        }
                        aVar.b(h.i());
                        return;
                    }
                    this.f5756f = true;
                    this.f5755e.a();
                }
            }
        }
    }

    public void c(p2.c cVar) {
        boolean z4 = true;
        if (!this.f5758h) {
            synchronized (this) {
                if (!this.f5758h) {
                    if (this.f5756f) {
                        a<Object> aVar = this.f5757g;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f5757g = aVar;
                        }
                        aVar.b(h.l(cVar));
                        return;
                    }
                    this.f5756f = true;
                    z4 = false;
                }
            }
        }
        if (z4) {
            cVar.dispose();
            return;
        }
        this.f5755e.c(cVar);
        P0();
    }

    public void d(T t5) {
        if (!this.f5758h) {
            synchronized (this) {
                if (!this.f5758h) {
                    if (this.f5756f) {
                        a<Object> aVar = this.f5757g;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f5757g = aVar;
                        }
                        aVar.b(h.q(t5));
                        return;
                    }
                    this.f5756f = true;
                    this.f5755e.d(t5);
                    P0();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r1 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        j3.a.r(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r2.f5755e.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f5758h
            if (r0 == 0) goto L_0x0008
            j3.a.r(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f5758h     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002e
        L_0x000f:
            r2.f5758h = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f5756f     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002a
            g3.a<java.lang.Object> r0 = r2.f5757g     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0021
            g3.a r0 = new g3.a     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f5757g = r0     // Catch:{ all -> 0x003b }
        L_0x0021:
            java.lang.Object r3 = g3.h.m(r3)     // Catch:{ all -> 0x003b }
            r0.d(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002a:
            r0 = 0
            r2.f5756f = r1     // Catch:{ all -> 0x003b }
            r1 = r0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            j3.a.r(r3)
            return
        L_0x0035:
            l3.d<T> r0 = r2.f5755e
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.c.onError(java.lang.Throwable):void");
    }

    public boolean test(Object obj) {
        return h.f(obj, this.f5755e);
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f5755e.g(pVar);
    }
}
