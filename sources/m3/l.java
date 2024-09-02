package m3;

import kotlin.jvm.internal.k;
import m3.k;

public final class l {
    public static final Object a(Throwable th) {
        k.e(th, "exception");
        return new k.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof k.b) {
            throw ((k.b) obj).f5899e;
        }
    }
}
