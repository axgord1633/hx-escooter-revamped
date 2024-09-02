package com.yalantis.ucrop.callback;

import android.net.Uri;

public interface BitmapCropCallback {
    void onBitmapCropped(Uri uri, int i5, int i6, int i7, int i8);

    void onCropFailure(Throwable th);
}
