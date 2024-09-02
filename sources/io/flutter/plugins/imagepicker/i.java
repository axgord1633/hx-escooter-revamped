package io.flutter.plugins.imagepicker;

import android.media.MediaScannerConnection;
import android.net.Uri;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class i implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate.OnPathReadyListener f5329a;

    public /* synthetic */ i(ImagePickerDelegate.OnPathReadyListener onPathReadyListener) {
        this.f5329a = onPathReadyListener;
    }

    public final void onScanCompleted(String str, Uri uri) {
        this.f5329a.onPathReady(str);
    }
}
