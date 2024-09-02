package y1;

import g0.c;
import h0.a;

public final class k implements c<j> {

    /* renamed from: a  reason: collision with root package name */
    private final a<n> f7756a;

    /* renamed from: b  reason: collision with root package name */
    private final a<String[][]> f7757b;

    public k(a<n> aVar, a<String[][]> aVar2) {
        this.f7756a = aVar;
        this.f7757b = aVar2;
    }

    public static k a(a<n> aVar, a<String[][]> aVar2) {
        return new k(aVar, aVar2);
    }

    public static j c(n nVar, String[][] strArr) {
        return new j(nVar, strArr);
    }

    /* renamed from: b */
    public j get() {
        return c(this.f7756a.get(), this.f7757b.get());
    }
}
