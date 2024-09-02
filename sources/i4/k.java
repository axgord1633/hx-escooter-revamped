package i4;

import j4.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import m4.d;

public final class k {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f5108j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f5109k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f5110l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f5111m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f5112a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5113b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5114c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5115d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5116e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5117f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5118g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5119h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f5120i;

    private k(String str, String str2, long j5, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f5112a = str;
        this.f5113b = str2;
        this.f5114c = j5;
        this.f5115d = str3;
        this.f5116e = str4;
        this.f5117f = z4;
        this.f5118g = z5;
        this.f5120i = z6;
        this.f5119h = z7;
    }

    private static int a(String str, int i5, int i6, boolean z4) {
        while (i5 < i6) {
            char charAt = str.charAt(i5);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z4)) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !c.H(str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static i4.k d(long r23, i4.r r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 0
            r3 = 59
            int r4 = j4.c.l(r0, r2, r1, r3)
            r5 = 61
            int r6 = j4.c.l(r0, r2, r4, r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = j4.c.G(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0135
            int r8 = j4.c.v(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002a
            goto L_0x0135
        L_0x002a:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = j4.c.G(r0, r6, r4)
            int r11 = j4.c.v(r6)
            if (r11 == r10) goto L_0x0037
            return r7
        L_0x0037:
            int r4 = r4 + r8
            r10 = -1
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r15 = r2
            r16 = r15
            r18 = r16
            r14 = r7
            r17 = r8
            r19 = r10
            r21 = r12
            r8 = r14
        L_0x004c:
            if (r4 >= r1) goto L_0x00ba
            int r7 = j4.c.l(r0, r4, r1, r3)
            int r3 = j4.c.l(r0, r4, r7, r5)
            java.lang.String r4 = j4.c.G(r0, r4, r3)
            if (r3 >= r7) goto L_0x0063
            int r3 = r3 + 1
            java.lang.String r3 = j4.c.G(r0, r3, r7)
            goto L_0x0065
        L_0x0063:
            java.lang.String r3 = ""
        L_0x0065:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0076
            int r4 = r3.length()     // Catch:{ IllegalArgumentException -> 0x00b2 }
            long r21 = h(r3, r2, r4)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            goto L_0x0082
        L_0x0076:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0085
            long r19 = i(r3)     // Catch:{  }
        L_0x0082:
            r18 = 1
            goto L_0x00b2
        L_0x0085:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0094
            java.lang.String r14 = g(r3)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            r17 = r2
            goto L_0x00b2
        L_0x0094:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x009e
            r8 = r3
            goto L_0x00b2
        L_0x009e:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a8
            r15 = 1
            goto L_0x00b2
        L_0x00a8:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b2
            r16 = 1
        L_0x00b2:
            int r4 = r7 + 1
            r3 = 59
            r5 = 61
            r7 = 0
            goto L_0x004c
        L_0x00ba:
            r0 = -9223372036854775808
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c2
        L_0x00c0:
            r11 = r0
            goto L_0x00e7
        L_0x00c2:
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00e5
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x00d4
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00d9
        L_0x00d4:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00d9:
            long r0 = r23 + r19
            int r3 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r3 < 0) goto L_0x00e3
            int r3 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c0
        L_0x00e3:
            r11 = r12
            goto L_0x00e7
        L_0x00e5:
            r11 = r21
        L_0x00e7:
            java.lang.String r0 = r25.l()
            if (r14 != 0) goto L_0x00f0
            r13 = r0
            r1 = 0
            goto L_0x00fa
        L_0x00f0:
            boolean r1 = b(r0, r14)
            if (r1 != 0) goto L_0x00f8
            r1 = 0
            return r1
        L_0x00f8:
            r1 = 0
            r13 = r14
        L_0x00fa:
            int r0 = r0.length()
            int r3 = r13.length()
            if (r0 == r3) goto L_0x010f
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.c()
            java.lang.String r0 = r0.d(r13)
            if (r0 != 0) goto L_0x010f
            return r1
        L_0x010f:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x011c
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r14 = r8
            goto L_0x012d
        L_0x011c:
            java.lang.String r1 = r25.g()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x012c
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x012c:
            r14 = r0
        L_0x012d:
            i4.k r0 = new i4.k
            r8 = r0
            r10 = r6
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x0135:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.k.d(long, i4.r, java.lang.String):i4.k");
    }

    @Nullable
    public static k e(r rVar, String str) {
        return d(System.currentTimeMillis(), rVar, str);
    }

    public static List<k> f(r rVar, q qVar) {
        List<String> i5 = qVar.i("Set-Cookie");
        int size = i5.size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            k e5 = e(rVar, i5.get(i6));
            if (e5 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e5);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static String g(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String c5 = c.c(str);
            if (c5 != null) {
                return c5;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long h(String str, int i5, int i6) {
        int a5 = a(str, i5, i6, false);
        Matcher matcher = f5111m.matcher(str);
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        while (a5 < i6) {
            int a6 = a(str, a5 + 1, i6, true);
            matcher.region(a5, a6);
            if (i8 == -1 && matcher.usePattern(f5111m).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
                i11 = Integer.parseInt(matcher.group(2));
                i12 = Integer.parseInt(matcher.group(3));
            } else if (i9 != -1 || !matcher.usePattern(f5110l).matches()) {
                if (i10 == -1) {
                    Pattern pattern = f5109k;
                    if (matcher.usePattern(pattern).matches()) {
                        i10 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i7 == -1 && matcher.usePattern(f5108j).matches()) {
                    i7 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i9 = Integer.parseInt(matcher.group(1));
            }
            a5 = a(str, a6 + 1, i6, false);
        }
        if (i7 >= 70 && i7 <= 99) {
            i7 += 1900;
        }
        if (i7 >= 0 && i7 <= 69) {
            i7 += 2000;
        }
        if (i7 < 1601) {
            throw new IllegalArgumentException();
        } else if (i10 == -1) {
            throw new IllegalArgumentException();
        } else if (i9 < 1 || i9 > 31) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 23) {
            throw new IllegalArgumentException();
        } else if (i11 < 0 || i11 > 59) {
            throw new IllegalArgumentException();
        } else if (i12 < 0 || i12 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(c.f5490p);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i7);
            gregorianCalendar.set(2, i10 - 1);
            gregorianCalendar.set(5, i9);
            gregorianCalendar.set(11, i8);
            gregorianCalendar.set(12, i11);
            gregorianCalendar.set(13, i12);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e5) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e5;
        }
    }

    public String c() {
        return this.f5112a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.f5112a.equals(this.f5112a) && kVar.f5113b.equals(this.f5113b) && kVar.f5115d.equals(this.f5115d) && kVar.f5116e.equals(this.f5116e) && kVar.f5114c == this.f5114c && kVar.f5117f == this.f5117f && kVar.f5118g == this.f5118g && kVar.f5119h == this.f5119h && kVar.f5120i == this.f5120i;
    }

    public int hashCode() {
        long j5 = this.f5114c;
        return ((((((((((((((((527 + this.f5112a.hashCode()) * 31) + this.f5113b.hashCode()) * 31) + this.f5115d.hashCode()) * 31) + this.f5116e.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.f5117f ^ true ? 1 : 0)) * 31) + (this.f5118g ^ true ? 1 : 0)) * 31) + (this.f5119h ^ true ? 1 : 0)) * 31) + (this.f5120i ^ true ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public String j(boolean z4) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5112a);
        sb.append('=');
        sb.append(this.f5113b);
        if (this.f5119h) {
            if (this.f5114c == Long.MIN_VALUE) {
                str = "; max-age=0";
            } else {
                sb.append("; expires=");
                str = d.a(new Date(this.f5114c));
            }
            sb.append(str);
        }
        if (!this.f5120i) {
            sb.append("; domain=");
            if (z4) {
                sb.append(".");
            }
            sb.append(this.f5115d);
        }
        sb.append("; path=");
        sb.append(this.f5116e);
        if (this.f5117f) {
            sb.append("; secure");
        }
        if (this.f5118g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.f5113b;
    }

    public String toString() {
        return j(false);
    }
}
