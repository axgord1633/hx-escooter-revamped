package z1;

import p1.p0;
import u1.b;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final p0 f7873a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7874b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7875c;

    /* renamed from: d  reason: collision with root package name */
    private final c f7876d;

    /* renamed from: e  reason: collision with root package name */
    private final e f7877e;

    /* renamed from: f  reason: collision with root package name */
    private final b f7878f;

    public f(p0 p0Var, int i5, long j5, c cVar, e eVar, b bVar) {
        this.f7873a = p0Var;
        this.f7874b = i5;
        this.f7875c = j5;
        this.f7876d = cVar;
        this.f7877e = eVar;
        this.f7878f = bVar;
    }

    public p0 a() {
        return this.f7873a;
    }

    public int b() {
        return this.f7874b;
    }

    public e c() {
        return this.f7877e;
    }

    public b d() {
        return this.f7878f;
    }

    public String toString() {
        return "ScanResult{bleDevice=" + this.f7873a + ", rssi=" + this.f7874b + ", timestampNanos=" + this.f7875c + ", callbackType=" + this.f7876d + ", scanRecord=" + b.a(this.f7877e.c()) + ", isConnectable=" + this.f7878f + '}';
    }
}
