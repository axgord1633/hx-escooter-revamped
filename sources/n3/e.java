package n3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class e<E> extends c<E> {

    /* renamed from: h  reason: collision with root package name */
    public static final a f6072h = new a((g) null);

    /* renamed from: i  reason: collision with root package name */
    private static final Object[] f6073i = new Object[0];

    /* renamed from: e  reason: collision with root package name */
    private int f6074e;

    /* renamed from: f  reason: collision with root package name */
    private Object[] f6075f = f6073i;

    /* renamed from: g  reason: collision with root package name */
    private int f6076g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final int a(int i5, int i6) {
            int i7 = i5 + (i5 >> 1);
            if (i7 - i6 < 0) {
                i7 = i6;
            }
            return i7 - 2147483639 > 0 ? i6 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i7;
        }
    }

    private final void f(int i5, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f6075f.length;
        while (i5 < length && it.hasNext()) {
            this.f6075f[i5] = it.next();
            i5++;
        }
        int i6 = this.f6074e;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.f6075f[i7] = it.next();
        }
        this.f6076g = size() + collection.size();
    }

    private final void i(int i5) {
        Object[] objArr = new Object[i5];
        Object[] objArr2 = this.f6075f;
        i.d(objArr2, objArr, 0, this.f6074e, objArr2.length);
        Object[] objArr3 = this.f6075f;
        int length = objArr3.length;
        int i6 = this.f6074e;
        i.d(objArr3, objArr, length - i6, 0, i6);
        this.f6074e = 0;
        this.f6075f = objArr;
    }

    private final int l(int i5) {
        return i5 == 0 ? j.m(this.f6075f) : i5 - 1;
    }

    private final void m(int i5) {
        if (i5 >= 0) {
            Object[] objArr = this.f6075f;
            if (i5 > objArr.length) {
                if (objArr == f6073i) {
                    this.f6075f = new Object[f.a(i5, 10)];
                } else {
                    i(f6072h.a(objArr.length, i5));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    private final int n(int i5) {
        if (i5 == j.m(this.f6075f)) {
            return 0;
        }
        return i5 + 1;
    }

    private final int o(int i5) {
        return i5 < 0 ? i5 + this.f6075f.length : i5;
    }

    private final int p(int i5) {
        Object[] objArr = this.f6075f;
        return i5 >= objArr.length ? i5 - objArr.length : i5;
    }

    public void add(int i5, E e5) {
        b.f6063e.b(i5, size());
        if (i5 == size()) {
            addLast(e5);
        } else if (i5 == 0) {
            addFirst(e5);
        } else {
            m(size() + 1);
            int p5 = p(this.f6074e + i5);
            if (i5 < ((size() + 1) >> 1)) {
                int l5 = l(p5);
                int l6 = l(this.f6074e);
                int i6 = this.f6074e;
                if (l5 >= i6) {
                    Object[] objArr = this.f6075f;
                    objArr[l6] = objArr[i6];
                    i.d(objArr, objArr, i6, i6 + 1, l5 + 1);
                } else {
                    Object[] objArr2 = this.f6075f;
                    i.d(objArr2, objArr2, i6 - 1, i6, objArr2.length);
                    Object[] objArr3 = this.f6075f;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    i.d(objArr3, objArr3, 0, 1, l5 + 1);
                }
                this.f6075f[l5] = e5;
                this.f6074e = l6;
            } else {
                int p6 = p(this.f6074e + size());
                Object[] objArr4 = this.f6075f;
                if (p5 < p6) {
                    i.d(objArr4, objArr4, p5 + 1, p5, p6);
                } else {
                    i.d(objArr4, objArr4, 1, 0, p6);
                    Object[] objArr5 = this.f6075f;
                    objArr5[0] = objArr5[objArr5.length - 1];
                    i.d(objArr5, objArr5, p5 + 1, p5, objArr5.length - 1);
                }
                this.f6075f[p5] = e5;
            }
            this.f6076g = size() + 1;
        }
    }

    public boolean add(E e5) {
        addLast(e5);
        return true;
    }

    public boolean addAll(int i5, Collection<? extends E> collection) {
        k.e(collection, "elements");
        b.f6063e.b(i5, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i5 == size()) {
            return addAll(collection);
        }
        m(size() + collection.size());
        int p5 = p(this.f6074e + size());
        int p6 = p(this.f6074e + i5);
        int size = collection.size();
        if (i5 < ((size() + 1) >> 1)) {
            int i6 = this.f6074e;
            int i7 = i6 - size;
            if (p6 < i6) {
                Object[] objArr = this.f6075f;
                i.d(objArr, objArr, i7, i6, objArr.length);
                Object[] objArr2 = this.f6075f;
                if (size >= p6) {
                    i.d(objArr2, objArr2, objArr2.length - size, 0, p6);
                } else {
                    i.d(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f6075f;
                    i.d(objArr3, objArr3, 0, size, p6);
                }
            } else if (i7 >= 0) {
                Object[] objArr4 = this.f6075f;
                i.d(objArr4, objArr4, i7, i6, p6);
            } else {
                Object[] objArr5 = this.f6075f;
                i7 += objArr5.length;
                int i8 = p6 - i6;
                int length = objArr5.length - i7;
                if (length >= i8) {
                    i.d(objArr5, objArr5, i7, i6, p6);
                } else {
                    i.d(objArr5, objArr5, i7, i6, i6 + length);
                    Object[] objArr6 = this.f6075f;
                    i.d(objArr6, objArr6, 0, this.f6074e + length, p6);
                }
            }
            this.f6074e = i7;
            f(o(p6 - size), collection);
        } else {
            int i9 = p6 + size;
            if (p6 < p5) {
                int i10 = size + p5;
                Object[] objArr7 = this.f6075f;
                if (i10 > objArr7.length) {
                    if (i9 >= objArr7.length) {
                        i9 -= objArr7.length;
                    } else {
                        int length2 = p5 - (i10 - objArr7.length);
                        i.d(objArr7, objArr7, 0, length2, p5);
                        Object[] objArr8 = this.f6075f;
                        i.d(objArr8, objArr8, i9, p6, length2);
                    }
                }
                i.d(objArr7, objArr7, i9, p6, p5);
            } else {
                Object[] objArr9 = this.f6075f;
                i.d(objArr9, objArr9, size, 0, p5);
                Object[] objArr10 = this.f6075f;
                if (i9 >= objArr10.length) {
                    i.d(objArr10, objArr10, i9 - objArr10.length, p6, objArr10.length);
                } else {
                    i.d(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f6075f;
                    i.d(objArr11, objArr11, i9, p6, objArr11.length - size);
                }
            }
            f(p6, collection);
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        k.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        m(size() + collection.size());
        f(p(this.f6074e + size()), collection);
        return true;
    }

    public final void addFirst(E e5) {
        m(size() + 1);
        int l5 = l(this.f6074e);
        this.f6074e = l5;
        this.f6075f[l5] = e5;
        this.f6076g = size() + 1;
    }

    public final void addLast(E e5) {
        m(size() + 1);
        this.f6075f[p(this.f6074e + size())] = e5;
        this.f6076g = size() + 1;
    }

    public int c() {
        return this.f6076g;
    }

    public void clear() {
        int p5 = p(this.f6074e + size());
        int i5 = this.f6074e;
        if (i5 < p5) {
            i.f(this.f6075f, null, i5, p5);
        } else if (!isEmpty()) {
            Object[] objArr = this.f6075f;
            i.f(objArr, null, this.f6074e, objArr.length);
            i.f(this.f6075f, null, 0, p5);
        }
        this.f6074e = 0;
        this.f6076g = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public E e(int i5) {
        b.f6063e.a(i5, size());
        if (i5 == n.e(this)) {
            return removeLast();
        }
        if (i5 == 0) {
            return removeFirst();
        }
        int p5 = p(this.f6074e + i5);
        E e5 = this.f6075f[p5];
        if (i5 < (size() >> 1)) {
            int i6 = this.f6074e;
            if (p5 >= i6) {
                Object[] objArr = this.f6075f;
                i.d(objArr, objArr, i6 + 1, i6, p5);
            } else {
                Object[] objArr2 = this.f6075f;
                i.d(objArr2, objArr2, 1, 0, p5);
                Object[] objArr3 = this.f6075f;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i7 = this.f6074e;
                i.d(objArr3, objArr3, i7 + 1, i7, objArr3.length - 1);
            }
            Object[] objArr4 = this.f6075f;
            int i8 = this.f6074e;
            objArr4[i8] = null;
            this.f6074e = n(i8);
        } else {
            int p6 = p(this.f6074e + n.e(this));
            Object[] objArr5 = this.f6075f;
            if (p5 <= p6) {
                i.d(objArr5, objArr5, p5, p5 + 1, p6 + 1);
            } else {
                i.d(objArr5, objArr5, p5, p5 + 1, objArr5.length);
                Object[] objArr6 = this.f6075f;
                objArr6[objArr6.length - 1] = objArr6[0];
                i.d(objArr6, objArr6, 0, 1, p6 + 1);
            }
            this.f6075f[p6] = null;
        }
        this.f6076g = size() - 1;
        return e5;
    }

    public E get(int i5) {
        b.f6063e.a(i5, size());
        return this.f6075f[p(this.f6074e + i5)];
    }

    public int indexOf(Object obj) {
        int p5 = p(this.f6074e + size());
        int i5 = this.f6074e;
        if (i5 < p5) {
            while (i5 < p5) {
                if (!k.a(obj, this.f6075f[i5])) {
                    i5++;
                }
            }
            return -1;
        } else if (i5 < p5) {
            return -1;
        } else {
            int length = this.f6075f.length;
            while (true) {
                if (i5 >= length) {
                    int i6 = 0;
                    while (i6 < p5) {
                        if (k.a(obj, this.f6075f[i6])) {
                            i5 = i6 + this.f6075f.length;
                        } else {
                            i6++;
                        }
                    }
                    return -1;
                } else if (k.a(obj, this.f6075f[i5])) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        return i5 - this.f6074e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int lastIndexOf(Object obj) {
        int i5;
        int p5 = p(this.f6074e + size());
        int i6 = this.f6074e;
        if (i6 < p5) {
            i5 = p5 - 1;
            if (i6 <= i5) {
                while (!k.a(obj, this.f6075f[i5])) {
                    if (i5 != i6) {
                        i5--;
                    }
                }
            }
            return -1;
        }
        if (i6 > p5) {
            int i7 = p5 - 1;
            while (true) {
                if (-1 >= i7) {
                    int m5 = j.m(this.f6075f);
                    int i8 = this.f6074e;
                    if (i8 <= m5) {
                        while (!k.a(obj, this.f6075f[i5])) {
                            if (i5 != i8) {
                                m5 = i5 - 1;
                            }
                        }
                    }
                } else if (k.a(obj, this.f6075f[i7])) {
                    i5 = i7 + this.f6075f.length;
                    break;
                } else {
                    i7--;
                }
            }
        }
        return -1;
        return i5 - this.f6074e;
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.k.e(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0096
            java.lang.Object[] r0 = r11.f6075f
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0096
        L_0x0019:
            int r0 = r11.f6074e
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.p(r0)
            int r3 = r11.f6074e
            r4 = 0
            if (r3 >= r0) goto L_0x0049
            r5 = r3
        L_0x002a:
            if (r3 >= r0) goto L_0x0043
            java.lang.Object[] r6 = r11.f6075f
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x003f
            java.lang.Object[] r7 = r11.f6075f
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x0040
        L_0x003f:
            r1 = r2
        L_0x0040:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0043:
            java.lang.Object[] r12 = r11.f6075f
            n3.i.f(r12, r4, r5, r0)
            goto L_0x008b
        L_0x0049:
            java.lang.Object[] r5 = r11.f6075f
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x004e:
            if (r3 >= r5) goto L_0x0069
            java.lang.Object[] r8 = r11.f6075f
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x0065
            java.lang.Object[] r8 = r11.f6075f
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0066
        L_0x0065:
            r7 = r2
        L_0x0066:
            int r3 = r3 + 1
            goto L_0x004e
        L_0x0069:
            int r3 = r11.p(r6)
            r5 = r3
        L_0x006e:
            if (r1 >= r0) goto L_0x008a
            java.lang.Object[] r3 = r11.f6075f
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0086
            java.lang.Object[] r3 = r11.f6075f
            r3[r5] = r6
            int r5 = r11.n(r5)
            goto L_0x0087
        L_0x0086:
            r7 = r2
        L_0x0087:
            int r1 = r1 + 1
            goto L_0x006e
        L_0x008a:
            r1 = r7
        L_0x008b:
            if (r1 == 0) goto L_0x0096
            int r12 = r11.f6074e
            int r5 = r5 - r12
            int r12 = r11.o(r5)
            r11.f6076g = r12
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.e.removeAll(java.util.Collection):boolean");
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E[] eArr = this.f6075f;
            int i5 = this.f6074e;
            E e5 = eArr[i5];
            eArr[i5] = null;
            this.f6074e = n(i5);
            this.f6076g = size() - 1;
            return e5;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int p5 = p(this.f6074e + n.e(this));
            E[] eArr = this.f6075f;
            E e5 = eArr[p5];
            eArr[p5] = null;
            this.f6076g = size() - 1;
            return e5;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.k.e(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0093
            java.lang.Object[] r0 = r11.f6075f
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0093
        L_0x0019:
            int r0 = r11.f6074e
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.p(r0)
            int r3 = r11.f6074e
            r4 = 0
            if (r3 >= r0) goto L_0x0048
            r5 = r3
        L_0x002a:
            if (r3 >= r0) goto L_0x0042
            java.lang.Object[] r6 = r11.f6075f
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x003e
            java.lang.Object[] r7 = r11.f6075f
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0042:
            java.lang.Object[] r12 = r11.f6075f
            n3.i.f(r12, r4, r5, r0)
            goto L_0x0088
        L_0x0048:
            java.lang.Object[] r5 = r11.f6075f
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x004d:
            if (r3 >= r5) goto L_0x0067
            java.lang.Object[] r8 = r11.f6075f
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x0063
            java.lang.Object[] r8 = r11.f6075f
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0064
        L_0x0063:
            r7 = r2
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0067:
            int r3 = r11.p(r6)
            r5 = r3
        L_0x006c:
            if (r1 >= r0) goto L_0x0087
            java.lang.Object[] r3 = r11.f6075f
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            if (r3 == 0) goto L_0x0083
            java.lang.Object[] r3 = r11.f6075f
            r3[r5] = r6
            int r5 = r11.n(r5)
            goto L_0x0084
        L_0x0083:
            r7 = r2
        L_0x0084:
            int r1 = r1 + 1
            goto L_0x006c
        L_0x0087:
            r1 = r7
        L_0x0088:
            if (r1 == 0) goto L_0x0093
            int r12 = r11.f6074e
            int r5 = r5 - r12
            int r12 = r11.o(r5)
            r11.f6076g = r12
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.e.retainAll(java.util.Collection):boolean");
    }

    public E set(int i5, E e5) {
        b.f6063e.a(i5, size());
        int p5 = p(this.f6074e + i5);
        E[] eArr = this.f6075f;
        E e6 = eArr[p5];
        eArr[p5] = e5;
        return e6;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] toArray(T[] tArr) {
        k.e(tArr, "array");
        if (tArr.length < size()) {
            tArr = g.a(tArr, size());
        }
        int p5 = p(this.f6074e + size());
        int i5 = this.f6074e;
        if (i5 < p5) {
            Object[] unused = i.e(this.f6075f, tArr, 0, i5, p5, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f6075f;
            i.d(objArr, tArr, 0, this.f6074e, objArr.length);
            Object[] objArr2 = this.f6075f;
            i.d(objArr2, tArr, objArr2.length - this.f6074e, 0, p5);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }
}
