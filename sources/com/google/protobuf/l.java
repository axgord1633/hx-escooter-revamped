package com.google.protobuf;

import com.google.protobuf.u1;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class l extends h {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f3596c = Logger.getLogger(l.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3597d = t1.I();

    /* renamed from: a  reason: collision with root package name */
    m f3598a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3599b;

    private static abstract class b extends l {

        /* renamed from: e  reason: collision with root package name */
        final byte[] f3600e;

        /* renamed from: f  reason: collision with root package name */
        final int f3601f;

        /* renamed from: g  reason: collision with root package name */
        int f3602g;

        /* renamed from: h  reason: collision with root package name */
        int f3603h;

        b(int i5) {
            super();
            if (i5 >= 0) {
                byte[] bArr = new byte[Math.max(i5, 20)];
                this.f3600e = bArr;
                this.f3601f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void W0(byte b5) {
            byte[] bArr = this.f3600e;
            int i5 = this.f3602g;
            this.f3602g = i5 + 1;
            bArr[i5] = b5;
            this.f3603h++;
        }

        /* access modifiers changed from: package-private */
        public final void X0(int i5) {
            byte[] bArr = this.f3600e;
            int i6 = this.f3602g;
            int i7 = i6 + 1;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.f3602g = i9 + 1;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
            this.f3603h += 4;
        }

        /* access modifiers changed from: package-private */
        public final void Y0(long j5) {
            byte[] bArr = this.f3600e;
            int i5 = this.f3602g;
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((int) (j5 & 255));
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((int) ((j5 >> 8) & 255));
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((int) ((j5 >> 16) & 255));
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((int) (255 & (j5 >> 24)));
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
            this.f3602g = i12 + 1;
            bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            this.f3603h += 8;
        }

        /* access modifiers changed from: package-private */
        public final void Z0(int i5) {
            if (i5 >= 0) {
                b1(i5);
            } else {
                c1((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a1(int i5, int i6) {
            b1(v1.c(i5, i6));
        }

        /* access modifiers changed from: package-private */
        public final void b1(int i5) {
            if (l.f3597d) {
                long j5 = (long) this.f3602g;
                while ((i5 & -128) != 0) {
                    byte[] bArr = this.f3600e;
                    int i6 = this.f3602g;
                    this.f3602g = i6 + 1;
                    t1.O(bArr, (long) i6, (byte) ((i5 & 127) | 128));
                    i5 >>>= 7;
                }
                byte[] bArr2 = this.f3600e;
                int i7 = this.f3602g;
                this.f3602g = i7 + 1;
                t1.O(bArr2, (long) i7, (byte) i5);
                this.f3603h += (int) (((long) this.f3602g) - j5);
                return;
            }
            while ((i5 & -128) != 0) {
                byte[] bArr3 = this.f3600e;
                int i8 = this.f3602g;
                this.f3602g = i8 + 1;
                bArr3[i8] = (byte) ((i5 & 127) | 128);
                this.f3603h++;
                i5 >>>= 7;
            }
            byte[] bArr4 = this.f3600e;
            int i9 = this.f3602g;
            this.f3602g = i9 + 1;
            bArr4[i9] = (byte) i5;
            this.f3603h++;
        }

        /* access modifiers changed from: package-private */
        public final void c1(long j5) {
            if (l.f3597d) {
                long j6 = (long) this.f3602g;
                while ((j5 & -128) != 0) {
                    byte[] bArr = this.f3600e;
                    int i5 = this.f3602g;
                    this.f3602g = i5 + 1;
                    t1.O(bArr, (long) i5, (byte) ((((int) j5) & 127) | 128));
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.f3600e;
                int i6 = this.f3602g;
                this.f3602g = i6 + 1;
                t1.O(bArr2, (long) i6, (byte) ((int) j5));
                this.f3603h += (int) (((long) this.f3602g) - j6);
                return;
            }
            while ((j5 & -128) != 0) {
                byte[] bArr3 = this.f3600e;
                int i7 = this.f3602g;
                this.f3602g = i7 + 1;
                bArr3[i7] = (byte) ((((int) j5) & 127) | 128);
                this.f3603h++;
                j5 >>>= 7;
            }
            byte[] bArr4 = this.f3600e;
            int i8 = this.f3602g;
            this.f3602g = i8 + 1;
            bArr4[i8] = (byte) ((int) j5);
            this.f3603h++;
        }

        public final int j0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class c extends l {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f3604e;

        /* renamed from: f  reason: collision with root package name */
        private final int f3605f;

        /* renamed from: g  reason: collision with root package name */
        private final int f3606g;

        /* renamed from: h  reason: collision with root package name */
        private int f3607h;

        c(byte[] bArr, int i5, int i6) {
            super();
            if (bArr != null) {
                int i7 = i5 + i6;
                if ((i5 | i6 | (bArr.length - i7)) >= 0) {
                    this.f3604e = bArr;
                    this.f3605f = i5;
                    this.f3607h = i5;
                    this.f3606g = i7;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void A0(int i5, int i6) {
            R0(i5, 0);
            B0(i6);
        }

        public final void B0(int i5) {
            if (i5 >= 0) {
                T0(i5);
            } else {
                V0((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public final void E0(int i5, s0 s0Var, i1 i1Var) {
            R0(i5, 2);
            T0(((a) s0Var).getSerializedSize(i1Var));
            i1Var.b(s0Var, this.f3598a);
        }

        public final void F0(int i5, s0 s0Var) {
            R0(1, 3);
            S0(2, i5);
            Z0(3, s0Var);
            R0(1, 4);
        }

        public final void G0(int i5, i iVar) {
            R0(1, 3);
            S0(2, i5);
            n0(3, iVar);
            R0(1, 4);
        }

        public final void Q0(int i5, String str) {
            R0(i5, 2);
            b1(str);
        }

        public final void R0(int i5, int i6) {
            T0(v1.c(i5, i6));
        }

        public final void S0(int i5, int i6) {
            R0(i5, 0);
            T0(i6);
        }

        public final void T0(int i5) {
            if (!l.f3597d || d.c() || j0() < 5) {
                while ((i5 & -128) != 0) {
                    byte[] bArr = this.f3604e;
                    int i6 = this.f3607h;
                    this.f3607h = i6 + 1;
                    bArr[i6] = (byte) ((i5 & 127) | 128);
                    i5 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3604e;
                    int i7 = this.f3607h;
                    this.f3607h = i7 + 1;
                    bArr2[i7] = (byte) i5;
                } catch (IndexOutOfBoundsException e5) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f3607h), Integer.valueOf(this.f3606g), 1}), e5);
                }
            } else if ((i5 & -128) == 0) {
                byte[] bArr3 = this.f3604e;
                int i8 = this.f3607h;
                this.f3607h = i8 + 1;
                t1.O(bArr3, (long) i8, (byte) i5);
            } else {
                byte[] bArr4 = this.f3604e;
                int i9 = this.f3607h;
                this.f3607h = i9 + 1;
                t1.O(bArr4, (long) i9, (byte) (i5 | 128));
                int i10 = i5 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr5 = this.f3604e;
                    int i11 = this.f3607h;
                    this.f3607h = i11 + 1;
                    t1.O(bArr5, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr6 = this.f3604e;
                int i12 = this.f3607h;
                this.f3607h = i12 + 1;
                t1.O(bArr6, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & -128) == 0) {
                    byte[] bArr7 = this.f3604e;
                    int i14 = this.f3607h;
                    this.f3607h = i14 + 1;
                    t1.O(bArr7, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr8 = this.f3604e;
                int i15 = this.f3607h;
                this.f3607h = i15 + 1;
                t1.O(bArr8, (long) i15, (byte) (i13 | 128));
                int i16 = i13 >>> 7;
                if ((i16 & -128) == 0) {
                    byte[] bArr9 = this.f3604e;
                    int i17 = this.f3607h;
                    this.f3607h = i17 + 1;
                    t1.O(bArr9, (long) i17, (byte) i16);
                    return;
                }
                byte[] bArr10 = this.f3604e;
                int i18 = this.f3607h;
                this.f3607h = i18 + 1;
                t1.O(bArr10, (long) i18, (byte) (i16 | 128));
                byte[] bArr11 = this.f3604e;
                int i19 = this.f3607h;
                this.f3607h = i19 + 1;
                t1.O(bArr11, (long) i19, (byte) (i16 >>> 7));
            }
        }

        public final void U0(int i5, long j5) {
            R0(i5, 0);
            V0(j5);
        }

        public final void V0(long j5) {
            if (!l.f3597d || j0() < 10) {
                while ((j5 & -128) != 0) {
                    byte[] bArr = this.f3604e;
                    int i5 = this.f3607h;
                    this.f3607h = i5 + 1;
                    bArr[i5] = (byte) ((((int) j5) & 127) | 128);
                    j5 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3604e;
                    int i6 = this.f3607h;
                    this.f3607h = i6 + 1;
                    bArr2[i6] = (byte) ((int) j5);
                } catch (IndexOutOfBoundsException e5) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f3607h), Integer.valueOf(this.f3606g), 1}), e5);
                }
            } else {
                while ((j5 & -128) != 0) {
                    byte[] bArr3 = this.f3604e;
                    int i7 = this.f3607h;
                    this.f3607h = i7 + 1;
                    t1.O(bArr3, (long) i7, (byte) ((((int) j5) & 127) | 128));
                    j5 >>>= 7;
                }
                byte[] bArr4 = this.f3604e;
                int i8 = this.f3607h;
                this.f3607h = i8 + 1;
                t1.O(bArr4, (long) i8, (byte) ((int) j5));
            }
        }

        public final void W0(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f3604e, this.f3607h, remaining);
                this.f3607h += remaining;
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f3607h), Integer.valueOf(this.f3606g), Integer.valueOf(remaining)}), e5);
            }
        }

        public final void X0(byte[] bArr, int i5, int i6) {
            try {
                System.arraycopy(bArr, i5, this.f3604e, this.f3607h, i6);
                this.f3607h += i6;
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f3607h), Integer.valueOf(this.f3606g), Integer.valueOf(i6)}), e5);
            }
        }

        public final void Y0(i iVar) {
            T0(iVar.size());
            iVar.H(this);
        }

        public final void Z0(int i5, s0 s0Var) {
            R0(i5, 2);
            a1(s0Var);
        }

        public final void a(ByteBuffer byteBuffer) {
            W0(byteBuffer);
        }

        public final void a1(s0 s0Var) {
            T0(s0Var.getSerializedSize());
            s0Var.writeTo(this);
        }

        public final void b(byte[] bArr, int i5, int i6) {
            X0(bArr, i5, i6);
        }

        public final void b1(String str) {
            int i5;
            int i6 = this.f3607h;
            try {
                int Y = l.Y(str.length() * 3);
                int Y2 = l.Y(str.length());
                if (Y2 == Y) {
                    int i7 = i6 + Y2;
                    this.f3607h = i7;
                    i5 = u1.i(str, this.f3604e, i7, j0());
                    this.f3607h = i6;
                    T0((i5 - i6) - Y2);
                } else {
                    T0(u1.j(str));
                    i5 = u1.i(str, this.f3604e, this.f3607h, j0());
                }
                this.f3607h = i5;
            } catch (u1.d e5) {
                this.f3607h = i6;
                e0(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new d(e6);
            }
        }

        public void d0() {
        }

        public final int j0() {
            return this.f3606g - this.f3607h;
        }

        public final void k0(byte b5) {
            try {
                byte[] bArr = this.f3604e;
                int i5 = this.f3607h;
                this.f3607h = i5 + 1;
                bArr[i5] = b5;
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f3607h), Integer.valueOf(this.f3606g), 1}), e5);
            }
        }

        public final void l0(int i5, boolean z4) {
            R0(i5, 0);
            k0(z4 ? (byte) 1 : 0);
        }

        public final void n0(int i5, i iVar) {
            R0(i5, 2);
            Y0(iVar);
        }

        public final void s0(int i5, int i6) {
            R0(i5, 5);
            t0(i6);
        }

        public final void t0(int i5) {
            try {
                byte[] bArr = this.f3604e;
                int i6 = this.f3607h;
                int i7 = i6 + 1;
                bArr[i6] = (byte) (i5 & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((i5 >> 8) & 255);
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((i5 >> 16) & 255);
                this.f3607h = i9 + 1;
                bArr[i9] = (byte) ((i5 >> 24) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f3607h), Integer.valueOf(this.f3606g), 1}), e5);
            }
        }

        public final void u0(int i5, long j5) {
            R0(i5, 1);
            v0(j5);
        }

        public final void v0(long j5) {
            try {
                byte[] bArr = this.f3604e;
                int i5 = this.f3607h;
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((int) j5) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((int) (j5 >> 8)) & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((int) (j5 >> 16)) & 255);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((int) (j5 >> 24)) & 255);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
                this.f3607h = i12 + 1;
                bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f3607h), Integer.valueOf(this.f3606g), 1}), e5);
            }
        }
    }

    public static class d extends IOException {
        d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private static final class e extends b {

        /* renamed from: i  reason: collision with root package name */
        private final OutputStream f3608i;

        e(OutputStream outputStream, int i5) {
            super(i5);
            if (outputStream != null) {
                this.f3608i = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void d1() {
            this.f3608i.write(this.f3600e, 0, this.f3602g);
            this.f3602g = 0;
        }

        private void e1(int i5) {
            if (this.f3601f - this.f3602g < i5) {
                d1();
            }
        }

        public void A0(int i5, int i6) {
            e1(20);
            a1(i5, 0);
            Z0(i6);
        }

        public void B0(int i5) {
            if (i5 >= 0) {
                T0(i5);
            } else {
                V0((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void E0(int i5, s0 s0Var, i1 i1Var) {
            R0(i5, 2);
            k1(s0Var, i1Var);
        }

        public void F0(int i5, s0 s0Var) {
            R0(1, 3);
            S0(2, i5);
            i1(3, s0Var);
            R0(1, 4);
        }

        public void G0(int i5, i iVar) {
            R0(1, 3);
            S0(2, i5);
            n0(3, iVar);
            R0(1, 4);
        }

        public void Q0(int i5, String str) {
            R0(i5, 2);
            l1(str);
        }

        public void R0(int i5, int i6) {
            T0(v1.c(i5, i6));
        }

        public void S0(int i5, int i6) {
            e1(20);
            a1(i5, 0);
            b1(i6);
        }

        public void T0(int i5) {
            e1(5);
            b1(i5);
        }

        public void U0(int i5, long j5) {
            e1(20);
            a1(i5, 0);
            c1(j5);
        }

        public void V0(long j5) {
            e1(10);
            c1(j5);
        }

        public void a(ByteBuffer byteBuffer) {
            f1(byteBuffer);
        }

        public void b(byte[] bArr, int i5, int i6) {
            g1(bArr, i5, i6);
        }

        public void d0() {
            if (this.f3602g > 0) {
                d1();
            }
        }

        public void f1(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i5 = this.f3601f;
            int i6 = this.f3602g;
            if (i5 - i6 >= remaining) {
                byteBuffer.get(this.f3600e, i6, remaining);
                this.f3602g += remaining;
            } else {
                int i7 = i5 - i6;
                byteBuffer.get(this.f3600e, i6, i7);
                remaining -= i7;
                this.f3602g = this.f3601f;
                this.f3603h += i7;
                d1();
                while (true) {
                    int i8 = this.f3601f;
                    if (remaining <= i8) {
                        break;
                    }
                    byteBuffer.get(this.f3600e, 0, i8);
                    this.f3608i.write(this.f3600e, 0, this.f3601f);
                    int i9 = this.f3601f;
                    remaining -= i9;
                    this.f3603h += i9;
                }
                byteBuffer.get(this.f3600e, 0, remaining);
                this.f3602g = remaining;
            }
            this.f3603h += remaining;
        }

        public void g1(byte[] bArr, int i5, int i6) {
            int i7 = this.f3601f;
            int i8 = this.f3602g;
            if (i7 - i8 >= i6) {
                System.arraycopy(bArr, i5, this.f3600e, i8, i6);
                this.f3602g += i6;
            } else {
                int i9 = i7 - i8;
                System.arraycopy(bArr, i5, this.f3600e, i8, i9);
                int i10 = i5 + i9;
                i6 -= i9;
                this.f3602g = this.f3601f;
                this.f3603h += i9;
                d1();
                if (i6 <= this.f3601f) {
                    System.arraycopy(bArr, i10, this.f3600e, 0, i6);
                    this.f3602g = i6;
                } else {
                    this.f3608i.write(bArr, i10, i6);
                }
            }
            this.f3603h += i6;
        }

        public void h1(i iVar) {
            T0(iVar.size());
            iVar.H(this);
        }

        public void i1(int i5, s0 s0Var) {
            R0(i5, 2);
            j1(s0Var);
        }

        public void j1(s0 s0Var) {
            T0(s0Var.getSerializedSize());
            s0Var.writeTo(this);
        }

        public void k0(byte b5) {
            if (this.f3602g == this.f3601f) {
                d1();
            }
            W0(b5);
        }

        /* access modifiers changed from: package-private */
        public void k1(s0 s0Var, i1 i1Var) {
            T0(((a) s0Var).getSerializedSize(i1Var));
            i1Var.b(s0Var, this.f3598a);
        }

        public void l0(int i5, boolean z4) {
            e1(11);
            a1(i5, 0);
            W0(z4 ? (byte) 1 : 0);
        }

        public void l1(String str) {
            int i5;
            int i6;
            try {
                int length = str.length() * 3;
                int Y = l.Y(length);
                int i7 = Y + length;
                int i8 = this.f3601f;
                if (i7 > i8) {
                    byte[] bArr = new byte[length];
                    int i9 = u1.i(str, bArr, 0, length);
                    T0(i9);
                    b(bArr, 0, i9);
                    return;
                }
                if (i7 > i8 - this.f3602g) {
                    d1();
                }
                int Y2 = l.Y(str.length());
                i5 = this.f3602g;
                if (Y2 == Y) {
                    int i10 = i5 + Y2;
                    this.f3602g = i10;
                    int i11 = u1.i(str, this.f3600e, i10, this.f3601f - i10);
                    this.f3602g = i5;
                    i6 = (i11 - i5) - Y2;
                    b1(i6);
                    this.f3602g = i11;
                } else {
                    i6 = u1.j(str);
                    b1(i6);
                    this.f3602g = u1.i(str, this.f3600e, this.f3602g, i6);
                }
                this.f3603h += i6;
            } catch (u1.d e5) {
                this.f3603h -= this.f3602g - i5;
                this.f3602g = i5;
                throw e5;
            } catch (ArrayIndexOutOfBoundsException e6) {
                throw new d(e6);
            } catch (u1.d e7) {
                e0(str, e7);
            }
        }

        public void n0(int i5, i iVar) {
            R0(i5, 2);
            h1(iVar);
        }

        public void s0(int i5, int i6) {
            e1(14);
            a1(i5, 5);
            X0(i6);
        }

        public void t0(int i5) {
            e1(4);
            X0(i5);
        }

        public void u0(int i5, long j5) {
            e1(18);
            a1(i5, 1);
            Y0(j5);
        }

        public void v0(long j5) {
            e1(8);
            Y0(j5);
        }
    }

    private l() {
    }

    public static int A(int i5, f0 f0Var) {
        return (W(1) * 2) + X(2, i5) + B(3, f0Var);
    }

    public static int B(int i5, f0 f0Var) {
        return W(i5) + C(f0Var);
    }

    public static int C(f0 f0Var) {
        return D(f0Var.b());
    }

    static int D(int i5) {
        return Y(i5) + i5;
    }

    public static int E(int i5, s0 s0Var) {
        return (W(1) * 2) + X(2, i5) + F(3, s0Var);
    }

    public static int F(int i5, s0 s0Var) {
        return W(i5) + H(s0Var);
    }

    static int G(int i5, s0 s0Var, i1 i1Var) {
        return W(i5) + I(s0Var, i1Var);
    }

    public static int H(s0 s0Var) {
        return D(s0Var.getSerializedSize());
    }

    static int I(s0 s0Var, i1 i1Var) {
        return D(((a) s0Var).getSerializedSize(i1Var));
    }

    static int J(int i5) {
        if (i5 > 4096) {
            return 4096;
        }
        return i5;
    }

    public static int K(int i5, i iVar) {
        return (W(1) * 2) + X(2, i5) + h(3, iVar);
    }

    @Deprecated
    public static int L(int i5) {
        return Y(i5);
    }

    public static int M(int i5, int i6) {
        return W(i5) + N(i6);
    }

    public static int N(int i5) {
        return 4;
    }

    public static int O(int i5, long j5) {
        return W(i5) + P(j5);
    }

    public static int P(long j5) {
        return 8;
    }

    public static int Q(int i5, int i6) {
        return W(i5) + R(i6);
    }

    public static int R(int i5) {
        return Y(b0(i5));
    }

    public static int S(int i5, long j5) {
        return W(i5) + T(j5);
    }

    public static int T(long j5) {
        return a0(c0(j5));
    }

    public static int U(int i5, String str) {
        return W(i5) + V(str);
    }

    public static int V(String str) {
        int i5;
        try {
            i5 = u1.j(str);
        } catch (u1.d unused) {
            i5 = str.getBytes(b0.f3469a).length;
        }
        return D(i5);
    }

    public static int W(int i5) {
        return Y(v1.c(i5, 0));
    }

    public static int X(int i5, int i6) {
        return W(i5) + Y(i6);
    }

    public static int Y(int i5) {
        if ((i5 & -128) == 0) {
            return 1;
        }
        if ((i5 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i5) == 0) {
            return 3;
        }
        return (i5 & -268435456) == 0 ? 4 : 5;
    }

    public static int Z(int i5, long j5) {
        return W(i5) + a0(j5);
    }

    public static int a0(long j5) {
        int i5;
        if ((-128 & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if ((-34359738368L & j5) != 0) {
            i5 = 6;
            j5 >>>= 28;
        } else {
            i5 = 2;
        }
        if ((-2097152 & j5) != 0) {
            i5 += 2;
            j5 >>>= 14;
        }
        return (j5 & -16384) != 0 ? i5 + 1 : i5;
    }

    public static int b0(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public static long c0(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    public static int e(int i5, boolean z4) {
        return W(i5) + f(z4);
    }

    public static int f(boolean z4) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return D(bArr.length);
    }

    public static l g0(OutputStream outputStream, int i5) {
        return new e(outputStream, i5);
    }

    public static int h(int i5, i iVar) {
        return W(i5) + i(iVar);
    }

    public static l h0(byte[] bArr) {
        return i0(bArr, 0, bArr.length);
    }

    public static int i(i iVar) {
        return D(iVar.size());
    }

    public static l i0(byte[] bArr, int i5, int i6) {
        return new c(bArr, i5, i6);
    }

    public static int j(int i5, double d5) {
        return W(i5) + k(d5);
    }

    public static int k(double d5) {
        return 8;
    }

    public static int l(int i5, int i6) {
        return W(i5) + m(i6);
    }

    public static int m(int i5) {
        return x(i5);
    }

    public static int n(int i5, int i6) {
        return W(i5) + o(i6);
    }

    public static int o(int i5) {
        return 4;
    }

    public static int p(int i5, long j5) {
        return W(i5) + q(j5);
    }

    public static int q(long j5) {
        return 8;
    }

    public static int r(int i5, float f5) {
        return W(i5) + s(f5);
    }

    public static int s(float f5) {
        return 4;
    }

    @Deprecated
    static int t(int i5, s0 s0Var, i1 i1Var) {
        return (W(i5) * 2) + v(s0Var, i1Var);
    }

    @Deprecated
    public static int u(s0 s0Var) {
        return s0Var.getSerializedSize();
    }

    @Deprecated
    static int v(s0 s0Var, i1 i1Var) {
        return ((a) s0Var).getSerializedSize(i1Var);
    }

    public static int w(int i5, int i6) {
        return W(i5) + x(i6);
    }

    public static int x(int i5) {
        if (i5 >= 0) {
            return Y(i5);
        }
        return 10;
    }

    public static int y(int i5, long j5) {
        return W(i5) + z(j5);
    }

    public static int z(long j5) {
        return a0(j5);
    }

    public abstract void A0(int i5, int i6);

    public abstract void B0(int i5);

    public final void C0(int i5, long j5) {
        U0(i5, j5);
    }

    public final void D0(long j5) {
        V0(j5);
    }

    /* access modifiers changed from: package-private */
    public abstract void E0(int i5, s0 s0Var, i1 i1Var);

    public abstract void F0(int i5, s0 s0Var);

    public abstract void G0(int i5, i iVar);

    @Deprecated
    public final void H0(int i5) {
        T0(i5);
    }

    public final void I0(int i5, int i6) {
        s0(i5, i6);
    }

    public final void J0(int i5) {
        t0(i5);
    }

    public final void K0(int i5, long j5) {
        u0(i5, j5);
    }

    public final void L0(long j5) {
        v0(j5);
    }

    public final void M0(int i5, int i6) {
        S0(i5, b0(i6));
    }

    public final void N0(int i5) {
        T0(b0(i5));
    }

    public final void O0(int i5, long j5) {
        U0(i5, c0(j5));
    }

    public final void P0(long j5) {
        V0(c0(j5));
    }

    public abstract void Q0(int i5, String str);

    public abstract void R0(int i5, int i6);

    public abstract void S0(int i5, int i6);

    public abstract void T0(int i5);

    public abstract void U0(int i5, long j5);

    public abstract void V0(long j5);

    public abstract void b(byte[] bArr, int i5, int i6);

    public final void d() {
        if (j0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void d0();

    /* access modifiers changed from: package-private */
    public final void e0(String str, u1.d dVar) {
        f3596c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", dVar);
        byte[] bytes = str.getBytes(b0.f3469a);
        try {
            T0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new d(e5);
        } catch (d e6) {
            throw e6;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f0() {
        return this.f3599b;
    }

    public abstract int j0();

    public abstract void k0(byte b5);

    public abstract void l0(int i5, boolean z4);

    public final void m0(boolean z4) {
        k0(z4 ? (byte) 1 : 0);
    }

    public abstract void n0(int i5, i iVar);

    public final void o0(int i5, double d5) {
        u0(i5, Double.doubleToRawLongBits(d5));
    }

    public final void p0(double d5) {
        v0(Double.doubleToRawLongBits(d5));
    }

    public final void q0(int i5, int i6) {
        A0(i5, i6);
    }

    public final void r0(int i5) {
        B0(i5);
    }

    public abstract void s0(int i5, int i6);

    public abstract void t0(int i5);

    public abstract void u0(int i5, long j5);

    public abstract void v0(long j5);

    public final void w0(int i5, float f5) {
        s0(i5, Float.floatToRawIntBits(f5));
    }

    public final void x0(float f5) {
        t0(Float.floatToRawIntBits(f5));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void y0(int i5, s0 s0Var, i1 i1Var) {
        R0(i5, 3);
        z0(s0Var, i1Var);
        R0(i5, 4);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void z0(s0 s0Var, i1 i1Var) {
        i1Var.b(s0Var, this.f3598a);
    }
}
