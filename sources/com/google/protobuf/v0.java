package com.google.protobuf;

import com.google.protobuf.b0;
import com.google.protobuf.e;
import com.google.protobuf.i;
import com.google.protobuf.l0;
import com.google.protobuf.w1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class v0<T> implements i1<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f3699r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f3700s = t1.H();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f3701a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f3702b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3703c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3704d;

    /* renamed from: e  reason: collision with root package name */
    private final s0 f3705e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3706f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f3707g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f3708h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f3709i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f3710j;

    /* renamed from: k  reason: collision with root package name */
    private final int f3711k;

    /* renamed from: l  reason: collision with root package name */
    private final int f3712l;

    /* renamed from: m  reason: collision with root package name */
    private final x0 f3713m;

    /* renamed from: n  reason: collision with root package name */
    private final i0 f3714n;

    /* renamed from: o  reason: collision with root package name */
    private final p1<?, ?> f3715o;

    /* renamed from: p  reason: collision with root package name */
    private final r<?> f3716p;

    /* renamed from: q  reason: collision with root package name */
    private final n0 f3717q;

    private v0(int[] iArr, Object[] objArr, int i5, int i6, s0 s0Var, boolean z4, boolean z5, int[] iArr2, int i7, int i8, x0 x0Var, i0 i0Var, p1<?, ?> p1Var, r<?> rVar, n0 n0Var) {
        this.f3701a = iArr;
        this.f3702b = objArr;
        this.f3703c = i5;
        this.f3704d = i6;
        this.f3707g = s0Var instanceof z;
        this.f3708h = z4;
        this.f3706f = rVar != null && rVar.e(s0Var);
        this.f3709i = z5;
        this.f3710j = iArr2;
        this.f3711k = i7;
        this.f3712l = i8;
        this.f3713m = x0Var;
        this.f3714n = i0Var;
        this.f3715o = p1Var;
        this.f3716p = rVar;
        this.f3705e = s0Var;
        this.f3717q = n0Var;
    }

    private static boolean A(int i5) {
        return (i5 & 536870912) != 0;
    }

    private boolean B(T t5, int i5) {
        int h02 = h0(i5);
        long j5 = (long) (1048575 & h02);
        if (j5 == 1048575) {
            int r02 = r0(i5);
            long U = U(r02);
            switch (q0(r02)) {
                case 0:
                    return t1.A(t5, U) != 0.0d;
                case 1:
                    return t1.B(t5, U) != CropImageView.DEFAULT_ASPECT_RATIO;
                case 2:
                    return t1.E(t5, U) != 0;
                case 3:
                    return t1.E(t5, U) != 0;
                case 4:
                    return t1.C(t5, U) != 0;
                case 5:
                    return t1.E(t5, U) != 0;
                case 6:
                    return t1.C(t5, U) != 0;
                case 7:
                    return t1.t(t5, U);
                case 8:
                    Object G = t1.G(t5, U);
                    if (G instanceof String) {
                        return !((String) G).isEmpty();
                    }
                    if (G instanceof i) {
                        return !i.f3533f.equals(G);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return t1.G(t5, U) != null;
                case 10:
                    return !i.f3533f.equals(t1.G(t5, U));
                case 11:
                    return t1.C(t5, U) != 0;
                case 12:
                    return t1.C(t5, U) != 0;
                case 13:
                    return t1.C(t5, U) != 0;
                case 14:
                    return t1.E(t5, U) != 0;
                case 15:
                    return t1.C(t5, U) != 0;
                case 16:
                    return t1.E(t5, U) != 0;
                case 17:
                    return t1.G(t5, U) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (t1.C(t5, j5) & (1 << (h02 >>> 20))) != 0;
        }
    }

    private boolean C(T t5, int i5, int i6, int i7, int i8) {
        return i6 == 1048575 ? B(t5, i5) : (i7 & i8) != 0;
    }

    private static boolean D(Object obj, int i5, i1 i1Var) {
        return i1Var.d(t1.G(obj, U(i5)));
    }

    private <N> boolean E(Object obj, int i5, int i6) {
        List list = (List) t1.G(obj, U(i5));
        if (list.isEmpty()) {
            return true;
        }
        i1 u5 = u(i6);
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!u5.d(list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    private boolean F(T t5, int i5, int i6) {
        if (this.f3717q.g(t1.G(t5, U(i5))).isEmpty()) {
            return true;
        }
        this.f3717q.f(t(i6));
        throw null;
    }

    private boolean G(T t5, T t6, int i5) {
        long h02 = (long) (h0(i5) & 1048575);
        return t1.C(t5, h02) == t1.C(t6, h02);
    }

    private boolean H(T t5, int i5, int i6) {
        return t1.C(t5, (long) (h0(i6) & 1048575)) == i5;
    }

    private static boolean I(int i5) {
        return (i5 & 268435456) != 0;
    }

    private static List<?> J(Object obj, long j5) {
        return (List) t1.G(obj, j5);
    }

    private static <T> long K(T t5, long j5) {
        return t1.E(t5, j5);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <UT, UB, ET extends com.google.protobuf.v.b<ET>> void L(com.google.protobuf.p1<UT, UB> r17, com.google.protobuf.r<ET> r18, T r19, com.google.protobuf.h1 r20, com.google.protobuf.q r21) {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.t()     // Catch:{ all -> 0x056b }
            int r3 = r8.f0(r1)     // Catch:{ all -> 0x056b }
            if (r3 >= 0) goto L_0x008e
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.f3711k
        L_0x001e:
            int r1 = r8.f3712l
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.f3710j
            r1 = r1[r0]
            java.lang.Object r13 = r8.p(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.o(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.f3706f     // Catch:{ all -> 0x056b }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            com.google.protobuf.s0 r2 = r8.f3705e     // Catch:{ all -> 0x056b }
            r15 = r18
            java.lang.Object r1 = r15.b(r11, r2, r1)     // Catch:{ all -> 0x056b }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005c
            if (r14 != 0) goto L_0x004d
            com.google.protobuf.v r1 = r18.d(r19)     // Catch:{ all -> 0x056b }
            r14 = r1
        L_0x004d:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.g(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x056b }
            goto L_0x000d
        L_0x005c:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x056b }
            if (r1 == 0) goto L_0x0069
            boolean r1 = r20.F()     // Catch:{ all -> 0x056b }
            if (r1 == 0) goto L_0x0077
            goto L_0x000d
        L_0x0069:
            if (r13 != 0) goto L_0x0070
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x056b }
            r13 = r1
        L_0x0070:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x056b }
            if (r1 == 0) goto L_0x0077
            goto L_0x000d
        L_0x0077:
            int r0 = r8.f3711k
        L_0x0079:
            int r1 = r8.f3712l
            if (r0 >= r1) goto L_0x0088
            int[] r1 = r8.f3710j
            r1 = r1[r0]
            java.lang.Object r13 = r8.p(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0079
        L_0x0088:
            if (r13 == 0) goto L_0x008d
            r9.o(r10, r13)
        L_0x008d:
            return
        L_0x008e:
            r15 = r18
            int r4 = r8.r0(r3)     // Catch:{ all -> 0x056b }
            int r2 = q0(r4)     // Catch:{ a -> 0x0524 }
            switch(r2) {
                case 0: goto L_0x04f9;
                case 1: goto L_0x04ec;
                case 2: goto L_0x04df;
                case 3: goto L_0x04d2;
                case 4: goto L_0x04c5;
                case 5: goto L_0x04b8;
                case 6: goto L_0x04ab;
                case 7: goto L_0x049e;
                case 8: goto L_0x0499;
                case 9: goto L_0x0468;
                case 10: goto L_0x045c;
                case 11: goto L_0x0450;
                case 12: goto L_0x0438;
                case 13: goto L_0x042c;
                case 14: goto L_0x0420;
                case 15: goto L_0x0414;
                case 16: goto L_0x0408;
                case 17: goto L_0x03d1;
                case 18: goto L_0x03c5;
                case 19: goto L_0x03b9;
                case 20: goto L_0x03ad;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0395;
                case 23: goto L_0x0389;
                case 24: goto L_0x037d;
                case 25: goto L_0x0371;
                case 26: goto L_0x036c;
                case 27: goto L_0x035a;
                case 28: goto L_0x034b;
                case 29: goto L_0x033f;
                case 30: goto L_0x032c;
                case 31: goto L_0x0320;
                case 32: goto L_0x0314;
                case 33: goto L_0x0308;
                case 34: goto L_0x02fc;
                case 35: goto L_0x02ed;
                case 36: goto L_0x02de;
                case 37: goto L_0x02cf;
                case 38: goto L_0x02c0;
                case 39: goto L_0x02b1;
                case 40: goto L_0x02a2;
                case 41: goto L_0x0293;
                case 42: goto L_0x0284;
                case 43: goto L_0x0275;
                case 44: goto L_0x025e;
                case 45: goto L_0x024f;
                case 46: goto L_0x0240;
                case 47: goto L_0x0231;
                case 48: goto L_0x0222;
                case 49: goto L_0x020c;
                case 50: goto L_0x01fb;
                case 51: goto L_0x01ea;
                case 52: goto L_0x01d9;
                case 53: goto L_0x01c8;
                case 54: goto L_0x01b7;
                case 55: goto L_0x01a6;
                case 56: goto L_0x0195;
                case 57: goto L_0x0184;
                case 58: goto L_0x0173;
                case 59: goto L_0x016e;
                case 60: goto L_0x0137;
                case 61: goto L_0x012a;
                case 62: goto L_0x011a;
                case 63: goto L_0x00f7;
                case 64: goto L_0x00e7;
                case 65: goto L_0x00d7;
                case 66: goto L_0x00c7;
                case 67: goto L_0x00b7;
                case 68: goto L_0x00a3;
                default: goto L_0x009b;
            }     // Catch:{ a -> 0x0524 }
        L_0x009b:
            if (r13 != 0) goto L_0x0507
            java.lang.Object r1 = r17.n()     // Catch:{ a -> 0x0524 }
            goto L_0x0506
        L_0x00a3:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r2 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            java.lang.Object r2 = r0.A(r2, r11)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
        L_0x00b2:
            r8.o0(r10, r1, r3)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x00b7:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            long r6 = r20.k()     // Catch:{ a -> 0x0524 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x00c7:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            int r2 = r20.h()     // Catch:{ a -> 0x0524 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x00d7:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            long r6 = r20.v()     // Catch:{ a -> 0x0524 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x00e7:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            int r2 = r20.G()     // Catch:{ a -> 0x0524 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x00f7:
            int r2 = r20.b()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.b0$e r5 = r8.s(r3)     // Catch:{ a -> 0x0524 }
            if (r5 == 0) goto L_0x010e
            boolean r5 = r5.a(r2)     // Catch:{ a -> 0x0524 }
            if (r5 == 0) goto L_0x0108
            goto L_0x010e
        L_0x0108:
            java.lang.Object r13 = com.google.protobuf.k1.L(r1, r2, r13, r9)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x010e:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x011a:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            int r2 = r20.D()     // Catch:{ a -> 0x0524 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x012a:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i r2 = r20.B()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x0137:
            boolean r2 = r8.H(r10, r1, r3)     // Catch:{ a -> 0x0524 }
            if (r2 == 0) goto L_0x015a
            long r5 = U(r4)     // Catch:{ a -> 0x0524 }
            java.lang.Object r2 = com.google.protobuf.t1.G(r10, r5)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r5 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            java.lang.Object r5 = r0.w(r5, r11)     // Catch:{ a -> 0x0524 }
            java.lang.Object r2 = com.google.protobuf.b0.h(r2, r5)     // Catch:{ a -> 0x0524 }
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x015a:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r2 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            java.lang.Object r2 = r0.w(r2, r11)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            r8.n0(r10, r3)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x016e:
            r8.k0(r10, r4, r0)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x0173:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            boolean r2 = r20.r()     // Catch:{ a -> 0x0524 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x0184:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            int r2 = r20.p()     // Catch:{ a -> 0x0524 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x0195:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            long r6 = r20.f()     // Catch:{ a -> 0x0524 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x01a6:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            int r2 = r20.E()     // Catch:{ a -> 0x0524 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x01b7:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            long r6 = r20.d()     // Catch:{ a -> 0x0524 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x01c8:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            long r6 = r20.L()     // Catch:{ a -> 0x0524 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x01d9:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            float r2 = r20.readFloat()     // Catch:{ a -> 0x0524 }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x01ea:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            double r6 = r20.readDouble()     // Catch:{ a -> 0x0524 }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x00b2
        L_0x01fb:
            java.lang.Object r4 = r8.t(r3)     // Catch:{ a -> 0x0524 }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.M(r2, r3, r4, r5, r6)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x020c:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r6 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.i0(r2, r3, r5, r6, r7)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0222:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x022c:
            r0.i(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0231:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x023b:
            r0.a(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0240:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x024a:
            r0.K(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x024f:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x0259:
            r0.g(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x025e:
            com.google.protobuf.i0 r2 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ a -> 0x0524 }
            r0.P(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.b0$e r3 = r8.s(r3)     // Catch:{ a -> 0x0524 }
        L_0x026f:
            java.lang.Object r13 = com.google.protobuf.k1.A(r1, r2, r3, r13, r9)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0275:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x027f:
            r0.l(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0284:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x028e:
            r0.n(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0293:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x029d:
            r0.e(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x02a2:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x02ac:
            r0.N(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x02b1:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x02bb:
            r0.O(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x02c0:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x02ca:
            r0.y(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x02cf:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x02d9:
            r0.J(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x02de:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x02e8:
            r0.C(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x02ed:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
        L_0x02f7:
            r0.I(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x02fc:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x022c
        L_0x0308:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x023b
        L_0x0314:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x024a
        L_0x0320:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x0259
        L_0x032c:
            com.google.protobuf.i0 r2 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ a -> 0x0524 }
            r0.P(r2)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.b0$e r3 = r8.s(r3)     // Catch:{ a -> 0x0524 }
            goto L_0x026f
        L_0x033f:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x027f
        L_0x034b:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            r0.H(r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x035a:
            com.google.protobuf.i1 r5 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.j0(r2, r3, r4, r5, r6)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x036c:
            r8.l0(r10, r4, r0)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0371:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x028e
        L_0x037d:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x029d
        L_0x0389:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x02ac
        L_0x0395:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x02bb
        L_0x03a1:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x02ca
        L_0x03ad:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x02d9
        L_0x03b9:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x02e8
        L_0x03c5:
            com.google.protobuf.i0 r1 = r8.f3714n     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x02f7
        L_0x03d1:
            boolean r1 = r8.B(r10, r3)     // Catch:{ a -> 0x0524 }
            if (r1 == 0) goto L_0x03f4
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            java.lang.Object r1 = com.google.protobuf.t1.G(r10, r1)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r2 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            java.lang.Object r2 = r0.A(r2, r11)     // Catch:{ a -> 0x0524 }
            java.lang.Object r1 = com.google.protobuf.b0.h(r1, r2)     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
        L_0x03ef:
            com.google.protobuf.t1.V(r10, r2, r1)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x03f4:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r4 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            java.lang.Object r4 = r0.A(r4, r11)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r1, r4)     // Catch:{ a -> 0x0524 }
        L_0x0403:
            r8.n0(r10, r3)     // Catch:{ a -> 0x0524 }
            goto L_0x000d
        L_0x0408:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            long r4 = r20.k()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.U(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x0414:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            int r4 = r20.h()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.T(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x0420:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            long r4 = r20.v()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.U(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x042c:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            int r4 = r20.G()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.T(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x0438:
            int r2 = r20.b()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.b0$e r5 = r8.s(r3)     // Catch:{ a -> 0x0524 }
            if (r5 == 0) goto L_0x0448
            boolean r5 = r5.a(r2)     // Catch:{ a -> 0x0524 }
            if (r5 == 0) goto L_0x0108
        L_0x0448:
            long r4 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.T(r10, r4, r2)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x0450:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            int r4 = r20.D()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.T(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x045c:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i r4 = r20.B()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x0468:
            boolean r1 = r8.B(r10, r3)     // Catch:{ a -> 0x0524 }
            if (r1 == 0) goto L_0x0488
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            java.lang.Object r1 = com.google.protobuf.t1.G(r10, r1)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r2 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            java.lang.Object r2 = r0.w(r2, r11)     // Catch:{ a -> 0x0524 }
            java.lang.Object r1 = com.google.protobuf.b0.h(r1, r2)     // Catch:{ a -> 0x0524 }
            long r2 = U(r4)     // Catch:{ a -> 0x0524 }
            goto L_0x03ef
        L_0x0488:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.i1 r4 = r8.u(r3)     // Catch:{ a -> 0x0524 }
            java.lang.Object r4 = r0.w(r4, r11)     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.V(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x0499:
            r8.k0(r10, r4, r0)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x049e:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            boolean r4 = r20.r()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.L(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x04ab:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            int r4 = r20.p()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.T(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x04b8:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            long r4 = r20.f()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.U(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x04c5:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            int r4 = r20.E()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.T(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x04d2:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            long r4 = r20.d()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.U(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x04df:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            long r4 = r20.L()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.U(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x04ec:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            float r4 = r20.readFloat()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.S(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x04f9:
            long r1 = U(r4)     // Catch:{ a -> 0x0524 }
            double r4 = r20.readDouble()     // Catch:{ a -> 0x0524 }
            com.google.protobuf.t1.R(r10, r1, r4)     // Catch:{ a -> 0x0524 }
            goto L_0x0403
        L_0x0506:
            r13 = r1
        L_0x0507:
            boolean r1 = r9.m(r13, r0)     // Catch:{ a -> 0x0524 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f3711k
        L_0x050f:
            int r1 = r8.f3712l
            if (r0 >= r1) goto L_0x051e
            int[] r1 = r8.f3710j
            r1 = r1[r0]
            java.lang.Object r13 = r8.p(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x050f
        L_0x051e:
            if (r13 == 0) goto L_0x0523
            r9.o(r10, r13)
        L_0x0523:
            return
        L_0x0524:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x056b }
            if (r1 == 0) goto L_0x0547
            boolean r1 = r20.F()     // Catch:{ all -> 0x056b }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f3711k
        L_0x0532:
            int r1 = r8.f3712l
            if (r0 >= r1) goto L_0x0541
            int[] r1 = r8.f3710j
            r1 = r1[r0]
            java.lang.Object r13 = r8.p(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0532
        L_0x0541:
            if (r13 == 0) goto L_0x0546
            r9.o(r10, r13)
        L_0x0546:
            return
        L_0x0547:
            if (r13 != 0) goto L_0x054e
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x056b }
            r13 = r1
        L_0x054e:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x056b }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f3711k
        L_0x0556:
            int r1 = r8.f3712l
            if (r0 >= r1) goto L_0x0565
            int[] r1 = r8.f3710j
            r1 = r1[r0]
            java.lang.Object r13 = r8.p(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0556
        L_0x0565:
            if (r13 == 0) goto L_0x056a
            r9.o(r10, r13)
        L_0x056a:
            return
        L_0x056b:
            r0 = move-exception
            int r1 = r8.f3711k
        L_0x056e:
            int r2 = r8.f3712l
            if (r1 >= r2) goto L_0x057d
            int[] r2 = r8.f3710j
            r2 = r2[r1]
            java.lang.Object r13 = r8.p(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x056e
        L_0x057d:
            if (r13 == 0) goto L_0x0582
            r9.o(r10, r13)
        L_0x0582:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.L(com.google.protobuf.p1, com.google.protobuf.r, java.lang.Object, com.google.protobuf.h1, com.google.protobuf.q):void");
    }

    private final <K, V> void M(Object obj, int i5, Object obj2, q qVar, h1 h1Var) {
        long U = U(r0(i5));
        Object G = t1.G(obj, U);
        if (G == null) {
            G = this.f3717q.b(obj2);
            t1.V(obj, U, G);
        } else if (this.f3717q.d(G)) {
            Object b5 = this.f3717q.b(obj2);
            this.f3717q.a(b5, G);
            t1.V(obj, U, b5);
            G = b5;
        }
        Map<?, ?> h5 = this.f3717q.h(G);
        this.f3717q.f(obj2);
        h1Var.x(h5, (l0.a) null, qVar);
    }

    private void N(T t5, T t6, int i5) {
        long U = U(r0(i5));
        if (B(t6, i5)) {
            Object G = t1.G(t5, U);
            Object G2 = t1.G(t6, U);
            if (G != null && G2 != null) {
                G2 = b0.h(G, G2);
            } else if (G2 == null) {
                return;
            }
            t1.V(t5, U, G2);
            n0(t5, i5);
        }
    }

    private void O(T t5, T t6, int i5) {
        int r02 = r0(i5);
        int T = T(i5);
        long U = U(r02);
        if (H(t6, T, i5)) {
            Object obj = null;
            if (H(t5, T, i5)) {
                obj = t1.G(t5, U);
            }
            Object G = t1.G(t6, U);
            if (obj != null && G != null) {
                G = b0.h(obj, G);
            } else if (G == null) {
                return;
            }
            t1.V(t5, U, G);
            o0(t5, T, i5);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        com.google.protobuf.t1.V(r6, r1, com.google.protobuf.t1.G(r7, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a9, code lost:
        com.google.protobuf.t1.T(r6, r1, com.google.protobuf.t1.C(r7, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00be, code lost:
        com.google.protobuf.t1.U(r6, r1, com.google.protobuf.t1.E(r7, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e1, code lost:
        n0(r6, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        com.google.protobuf.t1.V(r6, r1, com.google.protobuf.t1.G(r7, r1));
        o0(r6, r3, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void P(T r6, T r7, int r8) {
        /*
            r5 = this;
            int r0 = r5.r0(r8)
            long r1 = U(r0)
            int r3 = r5.T(r8)
            int r0 = q0(r0)
            switch(r0) {
                case 0: goto L_0x00d4;
                case 1: goto L_0x00c6;
                case 2: goto L_0x00b8;
                case 3: goto L_0x00b1;
                case 4: goto L_0x00a3;
                case 5: goto L_0x009c;
                case 6: goto L_0x0095;
                case 7: goto L_0x0087;
                case 8: goto L_0x0079;
                case 9: goto L_0x0074;
                case 10: goto L_0x006d;
                case 11: goto L_0x0066;
                case 12: goto L_0x005f;
                case 13: goto L_0x0058;
                case 14: goto L_0x0050;
                case 15: goto L_0x0049;
                case 16: goto L_0x0041;
                case 17: goto L_0x0074;
                case 18: goto L_0x003a;
                case 19: goto L_0x003a;
                case 20: goto L_0x003a;
                case 21: goto L_0x003a;
                case 22: goto L_0x003a;
                case 23: goto L_0x003a;
                case 24: goto L_0x003a;
                case 25: goto L_0x003a;
                case 26: goto L_0x003a;
                case 27: goto L_0x003a;
                case 28: goto L_0x003a;
                case 29: goto L_0x003a;
                case 30: goto L_0x003a;
                case 31: goto L_0x003a;
                case 32: goto L_0x003a;
                case 33: goto L_0x003a;
                case 34: goto L_0x003a;
                case 35: goto L_0x003a;
                case 36: goto L_0x003a;
                case 37: goto L_0x003a;
                case 38: goto L_0x003a;
                case 39: goto L_0x003a;
                case 40: goto L_0x003a;
                case 41: goto L_0x003a;
                case 42: goto L_0x003a;
                case 43: goto L_0x003a;
                case 44: goto L_0x003a;
                case 45: goto L_0x003a;
                case 46: goto L_0x003a;
                case 47: goto L_0x003a;
                case 48: goto L_0x003a;
                case 49: goto L_0x003a;
                case 50: goto L_0x0033;
                case 51: goto L_0x0021;
                case 52: goto L_0x0021;
                case 53: goto L_0x0021;
                case 54: goto L_0x0021;
                case 55: goto L_0x0021;
                case 56: goto L_0x0021;
                case 57: goto L_0x0021;
                case 58: goto L_0x0021;
                case 59: goto L_0x0021;
                case 60: goto L_0x001c;
                case 61: goto L_0x0015;
                case 62: goto L_0x0015;
                case 63: goto L_0x0015;
                case 64: goto L_0x0015;
                case 65: goto L_0x0015;
                case 66: goto L_0x0015;
                case 67: goto L_0x0015;
                case 68: goto L_0x001c;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x00e4
        L_0x0015:
            boolean r0 = r5.H(r7, r3, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x0027
        L_0x001c:
            r5.O(r6, r7, r8)
            goto L_0x00e4
        L_0x0021:
            boolean r0 = r5.H(r7, r3, r8)
            if (r0 == 0) goto L_0x00e4
        L_0x0027:
            java.lang.Object r7 = com.google.protobuf.t1.G(r7, r1)
            com.google.protobuf.t1.V(r6, r1, r7)
            r5.o0(r6, r3, r8)
            goto L_0x00e4
        L_0x0033:
            com.google.protobuf.n0 r8 = r5.f3717q
            com.google.protobuf.k1.F(r8, r6, r7, r1)
            goto L_0x00e4
        L_0x003a:
            com.google.protobuf.i0 r8 = r5.f3714n
            r8.d(r6, r7, r1)
            goto L_0x00e4
        L_0x0041:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x00be
        L_0x0049:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x0065
        L_0x0050:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x00be
        L_0x0058:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x0065
        L_0x005f:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
        L_0x0065:
            goto L_0x00a9
        L_0x0066:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x00a9
        L_0x006d:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x007f
        L_0x0074:
            r5.N(r6, r7, r8)
            goto L_0x00e4
        L_0x0079:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
        L_0x007f:
            java.lang.Object r7 = com.google.protobuf.t1.G(r7, r1)
            com.google.protobuf.t1.V(r6, r1, r7)
            goto L_0x00e1
        L_0x0087:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            boolean r7 = com.google.protobuf.t1.t(r7, r1)
            com.google.protobuf.t1.L(r6, r1, r7)
            goto L_0x00e1
        L_0x0095:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x00a9
        L_0x009c:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x00be
        L_0x00a3:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
        L_0x00a9:
            int r7 = com.google.protobuf.t1.C(r7, r1)
            com.google.protobuf.t1.T(r6, r1, r7)
            goto L_0x00e1
        L_0x00b1:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            goto L_0x00be
        L_0x00b8:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
        L_0x00be:
            long r3 = com.google.protobuf.t1.E(r7, r1)
            com.google.protobuf.t1.U(r6, r1, r3)
            goto L_0x00e1
        L_0x00c6:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            float r7 = com.google.protobuf.t1.B(r7, r1)
            com.google.protobuf.t1.S(r6, r1, r7)
            goto L_0x00e1
        L_0x00d4:
            boolean r0 = r5.B(r7, r8)
            if (r0 == 0) goto L_0x00e4
            double r3 = com.google.protobuf.t1.A(r7, r1)
            com.google.protobuf.t1.R(r6, r1, r3)
        L_0x00e1:
            r5.n0(r6, r8)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.P(java.lang.Object, java.lang.Object, int):void");
    }

    static <T> v0<T> Q(Class<T> cls, q0 q0Var, x0 x0Var, i0 i0Var, p1<?, ?> p1Var, r<?> rVar, n0 n0Var) {
        return q0Var instanceof g1 ? S((g1) q0Var, x0Var, i0Var, p1Var, rVar, n0Var) : R((m1) q0Var, x0Var, i0Var, p1Var, rVar, n0Var);
    }

    static <T> v0<T> R(m1 m1Var, x0 x0Var, i0 i0Var, p1<?, ?> p1Var, r<?> rVar, n0 n0Var) {
        boolean z4 = m1Var.b() == d1.PROTO3;
        u[] e5 = m1Var.e();
        if (e5.length == 0) {
            int length = e5.length;
            int[] iArr = new int[(length * 3)];
            Object[] objArr = new Object[(length * 2)];
            if (e5.length <= 0) {
                int[] d5 = m1Var.d();
                if (d5 == null) {
                    d5 = f3699r;
                }
                if (e5.length <= 0) {
                    int[] iArr2 = f3699r;
                    int[] iArr3 = f3699r;
                    int[] iArr4 = new int[(d5.length + iArr2.length + iArr3.length)];
                    System.arraycopy(d5, 0, iArr4, 0, d5.length);
                    System.arraycopy(iArr2, 0, iArr4, d5.length, iArr2.length);
                    System.arraycopy(iArr3, 0, iArr4, d5.length + iArr2.length, iArr3.length);
                    return new v0(iArr, objArr, 0, 0, m1Var.c(), z4, true, iArr4, d5.length, d5.length + iArr2.length, x0Var, i0Var, p1Var, rVar, n0Var);
                }
                u uVar = e5[0];
                throw null;
            }
            u uVar2 = e5[0];
            throw null;
        }
        u uVar3 = e5[0];
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x036d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.protobuf.v0<T> S(com.google.protobuf.g1 r34, com.google.protobuf.x0 r35, com.google.protobuf.i0 r36, com.google.protobuf.p1<?, ?> r37, com.google.protobuf.r<?> r38, com.google.protobuf.n0 r39) {
        /*
            com.google.protobuf.d1 r0 = r34.b()
            com.google.protobuf.d1 r1 = com.google.protobuf.d1.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = r2
        L_0x000c:
            java.lang.String r0 = r34.e()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0028
            r4 = 1
        L_0x001e:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0029
            r4 = r6
            goto L_0x001e
        L_0x0028:
            r6 = 1
        L_0x0029:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0048
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0035:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0045
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0035
        L_0x0045:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0048:
            if (r6 != 0) goto L_0x0058
            int[] r6 = f3699r
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0162
        L_0x0058:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0077
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0064:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0074
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0064
        L_0x0074:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0077:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0096
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0083:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0093
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0083
        L_0x0093:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0096:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b5
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a2:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a2
        L_0x00b2:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b5:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c1:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c1
        L_0x00d1:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d4:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f3
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00e0:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00f0
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00e0
        L_0x00f0:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f3:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0112
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ff:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010f
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ff
        L_0x010f:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0112:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0133
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011e:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012f
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011e
        L_0x012f:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0133:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0156
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013f:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0151
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013f
        L_0x0151:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0156:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 * 2
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
        L_0x0162:
            sun.misc.Unsafe r15 = f3700s
            java.lang.Object[] r17 = r34.d()
            com.google.protobuf.s0 r18 = r34.c()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 * 2
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r20 = r14 + r12
            r22 = r14
            r23 = r20
            r12 = 0
            r21 = 0
        L_0x0181:
            if (r4 >= r1) goto L_0x03bd
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01a9
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0191:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a3
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0191
        L_0x01a3:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ab
        L_0x01a9:
            r3 = r24
        L_0x01ab:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01d8
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01b9:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d2
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01b9
        L_0x01d2:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01dc
        L_0x01d8:
            r28 = r1
            r1 = r24
        L_0x01dc:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01e9
            int r14 = r12 + 1
            r13[r12] = r21
            r12 = r14
        L_0x01e9:
            r14 = 51
            r30 = r12
            if (r5 < r14) goto L_0x0286
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0218
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x01fe:
            int r33 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r12) goto L_0x0213
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r32
            r1 = r1 | r12
            int r32 = r32 + 13
            r14 = r33
            r12 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01fe
        L_0x0213:
            int r12 = r14 << r32
            r1 = r1 | r12
            r14 = r33
        L_0x0218:
            int r12 = r5 + -51
            r32 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0238
            r14 = 17
            if (r12 != r14) goto L_0x0225
            goto L_0x0238
        L_0x0225:
            r14 = 12
            if (r12 != r14) goto L_0x0246
            if (r10 != 0) goto L_0x0246
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0244
        L_0x0238:
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0244:
            r16 = r14
        L_0x0246:
            int r1 = r1 * 2
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0251
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0259
        L_0x0251:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = m0(r2, r12)
            r17[r1] = r12
        L_0x0259:
            r14 = r8
            r33 = r9
            long r8 = r15.objectFieldOffset(r12)
            int r8 = (int) r8
            int r1 = r1 + 1
            r9 = r17[r1]
            boolean r12 = r9 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x026c
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0274
        L_0x026c:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = m0(r2, r9)
            r17[r1] = r9
        L_0x0274:
            r1 = r8
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r31 = r0
            r9 = r8
            r0 = r10
            r29 = r32
            r25 = 1
            r8 = r1
            r1 = 0
            goto L_0x0386
        L_0x0286:
            r14 = r8
            r33 = r9
            int r8 = r16 + 1
            r9 = r17[r16]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = m0(r2, r9)
            r12 = 9
            if (r5 == r12) goto L_0x02fe
            r12 = 17
            if (r5 != r12) goto L_0x029c
            goto L_0x02fe
        L_0x029c:
            r12 = 27
            if (r5 == r12) goto L_0x02ed
            r12 = 49
            if (r5 != r12) goto L_0x02a5
            goto L_0x02ed
        L_0x02a5:
            r12 = 12
            if (r5 == r12) goto L_0x02dc
            r12 = 30
            if (r5 == r12) goto L_0x02dc
            r12 = 44
            if (r5 != r12) goto L_0x02b2
            goto L_0x02dc
        L_0x02b2:
            r12 = 50
            if (r5 != r12) goto L_0x02d2
            int r12 = r22 + 1
            r13[r22] = r21
            int r22 = r21 / 3
            int r22 = r22 * 2
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r22] = r8
            r8 = r3 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02d5
            int r22 = r22 + 1
            int r8 = r27 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02d2:
            r25 = 1
            goto L_0x030c
        L_0x02d5:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x030d
        L_0x02dc:
            if (r10 != 0) goto L_0x02d2
            int r12 = r21 / 3
            int r12 = r12 * 2
            r25 = 1
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
            goto L_0x02fb
        L_0x02ed:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
        L_0x02fb:
            r12 = r27
            goto L_0x030d
        L_0x02fe:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            java.lang.Class r27 = r9.getType()
            r11[r12] = r27
        L_0x030c:
            r12 = r8
        L_0x030d:
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r9 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = r12
            r12 = 4096(0x1000, float:5.74E-42)
            if (r9 != r12) goto L_0x031d
            r9 = r25
            goto L_0x031e
        L_0x031d:
            r9 = 0
        L_0x031e:
            if (r9 == 0) goto L_0x036d
            r9 = 17
            if (r5 > r9) goto L_0x036d
            int r9 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0349
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x0333:
            int r29 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r12) goto L_0x0345
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r26
            r1 = r1 | r9
            int r26 = r26 + 13
            r9 = r29
            goto L_0x0333
        L_0x0345:
            int r9 = r9 << r26
            r1 = r1 | r9
            goto L_0x034b
        L_0x0349:
            r29 = r9
        L_0x034b:
            int r9 = r6 * 2
            int r26 = r1 / 32
            int r9 = r9 + r26
            r12 = r17[r9]
            r31 = r0
            boolean r0 = r12 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x035c
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0364
        L_0x035c:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = m0(r2, r12)
            r17[r9] = r12
        L_0x0364:
            r0 = r10
            long r9 = r15.objectFieldOffset(r12)
            int r9 = (int) r9
            int r1 = r1 % 32
            goto L_0x0376
        L_0x036d:
            r31 = r0
            r0 = r10
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r1
            r1 = 0
        L_0x0376:
            r10 = 18
            if (r5 < r10) goto L_0x0384
            r10 = 49
            if (r5 > r10) goto L_0x0384
            int r10 = r23 + 1
            r13[r23] = r8
            r23 = r10
        L_0x0384:
            r16 = r27
        L_0x0386:
            int r10 = r21 + 1
            r7[r21] = r4
            int r4 = r10 + 1
            r12 = r3 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0393
            r12 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0394
        L_0x0393:
            r12 = 0
        L_0x0394:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x039b
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039c
        L_0x039b:
            r3 = 0
        L_0x039c:
            r3 = r3 | r12
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r8
            r7[r10] = r3
            int r21 = r4 + 1
            int r1 = r1 << 20
            r1 = r1 | r9
            r7[r4] = r1
            r10 = r0
            r8 = r14
            r14 = r24
            r1 = r28
            r4 = r29
            r12 = r30
            r0 = r31
            r9 = r33
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0181
        L_0x03bd:
            r33 = r9
            r0 = r10
            r24 = r14
            r14 = r8
            com.google.protobuf.v0 r1 = new com.google.protobuf.v0
            com.google.protobuf.s0 r9 = r34.c()
            r2 = 0
            r4 = r1
            r5 = r7
            r6 = r11
            r7 = r14
            r8 = r33
            r11 = r2
            r12 = r13
            r13 = r24
            r14 = r20
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.S(com.google.protobuf.g1, com.google.protobuf.x0, com.google.protobuf.i0, com.google.protobuf.p1, com.google.protobuf.r, com.google.protobuf.n0):com.google.protobuf.v0");
    }

    private int T(int i5) {
        return this.f3701a[i5];
    }

    private static long U(int i5) {
        return (long) (i5 & 1048575);
    }

    private static <T> boolean V(T t5, long j5) {
        return ((Boolean) t1.G(t5, j5)).booleanValue();
    }

    private static <T> double W(T t5, long j5) {
        return ((Double) t1.G(t5, j5)).doubleValue();
    }

    private static <T> float X(T t5, long j5) {
        return ((Float) t1.G(t5, j5)).floatValue();
    }

    private static <T> int Y(T t5, long j5) {
        return ((Integer) t1.G(t5, j5)).intValue();
    }

    private static <T> long Z(T t5, long j5) {
        return ((Long) t1.G(t5, j5)).longValue();
    }

    private <K, V> int a0(T t5, byte[] bArr, int i5, int i6, int i7, long j5, e.b bVar) {
        T t6 = t5;
        long j6 = j5;
        Unsafe unsafe = f3700s;
        int i8 = i7;
        Object t7 = t(i7);
        Object object = unsafe.getObject(t5, j6);
        if (this.f3717q.d(object)) {
            Object b5 = this.f3717q.b(t7);
            this.f3717q.a(b5, object);
            unsafe.putObject(t5, j6, b5);
            object = b5;
        }
        this.f3717q.f(t7);
        return m(bArr, i5, i6, (l0.a) null, this.f3717q.h(object), bVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0134, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0141, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0153, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0164, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b0(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.protobuf.e.b r29) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = f3700s
            int[] r7 = r0.f3701a
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0159;
                case 52: goto L_0x0149;
                case 53: goto L_0x0139;
                case 54: goto L_0x0139;
                case 55: goto L_0x012c;
                case 56: goto L_0x0120;
                case 57: goto L_0x0115;
                case 58: goto L_0x00ff;
                case 59: goto L_0x00d1;
                case 60: goto L_0x00ad;
                case 61: goto L_0x00a3;
                case 62: goto L_0x012c;
                case 63: goto L_0x0074;
                case 64: goto L_0x0115;
                case 65: goto L_0x0120;
                case 66: goto L_0x0066;
                case 67: goto L_0x0058;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x016d
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x016d
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.protobuf.i1 r2 = r0.u(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.protobuf.e.n(r2, r3, r4, r5, r6, r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            java.lang.Object r3 = r11.f3500c
            if (r15 != 0) goto L_0x0052
            goto L_0x0145
        L_0x0052:
            java.lang.Object r3 = com.google.protobuf.b0.h(r15, r3)
            goto L_0x0145
        L_0x0058:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.protobuf.e.L(r3, r4, r11)
            long r3 = r11.f3499b
            long r3 = com.google.protobuf.j.c(r3)
            goto L_0x0141
        L_0x0066:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.protobuf.e.I(r3, r4, r11)
            int r3 = r11.f3498a
            int r3 = com.google.protobuf.j.b(r3)
            goto L_0x0134
        L_0x0074:
            if (r5 != 0) goto L_0x016d
            int r3 = com.google.protobuf.e.I(r3, r4, r11)
            int r4 = r11.f3498a
            com.google.protobuf.b0$e r5 = r0.s(r6)
            if (r5 == 0) goto L_0x0096
            boolean r5 = r5.a(r4)
            if (r5 == 0) goto L_0x0089
            goto L_0x0096
        L_0x0089:
            com.google.protobuf.q1 r1 = v(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.q(r2, r4)
            goto L_0x00a0
        L_0x0096:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
        L_0x00a0:
            r2 = r3
            goto L_0x016e
        L_0x00a3:
            if (r5 != r15) goto L_0x016d
            int r2 = com.google.protobuf.e.b(r3, r4, r11)
            java.lang.Object r3 = r11.f3500c
            goto L_0x0145
        L_0x00ad:
            if (r5 != r15) goto L_0x016d
            com.google.protobuf.i1 r2 = r0.u(r6)
            r5 = r20
            int r2 = com.google.protobuf.e.p(r2, r3, r4, r5, r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00c4
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00c5
        L_0x00c4:
            r15 = 0
        L_0x00c5:
            java.lang.Object r3 = r11.f3500c
            if (r15 != 0) goto L_0x00cb
            goto L_0x0145
        L_0x00cb:
            java.lang.Object r3 = com.google.protobuf.b0.h(r15, r3)
            goto L_0x0145
        L_0x00d1:
            if (r5 != r15) goto L_0x016d
            int r2 = com.google.protobuf.e.I(r3, r4, r11)
            int r4 = r11.f3498a
            if (r4 != 0) goto L_0x00de
            java.lang.String r3 = ""
            goto L_0x0145
        L_0x00de:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x00f2
            int r5 = r2 + r4
            boolean r5 = com.google.protobuf.u1.t(r3, r2, r5)
            if (r5 == 0) goto L_0x00ed
            goto L_0x00f2
        L_0x00ed:
            com.google.protobuf.c0 r1 = com.google.protobuf.c0.d()
            throw r1
        L_0x00f2:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.protobuf.b0.f3469a
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
            goto L_0x0169
        L_0x00ff:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.protobuf.e.L(r3, r4, r11)
            long r3 = r11.f3499b
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x010f
            r15 = 1
            goto L_0x0110
        L_0x010f:
            r15 = 0
        L_0x0110:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x0145
        L_0x0115:
            if (r5 != r7) goto L_0x016d
            int r2 = com.google.protobuf.e.h(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0153
        L_0x0120:
            r2 = 1
            if (r5 != r2) goto L_0x016d
            long r2 = com.google.protobuf.e.j(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0164
        L_0x012c:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.protobuf.e.I(r3, r4, r11)
            int r3 = r11.f3498a
        L_0x0134:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0145
        L_0x0139:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.protobuf.e.L(r3, r4, r11)
            long r3 = r11.f3499b
        L_0x0141:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0145:
            r12.putObject(r1, r9, r3)
            goto L_0x0169
        L_0x0149:
            if (r5 != r7) goto L_0x016d
            float r2 = com.google.protobuf.e.l(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x0153:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x0169
        L_0x0159:
            r2 = 1
            if (r5 != r2) goto L_0x016d
            double r2 = com.google.protobuf.e.d(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
        L_0x0164:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x0169:
            r12.putInt(r1, r13, r8)
            goto L_0x016e
        L_0x016d:
            r2 = r4
        L_0x016e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.b0(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.protobuf.e$b):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0278, code lost:
        if (r0 != r15) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02c1, code lost:
        if (r0 != r15) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02e2, code lost:
        if (r0 != r15) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02e5, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cf, code lost:
        if (r3 == 0) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012c, code lost:
        r10.putObject(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0160, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r1 = r19;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x018e, code lost:
        if (r3 == 0) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0190, code lost:
        r0 = com.google.protobuf.e.I(r12, r4, r11);
        r1 = r11.f3498a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0196, code lost:
        r10.putInt(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ac, code lost:
        r0.putLong(r1, r2, r4);
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01da, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01dd, code lost:
        r2 = r4;
        r28 = r10;
        r20 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int d0(T r31, byte[] r32, int r33, int r34, com.google.protobuf.e.b r35) {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = f3700s
            r10 = -1
            r16 = 0
            r0 = r33
            r1 = r10
            r2 = r16
            r6 = r2
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0018:
            if (r0 >= r13) goto L_0x030b
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.protobuf.e.H(r0, r12, r3, r11)
            int r3 = r11.f3498a
            r4 = r0
            r17 = r3
            goto L_0x002d
        L_0x002a:
            r17 = r0
            r4 = r3
        L_0x002d:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003a
            int r2 = r2 / 3
            int r0 = r15.g0(r5, r2)
            goto L_0x003e
        L_0x003a:
            int r0 = r15.f0(r5)
        L_0x003e:
            r2 = r0
            if (r2 != r10) goto L_0x004c
            r2 = r4
            r19 = r5
            r28 = r9
            r18 = r10
            r20 = r16
            goto L_0x02e7
        L_0x004c:
            int[] r0 = r15.f3701a
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = q0(r1)
            r18 = r9
            long r8 = U(r1)
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x01e6
            int[] r10 = r15.f3701a
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            r23 = r1
            r19 = r2
            if (r10 == r7) goto L_0x0090
            if (r7 == r13) goto L_0x0080
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0082
        L_0x0080:
            r7 = r18
        L_0x0082:
            if (r10 == r13) goto L_0x008a
            long r1 = (long) r10
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008a:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0092
        L_0x0090:
            r10 = r18
        L_0x0092:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01c9;
                case 1: goto L_0x01b7;
                case 2: goto L_0x019a;
                case 3: goto L_0x019a;
                case 4: goto L_0x0188;
                case 5: goto L_0x016d;
                case 6: goto L_0x014d;
                case 7: goto L_0x0130;
                case 8: goto L_0x0110;
                case 9: goto L_0x00e5;
                case 10: goto L_0x00d3;
                case 11: goto L_0x0188;
                case 12: goto L_0x00cb;
                case 13: goto L_0x014d;
                case 14: goto L_0x016d;
                case 15: goto L_0x00b9;
                case 16: goto L_0x009e;
                default: goto L_0x0096;
            }
        L_0x0096:
            r18 = r13
            r13 = r19
            r19 = r33
            goto L_0x01dd
        L_0x009e:
            if (r3 != 0) goto L_0x00b4
            int r17 = com.google.protobuf.e.L(r12, r4, r11)
            long r0 = r11.f3499b
            long r4 = com.google.protobuf.j.c(r0)
            r0 = r10
            r1 = r31
            r13 = r19
            r2 = r8
            r19 = r33
            goto L_0x01ac
        L_0x00b4:
            r13 = r19
            r19 = r33
            goto L_0x010b
        L_0x00b9:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x010b
            int r0 = com.google.protobuf.e.I(r12, r4, r11)
            int r1 = r11.f3498a
            int r1 = com.google.protobuf.j.b(r1)
            goto L_0x0196
        L_0x00cb:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x010b
            goto L_0x0190
        L_0x00d3:
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x010b
            int r0 = com.google.protobuf.e.b(r12, r4, r11)
            java.lang.Object r1 = r11.f3500c
            r10.putObject(r14, r8, r1)
            goto L_0x01da
        L_0x00e5:
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x0109
            com.google.protobuf.i1 r0 = r15.u(r13)
            r2 = r34
            r18 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.protobuf.e.p(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0102
            java.lang.Object r1 = r11.f3500c
            goto L_0x012c
        L_0x0102:
            java.lang.Object r3 = r11.f3500c
            java.lang.Object r1 = com.google.protobuf.b0.h(r1, r3)
            goto L_0x012c
        L_0x0109:
            r2 = r34
        L_0x010b:
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x01dd
        L_0x0110:
            r2 = r34
            r18 = r13
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x01dd
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0126
            int r0 = com.google.protobuf.e.C(r12, r4, r11)
            goto L_0x012a
        L_0x0126:
            int r0 = com.google.protobuf.e.F(r12, r4, r11)
        L_0x012a:
            java.lang.Object r1 = r11.f3500c
        L_0x012c:
            r10.putObject(r14, r8, r1)
            goto L_0x0160
        L_0x0130:
            r2 = r34
            r18 = r13
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01dd
            int r0 = com.google.protobuf.e.L(r12, r4, r11)
            long r3 = r11.f3499b
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x0147
            goto L_0x0149
        L_0x0147:
            r5 = r16
        L_0x0149:
            com.google.protobuf.t1.L(r14, r8, r5)
            goto L_0x0160
        L_0x014d:
            r2 = r34
            r18 = r13
            r13 = r19
            r19 = r33
            if (r3 != r1) goto L_0x01dd
            int r0 = com.google.protobuf.e.h(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x0160:
            r6 = r6 | r21
            r9 = r10
            r1 = r19
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0018
        L_0x016d:
            r2 = r34
            r18 = r13
            r13 = r19
            r19 = r33
            if (r3 != r5) goto L_0x01dd
            long r22 = com.google.protobuf.e.j(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x01da
        L_0x0188:
            r18 = r13
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01dd
        L_0x0190:
            int r0 = com.google.protobuf.e.I(r12, r4, r11)
            int r1 = r11.f3498a
        L_0x0196:
            r10.putInt(r14, r8, r1)
            goto L_0x01da
        L_0x019a:
            r18 = r13
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01dd
            int r17 = com.google.protobuf.e.L(r12, r4, r11)
            long r4 = r11.f3499b
            r0 = r10
            r1 = r31
            r2 = r8
        L_0x01ac:
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x022b
        L_0x01b7:
            r18 = r13
            r13 = r19
            r19 = r33
            if (r3 != r1) goto L_0x01dd
            float r0 = com.google.protobuf.e.l(r12, r4)
            com.google.protobuf.t1.S(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x01da
        L_0x01c9:
            r18 = r13
            r13 = r19
            r19 = r33
            if (r3 != r5) goto L_0x01dd
            double r0 = com.google.protobuf.e.d(r12, r4)
            com.google.protobuf.t1.R(r14, r8, r0)
            int r0 = r4 + 8
        L_0x01da:
            r6 = r6 | r21
            goto L_0x0229
        L_0x01dd:
            r2 = r4
            r28 = r10
            r20 = r13
            r18 = -1
            goto L_0x02e7
        L_0x01e6:
            r19 = r33
            r23 = r1
            r13 = r2
            r10 = r18
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x023f
            r1 = 2
            if (r3 != r1) goto L_0x0232
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.protobuf.b0$i r0 = (com.google.protobuf.b0.i) r0
            boolean r1 = r0.k()
            if (r1 != 0) goto L_0x0215
            int r1 = r0.size()
            if (r1 != 0) goto L_0x020c
            r1 = 10
            goto L_0x020e
        L_0x020c:
            int r1 = r1 * 2
        L_0x020e:
            com.google.protobuf.b0$i r0 = r0.a(r1)
            r10.putObject(r14, r8, r0)
        L_0x0215:
            r5 = r0
            com.google.protobuf.i1 r0 = r15.u(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.protobuf.e.q(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0229:
            r9 = r10
            r2 = r13
        L_0x022b:
            r1 = r19
            r10 = -1
            r13 = r34
            goto L_0x0018
        L_0x0232:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r20 = r13
            r18 = -1
            goto L_0x02c4
        L_0x023f:
            r1 = 49
            if (r0 > r1) goto L_0x0290
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r19
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = r18
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r20 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.e0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02e5
        L_0x027a:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r1 = r19
            r2 = r20
            r6 = r24
            r7 = r25
            goto L_0x0307
        L_0x0290:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r20 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            r7 = r33
            if (r9 != r0) goto L_0x02ca
            r0 = 2
            if (r7 != r0) goto L_0x02c4
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r20
            r6 = r26
            r8 = r35
            int r0 = r0.a0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02e5
            goto L_0x027a
        L_0x02c4:
            r2 = r15
        L_0x02c5:
            r6 = r24
            r7 = r25
            goto L_0x02e7
        L_0x02ca:
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r19
            r10 = r26
            r12 = r20
            r13 = r35
            int r0 = r0.b0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02e5
            goto L_0x027a
        L_0x02e5:
            r2 = r0
            goto L_0x02c5
        L_0x02e7:
            com.google.protobuf.q1 r4 = v(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.protobuf.e.G(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r1 = r19
            r2 = r20
        L_0x0307:
            r9 = r28
            goto L_0x0018
        L_0x030b:
            r24 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x031e
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x031e:
            r1 = r34
            if (r0 != r1) goto L_0x0323
            return r0
        L_0x0323:
            com.google.protobuf.c0 r0 = com.google.protobuf.c0.h()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.d0(java.lang.Object, byte[], int, int, com.google.protobuf.e$b):int");
    }

    private int e0(T t5, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, long j5, int i11, long j6, e.b bVar) {
        int i12;
        T t6 = t5;
        byte[] bArr2 = bArr;
        int i13 = i5;
        int i14 = i9;
        int i15 = i10;
        long j7 = j6;
        e.b bVar2 = bVar;
        Unsafe unsafe = f3700s;
        b0.i iVar = (b0.i) unsafe.getObject(t5, j7);
        if (!iVar.k()) {
            int size = iVar.size();
            iVar = iVar.a(size == 0 ? 10 : size * 2);
            unsafe.putObject(t5, j7, iVar);
        }
        switch (i11) {
            case 18:
            case R.styleable.AppCompatTheme_alertDialogButtonGroupStyle:
                if (i14 == 2) {
                    return e.s(bArr, i13, iVar, bVar2);
                }
                if (i14 == 1) {
                    return e.e(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 19:
            case R.styleable.AppCompatTheme_alertDialogCenterButtons:
                if (i14 == 2) {
                    return e.v(bArr, i13, iVar, bVar2);
                }
                if (i14 == 5) {
                    return e.m(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 20:
            case 21:
            case R.styleable.AppCompatTheme_alertDialogStyle:
            case R.styleable.AppCompatTheme_alertDialogTheme:
                if (i14 == 2) {
                    return e.z(bArr, i13, iVar, bVar2);
                }
                if (i14 == 0) {
                    return e.M(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 22:
            case 29:
            case R.styleable.AppCompatTheme_autoCompleteTextViewStyle:
            case R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle:
                if (i14 == 2) {
                    return e.y(bArr, i13, iVar, bVar2);
                }
                if (i14 == 0) {
                    return e.J(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 23:
            case R.styleable.AppCompatTheme_actionOverflowButtonStyle:
            case R.styleable.AppCompatTheme_borderlessButtonStyle:
            case R.styleable.AppCompatTheme_buttonStyle:
                if (i14 == 2) {
                    return e.u(bArr, i13, iVar, bVar2);
                }
                if (i14 == 1) {
                    return e.k(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 24:
            case R.styleable.AppCompatTheme_actionModeWebSearchDrawable:
            case R.styleable.AppCompatTheme_buttonBarButtonStyle:
            case R.styleable.AppCompatTheme_buttonBarStyle:
                if (i14 == 2) {
                    return e.t(bArr, i13, iVar, bVar2);
                }
                if (i14 == 5) {
                    return e.i(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 25:
            case R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle:
                if (i14 == 2) {
                    return e.r(bArr, i13, iVar, bVar2);
                }
                if (i14 == 0) {
                    return e.a(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 26:
                if (i14 == 2) {
                    int i16 = ((j5 & 536870912) > 0 ? 1 : ((j5 & 536870912) == 0 ? 0 : -1));
                    byte[] bArr3 = bArr;
                    int i17 = i5;
                    int i18 = i6;
                    b0.i iVar2 = iVar;
                    e.b bVar3 = bVar;
                    return i16 == 0 ? e.D(i7, bArr3, i17, i18, iVar2, bVar3) : e.E(i7, bArr3, i17, i18, iVar2, bVar3);
                }
                break;
            case 27:
                if (i14 == 2) {
                    return e.q(u(i15), i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 28:
                if (i14 == 2) {
                    return e.c(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case R.styleable.AppCompatTheme_actionModeTheme:
            case R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle:
                if (i14 == 2) {
                    i12 = e.y(bArr, i13, iVar, bVar2);
                } else if (i14 == 0) {
                    i12 = e.J(i7, bArr, i5, i6, iVar, bVar);
                }
                z zVar = (z) t6;
                q1 q1Var = zVar.unknownFields;
                if (q1Var == q1.c()) {
                    q1Var = null;
                }
                q1 q1Var2 = (q1) k1.A(i8, iVar, s(i15), q1Var, this.f3715o);
                if (q1Var2 != null) {
                    zVar.unknownFields = q1Var2;
                }
                return i12;
            case R.styleable.AppCompatTheme_actionOverflowMenuStyle:
            case R.styleable.AppCompatTheme_buttonStyleSmall:
                if (i14 == 2) {
                    return e.w(bArr, i13, iVar, bVar2);
                }
                if (i14 == 0) {
                    return e.A(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case R.styleable.AppCompatTheme_activityChooserViewStyle:
            case R.styleable.AppCompatTheme_checkboxStyle:
                if (i14 == 2) {
                    return e.x(bArr, i13, iVar, bVar2);
                }
                if (i14 == 0) {
                    return e.B(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case R.styleable.AppCompatTheme_checkedTextViewStyle:
                if (i14 == 3) {
                    return e.o(u(i15), i7, bArr, i5, i6, iVar, bVar);
                }
                break;
        }
        return i13;
    }

    private int f0(int i5) {
        if (i5 < this.f3703c || i5 > this.f3704d) {
            return -1;
        }
        return p0(i5, 0);
    }

    private int g0(int i5, int i6) {
        if (i5 < this.f3703c || i5 > this.f3704d) {
            return -1;
        }
        return p0(i5, i6);
    }

    private int h0(int i5) {
        return this.f3701a[i5 + 2];
    }

    private <E> void i0(Object obj, long j5, h1 h1Var, i1<E> i1Var, q qVar) {
        h1Var.j(this.f3714n.e(obj, j5), i1Var, qVar);
    }

    private <E> void j0(Object obj, int i5, h1 h1Var, i1<E> i1Var, q qVar) {
        h1Var.s(this.f3714n.e(obj, U(i5)), i1Var, qVar);
    }

    private boolean k(T t5, T t6, int i5) {
        return B(t5, i5) == B(t6, i5);
    }

    private void k0(Object obj, int i5, h1 h1Var) {
        long U;
        Object B;
        if (A(i5)) {
            U = U(i5);
            B = h1Var.M();
        } else if (this.f3707g) {
            U = U(i5);
            B = h1Var.o();
        } else {
            U = U(i5);
            B = h1Var.B();
        }
        t1.V(obj, U, B);
    }

    private static <T> boolean l(T t5, long j5) {
        return t1.t(t5, j5);
    }

    private void l0(Object obj, int i5, h1 h1Var) {
        if (A(i5)) {
            h1Var.z(this.f3714n.e(obj, U(i5)));
        } else {
            h1Var.u(this.f3714n.e(obj, U(i5)));
        }
    }

    private <K, V> int m(byte[] bArr, int i5, int i6, l0.a<K, V> aVar, Map<K, V> map, e.b bVar) {
        int I = e.I(bArr, i5, bVar);
        int i7 = bVar.f3498a;
        if (i7 < 0 || i7 > i6 - I) {
            throw c0.m();
        }
        throw null;
    }

    private static Field m0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static <T> double n(T t5, long j5) {
        return t1.A(t5, j5);
    }

    private void n0(T t5, int i5) {
        int h02 = h0(i5);
        long j5 = (long) (1048575 & h02);
        if (j5 != 1048575) {
            t1.T(t5, j5, (1 << (h02 >>> 20)) | t1.C(t5, j5));
        }
    }

    private boolean o(T t5, T t6, int i5) {
        int r02 = r0(i5);
        long U = U(r02);
        switch (q0(r02)) {
            case 0:
                return k(t5, t6, i5) && Double.doubleToLongBits(t1.A(t5, U)) == Double.doubleToLongBits(t1.A(t6, U));
            case 1:
                return k(t5, t6, i5) && Float.floatToIntBits(t1.B(t5, U)) == Float.floatToIntBits(t1.B(t6, U));
            case 2:
                return k(t5, t6, i5) && t1.E(t5, U) == t1.E(t6, U);
            case 3:
                return k(t5, t6, i5) && t1.E(t5, U) == t1.E(t6, U);
            case 4:
                return k(t5, t6, i5) && t1.C(t5, U) == t1.C(t6, U);
            case 5:
                return k(t5, t6, i5) && t1.E(t5, U) == t1.E(t6, U);
            case 6:
                return k(t5, t6, i5) && t1.C(t5, U) == t1.C(t6, U);
            case 7:
                return k(t5, t6, i5) && t1.t(t5, U) == t1.t(t6, U);
            case 8:
                return k(t5, t6, i5) && k1.K(t1.G(t5, U), t1.G(t6, U));
            case 9:
                return k(t5, t6, i5) && k1.K(t1.G(t5, U), t1.G(t6, U));
            case 10:
                return k(t5, t6, i5) && k1.K(t1.G(t5, U), t1.G(t6, U));
            case 11:
                return k(t5, t6, i5) && t1.C(t5, U) == t1.C(t6, U);
            case 12:
                return k(t5, t6, i5) && t1.C(t5, U) == t1.C(t6, U);
            case 13:
                return k(t5, t6, i5) && t1.C(t5, U) == t1.C(t6, U);
            case 14:
                return k(t5, t6, i5) && t1.E(t5, U) == t1.E(t6, U);
            case 15:
                return k(t5, t6, i5) && t1.C(t5, U) == t1.C(t6, U);
            case 16:
                return k(t5, t6, i5) && t1.E(t5, U) == t1.E(t6, U);
            case 17:
                return k(t5, t6, i5) && k1.K(t1.G(t5, U), t1.G(t6, U));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case R.styleable.AppCompatTheme_actionModeTheme:
            case R.styleable.AppCompatTheme_actionModeWebSearchDrawable:
            case R.styleable.AppCompatTheme_actionOverflowButtonStyle:
            case R.styleable.AppCompatTheme_actionOverflowMenuStyle:
            case R.styleable.AppCompatTheme_activityChooserViewStyle:
            case R.styleable.AppCompatTheme_alertDialogButtonGroupStyle:
            case R.styleable.AppCompatTheme_alertDialogCenterButtons:
            case R.styleable.AppCompatTheme_alertDialogStyle:
            case R.styleable.AppCompatTheme_alertDialogTheme:
            case R.styleable.AppCompatTheme_autoCompleteTextViewStyle:
            case R.styleable.AppCompatTheme_borderlessButtonStyle:
            case R.styleable.AppCompatTheme_buttonBarButtonStyle:
            case R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle:
            case R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle:
            case R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle:
            case R.styleable.AppCompatTheme_buttonBarStyle:
            case R.styleable.AppCompatTheme_buttonStyle:
            case R.styleable.AppCompatTheme_buttonStyleSmall:
            case R.styleable.AppCompatTheme_checkboxStyle:
            case R.styleable.AppCompatTheme_checkedTextViewStyle:
            case R.styleable.AppCompatTheme_colorAccent:
                return k1.K(t1.G(t5, U), t1.G(t6, U));
            case R.styleable.AppCompatTheme_colorBackgroundFloating:
            case R.styleable.AppCompatTheme_colorButtonNormal:
            case R.styleable.AppCompatTheme_colorControlActivated:
            case R.styleable.AppCompatTheme_colorControlHighlight:
            case R.styleable.AppCompatTheme_colorControlNormal:
            case R.styleable.AppCompatTheme_colorError:
            case R.styleable.AppCompatTheme_colorPrimary:
            case R.styleable.AppCompatTheme_colorPrimaryDark:
            case R.styleable.AppCompatTheme_colorSwitchThumbNormal:
            case R.styleable.AppCompatTheme_controlBackground:
            case R.styleable.AppCompatTheme_dialogCornerRadius:
            case R.styleable.AppCompatTheme_dialogPreferredPadding:
            case R.styleable.AppCompatTheme_dialogTheme:
            case R.styleable.AppCompatTheme_dividerHorizontal:
            case R.styleable.AppCompatTheme_dividerVertical:
            case R.styleable.AppCompatTheme_dropDownListViewStyle:
            case R.styleable.AppCompatTheme_dropdownListPreferredItemHeight:
            case R.styleable.AppCompatTheme_editTextBackground:
                return G(t5, t6, i5) && k1.K(t1.G(t5, U), t1.G(t6, U));
            default:
                return true;
        }
    }

    private void o0(T t5, int i5, int i6) {
        t1.T(t5, (long) (h0(i6) & 1048575), i5);
    }

    private final <UT, UB> UB p(Object obj, int i5, UB ub, p1<UT, UB> p1Var) {
        b0.e s5;
        int T = T(i5);
        Object G = t1.G(obj, U(r0(i5)));
        if (G == null || (s5 = s(i5)) == null) {
            return ub;
        }
        return q(i5, T, this.f3717q.h(G), s5, ub, p1Var);
    }

    private int p0(int i5, int i6) {
        int length = (this.f3701a.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int T = T(i8);
            if (i5 == T) {
                return i8;
            }
            if (i5 < T) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    private final <K, V, UT, UB> UB q(int i5, int i6, Map<K, V> map, b0.e eVar, UB ub, p1<UT, UB> p1Var) {
        this.f3717q.f(t(i5));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!eVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = p1Var.n();
                }
                i.h t5 = i.t(l0.b((l0.a) null, next.getKey(), next.getValue()));
                try {
                    l0.d(t5.b(), (l0.a) null, next.getKey(), next.getValue());
                    p1Var.d(ub, i6, t5.a());
                    it.remove();
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            }
        }
        return ub;
    }

    private static int q0(int i5) {
        return (i5 & 267386880) >>> 20;
    }

    private static <T> float r(T t5, long j5) {
        return t1.B(t5, j5);
    }

    private int r0(int i5) {
        return this.f3701a[i5 + 1];
    }

    private b0.e s(int i5) {
        return (b0.e) this.f3702b[((i5 / 3) * 2) + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void s0(T r18, com.google.protobuf.w1 r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f3706f
            if (r3 == 0) goto L_0x0021
            com.google.protobuf.r<?> r3 = r0.f3716p
            com.google.protobuf.v r3 = r3.c(r1)
            boolean r5 = r3.m()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.r()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.f3701a
            int r6 = r6.length
            sun.misc.Unsafe r7 = f3700s
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r8
            r10 = 0
            r12 = 0
        L_0x002e:
            if (r10 >= r6) goto L_0x048d
            int r13 = r0.r0(r10)
            int r14 = r0.T(r10)
            int r15 = q0(r13)
            r4 = 17
            if (r15 > r4) goto L_0x0056
            int[] r4 = r0.f3701a
            int r16 = r10 + 2
            r4 = r4[r16]
            r9 = r4 & r8
            if (r9 == r11) goto L_0x0050
            long r11 = (long) r9
            int r12 = r7.getInt(r1, r11)
            r11 = r9
        L_0x0050:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            if (r5 == 0) goto L_0x0075
            com.google.protobuf.r<?> r9 = r0.f3716p
            int r9 = r9.a(r5)
            if (r9 > r14) goto L_0x0075
            com.google.protobuf.r<?> r9 = r0.f3716p
            r9.j(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0073
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0057
        L_0x0073:
            r5 = 0
            goto L_0x0057
        L_0x0075:
            long r8 = U(r13)
            switch(r15) {
                case 0: goto L_0x047b;
                case 1: goto L_0x046f;
                case 2: goto L_0x0463;
                case 3: goto L_0x0457;
                case 4: goto L_0x044b;
                case 5: goto L_0x043f;
                case 6: goto L_0x0433;
                case 7: goto L_0x0427;
                case 8: goto L_0x041b;
                case 9: goto L_0x040a;
                case 10: goto L_0x03fb;
                case 11: goto L_0x03ee;
                case 12: goto L_0x03e1;
                case 13: goto L_0x03d4;
                case 14: goto L_0x03c7;
                case 15: goto L_0x03ba;
                case 16: goto L_0x03ad;
                case 17: goto L_0x039c;
                case 18: goto L_0x038c;
                case 19: goto L_0x037c;
                case 20: goto L_0x036c;
                case 21: goto L_0x035c;
                case 22: goto L_0x034c;
                case 23: goto L_0x033c;
                case 24: goto L_0x032c;
                case 25: goto L_0x031c;
                case 26: goto L_0x030d;
                case 27: goto L_0x02fa;
                case 28: goto L_0x02eb;
                case 29: goto L_0x02db;
                case 30: goto L_0x02cb;
                case 31: goto L_0x02bb;
                case 32: goto L_0x02ab;
                case 33: goto L_0x029b;
                case 34: goto L_0x028b;
                case 35: goto L_0x027b;
                case 36: goto L_0x026b;
                case 37: goto L_0x025b;
                case 38: goto L_0x024b;
                case 39: goto L_0x023b;
                case 40: goto L_0x022b;
                case 41: goto L_0x021b;
                case 42: goto L_0x020b;
                case 43: goto L_0x01fb;
                case 44: goto L_0x01eb;
                case 45: goto L_0x01db;
                case 46: goto L_0x01cb;
                case 47: goto L_0x01bb;
                case 48: goto L_0x01ab;
                case 49: goto L_0x0198;
                case 50: goto L_0x018f;
                case 51: goto L_0x0180;
                case 52: goto L_0x0171;
                case 53: goto L_0x0162;
                case 54: goto L_0x0153;
                case 55: goto L_0x0144;
                case 56: goto L_0x0135;
                case 57: goto L_0x0126;
                case 58: goto L_0x0117;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f5;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d7;
                case 63: goto L_0x00c9;
                case 64: goto L_0x00bb;
                case 65: goto L_0x00ad;
                case 66: goto L_0x009f;
                case 67: goto L_0x0091;
                case 68: goto L_0x007f;
                default: goto L_0x007c;
            }
        L_0x007c:
            r13 = 0
            goto L_0x0486
        L_0x007f:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.i1 r8 = r0.u(r10)
            r2.i(r14, r4, r8)
            goto L_0x007c
        L_0x0091:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = Z(r1, r8)
            r2.C(r14, r8)
            goto L_0x007c
        L_0x009f:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = Y(r1, r8)
            r2.N(r14, r4)
            goto L_0x007c
        L_0x00ad:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = Z(r1, r8)
            r2.r(r14, r8)
            goto L_0x007c
        L_0x00bb:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = Y(r1, r8)
            r2.j(r14, r4)
            goto L_0x007c
        L_0x00c9:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = Y(r1, r8)
            r2.J(r14, r4)
            goto L_0x007c
        L_0x00d7:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = Y(r1, r8)
            r2.g(r14, r4)
            goto L_0x007c
        L_0x00e5:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.i r4 = (com.google.protobuf.i) r4
            r2.l(r14, r4)
            goto L_0x007c
        L_0x00f5:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.i1 r8 = r0.u(r10)
            r2.w(r14, r4, r8)
            goto L_0x007c
        L_0x0108:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.w0(r14, r4, r2)
            goto L_0x007c
        L_0x0117:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            boolean r4 = V(r1, r8)
            r2.f(r14, r4)
            goto L_0x007c
        L_0x0126:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = Y(r1, r8)
            r2.p(r14, r4)
            goto L_0x007c
        L_0x0135:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = Z(r1, r8)
            r2.A(r14, r8)
            goto L_0x007c
        L_0x0144:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = Y(r1, r8)
            r2.m(r14, r4)
            goto L_0x007c
        L_0x0153:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = Z(r1, r8)
            r2.I(r14, r8)
            goto L_0x007c
        L_0x0162:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = Z(r1, r8)
            r2.e(r14, r8)
            goto L_0x007c
        L_0x0171:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            float r4 = X(r1, r8)
            r2.D(r14, r4)
            goto L_0x007c
        L_0x0180:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            double r8 = W(r1, r8)
            r2.q(r14, r8)
            goto L_0x007c
        L_0x018f:
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.v0(r2, r14, r4, r10)
            goto L_0x007c
        L_0x0198:
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.i1 r9 = r0.u(r10)
            com.google.protobuf.k1.U(r4, r8, r2, r9)
            goto L_0x007c
        L_0x01ab:
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 1
            com.google.protobuf.k1.b0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01bb:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.a0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01cb:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.Z(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01db:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.Y(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01eb:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.Q(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01fb:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.d0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x020b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.N(r4, r8, r2, r13)
            goto L_0x007c
        L_0x021b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.R(r4, r8, r2, r13)
            goto L_0x007c
        L_0x022b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.S(r4, r8, r2, r13)
            goto L_0x007c
        L_0x023b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.V(r4, r8, r2, r13)
            goto L_0x007c
        L_0x024b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.e0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x025b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.W(r4, r8, r2, r13)
            goto L_0x007c
        L_0x026b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.T(r4, r8, r2, r13)
            goto L_0x007c
        L_0x027b:
            r13 = 1
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.P(r4, r8, r2, r13)
            goto L_0x007c
        L_0x028b:
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.protobuf.k1.b0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x029b:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.a0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02ab:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.Z(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02bb:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.Y(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02cb:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.Q(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02db:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.d0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02eb:
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.O(r4, r8, r2)
            goto L_0x007c
        L_0x02fa:
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.i1 r9 = r0.u(r10)
            com.google.protobuf.k1.X(r4, r8, r2, r9)
            goto L_0x007c
        L_0x030d:
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.c0(r4, r8, r2)
            goto L_0x007c
        L_0x031c:
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.protobuf.k1.N(r4, r8, r2, r13)
            goto L_0x0486
        L_0x032c:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.R(r4, r8, r2, r13)
            goto L_0x0486
        L_0x033c:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.S(r4, r8, r2, r13)
            goto L_0x0486
        L_0x034c:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.V(r4, r8, r2, r13)
            goto L_0x0486
        L_0x035c:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.e0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x036c:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.W(r4, r8, r2, r13)
            goto L_0x0486
        L_0x037c:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.T(r4, r8, r2, r13)
            goto L_0x0486
        L_0x038c:
            r13 = 0
            int r4 = r0.T(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.k1.P(r4, r8, r2, r13)
            goto L_0x0486
        L_0x039c:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.i1 r8 = r0.u(r10)
            r2.i(r14, r4, r8)
            goto L_0x0486
        L_0x03ad:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.C(r14, r8)
            goto L_0x0486
        L_0x03ba:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.N(r14, r4)
            goto L_0x0486
        L_0x03c7:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.r(r14, r8)
            goto L_0x0486
        L_0x03d4:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.j(r14, r4)
            goto L_0x0486
        L_0x03e1:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.J(r14, r4)
            goto L_0x0486
        L_0x03ee:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.g(r14, r4)
            goto L_0x0486
        L_0x03fb:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.i r4 = (com.google.protobuf.i) r4
            r2.l(r14, r4)
            goto L_0x0486
        L_0x040a:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.i1 r8 = r0.u(r10)
            r2.w(r14, r4, r8)
            goto L_0x0486
        L_0x041b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.w0(r14, r4, r2)
            goto L_0x0486
        L_0x0427:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            boolean r4 = l(r1, r8)
            r2.f(r14, r4)
            goto L_0x0486
        L_0x0433:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.p(r14, r4)
            goto L_0x0486
        L_0x043f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.A(r14, r8)
            goto L_0x0486
        L_0x044b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.m(r14, r4)
            goto L_0x0486
        L_0x0457:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.I(r14, r8)
            goto L_0x0486
        L_0x0463:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.e(r14, r8)
            goto L_0x0486
        L_0x046f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            float r4 = r(r1, r8)
            r2.D(r14, r4)
            goto L_0x0486
        L_0x047b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            double r8 = n(r1, r8)
            r2.q(r14, r8)
        L_0x0486:
            int r10 = r10 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x002e
        L_0x048d:
            if (r5 == 0) goto L_0x04a4
            com.google.protobuf.r<?> r4 = r0.f3716p
            r4.j(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a2
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048d
        L_0x04a2:
            r5 = 0
            goto L_0x048d
        L_0x04a4:
            com.google.protobuf.p1<?, ?> r3 = r0.f3715o
            r0.x0(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.s0(java.lang.Object, com.google.protobuf.w1):void");
    }

    private Object t(int i5) {
        return this.f3702b[(i5 / 3) * 2];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x03d0, code lost:
        r14.i(r7, com.google.protobuf.t1.G(r13, U(r6)), u(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x03ef, code lost:
        r14.C(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0402, code lost:
        r14.N(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0415, code lost:
        r14.r(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0428, code lost:
        r14.j(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x043b, code lost:
        r14.J(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x044e, code lost:
        r14.g(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0459, code lost:
        r14.l(r7, (com.google.protobuf.i) com.google.protobuf.t1.G(r13, U(r6)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x046e, code lost:
        r14.w(r7, com.google.protobuf.t1.G(r13, U(r6)), u(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0485, code lost:
        w0(r7, com.google.protobuf.t1.G(r13, U(r6)), r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x04a0, code lost:
        r14.f(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x04b3, code lost:
        r14.p(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x04c5, code lost:
        r14.A(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x04d7, code lost:
        r14.m(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x04e9, code lost:
        r14.I(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x04fb, code lost:
        r14.e(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x050d, code lost:
        r14.D(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x051f, code lost:
        r14.q(r7, r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0528  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void t0(T r13, com.google.protobuf.w1 r14) {
        /*
            r12 = this;
            boolean r0 = r12.f3706f
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.google.protobuf.r<?> r0 = r12.f3716p
            com.google.protobuf.v r0 = r0.c(r13)
            boolean r2 = r0.m()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.r()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.f3701a
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0023:
            if (r5 >= r3) goto L_0x0526
            int r6 = r12.r0(r5)
            int r7 = r12.T(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            com.google.protobuf.r<?> r8 = r12.f3716p
            int r8 = r8.a(r2)
            if (r8 > r7) goto L_0x004b
            com.google.protobuf.r<?> r8 = r12.f3716p
            r8.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = q0(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0511;
                case 1: goto L_0x04ff;
                case 2: goto L_0x04ed;
                case 3: goto L_0x04db;
                case 4: goto L_0x04c9;
                case 5: goto L_0x04b7;
                case 6: goto L_0x04a5;
                case 7: goto L_0x0492;
                case 8: goto L_0x047f;
                case 9: goto L_0x0468;
                case 10: goto L_0x0453;
                case 11: goto L_0x0440;
                case 12: goto L_0x042d;
                case 13: goto L_0x041a;
                case 14: goto L_0x0407;
                case 15: goto L_0x03f4;
                case 16: goto L_0x03e1;
                case 17: goto L_0x03ca;
                case 18: goto L_0x03b7;
                case 19: goto L_0x03a4;
                case 20: goto L_0x0391;
                case 21: goto L_0x037e;
                case 22: goto L_0x036b;
                case 23: goto L_0x0358;
                case 24: goto L_0x0345;
                case 25: goto L_0x0332;
                case 26: goto L_0x031f;
                case 27: goto L_0x0308;
                case 28: goto L_0x02f5;
                case 29: goto L_0x02e2;
                case 30: goto L_0x02cf;
                case 31: goto L_0x02bc;
                case 32: goto L_0x02a9;
                case 33: goto L_0x0296;
                case 34: goto L_0x0283;
                case 35: goto L_0x0270;
                case 36: goto L_0x025d;
                case 37: goto L_0x024a;
                case 38: goto L_0x0237;
                case 39: goto L_0x0224;
                case 40: goto L_0x0211;
                case 41: goto L_0x01fe;
                case 42: goto L_0x01eb;
                case 43: goto L_0x01d8;
                case 44: goto L_0x01c5;
                case 45: goto L_0x01b2;
                case 46: goto L_0x019f;
                case 47: goto L_0x018c;
                case 48: goto L_0x0179;
                case 49: goto L_0x0162;
                case 50: goto L_0x0155;
                case 51: goto L_0x0145;
                case 52: goto L_0x0135;
                case 53: goto L_0x0125;
                case 54: goto L_0x0115;
                case 55: goto L_0x0105;
                case 56: goto L_0x00f5;
                case 57: goto L_0x00e5;
                case 58: goto L_0x00d5;
                case 59: goto L_0x00cd;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00bd;
                case 62: goto L_0x00ad;
                case 63: goto L_0x009d;
                case 64: goto L_0x008d;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0522
        L_0x0055:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            goto L_0x03d0
        L_0x005d:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = Z(r13, r8)
            goto L_0x03ef
        L_0x006d:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = Y(r13, r8)
            goto L_0x0402
        L_0x007d:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = Z(r13, r8)
            goto L_0x0415
        L_0x008d:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = Y(r13, r8)
            goto L_0x0428
        L_0x009d:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = Y(r13, r8)
            goto L_0x043b
        L_0x00ad:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = Y(r13, r8)
            goto L_0x044e
        L_0x00bd:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            goto L_0x0459
        L_0x00c5:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            goto L_0x046e
        L_0x00cd:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            goto L_0x0485
        L_0x00d5:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            boolean r6 = V(r13, r8)
            goto L_0x04a0
        L_0x00e5:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = Y(r13, r8)
            goto L_0x04b3
        L_0x00f5:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = Z(r13, r8)
            goto L_0x04c5
        L_0x0105:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = Y(r13, r8)
            goto L_0x04d7
        L_0x0115:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = Z(r13, r8)
            goto L_0x04e9
        L_0x0125:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = Z(r13, r8)
            goto L_0x04fb
        L_0x0135:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            float r6 = X(r13, r8)
            goto L_0x050d
        L_0x0145:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            double r8 = W(r13, r8)
            goto L_0x051f
        L_0x0155:
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            r12.v0(r14, r7, r6, r5)
            goto L_0x0522
        L_0x0162:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.i1 r8 = r12.u(r5)
            com.google.protobuf.k1.U(r7, r6, r14, r8)
            goto L_0x0522
        L_0x0179:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.b0(r7, r6, r14, r9)
            goto L_0x0522
        L_0x018c:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.a0(r7, r6, r14, r9)
            goto L_0x0522
        L_0x019f:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.Z(r7, r6, r14, r9)
            goto L_0x0522
        L_0x01b2:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.Y(r7, r6, r14, r9)
            goto L_0x0522
        L_0x01c5:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.Q(r7, r6, r14, r9)
            goto L_0x0522
        L_0x01d8:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.d0(r7, r6, r14, r9)
            goto L_0x0522
        L_0x01eb:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.N(r7, r6, r14, r9)
            goto L_0x0522
        L_0x01fe:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.R(r7, r6, r14, r9)
            goto L_0x0522
        L_0x0211:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.S(r7, r6, r14, r9)
            goto L_0x0522
        L_0x0224:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.V(r7, r6, r14, r9)
            goto L_0x0522
        L_0x0237:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.e0(r7, r6, r14, r9)
            goto L_0x0522
        L_0x024a:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.W(r7, r6, r14, r9)
            goto L_0x0522
        L_0x025d:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.T(r7, r6, r14, r9)
            goto L_0x0522
        L_0x0270:
            int r7 = r12.T(r5)
            long r10 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.P(r7, r6, r14, r9)
            goto L_0x0522
        L_0x0283:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.b0(r7, r6, r14, r4)
            goto L_0x0522
        L_0x0296:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.a0(r7, r6, r14, r4)
            goto L_0x0522
        L_0x02a9:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.Z(r7, r6, r14, r4)
            goto L_0x0522
        L_0x02bc:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.Y(r7, r6, r14, r4)
            goto L_0x0522
        L_0x02cf:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.Q(r7, r6, r14, r4)
            goto L_0x0522
        L_0x02e2:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.d0(r7, r6, r14, r4)
            goto L_0x0522
        L_0x02f5:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.O(r7, r6, r14)
            goto L_0x0522
        L_0x0308:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.i1 r8 = r12.u(r5)
            com.google.protobuf.k1.X(r7, r6, r14, r8)
            goto L_0x0522
        L_0x031f:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.c0(r7, r6, r14)
            goto L_0x0522
        L_0x0332:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.N(r7, r6, r14, r4)
            goto L_0x0522
        L_0x0345:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.R(r7, r6, r14, r4)
            goto L_0x0522
        L_0x0358:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.S(r7, r6, r14, r4)
            goto L_0x0522
        L_0x036b:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.V(r7, r6, r14, r4)
            goto L_0x0522
        L_0x037e:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.e0(r7, r6, r14, r4)
            goto L_0x0522
        L_0x0391:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.W(r7, r6, r14, r4)
            goto L_0x0522
        L_0x03a4:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.T(r7, r6, r14, r4)
            goto L_0x0522
        L_0x03b7:
            int r7 = r12.T(r5)
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.k1.P(r7, r6, r14, r4)
            goto L_0x0522
        L_0x03ca:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
        L_0x03d0:
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            com.google.protobuf.i1 r8 = r12.u(r5)
            r14.i(r7, r6, r8)
            goto L_0x0522
        L_0x03e1:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = K(r13, r8)
        L_0x03ef:
            r14.C(r7, r8)
            goto L_0x0522
        L_0x03f4:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = z(r13, r8)
        L_0x0402:
            r14.N(r7, r6)
            goto L_0x0522
        L_0x0407:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = K(r13, r8)
        L_0x0415:
            r14.r(r7, r8)
            goto L_0x0522
        L_0x041a:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = z(r13, r8)
        L_0x0428:
            r14.j(r7, r6)
            goto L_0x0522
        L_0x042d:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = z(r13, r8)
        L_0x043b:
            r14.J(r7, r6)
            goto L_0x0522
        L_0x0440:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = z(r13, r8)
        L_0x044e:
            r14.g(r7, r6)
            goto L_0x0522
        L_0x0453:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
        L_0x0459:
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            com.google.protobuf.i r6 = (com.google.protobuf.i) r6
            r14.l(r7, r6)
            goto L_0x0522
        L_0x0468:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
        L_0x046e:
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            com.google.protobuf.i1 r8 = r12.u(r5)
            r14.w(r7, r6, r8)
            goto L_0x0522
        L_0x047f:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
        L_0x0485:
            long r8 = U(r6)
            java.lang.Object r6 = com.google.protobuf.t1.G(r13, r8)
            r12.w0(r7, r6, r14)
            goto L_0x0522
        L_0x0492:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            boolean r6 = l(r13, r8)
        L_0x04a0:
            r14.f(r7, r6)
            goto L_0x0522
        L_0x04a5:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = z(r13, r8)
        L_0x04b3:
            r14.p(r7, r6)
            goto L_0x0522
        L_0x04b7:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = K(r13, r8)
        L_0x04c5:
            r14.A(r7, r8)
            goto L_0x0522
        L_0x04c9:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            int r6 = z(r13, r8)
        L_0x04d7:
            r14.m(r7, r6)
            goto L_0x0522
        L_0x04db:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = K(r13, r8)
        L_0x04e9:
            r14.I(r7, r8)
            goto L_0x0522
        L_0x04ed:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            long r8 = K(r13, r8)
        L_0x04fb:
            r14.e(r7, r8)
            goto L_0x0522
        L_0x04ff:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            float r6 = r(r13, r8)
        L_0x050d:
            r14.D(r7, r6)
            goto L_0x0522
        L_0x0511:
            boolean r8 = r12.B(r13, r5)
            if (r8 == 0) goto L_0x0522
            long r8 = U(r6)
            double r8 = n(r13, r8)
        L_0x051f:
            r14.q(r7, r8)
        L_0x0522:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0526:
            if (r2 == 0) goto L_0x053c
            com.google.protobuf.r<?> r3 = r12.f3716p
            r3.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x053a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0526
        L_0x053a:
            r2 = r1
            goto L_0x0526
        L_0x053c:
            com.google.protobuf.p1<?, ?> r0 = r12.f3715o
            r12.x0(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.t0(java.lang.Object, com.google.protobuf.w1):void");
    }

    private i1 u(int i5) {
        int i6 = (i5 / 3) * 2;
        i1 i1Var = (i1) this.f3702b[i6];
        if (i1Var != null) {
            return i1Var;
        }
        i1 d5 = e1.a().d((Class) this.f3702b[i6 + 1]);
        this.f3702b[i6] = d5;
        return d5;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x03d6, code lost:
        r12.i(r5, com.google.protobuf.t1.G(r11, U(r4)), u(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x03f5, code lost:
        r12.C(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0408, code lost:
        r12.N(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x041b, code lost:
        r12.r(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x042e, code lost:
        r12.j(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0441, code lost:
        r12.J(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0454, code lost:
        r12.g(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x045f, code lost:
        r12.l(r5, (com.google.protobuf.i) com.google.protobuf.t1.G(r11, U(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0474, code lost:
        r12.w(r5, com.google.protobuf.t1.G(r11, U(r4)), u(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x048b, code lost:
        w0(r5, com.google.protobuf.t1.G(r11, U(r4)), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x04a6, code lost:
        r12.f(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x04b9, code lost:
        r12.p(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x04cb, code lost:
        r12.A(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x04dd, code lost:
        r12.m(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x04ef, code lost:
        r12.I(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0501, code lost:
        r12.e(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0513, code lost:
        r12.D(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0525, code lost:
        r12.q(r5, r6);
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u0(T r11, com.google.protobuf.w1 r12) {
        /*
            r10 = this;
            com.google.protobuf.p1<?, ?> r0 = r10.f3715o
            r10.x0(r0, r11, r12)
            boolean r0 = r10.f3706f
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.google.protobuf.r<?> r0 = r10.f3716p
            com.google.protobuf.v r0 = r0.c(r11)
            boolean r2 = r0.m()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.g()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.f3701a
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x052c
            int r4 = r10.r0(r3)
            int r5 = r10.T(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            com.google.protobuf.r<?> r6 = r10.f3716p
            int r6 = r6.a(r2)
            if (r6 <= r5) goto L_0x0050
            com.google.protobuf.r<?> r6 = r10.f3716p
            r6.j(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = q0(r4)
            r7 = 1
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0505;
                case 2: goto L_0x04f3;
                case 3: goto L_0x04e1;
                case 4: goto L_0x04cf;
                case 5: goto L_0x04bd;
                case 6: goto L_0x04ab;
                case 7: goto L_0x0498;
                case 8: goto L_0x0485;
                case 9: goto L_0x046e;
                case 10: goto L_0x0459;
                case 11: goto L_0x0446;
                case 12: goto L_0x0433;
                case 13: goto L_0x0420;
                case 14: goto L_0x040d;
                case 15: goto L_0x03fa;
                case 16: goto L_0x03e7;
                case 17: goto L_0x03d0;
                case 18: goto L_0x03bd;
                case 19: goto L_0x03aa;
                case 20: goto L_0x0397;
                case 21: goto L_0x0384;
                case 22: goto L_0x0371;
                case 23: goto L_0x035e;
                case 24: goto L_0x034b;
                case 25: goto L_0x0338;
                case 26: goto L_0x0325;
                case 27: goto L_0x030e;
                case 28: goto L_0x02fb;
                case 29: goto L_0x02e8;
                case 30: goto L_0x02d5;
                case 31: goto L_0x02c2;
                case 32: goto L_0x02af;
                case 33: goto L_0x029c;
                case 34: goto L_0x0289;
                case 35: goto L_0x0276;
                case 36: goto L_0x0263;
                case 37: goto L_0x0250;
                case 38: goto L_0x023d;
                case 39: goto L_0x022a;
                case 40: goto L_0x0217;
                case 41: goto L_0x0204;
                case 42: goto L_0x01f1;
                case 43: goto L_0x01de;
                case 44: goto L_0x01cb;
                case 45: goto L_0x01b8;
                case 46: goto L_0x01a5;
                case 47: goto L_0x0192;
                case 48: goto L_0x017f;
                case 49: goto L_0x0168;
                case 50: goto L_0x015b;
                case 51: goto L_0x014b;
                case 52: goto L_0x013b;
                case 53: goto L_0x012b;
                case 54: goto L_0x011b;
                case 55: goto L_0x010b;
                case 56: goto L_0x00fb;
                case 57: goto L_0x00eb;
                case 58: goto L_0x00db;
                case 59: goto L_0x00d3;
                case 60: goto L_0x00cb;
                case 61: goto L_0x00c3;
                case 62: goto L_0x00b3;
                case 63: goto L_0x00a3;
                case 64: goto L_0x0093;
                case 65: goto L_0x0083;
                case 66: goto L_0x0073;
                case 67: goto L_0x0063;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0528
        L_0x005b:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            goto L_0x03d6
        L_0x0063:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = Z(r11, r6)
            goto L_0x03f5
        L_0x0073:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = Y(r11, r6)
            goto L_0x0408
        L_0x0083:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = Z(r11, r6)
            goto L_0x041b
        L_0x0093:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = Y(r11, r6)
            goto L_0x042e
        L_0x00a3:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = Y(r11, r6)
            goto L_0x0441
        L_0x00b3:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = Y(r11, r6)
            goto L_0x0454
        L_0x00c3:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            goto L_0x045f
        L_0x00cb:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            goto L_0x0474
        L_0x00d3:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            goto L_0x048b
        L_0x00db:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            boolean r4 = V(r11, r6)
            goto L_0x04a6
        L_0x00eb:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = Y(r11, r6)
            goto L_0x04b9
        L_0x00fb:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = Z(r11, r6)
            goto L_0x04cb
        L_0x010b:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = Y(r11, r6)
            goto L_0x04dd
        L_0x011b:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = Z(r11, r6)
            goto L_0x04ef
        L_0x012b:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = Z(r11, r6)
            goto L_0x0501
        L_0x013b:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            float r4 = X(r11, r6)
            goto L_0x0513
        L_0x014b:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            double r6 = W(r11, r6)
            goto L_0x0525
        L_0x015b:
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            r10.v0(r12, r5, r4, r3)
            goto L_0x0528
        L_0x0168:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.i1 r6 = r10.u(r3)
            com.google.protobuf.k1.U(r5, r4, r12, r6)
            goto L_0x0528
        L_0x017f:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.b0(r5, r4, r12, r7)
            goto L_0x0528
        L_0x0192:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.a0(r5, r4, r12, r7)
            goto L_0x0528
        L_0x01a5:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.Z(r5, r4, r12, r7)
            goto L_0x0528
        L_0x01b8:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.Y(r5, r4, r12, r7)
            goto L_0x0528
        L_0x01cb:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.Q(r5, r4, r12, r7)
            goto L_0x0528
        L_0x01de:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.d0(r5, r4, r12, r7)
            goto L_0x0528
        L_0x01f1:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.N(r5, r4, r12, r7)
            goto L_0x0528
        L_0x0204:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.R(r5, r4, r12, r7)
            goto L_0x0528
        L_0x0217:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.S(r5, r4, r12, r7)
            goto L_0x0528
        L_0x022a:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.V(r5, r4, r12, r7)
            goto L_0x0528
        L_0x023d:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.e0(r5, r4, r12, r7)
            goto L_0x0528
        L_0x0250:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.W(r5, r4, r12, r7)
            goto L_0x0528
        L_0x0263:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.T(r5, r4, r12, r7)
            goto L_0x0528
        L_0x0276:
            int r5 = r10.T(r3)
            long r8 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.P(r5, r4, r12, r7)
            goto L_0x0528
        L_0x0289:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.b0(r5, r4, r12, r8)
            goto L_0x0528
        L_0x029c:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.a0(r5, r4, r12, r8)
            goto L_0x0528
        L_0x02af:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.Z(r5, r4, r12, r8)
            goto L_0x0528
        L_0x02c2:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.Y(r5, r4, r12, r8)
            goto L_0x0528
        L_0x02d5:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.Q(r5, r4, r12, r8)
            goto L_0x0528
        L_0x02e8:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.d0(r5, r4, r12, r8)
            goto L_0x0528
        L_0x02fb:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.O(r5, r4, r12)
            goto L_0x0528
        L_0x030e:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.i1 r6 = r10.u(r3)
            com.google.protobuf.k1.X(r5, r4, r12, r6)
            goto L_0x0528
        L_0x0325:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.c0(r5, r4, r12)
            goto L_0x0528
        L_0x0338:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.N(r5, r4, r12, r8)
            goto L_0x0528
        L_0x034b:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.R(r5, r4, r12, r8)
            goto L_0x0528
        L_0x035e:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.S(r5, r4, r12, r8)
            goto L_0x0528
        L_0x0371:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.V(r5, r4, r12, r8)
            goto L_0x0528
        L_0x0384:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.e0(r5, r4, r12, r8)
            goto L_0x0528
        L_0x0397:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.W(r5, r4, r12, r8)
            goto L_0x0528
        L_0x03aa:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.T(r5, r4, r12, r8)
            goto L_0x0528
        L_0x03bd:
            int r5 = r10.T(r3)
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.k1.P(r5, r4, r12, r8)
            goto L_0x0528
        L_0x03d0:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
        L_0x03d6:
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            com.google.protobuf.i1 r6 = r10.u(r3)
            r12.i(r5, r4, r6)
            goto L_0x0528
        L_0x03e7:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = K(r11, r6)
        L_0x03f5:
            r12.C(r5, r6)
            goto L_0x0528
        L_0x03fa:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = z(r11, r6)
        L_0x0408:
            r12.N(r5, r4)
            goto L_0x0528
        L_0x040d:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = K(r11, r6)
        L_0x041b:
            r12.r(r5, r6)
            goto L_0x0528
        L_0x0420:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = z(r11, r6)
        L_0x042e:
            r12.j(r5, r4)
            goto L_0x0528
        L_0x0433:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = z(r11, r6)
        L_0x0441:
            r12.J(r5, r4)
            goto L_0x0528
        L_0x0446:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = z(r11, r6)
        L_0x0454:
            r12.g(r5, r4)
            goto L_0x0528
        L_0x0459:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
        L_0x045f:
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            com.google.protobuf.i r4 = (com.google.protobuf.i) r4
            r12.l(r5, r4)
            goto L_0x0528
        L_0x046e:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
        L_0x0474:
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            com.google.protobuf.i1 r6 = r10.u(r3)
            r12.w(r5, r4, r6)
            goto L_0x0528
        L_0x0485:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
        L_0x048b:
            long r6 = U(r4)
            java.lang.Object r4 = com.google.protobuf.t1.G(r11, r6)
            r10.w0(r5, r4, r12)
            goto L_0x0528
        L_0x0498:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            boolean r4 = l(r11, r6)
        L_0x04a6:
            r12.f(r5, r4)
            goto L_0x0528
        L_0x04ab:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = z(r11, r6)
        L_0x04b9:
            r12.p(r5, r4)
            goto L_0x0528
        L_0x04bd:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = K(r11, r6)
        L_0x04cb:
            r12.A(r5, r6)
            goto L_0x0528
        L_0x04cf:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            int r4 = z(r11, r6)
        L_0x04dd:
            r12.m(r5, r4)
            goto L_0x0528
        L_0x04e1:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = K(r11, r6)
        L_0x04ef:
            r12.I(r5, r6)
            goto L_0x0528
        L_0x04f3:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            long r6 = K(r11, r6)
        L_0x0501:
            r12.e(r5, r6)
            goto L_0x0528
        L_0x0505:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            float r4 = r(r11, r6)
        L_0x0513:
            r12.D(r5, r4)
            goto L_0x0528
        L_0x0517:
            boolean r6 = r10.B(r11, r3)
            if (r6 == 0) goto L_0x0528
            long r6 = U(r4)
            double r6 = n(r11, r6)
        L_0x0525:
            r12.q(r5, r6)
        L_0x0528:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x052c:
            if (r2 == 0) goto L_0x0543
            com.google.protobuf.r<?> r11 = r10.f3716p
            r11.j(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x0541
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x052c
        L_0x0541:
            r2 = r1
            goto L_0x052c
        L_0x0543:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.u0(java.lang.Object, com.google.protobuf.w1):void");
    }

    static q1 v(Object obj) {
        z zVar = (z) obj;
        q1 q1Var = zVar.unknownFields;
        if (q1Var != q1.c()) {
            return q1Var;
        }
        q1 n5 = q1.n();
        zVar.unknownFields = n5;
        return n5;
    }

    private <K, V> void v0(w1 w1Var, int i5, Object obj, int i6) {
        if (obj != null) {
            this.f3717q.f(t(i6));
            w1Var.x(i5, (l0.a) null, this.f3717q.g(obj));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01ef, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0200, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0211, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0222, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0233, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0244, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0255, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0257, code lost:
        r2.putInt(r1, (long) r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x025b, code lost:
        r4 = (com.google.protobuf.l.W(r10) + com.google.protobuf.l.Y(r3)) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0308, code lost:
        r6 = r6 + r3;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x031d, code lost:
        if ((r8 & r15) != 0) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x031f, code lost:
        r3 = com.google.protobuf.l.t(r10, (com.google.protobuf.s0) r2.getObject(r1, r13), u(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0336, code lost:
        r3 = com.google.protobuf.l.S(r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0343, code lost:
        r3 = com.google.protobuf.l.Q(r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x034a, code lost:
        if ((r8 & r15) != 0) goto L_0x034c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x034c, code lost:
        r3 = com.google.protobuf.l.O(r10, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0353, code lost:
        if ((r8 & r15) != 0) goto L_0x0355;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0355, code lost:
        r4 = com.google.protobuf.l.M(r10, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x035a, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0364, code lost:
        r3 = com.google.protobuf.l.l(r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0371, code lost:
        r3 = com.google.protobuf.l.X(r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0378, code lost:
        if ((r8 & r15) != 0) goto L_0x037a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x037a, code lost:
        r3 = com.google.protobuf.l.h(r10, (com.google.protobuf.i) r2.getObject(r1, r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0387, code lost:
        if ((r8 & r15) != 0) goto L_0x0389;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0389, code lost:
        r3 = com.google.protobuf.k1.o(r10, r2.getObject(r1, r13), u(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03b4, code lost:
        if ((r8 & r15) != 0) goto L_0x03b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03b6, code lost:
        r3 = com.google.protobuf.l.e(r10, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (H(r1, r10, r5) != false) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0411, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (H(r1, r10, r5) != false) goto L_0x034c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
        if (H(r1, r10, r5) != false) goto L_0x0355;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        if (H(r1, r10, r5) != false) goto L_0x037a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        if (H(r1, r10, r5) != false) goto L_0x0389;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dc, code lost:
        if (H(r1, r10, r5) != false) goto L_0x03b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0171, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0183, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0195, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01a7, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b9, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cb, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01dd, code lost:
        if (r0.f3709i != false) goto L_0x0257;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int w(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = f3700s
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r3
            r5 = 0
            r6 = 0
            r8 = 0
        L_0x000d:
            int[] r9 = r0.f3701a
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0418
            int r9 = r0.r0(r5)
            int r10 = r0.T(r5)
            int r11 = q0(r9)
            r12 = 17
            r13 = 1
            if (r11 > r12) goto L_0x0038
            int[] r12 = r0.f3701a
            int r14 = r5 + 2
            r12 = r12[r14]
            r14 = r12 & r3
            int r15 = r12 >>> 20
            int r15 = r13 << r15
            if (r14 == r7) goto L_0x0056
            long r7 = (long) r14
            int r8 = r2.getInt(r1, r7)
            r7 = r14
            goto L_0x0056
        L_0x0038:
            boolean r12 = r0.f3709i
            if (r12 == 0) goto L_0x0054
            com.google.protobuf.w r12 = com.google.protobuf.w.DOUBLE_LIST_PACKED
            int r12 = r12.c()
            if (r11 < r12) goto L_0x0054
            com.google.protobuf.w r12 = com.google.protobuf.w.SINT64_LIST_PACKED
            int r12 = r12.c()
            if (r11 > r12) goto L_0x0054
            int[] r12 = r0.f3701a
            int r14 = r5 + 2
            r12 = r12[r14]
            r12 = r12 & r3
            goto L_0x0055
        L_0x0054:
            r12 = 0
        L_0x0055:
            r15 = 0
        L_0x0056:
            long r13 = U(r9)
            r9 = 0
            r3 = 0
            switch(r11) {
                case 0: goto L_0x0405;
                case 1: goto L_0x03fb;
                case 2: goto L_0x03ed;
                case 3: goto L_0x03df;
                case 4: goto L_0x03d1;
                case 5: goto L_0x03c7;
                case 6: goto L_0x03bd;
                case 7: goto L_0x03b2;
                case 8: goto L_0x0396;
                case 9: goto L_0x0385;
                case 10: goto L_0x0376;
                case 11: goto L_0x0369;
                case 12: goto L_0x035c;
                case 13: goto L_0x0351;
                case 14: goto L_0x0348;
                case 15: goto L_0x033b;
                case 16: goto L_0x032e;
                case 17: goto L_0x031b;
                case 18: goto L_0x030c;
                case 19: goto L_0x02fd;
                case 20: goto L_0x02f1;
                case 21: goto L_0x02e5;
                case 22: goto L_0x02d9;
                case 23: goto L_0x02cd;
                case 24: goto L_0x02fd;
                case 25: goto L_0x02c1;
                case 26: goto L_0x02b6;
                case 27: goto L_0x02a7;
                case 28: goto L_0x029b;
                case 29: goto L_0x028e;
                case 30: goto L_0x0281;
                case 31: goto L_0x02fd;
                case 32: goto L_0x02cd;
                case 33: goto L_0x0274;
                case 34: goto L_0x0267;
                case 35: goto L_0x0247;
                case 36: goto L_0x0236;
                case 37: goto L_0x0225;
                case 38: goto L_0x0214;
                case 39: goto L_0x0203;
                case 40: goto L_0x01f2;
                case 41: goto L_0x01e1;
                case 42: goto L_0x01cf;
                case 43: goto L_0x01bd;
                case 44: goto L_0x01ab;
                case 45: goto L_0x0199;
                case 46: goto L_0x0187;
                case 47: goto L_0x0175;
                case 48: goto L_0x0163;
                case 49: goto L_0x0153;
                case 50: goto L_0x0143;
                case 51: goto L_0x0135;
                case 52: goto L_0x0129;
                case 53: goto L_0x0119;
                case 54: goto L_0x0109;
                case 55: goto L_0x00f9;
                case 56: goto L_0x00ed;
                case 57: goto L_0x00e0;
                case 58: goto L_0x00d8;
                case 59: goto L_0x00ba;
                case 60: goto L_0x00b2;
                case 61: goto L_0x00aa;
                case 62: goto L_0x009e;
                case 63: goto L_0x0092;
                case 64: goto L_0x008a;
                case 65: goto L_0x0082;
                case 66: goto L_0x0076;
                case 67: goto L_0x006a;
                case 68: goto L_0x0062;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0318
        L_0x0062:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            goto L_0x031f
        L_0x006a:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            long r3 = Z(r1, r13)
            goto L_0x0336
        L_0x0076:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            int r3 = Y(r1, r13)
            goto L_0x0343
        L_0x0082:
            boolean r9 = r0.H(r1, r10, r5)
            if (r9 == 0) goto L_0x0318
            goto L_0x034c
        L_0x008a:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            goto L_0x0355
        L_0x0092:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            int r3 = Y(r1, r13)
            goto L_0x0364
        L_0x009e:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            int r3 = Y(r1, r13)
            goto L_0x0371
        L_0x00aa:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            goto L_0x037a
        L_0x00b2:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            goto L_0x0389
        L_0x00ba:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.protobuf.i
            if (r4 == 0) goto L_0x00d0
            com.google.protobuf.i r3 = (com.google.protobuf.i) r3
            int r3 = com.google.protobuf.l.h(r10, r3)
            goto L_0x0317
        L_0x00d0:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.l.U(r10, r3)
            goto L_0x0317
        L_0x00d8:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            goto L_0x03b6
        L_0x00e0:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            r3 = 0
            int r4 = com.google.protobuf.l.n(r10, r3)
            goto L_0x035a
        L_0x00ed:
            boolean r9 = r0.H(r1, r10, r5)
            if (r9 == 0) goto L_0x0318
            int r3 = com.google.protobuf.l.p(r10, r3)
            goto L_0x0317
        L_0x00f9:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            int r3 = Y(r1, r13)
            int r3 = com.google.protobuf.l.w(r10, r3)
            goto L_0x0317
        L_0x0109:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            long r3 = Z(r1, r13)
            int r3 = com.google.protobuf.l.Z(r10, r3)
            goto L_0x0317
        L_0x0119:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            long r3 = Z(r1, r13)
            int r3 = com.google.protobuf.l.y(r10, r3)
            goto L_0x0317
        L_0x0129:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            int r3 = com.google.protobuf.l.r(r10, r9)
            goto L_0x0317
        L_0x0135:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0318
            r3 = 0
            int r3 = com.google.protobuf.l.j(r10, r3)
            goto L_0x0317
        L_0x0143:
            com.google.protobuf.n0 r3 = r0.f3717q
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.lang.Object r9 = r0.t(r5)
            int r3 = r3.c(r10, r4, r9)
            goto L_0x0317
        L_0x0153:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.i1 r4 = r0.u(r5)
            int r3 = com.google.protobuf.k1.j(r10, r3, r4)
            goto L_0x0317
        L_0x0163:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.t(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0175:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.r(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0187:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.i(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0199:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.g(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x01ab:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.e(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x01bd:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.w(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x01cf:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.b(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x01e1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.g(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x01f2:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.i(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0203:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.l(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0214:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.y(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0225:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.n(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0236:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.g(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
            goto L_0x0257
        L_0x0247:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.i(r3)
            if (r3 <= 0) goto L_0x0318
            boolean r4 = r0.f3709i
            if (r4 == 0) goto L_0x025b
        L_0x0257:
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x025b:
            int r4 = com.google.protobuf.l.W(r10)
            int r9 = com.google.protobuf.l.Y(r3)
            int r4 = r4 + r9
            int r4 = r4 + r3
            goto L_0x035a
        L_0x0267:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.k1.s(r10, r3, r4)
            goto L_0x0308
        L_0x0274:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.q(r10, r3, r4)
            goto L_0x0308
        L_0x0281:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.d(r10, r3, r4)
            goto L_0x0308
        L_0x028e:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.v(r10, r3, r4)
            goto L_0x0317
        L_0x029b:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.c(r10, r3)
            goto L_0x0317
        L_0x02a7:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.i1 r4 = r0.u(r5)
            int r3 = com.google.protobuf.k1.p(r10, r3, r4)
            goto L_0x0317
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.u(r10, r3)
            goto L_0x0317
        L_0x02c1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.k1.a(r10, r3, r4)
            goto L_0x0308
        L_0x02cd:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.h(r10, r3, r4)
            goto L_0x0308
        L_0x02d9:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.k(r10, r3, r4)
            goto L_0x0308
        L_0x02e5:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.x(r10, r3, r4)
            goto L_0x0308
        L_0x02f1:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.m(r10, r3, r4)
            goto L_0x0308
        L_0x02fd:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.f(r10, r3, r4)
        L_0x0308:
            int r6 = r6 + r3
            r11 = r4
            goto L_0x0411
        L_0x030c:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.k1.h(r10, r3, r4)
        L_0x0317:
            int r6 = r6 + r3
        L_0x0318:
            r11 = 0
            goto L_0x0411
        L_0x031b:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
        L_0x031f:
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.s0 r3 = (com.google.protobuf.s0) r3
            com.google.protobuf.i1 r4 = r0.u(r5)
            int r3 = com.google.protobuf.l.t(r10, r3, r4)
            goto L_0x0317
        L_0x032e:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
            long r3 = r2.getLong(r1, r13)
        L_0x0336:
            int r3 = com.google.protobuf.l.S(r10, r3)
            goto L_0x0317
        L_0x033b:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
            int r3 = r2.getInt(r1, r13)
        L_0x0343:
            int r3 = com.google.protobuf.l.Q(r10, r3)
            goto L_0x0317
        L_0x0348:
            r9 = r8 & r15
            if (r9 == 0) goto L_0x0318
        L_0x034c:
            int r3 = com.google.protobuf.l.O(r10, r3)
            goto L_0x0317
        L_0x0351:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
        L_0x0355:
            r3 = 0
            int r4 = com.google.protobuf.l.M(r10, r3)
        L_0x035a:
            int r6 = r6 + r4
            goto L_0x0318
        L_0x035c:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
            int r3 = r2.getInt(r1, r13)
        L_0x0364:
            int r3 = com.google.protobuf.l.l(r10, r3)
            goto L_0x0317
        L_0x0369:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
            int r3 = r2.getInt(r1, r13)
        L_0x0371:
            int r3 = com.google.protobuf.l.X(r10, r3)
            goto L_0x0317
        L_0x0376:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
        L_0x037a:
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.i r3 = (com.google.protobuf.i) r3
            int r3 = com.google.protobuf.l.h(r10, r3)
            goto L_0x0317
        L_0x0385:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
        L_0x0389:
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.i1 r4 = r0.u(r5)
            int r3 = com.google.protobuf.k1.o(r10, r3, r4)
            goto L_0x0317
        L_0x0396:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.protobuf.i
            if (r4 == 0) goto L_0x03aa
            com.google.protobuf.i r3 = (com.google.protobuf.i) r3
            int r3 = com.google.protobuf.l.h(r10, r3)
            goto L_0x0317
        L_0x03aa:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.l.U(r10, r3)
            goto L_0x0317
        L_0x03b2:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
        L_0x03b6:
            r3 = 1
            int r3 = com.google.protobuf.l.e(r10, r3)
            goto L_0x0317
        L_0x03bd:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0318
            r11 = 0
            int r3 = com.google.protobuf.l.n(r10, r11)
            goto L_0x0410
        L_0x03c7:
            r11 = 0
            r9 = r8 & r15
            if (r9 == 0) goto L_0x0411
            int r3 = com.google.protobuf.l.p(r10, r3)
            goto L_0x0410
        L_0x03d1:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0411
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.l.w(r10, r3)
            goto L_0x0410
        L_0x03df:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0411
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.l.Z(r10, r3)
            goto L_0x0410
        L_0x03ed:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0411
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.l.y(r10, r3)
            goto L_0x0410
        L_0x03fb:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0411
            int r3 = com.google.protobuf.l.r(r10, r9)
            goto L_0x0410
        L_0x0405:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0411
            r3 = 0
            int r3 = com.google.protobuf.l.j(r10, r3)
        L_0x0410:
            int r6 = r6 + r3
        L_0x0411:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000d
        L_0x0418:
            com.google.protobuf.p1<?, ?> r2 = r0.f3715o
            int r2 = r0.y(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f3706f
            if (r2 == 0) goto L_0x042e
            com.google.protobuf.r<?> r2 = r0.f3716p
            com.google.protobuf.v r1 = r2.c(r1)
            int r1 = r1.l()
            int r6 = r6 + r1
        L_0x042e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.w(java.lang.Object):int");
    }

    private void w0(int i5, Object obj, w1 w1Var) {
        if (obj instanceof String) {
            w1Var.G(i5, (String) obj);
        } else {
            w1Var.l(i5, (i) obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01db, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ec, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01fd, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020e, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0210, code lost:
        r2.putInt(r1, (long) r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0214, code lost:
        r6 = (com.google.protobuf.l.W(r8) + com.google.protobuf.l.Y(r7)) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0299, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02a2, code lost:
        r6 = com.google.protobuf.l.t(r8, (com.google.protobuf.s0) com.google.protobuf.t1.G(r1, r9), u(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02bb, code lost:
        r6 = com.google.protobuf.l.S(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02ca, code lost:
        r6 = com.google.protobuf.l.Q(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02d5, code lost:
        r6 = com.google.protobuf.l.O(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02e0, code lost:
        r6 = com.google.protobuf.l.M(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02ef, code lost:
        r6 = com.google.protobuf.l.l(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02fe, code lost:
        r6 = com.google.protobuf.l.X(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0309, code lost:
        r6 = com.google.protobuf.t1.G(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x030d, code lost:
        r6 = com.google.protobuf.l.h(r8, (com.google.protobuf.i) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x031a, code lost:
        r6 = com.google.protobuf.k1.o(r8, com.google.protobuf.t1.G(r1, r9), u(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0334, code lost:
        if ((r6 instanceof com.google.protobuf.i) != false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x033e, code lost:
        r6 = com.google.protobuf.l.e(r8, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x034a, code lost:
        r6 = com.google.protobuf.l.n(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0356, code lost:
        r6 = com.google.protobuf.l.p(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0366, code lost:
        r6 = com.google.protobuf.l.w(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0376, code lost:
        r6 = com.google.protobuf.l.Z(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0386, code lost:
        r6 = com.google.protobuf.l.y(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0392, code lost:
        r6 = com.google.protobuf.l.r(r8, com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x039e, code lost:
        r6 = com.google.protobuf.l.j(r8, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03a6, code lost:
        r4 = r4 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a6, code lost:
        if ((r6 instanceof com.google.protobuf.i) != false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r6 = com.google.protobuf.l.U(r8, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012a, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x013c, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014e, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0160, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0172, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0184, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0196, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a8, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b9, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ca, code lost:
        if (r0.f3709i != false) goto L_0x0210;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int x(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = f3700s
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            int[] r6 = r0.f3701a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x03aa
            int r6 = r15.r0(r4)
            int r7 = q0(r6)
            int r8 = r15.T(r4)
            long r9 = U(r6)
            com.google.protobuf.w r6 = com.google.protobuf.w.DOUBLE_LIST_PACKED
            int r6 = r6.c()
            if (r7 < r6) goto L_0x0038
            com.google.protobuf.w r6 = com.google.protobuf.w.SINT64_LIST_PACKED
            int r6 = r6.c()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.f3701a
            int r11 = r4 + 2
            r6 = r6[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r11
            goto L_0x0039
        L_0x0038:
            r6 = r3
        L_0x0039:
            r11 = 1
            r12 = 0
            r13 = 0
            switch(r7) {
                case 0: goto L_0x0398;
                case 1: goto L_0x038c;
                case 2: goto L_0x037c;
                case 3: goto L_0x036c;
                case 4: goto L_0x035c;
                case 5: goto L_0x0350;
                case 6: goto L_0x0344;
                case 7: goto L_0x0338;
                case 8: goto L_0x0328;
                case 9: goto L_0x0314;
                case 10: goto L_0x0303;
                case 11: goto L_0x02f4;
                case 12: goto L_0x02e5;
                case 13: goto L_0x02da;
                case 14: goto L_0x02cf;
                case 15: goto L_0x02c0;
                case 16: goto L_0x02b1;
                case 17: goto L_0x029c;
                case 18: goto L_0x0291;
                case 19: goto L_0x0288;
                case 20: goto L_0x027f;
                case 21: goto L_0x0276;
                case 22: goto L_0x026d;
                case 23: goto L_0x0291;
                case 24: goto L_0x0288;
                case 25: goto L_0x0264;
                case 26: goto L_0x025b;
                case 27: goto L_0x024e;
                case 28: goto L_0x0245;
                case 29: goto L_0x023c;
                case 30: goto L_0x0233;
                case 31: goto L_0x0288;
                case 32: goto L_0x0291;
                case 33: goto L_0x022a;
                case 34: goto L_0x0220;
                case 35: goto L_0x0200;
                case 36: goto L_0x01ef;
                case 37: goto L_0x01de;
                case 38: goto L_0x01cd;
                case 39: goto L_0x01bc;
                case 40: goto L_0x01ab;
                case 41: goto L_0x019a;
                case 42: goto L_0x0188;
                case 43: goto L_0x0176;
                case 44: goto L_0x0164;
                case 45: goto L_0x0152;
                case 46: goto L_0x0140;
                case 47: goto L_0x012e;
                case 48: goto L_0x011c;
                case 49: goto L_0x010e;
                case 50: goto L_0x00fe;
                case 51: goto L_0x00f6;
                case 52: goto L_0x00ee;
                case 53: goto L_0x00e2;
                case 54: goto L_0x00d6;
                case 55: goto L_0x00ca;
                case 56: goto L_0x00c2;
                case 57: goto L_0x00ba;
                case 58: goto L_0x00b2;
                case 59: goto L_0x009a;
                case 60: goto L_0x0092;
                case 61: goto L_0x008a;
                case 62: goto L_0x007e;
                case 63: goto L_0x0072;
                case 64: goto L_0x006a;
                case 65: goto L_0x0062;
                case 66: goto L_0x0056;
                case 67: goto L_0x004a;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x03a6
        L_0x0042:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x02a2
        L_0x004a:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            long r6 = Z(r1, r9)
            goto L_0x02bb
        L_0x0056:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = Y(r1, r9)
            goto L_0x02ca
        L_0x0062:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x02d5
        L_0x006a:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x02e0
        L_0x0072:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = Y(r1, r9)
            goto L_0x02ef
        L_0x007e:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = Y(r1, r9)
            goto L_0x02fe
        L_0x008a:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x0309
        L_0x0092:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x031a
        L_0x009a:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            java.lang.Object r6 = com.google.protobuf.t1.G(r1, r9)
            boolean r7 = r6 instanceof com.google.protobuf.i
            if (r7 == 0) goto L_0x00aa
        L_0x00a8:
            goto L_0x030d
        L_0x00aa:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.protobuf.l.U(r8, r6)
            goto L_0x0299
        L_0x00b2:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x033e
        L_0x00ba:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x034a
        L_0x00c2:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x0356
        L_0x00ca:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = Y(r1, r9)
            goto L_0x0366
        L_0x00d6:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            long r6 = Z(r1, r9)
            goto L_0x0376
        L_0x00e2:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            long r6 = Z(r1, r9)
            goto L_0x0386
        L_0x00ee:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x0392
        L_0x00f6:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x03a6
            goto L_0x039e
        L_0x00fe:
            com.google.protobuf.n0 r6 = r0.f3717q
            java.lang.Object r7 = com.google.protobuf.t1.G(r1, r9)
            java.lang.Object r9 = r15.t(r4)
            int r6 = r6.c(r8, r7, r9)
            goto L_0x0299
        L_0x010e:
            java.util.List r6 = J(r1, r9)
            com.google.protobuf.i1 r7 = r15.u(r4)
            int r6 = com.google.protobuf.k1.j(r8, r6, r7)
            goto L_0x0299
        L_0x011c:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.t(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x012e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.r(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x0140:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.i(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x0152:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.g(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x0164:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.e(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x0176:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.w(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x0188:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.b(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x019a:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.g(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x01ab:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.i(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x01bc:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.l(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x01cd:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.y(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x01de:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.n(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x01ef:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.g(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
            goto L_0x0210
        L_0x0200:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.k1.i(r7)
            if (r7 <= 0) goto L_0x03a6
            boolean r9 = r0.f3709i
            if (r9 == 0) goto L_0x0214
        L_0x0210:
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0214:
            int r6 = com.google.protobuf.l.W(r8)
            int r8 = com.google.protobuf.l.Y(r7)
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x0299
        L_0x0220:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.s(r8, r6, r3)
            goto L_0x0299
        L_0x022a:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.q(r8, r6, r3)
            goto L_0x0299
        L_0x0233:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.d(r8, r6, r3)
            goto L_0x0299
        L_0x023c:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.v(r8, r6, r3)
            goto L_0x0299
        L_0x0245:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.c(r8, r6)
            goto L_0x0299
        L_0x024e:
            java.util.List r6 = J(r1, r9)
            com.google.protobuf.i1 r7 = r15.u(r4)
            int r6 = com.google.protobuf.k1.p(r8, r6, r7)
            goto L_0x0299
        L_0x025b:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.u(r8, r6)
            goto L_0x0299
        L_0x0264:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.a(r8, r6, r3)
            goto L_0x0299
        L_0x026d:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.k(r8, r6, r3)
            goto L_0x0299
        L_0x0276:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.x(r8, r6, r3)
            goto L_0x0299
        L_0x027f:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.m(r8, r6, r3)
            goto L_0x0299
        L_0x0288:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.f(r8, r6, r3)
            goto L_0x0299
        L_0x0291:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.k1.h(r8, r6, r3)
        L_0x0299:
            int r5 = r5 + r6
            goto L_0x03a6
        L_0x029c:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x02a2:
            java.lang.Object r6 = com.google.protobuf.t1.G(r1, r9)
            com.google.protobuf.s0 r6 = (com.google.protobuf.s0) r6
            com.google.protobuf.i1 r7 = r15.u(r4)
            int r6 = com.google.protobuf.l.t(r8, r6, r7)
            goto L_0x0299
        L_0x02b1:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            long r6 = com.google.protobuf.t1.E(r1, r9)
        L_0x02bb:
            int r6 = com.google.protobuf.l.S(r8, r6)
            goto L_0x0299
        L_0x02c0:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = com.google.protobuf.t1.C(r1, r9)
        L_0x02ca:
            int r6 = com.google.protobuf.l.Q(r8, r6)
            goto L_0x0299
        L_0x02cf:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x02d5:
            int r6 = com.google.protobuf.l.O(r8, r13)
            goto L_0x0299
        L_0x02da:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x02e0:
            int r6 = com.google.protobuf.l.M(r8, r3)
            goto L_0x0299
        L_0x02e5:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = com.google.protobuf.t1.C(r1, r9)
        L_0x02ef:
            int r6 = com.google.protobuf.l.l(r8, r6)
            goto L_0x0299
        L_0x02f4:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = com.google.protobuf.t1.C(r1, r9)
        L_0x02fe:
            int r6 = com.google.protobuf.l.X(r8, r6)
            goto L_0x0299
        L_0x0303:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x0309:
            java.lang.Object r6 = com.google.protobuf.t1.G(r1, r9)
        L_0x030d:
            com.google.protobuf.i r6 = (com.google.protobuf.i) r6
            int r6 = com.google.protobuf.l.h(r8, r6)
            goto L_0x0299
        L_0x0314:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x031a:
            java.lang.Object r6 = com.google.protobuf.t1.G(r1, r9)
            com.google.protobuf.i1 r7 = r15.u(r4)
            int r6 = com.google.protobuf.k1.o(r8, r6, r7)
            goto L_0x0299
        L_0x0328:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            java.lang.Object r6 = com.google.protobuf.t1.G(r1, r9)
            boolean r7 = r6 instanceof com.google.protobuf.i
            if (r7 == 0) goto L_0x00aa
            goto L_0x00a8
        L_0x0338:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x033e:
            int r6 = com.google.protobuf.l.e(r8, r11)
            goto L_0x0299
        L_0x0344:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x034a:
            int r6 = com.google.protobuf.l.n(r8, r3)
            goto L_0x0299
        L_0x0350:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x0356:
            int r6 = com.google.protobuf.l.p(r8, r13)
            goto L_0x0299
        L_0x035c:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            int r6 = com.google.protobuf.t1.C(r1, r9)
        L_0x0366:
            int r6 = com.google.protobuf.l.w(r8, r6)
            goto L_0x0299
        L_0x036c:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            long r6 = com.google.protobuf.t1.E(r1, r9)
        L_0x0376:
            int r6 = com.google.protobuf.l.Z(r8, r6)
            goto L_0x0299
        L_0x037c:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
            long r6 = com.google.protobuf.t1.E(r1, r9)
        L_0x0386:
            int r6 = com.google.protobuf.l.y(r8, r6)
            goto L_0x0299
        L_0x038c:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x0392:
            int r6 = com.google.protobuf.l.r(r8, r12)
            goto L_0x0299
        L_0x0398:
            boolean r6 = r15.B(r1, r4)
            if (r6 == 0) goto L_0x03a6
        L_0x039e:
            r6 = 0
            int r6 = com.google.protobuf.l.j(r8, r6)
            goto L_0x0299
        L_0x03a6:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x03aa:
            com.google.protobuf.p1<?, ?> r2 = r0.f3715o
            int r1 = r15.y(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.x(java.lang.Object):int");
    }

    private <UT, UB> void x0(p1<UT, UB> p1Var, T t5, w1 w1Var) {
        p1Var.t(p1Var.g(t5), w1Var);
    }

    private <UT, UB> int y(p1<UT, UB> p1Var, T t5) {
        return p1Var.h(p1Var.g(t5));
    }

    private static <T> int z(T t5, long j5) {
        return t1.C(t5, j5);
    }

    public void a(T t5, T t6) {
        t6.getClass();
        for (int i5 = 0; i5 < this.f3701a.length; i5 += 3) {
            P(t5, t6, i5);
        }
        k1.G(this.f3715o, t5, t6);
        if (this.f3706f) {
            k1.E(this.f3716p, t5, t6);
        }
    }

    public void b(T t5, w1 w1Var) {
        if (w1Var.B() == w1.a.DESCENDING) {
            u0(t5, w1Var);
        } else if (this.f3708h) {
            t0(t5, w1Var);
        } else {
            s0(t5, w1Var);
        }
    }

    public void c(T t5) {
        int i5;
        int i6 = this.f3711k;
        while (true) {
            i5 = this.f3712l;
            if (i6 >= i5) {
                break;
            }
            long U = U(r0(this.f3710j[i6]));
            Object G = t1.G(t5, U);
            if (G != null) {
                t1.V(t5, U, this.f3717q.e(G));
            }
            i6++;
        }
        int length = this.f3710j.length;
        while (i5 < length) {
            this.f3714n.c(t5, (long) this.f3710j[i5]);
            i5++;
        }
        this.f3715o.j(t5);
        if (this.f3706f) {
            this.f3716p.f(t5);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v42, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03a4, code lost:
        if (r0 != r15) goto L_0x03a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x03e4, code lost:
        if (r0 != r15) goto L_0x03a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0404, code lost:
        if (r0 != r15) goto L_0x03a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0407, code lost:
        r8 = r35;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e8, code lost:
        r10.putObject(r4, r13, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0233, code lost:
        r1 = r6 | r21;
        r14 = r4;
        r13 = r5;
        r2 = r8;
        r3 = r11;
        r6 = r24;
        r11 = r35;
        r5 = r1;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0285, code lost:
        r10.putInt(r4, r13, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02b2, code lost:
        r2 = r8;
        r3 = r11;
        r14 = r13;
        r1 = r17;
        r6 = r24;
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02f7, code lost:
        r5 = r6 | r21;
        r13 = r34;
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02fc, code lost:
        r2 = r8;
        r3 = r11;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0302, code lost:
        r2 = r3;
        r23 = r6;
        r21 = r8;
        r27 = r10;
        r9 = r11;
        r8 = r35;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c0(T r31, byte[] r32, int r33, int r34, int r35, com.google.protobuf.e.b r36) {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = f3700s
            r16 = 0
            r0 = r33
            r2 = r16
            r3 = r2
            r5 = r3
            r1 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x0462
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.protobuf.e.H(r0, r12, r3, r9)
            int r3 = r9.f3498a
            r4 = r3
            r3 = r0
            goto L_0x002c
        L_0x002b:
            r4 = r0
        L_0x002c:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x0039
            int r2 = r2 / r8
            int r1 = r15.g0(r0, r2)
            goto L_0x003d
        L_0x0039:
            int r1 = r15.f0(r0)
        L_0x003d:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0052
            r17 = r0
            r18 = r1
            r2 = r3
            r9 = r4
            r23 = r5
            r24 = r6
            r27 = r10
            r8 = r11
            r21 = r16
            goto L_0x040b
        L_0x0052:
            int[] r1 = r15.f3701a
            int r19 = r2 + 1
            r1 = r1[r19]
            int r8 = q0(r1)
            long r11 = U(r1)
            r19 = r4
            r4 = 17
            r20 = r1
            if (r8 > r4) goto L_0x030e
            int[] r4 = r15.f3701a
            int r21 = r2 + 2
            r4 = r4[r21]
            int r21 = r4 >>> 20
            r1 = 1
            int r21 = r1 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r13
            r17 = r2
            if (r4 == r6) goto L_0x0089
            if (r6 == r13) goto L_0x0081
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x0081:
            long r1 = (long) r4
            int r5 = r10.getInt(r14, r1)
            r24 = r4
            goto L_0x008b
        L_0x0089:
            r24 = r6
        L_0x008b:
            r6 = r5
            r1 = 5
            switch(r8) {
                case 0: goto L_0x02da;
                case 1: goto L_0x02bd;
                case 2: goto L_0x028a;
                case 3: goto L_0x028a;
                case 4: goto L_0x026c;
                case 5: goto L_0x0242;
                case 6: goto L_0x0215;
                case 7: goto L_0x01ec;
                case 8: goto L_0x01c1;
                case 9: goto L_0x018c;
                case 10: goto L_0x0172;
                case 11: goto L_0x026c;
                case 12: goto L_0x013e;
                case 13: goto L_0x0215;
                case 14: goto L_0x0242;
                case 15: goto L_0x011f;
                case 16: goto L_0x00ef;
                case 17: goto L_0x009f;
                default: goto L_0x0090;
            }
        L_0x0090:
            r12 = r32
            r4 = r14
            r8 = r17
            r11 = r19
            r18 = -1
            r17 = r0
        L_0x009b:
            r19 = r13
            goto L_0x0302
        L_0x009f:
            r2 = 3
            if (r7 != r2) goto L_0x00e3
            int r1 = r0 << 3
            r4 = r1 | 4
            r2 = r17
            com.google.protobuf.i1 r1 = r15.u(r2)
            r17 = r0
            r0 = r1
            r18 = -1
            r1 = r32
            r8 = r2
            r2 = r3
            r3 = r34
            r7 = r19
            r5 = r36
            int r0 = com.google.protobuf.e.n(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r21
            if (r1 != 0) goto L_0x00c6
            java.lang.Object r1 = r9.f3500c
            goto L_0x00d0
        L_0x00c6:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.f3500c
            java.lang.Object r1 = com.google.protobuf.b0.h(r1, r2)
        L_0x00d0:
            r10.putObject(r14, r11, r1)
            r5 = r6 | r21
            r12 = r32
            r13 = r34
            r11 = r35
            r3 = r7
            r2 = r8
            r1 = r17
            r6 = r24
            goto L_0x001a
        L_0x00e3:
            r8 = r17
            r18 = -1
            r17 = r0
            r12 = r32
            r4 = r14
            r11 = r19
            goto L_0x009b
        L_0x00ef:
            r8 = r17
            r4 = r19
            r18 = -1
            r17 = r0
            if (r7 != 0) goto L_0x0118
            r1 = r11
            r12 = r32
            int r7 = com.google.protobuf.e.L(r12, r3, r9)
            long r13 = r9.f3499b
            long r13 = com.google.protobuf.j.c(r13)
            r0 = r10
            r2 = r1
            r1 = r31
            r11 = r4
            r4 = r13
            r0.putLong(r1, r2, r4)
            r5 = r6 | r21
            r14 = r31
            r13 = r34
            r0 = r7
            goto L_0x02fc
        L_0x0118:
            r12 = r32
            r11 = r4
            r4 = r31
            goto L_0x009b
        L_0x011f:
            r13 = r11
            r8 = r17
            r11 = r19
            r18 = -1
            r12 = r32
            r17 = r0
            if (r7 != 0) goto L_0x013a
            int r0 = com.google.protobuf.e.I(r12, r3, r9)
            int r1 = r9.f3498a
            int r1 = com.google.protobuf.j.b(r1)
            r4 = r31
            goto L_0x0285
        L_0x013a:
            r4 = r31
            goto L_0x01bc
        L_0x013e:
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r13 = r11
            r11 = r19
            r12 = r32
            if (r7 != 0) goto L_0x01bc
            int r0 = com.google.protobuf.e.I(r12, r3, r9)
            int r1 = r9.f3498a
            com.google.protobuf.b0$e r2 = r15.s(r8)
            if (r2 == 0) goto L_0x0285
            boolean r2 = r2.a(r1)
            if (r2 == 0) goto L_0x0160
            goto L_0x0285
        L_0x0160:
            com.google.protobuf.q1 r2 = v(r31)
            long r13 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r13)
            r2.q(r11, r1)
            r13 = r34
            r14 = r4
            r5 = r6
            goto L_0x02fc
        L_0x0172:
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r13 = r11
            r11 = r19
            r0 = 2
            r12 = r32
            if (r7 != r0) goto L_0x01bc
            int r0 = com.google.protobuf.e.b(r12, r3, r9)
            java.lang.Object r1 = r9.f3500c
            r10.putObject(r4, r13, r1)
            goto L_0x02f7
        L_0x018c:
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r13 = r11
            r11 = r19
            r0 = 2
            r12 = r32
            if (r7 != r0) goto L_0x01ba
            com.google.protobuf.i1 r0 = r15.u(r8)
            r5 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.protobuf.e.p(r0, r12, r3, r5, r9)
            r1 = r6 & r21
            if (r1 != 0) goto L_0x01af
            java.lang.Object r1 = r9.f3500c
            goto L_0x01e8
        L_0x01af:
            java.lang.Object r1 = r10.getObject(r4, r13)
            java.lang.Object r2 = r9.f3500c
            java.lang.Object r1 = com.google.protobuf.b0.h(r1, r2)
            goto L_0x01e8
        L_0x01ba:
            r5 = r34
        L_0x01bc:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0302
        L_0x01c1:
            r5 = r34
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r0 = 2
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != r0) goto L_0x0302
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01e2
            int r0 = com.google.protobuf.e.C(r12, r3, r9)
            goto L_0x01e6
        L_0x01e2:
            int r0 = com.google.protobuf.e.F(r12, r3, r9)
        L_0x01e6:
            java.lang.Object r1 = r9.f3500c
        L_0x01e8:
            r10.putObject(r4, r13, r1)
            goto L_0x0233
        L_0x01ec:
            r5 = r34
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != 0) goto L_0x0302
            int r0 = com.google.protobuf.e.L(r12, r3, r9)
            long r1 = r9.f3499b
            r25 = 0
            int r1 = (r1 > r25 ? 1 : (r1 == r25 ? 0 : -1))
            if (r1 == 0) goto L_0x020f
            r1 = 1
            goto L_0x0211
        L_0x020f:
            r1 = r16
        L_0x0211:
            com.google.protobuf.t1.L(r4, r13, r1)
            goto L_0x0233
        L_0x0215:
            r5 = r34
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != r1) goto L_0x0302
            int r0 = com.google.protobuf.e.h(r12, r3)
            r10.putInt(r4, r13, r0)
            int r0 = r3 + 4
        L_0x0233:
            r1 = r6 | r21
            r14 = r4
            r13 = r5
            r2 = r8
            r3 = r11
            r6 = r24
            r11 = r35
            r5 = r1
            r1 = r17
            goto L_0x001a
        L_0x0242:
            r5 = r34
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r0 = 1
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != r0) goto L_0x0302
            long r22 = com.google.protobuf.e.j(r12, r3)
            r0 = r10
            r1 = r31
            r7 = r3
            r2 = r13
            r13 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            r5 = r6 | r21
            goto L_0x02b2
        L_0x026c:
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != 0) goto L_0x0302
            int r0 = com.google.protobuf.e.I(r12, r3, r9)
            int r1 = r9.f3498a
        L_0x0285:
            r10.putInt(r4, r13, r1)
            goto L_0x02f7
        L_0x028a:
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != 0) goto L_0x0302
            int r7 = com.google.protobuf.e.L(r12, r3, r9)
            long r2 = r9.f3499b
            r0 = r10
            r1 = r31
            r22 = r2
            r2 = r13
            r13 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            r5 = r6 | r21
            r0 = r7
        L_0x02b2:
            r2 = r8
            r3 = r11
            r14 = r13
            r1 = r17
            r6 = r24
            r13 = r34
            goto L_0x0364
        L_0x02bd:
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != r1) goto L_0x0302
            float r0 = com.google.protobuf.e.l(r12, r3)
            com.google.protobuf.t1.S(r4, r13, r0)
            int r0 = r3 + 4
            goto L_0x02f7
        L_0x02da:
            r4 = r14
            r8 = r17
            r18 = -1
            r17 = r0
            r0 = 1
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r7 != r0) goto L_0x0302
            double r0 = com.google.protobuf.e.d(r12, r3)
            com.google.protobuf.t1.R(r4, r13, r0)
            int r0 = r3 + 8
        L_0x02f7:
            r5 = r6 | r21
            r13 = r34
            r14 = r4
        L_0x02fc:
            r2 = r8
            r3 = r11
            r1 = r17
            goto L_0x0362
        L_0x0302:
            r2 = r3
            r23 = r6
            r21 = r8
            r27 = r10
            r9 = r11
            r8 = r35
            goto L_0x040b
        L_0x030e:
            r17 = r0
            r4 = r14
            r18 = -1
            r13 = r11
            r11 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            r0 = 27
            if (r8 != r0) goto L_0x0375
            r0 = 2
            if (r7 != r0) goto L_0x0368
            java.lang.Object r0 = r10.getObject(r4, r13)
            com.google.protobuf.b0$i r0 = (com.google.protobuf.b0.i) r0
            boolean r1 = r0.k()
            if (r1 != 0) goto L_0x0340
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0337
            r1 = 10
            goto L_0x0339
        L_0x0337:
            int r1 = r1 * 2
        L_0x0339:
            com.google.protobuf.b0$i r0 = r0.a(r1)
            r10.putObject(r4, r13, r0)
        L_0x0340:
            r7 = r0
            com.google.protobuf.i1 r0 = r15.u(r2)
            r1 = r11
            r21 = r2
            r2 = r32
            r4 = r34
            r23 = r5
            r5 = r7
            r24 = r6
            r6 = r36
            int r0 = com.google.protobuf.e.q(r0, r1, r2, r3, r4, r5, r6)
            r14 = r31
            r13 = r34
            r3 = r11
            r1 = r17
            r2 = r21
            r5 = r23
        L_0x0362:
            r6 = r24
        L_0x0364:
            r11 = r35
            goto L_0x001a
        L_0x0368:
            r21 = r2
            r23 = r5
            r24 = r6
            r15 = r3
            r27 = r10
            r19 = r11
            goto L_0x03e7
        L_0x0375:
            r21 = r2
            r23 = r5
            r24 = r6
            r0 = 49
            if (r8 > r0) goto L_0x03c0
            r1 = r20
            long r5 = (long) r1
            r0 = r30
            r1 = r31
            r2 = r32
            r4 = r3
            r15 = r4
            r4 = r34
            r25 = r5
            r5 = r11
            r6 = r17
            r33 = r8
            r8 = r21
            r27 = r10
            r9 = r25
            r19 = r11
            r11 = r33
            r12 = r13
            r14 = r36
            int r0 = r0.e0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0407
        L_0x03a6:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r1 = r17
            r3 = r19
            r2 = r21
            r5 = r23
            r6 = r24
            r10 = r27
            goto L_0x001a
        L_0x03c0:
            r15 = r3
            r33 = r8
            r27 = r10
            r19 = r11
            r1 = r20
            r0 = 50
            r9 = r33
            if (r9 != r0) goto L_0x03ed
            r0 = 2
            if (r7 != r0) goto L_0x03e7
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r21
            r6 = r13
            r8 = r36
            int r0 = r0.a0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0407
            goto L_0x03a6
        L_0x03e7:
            r8 = r35
            r2 = r15
        L_0x03ea:
            r9 = r19
            goto L_0x040b
        L_0x03ed:
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r17
            r10 = r13
            r12 = r21
            r13 = r36
            int r0 = r0.b0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0407
            goto L_0x03a6
        L_0x0407:
            r8 = r35
            r2 = r0
            goto L_0x03ea
        L_0x040b:
            if (r9 != r8) goto L_0x041b
            if (r8 == 0) goto L_0x041b
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r30
            r0 = r2
            r3 = r9
            r5 = r23
            r6 = r24
            goto L_0x046d
        L_0x041b:
            r10 = r30
            boolean r0 = r10.f3706f
            r11 = r36
            if (r0 == 0) goto L_0x043d
            com.google.protobuf.q r0 = r11.f3501d
            com.google.protobuf.q r1 = com.google.protobuf.q.b()
            if (r0 == r1) goto L_0x043d
            com.google.protobuf.s0 r5 = r10.f3705e
            com.google.protobuf.p1<?, ?> r6 = r10.f3715o
            r0 = r9
            r1 = r32
            r3 = r34
            r4 = r31
            r7 = r36
            int r0 = com.google.protobuf.e.g(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x044c
        L_0x043d:
            com.google.protobuf.q1 r4 = v(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.protobuf.e.G(r0, r1, r2, r3, r4, r5)
        L_0x044c:
            r14 = r31
            r12 = r32
            r13 = r34
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r17
            r2 = r21
            r5 = r23
            r6 = r24
            r10 = r27
            r11 = r8
            goto L_0x001a
        L_0x0462:
            r23 = r5
            r24 = r6
            r27 = r10
            r8 = r11
            r10 = r15
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x046d:
            if (r6 == r1) goto L_0x0478
            long r1 = (long) r6
            r4 = r31
            r6 = r27
            r6.putInt(r4, r1, r5)
            goto L_0x047a
        L_0x0478:
            r4 = r31
        L_0x047a:
            r1 = 0
            int r2 = r10.f3711k
        L_0x047d:
            int r5 = r10.f3712l
            if (r2 >= r5) goto L_0x0490
            int[] r5 = r10.f3710j
            r5 = r5[r2]
            com.google.protobuf.p1<?, ?> r6 = r10.f3715o
            java.lang.Object r1 = r10.p(r4, r5, r1, r6)
            com.google.protobuf.q1 r1 = (com.google.protobuf.q1) r1
            int r2 = r2 + 1
            goto L_0x047d
        L_0x0490:
            if (r1 == 0) goto L_0x0497
            com.google.protobuf.p1<?, ?> r2 = r10.f3715o
            r2.o(r4, r1)
        L_0x0497:
            r1 = r34
            if (r8 != 0) goto L_0x04a3
            if (r0 != r1) goto L_0x049e
            goto L_0x04a7
        L_0x049e:
            com.google.protobuf.c0 r0 = com.google.protobuf.c0.h()
            throw r0
        L_0x04a3:
            if (r0 > r1) goto L_0x04a8
            if (r3 != r8) goto L_0x04a8
        L_0x04a7:
            return r0
        L_0x04a8:
            com.google.protobuf.c0 r0 = com.google.protobuf.c0.h()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.c0(java.lang.Object, byte[], int, int, int, com.google.protobuf.e$b):int");
    }

    public final boolean d(T t5) {
        int i5;
        int i6;
        T t6 = t5;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i9 < this.f3711k) {
            int i10 = this.f3710j[i9];
            int T = T(i10);
            int r02 = r0(i10);
            int i11 = this.f3701a[i10 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i7) {
                if (i12 != 1048575) {
                    i8 = f3700s.getInt(t6, (long) i12);
                }
                i5 = i8;
                i6 = i12;
            } else {
                i6 = i7;
                i5 = i8;
            }
            if (I(r02) && !C(t5, i10, i6, i5, i13)) {
                return false;
            }
            int q02 = q0(r02);
            if (q02 != 9 && q02 != 17) {
                if (q02 != 27) {
                    if (q02 == 60 || q02 == 68) {
                        if (H(t6, T, i10) && !D(t6, r02, u(i10))) {
                            return false;
                        }
                    } else if (q02 != 49) {
                        if (q02 == 50 && !F(t6, r02, i10)) {
                            return false;
                        }
                    }
                }
                if (!E(t6, r02, i10)) {
                    return false;
                }
            } else if (C(t5, i10, i6, i5, i13) && !D(t6, r02, u(i10))) {
                return false;
            }
            i9++;
            i7 = i6;
            i8 = i5;
        }
        return !this.f3706f || this.f3716p.c(t6).o();
    }

    public void e(T t5, h1 h1Var, q qVar) {
        qVar.getClass();
        L(this.f3715o, this.f3716p, t5, h1Var, qVar);
    }

    public boolean f(T t5, T t6) {
        int length = this.f3701a.length;
        for (int i5 = 0; i5 < length; i5 += 3) {
            if (!o(t5, t6, i5)) {
                return false;
            }
        }
        if (!this.f3715o.g(t5).equals(this.f3715o.g(t6))) {
            return false;
        }
        if (this.f3706f) {
            return this.f3716p.c(t5).equals(this.f3716p.c(t6));
        }
        return true;
    }

    public void g(T t5, byte[] bArr, int i5, int i6, e.b bVar) {
        if (this.f3708h) {
            d0(t5, bArr, i5, i6, bVar);
        } else {
            c0(t5, bArr, i5, i6, 0, bVar);
        }
    }

    public int h(T t5) {
        return this.f3708h ? x(t5) : w(t5);
    }

    public T i() {
        return this.f3713m.a(this.f3705e);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        r3 = com.google.protobuf.t1.G(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0091, code lost:
        r2 = r2 * 53;
        r3 = Y(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        r2 = r2 * 53;
        r3 = Z(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        if (r3 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cf, code lost:
        r2 = r2 * 53;
        r3 = com.google.protobuf.t1.G(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d5, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r3 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e4, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e8, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.protobuf.t1.G(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fb, code lost:
        r3 = com.google.protobuf.b0.c(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0114, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011f, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0123, code lost:
        r3 = com.google.protobuf.b0.f(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0127, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0128, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f3701a
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x012c
            int r3 = r8.r0(r1)
            int r4 = r8.T(r1)
            long r5 = U(r3)
            int r3 = q0(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0119;
                case 1: goto L_0x010e;
                case 2: goto L_0x0107;
                case 3: goto L_0x0107;
                case 4: goto L_0x0100;
                case 5: goto L_0x0107;
                case 6: goto L_0x0100;
                case 7: goto L_0x00f5;
                case 8: goto L_0x00e8;
                case 9: goto L_0x00da;
                case 10: goto L_0x00cf;
                case 11: goto L_0x0100;
                case 12: goto L_0x0100;
                case 13: goto L_0x0100;
                case 14: goto L_0x0107;
                case 15: goto L_0x0100;
                case 16: goto L_0x0107;
                case 17: goto L_0x00c8;
                case 18: goto L_0x00cf;
                case 19: goto L_0x00cf;
                case 20: goto L_0x00cf;
                case 21: goto L_0x00cf;
                case 22: goto L_0x00cf;
                case 23: goto L_0x00cf;
                case 24: goto L_0x00cf;
                case 25: goto L_0x00cf;
                case 26: goto L_0x00cf;
                case 27: goto L_0x00cf;
                case 28: goto L_0x00cf;
                case 29: goto L_0x00cf;
                case 30: goto L_0x00cf;
                case 31: goto L_0x00cf;
                case 32: goto L_0x00cf;
                case 33: goto L_0x00cf;
                case 34: goto L_0x00cf;
                case 35: goto L_0x00cf;
                case 36: goto L_0x00cf;
                case 37: goto L_0x00cf;
                case 38: goto L_0x00cf;
                case 39: goto L_0x00cf;
                case 40: goto L_0x00cf;
                case 41: goto L_0x00cf;
                case 42: goto L_0x00cf;
                case 43: goto L_0x00cf;
                case 44: goto L_0x00cf;
                case 45: goto L_0x00cf;
                case 46: goto L_0x00cf;
                case 47: goto L_0x00cf;
                case 48: goto L_0x00cf;
                case 49: goto L_0x00cf;
                case 50: goto L_0x00cf;
                case 51: goto L_0x00bb;
                case 52: goto L_0x00ae;
                case 53: goto L_0x00a0;
                case 54: goto L_0x0099;
                case 55: goto L_0x008b;
                case 56: goto L_0x0084;
                case 57: goto L_0x007d;
                case 58: goto L_0x006f;
                case 59: goto L_0x0067;
                case 60: goto L_0x0059;
                case 61: goto L_0x0051;
                case 62: goto L_0x004a;
                case 63: goto L_0x0043;
                case 64: goto L_0x003c;
                case 65: goto L_0x0034;
                case 66: goto L_0x002d;
                case 67: goto L_0x0025;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0128
        L_0x001e:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x005f
        L_0x0025:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x00a6
        L_0x002d:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0049
        L_0x0034:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x00a6
        L_0x003c:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0049
        L_0x0043:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
        L_0x0049:
            goto L_0x0091
        L_0x004a:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0091
        L_0x0051:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x00cf
        L_0x0059:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
        L_0x005f:
            java.lang.Object r3 = com.google.protobuf.t1.G(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d5
        L_0x0067:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x00e8
        L_0x006f:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            int r2 = r2 * 53
            boolean r3 = V(r9, r5)
            goto L_0x00fb
        L_0x007d:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0091
        L_0x0084:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x00a6
        L_0x008b:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
        L_0x0091:
            int r2 = r2 * 53
            int r3 = Y(r9, r5)
            goto L_0x0127
        L_0x0099:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x00a6
        L_0x00a0:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
        L_0x00a6:
            int r2 = r2 * 53
            long r3 = Z(r9, r5)
            goto L_0x0123
        L_0x00ae:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            int r2 = r2 * 53
            float r3 = X(r9, r5)
            goto L_0x0114
        L_0x00bb:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0128
            int r2 = r2 * 53
            double r3 = W(r9, r5)
            goto L_0x011f
        L_0x00c8:
            java.lang.Object r3 = com.google.protobuf.t1.G(r9, r5)
            if (r3 == 0) goto L_0x00e4
            goto L_0x00e0
        L_0x00cf:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.t1.G(r9, r5)
        L_0x00d5:
            int r3 = r3.hashCode()
            goto L_0x0127
        L_0x00da:
            java.lang.Object r3 = com.google.protobuf.t1.G(r9, r5)
            if (r3 == 0) goto L_0x00e4
        L_0x00e0:
            int r7 = r3.hashCode()
        L_0x00e4:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0128
        L_0x00e8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.t1.G(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0127
        L_0x00f5:
            int r2 = r2 * 53
            boolean r3 = com.google.protobuf.t1.t(r9, r5)
        L_0x00fb:
            int r3 = com.google.protobuf.b0.c(r3)
            goto L_0x0127
        L_0x0100:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.t1.C(r9, r5)
            goto L_0x0127
        L_0x0107:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.t1.E(r9, r5)
            goto L_0x0123
        L_0x010e:
            int r2 = r2 * 53
            float r3 = com.google.protobuf.t1.B(r9, r5)
        L_0x0114:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0127
        L_0x0119:
            int r2 = r2 * 53
            double r3 = com.google.protobuf.t1.A(r9, r5)
        L_0x011f:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0123:
            int r3 = com.google.protobuf.b0.f(r3)
        L_0x0127:
            int r2 = r2 + r3
        L_0x0128:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x012c:
            int r2 = r2 * 53
            com.google.protobuf.p1<?, ?> r0 = r8.f3715o
            java.lang.Object r0 = r0.g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f3706f
            if (r0 == 0) goto L_0x014a
            int r2 = r2 * 53
            com.google.protobuf.r<?> r0 = r8.f3716p
            com.google.protobuf.v r9 = r0.c(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x014a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.j(java.lang.Object):int");
    }
}
