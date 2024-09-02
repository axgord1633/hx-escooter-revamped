package v0;

import com.google.android.gms.common.api.internal.LifecycleCallback;

final class h0 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f7138e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7139f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ i0 f7140g;

    h0(i0 i0Var, LifecycleCallback lifecycleCallback, String str) {
        this.f7140g = i0Var;
        this.f7138e = lifecycleCallback;
        this.f7139f = str;
    }

    public final void run() {
        i0 i0Var = this.f7140g;
        if (i0Var.f7143f > 0) {
            this.f7138e.f(i0Var.f7144g != null ? i0Var.f7144g.getBundle(this.f7139f) : null);
        }
        if (this.f7140g.f7143f >= 2) {
            this.f7138e.j();
        }
        if (this.f7140g.f7143f >= 3) {
            this.f7138e.h();
        }
        if (this.f7140g.f7143f >= 4) {
            this.f7138e.k();
        }
        if (this.f7140g.f7143f >= 5) {
            this.f7138e.g();
        }
    }
}
