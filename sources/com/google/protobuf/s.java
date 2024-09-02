package com.google.protobuf;

import com.google.protobuf.z;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

final class s extends r<z.d> {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3659a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.v1$b[] r0 = com.google.protobuf.v1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3659a = r0
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f3659a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s.a.<clinit>():void");
        }
    }

    s() {
    }

    /* access modifiers changed from: package-private */
    public int a(Map.Entry<?, ?> entry) {
        return ((z.d) entry.getKey()).a();
    }

    /* access modifiers changed from: package-private */
    public Object b(q qVar, s0 s0Var, int i5) {
        return qVar.a(s0Var, i5);
    }

    /* access modifiers changed from: package-private */
    public v<z.d> c(Object obj) {
        return ((z.c) obj).f3807e;
    }

    /* access modifiers changed from: package-private */
    public v<z.d> d(Object obj) {
        return ((z.c) obj).a();
    }

    /* access modifiers changed from: package-private */
    public boolean e(s0 s0Var) {
        return s0Var instanceof z.c;
    }

    /* access modifiers changed from: package-private */
    public void f(Object obj) {
        c(obj).s();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x016d, code lost:
        r1 = java.lang.Long.valueOf(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <UT, UB> UB g(com.google.protobuf.h1 r5, java.lang.Object r6, com.google.protobuf.q r7, com.google.protobuf.v<com.google.protobuf.z.d> r8, UB r9, com.google.protobuf.p1<UT, UB> r10) {
        /*
            r4 = this;
            com.google.protobuf.z$e r6 = (com.google.protobuf.z.e) r6
            int r0 = r6.d()
            com.google.protobuf.z$d r1 = r6.f3816d
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x00d2
            com.google.protobuf.z$d r1 = r6.f3816d
            boolean r1 = r1.k()
            if (r1 == 0) goto L_0x00d2
            int[] r7 = com.google.protobuf.s.a.f3659a
            com.google.protobuf.v1$b r1 = r6.b()
            int r1 = r1.ordinal()
            r7 = r7[r1]
            switch(r7) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00b1;
                case 4: goto L_0x00a8;
                case 5: goto L_0x009f;
                case 6: goto L_0x0096;
                case 7: goto L_0x008d;
                case 8: goto L_0x0084;
                case 9: goto L_0x007b;
                case 10: goto L_0x0072;
                case 11: goto L_0x0069;
                case 12: goto L_0x0060;
                case 13: goto L_0x0056;
                case 14: goto L_0x0042;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Type cannot be packed: "
            r7.append(r8)
            com.google.protobuf.z$d r6 = r6.f3816d
            com.google.protobuf.v1$b r6 = r6.d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L_0x0042:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.P(r7)
            com.google.protobuf.z$d r5 = r6.f3816d
            com.google.protobuf.b0$d r5 = r5.f()
            java.lang.Object r9 = com.google.protobuf.k1.z(r0, r7, r5, r9, r10)
            goto L_0x00cb
        L_0x0056:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.i(r7)
            goto L_0x00cb
        L_0x0060:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.a(r7)
            goto L_0x00cb
        L_0x0069:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.K(r7)
            goto L_0x00cb
        L_0x0072:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.g(r7)
            goto L_0x00cb
        L_0x007b:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.l(r7)
            goto L_0x00cb
        L_0x0084:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.n(r7)
            goto L_0x00cb
        L_0x008d:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.e(r7)
            goto L_0x00cb
        L_0x0096:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.N(r7)
            goto L_0x00cb
        L_0x009f:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.O(r7)
            goto L_0x00cb
        L_0x00a8:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.y(r7)
            goto L_0x00cb
        L_0x00b1:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.J(r7)
            goto L_0x00cb
        L_0x00ba:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.C(r7)
            goto L_0x00cb
        L_0x00c3:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.I(r7)
        L_0x00cb:
            com.google.protobuf.z$d r5 = r6.f3816d
            r8.w(r5, r7)
            goto L_0x01b5
        L_0x00d2:
            r1 = 0
            com.google.protobuf.v1$b r2 = r6.b()
            com.google.protobuf.v1$b r3 = com.google.protobuf.v1.b.ENUM
            if (r2 != r3) goto L_0x00f0
            int r5 = r5.E()
            com.google.protobuf.z$d r7 = r6.f3816d
            com.google.protobuf.b0$d r7 = r7.f()
            com.google.protobuf.b0$c r7 = r7.a(r5)
            if (r7 != 0) goto L_0x015f
            java.lang.Object r5 = com.google.protobuf.k1.L(r0, r5, r9, r10)
            return r5
        L_0x00f0:
            int[] r10 = com.google.protobuf.s.a.f3659a
            com.google.protobuf.v1$b r0 = r6.b()
            int r0 = r0.ordinal()
            r10 = r10[r0]
            switch(r10) {
                case 1: goto L_0x017b;
                case 2: goto L_0x0172;
                case 3: goto L_0x0169;
                case 4: goto L_0x0164;
                case 5: goto L_0x015b;
                case 6: goto L_0x0156;
                case 7: goto L_0x0151;
                case 8: goto L_0x0148;
                case 9: goto L_0x0143;
                case 10: goto L_0x013e;
                case 11: goto L_0x0139;
                case 12: goto L_0x0134;
                case 13: goto L_0x012f;
                case 14: goto L_0x0127;
                case 15: goto L_0x0122;
                case 16: goto L_0x011d;
                case 17: goto L_0x010f;
                case 18: goto L_0x0101;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            goto L_0x0183
        L_0x0101:
            com.google.protobuf.s0 r10 = r6.c()
            java.lang.Class r10 = r10.getClass()
            java.lang.Object r1 = r5.m(r10, r7)
            goto L_0x0183
        L_0x010f:
            com.google.protobuf.s0 r10 = r6.c()
            java.lang.Class r10 = r10.getClass()
            java.lang.Object r1 = r5.q(r10, r7)
            goto L_0x0183
        L_0x011d:
            java.lang.String r1 = r5.o()
            goto L_0x0183
        L_0x0122:
            com.google.protobuf.i r1 = r5.B()
            goto L_0x0183
        L_0x0127:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Shouldn't reach here."
            r5.<init>(r6)
            throw r5
        L_0x012f:
            long r0 = r5.k()
            goto L_0x016d
        L_0x0134:
            int r5 = r5.h()
            goto L_0x015f
        L_0x0139:
            long r0 = r5.v()
            goto L_0x016d
        L_0x013e:
            int r5 = r5.G()
            goto L_0x015f
        L_0x0143:
            int r5 = r5.D()
            goto L_0x015f
        L_0x0148:
            boolean r5 = r5.r()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)
            goto L_0x0183
        L_0x0151:
            int r5 = r5.p()
            goto L_0x015f
        L_0x0156:
            long r0 = r5.f()
            goto L_0x016d
        L_0x015b:
            int r5 = r5.E()
        L_0x015f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x0183
        L_0x0164:
            long r0 = r5.d()
            goto L_0x016d
        L_0x0169:
            long r0 = r5.L()
        L_0x016d:
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x0183
        L_0x0172:
            float r5 = r5.readFloat()
            java.lang.Float r1 = java.lang.Float.valueOf(r5)
            goto L_0x0183
        L_0x017b:
            double r0 = r5.readDouble()
            java.lang.Double r1 = java.lang.Double.valueOf(r0)
        L_0x0183:
            boolean r5 = r6.e()
            if (r5 == 0) goto L_0x018f
            com.google.protobuf.z$d r5 = r6.f3816d
            r8.a(r5, r1)
            goto L_0x01b5
        L_0x018f:
            int[] r5 = com.google.protobuf.s.a.f3659a
            com.google.protobuf.v1$b r7 = r6.b()
            int r7 = r7.ordinal()
            r5 = r5[r7]
            r7 = 17
            if (r5 == r7) goto L_0x01a4
            r7 = 18
            if (r5 == r7) goto L_0x01a4
            goto L_0x01b0
        L_0x01a4:
            com.google.protobuf.z$d r5 = r6.f3816d
            java.lang.Object r5 = r8.i(r5)
            if (r5 == 0) goto L_0x01b0
            java.lang.Object r1 = com.google.protobuf.b0.h(r5, r1)
        L_0x01b0:
            com.google.protobuf.z$d r5 = r6.f3816d
            r8.w(r5, r1)
        L_0x01b5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s.g(com.google.protobuf.h1, java.lang.Object, com.google.protobuf.q, com.google.protobuf.v, java.lang.Object, com.google.protobuf.p1):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public void h(h1 h1Var, Object obj, q qVar, v<z.d> vVar) {
        z.e eVar = (z.e) obj;
        vVar.w(eVar.f3816d, h1Var.m(eVar.c().getClass(), qVar));
    }

    /* access modifiers changed from: package-private */
    public void i(i iVar, Object obj, q qVar, v<z.d> vVar) {
        z.e eVar = (z.e) obj;
        s0 buildPartial = eVar.c().newBuilderForType().buildPartial();
        f Q = f.Q(ByteBuffer.wrap(iVar.y()), true);
        e1.a().b(buildPartial, Q, qVar);
        vVar.w(eVar.f3816d, buildPartial);
        if (Q.t() != Integer.MAX_VALUE) {
            throw c0.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(w1 w1Var, Map.Entry<?, ?> entry) {
        z.d dVar = (z.d) entry.getKey();
        if (dVar.b()) {
            switch (a.f3659a[dVar.d().ordinal()]) {
                case 1:
                    k1.P(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 2:
                    k1.T(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 3:
                    k1.W(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 4:
                    k1.e0(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 5:
                case 14:
                    k1.V(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 6:
                    k1.S(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 7:
                    k1.R(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 8:
                    k1.N(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 9:
                    k1.d0(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 10:
                    k1.Y(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 11:
                    k1.Z(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 12:
                    k1.a0(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 13:
                    k1.b0(dVar.a(), (List) entry.getValue(), w1Var, dVar.k());
                    return;
                case 15:
                    k1.O(dVar.a(), (List) entry.getValue(), w1Var);
                    return;
                case 16:
                    k1.c0(dVar.a(), (List) entry.getValue(), w1Var);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        k1.U(dVar.a(), (List) entry.getValue(), w1Var, e1.a().d(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        k1.X(dVar.a(), (List) entry.getValue(), w1Var, e1.a().d(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (a.f3659a[dVar.d().ordinal()]) {
                case 1:
                    w1Var.q(dVar.a(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    w1Var.D(dVar.a(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    w1Var.e(dVar.a(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    w1Var.I(dVar.a(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                case 14:
                    w1Var.m(dVar.a(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    w1Var.A(dVar.a(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    w1Var.p(dVar.a(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    w1Var.f(dVar.a(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    w1Var.g(dVar.a(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    w1Var.j(dVar.a(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    w1Var.r(dVar.a(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    w1Var.N(dVar.a(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    w1Var.C(dVar.a(), ((Long) entry.getValue()).longValue());
                    return;
                case 15:
                    w1Var.l(dVar.a(), (i) entry.getValue());
                    return;
                case 16:
                    w1Var.G(dVar.a(), (String) entry.getValue());
                    return;
                case 17:
                    w1Var.i(dVar.a(), entry.getValue(), e1.a().d(entry.getValue().getClass()));
                    return;
                case 18:
                    w1Var.w(dVar.a(), entry.getValue(), e1.a().d(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }
}
