package com.google.android.gms.common.api.internal;

import t0.c;
import v0.b;
import v0.n;
import w0.o;

final class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f3401a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f3402b;

    /* synthetic */ s(b bVar, c cVar, n nVar) {
        this.f3401a = bVar;
        this.f3402b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof s)) {
            s sVar = (s) obj;
            return o.a(this.f3401a, sVar.f3401a) && o.a(this.f3402b, sVar.f3402b);
        }
    }

    public final int hashCode() {
        return o.b(this.f3401a, this.f3402b);
    }

    public final String toString() {
        return o.c(this).a("key", this.f3401a).a("feature", this.f3402b).toString();
    }
}
