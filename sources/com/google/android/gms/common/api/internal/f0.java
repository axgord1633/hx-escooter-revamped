package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;
import l1.h;
import v0.v;

public final class f0 extends b0 {

    /* renamed from: c  reason: collision with root package name */
    public final c.a f3353c;

    public f0(c.a aVar, h hVar) {
        super(4, hVar);
        this.f3353c = aVar;
    }

    public final /* bridge */ /* synthetic */ void d(j jVar, boolean z4) {
    }

    public final boolean f(r rVar) {
        v vVar = (v) rVar.x().get(this.f3353c);
        return vVar != null && vVar.f7163a.f();
    }

    public final t0.c[] g(r rVar) {
        v vVar = (v) rVar.x().get(this.f3353c);
        if (vVar == null) {
            return null;
        }
        return vVar.f7163a.c();
    }

    public final void h(r rVar) {
        v vVar = (v) rVar.x().remove(this.f3353c);
        if (vVar != null) {
            vVar.f7164b.b(rVar.v(), this.f3329b);
            vVar.f7163a.a();
            return;
        }
        this.f3329b.e(Boolean.FALSE);
    }
}
