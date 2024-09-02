package com.google.protobuf;

import com.google.protobuf.l0;
import com.yalantis.ucrop.BuildConfig;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

abstract class f implements h1 {

    private static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f3508a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f3509b;

        /* renamed from: c  reason: collision with root package name */
        private int f3510c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3511d;

        /* renamed from: e  reason: collision with root package name */
        private int f3512e;

        /* renamed from: f  reason: collision with root package name */
        private int f3513f;

        /* renamed from: g  reason: collision with root package name */
        private int f3514g;

        public b(ByteBuffer byteBuffer, boolean z4) {
            super();
            this.f3508a = z4;
            this.f3509b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f3510c = arrayOffset;
            this.f3511d = arrayOffset;
            this.f3512e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean R() {
            return this.f3510c == this.f3512e;
        }

        private byte S() {
            int i5 = this.f3510c;
            if (i5 != this.f3512e) {
                byte[] bArr = this.f3509b;
                this.f3510c = i5 + 1;
                return bArr[i5];
            }
            throw c0.m();
        }

        private <T> T T(i1<T> i1Var, q qVar) {
            int i5 = this.f3514g;
            this.f3514g = v1.c(v1.a(this.f3513f), 4);
            try {
                T i6 = i1Var.i();
                i1Var.e(i6, this, qVar);
                i1Var.c(i6);
                if (this.f3513f == this.f3514g) {
                    return i6;
                }
                throw c0.h();
            } finally {
                this.f3514g = i5;
            }
        }

        private int U() {
            e0(4);
            return V();
        }

        private int V() {
            int i5 = this.f3510c;
            byte[] bArr = this.f3509b;
            this.f3510c = i5 + 4;
            return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
        }

        private long W() {
            e0(8);
            return X();
        }

        private long X() {
            int i5 = this.f3510c;
            byte[] bArr = this.f3509b;
            this.f3510c = i5 + 8;
            return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
        }

        private <T> T Y(i1<T> i1Var, q qVar) {
            int b02 = b0();
            e0(b02);
            int i5 = this.f3512e;
            int i6 = this.f3510c + b02;
            this.f3512e = i6;
            try {
                T i7 = i1Var.i();
                i1Var.e(i7, this, qVar);
                i1Var.c(i7);
                if (this.f3510c == i6) {
                    return i7;
                }
                throw c0.h();
            } finally {
                this.f3512e = i5;
            }
        }

        private int b0() {
            byte b5;
            int i5 = this.f3510c;
            int i6 = this.f3512e;
            if (i6 != i5) {
                byte[] bArr = this.f3509b;
                int i7 = i5 + 1;
                byte b6 = bArr[i5];
                if (b6 >= 0) {
                    this.f3510c = i7;
                    return b6;
                } else if (i6 - i7 < 9) {
                    return (int) d0();
                } else {
                    int i8 = i7 + 1;
                    byte b7 = b6 ^ (bArr[i7] << 7);
                    if (b7 < 0) {
                        b5 = b7 ^ Byte.MIN_VALUE;
                    } else {
                        int i9 = i8 + 1;
                        byte b8 = b7 ^ (bArr[i8] << 14);
                        if (b8 >= 0) {
                            b5 = b8 ^ 16256;
                        } else {
                            i8 = i9 + 1;
                            byte b9 = b8 ^ (bArr[i9] << 21);
                            if (b9 < 0) {
                                b5 = b9 ^ -2080896;
                            } else {
                                i9 = i8 + 1;
                                byte b10 = bArr[i8];
                                b5 = (b9 ^ (b10 << 28)) ^ 266354560;
                                if (b10 < 0) {
                                    i8 = i9 + 1;
                                    if (bArr[i9] < 0) {
                                        i9 = i8 + 1;
                                        if (bArr[i8] < 0) {
                                            i8 = i9 + 1;
                                            if (bArr[i9] < 0) {
                                                i9 = i8 + 1;
                                                if (bArr[i8] < 0) {
                                                    i8 = i9 + 1;
                                                    if (bArr[i9] < 0) {
                                                        throw c0.f();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i8 = i9;
                    }
                    this.f3510c = i8;
                    return b5;
                }
            } else {
                throw c0.m();
            }
        }

        private long d0() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte S = S();
                j5 |= ((long) (S & Byte.MAX_VALUE)) << i5;
                if ((S & 128) == 0) {
                    return j5;
                }
            }
            throw c0.f();
        }

        private void e0(int i5) {
            if (i5 < 0 || i5 > this.f3512e - this.f3510c) {
                throw c0.m();
            }
        }

        private void f0(int i5) {
            if (this.f3510c != i5) {
                throw c0.m();
            }
        }

        private void g0(int i5) {
            if (v1.b(this.f3513f) != i5) {
                throw c0.e();
            }
        }

        private void h0(int i5) {
            e0(i5);
            this.f3510c += i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void i0() {
            /*
                r3 = this;
                int r0 = r3.f3514g
                int r1 = r3.f3513f
                int r1 = com.google.protobuf.v1.a(r1)
                r2 = 4
                int r1 = com.google.protobuf.v1.c(r1, r2)
                r3.f3514g = r1
            L_0x000f:
                int r1 = r3.t()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.F()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.f3513f
                int r2 = r3.f3514g
                if (r1 != r2) goto L_0x0027
                r3.f3514g = r0
                return
            L_0x0027:
                com.google.protobuf.c0 r0 = com.google.protobuf.c0.h()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.b.i0():void");
        }

        private void j0() {
            int i5 = this.f3512e;
            int i6 = this.f3510c;
            if (i5 - i6 >= 10) {
                byte[] bArr = this.f3509b;
                int i7 = 0;
                while (i7 < 10) {
                    int i8 = i6 + 1;
                    if (bArr[i6] >= 0) {
                        this.f3510c = i8;
                        return;
                    } else {
                        i7++;
                        i6 = i8;
                    }
                }
            }
            k0();
        }

        private void k0() {
            int i5 = 0;
            while (i5 < 10) {
                if (S() < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw c0.f();
        }

        private void l0(int i5) {
            e0(i5);
            if ((i5 & 3) != 0) {
                throw c0.h();
            }
        }

        private void m0(int i5) {
            e0(i5);
            if ((i5 & 7) != 0) {
                throw c0.h();
            }
        }

        public <T> T A(i1<T> i1Var, q qVar) {
            g0(3);
            return T(i1Var, qVar);
        }

        public i B() {
            g0(2);
            int b02 = b0();
            if (b02 == 0) {
                return i.f3533f;
            }
            e0(b02);
            i G = this.f3508a ? i.G(this.f3509b, this.f3510c, b02) : i.n(this.f3509b, this.f3510c, b02);
            this.f3510c += b02;
            return G;
        }

        public void C(List<Float> list) {
            int i5;
            int i6;
            if (list instanceof x) {
                x xVar = (x) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 2) {
                    int b02 = b0();
                    l0(b02);
                    int i7 = this.f3510c + b02;
                    while (this.f3510c < i7) {
                        xVar.i(Float.intBitsToFloat(V()));
                    }
                } else if (b5 == 5) {
                    do {
                        xVar.i(readFloat());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 2) {
                    int b03 = b0();
                    l0(b03);
                    int i8 = this.f3510c + b03;
                    while (this.f3510c < i8) {
                        list.add(Float.valueOf(Float.intBitsToFloat(V())));
                    }
                } else if (b6 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else {
                    throw c0.e();
                }
            }
        }

        public int D() {
            g0(0);
            return b0();
        }

        public int E() {
            g0(0);
            return b0();
        }

        public boolean F() {
            int i5;
            int i6;
            if (R() || (i5 = this.f3513f) == this.f3514g) {
                return false;
            }
            int b5 = v1.b(i5);
            if (b5 != 0) {
                if (b5 == 1) {
                    i6 = 8;
                } else if (b5 == 2) {
                    i6 = b0();
                } else if (b5 == 3) {
                    i0();
                    return true;
                } else if (b5 == 5) {
                    i6 = 4;
                } else {
                    throw c0.e();
                }
                h0(i6);
                return true;
            }
            j0();
            return true;
        }

        public int G() {
            g0(5);
            return U();
        }

        public void H(List<i> list) {
            int i5;
            if (v1.b(this.f3513f) == 2) {
                do {
                    list.add(B());
                    if (!R()) {
                        i5 = this.f3510c;
                    } else {
                        return;
                    }
                } while (b0() == this.f3513f);
                this.f3510c = i5;
                return;
            }
            throw c0.e();
        }

        public void I(List<Double> list) {
            int i5;
            int i6;
            if (list instanceof n) {
                n nVar = (n) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 1) {
                    do {
                        nVar.i(readDouble());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else if (b5 == 2) {
                    int b02 = b0();
                    m0(b02);
                    int i7 = this.f3510c + b02;
                    while (this.f3510c < i7) {
                        nVar.i(Double.longBitsToDouble(X()));
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else if (b6 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i8 = this.f3510c + b03;
                    while (this.f3510c < i8) {
                        list.add(Double.valueOf(Double.longBitsToDouble(X())));
                    }
                } else {
                    throw c0.e();
                }
            }
        }

        public void J(List<Long> list) {
            int i5;
            int i6;
            int i7;
            if (list instanceof j0) {
                j0 j0Var = (j0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        j0Var.l(L());
                        if (!R()) {
                            i7 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i7;
                    return;
                } else if (b5 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        j0Var.l(c0());
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Long.valueOf(L()));
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                    return;
                } else if (b6 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        list.add(Long.valueOf(c0()));
                    }
                } else {
                    throw c0.e();
                }
            }
            f0(i5);
        }

        public void K(List<Long> list) {
            int i5;
            int i6;
            if (list instanceof j0) {
                j0 j0Var = (j0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 1) {
                    do {
                        j0Var.l(v());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else if (b5 == 2) {
                    int b02 = b0();
                    m0(b02);
                    int i7 = this.f3510c + b02;
                    while (this.f3510c < i7) {
                        j0Var.l(X());
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 1) {
                    do {
                        list.add(Long.valueOf(v()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else if (b6 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i8 = this.f3510c + b03;
                    while (this.f3510c < i8) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw c0.e();
                }
            }
        }

        public long L() {
            g0(0);
            return c0();
        }

        public String M() {
            return Z(true);
        }

        public void N(List<Long> list) {
            int i5;
            int i6;
            if (list instanceof j0) {
                j0 j0Var = (j0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 1) {
                    do {
                        j0Var.l(f());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else if (b5 == 2) {
                    int b02 = b0();
                    m0(b02);
                    int i7 = this.f3510c + b02;
                    while (this.f3510c < i7) {
                        j0Var.l(X());
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 1) {
                    do {
                        list.add(Long.valueOf(f()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else if (b6 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i8 = this.f3510c + b03;
                    while (this.f3510c < i8) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw c0.e();
                }
            }
        }

        public void O(List<Integer> list) {
            int i5;
            int i6;
            int i7;
            if (list instanceof a0) {
                a0 a0Var = (a0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        a0Var.i(E());
                        if (!R()) {
                            i7 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i7;
                    return;
                } else if (b5 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        a0Var.i(b0());
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Integer.valueOf(E()));
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                    return;
                } else if (b6 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw c0.e();
                }
            }
            f0(i5);
        }

        public void P(List<Integer> list) {
            int i5;
            int i6;
            if (list instanceof a0) {
                a0 a0Var = (a0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        a0Var.i(b());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else if (b5 == 2) {
                    int b02 = this.f3510c + b0();
                    while (this.f3510c < b02) {
                        a0Var.i(b0());
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Integer.valueOf(b()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else if (b6 == 2) {
                    int b03 = this.f3510c + b0();
                    while (this.f3510c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw c0.e();
                }
            }
        }

        public String Z(boolean z4) {
            g0(2);
            int b02 = b0();
            if (b02 == 0) {
                return BuildConfig.FLAVOR;
            }
            e0(b02);
            if (z4) {
                byte[] bArr = this.f3509b;
                int i5 = this.f3510c;
                if (!u1.t(bArr, i5, i5 + b02)) {
                    throw c0.d();
                }
            }
            String str = new String(this.f3509b, this.f3510c, b02, b0.f3469a);
            this.f3510c += b02;
            return str;
        }

        public void a(List<Integer> list) {
            int i5;
            int i6;
            if (list instanceof a0) {
                a0 a0Var = (a0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        a0Var.i(h());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else if (b5 == 2) {
                    int b02 = this.f3510c + b0();
                    while (this.f3510c < b02) {
                        a0Var.i(j.b(b0()));
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Integer.valueOf(h()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else if (b6 == 2) {
                    int b03 = this.f3510c + b0();
                    while (this.f3510c < b03) {
                        list.add(Integer.valueOf(j.b(b0())));
                    }
                } else {
                    throw c0.e();
                }
            }
        }

        public void a0(List<String> list, boolean z4) {
            int i5;
            int i6;
            if (v1.b(this.f3513f) != 2) {
                throw c0.e();
            } else if (!(list instanceof h0) || z4) {
                do {
                    list.add(Z(z4));
                    if (!R()) {
                        i5 = this.f3510c;
                    } else {
                        return;
                    }
                } while (b0() == this.f3513f);
                this.f3510c = i5;
            } else {
                h0 h0Var = (h0) list;
                do {
                    h0Var.d(B());
                    if (!R()) {
                        i6 = this.f3510c;
                    } else {
                        return;
                    }
                } while (b0() == this.f3513f);
                this.f3510c = i6;
            }
        }

        public int b() {
            g0(0);
            return b0();
        }

        public int c() {
            return this.f3513f;
        }

        public long c0() {
            long j5;
            int i5;
            long j6;
            long j7;
            byte b5;
            int i6 = this.f3510c;
            int i7 = this.f3512e;
            if (i7 != i6) {
                byte[] bArr = this.f3509b;
                int i8 = i6 + 1;
                byte b6 = bArr[i6];
                if (b6 >= 0) {
                    this.f3510c = i8;
                    return (long) b6;
                } else if (i7 - i8 < 9) {
                    return d0();
                } else {
                    int i9 = i8 + 1;
                    byte b7 = b6 ^ (bArr[i8] << 7);
                    if (b7 < 0) {
                        b5 = b7 ^ Byte.MIN_VALUE;
                    } else {
                        int i10 = i9 + 1;
                        byte b8 = b7 ^ (bArr[i9] << 14);
                        if (b8 >= 0) {
                            i5 = i10;
                            j5 = (long) (b8 ^ 16256);
                        } else {
                            i9 = i10 + 1;
                            byte b9 = b8 ^ (bArr[i10] << 21);
                            if (b9 < 0) {
                                b5 = b9 ^ -2080896;
                            } else {
                                long j8 = (long) b9;
                                int i11 = i9 + 1;
                                long j9 = j8 ^ (((long) bArr[i9]) << 28);
                                if (j9 >= 0) {
                                    j7 = 266354560;
                                } else {
                                    int i12 = i11 + 1;
                                    long j10 = j9 ^ (((long) bArr[i11]) << 35);
                                    if (j10 < 0) {
                                        j6 = -34093383808L;
                                    } else {
                                        i11 = i12 + 1;
                                        j9 = j10 ^ (((long) bArr[i12]) << 42);
                                        if (j9 >= 0) {
                                            j7 = 4363953127296L;
                                        } else {
                                            i12 = i11 + 1;
                                            j10 = j9 ^ (((long) bArr[i11]) << 49);
                                            if (j10 < 0) {
                                                j6 = -558586000294016L;
                                            } else {
                                                int i13 = i12 + 1;
                                                long j11 = (j10 ^ (((long) bArr[i12]) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    i5 = i13 + 1;
                                                    if (((long) bArr[i13]) < 0) {
                                                        throw c0.f();
                                                    }
                                                } else {
                                                    i5 = i13;
                                                }
                                                j5 = j11;
                                            }
                                        }
                                    }
                                    j5 = j10 ^ j6;
                                }
                                j5 = j9 ^ j7;
                                i5 = i11;
                            }
                        }
                        this.f3510c = i5;
                        return j5;
                    }
                    j5 = (long) b5;
                    this.f3510c = i5;
                    return j5;
                }
            } else {
                throw c0.m();
            }
        }

        public long d() {
            g0(0);
            return c0();
        }

        public void e(List<Integer> list) {
            int i5;
            int i6;
            if (list instanceof a0) {
                a0 a0Var = (a0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 2) {
                    int b02 = b0();
                    l0(b02);
                    int i7 = this.f3510c + b02;
                    while (this.f3510c < i7) {
                        a0Var.i(V());
                    }
                } else if (b5 == 5) {
                    do {
                        a0Var.i(p());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 2) {
                    int b03 = b0();
                    l0(b03);
                    int i8 = this.f3510c + b03;
                    while (this.f3510c < i8) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (b6 == 5) {
                    do {
                        list.add(Integer.valueOf(p()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else {
                    throw c0.e();
                }
            }
        }

        public long f() {
            g0(1);
            return W();
        }

        public void g(List<Integer> list) {
            int i5;
            int i6;
            if (list instanceof a0) {
                a0 a0Var = (a0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 2) {
                    int b02 = b0();
                    l0(b02);
                    int i7 = this.f3510c + b02;
                    while (this.f3510c < i7) {
                        a0Var.i(V());
                    }
                } else if (b5 == 5) {
                    do {
                        a0Var.i(G());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 2) {
                    int b03 = b0();
                    l0(b03);
                    int i8 = this.f3510c + b03;
                    while (this.f3510c < i8) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (b6 == 5) {
                    do {
                        list.add(Integer.valueOf(G()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else {
                    throw c0.e();
                }
            }
        }

        public int h() {
            g0(0);
            return j.b(b0());
        }

        public void i(List<Long> list) {
            int i5;
            int i6;
            if (list instanceof j0) {
                j0 j0Var = (j0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        j0Var.l(k());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else if (b5 == 2) {
                    int b02 = this.f3510c + b0();
                    while (this.f3510c < b02) {
                        j0Var.l(j.c(c0()));
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Long.valueOf(k()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else if (b6 == 2) {
                    int b03 = this.f3510c + b0();
                    while (this.f3510c < b03) {
                        list.add(Long.valueOf(j.c(c0())));
                    }
                } else {
                    throw c0.e();
                }
            }
        }

        public <T> void j(List<T> list, i1<T> i1Var, q qVar) {
            int i5;
            if (v1.b(this.f3513f) == 3) {
                int i6 = this.f3513f;
                do {
                    list.add(T(i1Var, qVar));
                    if (!R()) {
                        i5 = this.f3510c;
                    } else {
                        return;
                    }
                } while (b0() == i6);
                this.f3510c = i5;
                return;
            }
            throw c0.e();
        }

        public long k() {
            g0(0);
            return j.c(c0());
        }

        public void l(List<Integer> list) {
            int i5;
            int i6;
            if (list instanceof a0) {
                a0 a0Var = (a0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        a0Var.i(D());
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                } else if (b5 == 2) {
                    int b02 = this.f3510c + b0();
                    while (this.f3510c < b02) {
                        a0Var.i(b0());
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Integer.valueOf(D()));
                        if (!R()) {
                            i5 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i5;
                } else if (b6 == 2) {
                    int b03 = this.f3510c + b0();
                    while (this.f3510c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw c0.e();
                }
            }
        }

        public <T> T m(Class<T> cls, q qVar) {
            g0(2);
            return Y(e1.a().d(cls), qVar);
        }

        public void n(List<Boolean> list) {
            int i5;
            int i6;
            int i7;
            if (list instanceof g) {
                g gVar = (g) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        gVar.l(r());
                        if (!R()) {
                            i7 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i7;
                    return;
                } else if (b5 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        gVar.l(b0() != 0);
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Boolean.valueOf(r()));
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                    return;
                } else if (b6 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        list.add(Boolean.valueOf(b0() != 0));
                    }
                } else {
                    throw c0.e();
                }
            }
            f0(i5);
        }

        public String o() {
            return Z(false);
        }

        public int p() {
            g0(5);
            return U();
        }

        public <T> T q(Class<T> cls, q qVar) {
            g0(3);
            return T(e1.a().d(cls), qVar);
        }

        public boolean r() {
            g0(0);
            return b0() != 0;
        }

        public double readDouble() {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        public float readFloat() {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        public <T> void s(List<T> list, i1<T> i1Var, q qVar) {
            int i5;
            if (v1.b(this.f3513f) == 2) {
                int i6 = this.f3513f;
                do {
                    list.add(Y(i1Var, qVar));
                    if (!R()) {
                        i5 = this.f3510c;
                    } else {
                        return;
                    }
                } while (b0() == i6);
                this.f3510c = i5;
                return;
            }
            throw c0.e();
        }

        public int t() {
            if (R()) {
                return Integer.MAX_VALUE;
            }
            int b02 = b0();
            this.f3513f = b02;
            if (b02 == this.f3514g) {
                return Integer.MAX_VALUE;
            }
            return v1.a(b02);
        }

        public void u(List<String> list) {
            a0(list, false);
        }

        public long v() {
            g0(1);
            return W();
        }

        public <T> T w(i1<T> i1Var, q qVar) {
            g0(2);
            return Y(i1Var, qVar);
        }

        public <K, V> void x(Map<K, V> map, l0.a<K, V> aVar, q qVar) {
            g0(2);
            int b02 = b0();
            e0(b02);
            int i5 = this.f3512e;
            this.f3512e = this.f3510c + b02;
            try {
                throw null;
            } catch (Throwable th) {
                this.f3512e = i5;
                throw th;
            }
        }

        public void y(List<Long> list) {
            int i5;
            int i6;
            int i7;
            if (list instanceof j0) {
                j0 j0Var = (j0) list;
                int b5 = v1.b(this.f3513f);
                if (b5 == 0) {
                    do {
                        j0Var.l(d());
                        if (!R()) {
                            i7 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i7;
                    return;
                } else if (b5 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        j0Var.l(c0());
                    }
                } else {
                    throw c0.e();
                }
            } else {
                int b6 = v1.b(this.f3513f);
                if (b6 == 0) {
                    do {
                        list.add(Long.valueOf(d()));
                        if (!R()) {
                            i6 = this.f3510c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3513f);
                    this.f3510c = i6;
                    return;
                } else if (b6 == 2) {
                    i5 = this.f3510c + b0();
                    while (this.f3510c < i5) {
                        list.add(Long.valueOf(c0()));
                    }
                } else {
                    throw c0.e();
                }
            }
            f0(i5);
        }

        public void z(List<String> list) {
            a0(list, true);
        }
    }

    private f() {
    }

    public static f Q(ByteBuffer byteBuffer, boolean z4) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z4);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
