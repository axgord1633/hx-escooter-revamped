package t1;

import g0.c;
import g0.e;
import h0.a;

public final class i implements c<d0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Boolean> f6906a;

    /* renamed from: b  reason: collision with root package name */
    private final a<h0> f6907b;

    /* renamed from: c  reason: collision with root package name */
    private final a<m1> f6908c;

    public i(a<Boolean> aVar, a<h0> aVar2, a<m1> aVar3) {
        this.f6906a = aVar;
        this.f6907b = aVar2;
        this.f6908c = aVar3;
    }

    public static i a(a<Boolean> aVar, a<h0> aVar2, a<m1> aVar3) {
        return new i(aVar, aVar2, aVar3);
    }

    public static d0 c(boolean z4, a<h0> aVar, a<m1> aVar2) {
        return (d0) e.d(d.e(z4, aVar, aVar2));
    }

    /* renamed from: b */
    public d0 get() {
        return c(this.f6906a.get().booleanValue(), this.f6907b, this.f6908c);
    }
}
