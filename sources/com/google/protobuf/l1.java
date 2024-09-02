package com.google.protobuf;

import com.google.protobuf.v;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class l1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private final int f3609e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<l1<K, V>.e> f3610f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Map<K, V> f3611g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3612h;

    /* renamed from: i  reason: collision with root package name */
    private volatile l1<K, V>.g f3613i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Map<K, V> f3614j;

    /* renamed from: k  reason: collision with root package name */
    private volatile l1<K, V>.c f3615k;

    static class a extends l1<FieldDescriptorType, Object> {
        a(int i5) {
            super(i5, (a) null);
        }

        public void p() {
            if (!o()) {
                for (int i5 = 0; i5 < k(); i5++) {
                    Map.Entry j5 = j(i5);
                    if (((v.b) j5.getKey()).b()) {
                        j5.setValue(Collections.unmodifiableList((List) j5.getValue()));
                    }
                }
                for (Map.Entry entry : m()) {
                    if (((v.b) entry.getKey()).b()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            l1.super.p();
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return l1.super.put((v.b) obj, obj2);
        }
    }

    private class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        private int f3616e;

        /* renamed from: f  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f3617f;

        private b() {
            this.f3616e = l1.this.f3610f.size();
        }

        /* synthetic */ b(l1 l1Var, a aVar) {
            this();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f3617f == null) {
                this.f3617f = l1.this.f3614j.entrySet().iterator();
            }
            return this.f3617f;
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            Object obj;
            if (b().hasNext()) {
                obj = b().next();
            } else {
                List b5 = l1.this.f3610f;
                int i5 = this.f3616e - 1;
                this.f3616e = i5;
                obj = b5.get(i5);
            }
            return (Map.Entry) obj;
        }

        public boolean hasNext() {
            int i5 = this.f3616e;
            return (i5 > 0 && i5 <= l1.this.f3610f.size()) || b().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class c extends l1<K, V>.g {
        private c() {
            super(l1.this, (a) null);
        }

        /* synthetic */ c(l1 l1Var, a aVar) {
            this();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(l1.this, (a) null);
        }
    }

    private static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f3620a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f3621b = new b();

        static class a implements Iterator<Object> {
            a() {
            }

            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        static class b implements Iterable<Object> {
            b() {
            }

            public Iterator<Object> iterator() {
                return d.f3620a;
            }
        }

        static <T> Iterable<T> b() {
            return f3621b;
        }
    }

    private class e implements Map.Entry<K, V>, Comparable<l1<K, V>.e> {

        /* renamed from: e  reason: collision with root package name */
        private final K f3622e;

        /* renamed from: f  reason: collision with root package name */
        private V f3623f;

        e(K k5, V v5) {
            this.f3622e = k5;
            this.f3623f = v5;
        }

        e(l1 l1Var, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean f(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        /* renamed from: c */
        public int compareTo(l1<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return f(this.f3622e, entry.getKey()) && f(this.f3623f, entry.getValue());
        }

        public V getValue() {
            return this.f3623f;
        }

        public int hashCode() {
            K k5 = this.f3622e;
            int i5 = 0;
            int hashCode = k5 == null ? 0 : k5.hashCode();
            V v5 = this.f3623f;
            if (v5 != null) {
                i5 = v5.hashCode();
            }
            return hashCode ^ i5;
        }

        /* renamed from: i */
        public K getKey() {
            return this.f3622e;
        }

        public V setValue(V v5) {
            l1.this.g();
            V v6 = this.f3623f;
            this.f3623f = v5;
            return v6;
        }

        public String toString() {
            return this.f3622e + "=" + this.f3623f;
        }
    }

    private class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        private int f3625e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3626f;

        /* renamed from: g  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f3627g;

        private f() {
            this.f3625e = -1;
        }

        /* synthetic */ f(l1 l1Var, a aVar) {
            this();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f3627g == null) {
                this.f3627g = l1.this.f3611g.entrySet().iterator();
            }
            return this.f3627g;
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            this.f3626f = true;
            int i5 = this.f3625e + 1;
            this.f3625e = i5;
            return (Map.Entry) (i5 < l1.this.f3610f.size() ? l1.this.f3610f.get(this.f3625e) : b().next());
        }

        public boolean hasNext() {
            if (this.f3625e + 1 >= l1.this.f3610f.size()) {
                return !l1.this.f3611g.isEmpty() && b().hasNext();
            }
            return true;
        }

        public void remove() {
            if (this.f3626f) {
                this.f3626f = false;
                l1.this.g();
                if (this.f3625e < l1.this.f3610f.size()) {
                    l1 l1Var = l1.this;
                    int i5 = this.f3625e;
                    this.f3625e = i5 - 1;
                    Object unused = l1Var.s(i5);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    private class g extends AbstractSet<Map.Entry<K, V>> {
        private g() {
        }

        /* synthetic */ g(l1 l1Var, a aVar) {
            this();
        }

        /* renamed from: c */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            l1.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            l1.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = l1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(l1.this, (a) null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            l1.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return l1.this.size();
        }
    }

    private l1(int i5) {
        this.f3609e = i5;
        this.f3610f = Collections.emptyList();
        this.f3611g = Collections.emptyMap();
        this.f3614j = Collections.emptyMap();
    }

    /* synthetic */ l1(int i5, a aVar) {
        this(i5);
    }

    private int f(K k5) {
        int size = this.f3610f.size() - 1;
        if (size >= 0) {
            int compareTo = k5.compareTo(this.f3610f.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i5 = 0;
        while (i5 <= size) {
            int i6 = (i5 + size) / 2;
            int compareTo2 = k5.compareTo(this.f3610f.get(i6).getKey());
            if (compareTo2 < 0) {
                size = i6 - 1;
            } else if (compareTo2 <= 0) {
                return i6;
            } else {
                i5 = i6 + 1;
            }
        }
        return -(i5 + 1);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f3612h) {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        g();
        if (this.f3610f.isEmpty() && !(this.f3610f instanceof ArrayList)) {
            this.f3610f = new ArrayList(this.f3609e);
        }
    }

    private SortedMap<K, V> n() {
        g();
        if (this.f3611g.isEmpty() && !(this.f3611g instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f3611g = treeMap;
            TreeMap treeMap2 = treeMap;
            this.f3614j = treeMap.descendingMap();
        }
        return (SortedMap) this.f3611g;
    }

    static <FieldDescriptorType extends v.b<FieldDescriptorType>> l1<FieldDescriptorType, Object> q(int i5) {
        return new a(i5);
    }

    /* access modifiers changed from: private */
    public V s(int i5) {
        g();
        V value = this.f3610f.remove(i5).getValue();
        if (!this.f3611g.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            this.f3610f.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        g();
        if (!this.f3610f.isEmpty()) {
            this.f3610f.clear();
        }
        if (!this.f3611g.isEmpty()) {
            this.f3611g.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f3611g.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f3613i == null) {
            this.f3613i = new g(this, (a) null);
        }
        return this.f3613i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return super.equals(obj);
        }
        l1 l1Var = (l1) obj;
        int size = size();
        if (size != l1Var.size()) {
            return false;
        }
        int k5 = k();
        if (k5 != l1Var.k()) {
            return entrySet().equals(l1Var.entrySet());
        }
        for (int i5 = 0; i5 < k5; i5++) {
            if (!j(i5).equals(l1Var.j(i5))) {
                return false;
            }
        }
        if (k5 != size) {
            return this.f3611g.equals(l1Var.f3611g);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f5 = f(comparable);
        return f5 >= 0 ? this.f3610f.get(f5).getValue() : this.f3611g.get(comparable);
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> h() {
        if (this.f3615k == null) {
            this.f3615k = new c(this, (a) null);
        }
        return this.f3615k;
    }

    public int hashCode() {
        int k5 = k();
        int i5 = 0;
        for (int i6 = 0; i6 < k5; i6++) {
            i5 += this.f3610f.get(i6).hashCode();
        }
        return l() > 0 ? i5 + this.f3611g.hashCode() : i5;
    }

    public Map.Entry<K, V> j(int i5) {
        return this.f3610f.get(i5);
    }

    public int k() {
        return this.f3610f.size();
    }

    public int l() {
        return this.f3611g.size();
    }

    public Iterable<Map.Entry<K, V>> m() {
        return this.f3611g.isEmpty() ? d.b() : this.f3611g.entrySet();
    }

    public boolean o() {
        return this.f3612h;
    }

    public void p() {
        if (!this.f3612h) {
            this.f3611g = this.f3611g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3611g);
            this.f3614j = this.f3614j.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3614j);
            this.f3612h = true;
        }
    }

    /* renamed from: r */
    public V put(K k5, V v5) {
        g();
        int f5 = f(k5);
        if (f5 >= 0) {
            return this.f3610f.get(f5).setValue(v5);
        }
        i();
        int i5 = -(f5 + 1);
        if (i5 >= this.f3609e) {
            return n().put(k5, v5);
        }
        int size = this.f3610f.size();
        int i6 = this.f3609e;
        if (size == i6) {
            e remove = this.f3610f.remove(i6 - 1);
            n().put(remove.getKey(), remove.getValue());
        }
        this.f3610f.add(i5, new e(k5, v5));
        return null;
    }

    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f5 = f(comparable);
        if (f5 >= 0) {
            return s(f5);
        }
        if (this.f3611g.isEmpty()) {
            return null;
        }
        return this.f3611g.remove(comparable);
    }

    public int size() {
        return this.f3610f.size() + this.f3611g.size();
    }
}
