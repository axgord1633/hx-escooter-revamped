package io.flutter.plugins.imagepicker;

import android.content.Intent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5311e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5312f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f5313g;

    public /* synthetic */ a(ImagePickerDelegate imagePickerDelegate, int i5, Intent intent) {
        this.f5311e = imagePickerDelegate;
        this.f5312f = i5;
        this.f5313g = intent;
    }

    public final void run() {
        this.f5311e.lambda$onActivityResult$0(this.f5312f, this.f5313g);
    }
}
