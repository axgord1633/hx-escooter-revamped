package m;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: l  reason: collision with root package name */
    f<K, V> f5817l;

    /* renamed from: m.a$a  reason: collision with other inner class name */
    class C0088a extends f<K, V> {
        C0088a() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            a.this.clear();
        }

        /* access modifiers changed from: protected */
        public Object b(int i5, int i6) {
            return a.this.f5866f[(i5 << 1) + i6];
        }

        /* access modifiers changed from: protected */
        public Map<K, V> c() {
            return a.this;
        }

        /* access modifiers changed from: protected */
        public int d() {
            return a.this.f5867g;
        }

        /* access modifiers changed from: protected */
        public int e(Object obj) {
            return a.this.f(obj);
        }

        /* access modifiers changed from: protected */
        public int f(Object obj) {
            return a.this.h(obj);
        }

        /* access modifiers changed from: protected */
        public void g(K k5, V v5) {
            a.this.put(k5, v5);
        }

        /* access modifiers changed from: protected */
        public void h(int i5) {
            a.this.k(i5);
        }

        /* access modifiers changed from: protected */
        public V i(int i5, V v5) {
            return a.this.l(i5, v5);
        }
    }

    public a() {
    }

    public a(int i5) {
        super(i5);
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> n() {
        if (this.f5817l == null) {
            this.f5817l = new C0088a();
        }
        return this.f5817l;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f5867g + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Collection<V> values() {
        return n().n();
    }
}
