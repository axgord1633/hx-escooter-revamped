package p1;

import g0.c;
import g0.e;
import h0.a;
import p1.a;
import w1.s;
import w1.t;
import w1.v;

public final class w implements c<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f6535a;

    /* renamed from: b  reason: collision with root package name */
    private final a<t> f6536b;

    /* renamed from: c  reason: collision with root package name */
    private final a<v> f6537c;

    public w(a<Integer> aVar, a<t> aVar2, a<v> aVar3) {
        this.f6535a = aVar;
        this.f6536b = aVar2;
        this.f6537c = aVar3;
    }

    public static w a(a<Integer> aVar, a<t> aVar2, a<v> aVar3) {
        return new w(aVar, aVar2, aVar3);
    }

    public static s c(int i5, a<t> aVar, a<v> aVar2) {
        return (s) e.d(a.c.v(i5, aVar, aVar2));
    }

    /* renamed from: b */
    public s get() {
        return c(this.f6535a.get().intValue(), this.f6536b, this.f6537c);
    }
}
