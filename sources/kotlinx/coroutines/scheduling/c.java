package kotlinx.coroutines.scheduling;

public final class c extends f {

    /* renamed from: m  reason: collision with root package name */
    public static final c f5670m = new c();

    private c() {
        super(l.f5682b, l.f5683c, l.f5684d, "DefaultDispatcher");
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
