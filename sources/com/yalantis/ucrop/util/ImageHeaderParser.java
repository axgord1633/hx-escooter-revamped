package com.yalantis.ucrop.util;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;

    private static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i5) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i5);
        }

        public short getInt16(int i5) {
            return this.data.getShort(i5);
        }

        public int getInt32(int i5) {
            return this.data.getInt(i5);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    private interface Reader {
        int getUInt16();

        short getUInt8();

        int read(byte[] bArr, int i5);

        long skip(long j5);
    }

    private static class StreamReader implements Reader {
        private final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        public int getUInt16() {
            return ((this.is.read() << 8) & 65280) | (this.is.read() & ImageHeaderParser.SEGMENT_START_ID);
        }

        public short getUInt8() {
            return (short) (this.is.read() & ImageHeaderParser.SEGMENT_START_ID);
        }

        public int read(byte[] bArr, int i5) {
            int i6 = i5;
            while (i6 > 0) {
                int read = this.is.read(bArr, i5 - i6, i6);
                if (read == -1) {
                    break;
                }
                i6 -= read;
            }
            return i5 - i6;
        }

        public long skip(long j5) {
            if (j5 < 0) {
                return 0;
            }
            long j6 = j5;
            while (j6 > 0) {
                long skip = this.is.skip(j6);
                if (skip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j6 -= skip;
            }
            return j5 - j6;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new StreamReader(inputStream);
    }

    private static int calcTagOffset(int i5, int i6) {
        return i5 + 2 + (i6 * 12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0056 A[SYNTHETIC, Splitter:B:27:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC, Splitter:B:32:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074 A[SYNTHETIC, Splitter:B:38:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[SYNTHETIC, Splitter:B:43:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyExif(android.content.Context r4, int r5, int r6, android.net.Uri r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = "ImageHeaderParser"
            if (r4 != 0) goto L_0x000a
            java.lang.String r4 = "context is null"
            android.util.Log.d(r0, r4)
            return
        L_0x000a:
            r1 = 0
            android.content.ContentResolver r2 = r4.getContentResolver()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.io.InputStream r7 = r2.openInputStream(r7)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            androidx.exifinterface.media.a r2 = new androidx.exifinterface.media.a     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r2.<init>((java.io.InputStream) r7)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            java.lang.String r3 = "rw"
            android.os.ParcelFileDescriptor r1 = r4.openFileDescriptor(r8, r3)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            androidx.exifinterface.media.a r4 = new androidx.exifinterface.media.a     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            java.io.FileDescriptor r8 = r1.getFileDescriptor()     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r4.<init>((java.io.FileDescriptor) r8)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            copyExifAttributes(r2, r4, r5, r6)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            if (r7 == 0) goto L_0x003c
            r7.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x003c
        L_0x0034:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            android.util.Log.d(r0, r5, r4)
        L_0x003c:
            r1.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0070
        L_0x0040:
            r4 = move-exception
            r5 = r1
            r1 = r7
            goto L_0x0072
        L_0x0044:
            r4 = move-exception
            r5 = r1
            r1 = r7
            goto L_0x004d
        L_0x0048:
            r4 = move-exception
            r5 = r1
            goto L_0x0072
        L_0x004b:
            r4 = move-exception
            r5 = r1
        L_0x004d:
            java.lang.String r6 = r4.getMessage()     // Catch:{ all -> 0x0071 }
            android.util.Log.d(r0, r6, r4)     // Catch:{ all -> 0x0071 }
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r4 = move-exception
            java.lang.String r6 = r4.getMessage()
            android.util.Log.d(r0, r6, r4)
        L_0x0062:
            if (r5 == 0) goto L_0x0070
            r5.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            android.util.Log.d(r0, r5, r4)
        L_0x0070:
            return
        L_0x0071:
            r4 = move-exception
        L_0x0072:
            if (r1 == 0) goto L_0x0080
            r1.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            android.util.Log.d(r0, r7, r6)
        L_0x0080:
            if (r5 == 0) goto L_0x008e
            r5.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008e
        L_0x0086:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            android.util.Log.d(r0, r6, r5)
        L_0x008e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.copyExif(android.content.Context, int, int, android.net.Uri, android.net.Uri):void");
    }

    public static void copyExif(Context context, int i5, int i6, Uri uri, String str) {
        if (context == null) {
            Log.d(TAG, "context is null");
            return;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            copyExifAttributes(new a(inputStream), new a(str), i5, i6);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.d(TAG, e5.getMessage(), e5);
                }
            }
        } catch (IOException e6) {
            Log.d(TAG, e6.getMessage(), e6);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    Log.d(TAG, e7.getMessage(), e7);
                }
            }
            throw th;
        }
    }

    public static void copyExif(Context context, a aVar, int i5, int i6, Uri uri) {
        if (context == null) {
            Log.d(TAG, "context is null");
            return;
        }
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
            copyExifAttributes(aVar, new a(parcelFileDescriptor.getFileDescriptor()), i5, i6);
            try {
                parcelFileDescriptor.close();
            } catch (IOException e5) {
                Log.d(TAG, e5.getMessage(), e5);
            }
        } catch (IOException e6) {
            Log.d(TAG, e6.getMessage());
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (Throwable th) {
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e7) {
                    Log.d(TAG, e7.getMessage(), e7);
                }
            }
            throw th;
        }
    }

    public static void copyExif(a aVar, int i5, int i6, String str) {
        try {
            copyExifAttributes(aVar, new a(str), i5, i6);
        } catch (IOException e5) {
            Log.d(TAG, e5.getMessage());
        }
    }

    private static void copyExifAttributes(a aVar, a aVar2, int i5, int i6) {
        a aVar3 = aVar2;
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        for (int i7 = 0; i7 < 22; i7++) {
            String str = strArr[i7];
            String d5 = aVar.d(str);
            if (!TextUtils.isEmpty(d5)) {
                aVar3.U(str, d5);
            }
        }
        aVar3.U("ImageWidth", String.valueOf(i5));
        aVar3.U("ImageLength", String.valueOf(i6));
        aVar3.U("Orientation", "0");
        aVar2.Q();
    }

    private static boolean handles(int i5) {
        return (i5 & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i5 == MOTOROLA_TIFF_MAGIC_NUMBER || i5 == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i5) {
        boolean z4 = bArr != null && i5 > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z4) {
            int i6 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i6 >= bArr2.length) {
                    break;
                } else if (bArr[i6] != bArr2[i6]) {
                    return false;
                } else {
                    i6++;
                }
            }
        }
        return z4;
    }

    private int moveToExifSegmentAndGetLength() {
        short uInt8;
        int uInt16;
        long j5;
        long skip;
        do {
            short uInt82 = this.reader.getUInt8();
            if (uInt82 != SEGMENT_START_ID) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + uInt82);
                }
                return -1;
            }
            uInt8 = this.reader.getUInt8();
            if (uInt8 == SEGMENT_SOS) {
                return -1;
            }
            if (uInt8 == MARKER_EOI) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = this.reader.getUInt16() - 2;
            if (uInt8 == EXIF_SEGMENT_TYPE) {
                return uInt16;
            }
            j5 = (long) uInt16;
            skip = this.reader.skip(j5);
        } while (skip == j5);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + uInt8 + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int parseExifSegment(com.yalantis.ucrop.util.ImageHeaderParser.RandomAccessReader r12) {
        /*
            r0 = 6
            short r1 = r12.getInt16(r0)
            r2 = 3
            java.lang.String r3 = "ImageHeaderParser"
            r4 = 19789(0x4d4d, float:2.773E-41)
            if (r1 != r4) goto L_0x000f
        L_0x000c:
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            goto L_0x0031
        L_0x000f:
            r4 = 18761(0x4949, float:2.629E-41)
            if (r1 != r4) goto L_0x0016
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN
            goto L_0x0031
        L_0x0016:
            boolean r4 = android.util.Log.isLoggable(r3, r2)
            if (r4 == 0) goto L_0x000c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unknown endianness = "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            android.util.Log.d(r3, r1)
            goto L_0x000c
        L_0x0031:
            r12.order(r1)
            r1 = 10
            int r1 = r12.getInt32(r1)
            int r1 = r1 + r0
            short r0 = r12.getInt16(r1)
            r4 = 0
        L_0x0040:
            if (r4 >= r0) goto L_0x0123
            int r5 = calcTagOffset(r1, r4)
            short r6 = r12.getInt16(r5)
            r7 = 274(0x112, float:3.84E-43)
            if (r6 == r7) goto L_0x0050
            goto L_0x011f
        L_0x0050:
            int r7 = r5 + 2
            short r7 = r12.getInt16(r7)
            r8 = 1
            if (r7 < r8) goto L_0x0105
            r8 = 12
            if (r7 <= r8) goto L_0x005f
            goto L_0x0105
        L_0x005f:
            int r8 = r5 + 4
            int r8 = r12.getInt32(r8)
            if (r8 >= 0) goto L_0x0071
            boolean r5 = android.util.Log.isLoggable(r3, r2)
            if (r5 == 0) goto L_0x011f
            java.lang.String r5 = "Negative tiff component count"
            goto L_0x011c
        L_0x0071:
            boolean r9 = android.util.Log.isLoggable(r3, r2)
            java.lang.String r10 = " tagType="
            if (r9 == 0) goto L_0x00a3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "Got tagIndex="
            r9.append(r11)
            r9.append(r4)
            r9.append(r10)
            r9.append(r6)
            java.lang.String r11 = " formatCode="
            r9.append(r11)
            r9.append(r7)
            java.lang.String r11 = " componentCount="
            r9.append(r11)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r3, r9)
        L_0x00a3:
            int[] r9 = BYTES_PER_FORMAT
            r9 = r9[r7]
            int r8 = r8 + r9
            r9 = 4
            if (r8 <= r9) goto L_0x00b9
            boolean r5 = android.util.Log.isLoggable(r3, r2)
            if (r5 == 0) goto L_0x011f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Got byte count > 4, not orientation, continuing, formatCode="
            goto L_0x0112
        L_0x00b9:
            int r5 = r5 + 8
            if (r5 < 0) goto L_0x00e7
            int r7 = r12.length()
            if (r5 <= r7) goto L_0x00c4
            goto L_0x00e7
        L_0x00c4:
            if (r8 < 0) goto L_0x00d3
            int r8 = r8 + r5
            int r7 = r12.length()
            if (r8 <= r7) goto L_0x00ce
            goto L_0x00d3
        L_0x00ce:
            short r12 = r12.getInt16(r5)
            return r12
        L_0x00d3:
            boolean r5 = android.util.Log.isLoggable(r3, r2)
            if (r5 == 0) goto L_0x011f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Illegal number of bytes for TI tag data tagType="
            r5.append(r7)
            r5.append(r6)
            goto L_0x0118
        L_0x00e7:
            boolean r7 = android.util.Log.isLoggable(r3, r2)
            if (r7 == 0) goto L_0x011f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Illegal tagValueOffset="
            r7.append(r8)
            r7.append(r5)
            r7.append(r10)
            r7.append(r6)
            java.lang.String r5 = r7.toString()
            goto L_0x011c
        L_0x0105:
            boolean r5 = android.util.Log.isLoggable(r3, r2)
            if (r5 == 0) goto L_0x011f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Got invalid format code = "
        L_0x0112:
            r5.append(r6)
            r5.append(r7)
        L_0x0118:
            java.lang.String r5 = r5.toString()
        L_0x011c:
            android.util.Log.d(r3, r5)
        L_0x011f:
            int r4 = r4 + 1
            goto L_0x0040
        L_0x0123:
            r12 = -1
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.parseExifSegment(com.yalantis.ucrop.util.ImageHeaderParser$RandomAccessReader):int");
    }

    private int parseExifSegment(byte[] bArr, int i5) {
        int read = this.reader.read(bArr, i5);
        if (read != i5) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i5 + ", actually read: " + read);
            }
            return -1;
        } else if (hasJpegExifPreamble(bArr, i5)) {
            return parseExifSegment(new RandomAccessReader(bArr, i5));
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public int getOrientation() {
        int uInt16 = this.reader.getUInt16();
        if (!handles(uInt16)) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Parser doesn't handle magic number: " + uInt16);
            }
            return -1;
        }
        int moveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength();
        if (moveToExifSegmentAndGetLength != -1) {
            return parseExifSegment(new byte[moveToExifSegmentAndGetLength], moveToExifSegmentAndGetLength);
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
        }
        return -1;
    }
}
