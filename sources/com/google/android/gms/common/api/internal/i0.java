package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import v0.p;

final class i0 extends p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f3367a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j0 f3368b;

    i0(j0 j0Var, Dialog dialog) {
        this.f3368b = j0Var;
        this.f3367a = dialog;
    }

    public final void a() {
        this.f3368b.f3372f.o();
        if (this.f3367a.isShowing()) {
            this.f3367a.dismiss();
        }
    }
}
