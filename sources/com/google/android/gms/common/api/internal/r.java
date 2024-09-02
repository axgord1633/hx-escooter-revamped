package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import l1.h;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import t0.c;
import u0.a;
import u0.e;
import u0.f;
import u0.m;
import v0.b;
import v0.c0;
import v0.e0;
import v0.n;
import v0.v;
import w0.o;
import w0.p;

public final class r implements f.a, f.b {

    /* renamed from: b  reason: collision with root package name */
    private final Queue f3388b = new LinkedList();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: c  reason: collision with root package name */
    public final a.f f3389c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b f3390d;

    /* renamed from: e  reason: collision with root package name */
    private final j f3391e;

    /* renamed from: f  reason: collision with root package name */
    private final Set f3392f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final Map f3393g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final int f3394h;

    /* renamed from: i  reason: collision with root package name */
    private final c0 f3395i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3396j;

    /* renamed from: k  reason: collision with root package name */
    private final List f3397k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private t0.a f3398l = null;

    /* renamed from: m  reason: collision with root package name */
    private int f3399m = 0;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ b f3400n;

    public r(b bVar, e eVar) {
        this.f3400n = bVar;
        a.f n5 = eVar.n(bVar.f3327p.getLooper(), this);
        this.f3389c = n5;
        this.f3390d = eVar.k();
        this.f3391e = new j();
        this.f3394h = eVar.m();
        if (n5.o()) {
            this.f3395i = eVar.o(bVar.f3318g, bVar.f3327p);
        } else {
            this.f3395i = null;
        }
    }

    static /* bridge */ /* synthetic */ void B(r rVar, s sVar) {
        if (!rVar.f3397k.contains(sVar) || rVar.f3396j) {
            return;
        }
        if (!rVar.f3389c.a()) {
            rVar.E();
        } else {
            rVar.i();
        }
    }

