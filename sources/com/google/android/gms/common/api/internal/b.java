package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.c;
import e1.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import l1.g;
import l1.h;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import t0.a;
import t0.d;
import u0.e;
import v0.e0;
import v0.j;
import v0.m;
import v0.v;
import w0.h0;
import w0.i;
import w0.n;
import w0.q;
import w0.r;
import w0.s;
import w0.t;
import w0.u;

public class b implements Handler.Callback {

    /* renamed from: r  reason: collision with root package name */
    public static final Status f3308r = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final Status f3309s = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final Object f3310t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static b f3311u;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f3312a = 5000;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f3313b = 120000;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f3314c = 10000;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f3315d = false;

    /* renamed from: e  reason: collision with root package name */
    private s f3316e;

    /* renamed from: f  reason: collision with root package name */
    private u f3317f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f3318g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final d f3319h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final h0 f3320i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f3321j = new AtomicInteger(1);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f3322k = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Map f3323l = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public k f3324m = null;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Set f3325n = new m.b();

    /* renamed from: o  reason: collision with root package name */
    private final Set f3326o = new m.b();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: p  reason: collision with root package name */
    public final Handler f3327p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public volatile boolean f3328q = true;

    private b(Context context, Looper looper, d dVar) {
        this.f3318g = context;
        k kVar = new k(looper, this);
        this.f3327p = kVar;
        this.f3319h = dVar;
        this.f3320i = new h0(dVar);
        if (a1.d.a(context)) {
            this.f3328q = false;
        }
        kVar.sendMessage(kVar.obtainMessage(6));
    }

    /* access modifiers changed from: private */
    public static Status h(v0.b bVar, a aVar) {
        String b5 = bVar.b();
        String valueOf = String.valueOf(aVar);
        return new Status(aVar, "API: " + b5 + " is not available on this device. Connection failed with: " + valueOf);
    }

    private final r i(e eVar) {
        v0.b k5 = eVar.k();
        r rVar = (r) this.f3323l.get(k5);
        if (rVar == null) {
            rVar = new r(this, eVar);
            this.f3323l.put(k5, rVar);
        }
        if (rVar.P()) {
            this.f3326o.add(k5);
        }
        rVar.E();
        return rVar;
    }

    private final u j() {
        if (this.f3317f == null) {
            this.f3317f = t.a(this.f3318g);
        }
        return this.f3317f;
    }

    private final void k() {
        s sVar = this.f3316e;
        if (sVar != null) {
            if (sVar.a() > 0 || f()) {
                j().a(sVar);
            }
            this.f3316e = null;
        }
    }

    private final void l(h hVar, int i5, e eVar) {
        w b5;
        if (i5 != 0 && (b5 = w.b(this, i5, eVar.k())) != null) {
            g a5 = hVar.a();
            Handler handler = this.f3327p;
            handler.getClass();
            a5.a(new m(handler), b5);
        }
    }

    public static b x(Context context) {
        b bVar;
        synchronized (f3310t) {
            if (f3311u == null) {
                f3311u = new b(context.getApplicationContext(), i.c().getLooper(), d.k());
            }
            bVar = f3311u;
        }
        return bVar;
    }

    public final g A(e eVar, c.a aVar, int i5) {
        h hVar = new h();
        l(hVar, i5, eVar);
        f0 f0Var = new f0(aVar, hVar);
        Handler handler = this.f3327p;
        handler.sendMessage(handler.obtainMessage(13, new v0.u(f0Var, this.f3322k.get(), eVar)));
        return hVar.a();
    }

    public final void F(e eVar, int i5, g gVar, h hVar, j jVar) {
        l(hVar, gVar.d(), eVar);
        e0 e0Var = new e0(i5, gVar, hVar, jVar);
        Handler handler = this.f3327p;
        handler.sendMessage(handler.obtainMessage(4, new v0.u(e0Var, this.f3322k.get(), eVar)));
    }

    /* access modifiers changed from: package-private */
    public final void G(n nVar, int i5, long j5, int i6) {
        Handler handler = this.f3327p;
        handler.sendMessage(handler.obtainMessage(18, new x(nVar, i5, j5, i6)));
    }

    public final void H(a aVar, int i5) {
        if (!g(aVar, i5)) {
            Handler handler = this.f3327p;
            handler.sendMessage(handler.obtainMessage(5, i5, 0, aVar));
        }
    }

