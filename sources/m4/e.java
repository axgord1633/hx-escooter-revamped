package m4;

import i4.k;
import i4.l;
import i4.q;
import i4.r;
import i4.z;
import java.util.List;
import s4.f;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final f f5911a = f.o("\"\\");

    /* renamed from: b  reason: collision with root package name */
    private static final f f5912b = f.o("\t ,=");

    public static long a(q qVar) {
        return h(qVar.c("Content-Length"));
    }

    public static long b(z zVar) {
        return a(zVar.j());
    }

    public static boolean c(z zVar) {
        if (zVar.p().f().equals("HEAD")) {
            return false;
        }
        int e5 = zVar.e();
        return (((e5 >= 100 && e5 < 200) || e5 == 204 || e5 == 304) && b(zVar) == -1 && !"chunked".equalsIgnoreCase(zVar.g("Transfer-Encoding"))) ? false : true;
    }

    public static int d(String str, int i5) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i5;
        }
    }

    public static void e(l lVar, r rVar, q qVar) {
        if (lVar != l.f5121a) {
            List<k> f5 = k.f(rVar, qVar);
            if (!f5.isEmpty()) {
                lVar.a(rVar, f5);
            }
        }
    }

    public static int f(String str, int i5, String str2) {
        while (i5 < str.length() && str2.indexOf(str.charAt(i5)) == -1) {
            i5++;
        }
        return i5;
    }

    public static int g(String str, int i5) {
        while (i5 < str.length() && ((r0 = str.charAt(i5)) == ' ' || r0 == 9)) {
            i5++;
        }
        return i5;
    }

    private static long h(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
