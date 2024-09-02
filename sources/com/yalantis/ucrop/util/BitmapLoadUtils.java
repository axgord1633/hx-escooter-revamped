package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadUtils {
    private static final String CONTENT_SCHEME = "content";
    private static final String TAG = "BitmapLoadUtils";

    public static int calculateInSampleSize(BitmapFactory.Options options, int i5, int i6) {
        int i7 = options.outHeight;
        int i8 = options.outWidth;
        int i9 = 1;
        if (i7 > i6 || i8 > i5) {
            while (true) {
                if (i7 / i9 <= i6 && i8 / i9 <= i5) {
                    break;
                }
                i9 *= 2;
            }
        }
        return i9;
    }

    public static int calculateMaxBitmapSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow((double) point.x, 2.0d) + Math.pow((double) point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int maxTextureSize = EglUtils.getMaxTextureSize();
        if (maxTextureSize > 0) {
            sqrt = Math.min(sqrt, maxTextureSize);
        }
        Log.d(TAG, "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void decodeBitmapInBackground(Context context, Uri uri, Uri uri2, int i5, int i6, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i5, i6, bitmapLoadCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static int exifToDegrees(int i5) {
        switch (i5) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int exifToTranslation(int i5) {
        return (i5 == 2 || i5 == 7 || i5 == 4 || i5 == 5) ? -1 : 1;
    }

    public static int getExifOrientation(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            int orientation = new ImageHeaderParser(openInputStream).getOrientation();
            close(openInputStream);
            return orientation;
        } catch (IOException e5) {
            Log.e(TAG, "getExifOrientation: " + uri.toString(), e5);
            return 0;
        }
    }

    public static boolean hasContentScheme(Uri uri) {
        return uri != null && CONTENT_SCHEME.equals(uri.getScheme());
    }

    public static Bitmap transformBitmap(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError e5) {
            Log.e(TAG, "transformBitmap: ", e5);
            return bitmap;
        }
    }
}
