package c4;

import kotlinx.coroutines.internal.f;
import o3.d;

public final class n {
    public static final <T> l<T> a(d<? super T> dVar) {
        if (!(dVar instanceof f)) {
            return new l<>(dVar, 1);
        }
        l<T> l5 = ((f) dVar).l();
        if (l5 != null) {
            if (!l5.G()) {
                l5 = null;
            }
            if (l5 != null) {
                return l5;
            }
        }
        return new l<>(dVar, 2);
    }
}
