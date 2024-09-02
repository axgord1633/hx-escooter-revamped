package q1;

import com.yalantis.ucrop.BuildConfig;
import java.util.Date;

public class m extends f {

    /* renamed from: e  reason: collision with root package name */
    private final int f6650e;

    /* renamed from: f  reason: collision with root package name */
    private final Date f6651f;

    public m(int i5) {
        super(a(i5, (Date) null));
        this.f6650e = i5;
        this.f6651f = null;
    }

    public m(int i5, Throwable th) {
        super(a(i5, (Date) null), th);
        this.f6650e = i5;
        this.f6651f = null;
    }

    public m(int i5, Date date) {
        super(a(i5, date));
        this.f6650e = i5;
        this.f6651f = date;
    }

    private static String a(int i5, Date date) {
        return b(i5) + " (code " + i5 + ")" + c(date);
    }

    private static String b(int i5) {
        if (i5 == 2147483646) {
            return "Undocumented scan throttle";
        }
        switch (i5) {
            case 0:
                return "Bluetooth cannot start";
            case 1:
                return "Bluetooth disabled";
            case 2:
                return "Bluetooth not available";
            case 3:
                return "Location Permission missing";
            case 4:
                return "Location Services disabled";
            case 5:
                return "Scan failed because it has already started";
            case 6:
                return "Scan failed because application registration failed";
            case 7:
                return "Scan failed because of an internal error";
            case 8:
                return "Scan failed because feature unsupported";
            case 9:
                return "Scan failed because out of hardware resources";
            default:
                return "Unknown error";
        }
    }

    private static String c(Date date) {
        if (date == null) {
            return BuildConfig.FLAVOR;
        }
        return ", suggested retry date is " + date;
    }
}
