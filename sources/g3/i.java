package g3;

public final class i<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f4752a;

    /* renamed from: b  reason: collision with root package name */
    int f4753b;

    /* renamed from: c  reason: collision with root package name */
    int f4754c;

    /* renamed from: d  reason: collision with root package name */
    int f4755d;

    /* renamed from: e  reason: collision with root package name */
    T[] f4756e;

    public i() {
        this(16, 0.75f);
    }

    public i(int i5, float f5) {
        this.f4752a = f5;
        int a5 = j.a(i5);
        this.f4753b = a5 - 1;
        this.f4755d = (int) (f5 * ((float) a5));
        this.f4756e = new Object[a5];
    }

    static int c(int i5) {
        int i6 = i5 * -1640531527;
        return i6 ^ (i6 >>> 16);
    }

    public boolean a(T t5) {
        T t6;
        T[] tArr = this.f4756e;
        int i5 = this.f4753b;
        int c5 = c(t5.hashCode()) & i5;
        T t7 = tArr[c5];
        if (t7 != null) {
            if (t7.equals(t5)) {
                return false;
            }
            do {
                c5 = (c5 + 1) & i5;
                t6 = tArr[c5];
                if (t6 == null) {
                }
            } while (!t6.equals(t5));
            return false;
        }
        tArr[c5] = t5;
        int i6 = this.f4754c + 1;
        this.f4754c = i6;
        if (i6 >= this.f4755d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f4756e;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        T t5;
        T[] tArr = this.f4756e;
        int length = tArr.length;
        int i5 = length << 1;
        int i6 = i5 - 1;
        T[] tArr2 = new Object[i5];
        int i7 = this.f4754c;
        while (true) {
            int i8 = i7 - 1;
            if (i7 != 0) {
                do {
                    length--;
                    t5 = tArr[length];
                } while (t5 == null);
                int c5 = c(t5.hashCode()) & i6;
                if (tArr2[c5] != null) {
                    do {
                        c5 = (c5 + 1) & i6;
                    } while (tArr2[c5] != null);
                }
                tArr2[c5] = tArr[length];
                i7 = i8;
            } else {
                this.f4753b = i6;
                this.f4755d = (int) (((float) i5) * this.f4752a);
                this.f4756e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t5) {
        T t6;
        T[] tArr = this.f4756e;
        int i5 = this.f4753b;
        int c5 = c(t5.hashCode()) & i5;
        T t7 = tArr[c5];
        if (t7 == null) {
            return false;
        }
        if (t7.equals(t5)) {
            return f(c5, tArr, i5);
        }
        do {
            c5 = (c5 + 1) & i5;
            t6 = tArr[c5];
            if (t6 == null) {
                return false;
            }
        } while (!t6.equals(t5));
        return f(c5, tArr, i5);
    }

    /* access modifiers changed from: package-private */
    public boolean f(int i5, T[] tArr, int i6) {
        int i7;
        T t5;
        this.f4754c--;
        while (true) {
            int i8 = i5 + 1;
            while (true) {
                i7 = i8 & i6;
                t5 = tArr[i7];
                if (t5 == null) {
                    tArr[i5] = null;
                    return true;
                }
                int c5 = c(t5.hashCode()) & i6;
                if (i5 <= i7) {
                    if (i5 >= c5 || c5 > i7) {
                        break;
                    }
                    i8 = i7 + 1;
                } else {
                    if (i5 >= c5 && c5 > i7) {
                        break;
                    }
                    i8 = i7 + 1;
                }
            }
            tArr[i5] = t5;
            i5 = i7;
        }
    }
}
