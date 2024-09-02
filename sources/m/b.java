package m;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f5819i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    private static final Object[] f5820j = new Object[0];

    /* renamed from: k  reason: collision with root package name */
    private static Object[] f5821k;

    /* renamed from: l  reason: collision with root package name */
    private static int f5822l;

    /* renamed from: m  reason: collision with root package name */
    private static Object[] f5823m;

    /* renamed from: n  reason: collision with root package name */
    private static int f5824n;

    /* renamed from: e  reason: collision with root package name */
    private int[] f5825e;

    /* renamed from: f  reason: collision with root package name */
    Object[] f5826f;

    /* renamed from: g  reason: collision with root package name */
    int f5827g;

    /* renamed from: h  reason: collision with root package name */
    private f<E, E> f5828h;

    class a extends f<E, E> {
        a() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            b.this.clear();
        }

        /* access modifiers changed from: protected */
        public Object b(int i5, int i6) {
            return b.this.f5826f[i5];
        }

        /* access modifiers changed from: protected */
        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        /* access modifiers changed from: protected */
        public int d() {
            return b.this.f5827g;
        }

        /* access modifiers changed from: protected */
        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        public void g(E e5, E e6) {
            b.this.add(e5);
        }

        /* access modifiers changed from: protected */
        public void h(int i5) {
            b.this.n(i5);
        }

        /* access modifiers changed from: protected */
        public E i(int i5, E e5) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i5) {
        if (i5 == 0) {
            this.f5825e = f5819i;
            this.f5826f = f5820j;
        } else {
            c(i5);
        }
        this.f5827g = 0;
    }

    private void c(int i5) {
        if (i5 == 8) {
            synchronized (b.class) {
                Object[] objArr = f5823m;
                if (objArr != null) {
                    this.f5826f = objArr;
                    f5823m = (Object[]) objArr[0];
                    this.f5825e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f5824n--;
                    return;
                }
            }
        } else if (i5 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f5821k;
                if (objArr2 != null) {
                    this.f5826f = objArr2;
                    f5821k = (Object[]) objArr2[0];
                    this.f5825e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f5822l--;
                    return;
                }
            }
        }
        this.f5825e = new int[i5];
        this.f5826f = new Object[i5];
    }

    private static void f(int[] iArr, Object[] objArr, int i5) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f5824n < 10) {
                    objArr[0] = f5823m;
                    objArr[1] = iArr;
                    for (int i6 = i5 - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f5823m = objArr;
                    f5824n++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f5822l < 10) {
                    objArr[0] = f5821k;
                    objArr[1] = iArr;
                    for (int i7 = i5 - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f5821k = objArr;
                    f5822l++;
                }
            }
        }
    }

    private f<E, E> i() {
        if (this.f5828h == null) {
            this.f5828h = new a();
        }
        return this.f5828h;
    }

    private int l(Object obj, int i5) {
        int i6 = this.f5827g;
        if (i6 == 0) {
            return -1;
        }
        int a5 = c.a(this.f5825e, i6, i5);
        if (a5 < 0 || obj.equals(this.f5826f[a5])) {
            return a5;
        }
        int i7 = a5 + 1;
        while (i7 < i6 && this.f5825e[i7] == i5) {
            if (obj.equals(this.f5826f[i7])) {
                return i7;
            }
            i7++;
        }
        int i8 = a5 - 1;
        while (i8 >= 0 && this.f5825e[i8] == i5) {
            if (obj.equals(this.f5826f[i8])) {
                return i8;
            }
            i8--;
        }
        return ~i7;
    }

    private int m() {
        int i5 = this.f5827g;
        if (i5 == 0) {
            return -1;
        }
        int a5 = c.a(this.f5825e, i5, 0);
        if (a5 < 0 || this.f5826f[a5] == null) {
            return a5;
        }
        int i6 = a5 + 1;
        while (i6 < i5 && this.f5825e[i6] == 0) {
            if (this.f5826f[i6] == null) {
                return i6;
            }
            i6++;
        }
        int i7 = a5 - 1;
        while (i7 >= 0 && this.f5825e[i7] == 0) {
            if (this.f5826f[i7] == null) {
                return i7;
            }
            i7--;
        }
        return ~i6;
    }

    public boolean add(E e5) {
        int i5;
        int i6;
        if (e5 == null) {
            i6 = m();
            i5 = 0;
        } else {
            int hashCode = e5.hashCode();
            i5 = hashCode;
            i6 = l(e5, hashCode);
        }
        if (i6 >= 0) {
            return false;
        }
        int i7 = ~i6;
        int i8 = this.f5827g;
        int[] iArr = this.f5825e;
        if (i8 >= iArr.length) {
            int i9 = 4;
            if (i8 >= 8) {
                i9 = (i8 >> 1) + i8;
            } else if (i8 >= 4) {
                i9 = 8;
            }
            Object[] objArr = this.f5826f;
            c(i9);
            int[] iArr2 = this.f5825e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f5826f, 0, objArr.length);
            }
            f(iArr, objArr, this.f5827g);
        }
        int i10 = this.f5827g;
        if (i7 < i10) {
            int[] iArr3 = this.f5825e;
            int i11 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i11, i10 - i7);
            Object[] objArr2 = this.f5826f;
            System.arraycopy(objArr2, i7, objArr2, i11, this.f5827g - i7);
        }
        this.f5825e[i7] = i5;
        this.f5826f[i7] = e5;
        this.f5827g++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        e(this.f5827g + collection.size());
        boolean z4 = false;
        for (Object add : collection) {
            z4 |= add(add);
        }
        return z4;
    }

    public void clear() {
        int i5 = this.f5827g;
        if (i5 != 0) {
            f(this.f5825e, this.f5826f, i5);
            this.f5825e = f5819i;
            this.f5826f = f5820j;
            this.f5827g = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public void e(int i5) {
        int[] iArr = this.f5825e;
        if (iArr.length < i5) {
            Object[] objArr = this.f5826f;
            c(i5);
            int i6 = this.f5827g;
            if (i6 > 0) {
                System.arraycopy(iArr, 0, this.f5825e, 0, i6);
                System.arraycopy(objArr, 0, this.f5826f, 0, this.f5827g);
            }
            f(iArr, objArr, this.f5827g);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i5 = 0;
            while (i5 < this.f5827g) {
                try {
                    if (!set.contains(o(i5))) {
                        return false;
                    }
                    i5++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f5825e;
        int i5 = this.f5827g;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += iArr[i7];
        }
        return i6;
    }

    public int indexOf(Object obj) {
        return obj == null ? m() : l(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f5827g <= 0;
    }

    public Iterator<E> iterator() {
        return i().m().iterator();
    }

    public E n(int i5) {
        E[] eArr = this.f5826f;
        E e5 = eArr[i5];
        int i6 = this.f5827g;
        if (i6 <= 1) {
            f(this.f5825e, eArr, i6);
            this.f5825e = f5819i;
            this.f5826f = f5820j;
            this.f5827g = 0;
        } else {
            int[] iArr = this.f5825e;
            int i7 = 8;
            if (iArr.length <= 8 || i6 >= iArr.length / 3) {
                int i8 = i6 - 1;
                this.f5827g = i8;
                if (i5 < i8) {
                    int i9 = i5 + 1;
                    System.arraycopy(iArr, i9, iArr, i5, i8 - i5);
                    Object[] objArr = this.f5826f;
                    System.arraycopy(objArr, i9, objArr, i5, this.f5827g - i5);
                }
                this.f5826f[this.f5827g] = null;
            } else {
                if (i6 > 8) {
                    i7 = i6 + (i6 >> 1);
                }
                c(i7);
                this.f5827g--;
                if (i5 > 0) {
                    System.arraycopy(iArr, 0, this.f5825e, 0, i5);
                    System.arraycopy(eArr, 0, this.f5826f, 0, i5);
                }
                int i10 = this.f5827g;
                if (i5 < i10) {
                    int i11 = i5 + 1;
                    System.arraycopy(iArr, i11, this.f5825e, i5, i10 - i5);
                    System.arraycopy(eArr, i11, this.f5826f, i5, this.f5827g - i5);
                }
            }
        }
        return e5;
    }

    public E o(int i5) {
        return this.f5826f[i5];
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        n(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z4 = false;
        for (Object remove : collection) {
            z4 |= remove(remove);
        }
        return z4;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z4 = false;
        for (int i5 = this.f5827g - 1; i5 >= 0; i5--) {
            if (!collection.contains(this.f5826f[i5])) {
                n(i5);
                z4 = true;
            }
        }
        return z4;
    }

    public int size() {
        return this.f5827g;
    }

    public Object[] toArray() {
        int i5 = this.f5827g;
        Object[] objArr = new Object[i5];
        System.arraycopy(this.f5826f, 0, objArr, 0, i5);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f5827g) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f5827g);
        }
        System.arraycopy(this.f5826f, 0, tArr, 0, this.f5827g);
        int length = tArr.length;
        int i5 = this.f5827g;
        if (length > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5827g * 14);
        sb.append('{');
        for (int i5 = 0; i5 < this.f5827g; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object o5 = o(i5);
            if (o5 != this) {
                sb.append(o5);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