    public final void a() {
        Handler handler = this.f3327p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void b(e eVar) {
        Handler handler = this.f3327p;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void c(k kVar) {
        synchronized (f3310t) {
            if (this.f3324m != kVar) {
                this.f3324m = kVar;
                this.f3325n.clear();
            }
            this.f3325n.addAll(kVar.t());
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(k kVar) {
        synchronized (f3310t) {
            if (this.f3324m == kVar) {
                this.f3324m = null;
                this.f3325n.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        if (this.f3315d) {
            return false;
        }
        r a5 = q.b().a();
        if (a5 != null && !a5.c()) {
            return false;
        }
        int a6 = this.f3320i.a(this.f3318g, 203400000);
        return a6 == -1 || a6 == 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean g(a aVar, int i5) {
        return this.f3319h.u(this.f3318g, aVar, i5);
    }

    public final boolean handleMessage(Message message) {
        h hVar;
        Boolean bool;
        int i5 = message.what;
        long j5 = 300000;
        r rVar = null;
        switch (i5) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j5 = 10000;
                }
                this.f3314c = j5;
                this.f3327p.removeMessages(12);
                for (v0.b obtainMessage : this.f3323l.keySet()) {
                    Handler handler = this.f3327p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.f3314c);
                }
                break;
            case 2:
                e0 e0Var = (e0) message.obj;
                Iterator it = e0Var.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        v0.b bVar = (v0.b) it.next();
                        r rVar2 = (r) this.f3323l.get(bVar);
                        if (rVar2 == null) {
                            e0Var.b(bVar, new a(13), (String) null);
                            break;
                        } else if (rVar2.O()) {
                            e0Var.b(bVar, a.f6807i, rVar2.v().k());
                        } else {
                            a t5 = rVar2.t();
                            if (t5 != null) {
                                e0Var.b(bVar, t5, (String) null);
                            } else {
                                rVar2.J(e0Var);
                                rVar2.E();
                            }
                        }
                    }
                }
            case 3:
                for (r rVar3 : this.f3323l.values()) {
                    rVar3.D();
                    rVar3.E();
                }
                break;
            case 4:
            case 8:
            case 13:
                v0.u uVar = (v0.u) message.obj;
                r rVar4 = (r) this.f3323l.get(uVar.f7162c.k());
                if (rVar4 == null) {
                    rVar4 = i(uVar.f7162c);
                }
                if (rVar4.P() && this.f3322k.get() != uVar.f7161b) {
                    uVar.f7160a.a(f3308r);
                    rVar4.L();
                    break;
                } else {
                    rVar4.F(uVar.f7160a);
                    break;
                }
                break;
            case 5:
                int i6 = message.arg1;
                a aVar = (a) message.obj;
                Iterator it2 = this.f3323l.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        r rVar5 = (r) it2.next();
                        if (rVar5.r() == i6) {
                            rVar = rVar5;
                        }
                    }
                }
                if (rVar != null) {
                    if (aVar.a() != 13) {
                        rVar.g(h(rVar.f3390d, aVar));
                        break;
                    } else {
                        String d5 = this.f3319h.d(aVar.a());
                        String b5 = aVar.b();
                        rVar.g(new Status(17, "Error resolution was canceled by the user, original error message: " + d5 + ": " + b5));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i6 + " while trying to fail enqueued calls.", new Exception());
                    break;
                }
            case 6:
                if (this.f3318g.getApplicationContext() instanceof Application) {
                    a.c((Application) this.f3318g.getApplicationContext());
                    a.b().a(new m(this));
                    if (!a.b().e(true)) {
                        this.f3314c = 300000;
                        break;
                    }
                }
                break;
            case 7:
                i((e) message.obj);
                break;
            case 9:
                if (this.f3323l.containsKey(message.obj)) {
                    ((r) this.f3323l.get(message.obj)).K();
                    break;
                }
                break;
            case 10:
                for (v0.b remove : this.f3326o) {
                    r rVar6 = (r) this.f3323l.remove(remove);
                    if (rVar6 != null) {
                        rVar6.L();
                    }
                }
                this.f3326o.clear();
                break;
            case 11:
                if (this.f3323l.containsKey(message.obj)) {
                    ((r) this.f3323l.get(message.obj)).M();
                    break;
                }
                break;
            case 12:
                if (this.f3323l.containsKey(message.obj)) {
                    ((r) this.f3323l.get(message.obj)).b();
                    break;
                }
                break;
            case 14:
                l lVar = (l) message.obj;
                v0.b a5 = lVar.a();
                if (!this.f3323l.containsKey(a5)) {
                    hVar = lVar.b();
                    bool = Boolean.FALSE;
                } else {
                    boolean N = ((r) this.f3323l.get(a5)).q(false);
                    hVar = lVar.b();
                    bool = Boolean.valueOf(N);
                }
                hVar.c(bool);
                break;
            case 15:
                s sVar = (s) message.obj;
                if (this.f3323l.containsKey(sVar.f3401a)) {
                    r.B((r) this.f3323l.get(sVar.f3401a), sVar);
                    break;
                }
                break;
            case 16:
                s sVar2 = (s) message.obj;
                if (this.f3323l.containsKey(sVar2.f3401a)) {
                    r.C((r) this.f3323l.get(sVar2.f3401a), sVar2);
                    break;
                }
                break;
            case 17:
                k();
                break;
            case 18:
                x xVar = (x) message.obj;
                if (xVar.f3420c != 0) {
                    s sVar3 = this.f3316e;
                    if (sVar3 != null) {
                        List b6 = sVar3.b();
                        if (sVar3.a() != xVar.f3419b || (b6 != null && b6.size() >= xVar.f3421d)) {
                            this.f3327p.removeMessages(17);
                            k();
                        } else {
                            this.f3316e.c(xVar.f3418a);
                        }
                    }
                    if (this.f3316e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(xVar.f3418a);
                        this.f3316e = new s(xVar.f3419b, arrayList);
                        Handler handler2 = this.f3327p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), xVar.f3420c);
                        break;
                    }
                } else {
                    j().a(new s(xVar.f3419b, Arrays.asList(new n[]{xVar.f3418a})));
                    break;
                }
                break;
            case 19:
                this.f3315d = false;
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i5);
                return false;
        }
        return true;
    }

    public final int m() {
        return this.f3321j.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final r w(v0.b bVar) {
        return (r) this.f3323l.get(bVar);
    }

    public final g z(e eVar, e eVar2, h hVar, Runnable runnable) {
        h hVar2 = new h();
        l(hVar2, eVar2.e(), eVar);
        d0 d0Var = new d0(new v(eVar2, hVar, runnable), hVar2);
        Handler handler = this.f3327p;
        handler.sendMessage(handler.obtainMessage(8, new v0.u(d0Var, this.f3322k.get(), eVar)));
        return hVar2.a();
    }
}
