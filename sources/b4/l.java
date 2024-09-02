package b4;

import kotlin.jvm.internal.k;

class l extends k {
    public static Long f(String str) {
        k.e(str, "<this>");
        return g(str, 10);
    }

    public static final Long g(String str, int i5) {
        String str2 = str;
        int i6 = i5;
        k.e(str2, "<this>");
        a.a(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char charAt = str2.charAt(0);
        long j5 = -9223372036854775807L;
        boolean z4 = true;
        if (k.f(charAt, 48) >= 0) {
            z4 = false;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                j5 = Long.MIN_VALUE;
                i7 = 1;
            } else if (charAt != '+') {
                return null;
            } else {
                z4 = false;
                i7 = 1;
            }
        }
        long j6 = -256204778801521550L;
        long j7 = 0;
        long j8 = -256204778801521550L;
        while (i7 < length) {
            int b5 = a.b(str2.charAt(i7), i6);
            if (b5 < 0) {
                return null;
            }
            if (j7 < j8) {
                if (j8 == j6) {
                    j8 = j5 / ((long) i6);
                    if (j7 < j8) {
                    }
                }
                return null;
            }
            long j9 = j7 * ((long) i6);
            long j10 = (long) b5;
            if (j9 < j5 + j10) {
                return null;
            }
            j7 = j9 - j10;
            i7++;
            j6 = -256204778801521550L;
        }
        return z4 ? Long.valueOf(j7) : Long.valueOf(-j7);
    }
}
