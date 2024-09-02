package io.flutter.plugins.imagepicker;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class g implements ImagePickerDelegate.OnPathReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5327a;

    public /* synthetic */ g(ImagePickerDelegate imagePickerDelegate) {
        this.f5327a = imagePickerDelegate;
    }

    public final void onPathReady(String str) {
        this.f5327a.lambda$handleCaptureImageResult$6(str);
    }
}
