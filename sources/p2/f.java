package p2;

final class f extends e<Runnable> {
    f(Runnable runnable) {
        super(runnable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + f() + ", " + get() + ")";
    }
}
