package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;
import t0.a;
import w0.p;

final class j0 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    private final h0 f3371e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ k0 f3372f;

    j0(k0 k0Var, h0 h0Var) {
        this.f3372f = k0Var;
        this.f3371e = h0Var;
    }

    public final void run() {
        if (this.f3372f.f3375f) {
            a b5 = this.f3371e.b();
            if (b5.d()) {
                k0 k0Var = this.f3372f;
                k0Var.f3301e.startActivityForResult(GoogleApiActivity.a(k0Var.b(), (PendingIntent) p.g(b5.c()), this.f3371e.a(), false), 1);
                return;
            }
            k0 k0Var2 = this.f3372f;
            if (k0Var2.f3378i.a(k0Var2.b(), b5.a(), (String) null) != null) {
                k0 k0Var3 = this.f3372f;
                k0Var3.f3378i.t(k0Var3.b(), this.f3372f.f3301e, b5.a(), 2, this.f3372f);
            } else if (b5.a() == 18) {
                k0 k0Var4 = this.f3372f;
                Dialog o5 = k0Var4.f3378i.o(k0Var4.b(), this.f3372f);
                k0 k0Var5 = this.f3372f;
                k0Var5.f3378i.p(k0Var5.b().getApplicationContext(), new i0(this, o5));
            } else {
                this.f3372f.l(b5, this.f3371e.a());
            }
        }
    }
}
