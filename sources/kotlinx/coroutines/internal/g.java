package kotlinx.coroutines.internal;

import o3.d;
import v3.l;

public final class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f5599a = new b0("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final b0 f5600b = new b0("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        if (r8.E0() != false) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void b(o3.d<? super T> r6, java.lang.Object r7, v3.l<? super java.lang.Throwable, m3.q> r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.f
            if (r0 == 0) goto L_0x00b6
            kotlinx.coroutines.internal.f r6 = (kotlinx.coroutines.internal.f) r6
            java.lang.Object r8 = c4.z.c(r7, r8)
            c4.c0 r0 = r6.f5588h
            o3.g r1 = r6.getContext()
            boolean r0 = r0.N(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6.f5590j = r8
            r6.f3153g = r1
            c4.c0 r7 = r6.f5588h
            o3.g r8 = r6.getContext()
            r7.M(r8, r6)
            goto L_0x00b9
        L_0x0026:
            c4.c2 r0 = c4.c2.f3110a
            c4.w0 r0 = r0.a()
            boolean r2 = r0.V()
            if (r2 == 0) goto L_0x003b
            r6.f5590j = r8
            r6.f3153g = r1
            r0.R(r6)
            goto L_0x00b9
        L_0x003b:
            r0.T(r1)
            r2 = 0
            o3.g r3 = r6.getContext()     // Catch:{ all -> 0x00a9 }
            c4.l1$b r4 = c4.l1.f3142c     // Catch:{ all -> 0x00a9 }
            o3.g$b r3 = r3.d(r4)     // Catch:{ all -> 0x00a9 }
            c4.l1 r3 = (c4.l1) r3     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0069
            boolean r4 = r3.b()     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.CancellationException r3 = r3.z()     // Catch:{ all -> 0x00a9 }
            r6.b(r8, r3)     // Catch:{ all -> 0x00a9 }
            m3.k$a r8 = m3.k.f5898e     // Catch:{ all -> 0x00a9 }
            java.lang.Object r8 = m3.l.a(r3)     // Catch:{ all -> 0x00a9 }
            java.lang.Object r8 = m3.k.a(r8)     // Catch:{ all -> 0x00a9 }
            r6.resumeWith(r8)     // Catch:{ all -> 0x00a9 }
            r8 = r1
            goto L_0x006a
        L_0x0069:
            r8 = 0
        L_0x006a:
            if (r8 != 0) goto L_0x00a2
            o3.d<T> r8 = r6.f5589i     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = r6.f5591k     // Catch:{ all -> 0x00a9 }
            o3.g r4 = r8.getContext()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = kotlinx.coroutines.internal.f0.c(r4, r3)     // Catch:{ all -> 0x00a9 }
            kotlinx.coroutines.internal.b0 r5 = kotlinx.coroutines.internal.f0.f5592a     // Catch:{ all -> 0x00a9 }
            if (r3 == r5) goto L_0x0081
            c4.e2 r8 = c4.b0.f(r8, r4, r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x0082
        L_0x0081:
            r8 = r2
        L_0x0082:
            o3.d<T> r5 = r6.f5589i     // Catch:{ all -> 0x0095 }
            r5.resumeWith(r7)     // Catch:{ all -> 0x0095 }
            m3.q r7 = m3.q.f5904a     // Catch:{ all -> 0x0095 }
            if (r8 == 0) goto L_0x0091
            boolean r7 = r8.E0()     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x00a2
        L_0x0091:
            kotlinx.coroutines.internal.f0.a(r4, r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a2
        L_0x0095:
            r7 = move-exception
            if (r8 == 0) goto L_0x009e
            boolean r8 = r8.E0()     // Catch:{ all -> 0x00a9 }
            if (r8 == 0) goto L_0x00a1
        L_0x009e:
            kotlinx.coroutines.internal.f0.a(r4, r3)     // Catch:{ all -> 0x00a9 }
        L_0x00a1:
            throw r7     // Catch:{ all -> 0x00a9 }
        L_0x00a2:
            boolean r7 = r0.X()     // Catch:{ all -> 0x00a9 }
            if (r7 != 0) goto L_0x00a2
            goto L_0x00ad
        L_0x00a9:
            r7 = move-exception
            r6.h(r7, r2)     // Catch:{ all -> 0x00b1 }
        L_0x00ad:
            r0.P(r1)
            goto L_0x00b9
        L_0x00b1:
            r6 = move-exception
            r0.P(r1)
            throw r6
        L_0x00b6:
            r6.resumeWith(r7)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.g.b(o3.d, java.lang.Object, v3.l):void");
    }

    public static /* synthetic */ void c(d dVar, Object obj, l lVar, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }
}
