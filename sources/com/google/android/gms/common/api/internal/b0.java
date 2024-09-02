package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import l1.h;
import u0.b;
import v0.r;

abstract class b0 extends r {

    /* renamed from: b  reason: collision with root package name */
    protected final h f3329b;

    public b0(int i5, h hVar) {
        super(i5);
        this.f3329b = hVar;
    }

    public final void a(Status status) {
        this.f3329b.d(new b(status));
    }

    public final void b(Exception exc) {
        this.f3329b.d(exc);
    }

    public final void c(r rVar) {
        try {
            h(rVar);
        } catch (DeadObjectException e5) {
            a(g0.e(e5));
            throw e5;
        } catch (RemoteException e6) {
            a(g0.e(e6));
        } catch (RuntimeException e7) {
            this.f3329b.d(e7);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void h(r rVar);
}
