package a4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.k;
import v3.l;

class h extends g {
    public static <T, R> b<R> c(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        k.e(bVar, "<this>");
        k.e(lVar, "transform");
        return new i(bVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C d(b<? extends T> bVar, C c5) {
        k.e(bVar, "<this>");
        k.e(c5, "destination");
        for (Object add : bVar) {
            c5.add(add);
        }
        return c5;
    }

    public static <T> List<T> e(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return n.g(f(bVar));
    }

    public static final <T> List<T> f(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return (List) d(bVar, new ArrayList());
    }
}
