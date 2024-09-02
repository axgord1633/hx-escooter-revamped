package j4;

public abstract class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    protected final String f5474e;

    public b(String str, Object... objArr) {
        this.f5474e = c.p(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void k();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f5474e);
        try {
            k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
