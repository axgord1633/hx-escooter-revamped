package com.google.protobuf;

import com.yalantis.ucrop.BuildConfig;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class j {

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f3548f = 100;

    /* renamed from: a  reason: collision with root package name */
    int f3549a;

    /* renamed from: b  reason: collision with root package name */
    int f3550b;

    /* renamed from: c  reason: collision with root package name */
    int f3551c;

    /* renamed from: d  reason: collision with root package name */
    k f3552d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3553e;

    private static final class b extends j {

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f3554g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f3555h;

        /* renamed from: i  reason: collision with root package name */
        private int f3556i;

        /* renamed from: j  reason: collision with root package name */
        private int f3557j;

        /* renamed from: k  reason: collision with root package name */
        private int f3558k;

        /* renamed from: l  reason: collision with root package name */
        private int f3559l;

        /* renamed from: m  reason: collision with root package name */
        private int f3560m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f3561n;

        /* renamed from: o  reason: collision with root package name */
        private int f3562o;

        private b(byte[] bArr, int i5, int i6, boolean z4) {
            super();
            this.f3562o = Integer.MAX_VALUE;
            this.f3554g = bArr;
            this.f3556i = i6 + i5;
            this.f3558k = i5;
            this.f3559l = i5;
            this.f3555h = z4;
        }

        private void P() {
            int i5 = this.f3556i + this.f3557j;
            this.f3556i = i5;
            int i6 = i5 - this.f3559l;
            int i7 = this.f3562o;
            if (i6 > i7) {
                int i8 = i6 - i7;
                this.f3557j = i8;
                this.f3556i = i5 - i8;
                return;
            }
            this.f3557j = 0;
        }

        private void S() {
            if (this.f3556i - this.f3558k >= 10) {
                T();
            } else {
                U();
            }
        }

        private void T() {
            int i5 = 0;
            while (i5 < 10) {
                byte[] bArr = this.f3554g;
                int i6 = this.f3558k;
                this.f3558k = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw c0.f();
        }

        private void U() {
            int i5 = 0;
            while (i5 < 10) {
                if (I() < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw c0.f();
        }

        public int A() {
            return j.b(M());
        }

        public long B() {
            return j.c(N());
        }

        public String C() {
            int M = M();
            if (M > 0) {
                int i5 = this.f3556i;
                int i6 = this.f3558k;
                if (M <= i5 - i6) {
                    String str = new String(this.f3554g, i6, M, b0.f3469a);
                    this.f3558k += M;
                    return str;
                }
            }
            if (M == 0) {
                return BuildConfig.FLAVOR;
            }
            if (M < 0) {
                throw c0.g();
            }
            throw c0.m();
        }

        public String D() {
            int M = M();
            if (M > 0) {
                int i5 = this.f3556i;
                int i6 = this.f3558k;
                if (M <= i5 - i6) {
                    String h5 = u1.h(this.f3554g, i6, M);
                    this.f3558k += M;
                    return h5;
                }
            }
            if (M == 0) {
                return BuildConfig.FLAVOR;
            }
            if (M <= 0) {
                throw c0.g();
            }
            throw c0.m();
        }

        public int E() {
            if (e()) {
                this.f3560m = 0;
                return 0;
            }
            int M = M();
            this.f3560m = M;
            if (v1.a(M) != 0) {
                return this.f3560m;
            }
            throw c0.c();
        }

        public int F() {
            return M();
        }

        public long G() {
            return N();
        }

        public boolean H(int i5) {
            int b5 = v1.b(i5);
            if (b5 == 0) {
                S();
                return true;
            } else if (b5 == 1) {
                R(8);
                return true;
            } else if (b5 == 2) {
                R(M());
                return true;
            } else if (b5 == 3) {
                Q();
                a(v1.c(v1.a(i5), 4));
                return true;
            } else if (b5 == 4) {
                return false;
            } else {
                if (b5 == 5) {
                    R(4);
                    return true;
                }
                throw c0.e();
            }
        }

        public byte I() {
            int i5 = this.f3558k;
            if (i5 != this.f3556i) {
                byte[] bArr = this.f3554g;
                this.f3558k = i5 + 1;
                return bArr[i5];
            }
            throw c0.m();
        }

        public byte[] J(int i5) {
            if (i5 > 0) {
                int i6 = this.f3556i;
                int i7 = this.f3558k;
                if (i5 <= i6 - i7) {
                    int i8 = i5 + i7;
                    this.f3558k = i8;
                    return Arrays.copyOfRange(this.f3554g, i7, i8);
                }
            }
            if (i5 > 0) {
                throw c0.m();
            } else if (i5 == 0) {
                return b0.f3471c;
            } else {
                throw c0.g();
            }
        }

        public int K() {
            int i5 = this.f3558k;
            if (this.f3556i - i5 >= 4) {
                byte[] bArr = this.f3554g;
                this.f3558k = i5 + 4;
                return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
            }
            throw c0.m();
        }

        public long L() {
            int i5 = this.f3558k;
            if (this.f3556i - i5 >= 8) {
                byte[] bArr = this.f3554g;
                this.f3558k = i5 + 8;
                return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
            }
            throw c0.m();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int M() {
            /*
                r5 = this;
                int r0 = r5.f3558k
                int r1 = r5.f3556i
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f3554g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f3558k = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.O()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f3558k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.b.M():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long N() {
            /*
                r11 = this;
                int r0 = r11.f3558k
                int r1 = r11.f3556i
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f3554g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f3558k = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.O()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f3558k = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.b.N():long");
        }

        /* access modifiers changed from: package-private */
        public long O() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte I = I();
                j5 |= ((long) (I & Byte.MAX_VALUE)) << i5;
                if ((I & 128) == 0) {
                    return j5;
                }
            }
            throw c0.f();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void Q() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.E()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.H(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.b.Q():void");
        }

        public void R(int i5) {
            if (i5 >= 0) {
                int i6 = this.f3556i;
                int i7 = this.f3558k;
                if (i5 <= i6 - i7) {
                    this.f3558k = i7 + i5;
                    return;
                }
            }
            if (i5 < 0) {
                throw c0.g();
            }
            throw c0.m();
        }

        public void a(int i5) {
            if (this.f3560m != i5) {
                throw c0.b();
            }
        }

        public int d() {
            return this.f3558k - this.f3559l;
        }

        public boolean e() {
            return this.f3558k == this.f3556i;
        }

        public void m(int i5) {
            this.f3562o = i5;
            P();
        }

        public int n(int i5) {
            if (i5 >= 0) {
                int d5 = i5 + d();
                if (d5 >= 0) {
                    int i6 = this.f3562o;
                    if (d5 <= i6) {
                        this.f3562o = d5;
                        P();
                        return i6;
                    }
                    throw c0.m();
                }
                throw c0.h();
            }
            throw c0.g();
        }

        public boolean o() {
            return N() != 0;
        }

        public i p() {
            int M = M();
            if (M > 0) {
                int i5 = this.f3556i;
                int i6 = this.f3558k;
                if (M <= i5 - i6) {
                    i n5 = (!this.f3555h || !this.f3561n) ? i.n(this.f3554g, i6, M) : i.G(this.f3554g, i6, M);
                    this.f3558k += M;
                    return n5;
                }
            }
            return M == 0 ? i.f3533f : i.F(J(M));
        }

        public double q() {
            return Double.longBitsToDouble(L());
        }

        public int r() {
            return M();
        }

        public int s() {
            return K();
        }

        public long t() {
            return L();
        }

        public float u() {
            return Float.intBitsToFloat(K());
        }

        public int v() {
            return M();
        }

        public long w() {
            return N();
        }

        public int y() {
            return K();
        }

        public long z() {
            return L();
        }
    }

    private static final class c extends j {

        /* renamed from: g  reason: collision with root package name */
        private final InputStream f3563g;

        /* renamed from: h  reason: collision with root package name */
        private final byte[] f3564h;

        /* renamed from: i  reason: collision with root package name */
        private int f3565i;

        /* renamed from: j  reason: collision with root package name */
        private int f3566j;

        /* renamed from: k  reason: collision with root package name */
        private int f3567k;

        /* renamed from: l  reason: collision with root package name */
        private int f3568l;

        /* renamed from: m  reason: collision with root package name */
        private int f3569m;

        /* renamed from: n  reason: collision with root package name */
        private int f3570n;

        /* renamed from: o  reason: collision with root package name */
        private a f3571o;

        private interface a {
            void a();
        }

        private c(InputStream inputStream, int i5) {
            super();
            this.f3570n = Integer.MAX_VALUE;
            this.f3571o = null;
            b0.b(inputStream, "input");
            this.f3563g = inputStream;
            this.f3564h = new byte[i5];
            this.f3565i = 0;
            this.f3567k = 0;
            this.f3569m = 0;
        }

        private static int I(InputStream inputStream) {
            try {
                return inputStream.available();
            } catch (c0 e5) {
                e5.j();
                throw e5;
            }
        }

        private static int J(InputStream inputStream, byte[] bArr, int i5, int i6) {
            try {
                return inputStream.read(bArr, i5, i6);
            } catch (c0 e5) {
                e5.j();
                throw e5;
            }
        }

        private i K(int i5) {
            byte[] N = N(i5);
            if (N != null) {
                return i.m(N);
            }
            int i6 = this.f3567k;
            int i7 = this.f3565i;
            int i8 = i7 - i6;
            this.f3569m += i7;
            this.f3567k = 0;
            this.f3565i = 0;
            List<byte[]> O = O(i5 - i8);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.f3564h, i6, bArr, 0, i8);
            for (byte[] next : O) {
                System.arraycopy(next, 0, bArr, i8, next.length);
                i8 += next.length;
            }
            return i.F(bArr);
        }

        private byte[] M(int i5, boolean z4) {
            byte[] N = N(i5);
            if (N != null) {
                return z4 ? (byte[]) N.clone() : N;
            }
            int i6 = this.f3567k;
            int i7 = this.f3565i;
            int i8 = i7 - i6;
            this.f3569m += i7;
            this.f3567k = 0;
            this.f3565i = 0;
            List<byte[]> O = O(i5 - i8);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.f3564h, i6, bArr, 0, i8);
            for (byte[] next : O) {
                System.arraycopy(next, 0, bArr, i8, next.length);
                i8 += next.length;
            }
            return bArr;
        }

        private byte[] N(int i5) {
            if (i5 == 0) {
                return b0.f3471c;
            }
            if (i5 >= 0) {
                int i6 = this.f3569m;
                int i7 = this.f3567k;
                int i8 = i6 + i7 + i5;
                if (i8 - this.f3551c <= 0) {
                    int i9 = this.f3570n;
                    if (i8 <= i9) {
                        int i10 = this.f3565i - i7;
                        int i11 = i5 - i10;
                        if (i11 >= 4096 && i11 > I(this.f3563g)) {
                            return null;
                        }
                        byte[] bArr = new byte[i5];
                        System.arraycopy(this.f3564h, this.f3567k, bArr, 0, i10);
                        this.f3569m += this.f3565i;
                        this.f3567k = 0;
                        this.f3565i = 0;
                        while (i10 < i5) {
                            int J = J(this.f3563g, bArr, i10, i5 - i10);
                            if (J != -1) {
                                this.f3569m += J;
                                i10 += J;
                            } else {
                                throw c0.m();
                            }
                        }
                        return bArr;
                    }
                    Y((i9 - i6) - i7);
                    throw c0.m();
                }
                throw c0.l();
            }
            throw c0.g();
        }

        private List<byte[]> O(int i5) {
            ArrayList arrayList = new ArrayList();
            while (i5 > 0) {
                int min = Math.min(i5, 4096);
                byte[] bArr = new byte[min];
                int i6 = 0;
                while (i6 < min) {
                    int read = this.f3563g.read(bArr, i6, min - i6);
                    if (read != -1) {
                        this.f3569m += read;
                        i6 += read;
                    } else {
                        throw c0.m();
                    }
                }
                i5 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void U() {
            int i5 = this.f3565i + this.f3566j;
            this.f3565i = i5;
            int i6 = this.f3569m + i5;
            int i7 = this.f3570n;
            if (i6 > i7) {
                int i8 = i6 - i7;
                this.f3566j = i8;
                this.f3565i = i5 - i8;
                return;
            }
            this.f3566j = 0;
        }

        private void V(int i5) {
            if (d0(i5)) {
                return;
            }
            if (i5 > (this.f3551c - this.f3569m) - this.f3567k) {
                throw c0.l();
            }
            throw c0.m();
        }

        private static long W(InputStream inputStream, long j5) {
            try {
                return inputStream.skip(j5);
            } catch (c0 e5) {
                e5.j();
                throw e5;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.f3563g.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void Z(int r9) {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0094
                int r0 = r8.f3569m
                int r1 = r8.f3567k
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.f3570n
                if (r2 > r3) goto L_0x008a
                com.google.protobuf.j$c$a r2 = r8.f3571o
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.f3569m = r0
                int r0 = r8.f3565i
                int r0 = r0 - r1
                r8.f3565i = r3
                r8.f3567k = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.f3563g     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = W(r1, r4)     // Catch:{ all -> 0x005d }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x0038
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 > 0) goto L_0x0038
                if (r2 != 0) goto L_0x0035
                goto L_0x0067
            L_0x0035:
                int r0 = (int) r0     // Catch:{ all -> 0x005d }
                int r3 = r3 + r0
                goto L_0x001d
            L_0x0038:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r2.<init>()     // Catch:{ all -> 0x005d }
                java.io.InputStream r4 = r8.f3563g     // Catch:{ all -> 0x005d }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005d }
                r2.append(r4)     // Catch:{ all -> 0x005d }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005d }
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005d }
                r9.<init>(r0)     // Catch:{ all -> 0x005d }
                throw r9     // Catch:{ all -> 0x005d }
            L_0x005d:
                r9 = move-exception
                int r0 = r8.f3569m
                int r0 = r0 + r3
                r8.f3569m = r0
                r8.U()
                throw r9
            L_0x0067:
                int r0 = r8.f3569m
                int r0 = r0 + r3
                r8.f3569m = r0
                r8.U()
            L_0x006f:
                if (r3 >= r9) goto L_0x0089
                int r0 = r8.f3565i
                int r1 = r8.f3567k
                int r1 = r0 - r1
                r8.f3567k = r0
                r0 = 1
            L_0x007a:
                r8.V(r0)
                int r2 = r9 - r1
                int r3 = r8.f3565i
                if (r2 <= r3) goto L_0x0087
                int r1 = r1 + r3
                r8.f3567k = r3
                goto L_0x007a
            L_0x0087:
                r8.f3567k = r2
            L_0x0089:
                return
            L_0x008a:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.Y(r3)
                com.google.protobuf.c0 r9 = com.google.protobuf.c0.m()
                throw r9
            L_0x0094:
                com.google.protobuf.c0 r9 = com.google.protobuf.c0.g()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.c.Z(int):void");
        }

        private void a0() {
            if (this.f3565i - this.f3567k >= 10) {
                b0();
            } else {
                c0();
            }
        }

        private void b0() {
            int i5 = 0;
            while (i5 < 10) {
                byte[] bArr = this.f3564h;
                int i6 = this.f3567k;
                this.f3567k = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw c0.f();
        }

        private void c0() {
            int i5 = 0;
            while (i5 < 10) {
                if (L() < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw c0.f();
        }

        private boolean d0(int i5) {
            int i6 = this.f3567k;
            if (i6 + i5 > this.f3565i) {
                int i7 = this.f3551c;
                int i8 = this.f3569m;
                if (i5 > (i7 - i8) - i6 || i8 + i6 + i5 > this.f3570n) {
                    return false;
                }
                a aVar = this.f3571o;
                if (aVar != null) {
                    aVar.a();
                }
                int i9 = this.f3567k;
                if (i9 > 0) {
                    int i10 = this.f3565i;
                    if (i10 > i9) {
                        byte[] bArr = this.f3564h;
                        System.arraycopy(bArr, i9, bArr, 0, i10 - i9);
                    }
                    this.f3569m += i9;
                    this.f3565i -= i9;
                    this.f3567k = 0;
                }
                InputStream inputStream = this.f3563g;
                byte[] bArr2 = this.f3564h;
                int i11 = this.f3565i;
                int J = J(inputStream, bArr2, i11, Math.min(bArr2.length - i11, (this.f3551c - this.f3569m) - i11));
                if (J == 0 || J < -1 || J > this.f3564h.length) {
                    throw new IllegalStateException(this.f3563g.getClass() + "#read(byte[]) returned invalid result: " + J + "\nThe InputStream implementation is buggy.");
                } else if (J <= 0) {
                    return false;
                } else {
                    this.f3565i += J;
                    U();
                    if (this.f3565i >= i5) {
                        return true;
                    }
                    return d0(i5);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i5 + " bytes were already available in buffer");
            }
        }

        public int A() {
            return j.b(R());
        }

        public long B() {
            return j.c(S());
        }

        public String C() {
            int R = R();
            if (R > 0) {
                int i5 = this.f3565i;
                int i6 = this.f3567k;
                if (R <= i5 - i6) {
                    String str = new String(this.f3564h, i6, R, b0.f3469a);
                    this.f3567k += R;
                    return str;
                }
            }
            if (R == 0) {
                return BuildConfig.FLAVOR;
            }
            if (R > this.f3565i) {
                return new String(M(R, false), b0.f3469a);
            }
            V(R);
            String str2 = new String(this.f3564h, this.f3567k, R, b0.f3469a);
            this.f3567k += R;
            return str2;
        }

        public String D() {
            byte[] bArr;
            int R = R();
            int i5 = this.f3567k;
            int i6 = this.f3565i;
            if (R <= i6 - i5 && R > 0) {
                bArr = this.f3564h;
                this.f3567k = i5 + R;
            } else if (R == 0) {
                return BuildConfig.FLAVOR;
            } else {
                if (R <= i6) {
                    V(R);
                    bArr = this.f3564h;
                    this.f3567k = R + 0;
                } else {
                    bArr = M(R, false);
                }
                i5 = 0;
            }
            return u1.h(bArr, i5, R);
        }

        public int E() {
            if (e()) {
                this.f3568l = 0;
                return 0;
            }
            int R = R();
            this.f3568l = R;
            if (v1.a(R) != 0) {
                return this.f3568l;
            }
            throw c0.c();
        }

        public int F() {
            return R();
        }

        public long G() {
            return S();
        }

        public boolean H(int i5) {
            int b5 = v1.b(i5);
            if (b5 == 0) {
                a0();
                return true;
            } else if (b5 == 1) {
                Y(8);
                return true;
            } else if (b5 == 2) {
                Y(R());
                return true;
            } else if (b5 == 3) {
                X();
                a(v1.c(v1.a(i5), 4));
                return true;
            } else if (b5 == 4) {
                return false;
            } else {
                if (b5 == 5) {
                    Y(4);
                    return true;
                }
                throw c0.e();
            }
        }

        public byte L() {
            if (this.f3567k == this.f3565i) {
                V(1);
            }
            byte[] bArr = this.f3564h;
            int i5 = this.f3567k;
            this.f3567k = i5 + 1;
            return bArr[i5];
        }

        public int P() {
            int i5 = this.f3567k;
            if (this.f3565i - i5 < 4) {
                V(4);
                i5 = this.f3567k;
            }
            byte[] bArr = this.f3564h;
            this.f3567k = i5 + 4;
            return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
        }

        public long Q() {
            int i5 = this.f3567k;
            if (this.f3565i - i5 < 8) {
                V(8);
                i5 = this.f3567k;
            }
            byte[] bArr = this.f3564h;
            this.f3567k = i5 + 8;
            return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int R() {
            /*
                r5 = this;
                int r0 = r5.f3567k
                int r1 = r5.f3565i
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f3564h
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f3567k = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.T()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f3567k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.c.R():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long S() {
            /*
                r11 = this;
                int r0 = r11.f3567k
                int r1 = r11.f3565i
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f3564h
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f3567k = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.T()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f3567k = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.c.S():long");
        }

        /* access modifiers changed from: package-private */
        public long T() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte L = L();
                j5 |= ((long) (L & Byte.MAX_VALUE)) << i5;
                if ((L & 128) == 0) {
                    return j5;
                }
            }
            throw c0.f();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void X() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.E()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.H(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.c.X():void");
        }

        public void Y(int i5) {
            int i6 = this.f3565i;
            int i7 = this.f3567k;
            if (i5 > i6 - i7 || i5 < 0) {
                Z(i5);
            } else {
                this.f3567k = i7 + i5;
            }
        }

        public void a(int i5) {
            if (this.f3568l != i5) {
                throw c0.b();
            }
        }

        public int d() {
            return this.f3569m + this.f3567k;
        }

        public boolean e() {
            return this.f3567k == this.f3565i && !d0(1);
        }

        public void m(int i5) {
            this.f3570n = i5;
            U();
        }

        public int n(int i5) {
            if (i5 >= 0) {
                int i6 = i5 + this.f3569m + this.f3567k;
                int i7 = this.f3570n;
                if (i6 <= i7) {
                    this.f3570n = i6;
                    U();
                    return i7;
                }
                throw c0.m();
            }
            throw c0.g();
        }

        public boolean o() {
            return S() != 0;
        }

        public i p() {
            int R = R();
            int i5 = this.f3565i;
            int i6 = this.f3567k;
            if (R > i5 - i6 || R <= 0) {
                return R == 0 ? i.f3533f : K(R);
            }
            i n5 = i.n(this.f3564h, i6, R);
            this.f3567k += R;
            return n5;
        }

        public double q() {
            return Double.longBitsToDouble(Q());
        }

        public int r() {
            return R();
        }

        public int s() {
            return P();
        }

        public long t() {
            return Q();
        }

        public float u() {
            return Float.intBitsToFloat(P());
        }

        public int v() {
            return R();
        }

        public long w() {
            return S();
        }

        public int y() {
            return P();
        }

        public long z() {
            return Q();
        }
    }

    private static final class d extends j {

        /* renamed from: g  reason: collision with root package name */
        private final ByteBuffer f3572g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f3573h;

        /* renamed from: i  reason: collision with root package name */
        private final long f3574i;

        /* renamed from: j  reason: collision with root package name */
        private long f3575j;

        /* renamed from: k  reason: collision with root package name */
        private long f3576k;

        /* renamed from: l  reason: collision with root package name */
        private long f3577l;

        /* renamed from: m  reason: collision with root package name */
        private int f3578m;

        /* renamed from: n  reason: collision with root package name */
        private int f3579n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f3580o;

        /* renamed from: p  reason: collision with root package name */
        private int f3581p;

        private d(ByteBuffer byteBuffer, boolean z4) {
            super();
            this.f3581p = Integer.MAX_VALUE;
            this.f3572g = byteBuffer;
            long k5 = t1.k(byteBuffer);
            this.f3574i = k5;
            this.f3575j = ((long) byteBuffer.limit()) + k5;
            long position = k5 + ((long) byteBuffer.position());
            this.f3576k = position;
            this.f3577l = position;
            this.f3573h = z4;
        }

        private int I(long j5) {
            return (int) (j5 - this.f3574i);
        }

        static boolean J() {
            return t1.J();
        }

        private void Q() {
            long j5 = this.f3575j + ((long) this.f3578m);
            this.f3575j = j5;
            int i5 = (int) (j5 - this.f3577l);
            int i6 = this.f3581p;
            if (i5 > i6) {
                int i7 = i5 - i6;
                this.f3578m = i7;
                this.f3575j = j5 - ((long) i7);
                return;
            }
            this.f3578m = 0;
        }

        private int R() {
            return (int) (this.f3575j - this.f3576k);
        }

        private void U() {
            if (R() >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() {
            int i5 = 0;
            while (i5 < 10) {
                long j5 = this.f3576k;
                this.f3576k = 1 + j5;
                if (t1.w(j5) < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw c0.f();
        }

        private void W() {
            int i5 = 0;
            while (i5 < 10) {
                if (K() < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw c0.f();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            throw com.google.protobuf.c0.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r3.f3572g.position(r0);
            r3.f3572g.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer X(long r4, long r6) {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f3572g
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f3572g
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f3572g     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r4 = r3.I(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f3572g     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r5 = r3.I(r6)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f3572g     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r5 = r3.f3572g
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f3572g
                r5.limit(r1)
                return r4
            L_0x002f:
                r4 = move-exception
                goto L_0x0036
            L_0x0031:
                com.google.protobuf.c0 r4 = com.google.protobuf.c0.m()     // Catch:{ all -> 0x002f }
                throw r4     // Catch:{ all -> 0x002f }
            L_0x0036:
                java.nio.ByteBuffer r5 = r3.f3572g
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f3572g
                r5.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.d.X(long, long):java.nio.ByteBuffer");
        }

        public int A() {
            return j.b(N());
        }

        public long B() {
            return j.c(O());
        }

        public String C() {
            int N = N();
            if (N > 0 && N <= R()) {
                byte[] bArr = new byte[N];
                long j5 = (long) N;
                t1.p(this.f3576k, bArr, 0, j5);
                String str = new String(bArr, b0.f3469a);
                this.f3576k += j5;
                return str;
            } else if (N == 0) {
                return BuildConfig.FLAVOR;
            } else {
                if (N < 0) {
                    throw c0.g();
                }
                throw c0.m();
            }
        }

        public String D() {
            int N = N();
            if (N > 0 && N <= R()) {
                String g5 = u1.g(this.f3572g, I(this.f3576k), N);
                this.f3576k += (long) N;
                return g5;
            } else if (N == 0) {
                return BuildConfig.FLAVOR;
            } else {
                if (N <= 0) {
                    throw c0.g();
                }
                throw c0.m();
            }
        }

        public int E() {
            if (e()) {
                this.f3579n = 0;
                return 0;
            }
            int N = N();
            this.f3579n = N;
            if (v1.a(N) != 0) {
                return this.f3579n;
            }
            throw c0.c();
        }

        public int F() {
            return N();
        }

        public long G() {
            return O();
        }

        public boolean H(int i5) {
            int b5 = v1.b(i5);
            if (b5 == 0) {
                U();
                return true;
            } else if (b5 == 1) {
                T(8);
                return true;
            } else if (b5 == 2) {
                T(N());
                return true;
            } else if (b5 == 3) {
                S();
                a(v1.c(v1.a(i5), 4));
                return true;
            } else if (b5 == 4) {
                return false;
            } else {
                if (b5 == 5) {
                    T(4);
                    return true;
                }
                throw c0.e();
            }
        }

        public byte K() {
            long j5 = this.f3576k;
            if (j5 != this.f3575j) {
                this.f3576k = 1 + j5;
                return t1.w(j5);
            }
            throw c0.m();
        }

        public int L() {
            long j5 = this.f3576k;
            if (this.f3575j - j5 >= 4) {
                this.f3576k = 4 + j5;
                return ((t1.w(j5 + 3) & 255) << 24) | (t1.w(j5) & 255) | ((t1.w(1 + j5) & 255) << 8) | ((t1.w(2 + j5) & 255) << 16);
            }
            throw c0.m();
        }

        public long M() {
            long j5 = this.f3576k;
            if (this.f3575j - j5 >= 8) {
                this.f3576k = 8 + j5;
                return ((((long) t1.w(j5 + 7)) & 255) << 56) | (((long) t1.w(j5)) & 255) | ((((long) t1.w(1 + j5)) & 255) << 8) | ((((long) t1.w(2 + j5)) & 255) << 16) | ((((long) t1.w(3 + j5)) & 255) << 24) | ((((long) t1.w(4 + j5)) & 255) << 32) | ((((long) t1.w(5 + j5)) & 255) << 40) | ((((long) t1.w(6 + j5)) & 255) << 48);
            }
            throw c0.m();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (com.google.protobuf.t1.w(r4) < 0) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int N() {
            /*
                r10 = this;
                long r0 = r10.f3576k
                long r2 = r10.f3575j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x000a
                goto L_0x0085
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.t1.w(r0)
                if (r0 < 0) goto L_0x0017
                r10.f3576k = r4
                return r0
            L_0x0017:
                long r6 = r10.f3575j
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0021
                goto L_0x0085
            L_0x0021:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.t1.w(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x002f
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x008b
            L_0x002f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.t1.w(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003c:
                r6 = r4
                goto L_0x008b
            L_0x003e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.t1.w(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x004e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x008b
            L_0x004e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.t1.w(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.t1.w(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.t1.w(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.t1.w(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.t1.w(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.t1.w(r4)
                if (r1 >= 0) goto L_0x008b
            L_0x0085:
                long r0 = r10.P()
                int r0 = (int) r0
                return r0
            L_0x008b:
                r10.f3576k = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.d.N():int");
        }

        public long O() {
            long j5;
            long j6;
            long j7;
            byte b5;
            long j8 = this.f3576k;
            if (this.f3575j != j8) {
                long j9 = j8 + 1;
                byte w4 = t1.w(j8);
                if (w4 >= 0) {
                    this.f3576k = j9;
                    return (long) w4;
                } else if (this.f3575j - j9 >= 9) {
                    long j10 = j9 + 1;
                    byte w5 = w4 ^ (t1.w(j9) << 7);
                    if (w5 < 0) {
                        b5 = w5 ^ Byte.MIN_VALUE;
                    } else {
                        long j11 = j10 + 1;
                        byte w6 = w5 ^ (t1.w(j10) << 14);
                        if (w6 >= 0) {
                            j5 = (long) (w6 ^ 16256);
                        } else {
                            j10 = j11 + 1;
                            byte w7 = w6 ^ (t1.w(j11) << 21);
                            if (w7 < 0) {
                                b5 = w7 ^ -2080896;
                            } else {
                                j11 = j10 + 1;
                                long w8 = ((long) w7) ^ (((long) t1.w(j10)) << 28);
                                if (w8 >= 0) {
                                    j7 = 266354560;
                                } else {
                                    long j12 = j11 + 1;
                                    long w9 = w8 ^ (((long) t1.w(j11)) << 35);
                                    if (w9 < 0) {
                                        j6 = -34093383808L;
                                    } else {
                                        j11 = j12 + 1;
                                        w8 = w9 ^ (((long) t1.w(j12)) << 42);
                                        if (w8 >= 0) {
                                            j7 = 4363953127296L;
                                        } else {
                                            j12 = j11 + 1;
                                            w9 = w8 ^ (((long) t1.w(j11)) << 49);
                                            if (w9 < 0) {
                                                j6 = -558586000294016L;
                                            } else {
                                                j11 = j12 + 1;
                                                j5 = (w9 ^ (((long) t1.w(j12)) << 56)) ^ 71499008037633920L;
                                                if (j5 < 0) {
                                                    long j13 = 1 + j11;
                                                    if (((long) t1.w(j11)) >= 0) {
                                                        j10 = j13;
                                                        this.f3576k = j10;
                                                        return j5;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j5 = w9 ^ j6;
                                    j10 = j12;
                                    this.f3576k = j10;
                                    return j5;
                                }
                                j5 = w8 ^ j7;
                            }
                        }
                        j10 = j11;
                        this.f3576k = j10;
                        return j5;
                    }
                    j5 = (long) b5;
                    this.f3576k = j10;
                    return j5;
                }
            }
            return P();
        }

        /* access modifiers changed from: package-private */
        public long P() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte K = K();
                j5 |= ((long) (K & Byte.MAX_VALUE)) << i5;
                if ((K & 128) == 0) {
                    return j5;
                }
            }
            throw c0.f();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void S() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.E()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.H(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.d.S():void");
        }

        public void T(int i5) {
            if (i5 >= 0 && i5 <= R()) {
                this.f3576k += (long) i5;
            } else if (i5 < 0) {
                throw c0.g();
            } else {
                throw c0.m();
            }
        }

        public void a(int i5) {
            if (this.f3579n != i5) {
                throw c0.b();
            }
        }

        public int d() {
            return (int) (this.f3576k - this.f3577l);
        }

        public boolean e() {
            return this.f3576k == this.f3575j;
        }

        public void m(int i5) {
            this.f3581p = i5;
            Q();
        }

        public int n(int i5) {
            if (i5 >= 0) {
                int d5 = i5 + d();
                int i6 = this.f3581p;
                if (d5 <= i6) {
                    this.f3581p = d5;
                    Q();
                    return i6;
                }
                throw c0.m();
            }
            throw c0.g();
        }

        public boolean o() {
            return O() != 0;
        }

        public i p() {
            int N = N();
            if (N <= 0 || N > R()) {
                if (N == 0) {
                    return i.f3533f;
                }
                if (N < 0) {
                    throw c0.g();
                }
                throw c0.m();
            } else if (!this.f3573h || !this.f3580o) {
                byte[] bArr = new byte[N];
                long j5 = (long) N;
                t1.p(this.f3576k, bArr, 0, j5);
                this.f3576k += j5;
                return i.F(bArr);
            } else {
                long j6 = this.f3576k;
                long j7 = (long) N;
                ByteBuffer X = X(j6, j6 + j7);
                this.f3576k += j7;
                return i.E(X);
            }
        }

        public double q() {
            return Double.longBitsToDouble(M());
        }

        public int r() {
            return N();
        }

        public int s() {
            return L();
        }

        public long t() {
            return M();
        }

        public float u() {
            return Float.intBitsToFloat(L());
        }

        public int v() {
            return N();
        }

        public long w() {
            return O();
        }

        public int y() {
            return L();
        }

        public long z() {
            return M();
        }
    }

    private j() {
        this.f3550b = f3548f;
        this.f3551c = Integer.MAX_VALUE;
        this.f3553e = false;
    }

    public static int b(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public static long c(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static j f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static j g(InputStream inputStream, int i5) {
        if (i5 > 0) {
            return inputStream == null ? j(b0.f3471c) : new c(inputStream, i5);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static j h(ByteBuffer byteBuffer) {
        return i(byteBuffer, false);
    }

    static j i(ByteBuffer byteBuffer, boolean z4) {
        if (byteBuffer.hasArray()) {
            return l(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z4);
        }
        if (byteBuffer.isDirect() && d.J()) {
            return new d(byteBuffer, z4);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return l(bArr, 0, remaining, true);
    }

    public static j j(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static j k(byte[] bArr, int i5, int i6) {
        return l(bArr, i5, i6, false);
    }

    static j l(byte[] bArr, int i5, int i6, boolean z4) {
        b bVar = new b(bArr, i5, i6, z4);
        try {
            bVar.n(i6);
            return bVar;
        } catch (c0 e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public static int x(int i5, InputStream inputStream) {
        if ((i5 & 128) == 0) {
            return i5;
        }
        int i6 = i5 & 127;
        int i7 = 7;
        while (i7 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i6 |= (read & 127) << i7;
                if ((read & 128) == 0) {
                    return i6;
                }
                i7 += 7;
            } else {
                throw c0.m();
            }
        }
        while (i7 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw c0.m();
            } else if ((read2 & 128) == 0) {
                return i6;
            } else {
                i7 += 7;
            }
        }
        throw c0.f();
    }

    public abstract int A();

    public abstract long B();

    public abstract String C();

    public abstract String D();

    public abstract int E();

    public abstract int F();

    public abstract long G();

    public abstract boolean H(int i5);

    public abstract void a(int i5);

    public abstract int d();

    public abstract boolean e();

    public abstract void m(int i5);

    public abstract int n(int i5);

    public abstract boolean o();

    public abstract i p();

    public abstract double q();

    public abstract int r();

    public abstract int s();

    public abstract long t();

    public abstract float u();

    public abstract int v();

    public abstract long w();

    public abstract int y();

    public abstract long z();
}
