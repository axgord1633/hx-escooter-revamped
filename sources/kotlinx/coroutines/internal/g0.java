package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.internal.h0;

public class g0<T extends h0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    private T[] f5601a;

    private final T[] f() {
        T[] tArr = this.f5601a;
        if (tArr == null) {
            T[] tArr2 = new h0[4];
            this.f5601a = tArr2;
            return tArr2;
        } else if (c() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, c() * 2);
            k.d(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (h0[]) copyOf;
            this.f5601a = tArr3;
            return tArr3;
        }
    }

    private final void j(int i5) {
        this._size = i5;
    }

    private final void k(int i5) {
        while (true) {
            int i6 = (i5 * 2) + 1;
            if (i6 < c()) {
                T[] tArr = this.f5601a;
                k.b(tArr);
                int i7 = i6 + 1;
                if (i7 < c()) {
                    T t5 = tArr[i7];
                    k.b(t5);
                    T t6 = tArr[i6];
                    k.b(t6);
                    if (((Comparable) t5).compareTo(t6) < 0) {
                        i6 = i7;
                    }
                }
                T t7 = tArr[i5];
                k.b(t7);
                T t8 = tArr[i6];
                k.b(t8);
                if (((Comparable) t7).compareTo(t8) > 0) {
                    m(i5, i6);
                    i5 = i6;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final void l(int i5) {
        while (i5 > 0) {
            T[] tArr = this.f5601a;
            k.b(tArr);
            int i6 = (i5 - 1) / 2;
            T t5 = tArr[i6];
            k.b(t5);
            T t6 = tArr[i5];
            k.b(t6);
            if (((Comparable) t5).compareTo(t6) > 0) {
                m(i5, i6);
                i5 = i6;
            } else {
                return;
            }
        }
    }

    private final void m(int i5, int i6) {
        T[] tArr = this.f5601a;
        k.b(tArr);
        T t5 = tArr[i6];
        k.b(t5);
        T t6 = tArr[i5];
        k.b(t6);
        tArr[i5] = t5;
        tArr[i6] = t6;
        t5.setIndex(i5);
        t6.setIndex(i6);
    }

    public final void a(T t5) {
        t5.c(this);
        h0[] f5 = f();
        int c5 = c();
        j(c5 + 1);
        f5[c5] = t5;
        t5.setIndex(c5);
        l(c5);
    }

    public final T b() {
        T[] tArr = this.f5601a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b5;
        synchronized (this) {
            b5 = b();
        }
        return b5;
    }

    public final boolean g(T t5) {
        boolean z4;
        synchronized (this) {
            if (t5.i() == null) {
                z4 = false;
            } else {
                h(t5.getIndex());
                z4 = true;
            }
        }
        return z4;
    }

    public final T h(int i5) {
        T[] tArr = this.f5601a;
        k.b(tArr);
        j(c() - 1);
        if (i5 < c()) {
            m(i5, c());
            int i6 = (i5 - 1) / 2;
            if (i5 > 0) {
                T t5 = tArr[i5];
                k.b(t5);
                T t6 = tArr[i6];
                k.b(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    m(i5, i6);
                    l(i6);
                }
            }
            k(i5);
        }
        T t7 = tArr[c()];
        k.b(t7);
        t7.c((g0<?>) null);
        t7.setIndex(-1);
        tArr[c()] = null;
        return t7;
    }

    public final T i() {
        T h5;
        synchronized (this) {
            h5 = c() > 0 ? h(0) : null;
        }
        return h5;
    }
}
