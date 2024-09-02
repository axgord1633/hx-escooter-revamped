package y1;

import g0.c;
import h0.a;

public final class q implements c<p> {

    /* renamed from: a  reason: collision with root package name */
    private final a<n> f7767a;

    /* renamed from: b  reason: collision with root package name */
    private final a<String[][]> f7768b;

    public q(a<n> aVar, a<String[][]> aVar2) {
        this.f7767a = aVar;
        this.f7768b = aVar2;
    }

    public static q a(a<n> aVar, a<String[][]> aVar2) {
        return new q(aVar, aVar2);
    }

    public static p c(n nVar, String[][] strArr) {
        return new p(nVar, strArr);
    }

    /* renamed from: b */
    public p get() {
        return c(this.f7767a.get(), this.f7768b.get());
    }
}
