package kotlinx.coroutines.internal;

public final class l {
    public static final void a(int i5) {
        boolean z4 = true;
        if (i5 < 1) {
            z4 = false;
        }
        if (!z4) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i5).toString());
        }
    }
}
