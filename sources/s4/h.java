package s4;

public abstract class h implements s {

    /* renamed from: e  reason: collision with root package name */
    private final s f6766e;

    public h(s sVar) {
        if (sVar != null) {
            this.f6766e = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final s b() {
        return this.f6766e;
    }

    public t c() {
        return this.f6766e.c();
    }

    public void close() {
        this.f6766e.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f6766e.toString() + ")";
    }
}
