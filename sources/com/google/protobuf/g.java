package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class g extends c<Boolean> implements b0.a, RandomAccess, c1 {

    /* renamed from: h  reason: collision with root package name */
    private static final g f3523h;

    /* renamed from: f  reason: collision with root package name */
    private boolean[] f3524f;

    /* renamed from: g  reason: collision with root package name */
    private int f3525g;

    static {
        g gVar = new g(new boolean[0], 0);
        f3523h = gVar;
        gVar.b();
    }

    g() {
        this(new boolean[10], 0);
    }

    private g(boolean[] zArr, int i5) {
        this.f3524f = zArr;
        this.f3525g = i5;
    }

    private void i(int i5, boolean z4) {
        int i6;
        c();
        if (i5 < 0 || i5 > (i6 = this.f3525g)) {
            throw new IndexOutOfBoundsException(q(i5));
        }
        boolean[] zArr = this.f3524f;
        if (i6 < zArr.length) {
            System.arraycopy(zArr, i5, zArr, i5 + 1, i6 - i5);
        } else {
            boolean[] zArr2 = new boolean[(((i6 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            System.arraycopy(this.f3524f, i5, zArr2, i5 + 1, this.f3525g - i5);
            this.f3524f = zArr2;
        }
        this.f3524f[i5] = z4;
        this.f3525g++;
        this.modCount++;
    }

    public static g m() {
        return f3523h;
    }

    private void n(int i5) {
        if (i5 < 0 || i5 >= this.f3525g) {
            throw new IndexOutOfBoundsException(q(i5));
        }
    }

    private String q(int i5) {
        return "Index:" + i5 + ", Size:" + this.f3525g;
    }

    public b0.a a(int i5) {
        if (i5 >= this.f3525g) {
            return new g(Arrays.copyOf(this.f3524f, i5), this.f3525g);
        }
        throw new IllegalArgumentException();
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        c();
        b0.a(collection);
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i5 = gVar.f3525g;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f3525g;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            boolean[] zArr = this.f3524f;
            if (i7 > zArr.length) {
                this.f3524f = Arrays.copyOf(zArr, i7);
            }
            System.arraycopy(gVar.f3524f, 0, this.f3524f, this.f3525g, gVar.f3525g);
            this.f3525g = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: e */
    public void add(int i5, Boolean bool) {
        i(i5, bool.booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return super.equals(obj);
        }
        g gVar = (g) obj;
        if (this.f3525g != gVar.f3525g) {
            return false;
        }
        boolean[] zArr = gVar.f3524f;
        for (int i5 = 0; i5 < this.f3525g; i5++) {
            if (this.f3524f[i5] != zArr[i5]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Boolean bool) {
        l(bool.booleanValue());
        return true;
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f3525g; i6++) {
            i5 = (i5 * 31) + b0.c(this.f3524f[i6]);
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f3524f[i5] == booleanValue) {
                return i5;
            }
        }
        return -1;
    }

    public void l(boolean z4) {
        c();
        int i5 = this.f3525g;
        boolean[] zArr = this.f3524f;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i5 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            this.f3524f = zArr2;
        }
        boolean[] zArr3 = this.f3524f;
        int i6 = this.f3525g;
        this.f3525g = i6 + 1;
        zArr3[i6] = z4;
    }

    /* renamed from: o */
    public Boolean get(int i5) {
        return Boolean.valueOf(p(i5));
    }

    public boolean p(int i5) {
        n(i5);
        return this.f3524f[i5];
    }

    /* renamed from: r */
    public Boolean remove(int i5) {
        c();
        n(i5);
        boolean[] zArr = this.f3524f;
        boolean z4 = zArr[i5];
        int i6 = this.f3525g;
        if (i5 < i6 - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (i6 - i5) - 1);
        }
        this.f3525g--;
        this.modCount++;
        return Boolean.valueOf(z4);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        c();
        if (i6 >= i5) {
            boolean[] zArr = this.f3524f;
            System.arraycopy(zArr, i6, zArr, i5, this.f3525g - i6);
            this.f3525g -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    /* renamed from: s */
    public Boolean set(int i5, Boolean bool) {
        return Boolean.valueOf(t(i5, bool.booleanValue()));
    }

    public int size() {
        return this.f3525g;
    }

    public boolean t(int i5, boolean z4) {
        c();
        n(i5);
        boolean[] zArr = this.f3524f;
        boolean z5 = zArr[i5];
        zArr[i5] = z4;
        return z5;
    }
}
