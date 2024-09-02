package p1;

import g0.c;
import g0.e;
import h0.a;
import p1.a;
import w1.k;
import w1.l;
import w1.o;

public final class p implements c<k> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f6516a;

    /* renamed from: b  reason: collision with root package name */
    private final a<l> f6517b;

    /* renamed from: c  reason: collision with root package name */
    private final a<o> f6518c;

    public p(a<Integer> aVar, a<l> aVar2, a<o> aVar3) {
        this.f6516a = aVar;
        this.f6517b = aVar2;
        this.f6518c = aVar3;
    }

    public static p a(a<Integer> aVar, a<l> aVar2, a<o> aVar3) {
        return new p(aVar, aVar2, aVar3);
    }

    public static k c(int i5, a<l> aVar, a<o> aVar2) {
        return (k) e.d(a.c.o(i5, aVar, aVar2));
    }

    /* renamed from: b */
    public k get() {
        return c(this.f6516a.get().intValue(), this.f6517b, this.f6518c);
    }
}
