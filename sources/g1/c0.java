package g1;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import i1.d;
import i1.s;
import m.g;
import v0.c;
import w0.e;
import w0.h;

public final class c0 extends h {
    private final g I = new g();
    private final g J = new g();
    private final g K = new g();

    public c0(Context context, Looper looper, e eVar, c cVar, v0.h hVar) {
        super(context, looper, 23, eVar, cVar, hVar);
    }

    private final boolean k0(t0.c cVar) {
        t0.c cVar2;
        t0.c[] j5 = j();
        if (j5 == null) {
            return false;
        }
        int length = j5.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                cVar2 = null;
                break;
            }
            cVar2 = j5[i5];
            if (cVar.a().equals(cVar2.a())) {
                break;
            }
            i5++;
        }
        return cVar2 != null && cVar2.b() >= cVar.b();
    }

    /* access modifiers changed from: protected */
    public final String D() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    public final void L(int i5) {
        super.L(i5);
        synchronized (this.I) {
            this.I.clear();
        }
        synchronized (this.J) {
            this.J.clear();
        }
        synchronized (this.K) {
            this.K.clear();
        }
    }

    public final boolean Q() {
        return true;
    }

    public final int h() {
        return 11717000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j0(com.google.android.gms.common.api.internal.c.a r10, boolean r11, l1.h r12) {
        /*
            r9 = this;
            m.g r0 = r9.J
            monitor-enter(r0)
            m.g r1 = r9.J     // Catch:{ all -> 0x005b }
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x005b }
            r5 = r10
            g1.a0 r5 = (g1.a0) r5     // Catch:{ all -> 0x005b }
            if (r5 != 0) goto L_0x0015
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x005b }
            r12.c(r10)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x0015:
            r5.A()     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x0054
            t0.c r10 = i1.s.f4947j     // Catch:{ all -> 0x005b }
            boolean r10 = r9.k0(r10)     // Catch:{ all -> 0x005b }
            if (r10 == 0) goto L_0x0038
            android.os.IInterface r10 = r9.C()     // Catch:{ all -> 0x005b }
            g1.d1 r10 = (g1.d1) r10     // Catch:{ all -> 0x005b }
            r11 = 0
            g1.d0 r11 = g1.d0.a(r11, r5, r11, r11)     // Catch:{ all -> 0x005b }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            g1.r r2 = new g1.r     // Catch:{ all -> 0x005b }
            r2.<init>(r9, r1, r12)     // Catch:{ all -> 0x005b }
            r10.j(r11, r2)     // Catch:{ all -> 0x005b }
            goto L_0x0059
        L_0x0038:
            android.os.IInterface r10 = r9.C()     // Catch:{ all -> 0x005b }
            g1.d1 r10 = (g1.d1) r10     // Catch:{ all -> 0x005b }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            g1.t r7 = new g1.t     // Catch:{ all -> 0x005b }
            r7.<init>(r11, r12)     // Catch:{ all -> 0x005b }
            g1.h0 r11 = new g1.h0     // Catch:{ all -> 0x005b }
            r2 = 2
            r3 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x005b }
            r10.r(r11)     // Catch:{ all -> 0x005b }
            goto L_0x0059
        L_0x0054:
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            r12.c(r10)     // Catch:{ all -> 0x005b }
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x005b:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.c0.j0(com.google.android.gms.common.api.internal.c$a, boolean, l1.h):void");
    }

    public final void l0(d dVar, l1.h hVar) {
        x();
        if (k0(s.f4943f)) {
            ((d1) C()).w(dVar, new s(this, hVar));
        } else {
            hVar.c(((d1) C()).b());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m0(g1.w r18, com.google.android.gms.location.LocationRequest r19, l1.h r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.c r3 = r18.f()
            com.google.android.gms.common.api.internal.c$a r4 = r3.b()
            r4.getClass()
            t0.c r5 = i1.s.f4947j
            boolean r5 = r1.k0(r5)
            m.g r6 = r1.J
            monitor-enter(r6)
            m.g r7 = r1.J     // Catch:{ all -> 0x0082 }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x0082 }
            g1.a0 r7 = (g1.a0) r7     // Catch:{ all -> 0x0082 }
            r8 = 0
            if (r7 == 0) goto L_0x002e
            if (r5 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            r7.z(r3)     // Catch:{ all -> 0x0082 }
            r13 = r7
            r7 = r8
            goto L_0x003b
        L_0x002e:
            g1.a0 r3 = new g1.a0     // Catch:{ all -> 0x0082 }
            r9 = r18
            r3.<init>(r9)     // Catch:{ all -> 0x0082 }
            m.g r9 = r1.J     // Catch:{ all -> 0x0082 }
            r9.put(r4, r3)     // Catch:{ all -> 0x0082 }
            r13 = r3
        L_0x003b:
            r17.x()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r4.a()     // Catch:{ all -> 0x0082 }
            if (r5 == 0) goto L_0x0057
            android.os.IInterface r4 = r17.C()     // Catch:{ all -> 0x0082 }
            g1.d1 r4 = (g1.d1) r4     // Catch:{ all -> 0x0082 }
            g1.d0 r3 = g1.d0.a(r7, r13, r8, r3)     // Catch:{ all -> 0x0082 }
            g1.r r5 = new g1.r     // Catch:{ all -> 0x0082 }
            r5.<init>(r1, r8, r2)     // Catch:{ all -> 0x0082 }
            r4.l(r3, r0, r5)     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x0057:
            android.os.IInterface r4 = r17.C()     // Catch:{ all -> 0x0082 }
            g1.d1 r4 = (g1.d1) r4     // Catch:{ all -> 0x0082 }
            com.google.android.gms.location.LocationRequest$a r5 = new com.google.android.gms.location.LocationRequest$a     // Catch:{ all -> 0x0082 }
            r5.<init>((com.google.android.gms.location.LocationRequest) r0)     // Catch:{ all -> 0x0082 }
            r5.j(r8)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.location.LocationRequest r0 = r5.a()     // Catch:{ all -> 0x0082 }
            g1.f0 r11 = g1.f0.a(r8, r0)     // Catch:{ all -> 0x0082 }
            g1.u r15 = new g1.u     // Catch:{ all -> 0x0082 }
            r15.<init>(r2, r13)     // Catch:{ all -> 0x0082 }
            g1.h0 r0 = new g1.h0     // Catch:{ all -> 0x0082 }
            r10 = 1
            r12 = 0
            r14 = 0
            r9 = r0
            r16 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0082 }
            r4.r(r0)     // Catch:{ all -> 0x0082 }
        L_0x0080:
            monitor-exit(r6)     // Catch:{ all -> 0x0082 }
            return
        L_0x0082:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0082 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.c0.m0(g1.w, com.google.android.gms.location.LocationRequest, l1.h):void");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof d1 ? (d1) queryLocalInterface : new c1(iBinder);
    }

    public final t0.c[] u() {
        return s.f4949l;
    }
}
