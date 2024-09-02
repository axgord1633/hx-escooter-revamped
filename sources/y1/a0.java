package y1;

import g0.c;
import h0.a;

public final class a0 implements c<z> {

    /* renamed from: a  reason: collision with root package name */
    private final a<l> f7716a;

    /* renamed from: b  reason: collision with root package name */
    private final a<p> f7717b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Integer> f7718c;

    /* renamed from: d  reason: collision with root package name */
    private final a<Integer> f7719d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Boolean> f7720e;

    public a0(a<l> aVar, a<p> aVar2, a<Integer> aVar3, a<Integer> aVar4, a<Boolean> aVar5) {
        this.f7716a = aVar;
        this.f7717b = aVar2;
        this.f7718c = aVar3;
        this.f7719d = aVar4;
        this.f7720e = aVar5;
    }

    public static a0 a(a<l> aVar, a<p> aVar2, a<Integer> aVar3, a<Integer> aVar4, a<Boolean> aVar5) {
        return new a0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static z c(l lVar, p pVar, int i5, int i6, boolean z4) {
        return new z(lVar, pVar, i5, i6, z4);
    }

    /* renamed from: b */
    public z get() {
        return c(this.f7716a.get(), this.f7717b.get(), this.f7718c.get().intValue(), this.f7719d.get().intValue(), this.f7720e.get().booleanValue());
    }
}
