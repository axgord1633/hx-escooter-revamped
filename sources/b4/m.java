package b4;

import kotlin.jvm.internal.k;

class m extends l {
    public static final boolean h(String str, String str2, boolean z4) {
        k.e(str, "<this>");
        k.e(str2, "suffix");
        if (!z4) {
            return str.endsWith(str2);
        }
        return k(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean i(String str, String str2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return h(str, str2, z4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean j(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.k.e(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x003e
            y3.c r0 = b4.n.t(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0020
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0020
        L_0x001e:
            r4 = r2
            goto L_0x003c
        L_0x0020:
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x001e
            r3 = r0
            n3.a0 r3 = (n3.a0) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = b4.a.c(r3)
            if (r3 != 0) goto L_0x0024
            r4 = r1
        L_0x003c:
            if (r4 == 0) goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.m.j(java.lang.CharSequence):boolean");
    }

    public static final boolean k(String str, int i5, String str2, int i6, int i7, boolean z4) {
        k.e(str, "<this>");
        k.e(str2, "other");
        return !z4 ? str.regionMatches(i5, str2, i6, i7) : str.regionMatches(z4, i5, str2, i6, i7);
    }

    public static final String l(String str, String str2, String str3, boolean z4) {
        k.e(str, "<this>");
        k.e(str2, "oldValue");
        k.e(str3, "newValue");
        int i5 = 0;
        int w4 = n.w(str, str2, 0, z4);
        if (w4 < 0) {
            return str;
        }
        int length = str2.length();
        int a5 = f.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i5, w4);
                sb.append(str3);
                i5 = w4 + length;
                if (w4 >= str.length() || (w4 = n.w(str, str2, w4 + a5, z4)) <= 0) {
                    sb.append(str, i5, str.length());
                    String sb2 = sb.toString();
                    k.d(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(str, i5, w4);
                sb.append(str3);
                i5 = w4 + length;
                break;
            } while ((w4 = n.w(str, str2, w4 + a5, z4)) <= 0);
            sb.append(str, i5, str.length());
            String sb22 = sb.toString();
            k.d(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String m(String str, String str2, String str3, boolean z4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return l(str, str2, str3, z4);
    }

    public static final boolean n(String str, String str2, boolean z4) {
        k.e(str, "<this>");
        k.e(str2, "prefix");
        if (!z4) {
            return str.startsWith(str2);
        }
        return k(str, 0, str2, 0, str2.length(), z4);
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return n(str, str2, z4);
    }
}
