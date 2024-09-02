package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class n extends c<Double> implements b0.b, RandomAccess, c1 {

    /* renamed from: h  reason: collision with root package name */
    private static final n f3639h;

    /* renamed from: f  reason: collision with root package name */
    private double[] f3640f;

    /* renamed from: g  reason: collision with root package name */
    private int f3641g;

    static {
        n nVar = new n(new double[0], 0);
        f3639h = nVar;
        nVar.b();
    }

    n() {
        this(new double[10], 0);
    }

    private n(double[] dArr, int i5) {
        this.f3640f = dArr;
        this.f3641g = i5;
    }

    private void l(int i5, double d5) {
        int i6;
        c();
        if (i5 < 0 || i5 > (i6 = this.f3641g)) {
            throw new IndexOutOfBoundsException(q(i5));
        }
        double[] dArr = this.f3640f;
        if (i6 < dArr.length) {
            System.arraycopy(dArr, i5, dArr, i5 + 1, i6 - i5);
        } else {
            double[] dArr2 = new double[(((i6 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            System.arraycopy(this.f3640f, i5, dArr2, i5 + 1, this.f3641g - i5);
            this.f3640f = dArr2;
        }
        this.f3640f[i5] = d5;
        this.f3641g++;
        this.modCount++;
    }

    public static n m() {
        return f3639h;
    }

    private void n(int i5) {
        if (i5 < 0 || i5 >= this.f3641g) {
            throw new IndexOutOfBoundsException(q(i5));
        }
    }

    private String q(int i5) {
        return "Index:" + i5 + ", Size:" + this.f3641g;
    }

    public b0.b a(int i5) {
        if (i5 >= this.f3641g) {
            return new n(Arrays.copyOf(this.f3640f, i5), this.f3641g);
        }
        throw new IllegalArgumentException();
    }

    public boolean addAll(Collection<? extends Double> collection) {
        c();
        b0.a(collection);
        if (!(collection instanceof n)) {
            return super.addAll(collection);
        }
        n nVar = (n) collection;
        int i5 = nVar.f3641g;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f3641g;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            double[] dArr = this.f3640f;
            if (i7 > dArr.length) {
                this.f3640f = Arrays.copyOf(dArr, i7);
            }
            System.arraycopy(nVar.f3640f, 0, this.f3640f, this.f3641g, nVar.f3641g);
            this.f3641g = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: e */
    public void add(int i5, Double d5) {
        l(i5, d5.doubleValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return super.equals(obj);
        }
        n nVar = (n) obj;
        if (this.f3641g != nVar.f3641g) {
            return false;
        }
        double[] dArr = nVar.f3640f;
        for (int i5 = 0; i5 < this.f3641g; i5++) {
            if (Double.doubleToLongBits(this.f3640f[i5]) != Double.doubleToLongBits(dArr[i5])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Double d5) {
        i(d5.doubleValue());
        return true;
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f3641g; i6++) {
            i5 = (i5 * 31) + b0.f(Double.doubleToLongBits(this.f3640f[i6]));
        }
        return i5;
    }

    public void i(double d5) {
        c();
        int i5 = this.f3641g;
        double[] dArr = this.f3640f;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[(((i5 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            this.f3640f = dArr2;
        }
        double[] dArr3 = this.f3640f;
        int i6 = this.f3641g;
        this.f3641g = i6 + 1;
        dArr3[i6] = d5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f3640f[i5] == doubleValue) {
                return i5;
            }
        }
        return -1;
    }

    /* renamed from: o */
    public Double get(int i5) {
        return Double.valueOf(p(i5));
    }

    public double p(int i5) {
        n(i5);
        return this.f3640f[i5];
    }

    /* renamed from: r */
    public Double remove(int i5) {
        c();
        n(i5);
        double[] dArr = this.f3640f;
        double d5 = dArr[i5];
        int i6 = this.f3641g;
        if (i5 < i6 - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (i6 - i5) - 1);
        }
        this.f3641g--;
        this.modCount++;
        return Double.valueOf(d5);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        c();
        if (i6 >= i5) {
            double[] dArr = this.f3640f;
            System.arraycopy(dArr, i6, dArr, i5, this.f3641g - i6);
            this.f3641g -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    /* renamed from: s */
    public Double set(int i5, Double d5) {
        return Double.valueOf(t(i5, d5.doubleValue()));
    }

    public int size() {
        return this.f3641g;
    }

    public double t(int i5, double d5) {
        c();
        n(i5);
        double[] dArr = this.f3640f;
        double d6 = dArr[i5];
        dArr[i5] = d5;
        return d6;
    }
}
