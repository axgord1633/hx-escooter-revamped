package p1;

import g0.c;
import g0.e;
import h0.a;
import p1.a;

public final class v implements c<String[][]> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f6532a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Integer> f6533b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Boolean> f6534c;

    public v(a<Integer> aVar, a<Integer> aVar2, a<Boolean> aVar3) {
        this.f6532a = aVar;
        this.f6533b = aVar2;
        this.f6534c = aVar3;
    }

    public static v a(a<Integer> aVar, a<Integer> aVar2, a<Boolean> aVar3) {
        return new v(aVar, aVar2, aVar3);
    }

    public static String[][] c(int i5, int i6, boolean z4) {
        return (String[][]) e.d(a.c.u(i5, i6, z4));
    }

    /* renamed from: b */
    public String[][] get() {
        return c(this.f6532a.get().intValue(), this.f6533b.get().intValue(), this.f6534c.get().booleanValue());
    }
}
