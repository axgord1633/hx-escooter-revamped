package p1;

import g0.c;
import g0.e;
import h0.a;
import p1.a;

public final class u implements c<String[][]> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f6530a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Integer> f6531b;

    public u(a<Integer> aVar, a<Integer> aVar2) {
        this.f6530a = aVar;
        this.f6531b = aVar2;
    }

    public static u a(a<Integer> aVar, a<Integer> aVar2) {
        return new u(aVar, aVar2);
    }

    public static String[][] c(int i5, int i6) {
        return (String[][]) e.d(a.c.t(i5, i6));
    }

    /* renamed from: b */
    public String[][] get() {
        return c(this.f6530a.get().intValue(), this.f6531b.get().intValue());
    }
}
