package p1;

import g0.c;
import g0.e;
import h0.a;
import p1.a;
import w1.d0;
import w1.e0;
import w1.g0;
import w1.i0;

public final class x implements c<d0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f6538a;

    /* renamed from: b  reason: collision with root package name */
    private final a<e0> f6539b;

    /* renamed from: c  reason: collision with root package name */
    private final a<g0> f6540c;

    /* renamed from: d  reason: collision with root package name */
    private final a<i0> f6541d;

    public x(a<Integer> aVar, a<e0> aVar2, a<g0> aVar3, a<i0> aVar4) {
        this.f6538a = aVar;
        this.f6539b = aVar2;
        this.f6540c = aVar3;
        this.f6541d = aVar4;
    }

    public static x a(a<Integer> aVar, a<e0> aVar2, a<g0> aVar3, a<i0> aVar4) {
        return new x(aVar, aVar2, aVar3, aVar4);
    }

    public static d0 c(int i5, a<e0> aVar, a<g0> aVar2, a<i0> aVar3) {
        return (d0) e.d(a.c.w(i5, aVar, aVar2, aVar3));
    }

    /* renamed from: b */
    public d0 get() {
        return c(this.f6538a.get().intValue(), this.f6539b, this.f6540c, this.f6541d);
    }
}
