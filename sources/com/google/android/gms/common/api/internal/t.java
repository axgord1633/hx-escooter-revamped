package com.google.android.gms.common.api.internal;

import android.util.Log;
import t0.a;
import w0.j;

final class t implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ a f3403e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ u f3404f;

    t(u uVar, a aVar) {
        this.f3404f = uVar;
        this.f3403e = aVar;
    }

    public final void run() {
        u uVar = this.f3404f;
        r rVar = (r) uVar.f3410f.f3323l.get(uVar.f3406b);
        if (rVar != null) {
            if (this.f3403e.e()) {
                this.f3404f.f3409e = true;
                if (this.f3404f.f3405a.o()) {
                    this.f3404f.h();
                    return;
                }
                try {
                    u uVar2 = this.f3404f;
                    uVar2.f3405a.g((j) null, uVar2.f3405a.c());
                } catch (SecurityException e5) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e5);
                    this.f3404f.f3405a.e("Failed to get service from broker.");
                    rVar.H(new a(10), (Exception) null);
                }
            } else {
                rVar.H(this.f3403e, (Exception) null);
            }
        }
    }
}
