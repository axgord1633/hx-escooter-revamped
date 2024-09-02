package v0;

import com.google.android.gms.common.api.internal.LifecycleCallback;

final class j0 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f7145e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7146f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ k0 f7147g;

    j0(k0 k0Var, LifecycleCallback lifecycleCallback, String str) {
        this.f7147g = k0Var;
        this.f7145e = lifecycleCallback;
        this.f7146f = str;
    }

    public final void run() {
        k0 k0Var = this.f7147g;
        if (k0Var.f7150f > 0) {
            this.f7145e.f(k0Var.f7151g != null ? k0Var.f7151g.getBundle(this.f7146f) : null);
        }
        if (this.f7147g.f7150f >= 2) {
            this.f7145e.j();
        }
        if (this.f7147g.f7150f >= 3) {
            this.f7145e.h();
        }
        if (this.f7147g.f7150f >= 4) {
            this.f7145e.k();
        }
        if (this.f7147g.f7150f >= 5) {
            this.f7145e.g();
        }
    }
}
