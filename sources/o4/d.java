package o4;

import com.yalantis.ucrop.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s4.c;
import s4.e;
import s4.f;
import s4.l;
import s4.s;

final class d {

    /* renamed from: a  reason: collision with root package name */
    static final c[] f6184a;

    /* renamed from: b  reason: collision with root package name */
    static final Map<f, Integer> f6185b = b();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f6186a;

        /* renamed from: b  reason: collision with root package name */
        private final e f6187b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6188c;

        /* renamed from: d  reason: collision with root package name */
        private int f6189d;

        /* renamed from: e  reason: collision with root package name */
        c[] f6190e;

        /* renamed from: f  reason: collision with root package name */
        int f6191f;

        /* renamed from: g  reason: collision with root package name */
        int f6192g;

        /* renamed from: h  reason: collision with root package name */
        int f6193h;

        a(int i5, int i6, s sVar) {
            this.f6186a = new ArrayList();
            c[] cVarArr = new c[8];
            this.f6190e = cVarArr;
            this.f6191f = cVarArr.length - 1;
            this.f6192g = 0;
            this.f6193h = 0;
            this.f6188c = i5;
            this.f6189d = i6;
            this.f6187b = l.b(sVar);
        }

        a(int i5, s sVar) {
            this(i5, i5, sVar);
        }

        private void a() {
            int i5 = this.f6189d;
            int i6 = this.f6193h;
            if (i5 >= i6) {
                return;
            }
            if (i5 == 0) {
                b();
            } else {
                d(i6 - i5);
            }
        }

        private void b() {
            Arrays.fill(this.f6190e, (Object) null);
            this.f6191f = this.f6190e.length - 1;
            this.f6192g = 0;
            this.f6193h = 0;
        }

        private int c(int i5) {
            return this.f6191f + 1 + i5;
        }