    static /* bridge */ /* synthetic */ void C(r rVar, s sVar) {
        c[] g5;
        if (rVar.f3397k.remove(sVar)) {
            rVar.f3400n.f3327p.removeMessages(15, sVar);
            rVar.f3400n.f3327p.removeMessages(16, sVar);
            c a5 = sVar.f3402b;
            ArrayList arrayList = new ArrayList(rVar.f3388b.size());
            for (g0 g0Var : rVar.f3388b) {
                if ((g0Var instanceof v0.r) && (g5 = ((v0.r) g0Var).g(rVar)) != null && a1.a.b(g5, a5)) {
                    arrayList.add(g0Var);
                }
            }
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                g0 g0Var2 = (g0) arrayList.get(i5);
                rVar.f3388b.remove(g0Var2);
                g0Var2.b(new m(a5));
            }
        }
    }

    private final c d(c[] cVarArr) {
        if (!(cVarArr == null || cVarArr.length == 0)) {
            c[] j5 = this.f3389c.j();
            if (j5 == null) {
                j5 = new c[0];
            }
            m.a aVar = new m.a(r3);
            for (c cVar : j5) {
                aVar.put(cVar.a(), Long.valueOf(cVar.b()));
            }
            for (c cVar2 : cVarArr) {
                Long l5 = (Long) aVar.get(cVar2.a());
                if (l5 == null || l5.longValue() < cVar2.b()) {
                    return cVar2;
                }
            }
        }
        return null;
    }

    private final void f(t0.a aVar) {
        for (e0 b5 : this.f3392f) {
            b5.b(this.f3390d, aVar, o.a(aVar, t0.a.f6807i) ? this.f3389c.k() : null);
        }
        this.f3392f.clear();
    }

    /* access modifiers changed from: private */
    public final void g(Status status) {
        p.d(this.f3400n.f3327p);
        h(status, (Exception) null, false);
    }

    private final void h(Status status, Exception exc, boolean z4) {
        p.d(this.f3400n.f3327p);
        boolean z5 = false;
        boolean z6 = status == null;
        if (exc == null) {
            z5 = true;
        }
        if (z6 != z5) {
            Iterator it = this.f3388b.iterator();
            while (it.hasNext()) {
                g0 g0Var = (g0) it.next();
                if (!z4 || g0Var.f3361a == 2) {
                    if (status != null) {
                        g0Var.a(status);
                    } else {
                        g0Var.b(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    private final void i() {
        ArrayList arrayList = new ArrayList(this.f3388b);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            g0 g0Var = (g0) arrayList.get(i5);
            if (this.f3389c.a()) {
                if (o(g0Var)) {
                    this.f3388b.remove(g0Var);
                }
                i5++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        D();
        f(t0.a.f6807i);
        n();
        Iterator it = this.f3393g.values().iterator();
        while (it.hasNext()) {
            v vVar = (v) it.next();
            if (d(vVar.f7163a.c()) == null) {
                try {
                    vVar.f7163a.d(this.f3389c, new h());
                } catch (DeadObjectException unused) {
                    c(3);
                    this.f3389c.e("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                }
            }
            it.remove();
        }
        i();
        l();
    }

    /* access modifiers changed from: private */
    public final void k(int i5) {
        D();
        this.f3396j = true;
        this.f3391e.c(i5, this.f3389c.l());
        b bVar = this.f3400n;
        bVar.f3327p.sendMessageDelayed(Message.obtain(bVar.f3327p, 9, this.f3390d), this.f3400n.f3312a);
        b bVar2 = this.f3400n;
        bVar2.f3327p.sendMessageDelayed(Message.obtain(bVar2.f3327p, 11, this.f3390d), this.f3400n.f3313b);
        this.f3400n.f3320i.c();
        for (v vVar : this.f3393g.values()) {
            vVar.f7165c.run();
        }
    }

    private final void l() {
        this.f3400n.f3327p.removeMessages(12, this.f3390d);
        b bVar = this.f3400n;
        bVar.f3327p.sendMessageDelayed(bVar.f3327p.obtainMessage(12, this.f3390d), this.f3400n.f3314c);
    }

    private final void m(g0 g0Var) {
        g0Var.d(this.f3391e, P());
        try {
            g0Var.c(this);
        } catch (DeadObjectException unused) {
            c(1);
            this.f3389c.e("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void n() {
        if (this.f3396j) {
            this.f3400n.f3327p.removeMessages(11, this.f3390d);
            this.f3400n.f3327p.removeMessages(9, this.f3390d);
            this.f3396j = false;
        }
    }

    private final boolean o(g0 g0Var) {
        if (!(g0Var instanceof v0.r)) {
            m(g0Var);
            return true;
        }
        v0.r rVar = (v0.r) g0Var;
        c d5 = d(rVar.g(this));
        if (d5 == null) {
            m(g0Var);
            return true;
        }
        String name = this.f3389c.getClass().getName();
        String a5 = d5.a();
        long b5 = d5.b();
        Log.w("GoogleApiManager", name + " could not execute call because it requires feature (" + a5 + ", " + b5 + ").");
        if (!this.f3400n.f3328q || !rVar.f(this)) {
            rVar.b(new m(d5));
            return true;
        }
        s sVar = new s(this.f3390d, d5, (n) null);
        int indexOf = this.f3397k.indexOf(sVar);
        if (indexOf >= 0) {
            s sVar2 = (s) this.f3397k.get(indexOf);
            this.f3400n.f3327p.removeMessages(15, sVar2);
            b bVar = this.f3400n;
            bVar.f3327p.sendMessageDelayed(Message.obtain(bVar.f3327p, 15, sVar2), this.f3400n.f3312a);
            return false;
        }
        this.f3397k.add(sVar);
        b bVar2 = this.f3400n;
        bVar2.f3327p.sendMessageDelayed(Message.obtain(bVar2.f3327p, 15, sVar), this.f3400n.f3312a);
        b bVar3 = this.f3400n;
        bVar3.f3327p.sendMessageDelayed(Message.obtain(bVar3.f3327p, 16, sVar), this.f3400n.f3313b);
        t0.a aVar = new t0.a(2, (PendingIntent) null);
        if (p(aVar)) {
            return false;
        }
        this.f3400n.g(aVar, this.f3394h);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean p(t0.a r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.b.f3310t
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.b r1 = r3.f3400n     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.k r2 = r1.f3324m     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0027
            java.util.Set r1 = r1.f3325n     // Catch:{ all -> 0x002a }
            v0.b r2 = r3.f3390d     // Catch:{ all -> 0x002a }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0027
            com.google.android.gms.common.api.internal.b r1 = r3.f3400n     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.k r1 = r1.f3324m     // Catch:{ all -> 0x002a }
            int r2 = r3.f3394h     // Catch:{ all -> 0x002a }
            r1.s(r4, r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 1
            return r4
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 0
            return r4
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.r.p(t0.a):boolean");
    }

    /* access modifiers changed from: private */
    public final boolean q(boolean z4) {
        p.d(this.f3400n.f3327p);
        if (!this.f3389c.a() || this.f3393g.size() != 0) {
            return false;
        }
        if (this.f3391e.e()) {
            if (z4) {
                l();
            }
            return false;
        }
        this.f3389c.e("Timing out service connection.");
        return true;
    }

    public final void D() {
        p.d(this.f3400n.f3327p);
        this.f3398l = null;
    }

    public final void E() {
        t0.a aVar;
        p.d(this.f3400n.f3327p);
        if (!this.f3389c.a() && !this.f3389c.i()) {
            try {
                b bVar = this.f3400n;
                int b5 = bVar.f3320i.b(bVar.f3318g, this.f3389c);
                if (b5 != 0) {
                    t0.a aVar2 = new t0.a(b5, (PendingIntent) null);
                    String name = this.f3389c.getClass().getName();
                    String obj = aVar2.toString();
                    Log.w("GoogleApiManager", "The service for " + name + " is not available: " + obj);
                    H(aVar2, (Exception) null);
                    return;
                }
                b bVar2 = this.f3400n;
                a.f fVar = this.f3389c;
                u uVar = new u(bVar2, fVar, this.f3390d);
                if (fVar.o()) {
                    ((c0) p.g(this.f3395i)).C(uVar);
                }
                try {
                    this.f3389c.b(uVar);
                } catch (SecurityException e5) {
                    e = e5;
                    aVar = new t0.a(10);
                    H(aVar, e);
                }
            } catch (IllegalStateException e6) {
                e = e6;
                aVar = new t0.a(10);
                H(aVar, e);
            }
        }
    }

    public final void F(g0 g0Var) {
        p.d(this.f3400n.f3327p);
        if (!this.f3389c.a()) {
            this.f3388b.add(g0Var);
            t0.a aVar = this.f3398l;
            if (aVar == null || !aVar.d()) {
                E();
            } else {
                H(this.f3398l, (Exception) null);
            }
        } else if (o(g0Var)) {
            l();
        } else {
            this.f3388b.add(g0Var);
        }
    }

    /* access modifiers changed from: package-private */
    public final void G() {
        this.f3399m++;
    }

    public final void H(t0.a aVar, Exception exc) {
        p.d(this.f3400n.f3327p);
        c0 c0Var = this.f3395i;
        if (c0Var != null) {
            c0Var.D();
        }
        D();
        this.f3400n.f3320i.c();
        f(aVar);
        if ((this.f3389c instanceof y0.e) && aVar.a() != 24) {
            this.f3400n.f3315d = true;
            b bVar = this.f3400n;
            bVar.f3327p.sendMessageDelayed(bVar.f3327p.obtainMessage(19), 300000);
        }
        if (aVar.a() == 4) {
            g(b.f3309s);
        } else if (this.f3388b.isEmpty()) {
            this.f3398l = aVar;
        } else if (exc != null) {
            p.d(this.f3400n.f3327p);
            h((Status) null, exc, false);
        } else if (this.f3400n.f3328q) {
            h(b.h(this.f3390d, aVar), (Exception) null, true);
            if (!this.f3388b.isEmpty() && !p(aVar) && !this.f3400n.g(aVar, this.f3394h)) {
                if (aVar.a() == 18) {
                    this.f3396j = true;
                }
                if (this.f3396j) {
                    b bVar2 = this.f3400n;
                    bVar2.f3327p.sendMessageDelayed(Message.obtain(bVar2.f3327p, 9, this.f3390d), this.f3400n.f3312a);
                    return;
                }
                g(b.h(this.f3390d, aVar));
            }
        } else {
            g(b.h(this.f3390d, aVar));
        }
    }

    public final void I(t0.a aVar) {
        p.d(this.f3400n.f3327p);
        a.f fVar = this.f3389c;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(aVar);
        fVar.e("onSignInFailed for " + name + " with " + valueOf);
        H(aVar, (Exception) null);
    }

    public final void J(e0 e0Var) {
        p.d(this.f3400n.f3327p);
        this.f3392f.add(e0Var);
    }

    public final void K() {
        p.d(this.f3400n.f3327p);
        if (this.f3396j) {
            E();
        }
    }

    public final void L() {
        p.d(this.f3400n.f3327p);
        g(b.f3308r);
        this.f3391e.d();
        for (c.a f0Var : (c.a[]) this.f3393g.keySet().toArray(new c.a[0])) {
            F(new f0(f0Var, new h()));
        }
        f(new t0.a(4));
        if (this.f3389c.a()) {
            this.f3389c.d(new q(this));
        }
    }

    public final void M() {
        p.d(this.f3400n.f3327p);
        if (this.f3396j) {
            n();
            b bVar = this.f3400n;
            g(bVar.f3319h.e(bVar.f3318g) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f3389c.e("Timing out connection while resuming.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O() {
        return this.f3389c.a();
    }

    public final boolean P() {
        return this.f3389c.o();
    }

    public final void a(t0.a aVar) {
        H(aVar, (Exception) null);
    }

    public final boolean b() {
        return q(true);
    }

    public final void c(int i5) {
        if (Looper.myLooper() == this.f3400n.f3327p.getLooper()) {
            k(i5);
        } else {
            this.f3400n.f3327p.post(new o(this, i5));
        }
    }

    public final void e(Bundle bundle) {
        if (Looper.myLooper() == this.f3400n.f3327p.getLooper()) {
            j();
        } else {
            this.f3400n.f3327p.post(new n(this));
        }
    }

    public final int r() {
        return this.f3394h;
    }

    /* access modifiers changed from: package-private */
    public final int s() {
        return this.f3399m;
    }

    public final t0.a t() {
        p.d(this.f3400n.f3327p);
        return this.f3398l;
    }

    public final a.f v() {
        return this.f3389c;
    }

    public final Map x() {
        return this.f3393g;
    }
}
