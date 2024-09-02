package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.core.util.e;
import androidx.exifinterface.media.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class ImageResizer {
    private final Context context;
    private final ExifDataCopier exifDataCopier;

    ImageResizer(Context context2, ExifDataCopier exifDataCopier2) {
        this.context = context2;
        this.exifDataCopier = exifDataCopier2;
    }

    private int calculateSampleSize(BitmapFactory.Options options, int i5, int i6) {
        int i7 = options.outHeight;
        int i8 = options.outWidth;
        int i9 = 1;
        if (i7 > i6 || i8 > i5) {
            int i10 = i7 / 2;
            int i11 = i8 / 2;
            while (i10 / i9 >= i6 && i11 / i9 >= i5) {
                i9 *= 2;
            }
        }
        return i9;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
        if (r2 == false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        r5 = java.lang.Double.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        if (r3 == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if (r12.doubleValue() < r11.doubleValue()) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.core.util.e calculateTargetSize(java.lang.Double r11, java.lang.Double r12, java.lang.Double r13, java.lang.Double r14) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r13 == 0) goto L_0x0006
            r2 = r0
            goto L_0x0007
        L_0x0006:
            r2 = r1
        L_0x0007:
            if (r14 == 0) goto L_0x000b
            r3 = r0
            goto L_0x000c
        L_0x000b:
            r3 = r1
        L_0x000c:
            double r4 = r11.doubleValue()
            if (r2 == 0) goto L_0x001a
            double r6 = r13.doubleValue()
            double r4 = java.lang.Math.min(r4, r6)
        L_0x001a:
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            double r5 = r12.doubleValue()
            if (r3 == 0) goto L_0x002c
            double r7 = r14.doubleValue()
            double r5 = java.lang.Math.min(r5, r7)
        L_0x002c:
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            if (r2 == 0) goto L_0x0040
            double r6 = r13.doubleValue()
            double r8 = r11.doubleValue()
            int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x0040
            r13 = r0
            goto L_0x0041
        L_0x0040:
            r13 = r1
        L_0x0041:
            if (r3 == 0) goto L_0x0051
            double r6 = r14.doubleValue()
            double r8 = r12.doubleValue()
            int r14 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r14 >= 0) goto L_0x0051
            r14 = r0
            goto L_0x0052
        L_0x0051:
            r14 = r1
        L_0x0052:
            if (r13 != 0) goto L_0x0058
            if (r14 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r0 = r1
        L_0x0058:
            if (r0 == 0) goto L_0x00b7
            double r13 = r5.doubleValue()
            double r0 = r12.doubleValue()
            double r13 = r13 / r0
            double r0 = r11.doubleValue()
            double r13 = r13 * r0
            double r0 = r4.doubleValue()
            double r6 = r11.doubleValue()
            double r0 = r0 / r6
            double r6 = r12.doubleValue()
            double r0 = r0 * r6
            double r6 = r4.doubleValue()
            double r8 = r5.doubleValue()
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x008e
            if (r2 != 0) goto L_0x0089
        L_0x0084:
            java.lang.Double r4 = java.lang.Double.valueOf(r13)
            goto L_0x00b7
        L_0x0089:
            java.lang.Double r5 = java.lang.Double.valueOf(r0)
            goto L_0x00b7
        L_0x008e:
            double r6 = r5.doubleValue()
            double r8 = r4.doubleValue()
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x009d
            if (r3 != 0) goto L_0x0084
            goto L_0x0089
        L_0x009d:
            double r2 = r11.doubleValue()
            double r6 = r12.doubleValue()
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x00aa
            goto L_0x0084
        L_0x00aa:
            double r12 = r12.doubleValue()
            double r2 = r11.doubleValue()
            int r11 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r11 >= 0) goto L_0x00b7
            goto L_0x0089
        L_0x00b7:
            androidx.core.util.e r11 = new androidx.core.util.e
            float r12 = r4.floatValue()
            float r13 = r5.floatValue()
            r11.<init>(r12, r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImageResizer.calculateTargetSize(java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double):androidx.core.util.e");
    }

    private void copyExif(String str, String str2) {
        try {
            this.exifDataCopier.copyExif(new a(str), new a(str2));
        } catch (Exception e5) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e5);
        }
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i5) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(hasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream);
        File createFile = createFile(this.context.getCacheDir(), str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }

    private FileOutputStream createOutputStream(File file) {
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i5, int i6, boolean z4) {
        return Bitmap.createScaledBitmap(bitmap, i5, i6, z4);
    }

    private Bitmap decodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    private e readFileDimensions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(str, options);
        return new e((float) options.outWidth, (float) options.outHeight);
    }

    private File resizedImage(Bitmap bitmap, Double d5, Double d6, int i5, String str) {
        Bitmap createScaledBitmap = createScaledBitmap(bitmap, d5.intValue(), d6.intValue(), false);
        return createImageOnExternalDirectory("/scaled_" + str, createScaledBitmap, i5);
    }

    /* access modifiers changed from: package-private */
    public String resizeImageIfNeeded(String str, Double d5, Double d6, int i5) {
        e readFileDimensions = readFileDimensions(str);
        if (readFileDimensions.b() == -1.0f || readFileDimensions.a() == -1.0f) {
            return str;
        }
        if (!((d5 == null && d6 == null && i5 >= 100) ? false : true)) {
            return str;
        }
        try {
            String[] split = str.split("/");
            String str2 = split[split.length - 1];
            e calculateTargetSize = calculateTargetSize(Double.valueOf((double) readFileDimensions.b()), Double.valueOf((double) readFileDimensions.a()), d5, d6);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = calculateSampleSize(options, (int) calculateTargetSize.b(), (int) calculateTargetSize.a());
            Bitmap decodeFile = decodeFile(str, options);
            if (decodeFile == null) {
                return str;
            }
            File resizedImage = resizedImage(decodeFile, Double.valueOf((double) calculateTargetSize.b()), Double.valueOf((double) calculateTargetSize.a()), i5, str2);
            copyExif(str, resizedImage.getPath());
            return resizedImage.getPath();
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }
}
