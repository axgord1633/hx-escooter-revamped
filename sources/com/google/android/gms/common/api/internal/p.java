package com.google.android.gms.common.api.internal;

final class p implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ q f3386e;

    p(q qVar) {
        this.f3386e = qVar;
    }

    public final void run() {
        r rVar = this.f3386e.f3387a;
        rVar.f3389c.e(rVar.f3389c.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
