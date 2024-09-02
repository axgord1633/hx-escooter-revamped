package w1;

import g0.c;
import h0.a;
import y1.f0;

public final class j0 implements c<i0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f0> f7520a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g> f7521b;

    /* renamed from: c  reason: collision with root package name */
    private final a<a0> f7522c;

    /* renamed from: d  reason: collision with root package name */
    private final a<b> f7523d;

    public j0(a<f0> aVar, a<g> aVar2, a<a0> aVar3, a<b> aVar4) {
        this.f7520a = aVar;
        this.f7521b = aVar2;
        this.f7522c = aVar3;
        this.f7523d = aVar4;
    }

    public static j0 a(a<f0> aVar, a<g> aVar2, a<a0> aVar3, a<b> aVar4) {
        return new j0(aVar, aVar2, aVar3, aVar4);
    }

    public static i0 c(f0 f0Var, g gVar, a0 a0Var, b bVar) {
        return new i0(f0Var, gVar, a0Var, bVar);
    }

    /* renamed from: b */
    public i0 get() {
        return c(this.f7520a.get(), this.f7521b.get(), this.f7522c.get(), this.f7523d.get());
    }
}
