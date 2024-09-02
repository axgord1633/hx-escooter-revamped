package p1;

import g0.c;
import g0.e;
import h0.a;
import p1.a;
import y1.b0;
import y1.w;
import y1.x;
import y1.z;

public final class t implements c<w> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Integer> f6526a;

    /* renamed from: b  reason: collision with root package name */
    private final a<x> f6527b;

    /* renamed from: c  reason: collision with root package name */
    private final a<z> f6528c;

    /* renamed from: d  reason: collision with root package name */
    private final a<b0> f6529d;

    public t(a<Integer> aVar, a<x> aVar2, a<z> aVar3, a<b0> aVar4) {
        this.f6526a = aVar;
        this.f6527b = aVar2;
        this.f6528c = aVar3;
        this.f6529d = aVar4;
    }

    public static t a(a<Integer> aVar, a<x> aVar2, a<z> aVar3, a<b0> aVar4) {
        return new t(aVar, aVar2, aVar3, aVar4);
    }

    public static w c(int i5, a<x> aVar, a<z> aVar2, a<b0> aVar3) {
        return (w) e.d(a.c.s(i5, aVar, aVar2, aVar3));
    }

    /* renamed from: b */
    public w get() {
        return c(this.f6526a.get().intValue(), this.f6527b, this.f6528c, this.f6529d);
    }
}
