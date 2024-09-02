package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;
import l1.h;
import t0.c;
import u0.a;
import u0.a.b;

public abstract class e<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    private final c f3336a;

    /* renamed from: b  reason: collision with root package name */
    private final c[] f3337b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3338c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3339d;

    protected e(c<L> cVar, c[] cVarArr, boolean z4, int i5) {
        this.f3336a = cVar;
        this.f3337b = cVarArr;
        this.f3338c = z4;
        this.f3339d = i5;
    }

    public void a() {
        this.f3336a.a();
    }

    public c.a<L> b() {
        return this.f3336a.b();
    }

    public t0.c[] c() {
        return this.f3337b;
    }

    /* access modifiers changed from: protected */
    public abstract void d(A a5, h<Void> hVar);

    public final int e() {
        return this.f3339d;
    }

    public final boolean f() {
        return this.f3338c;
    }
}
