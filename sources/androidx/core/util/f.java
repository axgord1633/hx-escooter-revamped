package androidx.core.util;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1846a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static char[] f1847b = new char[24];

    private static int a(int i5, int i6, boolean z4, int i7) {
        if (i5 > 99 || (z4 && i7 >= 3)) {
            return i6 + 3;
        }
        if (i5 > 9 || (z4 && i7 >= 2)) {
            return i6 + 2;
        }
        if (z4 || i5 > 0) {
            return i6 + 1;
        }
        return 0;
    }

    public static void b(long j5, StringBuilder sb) {
        synchronized (f1846a) {
            sb.append(f1847b, 0, c(j5, 0));
        }
    }

    private static int c(long j5, int i5) {
        char c5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j6 = j5;
        int i11 = i5;
        if (f1847b.length < i11) {
            f1847b = new char[i11];
        }
        char[] cArr = f1847b;
        int i12 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if (i12 == 0) {
            int i13 = i11 - 1;
            while (i13 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i12 > 0) {
            c5 = '+';
        } else {
            c5 = '-';
            j6 = -j6;
        }
        int i14 = (int) (j6 % 1000);
        int floor = (int) Math.floor((double) (j6 / 1000));
        if (floor > 86400) {
            i6 = floor / 86400;
            floor -= 86400 * i6;
        } else {
            i6 = 0;
        }
        if (floor > 3600) {
            i7 = floor / 3600;
            floor -= i7 * 3600;
        } else {
            i7 = 0;
        }
        if (floor > 60) {
            int i15 = floor / 60;
            i8 = floor - (i15 * 60);
            i9 = i15;
        } else {
            i8 = floor;
            i9 = 0;
        }
        if (i11 != 0) {
            int a5 = a(i6, 1, false, 0);
            int a6 = a5 + a(i7, 1, a5 > 0, 2);
            int a7 = a6 + a(i9, 1, a6 > 0, 2);
            int a8 = a7 + a(i8, 1, a7 > 0, 2);
            i10 = 0;
            for (int a9 = a8 + a(i14, 2, true, a8 > 0 ? 3 : 0) + 1; a9 < i11; a9++) {
                cArr[i10] = ' ';
                i10++;
            }
        } else {
            i10 = 0;
        }
        cArr[i10] = c5;
        int i16 = i10 + 1;
        boolean z4 = i11 != 0;
        int i17 = i16;
        int d5 = d(cArr, i6, 'd', i16, false, 0);
        int d6 = d(cArr, i7, 'h', d5, d5 != i17, z4 ? 2 : 0);
        int d7 = d(cArr, i9, 'm', d6, d6 != i17, z4 ? 2 : 0);
        int d8 = d(cArr, i8, 's', d7, d7 != i17, z4 ? 2 : 0);
        int d9 = d(cArr, i14, 'm', d8, true, (!z4 || d8 == i17) ? 0 : 3);
        cArr[d9] = 's';
        return d9 + 1;
    }

    private static int d(char[] cArr, int i5, char c5, int i6, boolean z4, int i7) {
        int i8;
        if (!z4 && i5 <= 0) {
            return i6;
        }
        if ((!z4 || i7 < 3) && i5 <= 99) {
            i8 = i6;
        } else {
            int i9 = i5 / 100;
            cArr[i6] = (char) (i9 + 48);
            i8 = i6 + 1;
            i5 -= i9 * 100;
        }
        if ((z4 && i7 >= 2) || i5 > 9 || i6 != i8) {
            int i10 = i5 / 10;
            cArr[i8] = (char) (i10 + 48);
            i8++;
            i5 -= i10 * 10;
        }
        cArr[i8] = (char) (i5 + 48);
        int i11 = i8 + 1;
        cArr[i11] = c5;
        return i11 + 1;
    }
}
