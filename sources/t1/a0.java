package t1;

import g0.c;
import h0.a;
import m2.k;
import p1.e0;
import y1.f0;

public final class a0 implements c<y> {

    /* renamed from: a  reason: collision with root package name */
    private final a<String> f6847a;

    /* renamed from: b  reason: collision with root package name */
    private final a<f0> f6848b;

    /* renamed from: c  reason: collision with root package name */
    private final a<k<e0.b>> f6849c;

    public a0(a<String> aVar, a<f0> aVar2, a<k<e0.b>> aVar3) {
        this.f6847a = aVar;
        this.f6848b = aVar2;
        this.f6849c = aVar3;
    }

    public static a0 a(a<String> aVar, a<f0> aVar2, a<k<e0.b>> aVar3) {
        return new a0(aVar, aVar2, aVar3);
    }

    public static y c(String str, f0 f0Var, k<e0.b> kVar) {
        return new y(str, f0Var, kVar);
    }

    /* renamed from: b */
    public y get() {
        return c(this.f6847a.get(), this.f6848b.get(), this.f6849c.get());
    }
}
