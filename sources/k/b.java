package k;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: e  reason: collision with root package name */
    c<K, V> f5497e;

    /* renamed from: f  reason: collision with root package name */
    private c<K, V> f5498f;

    /* renamed from: g  reason: collision with root package name */
    private final WeakHashMap<f<K, V>, Boolean> f5499g = new WeakHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private int f5500h = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f5504h;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f5503g;
        }
    }

    /* renamed from: k.b$b  reason: collision with other inner class name */
    private static class C0083b<K, V> extends e<K, V> {
        C0083b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f5503g;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f5504h;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        final K f5501e;

        /* renamed from: f  reason: collision with root package name */
        final V f5502f;

        /* renamed from: g  reason: collision with root package name */
        c<K, V> f5503g;

        /* renamed from: h  reason: collision with root package name */
        c<K, V> f5504h;

        c(K k5, V v5) {
            this.f5501e = k5;
            this.f5502f = v5;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f5501e.equals(cVar.f5501e) && this.f5502f.equals(cVar.f5502f);
        }

        public K getKey() {
            return this.f5501e;
        }

        public V getValue() {
            return this.f5502f;
        }

        public int hashCode() {
            return this.f5501e.hashCode() ^ this.f5502f.hashCode();
        }

        public V setValue(V v5) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f5501e + "=" + this.f5502f;
        }
    }

    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        private c<K, V> f5505e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5506f = true;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.f5505e;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f5504h;
                this.f5505e = cVar3;
                this.f5506f = cVar3 == null;
            }
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f5506f) {
                this.f5506f = false;
                cVar = b.this.f5497e;
            } else {
                c<K, V> cVar2 = this.f5505e;
                cVar = cVar2 != null ? cVar2.f5503g : null;
            }
            this.f5505e = cVar;
            return this.f5505e;
        }

        public boolean hasNext() {
            if (this.f5506f) {
                return b.this.f5497e != null;
            }
            c<K, V> cVar = this.f5505e;
            return (cVar == null || cVar.f5503g == null) ? false : true;
        }
    }

    private static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        c<K, V> f5508e;

        /* renamed from: f  reason: collision with root package name */
        c<K, V> f5509f;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f5508e = cVar2;
            this.f5509f = cVar;
        }

        private c<K, V> f() {
            c<K, V> cVar = this.f5509f;
            c<K, V> cVar2 = this.f5508e;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        public void b(c<K, V> cVar) {
            if (this.f5508e == cVar && cVar == this.f5509f) {
                this.f5509f = null;
                this.f5508e = null;
            }
            c<K, V> cVar2 = this.f5508e;
            if (cVar2 == cVar) {
                this.f5508e = c(cVar2);
            }
            if (this.f5509f == cVar) {
                this.f5509f = f();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> c(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> d(c<K, V> cVar);

        /* renamed from: e */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f5509f;
            this.f5509f = f();
            return cVar;
        }

        public boolean hasNext() {
            return this.f5509f != null;
        }
    }

    public static abstract class f<K, V> {
        /* access modifiers changed from: package-private */
        public abstract void b(c<K, V> cVar);
    }

    public Map.Entry<K, V> c() {
        return this.f5497e;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0083b bVar = new C0083b(this.f5498f, this.f5497e);
        this.f5499g.put(bVar, Boolean.FALSE);
        return bVar;
    }

    /* access modifiers changed from: protected */
    public c<K, V> e(K k5) {
        c<K, V> cVar = this.f5497e;
        while (cVar != null && !cVar.f5501e.equals(k5)) {
            cVar = cVar.f5503g;
        }
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public b<K, V>.d f() {
        b<K, V>.d dVar = new d();
        this.f5499g.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += ((Map.Entry) it.next()).hashCode();
        }
        return i5;
    }

    public Map.Entry<K, V> i() {
        return this.f5498f;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f5497e, this.f5498f);
        this.f5499g.put(aVar, Boolean.FALSE);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public c<K, V> l(K k5, V v5) {
        c<K, V> cVar = new c<>(k5, v5);
        this.f5500h++;
        c<K, V> cVar2 = this.f5498f;
        if (cVar2 == null) {
            this.f5497e = cVar;
        } else {
            cVar2.f5503g = cVar;
            cVar.f5504h = cVar2;
        }
        this.f5498f = cVar;
        return cVar;
    }

    public V m(K k5, V v5) {
        c e5 = e(k5);
        if (e5 != null) {
            return e5.f5502f;
        }
        l(k5, v5);
        return null;
    }

    public V n(K k5) {
        c e5 = e(k5);
        if (e5 == null) {
            return null;
        }
        this.f5500h--;
        if (!this.f5499g.isEmpty()) {
            for (f<K, V> b5 : this.f5499g.keySet()) {
                b5.b(e5);
            }
        }
        c<K, V> cVar = e5.f5504h;
        c<K, V> cVar2 = e5.f5503g;
        if (cVar != null) {
            cVar.f5503g = cVar2;
        } else {
            this.f5497e = cVar2;
        }
        c<K, V> cVar3 = e5.f5503g;
        if (cVar3 != null) {
            cVar3.f5504h = cVar;
        } else {
            this.f5498f = cVar;
        }
        e5.f5503g = null;
        e5.f5504h = null;
        return e5.f5502f;
    }

    public int size() {
        return this.f5500h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
