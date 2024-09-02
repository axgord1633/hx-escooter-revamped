package y1;

public class b0 implements w {

    /* renamed from: a  reason: collision with root package name */
    private final l f7722a;

    /* renamed from: b  reason: collision with root package name */
    private final p f7723b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7724c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7725d;

    b0(l lVar, p pVar, boolean z4, boolean z5) {
        this.f7722a = lVar;
        this.f7723b = pVar;
        this.f7724c = z4;
        this.f7725d = z5;
    }

    private boolean c() {
        if (this.f7724c) {
            return false;
        }
        return !this.f7725d;
    }

    public boolean a() {
        return this.f7723b.a();
    }

    public boolean b() {
        return !c() || this.f7722a.a();
    }
}
