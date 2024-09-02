package c4;

import kotlinx.coroutines.internal.f;
import kotlinx.coroutines.internal.f0;
import m3.k;
import m3.l;
import m3.q;
import o3.d;
import o3.g;

public final class r0 {
    public static final <T> void a(q0<? super T> q0Var, int i5) {
        d<? super T> d5 = q0Var.d();
        boolean z4 = i5 == 4;
        if (z4 || !(d5 instanceof f) || b(i5) != b(q0Var.f3153g)) {
            d(q0Var, d5, z4);
            return;
        }
        c0 c0Var = ((f) d5).f5588h;
        g context = d5.getContext();
        if (c0Var.N(context)) {
            c0Var.M(context, q0Var);
        } else {
            e(q0Var);
        }
    }

    public static final boolean b(int i5) {
        return i5 == 1 || i5 == 2;
    }

    public static final boolean c(int i5) {
        return i5 == 2;
    }

    public static final <T> void d(q0<? super T> q0Var, d<? super T> dVar, boolean z4) {
        Object obj;
        Object i5 = q0Var.i();
        Throwable e5 = q0Var.e(i5);
        if (e5 != null) {
            k.a aVar = k.f5898e;
            obj = l.a(e5);
        } else {
            k.a aVar2 = k.f5898e;
            obj = q0Var.g(i5);
        }
        Object a5 = k.a(obj);
        if (z4) {
            f fVar = (f) dVar;
            d<T> dVar2 = fVar.f5589i;
            Object obj2 = fVar.f5591k;
            g context = dVar2.getContext();
            Object c5 = f0.c(context, obj2);
            e2<?> f5 = c5 != f0.f5592a ? b0.f(dVar2, context, c5) : null;
            try {
                fVar.f5589i.resumeWith(a5);
                q qVar = q.f5904a;
            } finally {
                if (f5 == null || f5.E0()) {
                    f0.a(context, c5);
                }
            }
        } else {
            dVar.resumeWith(a5);
        }
    }

    private static final void e(q0<?> q0Var) {
        w0 a5 = c2.f3110a.a();
        if (a5.V()) {
            a5.R(q0Var);
            return;
        }
        a5.T(true);
        try {
            d(q0Var, q0Var.d(), true);
            do {
            } while (a5.X());
        } catch (Throwable th) {
            a5.P(true);
            throw th;
        }
        a5.P(true);
    }
}
