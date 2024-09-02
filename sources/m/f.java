package m;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class f<K, V> {

    /* renamed from: a  reason: collision with root package name */
    f<K, V>.b f5846a;

    /* renamed from: b  reason: collision with root package name */
    f<K, V>.c f5847b;

    /* renamed from: c  reason: collision with root package name */
    f<K, V>.e f5848c;

    final class a<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        final int f5849e;

        /* renamed from: f  reason: collision with root package name */
        int f5850f;

        /* renamed from: g  reason: collision with root package name */
        int f5851g;

        /* renamed from: h  reason: collision with root package name */
        boolean f5852h = false;

        a(int i5) {
            this.f5849e = i5;
            this.f5850f = f.this.d();
        }

        public boolean hasNext() {
            return this.f5851g < this.f5850f;
        }

        public T next() {
            if (hasNext()) {
                T b5 = f.this.b(this.f5851g, this.f5849e);
                this.f5851g++;
                this.f5852h = true;
                return b5;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f5852h) {
                int i5 = this.f5851g - 1;
                this.f5851g = i5;
                this.f5850f--;
                this.f5852h = false;
                f.this.h(i5);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d5 = f.this.d();
            for (Map.Entry entry : collection) {
                f.this.g(entry.getKey(), entry.getValue());
            }
            return d5 != f.this.d();
        }

        /* renamed from: c */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e5 = f.this.e(entry.getKey());
            if (e5 < 0) {
                return false;
            }
            return c.c(f.this.b(e5, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        public int hashCode() {
            int i5 = 0;
            for (int d5 = f.this.d() - 1; d5 >= 0; d5--) {
                Object b5 = f.this.b(d5, 0);
                Object b6 = f.this.b(d5, 1);
                i5 += (b5 == null ? 0 : b5.hashCode()) ^ (b6 == null ? 0 : b6.hashCode());
            }
            return i5;
        }

        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return f.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public boolean add(K k5) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.a();
        }

        public boolean contains(Object obj) {
            return f.this.e(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return f.j(f.this.c(), collection);
        }

        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        public int hashCode() {
            int i5 = 0;
            for (int d5 = f.this.d() - 1; d5 >= 0; d5--) {
                Object b5 = f.this.b(d5, 0);
                i5 += b5 == null ? 0 : b5.hashCode();
            }
            return i5;
        }

        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int e5 = f.this.e(obj);
            if (e5 < 0) {
                return false;
            }
            f.this.h(e5);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return f.o(f.this.c(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return f.p(f.this.c(), collection);
        }

        public int size() {
            return f.this.d();
        }

        public Object[] toArray() {
            return f.this.q(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return f.this.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        int f5856e;

        /* renamed from: f  reason: collision with root package name */
        int f5857f;

        /* renamed from: g  reason: collision with root package name */
        boolean f5858g = false;

        d() {
            this.f5856e = f.this.d() - 1;
            this.f5857f = -1;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f5857f++;
                this.f5858g = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f5858g) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return c.c(entry.getKey(), f.this.b(this.f5857f, 0)) && c.c(entry.getValue(), f.this.b(this.f5857f, 1));
            }
        }

        public K getKey() {
            if (this.f5858g) {
                return f.this.b(this.f5857f, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f5858g) {
                return f.this.b(this.f5857f, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f5857f < this.f5856e;
        }

        public int hashCode() {
            if (this.f5858g) {
                int i5 = 0;
                Object b5 = f.this.b(this.f5857f, 0);
                Object b6 = f.this.b(this.f5857f, 1);
                int hashCode = b5 == null ? 0 : b5.hashCode();
                if (b6 != null) {
                    i5 = b6.hashCode();
                }
                return hashCode ^ i5;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f5858g) {
                f.this.h(this.f5857f);
                this.f5857f--;
                this.f5856e--;
                this.f5858g = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v5) {
            if (this.f5858g) {
                return f.this.i(this.f5857f, v5);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public boolean add(V v5) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.a();
        }

        public boolean contains(Object obj) {
            return f.this.f(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int f5 = f.this.f(obj);
            if (f5 < 0) {
                return false;
            }
            f.this.h(f5);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int d5 = f.this.d();
            int i5 = 0;
            boolean z4 = false;
            while (i5 < d5) {
                if (collection.contains(f.this.b(i5, 1))) {
                    f.this.h(i5);
                    i5--;
                    d5--;
                    z4 = true;
                }
                i5++;
            }
            return z4;
        }

        public boolean retainAll(Collection<?> collection) {
            int d5 = f.this.d();
            int i5 = 0;
            boolean z4 = false;
            while (i5 < d5) {
                if (!collection.contains(f.this.b(i5, 1))) {
                    f.this.h(i5);
                    i5--;
                    d5--;
                    z4 = true;
                }
                i5++;
            }
            return z4;
        }

        public int size() {
            return f.this.d();
        }

        public Object[] toArray() {
            return f.this.q(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return f.this.r(tArr, 1);
        }
    }

    f() {
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract Object b(int i5, int i6);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> c();

    /* access modifiers changed from: protected */
    public abstract int d();

    /* access modifiers changed from: protected */
    public abstract int e(Object obj);

    /* access modifiers changed from: protected */
    public abstract int f(Object obj);

    /* access modifiers changed from: protected */
    public abstract void g(K k5, V v5);

    /* access modifiers changed from: protected */
    public abstract void h(int i5);

    /* access modifiers changed from: protected */
    public abstract V i(int i5, V v5);

    public Set<Map.Entry<K, V>> l() {
        if (this.f5846a == null) {
            this.f5846a = new b();
        }
        return this.f5846a;
    }

    public Set<K> m() {
        if (this.f5847b == null) {
            this.f5847b = new c();
        }
        return this.f5847b;
    }

    public Collection<V> n() {
        if (this.f5848c == null) {
            this.f5848c = new e();
        }
        return this.f5848c;
    }

    public Object[] q(int i5) {
        int d5 = d();
        Object[] objArr = new Object[d5];
        for (int i6 = 0; i6 < d5; i6++) {
            objArr[i6] = b(i6, i5);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i5) {
        int d5 = d();
        if (tArr.length < d5) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), d5);
        }
        for (int i6 = 0; i6 < d5; i6++) {
            tArr[i6] = b(i6, i5);
        }
        if (tArr.length > d5) {
            tArr[d5] = null;
        }
        return tArr;
    }
}
