package n3;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import m3.j;

class e0 extends d0 {
    public static <K, V> Map<K, V> d() {
        y yVar = y.f6080e;
        k.c(yVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return yVar;
    }

    public static <K, V> Map<K, V> e(j<? extends K, ? extends V>... jVarArr) {
        k.e(jVarArr, "pairs");
        return jVarArr.length > 0 ? l(jVarArr, new LinkedHashMap(d0.a(jVarArr.length))) : d();
    }

    public static final <K, V> Map<K, V> f(Map<K, ? extends V> map) {
        k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : d0.c(map) : d();
    }

    public static final <K, V> void g(Map<? super K, ? super V> map, Iterable<? extends j<? extends K, ? extends V>> iterable) {
        k.e(map, "<this>");
        k.e(iterable, "pairs");
        for (j jVar : iterable) {
            map.put(jVar.a(), jVar.b());
        }
    }

    public static final <K, V> void h(Map<? super K, ? super V> map, j<? extends K, ? extends V>[] jVarArr) {
        k.e(map, "<this>");
        k.e(jVarArr, "pairs");
        for (j<? extends K, ? extends V> jVar : jVarArr) {
            map.put(jVar.a(), jVar.b());
        }
    }

    public static <K, V> Map<K, V> i(Iterable<? extends j<? extends K, ? extends V>> iterable) {
        k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return f(j(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return j(iterable, new LinkedHashMap(d0.a(collection.size())));
        }
        return d0.b((j) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M j(Iterable<? extends j<? extends K, ? extends V>> iterable, M m5) {
        k.e(iterable, "<this>");
        k.e(m5, "destination");
        g(m5, iterable);
        return m5;
    }

    public static <K, V> Map<K, V> k(Map<? extends K, ? extends V> map) {
        k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? m(map) : d0.c(map) : d();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M l(j<? extends K, ? extends V>[] jVarArr, M m5) {
        k.e(jVarArr, "<this>");
        k.e(m5, "destination");
        h(m5, jVarArr);
        return m5;
    }

    public static final <K, V> Map<K, V> m(Map<? extends K, ? extends V> map) {
        k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
