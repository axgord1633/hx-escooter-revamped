package p2;

import g3.f;
import g3.i;
import java.util.ArrayList;
import q2.a;

public final class b implements c, s2.b {

    /* renamed from: e  reason: collision with root package name */
    i<c> f6549e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f6550f;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(p2.c r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposables is null"
            t2.b.e(r3, r0)
            boolean r0 = r2.f6550f
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f6550f     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            g3.i<p2.c> r0 = r2.f6549e     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.e(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.b.a(p2.c):boolean");
    }

    public boolean b(c cVar) {
        t2.b.e(cVar, "disposable is null");
        if (!this.f6550f) {
            synchronized (this) {
                if (!this.f6550f) {
                    i<c> iVar = this.f6549e;
                    if (iVar == null) {
                        iVar = new i<>();
                        this.f6549e = iVar;
                    }
                    iVar.a(cVar);
                    return true;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    public boolean c(c cVar) {
        if (!a(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d(i<c> iVar) {
        if (iVar != null) {
            ArrayList arrayList = null;
            for (Object obj : iVar.b()) {
                if (obj instanceof c) {
                    try {
                        ((c) obj).dispose();
                    } catch (Throwable th) {
                        q2.b.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw f.d((Throwable) arrayList.get(0));
            }
            throw new a((Iterable<? extends Throwable>) arrayList);
        }
    }

    public void dispose() {
        if (!this.f6550f) {
            synchronized (this) {
                if (!this.f6550f) {
                    this.f6550f = true;
                    i<c> iVar = this.f6549e;
                    this.f6549e = null;
                    d(iVar);
                }
            }
        }
    }

    public boolean f() {
        return this.f6550f;
    }
}
