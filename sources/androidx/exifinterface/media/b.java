package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.util.Log;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class b {

    static class a {
        static void a(FileDescriptor fileDescriptor) {
            Os.close(fileDescriptor);
        }

        static FileDescriptor b(FileDescriptor fileDescriptor) {
            return Os.dup(fileDescriptor);
        }

        static long c(FileDescriptor fileDescriptor, long j5, int i5) {
            return Os.lseek(fileDescriptor, j5, i5);
        }
    }

    /* renamed from: androidx.exifinterface.media.b$b  reason: collision with other inner class name */
    static class C0035b {
        static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i5 = 0; i5 < bArr.length; i5++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i5])}));
        }
        return sb.toString();
    }

    static void b(FileDescriptor fileDescriptor) {
        try {
            a.a(fileDescriptor);
        } catch (Exception unused) {
            Log.e("ExifInterfaceUtils", "Error closing fd.");
        }
    }

    static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    static long[] d(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                jArr[i5] = (long) iArr[i5];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    static int e(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i5 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i5;
            }
            i5 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    static void f(InputStream inputStream, OutputStream outputStream, int i5) {
        byte[] bArr = new byte[8192];
        while (i5 > 0) {
            int min = Math.min(i5, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i5 -= read;
                outputStream.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    static boolean g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }
}
