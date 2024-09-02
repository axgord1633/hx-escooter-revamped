package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class x extends c<Float> implements b0.f, RandomAccess, c1 {

    /* renamed from: h  reason: collision with root package name */
    private static final x f3802h;

    /* renamed from: f  reason: collision with root package name */
    private float[] f3803f;

    /* renamed from: g  reason: collision with root package name */
    private int f3804g;

    static {
        x xVar = new x(new float[0], 0);
        f3802h = xVar;
        xVar.b();
    }

    x() {
        this(new float[10], 0);
    }

    private x(float[] fArr, int i5) {
        this.f3803f = fArr;
        this.f3804g = i5;
    }

    private void l(int i5, float f5) {
        int i6;
        c();
        if (i5 < 0 || i5 > (i6 = this.f3804g)) {
            throw new IndexOutOfBoundsException(q(i5));
        }
        float[] fArr = this.f3803f;
        if (i6 < fArr.length) {
            System.arraycopy(fArr, i5, fArr, i5 + 1, i6 - i5);
        } else {
            float[] fArr2 = new float[(((i6 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            System.arraycopy(this.f3803f, i5, fArr2, i5 + 1, this.f3804g - i5);
            this.f3803f = fArr2;
        }
        this.f3803f[i5] = f5;
        this.f3804g++;
        this.modCount++;
    }

    public static x m() {
        return f3802h;
    }

    private void n(int i5) {
        if (i5 < 0 || i5 >= this.f3804g) {
            throw new IndexOutOfBoundsException(q(i5));
        }
    }

    private String q(int i5) {
        return "Index:" + i5 + ", Size:" + this.f3804g;
    }

    public b0.f a(int i5) {
        if (i5 >= this.f3804g) {
            return new x(Arrays.copyOf(this.f3803f, i5), this.f3804g);
        }
        throw new IllegalArgumentException();
    }

    public boolean addAll(Collection<? extends Float> collection) {
        c();
        b0.a(collection);
        if (!(collection instanceof x)) {
            return super.addAll(collection);
        }
        x xVar = (x) collection;
        int i5 = xVar.f3804g;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f3804g;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            float[] fArr = this.f3803f;
            if (i7 > fArr.length) {
                this.f3803f = Arrays.copyOf(fArr, i7);
            }
            System.arraycopy(xVar.f3803f, 0, this.f3803f, this.f3804g, xVar.f3804g);
            this.f3804g = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: e */
    public void add(int i5, Float f5) {
        l(i5, f5.floatValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return super.equals(obj);
        }
        x xVar = (x) obj;
        if (this.f3804g != xVar.f3804g) {
            return false;
        }
        float[] fArr = xVar.f3803f;
        for (int i5 = 0; i5 < this.f3804g; i5++) {
            if (Float.floatToIntBits(this.f3803f[i5]) != Float.floatToIntBits(fArr[i5])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Float f5) {
        i(f5.floatValue());
        return true;
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f3804g; i6++) {
            i5 = (i5 * 31) + Float.floatToIntBits(this.f3803f[i6]);
        }
        return i5;
    }

    public void i(float f5) {
        c();
        int i5 = this.f3804g;
        float[] fArr = this.f3803f;
        if (i5 == fArr.length) {
            float[] fArr2 = new float[(((i5 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            this.f3803f = fArr2;
        }
        float[] fArr3 = this.f3803f;
        int i6 = this.f3804g;
        this.f3804g = i6 + 1;
        fArr3[i6] = f5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f3803f[i5] == floatValue) {
                return i5;
            }
        }
        return -1;
    }

    /* renamed from: o */
    public Float get(int i5) {
        return Float.valueOf(p(i5));
    }

    public float p(int i5) {
        n(i5);
        return this.f3803f[i5];
    }

    /* renamed from: r */
    public Float remove(int i5) {
        c();
        n(i5);
        float[] fArr = this.f3803f;
        float f5 = fArr[i5];
        int i6 = this.f3804g;
        if (i5 < i6 - 1) {
            System.arraycopy(fArr, i5 + 1, fArr, i5, (i6 - i5) - 1);
        }
        this.f3804g--;
        this.modCount++;
        return Float.valueOf(f5);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        c();
        if (i6 >= i5) {
            float[] fArr = this.f3803f;
            System.arraycopy(fArr, i6, fArr, i5, this.f3804g - i6);
            this.f3804g -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    /* renamed from: s */
    public Float set(int i5, Float f5) {
        return Float.valueOf(t(i5, f5.floatValue()));
    }

    public int size() {
        return this.f3804g;
    }

    public float t(int i5, float f5) {
        c();
        n(i5);
        float[] fArr = this.f3803f;
        float f6 = fArr[i5];
        fArr[i5] = f5;
        return f6;
    }
}
