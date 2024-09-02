package k;

import java.util.HashMap;
import java.util.Map;
import k.b;

public class a<K, V> extends b<K, V> {

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<K, b.c<K, V>> f5496i = new HashMap<>();

    public boolean contains(K k5) {
        return this.f5496i.containsKey(k5);
    }

    /* access modifiers changed from: protected */
    public b.c<K, V> e(K k5) {
        return this.f5496i.get(k5);
    }

    public V m(K k5, V v5) {
        b.c e5 = e(k5);
        if (e5 != null) {
            return e5.f5502f;
        }
        this.f5496i.put(k5, l(k5, v5));
        return null;
    }

    public V n(K k5) {
        V n5 = super.n(k5);
        this.f5496i.remove(k5);
        return n5;
    }

    public Map.Entry<K, V> o(K k5) {
        if (contains(k5)) {
            return this.f5496i.get(k5).f5504h;
        }
        return null;
    }
}
