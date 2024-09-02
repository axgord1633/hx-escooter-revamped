package n3;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.k;

class i0 {
    public static final <T> Set<T> a(T t5) {
        Set<T> singleton = Collections.singleton(t5);
        k.d(singleton, "singleton(element)");
        return singleton;
    }
}
