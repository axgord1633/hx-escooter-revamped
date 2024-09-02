package io.flutter.util;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static void checkState(boolean z4) {
        if (!z4) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
