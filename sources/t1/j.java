package t1;

import g0.c;
import g0.e;
import h0.a;
import m2.q;
import p1.r0;
import v1.x;

public final class j implements c<x> {

    /* renamed from: a  reason: collision with root package name */
    private final a<q> f6930a;

    /* renamed from: b  reason: collision with root package name */
    private final a<r0> f6931b;

    public j(a<q> aVar, a<r0> aVar2) {
        this.f6930a = aVar;
        this.f6931b = aVar2;
    }

    public static j a(a<q> aVar, a<r0> aVar2) {
        return new j(aVar, aVar2);
    }

    public static x c(q qVar, r0 r0Var) {
        return (x) e.d(d.f(qVar, r0Var));
    }

    /* renamed from: b */
    public x get() {
        return c(this.f6930a.get(), this.f6931b.get());
    }
}
