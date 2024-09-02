package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class f1<E> extends c<E> implements RandomAccess {

    /* renamed from: h  reason: collision with root package name */
    private static final f1<Object> f3520h;

    /* renamed from: f  reason: collision with root package name */
    private E[] f3521f;

    /* renamed from: g  reason: collision with root package name */
    private int f3522g;

    static {
        f1<Object> f1Var = new f1<>(new Object[0], 0);
        f3520h = f1Var;
        f1Var.b();
    }

    private f1(E[] eArr, int i5) {
        this.f3521f = eArr;
        this.f3522g = i5;
    }

    private static <E> E[] e(int i5) {
        return new Object[i5];
    }

    public static <E> f1<E> f() {
        return f3520h;
    }

    private void i(int i5) {
        if (i5 < 0 || i5 >= this.f3522g) {
            throw new IndexOutOfBoundsException(l(i5));
        }
    }

    private String l(int i5) {
        return "Index:" + i5 + ", Size:" + this.f3522g;
    }

    public void add(int i5, E e5) {
        int i6;
        c();
        if (i5 < 0 || i5 > (i6 = this.f3522g)) {
            throw new IndexOutOfBoundsException(l(i5));
        }
        E[] eArr = this.f3521f;
        if (i6 < eArr.length) {
            System.arraycopy(eArr, i5, eArr, i5 + 1, i6 - i5);
        } else {
            E[] e6 = e(((i6 * 3) / 2) + 1);
            System.arraycopy(this.f3521f, 0, e6, 0, i5);
            System.arraycopy(this.f3521f, i5, e6, i5 + 1, this.f3522g - i5);
            this.f3521f = e6;
        }
        this.f3521f[i5] = e5;
        this.f3522g++;
        this.modCount++;
    }

    public boolean add(E e5) {
        c();
        int i5 = this.f3522g;
        E[] eArr = this.f3521f;
        if (i5 == eArr.length) {
            this.f3521f = Arrays.copyOf(eArr, ((i5 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f3521f;
        int i6 = this.f3522g;
        this.f3522g = i6 + 1;
        eArr2[i6] = e5;
        this.modCount++;
        return true;
    }

    public E get(int i5) {
        i(i5);
        return this.f3521f[i5];
    }

    /* renamed from: m */
    public f1<E> a(int i5) {
        if (i5 >= this.f3522g) {
            return new f1<>(Arrays.copyOf(this.f3521f, i5), this.f3522g);
        }
        throw new IllegalArgumentException();
    }

    public E remove(int i5) {
        c();
        i(i5);
        E[] eArr = this.f3521f;
        E e5 = eArr[i5];
        int i6 = this.f3522g;
        if (i5 < i6 - 1) {
            System.arraycopy(eArr, i5 + 1, eArr, i5, (i6 - i5) - 1);
        }
        this.f3522g--;
        this.modCount++;
        return e5;
    }

    public E set(int i5, E e5) {
        c();
        i(i5);
        E[] eArr = this.f3521f;
        E e6 = eArr[i5];
        eArr[i5] = e5;
        this.modCount++;
        return e6;
    }

    public int size() {
        return this.f3522g;
    }
}
