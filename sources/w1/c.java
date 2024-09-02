package w1;

import h0.a;

public final class c implements g0.c<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f7480a;

    public c(a<Integer> aVar) {
        this.f7480a = aVar;
    }

    public static c a(a<Integer> aVar) {
        return new c(aVar);
    }

    public static b c(int i5) {
        return new b(i5);
    }

    /* renamed from: b */
    public b get() {
        return c(this.f7480a.get().intValue());
    }
}
