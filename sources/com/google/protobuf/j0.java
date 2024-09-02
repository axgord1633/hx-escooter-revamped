package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class j0 extends c<Long> implements b0.h, RandomAccess, c1 {

    /* renamed from: h  reason: collision with root package name */
    private static final j0 f3582h;

    /* renamed from: f  reason: collision with root package name */
    private long[] f3583f;

    /* renamed from: g  reason: collision with root package name */
    private int f3584g;

    static {
        j0 j0Var = new j0(new long[0], 0);
        f3582h = j0Var;
        j0Var.b();
    }

    j0() {
        this(new long[10], 0);
    }

    private j0(long[] jArr, int i5) {
        this.f3583f = jArr;
        this.f3584g = i5;
    }

    private void i(int i5, long j5) {
        int i6;
        c();
        if (i5 < 0 || i5 > (i6 = this.f3584g)) {
            throw new IndexOutOfBoundsException(q(i5));
        }
        long[] jArr = this.f3583f;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i5 + 1, i6 - i5);
        } else {
            long[] jArr2 = new long[(((i6 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.f3583f, i5, jArr2, i5 + 1, this.f3584g - i5);
            this.f3583f = jArr2;
        }
        this.f3583f[i5] = j5;
        this.f3584g++;
        this.modCount++;
    }

    public static j0 m() {
        return f3582h;
    }

    private void n(int i5) {
        if (i5 < 0 || i5 >= this.f3584g) {
            throw new IndexOutOfBoundsException(q(i5));
        }
    }

    private String q(int i5) {
        return "Index:" + i5 + ", Size:" + this.f3584g;
    }

    public b0.h a(int i5) {
        if (i5 >= this.f3584g) {
            return new j0(Arrays.copyOf(this.f3583f, i5), this.f3584g);
        }
        throw new IllegalArgumentException();
    }

    public boolean addAll(Collection<? extends Long> collection) {
        c();
        b0.a(collection);
        if (!(collection instanceof j0)) {
            return super.addAll(collection);
        }
        j0 j0Var = (j0) collection;
        int i5 = j0Var.f3584g;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f3584g;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            long[] jArr = this.f3583f;
            if (i7 > jArr.length) {
                this.f3583f = Arrays.copyOf(jArr, i7);
            }
            System.arraycopy(j0Var.f3583f, 0, this.f3583f, this.f3584g, j0Var.f3584g);
            this.f3584g = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: e */
    public void add(int i5, Long l5) {
        i(i5, l5.longValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return super.equals(obj);
        }
        j0 j0Var = (j0) obj;
        if (this.f3584g != j0Var.f3584g) {
            return false;
        }
        long[] jArr = j0Var.f3583f;
        for (int i5 = 0; i5 < this.f3584g; i5++) {
            if (this.f3583f[i5] != jArr[i5]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Long l5) {
        l(l5.longValue());
        return true;
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f3584g; i6++) {
            i5 = (i5 * 31) + b0.f(this.f3583f[i6]);
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f3583f[i5] == longValue) {
                return i5;
            }
        }
        return -1;
    }

    public void l(long j5) {
        c();
        int i5 = this.f3584g;
        long[] jArr = this.f3583f;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[(((i5 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.f3583f = jArr2;
        }
        long[] jArr3 = this.f3583f;
        int i6 = this.f3584g;
        this.f3584g = i6 + 1;
        jArr3[i6] = j5;
    }

    /* renamed from: o */
    public Long get(int i5) {
        return Long.valueOf(p(i5));
    }

    public long p(int i5) {
        n(i5);
        return this.f3583f[i5];
    }

    /* renamed from: r */
    public Long remove(int i5) {
        c();
        n(i5);
        long[] jArr = this.f3583f;
        long j5 = jArr[i5];
        int i6 = this.f3584g;
        if (i5 < i6 - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (i6 - i5) - 1);
        }
        this.f3584g--;
        this.modCount++;
        return Long.valueOf(j5);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        c();
        if (i6 >= i5) {
            long[] jArr = this.f3583f;
            System.arraycopy(jArr, i6, jArr, i5, this.f3584g - i6);
            this.f3584g -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    /* renamed from: s */
    public Long set(int i5, Long l5) {
        return Long.valueOf(t(i5, l5.longValue()));
    }

    public int size() {
        return this.f3584g;
    }

    public long t(int i5, long j5) {
        c();
        n(i5);
        long[] jArr = this.f3583f;
        long j6 = jArr[i5];
        jArr[i5] = j5;
        return j6;
    }
}
