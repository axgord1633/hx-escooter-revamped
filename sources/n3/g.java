package n3;

import java.lang.reflect.Array;
import kotlin.jvm.internal.k;

class g {
    public static final <T> T[] a(T[] tArr, int i5) {
        k.e(tArr, "reference");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i5);
        k.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) newInstance;
    }
}
