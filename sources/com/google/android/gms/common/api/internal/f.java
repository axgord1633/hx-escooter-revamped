package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;
import l1.h;
import t0.c;
import u0.a;
import u0.a.b;
import v0.i;
import v0.w;
import v0.x;
import v0.y;
import w0.p;

public class f<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    public final e<A, L> f3343a;

    /* renamed from: b  reason: collision with root package name */
    public final h f3344b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f3345c;

    public static class a<A extends a.b, L> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public i f3346a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public i f3347b;

        /* renamed from: c  reason: collision with root package name */
        private Runnable f3348c = w.f7166e;

        /* renamed from: d  reason: collision with root package name */
        private c f3349d;

        /* renamed from: e  reason: collision with root package name */
        private c[] f3350e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3351f = true;

        /* renamed from: g  reason: collision with root package name */
        private int f3352g;

        /* synthetic */ a(x xVar) {
        }

        public f<A, L> a() {
            boolean z4 = true;
            p.b(this.f3346a != null, "Must set register function");
            p.b(this.f3347b != null, "Must set unregister function");
            if (this.f3349d == null) {
                z4 = false;
            }
            p.b(z4, "Must set holder");
            return new f<>(new y(this, this.f3349d, this.f3350e, this.f3351f, this.f3352g), new z(this, (c.a) p.h(this.f3349d.b(), "Key must not be null")), this.f3348c, (y) null);
        }

        public a<A, L> b(i<A, h<Void>> iVar) {
            this.f3346a = iVar;
            return this;
        }

        public a<A, L> c(int i5) {
            this.f3352g = i5;
            return this;
        }

        public a<A, L> d(i<A, h<Boolean>> iVar) {
            this.f3347b = iVar;
            return this;
        }

        public a<A, L> e(c<L> cVar) {
            this.f3349d = cVar;
            return this;
        }
    }

    /* synthetic */ f(e eVar, h hVar, Runnable runnable, y yVar) {
        this.f3343a = eVar;
        this.f3344b = hVar;
        this.f3345c = runnable;
    }

    public static <A extends a.b, L> a<A, L> a() {
        return new a<>((x) null);
    }
}
