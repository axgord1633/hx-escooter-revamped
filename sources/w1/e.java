package w1;

import g0.c;
import h0.a;
import y1.f0;

public final class e implements c<d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f0> f7487a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b> f7488b;

    /* renamed from: c  reason: collision with root package name */
    private final a<g> f7489c;

    /* renamed from: d  reason: collision with root package name */
    private final a<i> f7490d;

    public e(a<f0> aVar, a<b> aVar2, a<g> aVar3, a<i> aVar4) {
        this.f7487a = aVar;
        this.f7488b = aVar2;
        this.f7489c = aVar3;
        this.f7490d = aVar4;
    }

    public static e a(a<f0> aVar, a<b> aVar2, a<g> aVar3, a<i> aVar4) {
        return new e(aVar, aVar2, aVar3, aVar4);
    }

    public static d c(f0 f0Var, b bVar, g gVar, i iVar) {
        return new d(f0Var, bVar, gVar, iVar);
    }

    /* renamed from: b */
    public d get() {
        return c(this.f7487a.get(), this.f7488b.get(), this.f7489c.get(), this.f7490d.get());
    }
}
