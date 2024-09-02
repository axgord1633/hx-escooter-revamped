package s4;

public abstract class g implements r {

    /* renamed from: e  reason: collision with root package name */
    private final r f6765e;

    public g(r rVar) {
        if (rVar != null) {
            this.f6765e = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void G(c cVar, long j5) {
        this.f6765e.G(cVar, j5);
    }

    public t c() {
        return this.f6765e.c();
    }

    public void close() {
        this.f6765e.close();
    }

    public void flush() {
        this.f6765e.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f6765e.toString() + ")";
    }
}
