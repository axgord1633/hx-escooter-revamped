package androidx.appcompat.widget;

class c1 {

    /* renamed from: a  reason: collision with root package name */
    private int f1172a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1173b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1174c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1175d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1176e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1177f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1178g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1179h = false;

    c1() {
    }

    public int a() {
        return this.f1178g ? this.f1172a : this.f1173b;
    }

    public int b() {
        return this.f1172a;
    }

    public int c() {
        return this.f1173b;
    }

    public int d() {
        return this.f1178g ? this.f1173b : this.f1172a;
    }

    public void e(int i5, int i6) {
        this.f1179h = false;
        if (i5 != Integer.MIN_VALUE) {
            this.f1176e = i5;
            this.f1172a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f1177f = i6;
            this.f1173b = i6;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.f1178g
            if (r2 != r0) goto L_0x0005
            return
        L_0x0005:
            r1.f1178g = r2
            boolean r0 = r1.f1179h
            if (r0 == 0) goto L_0x002b
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L_0x001d
            int r2 = r1.f1175d
            if (r2 == r0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            int r2 = r1.f1176e
        L_0x0016:
            r1.f1172a = r2
            int r2 = r1.f1174c
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x001d:
            int r2 = r1.f1174c
            if (r2 == r0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            int r2 = r1.f1176e
        L_0x0024:
            r1.f1172a = r2
            int r2 = r1.f1175d
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x002b:
            int r2 = r1.f1176e
            r1.f1172a = r2
        L_0x002f:
            int r2 = r1.f1177f
        L_0x0031:
            r1.f1173b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c1.f(boolean):void");
    }

    public void g(int i5, int i6) {
        this.f1174c = i5;
        this.f1175d = i6;
        this.f1179h = true;
        if (this.f1178g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f1172a = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.f1173b = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f1172a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f1173b = i6;
        }
    }
}
