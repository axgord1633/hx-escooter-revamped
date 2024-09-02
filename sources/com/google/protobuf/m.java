package com.google.protobuf;

import com.google.protobuf.l0;
import com.google.protobuf.w1;
import java.util.List;
import java.util.Map;

final class m implements w1 {

    /* renamed from: a  reason: collision with root package name */
    private final l f3630a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3631a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.v1$b[] r0 = com.google.protobuf.v1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3631a = r0
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f3631a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.v1$b r1 = com.google.protobuf.v1.b.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.m.a.<clinit>():void");
        }
    }

    private m(l lVar) {
        l lVar2 = (l) b0.b(lVar, "output");
        this.f3630a = lVar2;
        lVar2.f3598a = this;
    }

    public static m P(l lVar) {
        m mVar = lVar.f3598a;
        return mVar != null ? mVar : new m(lVar);
    }

    private <K, V> void Q(int i5, l0.a<K, V> aVar, Map<K, V> map) {
        int[] iArr = a.f3631a;
        throw null;
    }

    private void R(int i5, Object obj) {
        if (obj instanceof String) {
            this.f3630a.Q0(i5, (String) obj);
        } else {
            this.f3630a.n0(i5, (i) obj);
        }
    }

    public void A(int i5, long j5) {
        this.f3630a.u0(i5, j5);
    }

    public w1.a B() {
        return w1.a.ASCENDING;
    }

    public void C(int i5, long j5) {
        this.f3630a.O0(i5, j5);
    }

    public void D(int i5, float f5) {
        this.f3630a.w0(i5, f5);
    }

    public void E(int i5, List<String> list) {
        int i6 = 0;
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            while (i6 < list.size()) {
                R(i5, h0Var.h(i6));
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.Q0(i5, list.get(i6));
            i6++;
        }
    }

    public void F(int i5) {
        this.f3630a.R0(i5, 4);
    }

    public void G(int i5, String str) {
        this.f3630a.Q0(i5, str);
    }

    public void H(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.R(list.get(i8).intValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.N0(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.M0(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void I(int i5, long j5) {
        this.f3630a.U0(i5, j5);
    }

    public void J(int i5, int i6) {
        this.f3630a.q0(i5, i6);
    }

    public void K(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.z(list.get(i8).longValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.D0(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.C0(i5, list.get(i6).longValue());
            i6++;
        }
    }

    public void L(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.m(list.get(i8).intValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.r0(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.q0(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void M(int i5, List<Double> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.k(list.get(i8).doubleValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.p0(list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.o0(i5, list.get(i6).doubleValue());
            i6++;
        }
    }

    public void N(int i5, int i6) {
        this.f3630a.M0(i5, i6);
    }

    public void O(int i5, List<i> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f3630a.n0(i5, list.get(i6));
        }
    }

    public void a(int i5, List<?> list, i1 i1Var) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            w(i5, list.get(i6), i1Var);
        }
    }

    public void b(int i5, List<?> list, i1 i1Var) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            i(i5, list.get(i6), i1Var);
        }
    }

    public void c(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.x(list.get(i8).intValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.B0(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.A0(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void d(int i5, List<Float> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.s(list.get(i8).floatValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.x0(list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.w0(i5, list.get(i6).floatValue());
            i6++;
        }
    }

    public void e(int i5, long j5) {
        this.f3630a.C0(i5, j5);
    }

    public void f(int i5, boolean z4) {
        this.f3630a.l0(i5, z4);
    }

    public void g(int i5, int i6) {
        this.f3630a.S0(i5, i6);
    }

    public final void h(int i5, Object obj) {
        if (obj instanceof i) {
            this.f3630a.G0(i5, (i) obj);
        } else {
            this.f3630a.F0(i5, (s0) obj);
        }
    }

    public void i(int i5, Object obj, i1 i1Var) {
        this.f3630a.y0(i5, (s0) obj, i1Var);
    }

    public void j(int i5, int i6) {
        this.f3630a.I0(i5, i6);
    }

    public void k(int i5) {
        this.f3630a.R0(i5, 3);
    }

    public void l(int i5, i iVar) {
        this.f3630a.n0(i5, iVar);
    }

    public void m(int i5, int i6) {
        this.f3630a.A0(i5, i6);
    }

    public void n(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.q(list.get(i8).longValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.v0(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.u0(i5, list.get(i6).longValue());
            i6++;
        }
    }

    public void o(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.N(list.get(i8).intValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.J0(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.I0(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void p(int i5, int i6) {
        this.f3630a.s0(i5, i6);
    }

    public void q(int i5, double d5) {
        this.f3630a.o0(i5, d5);
    }

    public void r(int i5, long j5) {
        this.f3630a.K0(i5, j5);
    }

    public void s(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.P(list.get(i8).longValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.L0(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.K0(i5, list.get(i6).longValue());
            i6++;
        }
    }

    public void t(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.o(list.get(i8).intValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.t0(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.s0(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void u(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.a0(list.get(i8).longValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.V0(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.U0(i5, list.get(i6).longValue());
            i6++;
        }
    }

    public void v(int i5, List<Boolean> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.f(list.get(i8).booleanValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.m0(list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.l0(i5, list.get(i6).booleanValue());
            i6++;
        }
    }

    public void w(int i5, Object obj, i1 i1Var) {
        this.f3630a.E0(i5, (s0) obj, i1Var);
    }

    public <K, V> void x(int i5, l0.a<K, V> aVar, Map<K, V> map) {
        if (this.f3630a.f0()) {
            Q(i5, aVar, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.f3630a.R0(i5, 2);
            this.f3630a.T0(l0.b(aVar, next.getKey(), next.getValue()));
            l0.d(this.f3630a, aVar, next.getKey(), next.getValue());
        }
    }

    public void y(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.Y(list.get(i8).intValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.T0(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.S0(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void z(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (z4) {
            this.f3630a.R0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += l.T(list.get(i8).longValue());
            }
            this.f3630a.T0(i7);
            while (i6 < list.size()) {
                this.f3630a.P0(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.f3630a.O0(i5, list.get(i6).longValue());
            i6++;
        }
    }
}
