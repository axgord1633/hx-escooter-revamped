package y1;

import g0.c;
import h0.a;

public final class c0 implements c<b0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<l> f7727a;

    /* renamed from: b  reason: collision with root package name */
    private final a<p> f7728b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Boolean> f7729c;

    /* renamed from: d  reason: collision with root package name */
    private final a<Boolean> f7730d;

    public c0(a<l> aVar, a<p> aVar2, a<Boolean> aVar3, a<Boolean> aVar4) {
        this.f7727a = aVar;
        this.f7728b = aVar2;
        this.f7729c = aVar3;
        this.f7730d = aVar4;
    }

    public static c0 a(a<l> aVar, a<p> aVar2, a<Boolean> aVar3, a<Boolean> aVar4) {
        return new c0(aVar, aVar2, aVar3, aVar4);
    }

    public static b0 c(l lVar, p pVar, boolean z4, boolean z5) {
        return new b0(lVar, pVar, z4, z5);
    }

    /* renamed from: b */
    public b0 get() {
        return c(this.f7727a.get(), this.f7728b.get(), this.f7729c.get().booleanValue(), this.f7730d.get().booleanValue());
    }
}
