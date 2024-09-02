package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.g;

public final class j<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i5, g gVar) {
        if ((i5 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e5) {
        if (obj == null) {
            return a(e5);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e5);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e5);
        return a(arrayList);
    }
}
