package m4;

import j4.c;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f5908a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5909b;

    /* renamed from: c  reason: collision with root package name */
    private static final DateFormat[] f5910c;

    class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(c.f5490p);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f5909b = strArr;
        f5910c = new DateFormat[strArr.length];
    }

    public static String a(Date date) {
        return f5908a.get().format(date);
    }

    public static Date b(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f5908a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = f5909b;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                DateFormat[] dateFormatArr = f5910c;
                DateFormat dateFormat = dateFormatArr[i5];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f5909b[i5], Locale.US);
                    dateFormat.setTimeZone(c.f5490p);
                    dateFormatArr[i5] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }
}
