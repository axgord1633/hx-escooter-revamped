package c4;

import java.util.concurrent.CancellationException;
import o3.g;

final /* synthetic */ class q1 {
    public static final t a(l1 l1Var) {
        return new o1(l1Var);
    }

    public static /* synthetic */ t b(l1 l1Var, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            l1Var = null;
        }
        return p1.a(l1Var);
    }

    public static final void c(g gVar, CancellationException cancellationException) {
        l1 l1Var = (l1) gVar.d(l1.f3142c);
        if (l1Var != null) {
            l1Var.F(cancellationException);
        }
    }

    public static /* synthetic */ void d(g gVar, CancellationException cancellationException, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            cancellationException = null;
        }
        p1.c(gVar, cancellationException);
    }

    public static final void e(l1 l1Var) {
        if (!l1Var.b()) {
            throw l1Var.z();
        }
    }

    public static final void f(g gVar) {
        l1 l1Var = (l1) gVar.d(l1.f3142c);
        if (l1Var != null) {
            p1.e(l1Var);
        }
    }
}
