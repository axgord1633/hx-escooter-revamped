package n3;

import java.util.Collections;
import java.util.Map;
import kotlin.jvm.internal.k;
import m3.j;

class d0 extends c0 {
    public static int a(int i5) {
        if (i5 < 0) {
            return i5;
        }
        if (i5 < 3) {
            return i5 + 1;
        }
        if (i5 < 1073741824) {
            return (int) ((((float) i5) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> b(j<? extends K, ? extends V> jVar) {
        k.e(jVar, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(jVar.e(), jVar.f());
        k.d(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        k.e(map, "<this>");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        k.d(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
