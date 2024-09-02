package m;

public class h<E> implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f5868i = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f5869e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f5870f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f5871g;

    /* renamed from: h  reason: collision with root package name */
    private int f5872h;

    public h() {
        this(10);
    }

    public h(int i5) {
        this.f5869e = false;
        if (i5 == 0) {
            this.f5870f = c.f5830a;
            this.f5871g = c.f5832c;
            return;
        }
        int e5 = c.e(i5);
        this.f5870f = new int[e5];
        this.f5871g = new Object[e5];
    }

    private void d() {
        int i5 = this.f5872h;
        int[] iArr = this.f5870f;
        Object[] objArr = this.f5871g;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != f5868i) {
                if (i7 != i6) {
                    iArr[i6] = iArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        this.f5869e = false;
        this.f5872h = i6;
    }

    public void a(int i5, E e5) {
        int i6 = this.f5872h;
        if (i6 == 0 || i5 > this.f5870f[i6 - 1]) {
            if (this.f5869e && i6 >= this.f5870f.length) {
                d();
            }
            int i7 = this.f5872h;
            if (i7 >= this.f5870f.length) {
                int e6 = c.e(i7 + 1);
                int[] iArr = new int[e6];
                Object[] objArr = new Object[e6];
                int[] iArr2 = this.f5870f;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f5871g;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f5870f = iArr;
                this.f5871g = objArr;
            }
            this.f5870f[i7] = i5;
            this.f5871g[i7] = e5;
            this.f5872h = i7 + 1;
            return;
        }
        i(i5, e5);
    }

    public void b() {
        int i5 = this.f5872h;
        Object[] objArr = this.f5871g;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f5872h = 0;
        this.f5869e = false;
    }

    /* renamed from: c */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f5870f = (int[]) this.f5870f.clone();
            hVar.f5871g = (Object[]) this.f5871g.clone();
            return hVar;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public E f(int i5) {
        return g(i5, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.f5871g[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E g(int r3, E r4) {
        /*
            r2 = this;
            int[] r0 = r2.f5870f
            int r1 = r2.f5872h
            int r3 = m.c.a(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r0 = r2.f5871g
            r3 = r0[r3]
            java.lang.Object r0 = f5868i
            if (r3 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m.h.g(int, java.lang.Object):java.lang.Object");
    }

    public int h(int i5) {
        if (this.f5869e) {
            d();
        }
        return this.f5870f[i5];
    }

    public void i(int i5, E e5) {
        int a5 = c.a(this.f5870f, this.f5872h, i5);
        if (a5 >= 0) {
            this.f5871g[a5] = e5;
            return;
        }
        int i6 = ~a5;
        int i7 = this.f5872h;
        if (i6 < i7) {
            Object[] objArr = this.f5871g;
            if (objArr[i6] == f5868i) {
                this.f5870f[i6] = i5;
                objArr[i6] = e5;
                return;
            }
        }
        if (this.f5869e && i7 >= this.f5870f.length) {
            d();
            i6 = ~c.a(this.f5870f, this.f5872h, i5);
        }
        int i8 = this.f5872h;
        if (i8 >= this.f5870f.length) {
            int e6 = c.e(i8 + 1);
            int[] iArr = new int[e6];
            Object[] objArr2 = new Object[e6];
            int[] iArr2 = this.f5870f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f5871g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5870f = iArr;
            this.f5871g = objArr2;
        }
        int i9 = this.f5872h;
        if (i9 - i6 != 0) {
            int[] iArr3 = this.f5870f;
            int i10 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i10, i9 - i6);
            Object[] objArr4 = this.f5871g;
            System.arraycopy(objArr4, i6, objArr4, i10, this.f5872h - i6);
        }
        this.f5870f[i6] = i5;
        this.f5871g[i6] = e5;
        this.f5872h++;
    }

    public int j() {
        if (this.f5869e) {
            d();
        }
        return this.f5872h;
    }

    public E k(int i5) {
        if (this.f5869e) {
            d();
        }
        return this.f5871g[i5];
    }

    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5872h * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f5872h; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(h(i5));
            sb.append('=');
            Object k5 = k(i5);
            if (k5 != this) {
                sb.append(k5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
