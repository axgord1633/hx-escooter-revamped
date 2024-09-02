package m;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V> {

    /* renamed from: h  reason: collision with root package name */
    static Object[] f5861h;

    /* renamed from: i  reason: collision with root package name */
    static int f5862i;

    /* renamed from: j  reason: collision with root package name */
    static Object[] f5863j;

    /* renamed from: k  reason: collision with root package name */
    static int f5864k;

    /* renamed from: e  reason: collision with root package name */
    int[] f5865e;

    /* renamed from: f  reason: collision with root package name */
    Object[] f5866f;

    /* renamed from: g  reason: collision with root package name */
    int f5867g;

    public g() {
        this.f5865e = c.f5830a;
        this.f5866f = c.f5832c;
        this.f5867g = 0;
    }

    public g(int i5) {
        if (i5 == 0) {
            this.f5865e = c.f5830a;
            this.f5866f = c.f5832c;
        } else {
            a(i5);
        }
        this.f5867g = 0;
    }

    public g(g<K, V> gVar) {
        this();
        if (gVar != null) {
            j(gVar);
        }
    }

    private void a(int i5) {
        Class<g> cls = g.class;
        if (i5 == 8) {
            synchronized (cls) {
                Object[] objArr = f5863j;
                if (objArr != null) {
                    this.f5866f = objArr;
                    f5863j = (Object[]) objArr[0];
                    this.f5865e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f5864k--;
                    return;
                }
            }
        } else if (i5 == 4) {
            synchronized (cls) {
                Object[] objArr2 = f5861h;
                if (objArr2 != null) {
                    this.f5866f = objArr2;
                    f5861h = (Object[]) objArr2[0];
                    this.f5865e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f5862i--;
                    return;
                }
            }
        }
        this.f5865e = new int[i5];
        this.f5866f = new Object[(i5 << 1)];
    }

    private static int b(int[] iArr, int i5, int i6) {
        try {
            return c.a(iArr, i5, i6);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i5) {
        Class<g> cls = g.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f5864k < 10) {
                    objArr[0] = f5863j;
                    objArr[1] = iArr;
                    for (int i6 = (i5 << 1) - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f5863j = objArr;
                    f5864k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f5862i < 10) {
                    objArr[0] = f5861h;
                    objArr[1] = iArr;
                    for (int i7 = (i5 << 1) - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f5861h = objArr;
                    f5862i++;
                }
            }
        }
    }

    public void c(int i5) {
        int i6 = this.f5867g;
        int[] iArr = this.f5865e;
        if (iArr.length < i5) {
            Object[] objArr = this.f5866f;
            a(i5);
            if (this.f5867g > 0) {
                System.arraycopy(iArr, 0, this.f5865e, 0, i6);
                System.arraycopy(objArr, 0, this.f5866f, 0, i6 << 1);
            }
            d(iArr, objArr, i6);
        }
        if (this.f5867g != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i5 = this.f5867g;
        if (i5 > 0) {
            int[] iArr = this.f5865e;
            Object[] objArr = this.f5866f;
            this.f5865e = c.f5830a;
            this.f5866f = c.f5832c;
            this.f5867g = 0;
            d(iArr, objArr, i5);
        }
        if (this.f5867g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    public int e(Object obj, int i5) {
        int i6 = this.f5867g;
        if (i6 == 0) {
            return -1;
        }
        int b5 = b(this.f5865e, i6, i5);
        if (b5 < 0 || obj.equals(this.f5866f[b5 << 1])) {
            return b5;
        }
        int i7 = b5 + 1;
        while (i7 < i6 && this.f5865e[i7] == i5) {
            if (obj.equals(this.f5866f[i7 << 1])) {
                return i7;
            }
            i7++;
        }
        int i8 = b5 - 1;
        while (i8 >= 0 && this.f5865e[i8] == i5) {
            if (obj.equals(this.f5866f[i8 << 1])) {
                return i8;
            }
            i8--;
        }
        return ~i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i5 = 0;
            while (i5 < this.f5867g) {
                try {
                    Object i6 = i(i5);
                    Object m5 = m(i5);
                    Object obj2 = gVar.get(i6);
                    if (m5 == null) {
                        if (obj2 != null || !gVar.containsKey(i6)) {
                            return false;
                        }
                    } else if (!m5.equals(obj2)) {
                        return false;
                    }
                    i5++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i7 = 0;
            while (i7 < this.f5867g) {
                try {
                    Object i8 = i(i7);
                    Object m6 = m(i7);
                    Object obj3 = map.get(i8);
                    if (m6 == null) {
                        if (obj3 != null || !map.containsKey(i8)) {
                            return false;
                        }
                    } else if (!m6.equals(obj3)) {
                        return false;
                    }
                    i7++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int g() {
        int i5 = this.f5867g;
        if (i5 == 0) {
            return -1;
        }
        int b5 = b(this.f5865e, i5, 0);
        if (b5 < 0 || this.f5866f[b5 << 1] == null) {
            return b5;
        }
        int i6 = b5 + 1;
        while (i6 < i5 && this.f5865e[i6] == 0) {
            if (this.f5866f[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        int i7 = b5 - 1;
        while (i7 >= 0 && this.f5865e[i7] == 0) {
            if (this.f5866f[i7 << 1] == null) {
                return i7;
            }
            i7--;
        }
        return ~i6;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v5) {
        int f5 = f(obj);
        return f5 >= 0 ? this.f5866f[(f5 << 1) + 1] : v5;
    }

    /* access modifiers changed from: package-private */
    public int h(Object obj) {
        int i5 = this.f5867g * 2;
        Object[] objArr = this.f5866f;
        if (obj == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (obj.equals(objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f5865e;
        Object[] objArr = this.f5866f;
        int i5 = this.f5867g;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            i8 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return i8;
    }

    public K i(int i5) {
        return this.f5866f[i5 << 1];
    }

    public boolean isEmpty() {
        return this.f5867g <= 0;
    }

    public void j(g<? extends K, ? extends V> gVar) {
        int i5 = gVar.f5867g;
        c(this.f5867g + i5);
        if (this.f5867g != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                put(gVar.i(i6), gVar.m(i6));
            }
        } else if (i5 > 0) {
            System.arraycopy(gVar.f5865e, 0, this.f5865e, 0, i5);
            System.arraycopy(gVar.f5866f, 0, this.f5866f, 0, i5 << 1);
            this.f5867g = i5;
        }
    }

    public V k(int i5) {
        V[] vArr = this.f5866f;
        int i6 = i5 << 1;
        V v5 = vArr[i6 + 1];
        int i7 = this.f5867g;
        int i8 = 0;
        if (i7 <= 1) {
            d(this.f5865e, vArr, i7);
            this.f5865e = c.f5830a;
            this.f5866f = c.f5832c;
        } else {
            int i9 = i7 - 1;
            int[] iArr = this.f5865e;
            int i10 = 8;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                if (i5 < i9) {
                    int i11 = i5 + 1;
                    int i12 = i9 - i5;
                    System.arraycopy(iArr, i11, iArr, i5, i12);
                    Object[] objArr = this.f5866f;
                    System.arraycopy(objArr, i11 << 1, objArr, i6, i12 << 1);
                }
                Object[] objArr2 = this.f5866f;
                int i13 = i9 << 1;
                objArr2[i13] = null;
                objArr2[i13 + 1] = null;
            } else {
                if (i7 > 8) {
                    i10 = i7 + (i7 >> 1);
                }
                a(i10);
                if (i7 == this.f5867g) {
                    if (i5 > 0) {
                        System.arraycopy(iArr, 0, this.f5865e, 0, i5);
                        System.arraycopy(vArr, 0, this.f5866f, 0, i6);
                    }
                    if (i5 < i9) {
                        int i14 = i5 + 1;
                        int i15 = i9 - i5;
                        System.arraycopy(iArr, i14, this.f5865e, i5, i15);
                        System.arraycopy(vArr, i14 << 1, this.f5866f, i6, i15 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i8 = i9;
        }
        if (i7 == this.f5867g) {
            this.f5867g = i8;
            return v5;
        }
        throw new ConcurrentModificationException();
    }

    public V l(int i5, V v5) {
        int i6 = (i5 << 1) + 1;
        V[] vArr = this.f5866f;
        V v6 = vArr[i6];
        vArr[i6] = v5;
        return v6;
    }

    public V m(int i5) {
        return this.f5866f[(i5 << 1) + 1];
    }

    public V put(K k5, V v5) {
        int i5;
        int i6;
        int i7 = this.f5867g;
        if (k5 == null) {
            i6 = g();
            i5 = 0;
        } else {
            int hashCode = k5.hashCode();
            i5 = hashCode;
            i6 = e(k5, hashCode);
        }
        if (i6 >= 0) {
            int i8 = (i6 << 1) + 1;
            V[] vArr = this.f5866f;
            V v6 = vArr[i8];
            vArr[i8] = v5;
            return v6;
        }
        int i9 = ~i6;
        int[] iArr = this.f5865e;
        if (i7 >= iArr.length) {
            int i10 = 4;
            if (i7 >= 8) {
                i10 = (i7 >> 1) + i7;
            } else if (i7 >= 4) {
                i10 = 8;
            }
            Object[] objArr = this.f5866f;
            a(i10);
            if (i7 == this.f5867g) {
                int[] iArr2 = this.f5865e;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f5866f, 0, objArr.length);
                }
                d(iArr, objArr, i7);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i9 < i7) {
            int[] iArr3 = this.f5865e;
            int i11 = i9 + 1;
            System.arraycopy(iArr3, i9, iArr3, i11, i7 - i9);
            Object[] objArr2 = this.f5866f;
            System.arraycopy(objArr2, i9 << 1, objArr2, i11 << 1, (this.f5867g - i9) << 1);
        }
        int i12 = this.f5867g;
        if (i7 == i12) {
            int[] iArr4 = this.f5865e;
            if (i9 < iArr4.length) {
                iArr4[i9] = i5;
                Object[] objArr3 = this.f5866f;
                int i13 = i9 << 1;
                objArr3[i13] = k5;
                objArr3[i13 + 1] = v5;
                this.f5867g = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k5, V v5) {
        V v6 = get(k5);
        return v6 == null ? put(k5, v5) : v6;
    }

    public V remove(Object obj) {
        int f5 = f(obj);
        if (f5 >= 0) {
            return k(f5);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f5 = f(obj);
        if (f5 < 0) {
            return false;
        }
        Object m5 = m(f5);
        if (obj2 != m5 && (obj2 == null || !obj2.equals(m5))) {
            return false;
        }
        k(f5);
        return true;
    }

    public V replace(K k5, V v5) {
        int f5 = f(k5);
        if (f5 >= 0) {
            return l(f5, v5);
        }
        return null;
    }

    public boolean replace(K k5, V v5, V v6) {
        int f5 = f(k5);
        if (f5 < 0) {
            return false;
        }
        V m5 = m(f5);
        if (m5 != v5 && (v5 == null || !v5.equals(m5))) {
            return false;
        }
        l(f5, v6);
        return true;
    }

    public int size() {
        return this.f5867g;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5867g * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f5867g; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object i6 = i(i5);
            if (i6 != this) {
                sb.append(i6);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object m5 = m(i5);
            if (m5 != this) {
                sb.append(m5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
