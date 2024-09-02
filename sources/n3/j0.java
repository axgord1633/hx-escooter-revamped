package n3;

import java.util.Set;
import kotlin.jvm.internal.k;

class j0 extends i0 {
    public static <T> Set<T> b() {
        return z.f6081e;
    }

    public static final <T> Set<T> c(Set<? extends T> set) {
        k.e(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : i0.a(set.iterator().next()) : b();
    }
}
