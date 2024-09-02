package androidx.core.os;

import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

final class i implements j {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f1790c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f1791d = new Locale("en", "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f1792e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f1793f = h.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f1794a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1795b;

    i(Locale... localeArr) {
        String sb;
        if (localeArr.length == 0) {
            this.f1794a = f1790c;
            sb = BuildConfig.FLAVOR;
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            int i5 = 0;
            while (i5 < localeArr.length) {
                Locale locale = localeArr[i5];
                if (locale != null) {
                    if (!hashSet.contains(locale)) {
                        Locale locale2 = (Locale) locale.clone();
                        arrayList.add(locale2);
                        b(sb2, locale2);
                        if (i5 < localeArr.length - 1) {
                            sb2.append(',');
                        }
                        hashSet.add(locale2);
                    }
                    i5++;
                } else {
                    throw new NullPointerException("list[" + i5 + "] is null");
                }
            }
            this.f1794a = (Locale[]) arrayList.toArray(new Locale[0]);
            sb = sb2.toString();
        }
        this.f1795b = sb;
    }

    static void b(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        Locale[] localeArr = ((i) obj).f1794a;
        if (this.f1794a.length != localeArr.length) {
            return false;
        }
        int i5 = 0;
        while (true) {
            Locale[] localeArr2 = this.f1794a;
            if (i5 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i5].equals(localeArr[i5])) {
                return false;
            }
            i5++;
        }
    }

    public Locale get(int i5) {
        if (i5 >= 0) {
            Locale[] localeArr = this.f1794a;
            if (i5 < localeArr.length) {
                return localeArr[i5];
            }
        }
        return null;
    }

    public int hashCode() {
        int i5 = 1;
        for (Locale hashCode : this.f1794a) {
            i5 = (i5 * 31) + hashCode.hashCode();
        }
        return i5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i5 = 0;
        while (true) {
            Locale[] localeArr = this.f1794a;
            if (i5 < localeArr.length) {
                sb.append(localeArr[i5]);
                if (i5 < this.f1794a.length - 1) {
                    sb.append(',');
                }
                i5++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
