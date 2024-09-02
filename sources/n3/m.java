package n3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.k;

class m {
    public static final <T> Object[] a(T[] tArr, boolean z4) {
        Class<Object[]> cls = Object[].class;
        k.e(tArr, "<this>");
        if (z4 && k.a(tArr.getClass(), cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        k.d(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t5) {
        List<T> singletonList = Collections.singletonList(t5);
        k.d(singletonList, "singletonList(element)");
        return singletonList;
    }
}
