package i4;

import com.yalantis.ucrop.BuildConfig;
import j4.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class r {

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f5138j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f5139a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5140b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5141c;

    /* renamed from: d  reason: collision with root package name */
    final String f5142d;

    /* renamed from: e  reason: collision with root package name */
    final int f5143e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f5144f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f5145g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final String f5146h;

    /* renamed from: i  reason: collision with root package name */
    private final String f5147i;

    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        String f5148a;

        /* renamed from: b  reason: collision with root package name */
        String f5149b = BuildConfig.FLAVOR;

        /* renamed from: c  reason: collision with root package name */
        String f5150c = BuildConfig.FLAVOR;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        String f5151d;

        /* renamed from: e  reason: collision with root package name */
        int f5152e = -1;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f5153f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        List<String> f5154g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        String f5155h;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f5153f = arrayList;
            arrayList.add(BuildConfig.FLAVOR);
        }

        private static String b(String str, int i5, int i6) {
            return c.c(r.r(str, i5, i6, false));
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int i(String str, int i5, int i6) {
            try {
                int parseInt = Integer.parseInt(r.a(str, i5, i6, BuildConfig.FLAVOR, false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private void k() {
            List<String> list = this.f5153f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f5153f.isEmpty()) {
                this.f5153f.add(BuildConfig.FLAVOR);
                return;
            }
            List<String> list2 = this.f5153f;
            list2.set(list2.size() - 1, BuildConfig.FLAVOR);
        }

        private static int m(String str, int i5, int i6) {
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt == ':') {
                    return i5;
                }
                if (charAt == '[') {
                    do {
                        i5++;
                        if (i5 >= i6) {
                            break;
                        }
                    } while (str.charAt(i5) == ']');
                }
                i5++;
            }
            return i6;
        }

        private void n(String str, int i5, int i6, boolean z4, boolean z5) {
            String a5 = r.a(str, i5, i6, " \"<>^`{}|/\\?#", z5, false, false, true, (Charset) null);
            if (!f(a5)) {
                if (g(a5)) {
                    k();
                    return;
                }
                List<String> list = this.f5153f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f5153f;
                    list2.set(list2.size() - 1, a5);
                } else {
                    this.f5153f.add(a5);
                }
                if (z4) {
                    this.f5153f.add(BuildConfig.FLAVOR);
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void p(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f5153f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f5153f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f5153f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = j4.c.m(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0036
                r0 = r3
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.n(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i4.r.a.p(java.lang.String, int, int):void");
        }

        private static int r(String str, int i5, int i6) {
            if (i6 - i5 < 2) {
                return -1;
            }
            char charAt = str.charAt(i5);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i5++;
                    if (i5 >= i6) {
                        break;
                    }
                    char charAt2 = str.charAt(i5);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i5;
                        }
                    }
                }
            }
            return -1;
        }

        private static int s(String str, int i5, int i6) {
            int i7 = 0;
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i7++;
                i5++;
            }
            return i7;
        }

        public r a() {
            if (this.f5148a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f5151d != null) {
                return new r(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            int i5 = this.f5152e;
            return i5 != -1 ? i5 : r.d(this.f5148a);
        }

        public a d(@Nullable String str) {
            this.f5154g = str != null ? r.y(r.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a e(String str) {
            if (str != null) {
                String b5 = b(str, 0, str.length());
                if (b5 != null) {
                    this.f5151d = b5;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        public a h(@Nullable r rVar, String str) {
            int m5;
            int i5;
            r rVar2 = rVar;
            String str2 = str;
            int C = c.C(str2, 0, str.length());
            int D = c.D(str2, C, str.length());
            int r5 = r(str2, C, D);
            if (r5 != -1) {
                if (str.regionMatches(true, C, "https:", 0, 6)) {
                    this.f5148a = "https";
                    C += 6;
                } else if (str.regionMatches(true, C, "http:", 0, 5)) {
                    this.f5148a = "http";
                    C += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, r5) + "'");
                }
            } else if (rVar2 != null) {
                this.f5148a = rVar2.f5139a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int s5 = s(str2, C, D);
            char c5 = '?';
            char c6 = '#';
            if (s5 >= 2 || rVar2 == null || !rVar2.f5139a.equals(this.f5148a)) {
                boolean z4 = false;
                boolean z5 = false;
                int i6 = C + s5;
                while (true) {
                    m5 = c.m(str2, i6, D, "@/\\?#");
                    char charAt = m5 != D ? str2.charAt(m5) : 65535;
                    if (charAt == 65535 || charAt == c6 || charAt == '/' || charAt == '\\' || charAt == c5) {
                        int i7 = m5;
                        int m6 = m(str2, i6, i7);
                        int i8 = m6 + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z4) {
                                int l5 = c.l(str2, i6, m5, ':');
                                int i9 = l5;
                                String str3 = "%40";
                                i5 = m5;
                                String a5 = r.a(str, i6, l5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z5) {
                                    a5 = this.f5149b + str3 + a5;
                                }
                                this.f5149b = a5;
                                if (i9 != i5) {
                                    this.f5150c = r.a(str, i9 + 1, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z4 = true;
                                }
                                z5 = true;
                            } else {
                                i5 = m5;
                                this.f5150c += "%40" + r.a(str, i6, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            i6 = i5 + 1;
                        }
                        c5 = '?';
                        c6 = '#';
                    }
                }
                int i72 = m5;
                int m62 = m(str2, i6, i72);
                int i82 = m62 + 1;
                if (i82 < i72) {
                    this.f5151d = b(str2, i6, m62);
                    int i10 = i(str2, i82, i72);
                    this.f5152e = i10;
                    if (i10 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i82, i72) + '\"');
                    }
                } else {
                    this.f5151d = b(str2, i6, m62);
                    this.f5152e = r.d(this.f5148a);
                }
                if (this.f5151d != null) {
                    C = i72;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i6, m62) + '\"');
                }
            } else {
                this.f5149b = rVar.j();
                this.f5150c = rVar.f();
                this.f5151d = rVar2.f5142d;
                this.f5152e = rVar2.f5143e;
                this.f5153f.clear();
                this.f5153f.addAll(rVar.h());
                if (C == D || str2.charAt(C) == '#') {
                    d(rVar.i());
                }
            }
            int m7 = c.m(str2, C, D, "?#");
            p(str2, C, m7);
            if (m7 < D && str2.charAt(m7) == '?') {
                int l6 = c.l(str2, m7, D, '#');
                this.f5154g = r.y(r.a(str, m7 + 1, l6, " \"'<>#", true, false, true, true, (Charset) null));
                m7 = l6;
            }
            if (m7 < D && str2.charAt(m7) == '#') {
                this.f5155h = r.a(str, 1 + m7, D, BuildConfig.FLAVOR, true, false, false, false, (Charset) null);
            }
            return this;
        }

        public a j(String str) {
            if (str != null) {
                this.f5150c = r.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a l(int i5) {
            if (i5 <= 0 || i5 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i5);
            }
            this.f5152e = i5;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a o() {
            int size = this.f5153f.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f5153f.set(i5, r.b(this.f5153f.get(i5), "[]", true, true, false, true));
            }
            List<String> list = this.f5154g;
            if (list != null) {
                int size2 = list.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    String str = this.f5154g.get(i6);
                    if (str != null) {
                        this.f5154g.set(i6, r.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f5155h;
            if (str2 != null) {
                this.f5155h = r.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a q(String str) {
            if (str != null) {
                String str2 = "http";
                if (!str.equalsIgnoreCase(str2)) {
                    str2 = "https";
                    if (!str.equalsIgnoreCase(str2)) {
                        throw new IllegalArgumentException("unexpected scheme: " + str);
                    }
                }
                this.f5148a = str2;
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a t(String str) {
            if (str != null) {
                this.f5149b = r.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.f5148a;
            if (str2 != null) {
                sb.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            if (!this.f5149b.isEmpty() || !this.f5150c.isEmpty()) {
                sb.append(this.f5149b);
                if (!this.f5150c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5150c);
                }
                sb.append('@');
            }
            String str3 = this.f5151d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f5151d);
                    sb.append(']');
                } else {
                    sb.append(this.f5151d);
                }
            }
            if (!(this.f5152e == -1 && this.f5148a == null)) {
                int c5 = c();
                String str4 = this.f5148a;
                if (str4 == null || c5 != r.d(str4)) {
                    sb.append(':');
                    sb.append(c5);
                }
            }
            r.q(sb, this.f5153f);
            if (this.f5154g != null) {
                sb.append('?');
                r.n(sb, this.f5154g);
            }
            if (this.f5155h != null) {
                sb.append('#');
                sb.append(this.f5155h);
            }
            return sb.toString();
        }
    }

    r(a aVar) {
        this.f5139a = aVar.f5148a;
        this.f5140b = s(aVar.f5149b, false);
        this.f5141c = s(aVar.f5150c, false);
        this.f5142d = aVar.f5151d;
        this.f5143e = aVar.c();
        this.f5144f = t(aVar.f5153f, false);
        List<String> list = aVar.f5154g;
        String str = null;
        this.f5145g = list != null ? t(list, true) : null;
        String str2 = aVar.f5155h;
        this.f5146h = str2 != null ? s(str2, false) : str;
        this.f5147i = aVar.toString();
    }

    static String a(String str, int i5, int i6, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        String str3 = str;
        int i7 = i6;
        int i8 = i5;
        while (i8 < i7) {
            int codePointAt = str.codePointAt(i8);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z7)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z4 && (!z5 || v(str, i8, i6)))) && (codePointAt != 43 || !z6))) {
                    i8 += Character.charCount(codePointAt);
                }
            }
            s4.c cVar = new s4.c();
            int i9 = i5;
            cVar.T(str, i5, i8);
            c(cVar, str, i8, i6, str2, z4, z5, z6, z7, charset);
            return cVar.q();
        }
        int i10 = i5;
        return str.substring(i5, i6);
    }

    static String b(String str, String str2, boolean z4, boolean z5, boolean z6, boolean z7) {
        return a(str, 0, str.length(), str2, z4, z5, z6, z7, (Charset) null);
    }

    static void c(s4.c cVar, String str, int i5, int i6, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        s4.c cVar2 = null;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (!z4 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z6) {
                    cVar.I(z4 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z7) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z4 || (z5 && !v(str, i5, i6)))))) {
                    if (cVar2 == null) {
                        cVar2 = new s4.c();
                    }
                    if (charset == null || charset.equals(c.f5484j)) {
                        cVar2.U(codePointAt);
                    } else {
                        cVar2.R(str, i5, Character.charCount(codePointAt) + i5, charset);
                    }
                    while (!cVar2.t()) {
                        byte readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        char[] cArr = f5138j;
                        cVar.writeByte(cArr[(readByte >> 4) & 15]);
                        cVar.writeByte(cArr[readByte & 15]);
                    }
                } else {
                    cVar.U(codePointAt);
                }
            }
            i5 += Character.charCount(codePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static r k(String str) {
        return new a().h((r) null, str).a();
    }

    static void n(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            String str = list.get(i5);
            String str2 = list.get(i5 + 1);
            if (i5 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static void q(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            sb.append('/');
            sb.append(list.get(i5));
        }
    }

    static String r(String str, int i5, int i6, boolean z4) {
        for (int i7 = i5; i7 < i6; i7++) {
            char charAt = str.charAt(i7);
            if (charAt == '%' || (charAt == '+' && z4)) {
                s4.c cVar = new s4.c();
                cVar.T(str, i5, i7);
                u(cVar, str, i7, i6, z4);
                return cVar.q();
            }
        }
        return str.substring(i5, i6);
    }

    static String s(String str, boolean z4) {
        return r(str, 0, str.length(), z4);
    }

    private List<String> t(List<String> list, boolean z4) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            String str = list.get(i5);
            arrayList.add(str != null ? s(str, z4) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void u(s4.c cVar, String str, int i5, int i6, boolean z4) {
        int i7;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt == 37 && (i7 = i5 + 2) < i6) {
                int i8 = c.i(str.charAt(i5 + 1));
                int i9 = c.i(str.charAt(i7));
                if (!(i8 == -1 || i9 == -1)) {
                    cVar.writeByte((i8 << 4) + i9);
                    i5 = i7;
                    i5 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z4) {
                cVar.writeByte(32);
                i5 += Character.charCount(codePointAt);
            }
            cVar.U(codePointAt);
            i5 += Character.charCount(codePointAt);
        }
    }

    static boolean v(String str, int i5, int i6) {
        int i7 = i5 + 2;
        return i7 < i6 && str.charAt(i5) == '%' && c.i(str.charAt(i5 + 1)) != -1 && c.i(str.charAt(i7)) != -1;
    }

    static List<String> y(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 <= str.length()) {
            int indexOf = str.indexOf(38, i5);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i5);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i5, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i5, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i5 = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public r A(String str) {
        a p5 = p(str);
        if (p5 != null) {
            return p5.a();
        }
        return null;
    }

    public String B() {
        return this.f5139a;
    }

    public URI C() {
        String aVar = o().o().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e5) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BuildConfig.FLAVOR));
            } catch (Exception unused) {
                throw new RuntimeException(e5);
            }
        }
    }

    @Nullable
    public String e() {
        if (this.f5146h == null) {
            return null;
        }
        return this.f5147i.substring(this.f5147i.indexOf(35) + 1);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof r) && ((r) obj).f5147i.equals(this.f5147i);
    }

    public String f() {
        if (this.f5141c.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int indexOf = this.f5147i.indexOf(64);
        return this.f5147i.substring(this.f5147i.indexOf(58, this.f5139a.length() + 3) + 1, indexOf);
    }

    public String g() {
        int indexOf = this.f5147i.indexOf(47, this.f5139a.length() + 3);
        String str = this.f5147i;
        return this.f5147i.substring(indexOf, c.m(str, indexOf, str.length(), "?#"));
    }

    public List<String> h() {
        int indexOf = this.f5147i.indexOf(47, this.f5139a.length() + 3);
        String str = this.f5147i;
        int m5 = c.m(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < m5) {
            int i5 = indexOf + 1;
            int l5 = c.l(this.f5147i, i5, m5, '/');
            arrayList.add(this.f5147i.substring(i5, l5));
            indexOf = l5;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f5147i.hashCode();
    }

    @Nullable
    public String i() {
        if (this.f5145g == null) {
            return null;
        }
        int indexOf = this.f5147i.indexOf(63) + 1;
        String str = this.f5147i;
        return this.f5147i.substring(indexOf, c.l(str, indexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f5140b.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f5139a.length() + 3;
        String str = this.f5147i;
        return this.f5147i.substring(length, c.m(str, length, str.length(), ":@"));
    }

    public String l() {
        return this.f5142d;
    }

    public boolean m() {
        return this.f5139a.equals("https");
    }

    public a o() {
        a aVar = new a();
        aVar.f5148a = this.f5139a;
        aVar.f5149b = j();
        aVar.f5150c = f();
        aVar.f5151d = this.f5142d;
        aVar.f5152e = this.f5143e != d(this.f5139a) ? this.f5143e : -1;
        aVar.f5153f.clear();
        aVar.f5153f.addAll(h());
        aVar.d(i());
        aVar.f5155h = e();
        return aVar;
    }

    @Nullable
    public a p(String str) {
        try {
            return new a().h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.f5147i;
    }

    public int w() {
        return this.f5143e;
    }

    @Nullable
    public String x() {
        if (this.f5145g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        n(sb, this.f5145g);
        return sb.toString();
    }

    public String z() {
        return p("/...").t(BuildConfig.FLAVOR).j(BuildConfig.FLAVOR).a().toString();
    }
}
