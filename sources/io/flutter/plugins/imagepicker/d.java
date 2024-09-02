package io.flutter.plugins.imagepicker;

import android.content.Intent;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5319e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5320f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f5321g;

    public /* synthetic */ d(ImagePickerDelegate imagePickerDelegate, int i5, Intent intent) {
        this.f5319e = imagePickerDelegate;
        this.f5320f = i5;
        this.f5321g = intent;
    }

    public final void run() {
        this.f5319e.lambda$onActivityResult$3(this.f5320f, this.f5321g);
    }
}
