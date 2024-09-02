package kotlinx.coroutines.internal;

final /* synthetic */ class e0 {
    public static final int a(String str, int i5, int i6, int i7) {
        return (int) c0.c(str, (long) i5, (long) i6, (long) i7);
    }

    public static final long b(String str, long j5, long j6, long j7) {
        String d5 = c0.d(str);
        if (d5 == null) {
            return j5;
        }
        Long f5 = l.f(d5);
        if (f5 != null) {
            long longValue = f5.longValue();
            boolean z4 = false;
            if (j6 <= longValue && longValue <= j7) {
                z4 = true;
            }
            if (z4) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j6 + ".." + j7 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d5 + '\'').toString());
    }

    public static final boolean c(String str, boolean z4) {
        String d5 = c0.d(str);
        return d5 != null ? Boolean.parseBoolean(d5) : z4;
    }

    public static /* synthetic */ int d(String str, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i6 = 1;
        }
        if ((i8 & 8) != 0) {
            i7 = Integer.MAX_VALUE;
        }
        return c0.b(str, i5, i6, i7);
    }

    public static /* synthetic */ long e(String str, long j5, long j6, long j7, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            j6 = 1;
        }
        long j8 = j6;
        if ((i5 & 8) != 0) {
            j7 = Long.MAX_VALUE;
        }
        return c0.c(str, j5, j8, j7);
    }
}
