package g1;

public final class m0 {
    public static int a(int i5, int i6, String str) {
        String str2;
        if (i5 >= 0 && i5 < i6) {
            return i5;
        }
        if (i5 < 0) {
            str2 = n0.a("%s (%s) must not be negative", "index", Integer.valueOf(i5));
        } else if (i6 < 0) {
            throw new IllegalArgumentException("negative size: " + i6);
        } else {
            str2 = n0.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int b(int i5, int i6, String str) {
        if (i5 >= 0 && i5 <= i6) {
            return i5;
        }
        throw new IndexOutOfBoundsException(d(i5, i6, "index"));
    }

    public static void c(int i5, int i6, int i7) {
        String str;
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            if (i5 < 0 || i5 > i7) {
                str = d(i5, i7, "start index");
            } else if (i6 < 0 || i6 > i7) {
                str = d(i6, i7, "end index");
            } else {
                str = n0.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    private static String d(int i5, int i6, String str) {
        if (i5 < 0) {
            return n0.a("%s (%s) must not be negative", str, Integer.valueOf(i5));
        } else if (i6 >= 0) {
            return n0.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        } else {
            throw new IllegalArgumentException("negative size: " + i6);
        }
    }
}
