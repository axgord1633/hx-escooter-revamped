package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import l1.h;
import t0.c;
import v0.j;
import v0.r;

public final class e0 extends r {

    /* renamed from: b  reason: collision with root package name */
    private final g f3340b;

    /* renamed from: c  reason: collision with root package name */
    private final h f3341c;

    /* renamed from: d  reason: collision with root package name */
    private final j f3342d;

    public e0(int i5, g gVar, h hVar, j jVar) {
        super(i5);
        this.f3341c = hVar;
        this.f3340b = gVar;
        this.f3342d = jVar;
        if (i5 == 2 && gVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void a(Status status) {
        this.f3341c.d(this.f3342d.a(status));
    }

    public final void b(Exception exc) {
        this.f3341c.d(exc);
    }

    public final void c(r rVar) {
        try {
            this.f3340b.b(rVar.v(), this.f3341c);
        } catch (DeadObjectException e5) {
            throw e5;
        } catch (RemoteException e6) {
            a(g0.e(e6));
        } catch (RuntimeException e7) {
            this.f3341c.d(e7);
        }
    }

    public final void d(j jVar, boolean z4) {
        jVar.b(this.f3341c, z4);
    }

    public final boolean f(r rVar) {
        return this.f3340b.c();
    }

    public final c[] g(r rVar) {
        return this.f3340b.e();
    }
}
