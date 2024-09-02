package m;

public class d<E> implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f5833i = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f5834e;

    /* renamed from: f  reason: collision with root package name */
    private long[] f5835f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f5836g;

    /* renamed from: h  reason: collision with root package name */
    private int f5837h;

    public d() {
        this(10);
    }

    public d(int i5) {
        this.f5834e = false;
        if (i5 == 0) {
            this.f5835f = c.f5831b;
            this.f5836g = c.f5832c;
            return;
        }
        int f5 = c.f(i5);
        this.f5835f = new long[f5];
        this.f5836g = new Object[f5];
    }

    private void d() {
        int i5 = this.f5837h;
        long[] jArr = this.f5835f;
        Object[] objArr = this.f5836g;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != f5833i) {
                if (i7 != i6) {
                    jArr[i6] = jArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        this.f5834e = false;
        this.f5837h = i6;
    }

    public void a(long j5, E e5) {
        int i5 = this.f5837h;
        if (i5 == 0 || j5 > this.f5835f[i5 - 1]) {
            if (this.f5834e && i5 >= this.f5835f.length) {
                d();
            }
            int i6 = this.f5837h;
            if (i6 >= this.f5835f.length) {
                int f5 = c.f(i6 + 1);
                long[] jArr = new long[f5];
                Object[] objArr = new Object[f5];
                long[] jArr2 = this.f5835f;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f5836g;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f5835f = jArr;
                this.f5836g = objArr;
            }
            this.f5835f[i6] = j5;
            this.f5836g[i6] = e5;
            this.f5837h = i6 + 1;
            return;
        }
        j(j5, e5);
    }

    public void b() {
        int i5 = this.f5837h;
        Object[] objArr = this.f5836g;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f5837h = 0;
        this.f5834e = false;
    }

    /* renamed from: c */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f5835f = (long[]) this.f5835f.clone();
            dVar.f5836g = (Object[]) this.f5836g.clone();
            return dVar;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public E f(long j5) {
        return g(j5, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.f5836g[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E g(long r3, E r5) {
        /*
            r2 = this;
            long[] r0 = r2.f5835f
            int r1 = r2.f5837h
            int r3 = m.c.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r4 = r2.f5836g
            r3 = r4[r3]
            java.lang.Object r4 = f5833i
            if (r3 != r4) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d.g(long, java.lang.Object):java.lang.Object");
    }

    public int h(long j5) {
        if (this.f5834e) {
            d();
        }
        return c.b(this.f5835f, this.f5837h, j5);
    }

    public long i(int i5) {
        if (this.f5834e) {
            d();
        }
        return this.f5835f[i5];
    }

    public void j(long j5, E e5) {
        int b5 = c.b(this.f5835f, this.f5837h, j5);
        if (b5 >= 0) {
            this.f5836g[b5] = e5;
            return;
        }
        int i5 = ~b5;
        int i6 = this.f5837h;
        if (i5 < i6) {
            Object[] objArr = this.f5836g;
            if (objArr[i5] == f5833i) {
                this.f5835f[i5] = j5;
                objArr[i5] = e5;
                return;
            }
        }
        if (this.f5834e && i6 >= this.f5835f.length) {
            d();
            i5 = ~c.b(this.f5835f, this.f5837h, j5);
        }
        int i7 = this.f5837h;
        if (i7 >= this.f5835f.length) {
            int f5 = c.f(i7 + 1);
            long[] jArr = new long[f5];
            Object[] objArr2 = new Object[f5];
            long[] jArr2 = this.f5835f;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f5836g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5835f = jArr;
            this.f5836g = objArr2;
        }
        int i8 = this.f5837h;
        if (i8 - i5 != 0) {
            long[] jArr3 = this.f5835f;
            int i9 = i5 + 1;
            System.arraycopy(jArr3, i5, jArr3, i9, i8 - i5);
            Object[] objArr4 = this.f5836g;
            System.arraycopy(objArr4, i5, objArr4, i9, this.f5837h - i5);
        }
        this.f5835f[i5] = j5;
        this.f5836g[i5] = e5;
        this.f5837h++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f5836g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f5835f
            int r1 = r2.f5837h
            int r3 = m.c.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f5836g
            r0 = r4[r3]
            java.lang.Object r1 = f5833i
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f5834e = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d.k(long):void");
    }

    public int l() {
        if (this.f5834e) {
            d();
        }
        return this.f5837h;
    }

    public E m(int i5) {
        if (this.f5834e) {
            d();
        }
        return this.f5836g[i5];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5837h * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f5837h; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(i(i5));
            sb.append('=');
            Object m5 = m(i5);
            if (m5 != this) {
                sb.append(m5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
