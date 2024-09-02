package com.google.android.gms.common.api.internal;

import android.util.Log;
import java.util.Set;
import u0.a;
import v0.b;
import v0.b0;
import w0.c;
import w0.j;

final class u implements c.C0119c, b0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a.f f3405a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b f3406b;

    /* renamed from: c  reason: collision with root package name */
    private j f3407c = null;

    /* renamed from: d  reason: collision with root package name */
    private Set f3408d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f3409e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ b f3410f;

    public u(b bVar, a.f fVar, b bVar2) {
        this.f3410f = bVar;
        this.f3405a = fVar;
        this.f3406b = bVar2;
    }

    /* access modifiers changed from: private */
    public final void h() {
        j jVar;
        if (this.f3409e && (jVar = this.f3407c) != null) {
            this.f3405a.g(jVar, this.f3408d);
        }
    }

    public final void a(j jVar, Set set) {
        if (jVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new t0.a(4));
            return;
        }
        this.f3407c = jVar;
        this.f3408d = set;
        h();
    }

    public final void b(t0.a aVar) {
        r rVar = (r) this.f3410f.f3323l.get(this.f3406b);
        if (rVar != null) {
            rVar.I(aVar);
        }
    }

    public final void c(t0.a aVar) {
        this.f3410f.f3327p.post(new t(this, aVar));
    }
}
