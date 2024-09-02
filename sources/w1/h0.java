package w1;

import g0.c;
import h0.a;
import y1.f0;

public final class h0 implements c<g0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f0> f7510a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g> f7511b;

    /* renamed from: c  reason: collision with root package name */
    private final a<a0> f7512c;

    /* renamed from: d  reason: collision with root package name */
    private final a<b> f7513d;

    public h0(a<f0> aVar, a<g> aVar2, a<a0> aVar3, a<b> aVar4) {
        this.f7510a = aVar;
        this.f7511b = aVar2;
        this.f7512c = aVar3;
        this.f7513d = aVar4;
    }

    public static h0 a(a<f0> aVar, a<g> aVar2, a<a0> aVar3, a<b> aVar4) {
        return new h0(aVar, aVar2, aVar3, aVar4);
    }

    public static g0 c(f0 f0Var, g gVar, a0 a0Var, b bVar) {
        return new g0(f0Var, gVar, a0Var, bVar);
    }

    /* renamed from: b */
    public g0 get() {
        return c(this.f7510a.get(), this.f7511b.get(), this.f7512c.get(), this.f7513d.get());
    }
}
