package q3;

public final class c {
    private static final int a(int i5, int i6, int i7) {
        return c(c(i5, i7) - c(i6, i7), i7);
    }

    public static final int b(int i5, int i6, int i7) {
        if (i7 > 0) {
            return i5 >= i6 ? i6 : i6 - a(i6, i5, i7);
        }
        if (i7 < 0) {
            return i5 <= i6 ? i6 : i6 + a(i5, i6, -i7);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int c(int i5, int i6) {
        int i7 = i5 % i6;
        return i7 >= 0 ? i7 : i7 + i6;
    }
}