        private int d(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f6190e.length;
                while (true) {
                    length--;
                    i6 = this.f6191f;
                    if (length < i6 || i5 <= 0) {
                        c[] cVarArr = this.f6190e;
                        System.arraycopy(cVarArr, i6 + 1, cVarArr, i6 + 1 + i7, this.f6192g);
                        this.f6191f += i7;
                    } else {
                        int i8 = this.f6190e[length].f6183c;
                        i5 -= i8;
                        this.f6193h -= i8;
                        this.f6192g--;
                        i7++;
                    }
                }
                c[] cVarArr2 = this.f6190e;
                System.arraycopy(cVarArr2, i6 + 1, cVarArr2, i6 + 1 + i7, this.f6192g);
                this.f6191f += i7;
            }
            return i7;
        }

        private f f(int i5) {
            c cVar;
            if (h(i5)) {
                cVar = d.f6184a[i5];
            } else {
                int c5 = c(i5 - d.f6184a.length);
                if (c5 >= 0) {
                    c[] cVarArr = this.f6190e;
                    if (c5 < cVarArr.length) {
                        cVar = cVarArr[c5];
                    }
                }
                throw new IOException("Header index too large " + (i5 + 1));
            }
            return cVar.f6181a;
        }

        private void g(int i5, c cVar) {
            this.f6186a.add(cVar);
            int i6 = cVar.f6183c;
            if (i5 != -1) {
                i6 -= this.f6190e[c(i5)].f6183c;
            }
            int i7 = this.f6189d;
            if (i6 > i7) {
                b();
                return;
            }
            int d5 = d((this.f6193h + i6) - i7);
            if (i5 == -1) {
                int i8 = this.f6192g + 1;
                c[] cVarArr = this.f6190e;
                if (i8 > cVarArr.length) {
                    c[] cVarArr2 = new c[(cVarArr.length * 2)];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f6191f = this.f6190e.length - 1;
                    this.f6190e = cVarArr2;
                }
                int i9 = this.f6191f;
                this.f6191f = i9 - 1;
                this.f6190e[i9] = cVar;
                this.f6192g++;
            } else {
                this.f6190e[i5 + c(i5) + d5] = cVar;
            }
            this.f6193h += i6;
        }

        private boolean h(int i5) {
            return i5 >= 0 && i5 <= d.f6184a.length - 1;
        }

        private int i() {
            return this.f6187b.readByte() & 255;
        }

        private void l(int i5) {
            if (h(i5)) {
                this.f6186a.add(d.f6184a[i5]);
                return;
            }
            int c5 = c(i5 - d.f6184a.length);
            if (c5 >= 0) {
                c[] cVarArr = this.f6190e;
                if (c5 < cVarArr.length) {
                    this.f6186a.add(cVarArr[c5]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void n(int i5) {
            g(-1, new c(f(i5), j()));
        }

        private void o() {
            g(-1, new c(d.a(j()), j()));
        }

        private void p(int i5) {
            this.f6186a.add(new c(f(i5), j()));
        }

        private void q() {
            this.f6186a.add(new c(d.a(j()), j()));
        }

        public List<c> e() {
            ArrayList arrayList = new ArrayList(this.f6186a);
            this.f6186a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public f j() {
            int i5 = i();
            boolean z4 = (i5 & 128) == 128;
            int m5 = m(i5, 127);
            return z4 ? f.r(k.f().c(this.f6187b.u((long) m5))) : this.f6187b.k((long) m5);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            while (!this.f6187b.t()) {
                byte readByte = this.f6187b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    l(m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m5 = m(readByte, 31);
                    this.f6189d = m5;
                    if (m5 < 0 || m5 > this.f6188c) {
                        throw new IOException("Invalid dynamic table size update " + this.f6189d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    q();
                } else {
                    p(m(readByte, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int m(int i5, int i6) {
            int i7 = i5 & i6;
            if (i7 < i6) {
                return i7;
            }
            int i8 = 0;
            while (true) {
                int i9 = i();
                if ((i9 & 128) == 0) {
                    return i6 + (i9 << i8);
                }
                i6 += (i9 & 127) << i8;
                i8 += 7;
            }
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f6194a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6195b;

        /* renamed from: c  reason: collision with root package name */
        private int f6196c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6197d;

        /* renamed from: e  reason: collision with root package name */
        int f6198e;

        /* renamed from: f  reason: collision with root package name */
        int f6199f;

        /* renamed from: g  reason: collision with root package name */
        c[] f6200g;

        /* renamed from: h  reason: collision with root package name */
        int f6201h;

        /* renamed from: i  reason: collision with root package name */
        int f6202i;

        /* renamed from: j  reason: collision with root package name */
        int f6203j;

        b(int i5, boolean z4, c cVar) {
            this.f6196c = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.f6200g = cVarArr;
            this.f6201h = cVarArr.length - 1;
            this.f6202i = 0;
            this.f6203j = 0;
            this.f6198e = i5;
            this.f6199f = i5;
            this.f6195b = z4;
            this.f6194a = cVar;
        }

        b(c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            int i5 = this.f6199f;
            int i6 = this.f6203j;
            if (i5 >= i6) {
                return;
            }
            if (i5 == 0) {
                b();
            } else {
                c(i6 - i5);
            }
        }

        private void b() {
            Arrays.fill(this.f6200g, (Object) null);
            this.f6201h = this.f6200g.length - 1;
            this.f6202i = 0;
            this.f6203j = 0;
        }

        private int c(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f6200g.length;
                while (true) {
                    length--;
                    i6 = this.f6201h;
                    if (length < i6 || i5 <= 0) {
                        c[] cVarArr = this.f6200g;
                        System.arraycopy(cVarArr, i6 + 1, cVarArr, i6 + 1 + i7, this.f6202i);
                        c[] cVarArr2 = this.f6200g;
                        int i8 = this.f6201h;
                        Arrays.fill(cVarArr2, i8 + 1, i8 + 1 + i7, (Object) null);
                        this.f6201h += i7;
                    } else {
                        int i9 = this.f6200g[length].f6183c;
                        i5 -= i9;
                        this.f6203j -= i9;
                        this.f6202i--;
                        i7++;
                    }
                }
                c[] cVarArr3 = this.f6200g;
                System.arraycopy(cVarArr3, i6 + 1, cVarArr3, i6 + 1 + i7, this.f6202i);
                c[] cVarArr22 = this.f6200g;
                int i82 = this.f6201h;
                Arrays.fill(cVarArr22, i82 + 1, i82 + 1 + i7, (Object) null);
                this.f6201h += i7;
            }
            return i7;
        }

        private void d(c cVar) {
            int i5 = cVar.f6183c;
            int i6 = this.f6199f;
            if (i5 > i6) {
                b();
                return;
            }
            c((this.f6203j + i5) - i6);
            int i7 = this.f6202i + 1;
            c[] cVarArr = this.f6200g;
            if (i7 > cVarArr.length) {
                c[] cVarArr2 = new c[(cVarArr.length * 2)];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f6201h = this.f6200g.length - 1;
                this.f6200g = cVarArr2;
            }
            int i8 = this.f6201h;
            this.f6201h = i8 - 1;
            this.f6200g[i8] = cVar;
            this.f6202i++;
            this.f6203j += i5;
        }

        /* access modifiers changed from: package-private */
        public void e(int i5) {
            this.f6198e = i5;
            int min = Math.min(i5, 16384);
            int i6 = this.f6199f;
            if (i6 != min) {
                if (min < i6) {
                    this.f6196c = Math.min(this.f6196c, min);
                }
                this.f6197d = true;
                this.f6199f = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(f fVar) {
            int i5;
            int i6;
            if (!this.f6195b || k.f().e(fVar) >= fVar.w()) {
                i6 = fVar.w();
                i5 = 0;
            } else {
                c cVar = new c();
                k.f().d(fVar, cVar);
                fVar = cVar.n();
                i6 = fVar.w();
                i5 = 128;
            }
            h(i6, 127, i5);
            this.f6194a.D(fVar);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00af  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(java.util.List<o4.c> r14) {
            /*
                r13 = this;
                boolean r0 = r13.f6197d
                r1 = 0
                if (r0 == 0) goto L_0x001e
                int r0 = r13.f6196c
                int r2 = r13.f6199f
                r3 = 32
                r4 = 31
                if (r0 >= r2) goto L_0x0012
                r13.h(r0, r4, r3)
            L_0x0012:
                r13.f6197d = r1
                r0 = 2147483647(0x7fffffff, float:NaN)
                r13.f6196c = r0
                int r0 = r13.f6199f
                r13.h(r0, r4, r3)
            L_0x001e:
                int r0 = r14.size()
                r2 = r1
            L_0x0023:
                if (r2 >= r0) goto L_0x00e5
                java.lang.Object r3 = r14.get(r2)
                o4.c r3 = (o4.c) r3
                s4.f r4 = r3.f6181a
                s4.f r4 = r4.z()
                s4.f r5 = r3.f6182b
                java.util.Map<s4.f, java.lang.Integer> r6 = o4.d.f6185b
                java.lang.Object r6 = r6.get(r4)
                java.lang.Integer r6 = (java.lang.Integer) r6
                r7 = -1
                r8 = 1
                if (r6 == 0) goto L_0x006c
                int r6 = r6.intValue()
                int r6 = r6 + r8
                if (r6 <= r8) goto L_0x0069
                r9 = 8
                if (r6 >= r9) goto L_0x0069
                o4.c[] r9 = o4.d.f6184a
                int r10 = r6 + -1
                r10 = r9[r10]
                s4.f r10 = r10.f6182b
                boolean r10 = j4.c.o(r10, r5)
                if (r10 == 0) goto L_0x0059
                goto L_0x006d
            L_0x0059:
                r9 = r9[r6]
                s4.f r9 = r9.f6182b
                boolean r9 = j4.c.o(r9, r5)
                if (r9 == 0) goto L_0x0069
                int r9 = r6 + 1
                r12 = r9
                r9 = r6
                r6 = r12
                goto L_0x006e
            L_0x0069:
                r9 = r6
                r6 = r7
                goto L_0x006e
            L_0x006c:
                r6 = r7
            L_0x006d:
                r9 = r6
            L_0x006e:
                if (r6 != r7) goto L_0x00a5
                int r10 = r13.f6201h
                int r10 = r10 + r8
                o4.c[] r8 = r13.f6200g
                int r8 = r8.length
            L_0x0076:
                if (r10 >= r8) goto L_0x00a5
                o4.c[] r11 = r13.f6200g
                r11 = r11[r10]
                s4.f r11 = r11.f6181a
                boolean r11 = j4.c.o(r11, r4)
                if (r11 == 0) goto L_0x00a2
                o4.c[] r11 = r13.f6200g
                r11 = r11[r10]
                s4.f r11 = r11.f6182b
                boolean r11 = j4.c.o(r11, r5)
                if (r11 == 0) goto L_0x0098
                int r6 = r13.f6201h
                int r10 = r10 - r6
                o4.c[] r6 = o4.d.f6184a
                int r6 = r6.length
                int r6 = r6 + r10
                goto L_0x00a5
            L_0x0098:
                if (r9 != r7) goto L_0x00a2
                int r9 = r13.f6201h
                int r9 = r10 - r9
                o4.c[] r11 = o4.d.f6184a
                int r11 = r11.length
                int r9 = r9 + r11
            L_0x00a2:
                int r10 = r10 + 1
                goto L_0x0076
            L_0x00a5:
                if (r6 == r7) goto L_0x00af
                r3 = 127(0x7f, float:1.78E-43)
                r4 = 128(0x80, float:1.794E-43)
                r13.h(r6, r3, r4)
                goto L_0x00e1
            L_0x00af:
                r6 = 64
                if (r9 != r7) goto L_0x00c2
                s4.c r7 = r13.f6194a
                r7.writeByte(r6)
                r13.f(r4)
            L_0x00bb:
                r13.f(r5)
                r13.d(r3)
                goto L_0x00e1
            L_0x00c2:
                s4.f r7 = o4.c.f6175d
                boolean r7 = r4.x(r7)
                if (r7 == 0) goto L_0x00db
                s4.f r7 = o4.c.f6180i
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x00db
                r3 = 15
                r13.h(r9, r3, r1)
                r13.f(r5)
                goto L_0x00e1
            L_0x00db:
                r4 = 63
                r13.h(r9, r4, r6)
                goto L_0x00bb
            L_0x00e1:
                int r2 = r2 + 1
                goto L_0x0023
            L_0x00e5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o4.d.b.g(java.util.List):void");
        }

        /* access modifiers changed from: package-private */
        public void h(int i5, int i6, int i7) {
            int i8;
            c cVar;
            if (i5 < i6) {
                cVar = this.f6194a;
                i8 = i5 | i7;
            } else {
                this.f6194a.writeByte(i7 | i6);
                i8 = i5 - i6;
                while (i8 >= 128) {
                    this.f6194a.writeByte(128 | (i8 & 127));
                    i8 >>>= 7;
                }
                cVar = this.f6194a;
            }
            cVar.writeByte(i8);
        }
    }

    static {
        f fVar = c.f6177f;
        f fVar2 = c.f6178g;
        f fVar3 = c.f6179h;
        f fVar4 = c.f6176e;
        f6184a = new c[]{new c(c.f6180i, (String) BuildConfig.FLAVOR), new c(fVar, "GET"), new c(fVar, "POST"), new c(fVar2, "/"), new c(fVar2, "/index.html"), new c(fVar3, "http"), new c(fVar3, "https"), new c(fVar4, "200"), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, "404"), new c(fVar4, "500"), new c("accept-charset", (String) BuildConfig.FLAVOR), new c("accept-encoding", "gzip, deflate"), new c("accept-language", (String) BuildConfig.FLAVOR), new c("accept-ranges", (String) BuildConfig.FLAVOR), new c("accept", (String) BuildConfig.FLAVOR), new c("access-control-allow-origin", (String) BuildConfig.FLAVOR), new c("age", (String) BuildConfig.FLAVOR), new c("allow", (String) BuildConfig.FLAVOR), new c("authorization", (String) BuildConfig.FLAVOR), new c("cache-control", (String) BuildConfig.FLAVOR), new c("content-disposition", (String) BuildConfig.FLAVOR), new c("content-encoding", (String) BuildConfig.FLAVOR), new c("content-language", (String) BuildConfig.FLAVOR), new c("content-length", (String) BuildConfig.FLAVOR), new c("content-location", (String) BuildConfig.FLAVOR), new c("content-range", (String) BuildConfig.FLAVOR), new c("content-type", (String) BuildConfig.FLAVOR), new c("cookie", (String) BuildConfig.FLAVOR), new c("date", (String) BuildConfig.FLAVOR), new c("etag", (String) BuildConfig.FLAVOR), new c("expect", (String) BuildConfig.FLAVOR), new c("expires", (String) BuildConfig.FLAVOR), new c("from", (String) BuildConfig.FLAVOR), new c("host", (String) BuildConfig.FLAVOR), new c("if-match", (String) BuildConfig.FLAVOR), new c("if-modified-since", (String) BuildConfig.FLAVOR), new c("if-none-match", (String) BuildConfig.FLAVOR), new c("if-range", (String) BuildConfig.FLAVOR), new c("if-unmodified-since", (String) BuildConfig.FLAVOR), new c("last-modified", (String) BuildConfig.FLAVOR), new c("link", (String) BuildConfig.FLAVOR), new c("location", (String) BuildConfig.FLAVOR), new c("max-forwards", (String) BuildConfig.FLAVOR), new c("proxy-authenticate", (String) BuildConfig.FLAVOR), new c("proxy-authorization", (String) BuildConfig.FLAVOR), new c("range", (String) BuildConfig.FLAVOR), new c("referer", (String) BuildConfig.FLAVOR), new c("refresh", (String) BuildConfig.FLAVOR), new c("retry-after", (String) BuildConfig.FLAVOR), new c("server", (String) BuildConfig.FLAVOR), new c("set-cookie", (String) BuildConfig.FLAVOR), new c("strict-transport-security", (String) BuildConfig.FLAVOR), new c("transfer-encoding", (String) BuildConfig.FLAVOR), new c("user-agent", (String) BuildConfig.FLAVOR), new c("vary", (String) BuildConfig.FLAVOR), new c("via", (String) BuildConfig.FLAVOR), new c("www-authenticate", (String) BuildConfig.FLAVOR)};
    }

    static f a(f fVar) {
        int w4 = fVar.w();
        int i5 = 0;
        while (i5 < w4) {
            byte p5 = fVar.p(i5);
            if (p5 < 65 || p5 > 90) {
                i5++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.B());
            }
        }
        return fVar;
    }

    private static Map<f, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f6184a.length);
        int i5 = 0;
        while (true) {
            c[] cVarArr = f6184a;
            if (i5 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i5].f6181a)) {
                linkedHashMap.put(cVarArr[i5].f6181a, Integer.valueOf(i5));
            }
            i5++;
        }
    }
}
