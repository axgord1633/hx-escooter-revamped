package com.google.protobuf;

import java.nio.ByteBuffer;

final class u1 {

    /* renamed from: a  reason: collision with root package name */
    private static final b f3692a = ((!e.m() || d.c()) ? new c() : new e());

    private static class a {
        /* access modifiers changed from: private */
        public static void h(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) {
            if (m(b6) || (((b5 << 28) + (b6 + 112)) >> 30) != 0 || m(b7) || m(b8)) {
                throw c0.d();
            }
            int r5 = ((b5 & 7) << 18) | (r(b6) << 12) | (r(b7) << 6) | r(b8);
            cArr[i5] = l(r5);
            cArr[i5 + 1] = q(r5);
        }

        /* access modifiers changed from: private */
        public static void i(byte b5, char[] cArr, int i5) {
            cArr[i5] = (char) b5;
        }

        /* access modifiers changed from: private */
        public static void j(byte b5, byte b6, byte b7, char[] cArr, int i5) {
            if (m(b6) || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || m(b7)))) {
                throw c0.d();
            }
            cArr[i5] = (char) (((b5 & 15) << 12) | (r(b6) << 6) | r(b7));
        }

        /* access modifiers changed from: private */
        public static void k(byte b5, byte b6, char[] cArr, int i5) {
            if (b5 < -62 || m(b6)) {
                throw c0.d();
            }
            cArr[i5] = (char) (((b5 & 31) << 6) | r(b6));
        }

        private static char l(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean m(byte b5) {
            return b5 > -65;
        }

        /* access modifiers changed from: private */
        public static boolean n(byte b5) {
            return b5 >= 0;
        }

        /* access modifiers changed from: private */
        public static boolean o(byte b5) {
            return b5 < -16;
        }

        /* access modifiers changed from: private */
        public static boolean p(byte b5) {
            return b5 < -32;
        }

        private static char q(int i5) {
            return (char) ((i5 & 1023) + 56320);
        }

        private static int r(byte b5) {
            return b5 & 63;
        }
    }

    static abstract class b {
        b() {
        }

        private static int j(ByteBuffer byteBuffer, int i5, int i6) {
            int e5 = i5 + u1.l(byteBuffer, i5, i6);
            while (e5 < i6) {
                int i7 = e5 + 1;
                byte b5 = byteBuffer.get(e5);
                if (b5 < 0) {
                    if (b5 >= -32) {
                        if (b5 < -16) {
                            if (i7 < i6 - 1) {
                                int i8 = i7 + 1;
                                byte b6 = byteBuffer.get(i7);
                                if (b6 > -65 || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || byteBuffer.get(i8) > -65))) {
                                    return -1;
                                }
                                e5 = i8 + 1;
                            }
                        } else if (i7 < i6 - 2) {
                            int i9 = i7 + 1;
                            byte b7 = byteBuffer.get(i7);
                            if (b7 <= -65 && (((b5 << 28) + (b7 + 112)) >> 30) == 0) {
                                int i10 = i9 + 1;
                                if (byteBuffer.get(i9) <= -65) {
                                    i7 = i10 + 1;
                                    if (byteBuffer.get(i10) > -65) {
                                    }
                                }
                            }
                            return -1;
                        }
                        return u1.p(byteBuffer, b5, i7, i6 - i7);
                    } else if (i7 >= i6) {
                        return b5;
                    } else {
                        if (b5 < -62 || byteBuffer.get(i7) > -65) {
                            return -1;
                        }
                        i7++;
                    }
                }
                e5 = i7;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public final String a(ByteBuffer byteBuffer, int i5, int i6) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? d(byteBuffer, i5, i6) : c(byteBuffer, i5, i6);
            }
            return b(byteBuffer.array(), byteBuffer.arrayOffset() + i5, i6);
        }

        /* access modifiers changed from: package-private */
        public abstract String b(byte[] bArr, int i5, int i6);

        /* access modifiers changed from: package-private */
        public final String c(ByteBuffer byteBuffer, int i5, int i6) {
            if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) >= 0) {
                int i7 = i5 + i6;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (r13 < i7) {
                    byte b5 = byteBuffer.get(r13);
                    if (!a.n(b5)) {
                        break;
                    }
                    i5 = r13 + 1;
                    a.i(b5, cArr, i8);
                    i8++;
                }
                int i9 = i8;
                while (r13 < i7) {
                    int i10 = r13 + 1;
                    byte b6 = byteBuffer.get(r13);
                    if (a.n(b6)) {
                        int i11 = i9 + 1;
                        a.i(b6, cArr, i9);
                        while (i10 < i7) {
                            byte b7 = byteBuffer.get(i10);
                            if (!a.n(b7)) {
                                break;
                            }
                            i10++;
                            a.i(b7, cArr, i11);
                            i11++;
                        }
                        r13 = i10;
                        i9 = i11;
                    } else if (a.p(b6)) {
                        if (i10 < i7) {
                            a.k(b6, byteBuffer.get(i10), cArr, i9);
                            r13 = i10 + 1;
                            i9++;
                        } else {
                            throw c0.d();
                        }
                    } else if (a.o(b6)) {
                        if (i10 < i7 - 1) {
                            int i12 = i10 + 1;
                            a.j(b6, byteBuffer.get(i10), byteBuffer.get(i12), cArr, i9);
                            r13 = i12 + 1;
                            i9++;
                        } else {
                            throw c0.d();
                        }
                    } else if (i10 < i7 - 2) {
                        int i13 = i10 + 1;
                        byte b8 = byteBuffer.get(i10);
                        int i14 = i13 + 1;
                        a.h(b6, b8, byteBuffer.get(i13), byteBuffer.get(i14), cArr, i9);
                        r13 = i14 + 1;
                        i9 = i9 + 1 + 1;
                    } else {
                        throw c0.d();
                    }
                }
                return new String(cArr, 0, i9);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)}));
        }

        /* access modifiers changed from: package-private */
        public abstract String d(ByteBuffer byteBuffer, int i5, int i6);

        /* access modifiers changed from: package-private */
        public abstract int e(CharSequence charSequence, byte[] bArr, int i5, int i6);

        /* access modifiers changed from: package-private */
        public final boolean f(ByteBuffer byteBuffer, int i5, int i6) {
            return h(0, byteBuffer, i5, i6) == 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean g(byte[] bArr, int i5, int i6) {
            return i(0, bArr, i5, i6) == 0;
        }

        /* access modifiers changed from: package-private */
        public final int h(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? l(i5, byteBuffer, i6, i7) : k(i5, byteBuffer, i6, i7);
            }
            int arrayOffset = byteBuffer.arrayOffset();
            return i(i5, byteBuffer.array(), i6 + arrayOffset, arrayOffset + i7);
        }

        /* access modifiers changed from: package-private */
        public abstract int i(int i5, byte[] bArr, int i6, int i7);

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r8.get(r9) > -65) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008b, code lost:
            if (r8.get(r9) > -65) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int k(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x008e
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001e
                r7 = -62
                if (r0 < r7) goto L_0x001d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
                goto L_0x001d
            L_0x001a:
                r9 = r7
                goto L_0x008e
            L_0x001d:
                return r2
            L_0x001e:
                r4 = -16
                if (r0 >= r4) goto L_0x004f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0038
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L_0x0035
                int r7 = com.google.protobuf.u1.n(r0, r9)
                return r7
            L_0x0035:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0038:
                if (r7 > r3) goto L_0x004e
                r4 = -96
                if (r0 != r1) goto L_0x0040
                if (r7 < r4) goto L_0x004e
            L_0x0040:
                r1 = -19
                if (r0 != r1) goto L_0x0046
                if (r7 >= r4) goto L_0x004e
            L_0x0046:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x004e:
                return r2
            L_0x004f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x0065
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L_0x0063
                int r7 = com.google.protobuf.u1.n(r0, r1)
                return r7
            L_0x0063:
                r9 = r7
                goto L_0x0068
            L_0x0065:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L_0x0068:
                if (r4 != 0) goto L_0x0078
                int r7 = r9 + 1
                byte r4 = r8.get(r9)
                if (r7 < r10) goto L_0x0077
                int r7 = com.google.protobuf.u1.o(r0, r1, r4)
                return r7
            L_0x0077:
                r9 = r7
            L_0x0078:
                if (r1 > r3) goto L_0x008d
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x008d
                if (r4 > r3) goto L_0x008d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x008d:
                return r2
            L_0x008e:
                int r7 = j(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.u1.b.k(int, java.nio.ByteBuffer, int, int):int");
        }

        /* access modifiers changed from: package-private */
        public abstract int l(int i5, ByteBuffer byteBuffer, int i6, int i7);
    }

    static final class c extends b {
        c() {
        }

        private static int m(byte[] bArr, int i5, int i6) {
            while (i5 < i6 && bArr[i5] >= 0) {
                i5++;
            }
            if (i5 >= i6) {
                return 0;
            }
            return n(bArr, i5, i6);
        }

        private static int n(byte[] bArr, int i5, int i6) {
            while (i5 < i6) {
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 < 0) {
                    if (b5 < -32) {
                        if (i7 >= i6) {
                            return b5;
                        }
                        if (b5 >= -62) {
                            i5 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                        return -1;
                    } else if (b5 < -16) {
                        if (i7 >= i6 - 1) {
                            return u1.q(bArr, i7, i6);
                        }
                        int i8 = i7 + 1;
                        byte b6 = bArr[i7];
                        if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                            i5 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                        return -1;
                    } else if (i7 >= i6 - 2) {
                        return u1.q(bArr, i7, i6);
                    } else {
                        int i9 = i7 + 1;
                        byte b7 = bArr[i7];
                        if (b7 <= -65 && (((b5 << 28) + (b7 + 112)) >> 30) == 0) {
                            int i10 = i9 + 1;
                            if (bArr[i9] <= -65) {
                                i7 = i10 + 1;
                                if (bArr[i10] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i5 = i7;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String b(byte[] bArr, int i5, int i6) {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) >= 0) {
                int i7 = i5 + i6;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (r13 < i7) {
                    byte b5 = bArr[r13];
                    if (!a.n(b5)) {
                        break;
                    }
                    i5 = r13 + 1;
                    a.i(b5, cArr, i8);
                    i8++;
                }
                int i9 = i8;
                while (r13 < i7) {
                    int i10 = r13 + 1;
                    byte b6 = bArr[r13];
                    if (a.n(b6)) {
                        int i11 = i9 + 1;
                        a.i(b6, cArr, i9);
                        while (i10 < i7) {
                            byte b7 = bArr[i10];
                            if (!a.n(b7)) {
                                break;
                            }
                            i10++;
                            a.i(b7, cArr, i11);
                            i11++;
                        }
                        r13 = i10;
                        i9 = i11;
                    } else if (a.p(b6)) {
                        if (i10 < i7) {
                            a.k(b6, bArr[i10], cArr, i9);
                            r13 = i10 + 1;
                            i9++;
                        } else {
                            throw c0.d();
                        }
                    } else if (a.o(b6)) {
                        if (i10 < i7 - 1) {
                            int i12 = i10 + 1;
                            a.j(b6, bArr[i10], bArr[i12], cArr, i9);
                            r13 = i12 + 1;
                            i9++;
                        } else {
                            throw c0.d();
                        }
                    } else if (i10 < i7 - 2) {
                        int i13 = i10 + 1;
                        byte b8 = bArr[i10];
                        int i14 = i13 + 1;
                        a.h(b6, b8, bArr[i13], bArr[i14], cArr, i9);
                        r13 = i14 + 1;
                        i9 = i9 + 1 + 1;
                    } else {
                        throw c0.d();
                    }
                }
                return new String(cArr, 0, i9);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
        }

        /* access modifiers changed from: package-private */
        public String d(ByteBuffer byteBuffer, int i5, int i6) {
            return c(byteBuffer, i5, i6);
        }

        /* access modifiers changed from: package-private */
        public int e(CharSequence charSequence, byte[] bArr, int i5, int i6) {
            int i7;
            int i8;
            int i9;
            char charAt;
            int length = charSequence.length();
            int i10 = i6 + i5;
            int i11 = 0;
            while (i11 < length && (i9 = i11 + i5) < i10 && (charAt = charSequence.charAt(i11)) < 128) {
                bArr[i9] = (byte) charAt;
                i11++;
            }
            if (i11 == length) {
                return i5 + length;
            }
            int i12 = i5 + i11;
            while (i11 < length) {
                char charAt2 = charSequence.charAt(i11);
                if (charAt2 < 128 && i12 < i10) {
                    i8 = i12 + 1;
                    bArr[i12] = (byte) charAt2;
                } else if (charAt2 < 2048 && i12 <= i10 - 2) {
                    int i13 = i12 + 1;
                    bArr[i12] = (byte) ((charAt2 >>> 6) | 960);
                    i12 = i13 + 1;
                    bArr[i13] = (byte) ((charAt2 & '?') | 128);
                    i11++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i12 <= i10 - 3) {
                    int i14 = i12 + 1;
                    bArr[i12] = (byte) ((charAt2 >>> 12) | 480);
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i8 = i15 + 1;
                    bArr[i15] = (byte) ((charAt2 & '?') | 128);
                } else if (i12 <= i10 - 4) {
                    int i16 = i11 + 1;
                    if (i16 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i16);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i17 = i12 + 1;
                            bArr[i12] = (byte) ((codePoint >>> 18) | 240);
                            int i18 = i17 + 1;
                            bArr[i17] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i19 = i18 + 1;
                            bArr[i18] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i12 = i19 + 1;
                            bArr[i19] = (byte) ((codePoint & 63) | 128);
                            i11 = i16;
                            i11++;
                        } else {
                            i11 = i16;
                        }
                    }
                    throw new d(i11 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i7 = i11 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i7)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i12);
                } else {
                    throw new d(i11, length);
                }
                i12 = i8;
                i11++;
            }
            return i12;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007f, code lost:
            if (r8[r9] > -65) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int i(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0082
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001c
                r7 = -62
                if (r0 < r7) goto L_0x001b
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                r9 = r7
                goto L_0x0082
            L_0x001b:
                return r2
            L_0x001c:
                r4 = -16
                if (r0 >= r4) goto L_0x0049
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0034
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x0031
                int r7 = com.google.protobuf.u1.n(r0, r9)
                return r7
            L_0x0031:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0034:
                if (r7 > r3) goto L_0x0048
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r7 < r4) goto L_0x0048
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r7 >= r4) goto L_0x0048
            L_0x0042:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0048:
                return r2
            L_0x0049:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x005d
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005b
                int r7 = com.google.protobuf.u1.n(r0, r1)
                return r7
            L_0x005b:
                r9 = r7
                goto L_0x0060
            L_0x005d:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L_0x0060:
                if (r4 != 0) goto L_0x006e
                int r7 = r9 + 1
                byte r4 = r8[r9]
                if (r7 < r10) goto L_0x006d
                int r7 = com.google.protobuf.u1.o(r0, r1, r4)
                return r7
            L_0x006d:
                r9 = r7
            L_0x006e:
                if (r1 > r3) goto L_0x0081
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x0081
                if (r4 > r3) goto L_0x0081
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0081:
                return r2
            L_0x0082:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.u1.c.i(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int l(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            return k(i5, byteBuffer, i6, i7);
        }
    }

    static class d extends IllegalArgumentException {
        d(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    static final class e extends b {
        e() {
        }

        static boolean m() {
            return t1.I() && t1.J();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int n(long r8, int r10) {
            /*
                int r0 = p(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L_0x0007:
                r0 = 0
                r1 = r0
            L_0x0009:
                r2 = 1
                if (r10 <= 0) goto L_0x001a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.t1.w(r8)
                if (r1 < 0) goto L_0x0019
                int r10 = r10 + -1
                r8 = r4
                goto L_0x0009
            L_0x0019:
                r8 = r4
            L_0x001a:
                if (r10 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r10 = r10 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r10 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r10 = r10 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.t1.w(r8)
                if (r8 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r8 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r10 >= r6) goto L_0x0046
                int r8 = r(r8, r1, r10)
                return r8
            L_0x0046:
                int r10 = r10 + -2
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.t1.w(r8)
                if (r8 > r4) goto L_0x0063
                r9 = -96
                if (r1 != r0) goto L_0x0056
                if (r8 < r9) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r8 >= r9) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.t1.w(r6)
                if (r8 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r10 >= r0) goto L_0x006c
                int r8 = r(r8, r1, r10)
                return r8
            L_0x006c:
                int r10 = r10 + -3
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.t1.w(r8)
                if (r8 > r4) goto L_0x008e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L_0x008e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.t1.w(r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.t1.w(r8)
                if (r8 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.u1.e.n(long, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int o(byte[] r8, long r9, int r11) {
            /*
                int r0 = q(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L_0x0007:
                r0 = 0
                r1 = r0
            L_0x0009:
                r2 = 1
                if (r11 <= 0) goto L_0x001a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.t1.x(r8, r9)
                if (r1 < 0) goto L_0x0019
                int r11 = r11 + -1
                r9 = r4
                goto L_0x0009
            L_0x0019:
                r9 = r4
            L_0x001a:
                if (r11 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r11 = r11 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r11 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r11 = r11 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.t1.x(r8, r9)
                if (r9 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r9 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r11 >= r6) goto L_0x0046
                int r8 = s(r8, r1, r9, r11)
                return r8
            L_0x0046:
                int r11 = r11 + -2
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.t1.x(r8, r9)
                if (r9 > r4) goto L_0x0063
                r10 = -96
                if (r1 != r0) goto L_0x0056
                if (r9 < r10) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r9 >= r10) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.t1.x(r8, r6)
                if (r9 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r11 >= r0) goto L_0x006c
                int r8 = s(r8, r1, r9, r11)
                return r8
            L_0x006c:
                int r11 = r11 + -3
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.t1.x(r8, r9)
                if (r9 > r4) goto L_0x008e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L_0x008e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.t1.x(r8, r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.t1.x(r8, r9)
                if (r9 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.u1.e.o(byte[], long, int):int");
        }

        private static int p(long j5, int i5) {
            if (i5 < 16) {
                return 0;
            }
            int i6 = 8 - (((int) j5) & 7);
            int i7 = i6;
            while (i7 > 0) {
                long j6 = 1 + j5;
                if (t1.w(j5) < 0) {
                    return i6 - i7;
                }
                i7--;
                j5 = j6;
            }
            int i8 = i5 - i6;
            while (i8 >= 8 && (t1.D(j5) & -9187201950435737472L) == 0) {
                j5 += 8;
                i8 -= 8;
            }
            return i5 - i8;
        }

        private static int q(byte[] bArr, long j5, int i5) {
            int i6 = 0;
            if (i5 < 16) {
                return 0;
            }
            while (i6 < i5) {
                long j6 = 1 + j5;
                if (t1.x(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j6;
            }
            return i5;
        }

        private static int r(long j5, int i5, int i6) {
            if (i6 == 0) {
                return u1.m(i5);
            }
            if (i6 == 1) {
                return u1.n(i5, t1.w(j5));
            }
            if (i6 == 2) {
                return u1.o(i5, t1.w(j5), t1.w(j5 + 1));
            }
            throw new AssertionError();
        }

        private static int s(byte[] bArr, int i5, long j5, int i6) {
            if (i6 == 0) {
                return u1.m(i5);
            }
            if (i6 == 1) {
                return u1.n(i5, t1.x(bArr, j5));
            }
            if (i6 == 2) {
                return u1.o(i5, t1.x(bArr, j5), t1.x(bArr, j5 + 1));
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public String b(byte[] bArr, int i5, int i6) {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) >= 0) {
                int i7 = i5 + i6;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (r13 < i7) {
                    byte x4 = t1.x(bArr, (long) r13);
                    if (!a.n(x4)) {
                        break;
                    }
                    i5 = r13 + 1;
                    a.i(x4, cArr, i8);
                    i8++;
                }
                int i9 = i8;
                while (r13 < i7) {
                    int i10 = r13 + 1;
                    byte x5 = t1.x(bArr, (long) r13);
                    if (a.n(x5)) {
                        int i11 = i9 + 1;
                        a.i(x5, cArr, i9);
                        while (i10 < i7) {
                            byte x6 = t1.x(bArr, (long) i10);
                            if (!a.n(x6)) {
                                break;
                            }
                            i10++;
                            a.i(x6, cArr, i11);
                            i11++;
                        }
                        r13 = i10;
                        i9 = i11;
                    } else if (a.p(x5)) {
                        if (i10 < i7) {
                            a.k(x5, t1.x(bArr, (long) i10), cArr, i9);
                            r13 = i10 + 1;
                            i9++;
                        } else {
                            throw c0.d();
                        }
                    } else if (a.o(x5)) {
                        if (i10 < i7 - 1) {
                            int i12 = i10 + 1;
                            a.j(x5, t1.x(bArr, (long) i10), t1.x(bArr, (long) i12), cArr, i9);
                            r13 = i12 + 1;
                            i9++;
                        } else {
                            throw c0.d();
                        }
                    } else if (i10 < i7 - 2) {
                        int i13 = i10 + 1;
                        byte x7 = t1.x(bArr, (long) i10);
                        int i14 = i13 + 1;
                        a.h(x5, x7, t1.x(bArr, (long) i13), t1.x(bArr, (long) i14), cArr, i9);
                        r13 = i14 + 1;
                        i9 = i9 + 1 + 1;
                    } else {
                        throw c0.d();
                    }
                }
                return new String(cArr, 0, i9);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
        }

        /* access modifiers changed from: package-private */
        public String d(ByteBuffer byteBuffer, int i5, int i6) {
            long j5;
            int i7 = i5;
            int i8 = i6;
            if ((i7 | i8 | ((byteBuffer.limit() - i7) - i8)) >= 0) {
                long k5 = t1.k(byteBuffer) + ((long) i7);
                long j6 = ((long) i8) + k5;
                char[] cArr = new char[i8];
                int i9 = 0;
                while (k5 < j6) {
                    byte w4 = t1.w(k5);
                    if (!a.n(w4)) {
                        break;
                    }
                    k5++;
                    a.i(w4, cArr, i9);
                    i9++;
                }
                while (true) {
                    int i10 = i9;
                    while (j5 < j6) {
                        long j7 = j5 + 1;
                        byte w5 = t1.w(j5);
                        if (a.n(w5)) {
                            int i11 = i10 + 1;
                            a.i(w5, cArr, i10);
                            while (j7 < j6) {
                                byte w6 = t1.w(j7);
                                if (!a.n(w6)) {
                                    break;
                                }
                                j7++;
                                a.i(w6, cArr, i11);
                                i11++;
                            }
                            i10 = i11;
                            j5 = j7;
                        } else if (a.p(w5)) {
                            if (j7 < j6) {
                                j5 = j7 + 1;
                                a.k(w5, t1.w(j7), cArr, i10);
                                i10++;
                            } else {
                                throw c0.d();
                            }
                        } else if (a.o(w5)) {
                            if (j7 < j6 - 1) {
                                long j8 = j7 + 1;
                                a.j(w5, t1.w(j7), t1.w(j8), cArr, i10);
                                i10++;
                                j5 = j8 + 1;
                            } else {
                                throw c0.d();
                            }
                        } else if (j7 < j6 - 2) {
                            long j9 = j7 + 1;
                            byte w7 = t1.w(j7);
                            long j10 = j9 + 1;
                            byte w8 = t1.w(j9);
                            k5 = j10 + 1;
                            a.h(w5, w7, w8, t1.w(j10), cArr, i10);
                            i9 = i10 + 1 + 1;
                        } else {
                            throw c0.d();
                        }
                    }
                    return new String(cArr, 0, i10);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)}));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(java.lang.CharSequence r22, byte[] r23, int r24, int r25) {
            /*
                r21 = this;
                r0 = r22
                r1 = r23
                r2 = r24
                r3 = r25
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r22.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0144
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0144
                r2 = 0
            L_0x001a:
                r3 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                com.google.protobuf.t1.O(r1, r4, r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x0142
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004a
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004a
                long r14 = r4 + r11
                byte r13 = (byte) r13
                com.google.protobuf.t1.O(r1, r4, r13)
                r4 = r11
                r12 = r14
                r11 = r3
                goto L_0x00fc
            L_0x004a:
                r14 = 2048(0x800, float:2.87E-42)
                if (r13 >= r14) goto L_0x0074
                r14 = 2
                long r14 = r6 - r14
                int r14 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r14 > 0) goto L_0x0074
                long r14 = r4 + r11
                int r3 = r13 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                com.google.protobuf.t1.O(r1, r4, r3)
                long r3 = r14 + r11
                r5 = r13 & 63
                r13 = 128(0x80, float:1.794E-43)
                r5 = r5 | r13
                byte r5 = (byte) r5
                com.google.protobuf.t1.O(r1, r14, r5)
                r19 = r11
                r11 = 128(0x80, float:1.794E-43)
                r12 = r3
                r4 = r19
                goto L_0x00fc
            L_0x0074:
                r3 = 57343(0xdfff, float:8.0355E-41)
                r14 = 55296(0xd800, float:7.7486E-41)
                if (r13 < r14) goto L_0x007e
                if (r3 >= r13) goto L_0x00af
            L_0x007e:
                r15 = 3
                long r15 = r6 - r15
                int r15 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
                if (r15 > 0) goto L_0x00af
                long r14 = r4 + r11
                int r3 = r13 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                com.google.protobuf.t1.O(r1, r4, r3)
                long r3 = r14 + r11
                int r5 = r13 >>> 6
                r5 = r5 & 63
                r11 = 128(0x80, float:1.794E-43)
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.t1.O(r1, r14, r5)
                r14 = 1
                long r17 = r3 + r14
                r5 = r13 & 63
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.t1.O(r1, r3, r5)
                r12 = r17
                r4 = 1
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x00fc
            L_0x00af:
                r11 = 4
                long r11 = r6 - r11
                int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r11 > 0) goto L_0x010f
                int r3 = r2 + 1
                if (r3 == r8) goto L_0x0107
                char r2 = r0.charAt(r3)
                boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r11 == 0) goto L_0x0106
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r11 = 1
                long r13 = r4 + r11
                int r15 = r2 >>> 18
                r15 = r15 | 240(0xf0, float:3.36E-43)
                byte r15 = (byte) r15
                com.google.protobuf.t1.O(r1, r4, r15)
                long r4 = r13 + r11
                int r15 = r2 >>> 12
                r15 = r15 & 63
                r11 = 128(0x80, float:1.794E-43)
                r12 = r15 | 128(0x80, float:1.794E-43)
                byte r12 = (byte) r12
                com.google.protobuf.t1.O(r1, r13, r12)
                r12 = 1
                long r14 = r4 + r12
                int r16 = r2 >>> 6
                r12 = r16 & 63
                r12 = r12 | r11
                byte r12 = (byte) r12
                com.google.protobuf.t1.O(r1, r4, r12)
                r4 = 1
                long r12 = r14 + r4
                r2 = r2 & 63
                r2 = r2 | r11
                byte r2 = (byte) r2
                com.google.protobuf.t1.O(r1, r14, r2)
                r2 = r3
            L_0x00fc:
                int r2 = r2 + 1
                r3 = r11
                r19 = r4
                r4 = r12
                r11 = r19
                goto L_0x0033
            L_0x0106:
                r2 = r3
            L_0x0107:
                com.google.protobuf.u1$d r0 = new com.google.protobuf.u1$d
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010f:
                if (r14 > r13) goto L_0x0127
                if (r13 > r3) goto L_0x0127
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0121
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0127
            L_0x0121:
                com.google.protobuf.u1$d r0 = new com.google.protobuf.u1$d
                r0.<init>(r2, r8)
                throw r0
            L_0x0127:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0142:
                int r0 = (int) r4
                return r0
            L_0x0144:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.u1.e.e(java.lang.CharSequence, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (com.google.protobuf.t1.x(r13, r2) > -65) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
            if (com.google.protobuf.t1.x(r13, r2) > -65) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int i(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00a8
                long r2 = (long) r14
                long r14 = (long) r15
                if (r12 == 0) goto L_0x00a1
                int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
                if (r0 < 0) goto L_0x0011
                return r12
            L_0x0011:
                byte r0 = (byte) r12
                r4 = -32
                r5 = -1
                r6 = -65
                r7 = 1
                if (r0 >= r4) goto L_0x002b
                r12 = -62
                if (r0 < r12) goto L_0x002a
                long r7 = r7 + r2
                byte r12 = com.google.protobuf.t1.x(r13, r2)
                if (r12 <= r6) goto L_0x0027
                goto L_0x002a
            L_0x0027:
                r2 = r7
                goto L_0x00a1
            L_0x002a:
                return r5
            L_0x002b:
                r9 = -16
                if (r0 >= r9) goto L_0x005f
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0045
                long r9 = r2 + r7
                byte r12 = com.google.protobuf.t1.x(r13, r2)
                int r1 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r1 < 0) goto L_0x0044
                int r12 = com.google.protobuf.u1.n(r0, r12)
                return r12
            L_0x0044:
                r2 = r9
            L_0x0045:
                if (r12 > r6) goto L_0x005e
                r1 = -96
                if (r0 != r4) goto L_0x004d
                if (r12 < r1) goto L_0x005e
            L_0x004d:
                r4 = -19
                if (r0 != r4) goto L_0x0053
                if (r12 >= r1) goto L_0x005e
            L_0x0053:
                long r0 = r2 + r7
                byte r12 = com.google.protobuf.t1.x(r13, r2)
                if (r12 <= r6) goto L_0x005c
                goto L_0x005e
            L_0x005c:
                r2 = r0
                goto L_0x00a1
            L_0x005e:
                return r5
            L_0x005f:
                int r4 = r12 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0076
                long r9 = r2 + r7
                byte r4 = com.google.protobuf.t1.x(r13, r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x0074
                int r12 = com.google.protobuf.u1.n(r0, r4)
                return r12
            L_0x0074:
                r2 = r9
                goto L_0x0079
            L_0x0076:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x0079:
                if (r1 != 0) goto L_0x008b
                long r9 = r2 + r7
                byte r1 = com.google.protobuf.t1.x(r13, r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x008a
                int r12 = com.google.protobuf.u1.o(r0, r4, r1)
                return r12
            L_0x008a:
                r2 = r9
            L_0x008b:
                if (r4 > r6) goto L_0x00a0
                int r12 = r0 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00a0
                if (r1 > r6) goto L_0x00a0
                long r0 = r2 + r7
                byte r12 = com.google.protobuf.t1.x(r13, r2)
                if (r12 <= r6) goto L_0x005c
            L_0x00a0:
                return r5
            L_0x00a1:
                long r14 = r14 - r2
                int r12 = (int) r14
                int r12 = o(r13, r2, r12)
                return r12
            L_0x00a8:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r1] = r13
                r13 = 1
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0[r13] = r14
                r13 = 2
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                r0[r13] = r14
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.u1.e.i(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (com.google.protobuf.t1.w(r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (com.google.protobuf.t1.w(r2) > -65) goto L_0x00aa;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int l(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.limit()
                int r1 = r1 - r14
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00b2
                long r2 = com.google.protobuf.t1.k(r12)
                long r4 = (long) r13
                long r2 = r2 + r4
                int r14 = r14 - r13
                long r12 = (long) r14
                long r12 = r12 + r2
                if (r11 == 0) goto L_0x00ab
                int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r11
            L_0x001b:
                byte r14 = (byte) r11
                r0 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r14 >= r0) goto L_0x0035
                r11 = -62
                if (r14 < r11) goto L_0x0034
                long r6 = r6 + r2
                byte r11 = com.google.protobuf.t1.w(r2)
                if (r11 <= r5) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                r2 = r6
                goto L_0x00ab
            L_0x0034:
                return r4
            L_0x0035:
                r8 = -16
                if (r14 >= r8) goto L_0x0069
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L_0x004f
                long r8 = r2 + r6
                byte r11 = com.google.protobuf.t1.w(r2)
                int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r1 < 0) goto L_0x004e
                int r11 = com.google.protobuf.u1.n(r14, r11)
                return r11
            L_0x004e:
                r2 = r8
            L_0x004f:
                if (r11 > r5) goto L_0x0068
                r1 = -96
                if (r14 != r0) goto L_0x0057
                if (r11 < r1) goto L_0x0068
            L_0x0057:
                r0 = -19
                if (r14 != r0) goto L_0x005d
                if (r11 >= r1) goto L_0x0068
            L_0x005d:
                long r0 = r2 + r6
                byte r11 = com.google.protobuf.t1.w(r2)
                if (r11 <= r5) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r2 = r0
                goto L_0x00ab
            L_0x0068:
                return r4
            L_0x0069:
                int r0 = r11 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x0080
                long r8 = r2 + r6
                byte r0 = com.google.protobuf.t1.w(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x007e
                int r11 = com.google.protobuf.u1.n(r14, r0)
                return r11
            L_0x007e:
                r2 = r8
                goto L_0x0083
            L_0x0080:
                int r11 = r11 >> 16
                byte r1 = (byte) r11
            L_0x0083:
                if (r1 != 0) goto L_0x0095
                long r8 = r2 + r6
                byte r1 = com.google.protobuf.t1.w(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x0094
                int r11 = com.google.protobuf.u1.o(r14, r0, r1)
                return r11
            L_0x0094:
                r2 = r8
            L_0x0095:
                if (r0 > r5) goto L_0x00aa
                int r11 = r14 << 28
                int r0 = r0 + 112
                int r11 = r11 + r0
                int r11 = r11 >> 30
                if (r11 != 0) goto L_0x00aa
                if (r1 > r5) goto L_0x00aa
                long r0 = r2 + r6
                byte r11 = com.google.protobuf.t1.w(r2)
                if (r11 <= r5) goto L_0x0066
            L_0x00aa:
                return r4
            L_0x00ab:
                long r12 = r12 - r2
                int r11 = (int) r12
                int r11 = n(r2, r11)
                return r11
            L_0x00b2:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r12 = r12.limit()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                r0[r1] = r12
                r12 = 1
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r12] = r13
                r12 = 2
                java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
                r0[r12] = r13
                java.lang.String r12 = "buffer limit=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r12, r0)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.u1.e.l(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static String g(ByteBuffer byteBuffer, int i5, int i6) {
        return f3692a.a(byteBuffer, i5, i6);
    }

    static String h(byte[] bArr, int i5, int i6) {
        return f3692a.b(bArr, i5, i6);
    }

    static int i(CharSequence charSequence, byte[] bArr, int i5, int i6) {
        return f3692a.e(charSequence, bArr, i5, i6);
    }

    static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 < length) {
                char charAt = charSequence.charAt(i5);
                if (charAt >= 2048) {
                    i6 += k(charSequence, i5);
                    break;
                }
                i6 += (127 - charAt) >>> 31;
                i5++;
            } else {
                break;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i6) + 4294967296L));
    }

    private static int k(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i5) >= 65536) {
                        i5++;
                    } else {
                        throw new d(i5, length);
                    }
                }
            }
            i5++;
        }
        return i6;
    }

    /* access modifiers changed from: private */
    public static int l(ByteBuffer byteBuffer, int i5, int i6) {
        int i7 = i6 - 7;
        int i8 = i5;
        while (i8 < i7 && (byteBuffer.getLong(i8) & -9187201950435737472L) == 0) {
            i8 += 8;
        }
        return i8 - i5;
    }

    /* access modifiers changed from: private */
    public static int m(int i5) {
        if (i5 > -12) {
            return -1;
        }
        return i5;
    }

    /* access modifiers changed from: private */
    public static int n(int i5, int i6) {
        if (i5 > -12 || i6 > -65) {
            return -1;
        }
        return i5 ^ (i6 << 8);
    }

    /* access modifiers changed from: private */
    public static int o(int i5, int i6, int i7) {
        if (i5 > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i5 ^ (i6 << 8)) ^ (i7 << 16);
    }

    /* access modifiers changed from: private */
    public static int p(ByteBuffer byteBuffer, int i5, int i6, int i7) {
        if (i7 == 0) {
            return m(i5);
        }
        if (i7 == 1) {
            return n(i5, byteBuffer.get(i6));
        }
        if (i7 == 2) {
            return o(i5, byteBuffer.get(i6), byteBuffer.get(i6 + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static int q(byte[] bArr, int i5, int i6) {
        byte b5 = bArr[i5 - 1];
        int i7 = i6 - i5;
        if (i7 == 0) {
            return m(b5);
        }
        if (i7 == 1) {
            return n(b5, bArr[i5]);
        }
        if (i7 == 2) {
            return o(b5, bArr[i5], bArr[i5 + 1]);
        }
        throw new AssertionError();
    }

    static boolean r(ByteBuffer byteBuffer) {
        return f3692a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean s(byte[] bArr) {
        return f3692a.g(bArr, 0, bArr.length);
    }

    public static boolean t(byte[] bArr, int i5, int i6) {
        return f3692a.g(bArr, i5, i6);
    }
}
