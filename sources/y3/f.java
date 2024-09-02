package y3;

class f extends e {
    public static int a(int i5, int i6) {
        return i5 < i6 ? i6 : i5;
    }

    public static long b(long j5, long j6) {
        return j5 < j6 ? j6 : j5;
    }

    public static int c(int i5, int i6) {
        return i5 > i6 ? i6 : i5;
    }

    public static long d(long j5, long j6) {
        return j5 > j6 ? j6 : j5;
    }

    public static int e(int i5, int i6, int i7) {
        if (i6 <= i7) {
            return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i7 + " is less than minimum " + i6 + '.');
    }

    public static a f(int i5, int i6) {
        return a.f7824h.a(i5, i6, -1);
    }

    public static c g(int i5, int i6) {
        return i6 <= Integer.MIN_VALUE ? c.f7832i.a() : new c(i5, i6 - 1);
    }
}
