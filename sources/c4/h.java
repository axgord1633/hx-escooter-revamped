package c4;

import m3.q;
import o3.d;
import o3.g;
import v3.p;

final /* synthetic */ class h {
    public static final l1 a(g0 g0Var, g gVar, i0 i0Var, p<? super g0, ? super d<? super q>, ? extends Object> pVar) {
        g d5 = b0.d(g0Var, gVar);
        a u1Var = i0Var.i() ? new u1(d5, pVar) : new a2(d5, true);
        u1Var.C0(i0Var, u1Var, pVar);
        return u1Var;
    }

    public static /* synthetic */ l1 b(g0 g0Var, g gVar, i0 i0Var, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gVar = o3.h.f6161e;
        }
        if ((i5 & 2) != 0) {
            i0Var = i0.DEFAULT;
        }
        return g.a(g0Var, gVar, i0Var, pVar);
    }
}
