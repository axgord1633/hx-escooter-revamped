package k4;

import i4.q;
import i4.x;
import i4.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import m4.d;
import m4.e;

public final class c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final x f5536a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final z f5537b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f5538a;

        /* renamed from: b  reason: collision with root package name */
        final x f5539b;

        /* renamed from: c  reason: collision with root package name */
        final z f5540c;

        /* renamed from: d  reason: collision with root package name */
        private Date f5541d;

        /* renamed from: e  reason: collision with root package name */
        private String f5542e;

        /* renamed from: f  reason: collision with root package name */
        private Date f5543f;

        /* renamed from: g  reason: collision with root package name */
        private String f5544g;

        /* renamed from: h  reason: collision with root package name */
        private Date f5545h;

        /* renamed from: i  reason: collision with root package name */
        private long f5546i;

        /* renamed from: j  reason: collision with root package name */
        private long f5547j;

        /* renamed from: k  reason: collision with root package name */
        private String f5548k;

        /* renamed from: l  reason: collision with root package name */
        private int f5549l = -1;

        public a(long j5, x xVar, z zVar) {
            this.f5538a = j5;
            this.f5539b = xVar;
            this.f5540c = zVar;
            if (zVar != null) {
                this.f5546i = zVar.q();
                this.f5547j = zVar.n();
                q j6 = zVar.j();
                int g5 = j6.g();
                for (int i5 = 0; i5 < g5; i5++) {
                    String e5 = j6.e(i5);
                    String h5 = j6.h(i5);
                    if ("Date".equalsIgnoreCase(e5)) {
                        this.f5541d = d.b(h5);
                        this.f5542e = h5;
                    } else if ("Expires".equalsIgnoreCase(e5)) {
                        this.f5545h = d.b(h5);
                    } else if ("Last-Modified".equalsIgnoreCase(e5)) {
                        this.f5543f = d.b(h5);
                        this.f5544g = h5;
                    } else if ("ETag".equalsIgnoreCase(e5)) {
                        this.f5548k = h5;
                    } else if ("Age".equalsIgnoreCase(e5)) {
                        this.f5549l = e.d(h5, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f5541d;
            long j5 = 0;
            if (date != null) {
                j5 = Math.max(0, this.f5547j - date.getTime());
            }
            int i5 = this.f5549l;
            if (i5 != -1) {
                j5 = Math.max(j5, TimeUnit.SECONDS.toMillis((long) i5));
            }
            long j6 = this.f5547j;
            return j5 + (j6 - this.f5546i) + (this.f5538a - j6);
        }

        private long b() {
            i4.c d5 = this.f5540c.d();
            if (d5.d() != -1) {
                return TimeUnit.SECONDS.toMillis((long) d5.d());
            }
            if (this.f5545h != null) {
                Date date = this.f5541d;
                long time = this.f5545h.getTime() - (date != null ? date.getTime() : this.f5547j);
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f5543f == null || this.f5540c.p().h().x() != null) {
                return 0;
            } else {
                Date date2 = this.f5541d;
                long time2 = (date2 != null ? date2.getTime() : this.f5546i) - this.f5543f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        private c d() {
            if (this.f5540c == null) {
                return new c(this.f5539b, (z) null);
            }
            if (this.f5539b.e() && this.f5540c.f() == null) {
                return new c(this.f5539b, (z) null);
            }
            if (!c.a(this.f5540c, this.f5539b)) {
                return new c(this.f5539b, (z) null);
            }
            i4.c b5 = this.f5539b.b();
            if (b5.h() || e(this.f5539b)) {
                return new c(this.f5539b, (z) null);
            }
            i4.c d5 = this.f5540c.d();
            long a5 = a();
            long b6 = b();
            if (b5.d() != -1) {
                b6 = Math.min(b6, TimeUnit.SECONDS.toMillis((long) b5.d()));
            }
            long j5 = 0;
            long millis = b5.f() != -1 ? TimeUnit.SECONDS.toMillis((long) b5.f()) : 0;
            if (!d5.g() && b5.e() != -1) {
                j5 = TimeUnit.SECONDS.toMillis((long) b5.e());
            }
            if (!d5.h()) {
                long j6 = millis + a5;
                if (j6 < j5 + b6) {
                    z.a l5 = this.f5540c.l();
                    if (j6 >= b6) {
                        l5.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a5 > 86400000 && f()) {
                        l5.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c((x) null, l5.c());
                }
            }
            String str = this.f5548k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f5543f != null) {
                str = this.f5544g;
            } else if (this.f5541d == null) {
                return new c(this.f5539b, (z) null);
            } else {
                str = this.f5542e;
            }
            q.a f5 = this.f5539b.d().f();
            j4.a.f5473a.b(f5, str2, str);
            return new c(this.f5539b.g().c(f5.d()).a(), this.f5540c);
        }

        private static boolean e(x xVar) {
            return (xVar.c("If-Modified-Since") == null && xVar.c("If-None-Match") == null) ? false : true;
        }

        private boolean f() {
            return this.f5540c.d().d() == -1 && this.f5545h == null;
        }

        public c c() {
            c d5 = d();
            return (d5.f5536a == null || !this.f5539b.b().j()) ? d5 : new c((x) null, (z) null);
        }
    }

    c(x xVar, z zVar) {
        this.f5536a = xVar;
        this.f5537b = zVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.d().b() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(i4.z r3, i4.x r4) {
        /*
            int r0 = r3.e()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.g(r0)
            if (r0 != 0) goto L_0x005a
            i4.c r0 = r3.d()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            i4.c r0 = r3.d()
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x005a
            i4.c r0 = r3.d()
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            i4.c r3 = r3.d()
            boolean r3 = r3.i()
            if (r3 != 0) goto L_0x006f
            i4.c r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.c.a(i4.z, i4.x):boolean");
    }
}
