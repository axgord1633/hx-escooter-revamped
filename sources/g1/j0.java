package g1;

import java.text.SimpleDateFormat;
import java.util.Locale;

public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f4697a;

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f4698b;

    /* renamed from: c  reason: collision with root package name */
    private static final StringBuilder f4699c = new StringBuilder(33);

    static {
        Locale locale = Locale.ROOT;
        f4697a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        f4698b = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
    }

    public static String a(long j5) {
        String sb;
        StringBuilder sb2 = f4699c;
        synchronized (sb2) {
            sb2.setLength(0);
            b(j5, sb2);
            sb = sb2.toString();
        }
        return sb;
    }

    public static void b(long j5, StringBuilder sb) {
        String str;
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 == 0) {
            str = "0s";
        } else {
            sb.ensureCapacity(sb.length() + 27);
            boolean z4 = false;
            if (i5 < 0) {
                sb.append("-");
                if (j5 != Long.MIN_VALUE) {
                    j5 = -j5;
                } else {
                    j5 = Long.MAX_VALUE;
                    z4 = true;
                }
            }
            if (j5 >= 86400000) {
                sb.append(j5 / 86400000);
                sb.append("d");
                j5 %= 86400000;
            }
            if (true == z4) {
                j5 = 25975808;
            }
            if (j5 >= 3600000) {
                sb.append(j5 / 3600000);
                sb.append("h");
                j5 %= 3600000;
            }
            if (j5 >= 60000) {
                sb.append(j5 / 60000);
                sb.append("m");
                j5 %= 60000;
            }
            if (j5 >= 1000) {
                sb.append(j5 / 1000);
                sb.append("s");
                j5 %= 1000;
            }
            if (j5 > 0) {
                sb.append(j5);
                str = "ms";
            } else {
                return;
            }
        }
        sb.append(str);
    }
}
