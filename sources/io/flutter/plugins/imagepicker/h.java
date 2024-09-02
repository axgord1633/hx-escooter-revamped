package io.flutter.plugins.imagepicker;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class h implements ImagePickerDelegate.OnPathReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5328a;

    public /* synthetic */ h(ImagePickerDelegate imagePickerDelegate) {
        this.f5328a = imagePickerDelegate;
    }

    public final void onPathReady(String str) {
        this.f5328a.handleVideoResult(str);
    }
}
