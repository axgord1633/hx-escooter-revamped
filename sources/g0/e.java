package g0;

public final class e {
    public static <T> void a(T t5, Class<T> cls) {
        if (t5 == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T b(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T c(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static <T> T d(T t5) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
