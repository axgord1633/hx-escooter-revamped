package g1;

final class t0 extends s0 {

    /* renamed from: i  reason: collision with root package name */
    static final s0 f4721i = new t0(new Object[0], 0);

    /* renamed from: g  reason: collision with root package name */
    final transient Object[] f4722g;

    /* renamed from: h  reason: collision with root package name */
    private final transient int f4723h;

    t0(Object[] objArr, int i5) {
        this.f4722g = objArr;
        this.f4723h = i5;
    }

    /* access modifiers changed from: package-private */
    public final int c(Object[] objArr, int i5) {
        System.arraycopy(this.f4722g, 0, objArr, 0, this.f4723h);
        return this.f4723h;
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.f4723h;
    }

    /* access modifiers changed from: package-private */
    public final int f() {
        return 0;
    }

    public final Object get(int i5) {
        m0.a(i5, this.f4723h, "index");
        Object obj = this.f4722g[i5];
        obj.getClass();
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final boolean m() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object[] n() {
        return this.f4722g;
    }

    public final int size() {
        return this.f4723h;
    }
}
