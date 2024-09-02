package i4;

import com.yalantis.ucrop.BuildConfig;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class c {

    /* renamed from: n  reason: collision with root package name */
    public static final c f4978n = new a().c().a();

    /* renamed from: o  reason: collision with root package name */
    public static final c f4979o = new a().d().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4980a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4981b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4982c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4983d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4984e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4985f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4986g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4987h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4988i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f4989j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f4990k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f4991l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    String f4992m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f4993a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4994b;

        /* renamed from: c  reason: collision with root package name */
        int f4995c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f4996d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f4997e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f4998f;

        /* renamed from: g  reason: collision with root package name */
        boolean f4999g;

        /* renamed from: h  reason: collision with root package name */
        boolean f5000h;

        public c a() {
            return new c(this);
        }

        public a b(int i5, TimeUnit timeUnit) {
            if (i5 >= 0) {
                long seconds = timeUnit.toSeconds((long) i5);
                this.f4996d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i5);
        }

        public a c() {
            this.f4993a = true;
            return this;
        }

        public a d() {
            this.f4998f = true;
            return this;
        }
    }

    c(a aVar) {
        this.f4980a = aVar.f4993a;
        this.f4981b = aVar.f4994b;
        this.f4982c = aVar.f4995c;
        this.f4983d = -1;
        this.f4984e = false;
        this.f4985f = false;
        this.f4986g = false;
        this.f4987h = aVar.f4996d;
        this.f4988i = aVar.f4997e;
        this.f4989j = aVar.f4998f;
        this.f4990k = aVar.f4999g;
        this.f4991l = aVar.f5000h;
    }

    private c(boolean z4, boolean z5, int i5, int i6, boolean z6, boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, @Nullable String str) {
        this.f4980a = z4;
        this.f4981b = z5;
        this.f4982c = i5;
        this.f4983d = i6;
        this.f4984e = z6;
        this.f4985f = z7;
        this.f4986g = z8;
        this.f4987h = i7;
        this.f4988i = i8;
        this.f4989j = z9;
        this.f4990k = z10;
        this.f4991l = z11;
        this.f4992m = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f4980a) {
            sb.append("no-cache, ");
        }
        if (this.f4981b) {
            sb.append("no-store, ");
        }
        if (this.f4982c != -1) {
            sb.append("max-age=");
            sb.append(this.f4982c);
            sb.append(", ");
        }
        if (this.f4983d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f4983d);
            sb.append(", ");
        }
        if (this.f4984e) {
            sb.append("private, ");
        }
        if (this.f4985f) {
            sb.append("public, ");
        }
        if (this.f4986g) {
            sb.append("must-revalidate, ");
        }
        if (this.f4987h != -1) {
            sb.append("max-stale=");
            sb.append(this.f4987h);
            sb.append(", ");
        }
        if (this.f4988i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f4988i);
            sb.append(", ");
        }
        if (this.f4989j) {
            sb.append("only-if-cached, ");
        }
        if (this.f4990k) {
            sb.append("no-transform, ");
        }
        if (this.f4991l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static i4.c k(i4.q r22) {
        /*
            r0 = r22
            int r1 = r22.g()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x013f
            java.lang.String r2 = r0.e(r6)
            java.lang.String r4 = r0.h(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0138
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0138
            java.lang.String r3 = "=,;"
            int r3 = m4.e.f(r4, r2, r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0099
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0066
            goto L_0x0099
        L_0x0066:
            int r3 = r3 + 1
            int r0 = m4.e.g(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0089
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0089
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = m4.e.f(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009d
        L_0x0089:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = m4.e.f(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009d
        L_0x0099:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009d:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a9
            r5 = -1
            r9 = 1
            goto L_0x0133
        L_0x00a9:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b5
            r5 = -1
            r10 = 1
            goto L_0x0133
        L_0x00b5:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c4
            r5 = -1
            int r11 = m4.e.d(r0, r5)
            goto L_0x0133
        L_0x00c4:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d2
            r5 = -1
            int r12 = m4.e.d(r0, r5)
            goto L_0x0133
        L_0x00d2:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00dd
            r5 = -1
            r13 = 1
            goto L_0x0133
        L_0x00dd:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e8
            r5 = -1
            r14 = 1
            goto L_0x0133
        L_0x00e8:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f3
            r5 = -1
            r15 = 1
            goto L_0x0133
        L_0x00f3:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0104
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = m4.e.d(r0, r2)
            r5 = -1
            goto L_0x0133
        L_0x0104:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0112
            r5 = -1
            int r17 = m4.e.d(r0, r5)
            goto L_0x0133
        L_0x0112:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011e
            r18 = 1
            goto L_0x0133
        L_0x011e:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0129
            r19 = 1
            goto L_0x0133
        L_0x0129:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0133
            r20 = 1
        L_0x0133:
            r0 = r22
            r2 = r3
            goto L_0x003b
        L_0x0138:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x013f:
            if (r7 != 0) goto L_0x0144
            r21 = 0
            goto L_0x0146
        L_0x0144:
            r21 = r8
        L_0x0146:
            i4.c r0 = new i4.c
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.c.k(i4.q):i4.c");
    }

    public boolean b() {
        return this.f4984e;
    }

    public boolean c() {
        return this.f4985f;
    }

    public int d() {
        return this.f4982c;
    }

    public int e() {
        return this.f4987h;
    }

    public int f() {
        return this.f4988i;
    }

    public boolean g() {
        return this.f4986g;
    }

    public boolean h() {
        return this.f4980a;
    }

    public boolean i() {
        return this.f4981b;
    }

    public boolean j() {
        return this.f4989j;
    }

    public String toString() {
        String str = this.f4992m;
        if (str != null) {
            return str;
        }
        String a5 = a();
        this.f4992m = a5;
        return a5;
    }
}
