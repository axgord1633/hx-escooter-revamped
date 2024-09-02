package com.google.android.gms.common.api.internal;

import android.app.Activity;
import m.b;
import t0.a;
import t0.d;
import v0.f;
import w0.p;

public final class k extends k0 {

    /* renamed from: j  reason: collision with root package name */
    private final b f3373j = new b();

    /* renamed from: k  reason: collision with root package name */
    private final b f3374k;

    k(f fVar, b bVar, d dVar) {
        super(fVar, dVar);
        this.f3374k = bVar;
        this.f3301e.a("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, b bVar, v0.b bVar2) {
        f c5 = LifecycleCallback.c(activity);
        k kVar = (k) c5.b("ConnectionlessLifecycleHelper", k.class);
        if (kVar == null) {
            kVar = new k(c5, bVar, d.k());
        }
        p.h(bVar2, "ApiKey cannot be null");
        kVar.f3373j.add(bVar2);
        bVar.c(kVar);
    }

    private final void v() {
        if (!this.f3373j.isEmpty()) {
            this.f3374k.c(this);
        }
    }

    public final void h() {
        super.h();
        v();
    }

    public final void j() {
        super.j();
        v();
    }

    public final void k() {
        super.k();
        this.f3374k.d(this);
    }

    /* access modifiers changed from: protected */
    public final void m(a aVar, int i5) {
        this.f3374k.H(aVar, i5);
    }

    /* access modifiers changed from: protected */
    public final void n() {
        this.f3374k.a();
    }

    /* access modifiers changed from: package-private */
    public final b t() {
        return this.f3373j;
    }
}
