package s2;

import g3.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p2.c;
import q2.a;
import t2.b;

public final class e implements c, b {

    /* renamed from: e  reason: collision with root package name */
    List<c> f6741e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f6742f;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(p2.c r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Disposable item is null"
            t2.b.e(r3, r0)
            boolean r0 = r2.f6742f
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f6742f     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<p2.c> r0 = r2.f6741e     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: s2.e.a(p2.c):boolean");
    }

    public boolean b(c cVar) {
        b.e(cVar, "d is null");
        if (!this.f6742f) {
            synchronized (this) {
                if (!this.f6742f) {
                    List list = this.f6741e;
                    if (list == null) {
                        list = new LinkedList();
                        this.f6741e = list;
                    }
                    list.add(cVar);
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
    public void d(List<c> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (c dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    q2.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
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
        if (!this.f6742f) {
            synchronized (this) {
                if (!this.f6742f) {
                    this.f6742f = true;
                    List<c> list = this.f6741e;
                    this.f6741e = null;
                    d(list);
                }
            }
        }
    }

    public boolean f() {
        return this.f6742f;
    }
}
