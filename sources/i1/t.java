package i1;

import w0.p;

public final class t {
    public static int a(int i5) {
        boolean z4;
        if (!(i5 == 0 || i5 == 1)) {
            if (i5 == 2) {
                i5 = 2;
            } else {
                z4 = false;
                p.c(z4, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i5));
                return i5;
            }
        }
        z4 = true;
        p.c(z4, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i5));
        return i5;
    }

    public static String b(int i5) {
        if (i5 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i5 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i5 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }
}
