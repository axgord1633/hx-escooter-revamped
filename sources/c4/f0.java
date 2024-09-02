package c4;

import o3.g;

public final class f0 {
    public static final void a(g gVar, Throwable th) {
        try {
            d0 d0Var = (d0) gVar.d(d0.f3113b);
            if (d0Var != null) {
                d0Var.j(gVar, th);
            } else {
                e0.a(gVar, th);
            }
        } catch (Throwable th2) {
            e0.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        b.a(runtimeException, th);
        return runtimeException;
    }
}
