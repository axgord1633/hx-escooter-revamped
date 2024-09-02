package j;

import java.util.concurrent.Executor;

public class c extends f {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f5417c;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f5418d = new a();

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f5419e = new b();

    /* renamed from: a  reason: collision with root package name */
    private f f5420a;

    /* renamed from: b  reason: collision with root package name */
    private final f f5421b;

    private c() {
        d dVar = new d();
        this.f5421b = dVar;
        this.f5420a = dVar;
    }

    public static c f() {
        if (f5417c != null) {
            return f5417c;
        }
        synchronized (c.class) {
            if (f5417c == null) {
                f5417c = new c();
            }
        }
        return f5417c;
    }

    public void a(Runnable runnable) {
        this.f5420a.a(runnable);
    }

    public boolean b() {
        return this.f5420a.b();
    }

    public void c(Runnable runnable) {
        this.f5420a.c(runnable);
    }
}
