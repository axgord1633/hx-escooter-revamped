package p2;

import t2.a;
import t2.b;

public final class d {
    public static c a() {
        return s2.d.INSTANCE;
    }

    public static c b() {
        return d(a.f7033b);
    }

    public static c c(r2.a aVar) {
        b.e(aVar, "run is null");
        return new a(aVar);
    }

    public static c d(Runnable runnable) {
        b.e(runnable, "run is null");
        return new f(runnable);
    }
}
