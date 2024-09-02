package y1;

public class z implements w {

    /* renamed from: a  reason: collision with root package name */
    private final l f7795a;

    /* renamed from: b  reason: collision with root package name */
    private final p f7796b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7797c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7798d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7799e;

    z(l lVar, p pVar, int i5, int i6, boolean z4) {
        this.f7795a = lVar;
        this.f7796b = pVar;
        this.f7798d = i5;
        this.f7799e = i6;
        this.f7797c = z4;
    }

    private boolean c() {
        return !this.f7797c && (this.f7799e >= 29 || this.f7798d >= 23);
    }

    public boolean a() {
        return this.f7796b.a();
    }

    public boolean b() {
        return !c() || this.f7795a.a();
    }
}
