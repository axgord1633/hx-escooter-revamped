package w0;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c<T extends IInterface> {
    public static final String[] D = {"service_esmobile", "service_googleme"};
    private static final t0.c[] E = new t0.c[0];
    /* access modifiers changed from: private */
    public boolean A = false;
    private volatile z0 B = null;
    protected AtomicInteger C = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private int f7292a;

    /* renamed from: b  reason: collision with root package name */
    private long f7293b;

    /* renamed from: c  reason: collision with root package name */
    private long f7294c;

    /* renamed from: d  reason: collision with root package name */
    private int f7295d;

    /* renamed from: e  reason: collision with root package name */
    private long f7296e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f7297f = null;

    /* renamed from: g  reason: collision with root package name */
    l1 f7298g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f7299h;

    /* renamed from: i  reason: collision with root package name */
    private final Looper f7300i;

    /* renamed from: j  reason: collision with root package name */
    private final i f7301j;

    /* renamed from: k  reason: collision with root package name */
    private final t0.e f7302k;

    /* renamed from: l  reason: collision with root package name */
    final Handler f7303l;

    /* renamed from: m  reason: collision with root package name */
    private final Object f7304m = new Object();
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Object f7305n = new Object();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public m f7306o;

    /* renamed from: p  reason: collision with root package name */
    protected C0119c f7307p;

    /* renamed from: q  reason: collision with root package name */
    private IInterface f7308q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f7309r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private w0 f7310s;

    /* renamed from: t  reason: collision with root package name */
    private int f7311t = 1;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final a f7312u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public final b f7313v;

    /* renamed from: w  reason: collision with root package name */
    private final int f7314w;

    /* renamed from: x  reason: collision with root package name */
    private final String f7315x;

    /* renamed from: y  reason: collision with root package name */
    private volatile String f7316y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public t0.a f7317z = null;

    public interface a {
        void c(int i5);

        void e(Bundle bundle);
    }

    public interface b {
        void a(t0.a aVar);
    }

    /* renamed from: w0.c$c  reason: collision with other inner class name */
    public interface C0119c {
        void c(t0.a aVar);
    }

    protected class d implements C0119c {
        public d() {
        }

        public final void c(t0.a aVar) {
            if (aVar.e()) {
                c cVar = c.this;
                cVar.g((j) null, cVar.B());
            } else if (c.this.f7313v != null) {
                c.this.f7313v.a(aVar);
            }
        }
    }

    public interface e {
        void a();
    }

    protected c(Context context, Looper looper, i iVar, t0.e eVar, int i5, a aVar, b bVar, String str) {
        p.h(context, "Context must not be null");
        this.f7299h = context;
        p.h(looper, "Looper must not be null");
        this.f7300i = looper;
        p.h(iVar, "Supervisor must not be null");
        this.f7301j = iVar;
        p.h(eVar, "API availability must not be null");
        this.f7302k = eVar;
        this.f7303l = new t0(this, looper);
        this.f7314w = i5;
        this.f7312u = aVar;
        this.f7313v = bVar;
        this.f7315x = str;
    }

    static /* bridge */ /* synthetic */ void a0(c cVar, z0 z0Var) {
        cVar.B = z0Var;
        if (cVar.Q()) {
            f fVar = z0Var.f7454h;
            q.b().c(fVar == null ? null : fVar.f());
        }
    }

    static /* bridge */ /* synthetic */ void b0(c cVar, int i5) {
        int i6;
        int i7;
        synchronized (cVar.f7304m) {
            i6 = cVar.f7311t;
        }
        if (i6 == 3) {
            cVar.A = true;
            i7 = 5;
        } else {
            i7 = 4;
        }
        Handler handler = cVar.f7303l;
        handler.sendMessage(handler.obtainMessage(i7, cVar.C.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean e0(c cVar, int i5, int i6, IInterface iInterface) {
        synchronized (cVar.f7304m) {
            if (cVar.f7311t != i5) {
                return false;
            }
            cVar.g0(i6, iInterface);
            return true;
        }
    }

    static /* bridge */ /* synthetic */ boolean f0(c cVar) {
        if (cVar.A || TextUtils.isEmpty(cVar.D()) || TextUtils.isEmpty(cVar.A())) {
            return false;
        }
        try {
            Class.forName(cVar.D());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void g0(int i5, IInterface iInterface) {
        l1 l1Var;
        boolean z4 = false;
        if ((i5 == 4) == (iInterface != null)) {
            z4 = true;
        }
        p.a(z4);
        synchronized (this.f7304m) {
            this.f7311t = i5;
            this.f7308q = iInterface;
            if (i5 == 1) {
                w0 w0Var = this.f7310s;
                if (w0Var != null) {
                    i iVar = this.f7301j;
                    String c5 = this.f7298g.c();
                    p.g(c5);
                    iVar.e(c5, this.f7298g.b(), this.f7298g.a(), w0Var, V(), this.f7298g.d());
                    this.f7310s = null;
                }
            } else if (i5 == 2 || i5 == 3) {
                w0 w0Var2 = this.f7310s;
                if (!(w0Var2 == null || (l1Var = this.f7298g) == null)) {
                    Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + l1Var.c() + " on " + l1Var.b());
                    i iVar2 = this.f7301j;
                    String c6 = this.f7298g.c();
                    p.g(c6);
                    iVar2.e(c6, this.f7298g.b(), this.f7298g.a(), w0Var2, V(), this.f7298g.d());
                    this.C.incrementAndGet();
                }
                w0 w0Var3 = new w0(this, this.C.get());
                this.f7310s = w0Var3;
                l1 l1Var2 = (this.f7311t != 3 || A() == null) ? new l1(F(), E(), false, i.a(), H()) : new l1(x().getPackageName(), A(), true, i.a(), false);
                this.f7298g = l1Var2;
                if (l1Var2.d()) {
                    if (h() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f7298g.c())));
                    }
                }
                i iVar3 = this.f7301j;
                String c7 = this.f7298g.c();
                p.g(c7);
                if (!iVar3.f(new d1(c7, this.f7298g.b(), this.f7298g.a(), this.f7298g.d()), w0Var3, V(), v())) {
                    Log.w("GmsClient", "unable to connect to service: " + this.f7298g.c() + " on " + this.f7298g.b());
                    c0(16, (Bundle) null, this.C.get());
                }
            } else if (i5 == 4) {
                p.g(iInterface);
                J(iInterface);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String A() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> B() {
        return Collections.emptySet();
    }

    public final T C() {
        T t5;
        synchronized (this.f7304m) {
            if (this.f7311t != 5) {
                q();
                t5 = this.f7308q;
                p.h(t5, "Client is connected but service is null");
            } else {
                throw new DeadObjectException();
            }
        }
        return t5;
    }

    /* access modifiers changed from: protected */
    public abstract String D();

    /* access modifiers changed from: protected */
    public abstract String E();

    /* access modifiers changed from: protected */
    public String F() {
        return "com.google.android.gms";
    }

    public f G() {
        z0 z0Var = this.B;
        if (z0Var == null) {
            return null;
        }
        return z0Var.f7454h;
    }

    /* access modifiers changed from: protected */
    public boolean H() {
        return h() >= 211700000;
    }

    public boolean I() {
        return this.B != null;
    }

    /* access modifiers changed from: protected */
    public void J(T t5) {
        this.f7294c = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void K(t0.a aVar) {
        this.f7295d = aVar.a();
        this.f7296e = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void L(int i5) {
        this.f7292a = i5;
        this.f7293b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void M(int i5, IBinder iBinder, Bundle bundle, int i6) {
        Handler handler = this.f7303l;
        handler.sendMessage(handler.obtainMessage(1, i6, -1, new x0(this, i5, iBinder, bundle)));
    }

    public boolean N() {
        return false;
    }

    public void O(String str) {
        this.f7316y = str;
    }

    public void P(int i5) {
        Handler handler = this.f7303l;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i5));
    }

    public boolean Q() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String V() {
        String str = this.f7315x;
        return str == null ? this.f7299h.getClass().getName() : str;
    }

    public boolean a() {
        boolean z4;
        synchronized (this.f7304m) {
            z4 = this.f7311t == 4;
        }
        return z4;
    }

    public void b(C0119c cVar) {
        p.h(cVar, "Connection progress callbacks cannot be null.");
        this.f7307p = cVar;
        g0(2, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public final void c0(int i5, Bundle bundle, int i6) {
        Handler handler = this.f7303l;
        handler.sendMessage(handler.obtainMessage(7, i6, -1, new y0(this, i5, (Bundle) null)));
    }

    public void d(e eVar) {
        eVar.a();
    }

    public void e(String str) {
        this.f7297f = str;
        n();
    }

    public boolean f() {
        return true;
    }

    public void g(j jVar, Set<Scope> set) {
        Set<Scope> set2 = set;
        Bundle z4 = z();
        int i5 = this.f7314w;
        String str = this.f7316y;
        int i6 = t0.e.f6822a;
        Scope[] scopeArr = g.f7361s;
        Bundle bundle = new Bundle();
        t0.c[] cVarArr = g.f7362t;
        g gVar = r3;
        g gVar2 = new g(6, i5, i6, (String) null, (IBinder) null, scopeArr, bundle, (Account) null, cVarArr, cVarArr, true, 0, false, str);
        g gVar3 = gVar;
        gVar3.f7366h = this.f7299h.getPackageName();
        gVar3.f7369k = z4;
        if (set2 != null) {
            gVar3.f7368j = (Scope[]) set2.toArray(new Scope[0]);
        }
        if (o()) {
            Account t5 = t();
            if (t5 == null) {
                t5 = new Account("<<default account>>", "com.google");
            }
            gVar3.f7370l = t5;
            if (jVar != null) {
                gVar3.f7367i = jVar.asBinder();
            }
        } else if (N()) {
            gVar3.f7370l = t();
        }
        gVar3.f7371m = E;
        gVar3.f7372n = u();
        if (Q()) {
            gVar3.f7375q = true;
        }
        try {
            synchronized (this.f7305n) {
                m mVar = this.f7306o;
                if (mVar != null) {
                    mVar.g(new v0(this, this.C.get()), gVar3);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            P(3);
        } catch (SecurityException e6) {
            throw e6;
        } catch (RemoteException | RuntimeException e7) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e7);
            M(8, (IBinder) null, (Bundle) null, this.C.get());
        }
    }

    public int h() {
        return t0.e.f6822a;
    }

    public boolean i() {
        boolean z4;
        synchronized (this.f7304m) {
            int i5 = this.f7311t;
            z4 = true;
            if (i5 != 2) {
                if (i5 != 3) {
                    z4 = false;
                }
            }
        }
        return z4;
    }

    public final t0.c[] j() {
        z0 z0Var = this.B;
        if (z0Var == null) {
            return null;
        }
        return z0Var.f7452f;
    }

    public String k() {
        l1 l1Var;
        if (a() && (l1Var = this.f7298g) != null) {
            return l1Var.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public String l() {
        return this.f7297f;
    }

    public void n() {
        this.C.incrementAndGet();
        synchronized (this.f7309r) {
            int size = this.f7309r.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((u0) this.f7309r.get(i5)).d();
            }
            this.f7309r.clear();
        }
        synchronized (this.f7305n) {
            this.f7306o = null;
        }
        g0(1, (IInterface) null);
    }

    public boolean o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void q() {
        if (!a()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    public abstract T r(IBinder iBinder);

    /* access modifiers changed from: protected */
    public boolean s() {
        return false;
    }

    public Account t() {
        return null;
    }

    public t0.c[] u() {
        return E;
    }

    /* access modifiers changed from: protected */
    public Executor v() {
        return null;
    }

    public Bundle w() {
        return null;
    }

    public final Context x() {
        return this.f7299h;
    }

    public int y() {
        return this.f7314w;
    }

    /* access modifiers changed from: protected */
    public Bundle z() {
        return new Bundle();
    }
}
