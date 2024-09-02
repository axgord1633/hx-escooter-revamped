package c4;

public final class c2 {

    /* renamed from: a  reason: collision with root package name */
    public static final c2 f3110a = new c2();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<w0> f3111b = new ThreadLocal<>();

    private c2() {
    }

    public final w0 a() {
        ThreadLocal<w0> threadLocal = f3111b;
        w0 w0Var = threadLocal.get();
        if (w0Var != null) {
            return w0Var;
        }
        w0 a5 = z0.a();
        threadLocal.set(a5);
        return a5;
    }

    public final void b() {
        f3111b.set((Object) null);
    }

    public final void c(w0 w0Var) {
        f3111b.set(w0Var);
    }
}
