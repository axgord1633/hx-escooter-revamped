package i1;

import w0.p;

public final class q {
    public static int a(int i5) {
        boolean z4;
        if (!(i5 == 100 || i5 == 102 || i5 == 104)) {
            if (i5 == 105) {
                i5 = 105;
            } else {
                z4 = false;
                p.c(z4, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i5));
                return i5;
            }
        }
        z4 = true;
        p.c(z4, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i5));
        return i5;
    }

    public static String b(int i5) {
        if (i5 == 100) {
            return "HIGH_ACCURACY";
        }
        if (i5 == 102) {
            return "BALANCED_POWER_ACCURACY";
        }
        if (i5 == 104) {
            return "LOW_POWER";
        }
        if (i5 == 105) {
            return "PASSIVE";
        }
        throw new IllegalArgumentException();
    }
}
