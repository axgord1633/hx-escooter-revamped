package c4;

import kotlin.jvm.internal.k;
import kotlinx.coroutines.scheduling.h;
import o3.d;

public abstract class q0<T> extends h {

    /* renamed from: g  reason: collision with root package name */
    public int f3153g;

    public q0(int i5) {
        this.f3153g = i5;
    }

    public void b(Object obj, Throwable th) {
    }

    public abstract d<T> d();

    public Throwable e(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null) {
            return vVar.f3183a;
        }
        return null;
    }

    public <T> T g(Object obj) {
        return obj;
    }

    public final void h(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                b.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            k.b(th);
            f0.a(d().getContext(), new j0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object i();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (r4.E0() != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a5, code lost:
        if (r4.E0() != false) goto L_0x00a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.i r0 = r10.f5678f
            o3.d r1 = r10.d()     // Catch:{ all -> 0x00ab }
            kotlinx.coroutines.internal.f r1 = (kotlinx.coroutines.internal.f) r1     // Catch:{ all -> 0x00ab }
            o3.d<T> r2 = r1.f5589i     // Catch:{ all -> 0x00ab }
            java.lang.Object r1 = r1.f5591k     // Catch:{ all -> 0x00ab }
            o3.g r3 = r2.getContext()     // Catch:{ all -> 0x00ab }
            java.lang.Object r1 = kotlinx.coroutines.internal.f0.c(r3, r1)     // Catch:{ all -> 0x00ab }
            kotlinx.coroutines.internal.b0 r4 = kotlinx.coroutines.internal.f0.f5592a     // Catch:{ all -> 0x00ab }
            r5 = 0
            if (r1 == r4) goto L_0x001e
            c4.e2 r4 = c4.b0.f(r2, r3, r1)     // Catch:{ all -> 0x00ab }
            goto L_0x001f
        L_0x001e:
            r4 = r5
        L_0x001f:
            o3.g r6 = r2.getContext()     // Catch:{ all -> 0x009e }
            java.lang.Object r7 = r10.i()     // Catch:{ all -> 0x009e }
            java.lang.Throwable r8 = r10.e(r7)     // Catch:{ all -> 0x009e }
            if (r8 != 0) goto L_0x003e
            int r9 = r10.f3153g     // Catch:{ all -> 0x009e }
            boolean r9 = c4.r0.b(r9)     // Catch:{ all -> 0x009e }
            if (r9 == 0) goto L_0x003e
            c4.l1$b r9 = c4.l1.f3142c     // Catch:{ all -> 0x009e }
            o3.g$b r6 = r6.d(r9)     // Catch:{ all -> 0x009e }
            c4.l1 r6 = (c4.l1) r6     // Catch:{ all -> 0x009e }
            goto L_0x003f
        L_0x003e:
            r6 = r5
        L_0x003f:
            if (r6 == 0) goto L_0x005c
            boolean r9 = r6.b()     // Catch:{ all -> 0x009e }
            if (r9 != 0) goto L_0x005c
            java.util.concurrent.CancellationException r6 = r6.z()     // Catch:{ all -> 0x009e }
            r10.b(r7, r6)     // Catch:{ all -> 0x009e }
            m3.k$a r7 = m3.k.f5898e     // Catch:{ all -> 0x009e }
            java.lang.Object r6 = m3.l.a(r6)     // Catch:{ all -> 0x009e }
            java.lang.Object r6 = m3.k.a(r6)     // Catch:{ all -> 0x009e }
        L_0x0058:
            r2.resumeWith(r6)     // Catch:{ all -> 0x009e }
            goto L_0x0074
        L_0x005c:
            if (r8 == 0) goto L_0x0069
            m3.k$a r6 = m3.k.f5898e     // Catch:{ all -> 0x009e }
            java.lang.Object r6 = m3.l.a(r8)     // Catch:{ all -> 0x009e }
            java.lang.Object r6 = m3.k.a(r6)     // Catch:{ all -> 0x009e }
            goto L_0x0058
        L_0x0069:
            m3.k$a r6 = m3.k.f5898e     // Catch:{ all -> 0x009e }
            java.lang.Object r6 = r10.g(r7)     // Catch:{ all -> 0x009e }
            java.lang.Object r6 = m3.k.a(r6)     // Catch:{ all -> 0x009e }
            goto L_0x0058
        L_0x0074:
            m3.q r2 = m3.q.f5904a     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x007e
            boolean r2 = r4.E0()     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x0081
        L_0x007e:
            kotlinx.coroutines.internal.f0.a(r3, r1)     // Catch:{ all -> 0x00ab }
        L_0x0081:
            r0.a()     // Catch:{ all -> 0x008b }
            m3.q r0 = m3.q.f5904a     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = m3.k.a(r0)     // Catch:{ all -> 0x008b }
            goto L_0x0096
        L_0x008b:
            r0 = move-exception
            m3.k$a r1 = m3.k.f5898e
            java.lang.Object r0 = m3.l.a(r0)
            java.lang.Object r0 = m3.k.a(r0)
        L_0x0096:
            java.lang.Throwable r0 = m3.k.b(r0)
            r10.h(r5, r0)
            goto L_0x00ca
        L_0x009e:
            r2 = move-exception
            if (r4 == 0) goto L_0x00a7
            boolean r4 = r4.E0()     // Catch:{ all -> 0x00ab }
            if (r4 == 0) goto L_0x00aa
        L_0x00a7:
            kotlinx.coroutines.internal.f0.a(r3, r1)     // Catch:{ all -> 0x00ab }
        L_0x00aa:
            throw r2     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r1 = move-exception
            m3.k$a r2 = m3.k.f5898e     // Catch:{ all -> 0x00b8 }
            r0.a()     // Catch:{ all -> 0x00b8 }
            m3.q r0 = m3.q.f5904a     // Catch:{ all -> 0x00b8 }
            java.lang.Object r0 = m3.k.a(r0)     // Catch:{ all -> 0x00b8 }
            goto L_0x00c3
        L_0x00b8:
            r0 = move-exception
            m3.k$a r2 = m3.k.f5898e
            java.lang.Object r0 = m3.l.a(r0)
            java.lang.Object r0 = m3.k.a(r0)
        L_0x00c3:
            java.lang.Throwable r0 = m3.k.b(r0)
            r10.h(r1, r0)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.q0.run():void");
    }
}
