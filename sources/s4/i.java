package s4;

import java.util.concurrent.TimeUnit;

public class i extends t {

    /* renamed from: e  reason: collision with root package name */
    private t f6767e;

    public i(t tVar) {
        if (tVar != null) {
            this.f6767e = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public t a() {
        return this.f6767e.a();
    }

    public t b() {
        return this.f6767e.b();
    }

    public long c() {
        return this.f6767e.c();
    }

    public t d(long j5) {
        return this.f6767e.d(j5);
    }

    public boolean e() {
        return this.f6767e.e();
    }

    public void f() {
        this.f6767e.f();
    }

    public t g(long j5, TimeUnit timeUnit) {
        return this.f6767e.g(j5, timeUnit);
    }

    public final t i() {
        return this.f6767e;
    }

    public final i j(t tVar) {
        if (tVar != null) {
            this.f6767e = tVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }
}
