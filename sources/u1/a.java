package u1;

import p1.c0;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f7093a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7094b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7095c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f7096d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7097e;

    /* renamed from: f  reason: collision with root package name */
    public final c0.b f7098f;

    public a(int i5, int i6, int i7, boolean z4, boolean z5, c0.b bVar) {
        this.f7093a = i5;
        this.f7094b = i6;
        this.f7095c = i7;
        this.f7096d = z4;
        this.f7097e = z5;
        this.f7098f = bVar;
    }

    public a a(c0 c0Var) {
        return new a(c0Var.a() != null ? c0Var.a().intValue() : this.f7093a, c0Var.c() != null ? c0Var.c().intValue() : this.f7094b, c0Var.f() != null ? c0Var.f().intValue() : this.f7095c, c0Var.d() != null ? c0Var.d().booleanValue() : this.f7096d, c0Var.e() != null ? c0Var.e().booleanValue() : this.f7097e, c0Var.b() != null ? c0Var.b() : this.f7098f);
    }

    public String toString() {
        return "LoggerSetup{logLevel=" + this.f7093a + ", macAddressLogSetting=" + this.f7094b + ", uuidLogSetting=" + this.f7095c + ", shouldLogAttributeValues=" + this.f7096d + ", shouldLogScannedPeripherals=" + this.f7097e + ", logger=" + this.f7098f + '}';
    }
}
