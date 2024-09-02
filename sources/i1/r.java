package i1;

public final class r {
    public static String a(int i5) {
        if (i5 == 0) {
            return "THROTTLE_BACKGROUND";
        }
        if (i5 == 1) {
            return "THROTTLE_ALWAYS";
        }
        if (i5 == 2) {
            return "THROTTLE_NEVER";
        }
        throw new IllegalArgumentException();
    }
}
