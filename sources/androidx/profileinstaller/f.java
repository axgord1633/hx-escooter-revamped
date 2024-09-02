package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

class f {
    static int a(int i5) {
        return (((i5 + 8) - 1) & -8) / 8;
    }

    static byte[] b(byte[] bArr) {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
        throw th;
    }

    static RuntimeException c(String str) {
        return new IllegalStateException(str);
    }

    static byte[] d(InputStream inputStream, int i5) {
        byte[] bArr = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            int read = inputStream.read(bArr, i6, i5 - i6);
            if (read >= 0) {
                i6 += read;
            } else {
                throw c("Not enough bytes to read: " + i5);
            }
        }
        return bArr;
    }

    static byte[] e(InputStream inputStream, int i5, int i6) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i6];
            byte[] bArr2 = new byte[2048];
            int i7 = 0;
            int i8 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i7 < i5) {
                int read = inputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i8 += inflater.inflate(bArr, i8, i6 - i8);
                    i7 += read;
                } else {
                    throw c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i5 + " bytes");
                }
            }
            if (i7 != i5) {
                throw c("Didn't read enough bytes during decompression. expected=" + i5 + " actual=" + i7);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw c("Inflater did not finish");
            }
        } catch (DataFormatException e5) {
            throw c(e5.getMessage());
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    static String f(InputStream inputStream, int i5) {
        return new String(d(inputStream, i5), StandardCharsets.UTF_8);
    }

    static long g(InputStream inputStream, int i5) {
        byte[] d5 = d(inputStream, i5);
        long j5 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            j5 += ((long) (d5[i6] & 255)) << (i6 * 8);
        }
        return j5;
    }

    static int h(InputStream inputStream) {
        return (int) g(inputStream, 2);
    }

    static long i(InputStream inputStream) {
        return g(inputStream, 4);
    }

    static int j(InputStream inputStream) {
        return (int) g(inputStream, 1);
    }

    static int k(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    static void l(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static void m(OutputStream outputStream, byte[] bArr) {
        q(outputStream, (long) bArr.length);
        byte[] b5 = b(bArr);
        q(outputStream, (long) b5.length);
        outputStream.write(b5);
    }

    static void n(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    static void o(OutputStream outputStream, long j5, int i5) {
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = (byte) ((int) ((j5 >> (i6 * 8)) & 255));
        }
        outputStream.write(bArr);
    }

    static void p(OutputStream outputStream, int i5) {
        o(outputStream, (long) i5, 2);
    }

    static void q(OutputStream outputStream, long j5) {
        o(outputStream, j5, 4);
    }

    static void r(OutputStream outputStream, int i5) {
        o(outputStream, (long) i5, 1);
    }
}
