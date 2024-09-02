package n3;

import java.util.Collection;
import kotlin.jvm.internal.k;

class o extends n {
    public static <T> int i(Iterable<? extends T> iterable, int i5) {
        k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i5;
    }
}
