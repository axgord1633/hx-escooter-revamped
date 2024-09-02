package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class a0 extends c<Integer> implements b0.g, RandomAccess, c1 {

    /* renamed from: h  reason: collision with root package name */
    private static final a0 f3464h;

    /* renamed from: f  reason: collision with root package name */
    private int[] f3465f;

    /* renamed from: g  reason: collision with root package name */
    private int f3466g;

    static {
        a0 a0Var = new a0(new int[0], 0);
        f3464h = a0Var;
        a0Var.b();
    }

    a0() {
        this(new int[10], 0);
    }

    private a0(int[] iArr, int i5) {
        this.f3465f = iArr;
        this.f3466g = i5;
    }

    private void l(int i5, int i6) {
        int i7;
        c();
        if (i5 < 0 || i5 > (i7 = this.f3466g)) {
            throw new IndexOutOfBoundsException(q(i5));
        }
        int[] iArr = this.f3465f;
        if (i7 < iArr.length) {
            System.arraycopy(iArr, i5, iArr, i5 + 1, i7 - i5);
        } else {
            int[] iArr2 = new int[(((i7 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.f3465f, i5, iArr2, i5 + 1, this.f3466g - i5);
            this.f3465f = iArr2;
        }
        this.f3465f[i5] = i6;
        this.f3466g++;
        this.modCount++;
    }

    public static a0 m() {
        return f3464h;
    }

    private void n(int i5) {
        if (i5 < 0 || i5 >= this.f3466g) {
            throw new IndexOutOfBoundsException(q(i5));
        }
    }

    private String q(int i5) {
        return "Index:" + i5 + ", Size:" + this.f3466g;
    }

    public b0.g a(int i5) {
        if (i5 >= this.f3466g) {
            return new a0(Arrays.copyOf(this.f3465f, i5), this.f3466g);
        }
        throw new IllegalArgumentException();
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        c();
        b0.a(collection);
        if (!(collection instanceof a0)) {
            return super.addAll(collection);
        }
        a0 a0Var = (a0) collection;
        int i5 = a0Var.f3466g;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f3466g;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            int[] iArr = this.f3465f;
            if (i7 > iArr.length) {
                this.f3465f = Arrays.copyOf(iArr, i7);
            }
            System.arraycopy(a0Var.f3465f, 0, this.f3465f, this.f3466g, a0Var.f3466g);
            this.f3466g = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: e */
    public void add(int i5, Integer num) {
        l(i5, num.intValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return super.equals(obj);
        }
        a0 a0Var = (a0) obj;
        if (this.f3466g != a0Var.f3466g) {
            return false;
        }
        int[] iArr = a0Var.f3465f;
        for (int i5 = 0; i5 < this.f3466g; i5++) {
            if (this.f3465f[i5] != iArr[i5]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Integer num) {
        i(num.intValue());
        return true;
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f3466g; i6++) {
            i5 = (i5 * 31) + this.f3465f[i6];
        }
        return i5;
    }

    public void i(int i5) {
        c();
        int i6 = this.f3466g;
        int[] iArr = this.f3465f;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[(((i6 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f3465f = iArr2;
        }
        int[] iArr3 = this.f3465f;
        int i7 = this.f3466g;
        this.f3466g = i7 + 1;
        iArr3[i7] = i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f3465f[i5] == intValue) {
                return i5;
            }
        }
        return -1;
    }

    /* renamed from: o */
    public Integer get(int i5) {
        return Integer.valueOf(p(i5));
    }

    public int p(int i5) {
        n(i5);
        return this.f3465f[i5];
    }

    /* renamed from: r */
    public Integer remove(int i5) {
        c();
        n(i5);
        int[] iArr = this.f3465f;
        int i6 = iArr[i5];
        int i7 = this.f3466g;
        if (i5 < i7 - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i7 - i5) - 1);
        }
        this.f3466g--;
        this.modCount++;
        return Integer.valueOf(i6);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        c();
        if (i6 >= i5) {
            int[] iArr = this.f3465f;
            System.arraycopy(iArr, i6, iArr, i5, this.f3466g - i6);
            this.f3466g -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    /* renamed from: s */
    public Integer set(int i5, Integer num) {
        return Integer.valueOf(t(i5, num.intValue()));
    }

    public int size() {
        return this.f3466g;
    }

    public int t(int i5, int i6) {
        c();
        n(i5);
        int[] iArr = this.f3465f;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        return i7;
    }
}
