package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.e0;
import androidx.lifecycle.f;
import androidx.lifecycle.f0;
import androidx.lifecycle.k;
import w.a;
import y.c;
import y.d;

class a0 implements e, d, f0 {

    /* renamed from: e  reason: collision with root package name */
    private final Fragment f2178e;

    /* renamed from: f  reason: collision with root package name */
    private final e0 f2179f;

    /* renamed from: g  reason: collision with root package name */
    private k f2180g = null;

    /* renamed from: h  reason: collision with root package name */
    private c f2181h = null;

    a0(Fragment fragment, e0 e0Var) {
        this.f2178e = fragment;
        this.f2179f = e0Var;
    }

    /* access modifiers changed from: package-private */
    public void a(f.a aVar) {
        this.f2180g.h(aVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f2180g == null) {
            this.f2180g = new k(this);
            this.f2181h = c.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f2180g != null;
    }

    /* access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f2181h.d(bundle);
    }

    /* access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f2181h.e(bundle);
    }

    /* access modifiers changed from: package-private */
    public void f(f.b bVar) {
        this.f2180g.n(bVar);
    }

    public /* synthetic */ a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.d.a(this);
    }

    public f getLifecycle() {
        b();
        return this.f2180g;
    }

    public androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.f2181h.b();
    }

    public e0 getViewModelStore() {
        b();
        return this.f2179f;
    }
}
