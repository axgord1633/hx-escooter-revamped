package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final WeakReference<Context> mContext;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i5, int i6, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = new WeakReference<>(context);
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i5;
        this.mRequiredHeight = i6;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    private boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= MAX_BITMAP_SIZE) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadFile(android.net.Uri r5, android.net.Uri r6) {
        /*
            r4 = this;
            java.lang.String r0 = "BitmapWorkerTask"
            java.lang.String r1 = "downloadFile"
            android.util.Log.d(r0, r1)
            if (r6 == 0) goto L_0x009c
            java.lang.ref.WeakReference<android.content.Context> r0 = r4.mContext
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            if (r0 == 0) goto L_0x0094
            com.yalantis.ucrop.OkHttpClientStore r1 = com.yalantis.ucrop.OkHttpClientStore.INSTANCE
            i4.u r1 = r1.getClient()
            r2 = 0
            i4.x$a r3 = new i4.x$a     // Catch:{ all -> 0x0076 }
            r3.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0076 }
            i4.x$a r5 = r3.g(r5)     // Catch:{ all -> 0x0076 }
            i4.x r5 = r5.a()     // Catch:{ all -> 0x0076 }
            i4.d r5 = r1.r(r5)     // Catch:{ all -> 0x0076 }
            i4.z r5 = r5.e()     // Catch:{ all -> 0x0076 }
            i4.a0 r3 = r5.b()     // Catch:{ all -> 0x0072 }
            s4.e r3 = r3.f()     // Catch:{ all -> 0x0072 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x006d }
            java.io.OutputStream r6 = r0.openOutputStream(r6)     // Catch:{ all -> 0x006d }
            if (r6 == 0) goto L_0x0065
            s4.r r2 = s4.l.d(r6)     // Catch:{ all -> 0x006d }
            r3.o(r2)     // Catch:{ all -> 0x006d }
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r3)
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r2)
            i4.a0 r5 = r5.b()
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r5)
            i4.m r5 = r1.i()
            r5.a()
            android.net.Uri r5 = r4.mOutputUri
            r4.mInputUri = r5
            return
        L_0x0065:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "OutputStream for given output Uri is null"
            r6.<init>(r0)     // Catch:{ all -> 0x006d }
            throw r6     // Catch:{ all -> 0x006d }
        L_0x006d:
            r6 = move-exception
            r0 = r5
            r5 = r2
            r2 = r3
            goto L_0x0079
        L_0x0072:
            r6 = move-exception
            r0 = r5
            r5 = r2
            goto L_0x0079
        L_0x0076:
            r6 = move-exception
            r5 = r2
            r0 = r5
        L_0x0079:
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r2)
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r5)
            if (r0 == 0) goto L_0x0088
            i4.a0 r5 = r0.b()
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r5)
        L_0x0088:
            i4.m r5 = r1.i()
            r5.a()
            android.net.Uri r5 = r4.mOutputUri
            r4.mInputUri = r5
            throw r6
        L_0x0094:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Context is null"
            r5.<init>(r6)
            throw r5
        L_0x009c:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Output Uri is null - cannot download image"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapLoadTask.downloadFile(android.net.Uri, android.net.Uri):void");
    }

    private void processInputUri() {
        String scheme = this.mInputUri.getScheme();
        Log.d(TAG, "Uri scheme: " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                downloadFile(this.mInputUri, this.mOutputUri);
            } catch (IOException | NullPointerException e5) {
                Log.e(TAG, "Downloading failed", e5);
                throw e5;
            }
        } else if (!"file".equals(scheme) && !"content".equals(scheme)) {
            Log.e(TAG, "Invalid Uri scheme " + scheme);
            throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
        }
    }

    /* access modifiers changed from: protected */
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        InputStream openInputStream;
        Context context = this.mContext.get();
        if (context == null) {
            return new BitmapWorkerResult(new NullPointerException("context is null"));
        }
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            boolean z4 = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z4) {
                try {
                    openInputStream = context.getContentResolver().openInputStream(this.mInputUri);
                    bitmap = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                    if (options.outWidth == -1 || options.outHeight == -1) {
                        BitmapWorkerResult bitmapWorkerResult = new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                        BitmapLoadUtils.close(openInputStream);
                        return bitmapWorkerResult;
                    }
                    BitmapLoadUtils.close(openInputStream);
                    if (!checkSize(bitmap, options)) {
                        z4 = true;
                    }
                } catch (OutOfMemoryError e5) {
                    Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e5);
                    options.inSampleSize *= 2;
                } catch (IOException e6) {
                    Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e6);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e6));
                } catch (Throwable th) {
                    BitmapLoadUtils.close(openInputStream);
                    throw th;
                }
            }
            if (bitmap == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = BitmapLoadUtils.getExifOrientation(context, this.mInputUri);
            int exifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
            int exifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
            ExifInfo exifInfo = new ExifInfo(exifOrientation, exifToDegrees, exifToTranslation);
            Matrix matrix = new Matrix();
            if (exifToDegrees != 0) {
                matrix.preRotate((float) exifToDegrees);
            }
            if (exifToTranslation != 1) {
                matrix.postScale((float) exifToTranslation, 1.0f);
            }
            return !matrix.isIdentity() ? new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo) : new BitmapWorkerResult(bitmap, exifInfo);
        } catch (IOException | NullPointerException e7) {
            return new BitmapWorkerResult(e7);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        if (exc == null) {
            this.mBitmapLoadCallback.onBitmapLoaded(bitmapWorkerResult.mBitmapResult, bitmapWorkerResult.mExifInfo, this.mInputUri, this.mOutputUri);
        } else {
            this.mBitmapLoadCallback.onFailure(exc);
        }
    }
}
