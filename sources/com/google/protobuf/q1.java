package com.google.protobuf;

import com.google.protobuf.w1;
import java.util.Arrays;

public final class q1 {

    /* renamed from: f  reason: collision with root package name */
    private static final q1 f3653f = new q1(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f3654a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f3655b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f3656c;

    /* renamed from: d  reason: collision with root package name */
    private int f3657d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3658e;

    private q1() {
        this(0, new int[8], new Object[8], true);
    }

    private q1(int i5, int[] iArr, Object[] objArr, boolean z4) {
        this.f3657d = -1;
        this.f3654a = i5;
        this.f3655b = iArr;
        this.f3656c = objArr;
        this.f3658e = z4;
    }

    private void b() {
        int i5 = this.f3654a;
        int[] iArr = this.f3655b;
        if (i5 == iArr.length) {
            int i6 = i5 + (i5 < 4 ? 8 : i5 >> 1);
            this.f3655b = Arrays.copyOf(iArr, i6);
            this.f3656c = Arrays.copyOf(this.f3656c, i6);
        }
    }

    public static q1 c() {
        return f3653f;
    }

    private static int f(int[] iArr, int i5) {
        int i6 = 17;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        return i6;
    }

    private static int g(Object[] objArr, int i5) {
        int i6 = 17;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 31) + objArr[i7].hashCode();
        }
        return i6;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private com.google.protobuf.q1 j(com.google.protobuf.j r2) {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.E()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.i(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.q1.j(com.google.protobuf.j):com.google.protobuf.q1");
    }

    static q1 m(q1 q1Var, q1 q1Var2) {
        int i5 = q1Var.f3654a + q1Var2.f3654a;
        int[] copyOf = Arrays.copyOf(q1Var.f3655b, i5);
        System.arraycopy(q1Var2.f3655b, 0, copyOf, q1Var.f3654a, q1Var2.f3654a);
        Object[] copyOf2 = Arrays.copyOf(q1Var.f3656c, i5);
        System.arraycopy(q1Var2.f3656c, 0, copyOf2, q1Var.f3654a, q1Var2.f3654a);
        return new q1(i5, copyOf, copyOf2, true);
    }

    static q1 n() {
        return new q1();
    }

    private static boolean o(Object[] objArr, Object[] objArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (!objArr[i6].equals(objArr2[i6])) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(int[] iArr, int[] iArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (iArr[i6] != iArr2[i6]) {
                return false;
            }
        }
        return true;
    }

    private static void t(int i5, Object obj, w1 w1Var) {
        int a5 = v1.a(i5);
        int b5 = v1.b(i5);
        if (b5 == 0) {
            w1Var.e(a5, ((Long) obj).longValue());
        } else if (b5 == 1) {
            w1Var.A(a5, ((Long) obj).longValue());
        } else if (b5 == 2) {
            w1Var.l(a5, (i) obj);
        } else if (b5 != 3) {
            if (b5 == 5) {
                w1Var.p(a5, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(c0.e());
        } else if (w1Var.B() == w1.a.ASCENDING) {
            w1Var.k(a5);
            ((q1) obj).u(w1Var);
            w1Var.F(a5);
        } else {
            w1Var.F(a5);
            ((q1) obj).u(w1Var);
            w1Var.k(a5);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.f3658e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int i5;
        int i6 = this.f3657d;
        if (i6 != -1) {
            return i6;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.f3654a; i8++) {
            int i9 = this.f3655b[i8];
            int a5 = v1.a(i9);
            int b5 = v1.b(i9);
            if (b5 == 0) {
                i5 = l.Z(a5, ((Long) this.f3656c[i8]).longValue());
            } else if (b5 == 1) {
                i5 = l.p(a5, ((Long) this.f3656c[i8]).longValue());
            } else if (b5 == 2) {
                i5 = l.h(a5, (i) this.f3656c[i8]);
            } else if (b5 == 3) {
                i5 = (l.W(a5) * 2) + ((q1) this.f3656c[i8]).d();
            } else if (b5 == 5) {
                i5 = l.n(a5, ((Integer) this.f3656c[i8]).intValue());
            } else {
                throw new IllegalStateException(c0.e());
            }
            i7 += i5;
        }
        this.f3657d = i7;
        return i7;
    }

    public int e() {
        int i5 = this.f3657d;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f3654a; i7++) {
            i6 += l.K(v1.a(this.f3655b[i7]), (i) this.f3656c[i7]);
        }
        this.f3657d = i6;
        return i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof q1)) {
            return false;
        }
        q1 q1Var = (q1) obj;
        int i5 = this.f3654a;
        return i5 == q1Var.f3654a && r(this.f3655b, q1Var.f3655b, i5) && o(this.f3656c, q1Var.f3656c, this.f3654a);
    }

    public void h() {
        this.f3658e = false;
    }

    public int hashCode() {
        int i5 = this.f3654a;
        return ((((527 + i5) * 31) + f(this.f3655b, i5)) * 31) + g(this.f3656c, this.f3654a);
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i5, j jVar) {
        a();
        int a5 = v1.a(i5);
        int b5 = v1.b(i5);
        if (b5 == 0) {
            q(i5, Long.valueOf(jVar.w()));
            return true;
        } else if (b5 == 1) {
            q(i5, Long.valueOf(jVar.t()));
            return true;
        } else if (b5 == 2) {
            q(i5, jVar.p());
            return true;
        } else if (b5 == 3) {
            q1 q1Var = new q1();
            q1Var.j(jVar);
            jVar.a(v1.c(a5, 4));
            q(i5, q1Var);
            return true;
        } else if (b5 == 4) {
            return false;
        } else {
            if (b5 == 5) {
                q(i5, Integer.valueOf(jVar.s()));
                return true;
            }
            throw c0.e();
        }
    }

    /* access modifiers changed from: package-private */
    public q1 k(int i5, i iVar) {
        a();
        if (i5 != 0) {
            q(v1.c(i5, 2), iVar);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public q1 l(int i5, int i6) {
        a();
        if (i5 != 0) {
            q(v1.c(i5, 0), Long.valueOf((long) i6));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public final void p(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.f3654a; i6++) {
            u0.c(sb, i5, String.valueOf(v1.a(this.f3655b[i6])), this.f3656c[i6]);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i5, Object obj) {
        a();
        b();
        int[] iArr = this.f3655b;
        int i6 = this.f3654a;
        iArr[i6] = i5;
        this.f3656c[i6] = obj;
        this.f3654a = i6 + 1;
    }

    /* access modifiers changed from: package-private */
    public void s(w1 w1Var) {
        if (w1Var.B() == w1.a.DESCENDING) {
            for (int i5 = this.f3654a - 1; i5 >= 0; i5--) {
                w1Var.h(v1.a(this.f3655b[i5]), this.f3656c[i5]);
            }
            return;
        }
        for (int i6 = 0; i6 < this.f3654a; i6++) {
            w1Var.h(v1.a(this.f3655b[i6]), this.f3656c[i6]);
        }
    }

    public void u(w1 w1Var) {
        if (this.f3654a != 0) {
            if (w1Var.B() == w1.a.ASCENDING) {
                for (int i5 = 0; i5 < this.f3654a; i5++) {
                    t(this.f3655b[i5], this.f3656c[i5], w1Var);
                }
                return;
            }
            for (int i6 = this.f3654a - 1; i6 >= 0; i6--) {
                t(this.f3655b[i6], this.f3656c[i6], w1Var);
            }
        }
    }
}
