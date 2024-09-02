package com.google.android.gms.common.api.internal;

import l1.h;
import t0.c;
import u0.a;
import u0.a.b;
import v0.d0;
import v0.i;
import w0.p;

public abstract class g<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final c[] f3354a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3355b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3356c;

    public static class a<A extends a.b, ResultT> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public i f3357a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3358b = true;

        /* renamed from: c  reason: collision with root package name */
        private c[] f3359c;

        /* renamed from: d  reason: collision with root package name */
        private int f3360d = 0;

        /* synthetic */ a(d0 d0Var) {
        }

        public g<A, ResultT> a() {
            p.b(this.f3357a != null, "execute parameter required");
            return new a0(this, this.f3359c, this.f3358b, this.f3360d);
        }

        public a<A, ResultT> b(i<A, h<ResultT>> iVar) {
            this.f3357a = iVar;
            return this;
        }

        public a<A, ResultT> c(boolean z4) {
            this.f3358b = z4;
            return this;
        }

        public a<A, ResultT> d(c... cVarArr) {
            this.f3359c = cVarArr;
            return this;
        }

        public a<A, ResultT> e(int i5) {
            this.f3360d = i5;
            return this;
        }
    }

    protected g(c[] cVarArr, boolean z4, int i5) {
        this.f3354a = cVarArr;
        boolean z5 = false;
        if (cVarArr != null && z4) {
            z5 = true;
        }
        this.f3355b = z5;
        this.f3356c = i5;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>((d0) null);
    }

    /* access modifiers changed from: protected */
    public abstract void b(A a5, h<ResultT> hVar);

    public boolean c() {
        return this.f3355b;
    }

    public final int d() {
        return this.f3356c;
    }

    public final c[] e() {
        return this.f3354a;
    }
}
