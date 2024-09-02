package io.flutter.plugins.imagepicker;

import android.content.Intent;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5314e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5315f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f5316g;

    public /* synthetic */ b(ImagePickerDelegate imagePickerDelegate, int i5, Intent intent) {
        this.f5314e = imagePickerDelegate;
        this.f5315f = i5;
        this.f5316g = intent;
    }

    public final void run() {
        this.f5314e.lambda$onActivityResult$1(this.f5315f, this.f5316g);
    }
}
