package r1;

import g0.c;
import h0.a;
import r1.b;
import s1.b;

public final class p implements c<o> {

    /* renamed from: a  reason: collision with root package name */
    private final a<b> f6702a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b.a> f6703b;

    public p(a<s1.b> aVar, a<b.a> aVar2) {
        this.f6702a = aVar;
        this.f6703b = aVar2;
    }

    public static p a(a<s1.b> aVar, a<b.a> aVar2) {
        return new p(aVar, aVar2);
    }

    public static o c(s1.b bVar, a<b.a> aVar) {
        return new o(bVar, aVar);
    }

    /* renamed from: b */
    public o get() {
        return c(this.f6702a.get(), this.f6703b);
    }
}
