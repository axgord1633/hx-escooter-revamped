package androidx.core.util;

import java.util.Locale;

public final class d {
    public static void a(boolean z4, String str, Object... objArr) {
        if (!z4) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static float b(float f5, String str) {
        if (Float.isNaN(f5)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        } else if (!Float.isInfinite(f5)) {
            return f5;
        } else {
            throw new IllegalArgumentException(str + " must not be infinite");
        }
    }

    public static float c(float f5, float f6, float f7, String str) {
        if (f5 < f6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Float.valueOf(f6), Float.valueOf(f7)}));
        } else if (f5 <= f7) {
            return f5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Float.valueOf(f6), Float.valueOf(f7)}));
        }
    }

    public static int d(int i5, int i6, int i7, String str) {
        if (i5 < i6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i7)}));
        } else if (i5 <= i7) {
            return i5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i7)}));
        }
    }

    public static long e(long j5, long j6, long j7, String str) {
        if (j5 < j6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Long.valueOf(j6), Long.valueOf(j7)}));
        } else if (j5 <= j7) {
            return j5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Long.valueOf(j6), Long.valueOf(j7)}));
        }
    }

    public static int f(int i5) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException();
    }

    public static int g(int i5, int i6) {
        if ((i5 & i6) == i5) {
            return i5;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i5) + ", but only 0x" + Integer.toHexString(i6) + " are allowed");
    }

    public static <T> T h(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T i(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void j(boolean z4, String str) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }
}
