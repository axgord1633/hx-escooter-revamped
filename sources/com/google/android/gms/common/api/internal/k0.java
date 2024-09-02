package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import e1.k;
import java.util.concurrent.atomic.AtomicReference;
import t0.a;
import t0.d;
import v0.f;
import v0.f0;

public abstract class k0 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: f  reason: collision with root package name */
    protected volatile boolean f3375f;

    /* renamed from: g  reason: collision with root package name */
    protected final AtomicReference f3376g = new AtomicReference((Object) null);

    /* renamed from: h  reason: collision with root package name */
    private final Handler f3377h = new k(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    protected final d f3378i;

    k0(f fVar, d dVar) {
        super(fVar);
        this.f3378i = dVar;
    }

    /* access modifiers changed from: private */
    public final void l(a aVar, int i5) {
        this.f3376g.set((Object) null);
        m(aVar, i5);
    }

    /* access modifiers changed from: private */
    public final void o() {
        this.f3376g.set((Object) null);
        n();
    }

    private static final int p(h0 h0Var) {
        if (h0Var == null) {
            return -1;
        }
        return h0Var.a();
    }

    public final void e(int i5, int i6, Intent intent) {
        h0 h0Var = (h0) this.f3376g.get();
        if (i5 != 1) {
            if (i5 == 2) {
                int e5 = this.f3378i.e(b());
                if (e5 == 0) {
                    o();
                    return;
                } else if (h0Var != null) {
                    if (h0Var.b().a() == 18 && e5 == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i6 == -1) {
            o();
            return;
        } else if (i6 == 0) {
            if (h0Var != null) {
                int i7 = 13;
                if (intent != null) {
                    i7 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                l(new a(i7, (PendingIntent) null, h0Var.b().toString()), p(h0Var));
                return;
            }
            return;
        }
        if (h0Var != null) {
            l(h0Var.b(), h0Var.a());
        }
    }

    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f3376g.set(bundle.getBoolean("resolving_error", false) ? new h0(new a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void i(Bundle bundle) {
        super.i(bundle);
        h0 h0Var = (h0) this.f3376g.get();
        if (h0Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", h0Var.a());
            bundle.putInt("failed_status", h0Var.b().a());
            bundle.putParcelable("failed_resolution", h0Var.b().c());
        }
    }

    public void j() {
        super.j();
        this.f3375f = true;
    }

    public void k() {
        super.k();
        this.f3375f = false;
    }

    /* access modifiers changed from: protected */
    public abstract void m(a aVar, int i5);

    /* access modifiers changed from: protected */
    public abstract void n();

    public final void onCancel(DialogInterface dialogInterface) {
        l(new a(13, (PendingIntent) null), p((h0) this.f3376g.get()));
    }

    public final void s(a aVar, int i5) {
        h0 h0Var = new h0(aVar, i5);
        AtomicReference atomicReference = this.f3376g;
        while (!f0.a(atomicReference, (Object) null, h0Var)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.f3377h.post(new j0(this, h0Var));
    }
}
