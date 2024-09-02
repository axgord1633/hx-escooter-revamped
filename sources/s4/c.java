package s4;

import com.yalantis.ucrop.BuildConfig;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f6757g = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    o f6758e;

    /* renamed from: f  reason: collision with root package name */
    long f6759f;

    public String A(long j5) {
        if (j5 >= 0) {
            long j6 = Long.MAX_VALUE;
            if (j5 != Long.MAX_VALUE) {
                j6 = j5 + 1;
            }
            long l5 = l((byte) 10, 0, j6);
            if (l5 != -1) {
                return w(l5);
            }
            if (j6 < size() && j(j6 - 1) == 13 && j(j6) == 10) {
                return w(j6);
            }
            c cVar = new c();
            g(cVar, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j5) + " content=" + cVar.n().q() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j5);
    }

    public final f B(int i5) {
        return i5 == 0 ? f.f6761i : new q(this, i5);
    }

    /* access modifiers changed from: package-private */
    public o C(int i5) {
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.f6758e;
        if (oVar == null) {
            o b5 = p.b();
            this.f6758e = b5;
            b5.f6795g = b5;
            b5.f6794f = b5;
            return b5;
        }
        o oVar2 = oVar.f6795g;
        return (oVar2.f6791c + i5 > 8192 || !oVar2.f6793e) ? oVar2.c(p.b()) : oVar2;
    }

    public c D(f fVar) {
        if (fVar != null) {
            fVar.C(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: E */
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: F */
    public c write(byte[] bArr, int i5, int i6) {
        if (bArr != null) {
            long j5 = (long) i6;
            u.b((long) bArr.length, (long) i5, j5);
            int i7 = i6 + i5;
            while (i5 < i7) {
                o C = C(1);
                int min = Math.min(i7 - i5, 8192 - C.f6791c);
                System.arraycopy(bArr, i5, C.f6789a, C.f6791c, min);
                i5 += min;
                C.f6791c += min;
            }
            this.f6759f += j5;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void G(c cVar, long j5) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            u.b(cVar.f6759f, 0, j5);
            while (j5 > 0) {
                o oVar = cVar.f6758e;
                if (j5 < ((long) (oVar.f6791c - oVar.f6790b))) {
                    o oVar2 = this.f6758e;
                    o oVar3 = oVar2 != null ? oVar2.f6795g : null;
                    if (oVar3 != null && oVar3.f6793e) {
                        if ((((long) oVar3.f6791c) + j5) - ((long) (oVar3.f6792d ? 0 : oVar3.f6790b)) <= 8192) {
                            oVar.f(oVar3, (int) j5);
                            cVar.f6759f -= j5;
                            this.f6759f += j5;
                            return;
                        }
                    }
                    cVar.f6758e = oVar.e((int) j5);
                }
                o oVar4 = cVar.f6758e;
                long j6 = (long) (oVar4.f6791c - oVar4.f6790b);
                cVar.f6758e = oVar4.b();
                o oVar5 = this.f6758e;
                if (oVar5 == null) {
                    this.f6758e = oVar4;
                    oVar4.f6795g = oVar4;
                    oVar4.f6794f = oVar4;
                } else {
                    oVar5.f6795g.c(oVar4).a();
                }
                cVar.f6759f -= j6;
                this.f6759f += j6;
                j5 -= j6;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public void H(long j5) {
        if (this.f6759f < j5) {
            throw new EOFException();
        }
    }

    public long J(byte b5) {
        return l(b5, 0, Long.MAX_VALUE);
    }

    public long K(c cVar, long j5) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j5 >= 0) {
            long j6 = this.f6759f;
            if (j6 == 0) {
                return -1;
            }
            if (j5 > j6) {
                j5 = j6;
            }
            cVar.G(this, j5);
            return j5;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r14.f6758e = r6.b();
        s4.p.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.f6790b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r1 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long L() {
        /*
            r14 = this;
            long r0 = r14.f6759f
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00ac
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000b:
            s4.o r6 = r14.f6758e
            byte[] r7 = r6.f6789a
            int r8 = r6.f6790b
            int r9 = r6.f6791c
        L_0x0013:
            if (r8 >= r9) goto L_0x0091
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0072
            r11 = 70
            if (r10 > r11) goto L_0x0072
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004a:
            s4.c r0 = new s4.c
            r0.<init>()
            s4.c r0 = r0.i(r4)
            s4.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.q()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0072:
            if (r0 == 0) goto L_0x0076
            r1 = 1
            goto L_0x0091
        L_0x0076:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0091:
            if (r8 != r9) goto L_0x009d
            s4.o r7 = r6.b()
            r14.f6758e = r7
            s4.p.a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f6790b = r8
        L_0x009f:
            if (r1 != 0) goto L_0x00a5
            s4.o r6 = r14.f6758e
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r1 = r14.f6759f
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f6759f = r1
            return r4
        L_0x00ac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.c.L():long");
    }

    public long M(s sVar) {
        if (sVar != null) {
            long j5 = 0;
            while (true) {
                long K = sVar.K(this, 8192);
                if (K == -1) {
                    return j5;
                }
                j5 += K;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: N */
    public c writeByte(int i5) {
        o C = C(1);
        byte[] bArr = C.f6789a;
        int i6 = C.f6791c;
        C.f6791c = i6 + 1;
        bArr[i6] = (byte) i5;
        this.f6759f++;
        return this;
    }

    /* renamed from: O */
    public c i(long j5) {
        if (j5 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j5)) / 4) + 1;
        o C = C(numberOfTrailingZeros);
        byte[] bArr = C.f6789a;
        int i5 = C.f6791c;
        for (int i6 = (i5 + numberOfTrailingZeros) - 1; i6 >= i5; i6--) {
            bArr[i6] = f6757g[(int) (15 & j5)];
            j5 >>>= 4;
        }
        C.f6791c += numberOfTrailingZeros;
        this.f6759f += (long) numberOfTrailingZeros;
        return this;
    }

    /* renamed from: P */
    public c writeInt(int i5) {
        o C = C(4);
        byte[] bArr = C.f6789a;
        int i6 = C.f6791c;
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i5 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i5 >>> 8) & 255);
        bArr[i9] = (byte) (i5 & 255);
        C.f6791c = i9 + 1;
        this.f6759f += 4;
        return this;
    }

    /* renamed from: Q */
    public c writeShort(int i5) {
        o C = C(2);
        byte[] bArr = C.f6789a;
        int i6 = C.f6791c;
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i7] = (byte) (i5 & 255);
        C.f6791c = i7 + 1;
        this.f6759f += 2;
        return this;
    }

    public c R(String str, int i5, int i6, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i5 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i5);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i6 + " < " + i5);
        } else if (i6 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i6 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(u.f6804a)) {
            return T(str, i5, i6);
        } else {
            byte[] bytes = str.substring(i5, i6).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    /* renamed from: S */
    public c I(String str) {
        return T(str, 0, str.length());
    }

    public c T(String str, int i5, int i6) {
        int i7;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i5 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i5);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i6 + " < " + i5);
        } else if (i6 <= str.length()) {
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt < 128) {
                    o C = C(1);
                    byte[] bArr = C.f6789a;
                    int i8 = C.f6791c - i5;
                    int min = Math.min(i6, 8192 - i8);
                    int i9 = i5 + 1;
                    bArr[i5 + i8] = (byte) charAt;
                    while (i9 < min) {
                        char charAt2 = str.charAt(i9);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i9 + i8] = (byte) charAt2;
                        i9++;
                    }
                    int i10 = C.f6791c;
                    int i11 = (i8 + i9) - i10;
                    C.f6791c = i10 + i11;
                    this.f6759f += (long) i11;
                    i5 = i9;
                } else {
                    if (charAt < 2048) {
                        i7 = (charAt >> 6) | 192;
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        i7 = ((charAt >> 6) & 63) | 128;
                    } else {
                        int i12 = i5 + 1;
                        char charAt3 = i12 < i6 ? str.charAt(i12) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i5 = i12;
                        } else {
                            int i13 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i13 >> 18) | 240);
                            writeByte(((i13 >> 12) & 63) | 128);
                            writeByte(((i13 >> 6) & 63) | 128);
                            writeByte((i13 & 63) | 128);
                            i5 += 2;
                        }
                    }
                    writeByte(i7);
                    writeByte((charAt & '?') | 128);
                    i5++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i6 + " > " + str.length());
        }
    }

    public c U(int i5) {
        int i6;
        int i7;
        if (i5 >= 128) {
            if (i5 < 2048) {
                i7 = (i5 >> 6) | 192;
            } else {
                if (i5 < 65536) {
                    if (i5 < 55296 || i5 > 57343) {
                        i6 = (i5 >> 12) | 224;
                    } else {
                        writeByte(63);
                        return this;
                    }
                } else if (i5 <= 1114111) {
                    writeByte((i5 >> 18) | 240);
                    i6 = ((i5 >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i5));
                }
                writeByte(i6);
                i7 = ((i5 >> 6) & 63) | 128;
            }
            writeByte(i7);
            i5 = (i5 & 63) | 128;
        }
        writeByte(i5);
        return this;
    }

    public c a() {
        return this;
    }

    public final void b() {
        try {
            skip(this.f6759f);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public t c() {
        return t.f6800d;
    }

    public void close() {
    }

    /* renamed from: d */
    public c clone() {
        c cVar = new c();
        if (this.f6759f == 0) {
            return cVar;
        }
        o d5 = this.f6758e.d();
        cVar.f6758e = d5;
        d5.f6795g = d5;
        d5.f6794f = d5;
        o oVar = this.f6758e;
        while (true) {
            oVar = oVar.f6794f;
            if (oVar != this.f6758e) {
                cVar.f6758e.f6795g.c(oVar.d());
            } else {
                cVar.f6759f = this.f6759f;
                return cVar;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j5 = this.f6759f;
        if (j5 != cVar.f6759f) {
            return false;
        }
        long j6 = 0;
        if (j5 == 0) {
            return true;
        }
        o oVar = this.f6758e;
        o oVar2 = cVar.f6758e;
        int i5 = oVar.f6790b;
        int i6 = oVar2.f6790b;
        while (j6 < this.f6759f) {
            long min = (long) Math.min(oVar.f6791c - i5, oVar2.f6791c - i6);
            int i7 = 0;
            while (((long) i7) < min) {
                int i8 = i5 + 1;
                int i9 = i6 + 1;
                if (oVar.f6789a[i5] != oVar2.f6789a[i6]) {
                    return false;
                }
                i7++;
                i5 = i8;
                i6 = i9;
            }
            if (i5 == oVar.f6791c) {
                oVar = oVar.f6794f;
                i5 = oVar.f6790b;
            }
            if (i6 == oVar2.f6791c) {
                oVar2 = oVar2.f6794f;
                i6 = oVar2.f6790b;
            }
            j6 += min;
        }
        return true;
    }

    public final long f() {
        long j5 = this.f6759f;
        if (j5 == 0) {
            return 0;
        }
        o oVar = this.f6758e.f6795g;
        int i5 = oVar.f6791c;
        return (i5 >= 8192 || !oVar.f6793e) ? j5 : j5 - ((long) (i5 - oVar.f6790b));
    }

    public void flush() {
    }

    public final c g(c cVar, long j5, long j6) {
        if (cVar != null) {
            u.b(this.f6759f, j5, j6);
            if (j6 == 0) {
                return this;
            }
            cVar.f6759f += j6;
            o oVar = this.f6758e;
            while (true) {
                int i5 = oVar.f6791c;
                int i6 = oVar.f6790b;
                if (j5 < ((long) (i5 - i6))) {
                    break;
                }
                j5 -= (long) (i5 - i6);
                oVar = oVar.f6794f;
            }
            while (j6 > 0) {
                o d5 = oVar.d();
                int i7 = (int) (((long) d5.f6790b) + j5);
                d5.f6790b = i7;
                d5.f6791c = Math.min(i7 + ((int) j6), d5.f6791c);
                o oVar2 = cVar.f6758e;
                if (oVar2 == null) {
                    d5.f6795g = d5;
                    d5.f6794f = d5;
                    cVar.f6758e = d5;
                } else {
                    oVar2.f6795g.c(d5);
                }
                j6 -= (long) (d5.f6791c - d5.f6790b);
                oVar = oVar.f6794f;
                j5 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: h */
    public c y() {
        return this;
    }

    public int hashCode() {
        o oVar = this.f6758e;
        if (oVar == null) {
            return 0;
        }
        int i5 = 1;
        do {
            int i6 = oVar.f6791c;
            for (int i7 = oVar.f6790b; i7 < i6; i7++) {
                i5 = (i5 * 31) + oVar.f6789a[i7];
            }
            oVar = oVar.f6794f;
        } while (oVar != this.f6758e);
        return i5;
    }

    public boolean isOpen() {
        return true;
    }

    public final byte j(long j5) {
        int i5;
        u.b(this.f6759f, j5, 1);
        long j6 = this.f6759f;
        if (j6 - j5 > j5) {
            o oVar = this.f6758e;
            while (true) {
                int i6 = oVar.f6791c;
                int i7 = oVar.f6790b;
                long j7 = (long) (i6 - i7);
                if (j5 < j7) {
                    return oVar.f6789a[i7 + ((int) j5)];
                }
                j5 -= j7;
                oVar = oVar.f6794f;
            }
        } else {
            long j8 = j5 - j6;
            o oVar2 = this.f6758e;
            do {
                oVar2 = oVar2.f6795g;
                int i8 = oVar2.f6791c;
                i5 = oVar2.f6790b;
                j8 += (long) (i8 - i5);
            } while (j8 < 0);
            return oVar2.f6789a[i5 + ((int) j8)];
        }
    }

    public f k(long j5) {
        return new f(u(j5));
    }

    public long l(byte b5, long j5, long j6) {
        o oVar;
        long j7 = 0;
        if (j5 < 0 || j6 < j5) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f6759f), Long.valueOf(j5), Long.valueOf(j6)}));
        }
        long j8 = this.f6759f;
        long j9 = j6 > j8 ? j8 : j6;
        if (j5 == j9 || (oVar = this.f6758e) == null) {
            return -1;
        }
        if (j8 - j5 < j5) {
            while (j8 > j5) {
                oVar = oVar.f6795g;
                j8 -= (long) (oVar.f6791c - oVar.f6790b);
            }
        } else {
            while (true) {
                long j10 = ((long) (oVar.f6791c - oVar.f6790b)) + j7;
                if (j10 >= j5) {
                    break;
                }
                oVar = oVar.f6794f;
                j7 = j10;
            }
            j8 = j7;
        }
        long j11 = j5;
        while (j8 < j9) {
            byte[] bArr = oVar.f6789a;
            int min = (int) Math.min((long) oVar.f6791c, (((long) oVar.f6790b) + j9) - j8);
            for (int i5 = (int) ((((long) oVar.f6790b) + j11) - j8); i5 < min; i5++) {
                if (bArr[i5] == b5) {
                    return ((long) (i5 - oVar.f6790b)) + j8;
                }
            }
            byte b6 = b5;
            j8 += (long) (oVar.f6791c - oVar.f6790b);
            oVar = oVar.f6794f;
            j11 = j8;
        }
        return -1;
    }

    public byte[] m() {
        try {
            return u(this.f6759f);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public f n() {
        return new f(m());
    }

    public long o(r rVar) {
        long j5 = this.f6759f;
        if (j5 > 0) {
            rVar.G(this, j5);
        }
        return j5;
    }

    public String p(long j5, Charset charset) {
        u.b(this.f6759f, 0, j5);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j5 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
        } else if (j5 == 0) {
            return BuildConfig.FLAVOR;
        } else {
            o oVar = this.f6758e;
            int i5 = oVar.f6790b;
            if (((long) i5) + j5 > ((long) oVar.f6791c)) {
                return new String(u(j5), charset);
            }
            String str = new String(oVar.f6789a, i5, (int) j5, charset);
            int i6 = (int) (((long) oVar.f6790b) + j5);
            oVar.f6790b = i6;
            this.f6759f -= j5;
            if (i6 == oVar.f6791c) {
                this.f6758e = oVar.b();
                p.a(oVar);
            }
            return str;
        }
    }

    public String q() {
        try {
            return p(this.f6759f, u.f6804a);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public String r() {
        return A(Long.MAX_VALUE);
    }

    public int read(ByteBuffer byteBuffer) {
        o oVar = this.f6758e;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f6791c - oVar.f6790b);
        byteBuffer.put(oVar.f6789a, oVar.f6790b, min);
        int i5 = oVar.f6790b + min;
        oVar.f6790b = i5;
        this.f6759f -= (long) min;
        if (i5 == oVar.f6791c) {
            this.f6758e = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public int read(byte[] bArr, int i5, int i6) {
        u.b((long) bArr.length, (long) i5, (long) i6);
        o oVar = this.f6758e;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i6, oVar.f6791c - oVar.f6790b);
        System.arraycopy(oVar.f6789a, oVar.f6790b, bArr, i5, min);
        int i7 = oVar.f6790b + min;
        oVar.f6790b = i7;
        this.f6759f -= (long) min;
        if (i7 == oVar.f6791c) {
            this.f6758e = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public byte readByte() {
        long j5 = this.f6759f;
        if (j5 != 0) {
            o oVar = this.f6758e;
            int i5 = oVar.f6790b;
            int i6 = oVar.f6791c;
            int i7 = i5 + 1;
            byte b5 = oVar.f6789a[i5];
            this.f6759f = j5 - 1;
            if (i7 == i6) {
                this.f6758e = oVar.b();
                p.a(oVar);
            } else {
                oVar.f6790b = i7;
            }
            return b5;
        }
        throw new IllegalStateException("size == 0");
    }

    public void readFully(byte[] bArr) {
        int i5 = 0;
        while (i5 < bArr.length) {
            int read = read(bArr, i5, bArr.length - i5);
            if (read != -1) {
                i5 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() {
        long j5 = this.f6759f;
        if (j5 >= 4) {
            o oVar = this.f6758e;
            int i5 = oVar.f6790b;
            int i6 = oVar.f6791c;
            if (i6 - i5 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = oVar.f6789a;
            int i7 = i5 + 1;
            int i8 = i7 + 1;
            byte b5 = ((bArr[i5] & 255) << 24) | ((bArr[i7] & 255) << 16);
            int i9 = i8 + 1;
            byte b6 = b5 | ((bArr[i8] & 255) << 8);
            int i10 = i9 + 1;
            byte b7 = b6 | (bArr[i9] & 255);
            this.f6759f = j5 - 4;
            if (i10 == i6) {
                this.f6758e = oVar.b();
                p.a(oVar);
            } else {
                oVar.f6790b = i10;
            }
            return b7;
        }
        throw new IllegalStateException("size < 4: " + this.f6759f);
    }

    public short readShort() {
        long j5 = this.f6759f;
        if (j5 >= 2) {
            o oVar = this.f6758e;
            int i5 = oVar.f6790b;
            int i6 = oVar.f6791c;
            if (i6 - i5 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = oVar.f6789a;
            int i7 = i5 + 1;
            int i8 = i7 + 1;
            byte b5 = ((bArr[i5] & 255) << 8) | (bArr[i7] & 255);
            this.f6759f = j5 - 2;
            if (i8 == i6) {
                this.f6758e = oVar.b();
                p.a(oVar);
            } else {
                oVar.f6790b = i8;
            }
            return (short) b5;
        }
        throw new IllegalStateException("size < 2: " + this.f6759f);
    }

    public int s() {
        return u.c(readInt());
    }

    public final long size() {
        return this.f6759f;
    }

    public void skip(long j5) {
        while (j5 > 0) {
            o oVar = this.f6758e;
            if (oVar != null) {
                int min = (int) Math.min(j5, (long) (oVar.f6791c - oVar.f6790b));
                long j6 = (long) min;
                this.f6759f -= j6;
                j5 -= j6;
                o oVar2 = this.f6758e;
                int i5 = oVar2.f6790b + min;
                oVar2.f6790b = i5;
                if (i5 == oVar2.f6791c) {
                    this.f6758e = oVar2.b();
                    p.a(oVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public boolean t() {
        return this.f6759f == 0;
    }

    public String toString() {
        return z().toString();
    }

    public byte[] u(long j5) {
        u.b(this.f6759f, 0, j5);
        if (j5 <= 2147483647L) {
            byte[] bArr = new byte[((int) j5)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
    }

    public String v(long j5) {
        return p(j5, u.f6804a);
    }

    /* access modifiers changed from: package-private */
    public String w(long j5) {
        if (j5 > 0) {
            long j6 = j5 - 1;
            if (j(j6) == 13) {
                String v5 = v(j6);
                skip(2);
                return v5;
            }
        }
        String v6 = v(j5);
        skip(1);
        return v6;
    }

    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i5 = remaining;
            while (i5 > 0) {
                o C = C(1);
                int min = Math.min(i5, 8192 - C.f6791c);
                byteBuffer.get(C.f6789a, C.f6791c, min);
                i5 -= min;
                C.f6791c += min;
            }
            this.f6759f += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public short x() {
        return u.d(readShort());
    }

    public final f z() {
        long j5 = this.f6759f;
        if (j5 <= 2147483647L) {
            return B((int) j5);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f6759f);
    }
}
