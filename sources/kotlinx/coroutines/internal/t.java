package kotlinx.coroutines.internal;

import c4.v1;
import java.util.List;
import m3.d;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f5633a = true;

    private static final u a(Throwable th, String str) {
        if (f5633a) {
            return new u(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new d();
    }

    static /* synthetic */ u b(Throwable th, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            th = null;
        }
        if ((i5 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(v1 v1Var) {
        return v1Var.P() instanceof u;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final v1 e(r rVar, List<? extends r> list) {
        try {
            return rVar.b(list);
        } catch (Throwable th) {
            return a(th, rVar.a());
        }
    }
}
