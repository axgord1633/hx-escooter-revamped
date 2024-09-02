package p1;

import g0.c;
import g0.e;
import h0.a;
import m2.k;
import p1.a;
import y1.u;

public final class s implements c<k<Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f6524a;

    /* renamed from: b  reason: collision with root package name */
    private final a<u> f6525b;

    public s(a<Integer> aVar, a<u> aVar2) {
        this.f6524a = aVar;
        this.f6525b = aVar2;
    }

    public static s a(a<Integer> aVar, a<u> aVar2) {
        return new s(aVar, aVar2);
    }

    public static k<Boolean> c(int i5, u uVar) {
        return (k) e.d(a.c.r(i5, uVar));
    }

    /* renamed from: b */
    public k<Boolean> get() {
        return c(this.f6524a.get().intValue(), this.f6525b.get());
    }
}
