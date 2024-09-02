package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1773a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1774b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f1775c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f1776d;

    /* renamed from: androidx.core.os.a$a  reason: collision with other inner class name */
    private static final class C0027a {

        /* renamed from: a  reason: collision with root package name */
        static final int f1777a = SdkExtensions.getExtensionVersion(30);

        /* renamed from: b  reason: collision with root package name */
        static final int f1778b = SdkExtensions.getExtensionVersion(31);

        /* renamed from: c  reason: collision with root package name */
        static final int f1779c = SdkExtensions.getExtensionVersion(33);

        /* renamed from: d  reason: collision with root package name */
        static final int f1780d = SdkExtensions.getExtensionVersion(1000000);
    }

    static {
        int i5 = Build.VERSION.SDK_INT;
        int i6 = 0;
        f1773a = i5 >= 30 ? C0027a.f1777a : 0;
        f1774b = i5 >= 30 ? C0027a.f1778b : 0;
        f1775c = i5 >= 30 ? C0027a.f1779c : 0;
        if (i5 >= 30) {
            i6 = C0027a.f1780d;
        }
        f1776d = i6;
    }

    protected static boolean a(String str, String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0;
    }

    @Deprecated
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean c() {
        int i5 = Build.VERSION.SDK_INT;
        return i5 >= 33 || (i5 >= 32 && a("Tiramisu", Build.VERSION.CODENAME));
    }
}
