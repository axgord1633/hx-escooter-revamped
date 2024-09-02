package n3;

import java.util.Collection;
import kotlin.jvm.internal.k;

class s extends r {
    public static <T> boolean j(Collection<? super T> collection, Iterable<? extends T> iterable) {
        k.e(collection, "<this>");
        k.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z4 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z4 = true;
            }
        }
        return z4;
    }
}
