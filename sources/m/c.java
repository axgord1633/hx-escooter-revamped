package m;

class c {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f5830a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    static final long[] f5831b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    static final Object[] f5832c = new Object[0];

    static int a(int[] iArr, int i5, int i6) {
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else if (i10 <= i6) {
                return i9;
            } else {
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    static int b(long[] jArr, int i5, long j5) {
        int i6 = i5 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            int i9 = (jArr[i8] > j5 ? 1 : (jArr[i8] == j5 ? 0 : -1));
            if (i9 < 0) {
                i7 = i8 + 1;
            } else if (i9 <= 0) {
                return i8;
            } else {
                i6 = i8 - 1;
            }
        }
        return ~i7;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int d(int i5) {
        for (int i6 = 4; i6 < 32; i6++) {
            int i7 = (1 << i6) - 12;
            if (i5 <= i7) {
                return i7;
            }
        }
        return i5;
    }

    public static int e(int i5) {
        return d(i5 * 4) / 4;
    }

    public static int f(int i5) {
        return d(i5 * 8) / 8;
    }
}
