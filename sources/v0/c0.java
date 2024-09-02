package v0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import j1.e;
import java.util.Set;
import k1.d;
import k1.l;
import u0.a;
import u0.f;
import w0.l0;
import w0.p;

public final class c0 extends d implements f.a, f.b {

    /* renamed from: i  reason: collision with root package name */
    private static final a.C0113a f7112i = e.f5444c;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7113b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f7114c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0113a f7115d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f7116e;

    /* renamed from: f  reason: collision with root package name */
    private final w0.e f7117f;

    /* renamed from: g  reason: collision with root package name */
    private j1.f f7118g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public b0 f7119h;

    public c0(Context context, Handler handler, w0.e eVar) {
        a.C0113a aVar = f7112i;
        this.f7113b = context;
        this.f7114c = handler;
        this.f7117f = (w0.e) p.h(eVar, "ClientSettings must not be null");
        this.f7116e = eVar.e();
        this.f7115d = aVar;
    }

    static /* bridge */ /* synthetic */ void B(c0 c0Var, l lVar) {
        t0.a a5 = lVar.a();
        if (a5.e()) {
            l0 l0Var = (l0) p.g(lVar.b());
            a5 = l0Var.a();
            if (!a5.e()) {
                String valueOf = String.valueOf(a5);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
            } else {
                c0Var.f7119h.a(l0Var.b(), c0Var.f7116e);
                c0Var.f7118g.n();
            }
        }
        c0Var.f7119h.b(a5);
        c0Var.f7118g.n();
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [u0.a$f, j1.f] */
    public final void C(b0 b0Var) {
        j1.f fVar = this.f7118g;
        if (fVar != null) {
            fVar.n();
        }
        this.f7117f.i(Integer.valueOf(System.identityHashCode(this)));
        a.C0113a aVar = this.f7115d;
        Context context = this.f7113b;
        Looper looper = this.f7114c.getLooper();
        w0.e eVar = this.f7117f;
        this.f7118g = aVar.a(context, looper, eVar, eVar.f(), this, this);
        this.f7119h = b0Var;
        Set set = this.f7116e;
        if (set == null || set.isEmpty()) {
            this.f7114c.post(new z(this));
        } else {
            this.f7118g.p();
        }
    }

    public final void D() {
        j1.f fVar = this.f7118g;
        if (fVar != null) {
            fVar.n();
        }
    }

    public final void a(t0.a aVar) {
        this.f7119h.b(aVar);
    }

    public final void c(int i5) {
        this.f7118g.n();
    }

    public final void e(Bundle bundle) {
        this.f7118g.m(this);
    }

    public final void s(l lVar) {
        this.f7114c.post(new a0(this, lVar));
    }
}
