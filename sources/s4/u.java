package s4;

import java.nio.charset.Charset;

final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f6804a = Charset.forName("UTF-8");

    public static boolean a(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (bArr[i8 + i5] != bArr2[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static void b(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)}));
        }
    }

    public static int c(int i5) {
        return ((i5 & 255) << 24) | ((-16777216 & i5) >>> 24) | ((16711680 & i5) >>> 8) | ((65280 & i5) << 8);
    }

    public static short d(short s5) {
        short s6 = s5 & 65535;
        return (short) (((s6 & 255) << 8) | ((65280 & s6) >>> 8));
    }

    public static void e(Throwable th) {
        f(th);
    }

    private static <T extends Throwable> void f(Throwable th) {
        throw th;
    }
}
