package io.flutter.plugins.imagepicker;

import android.content.Intent;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5322e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5323f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f5324g;

    public /* synthetic */ e(ImagePickerDelegate imagePickerDelegate, int i5, Intent intent) {
        this.f5322e = imagePickerDelegate;
        this.f5323f = i5;
        this.f5324g = intent;
    }

    public final void run() {
        this.f5322e.lambda$onActivityResult$4(this.f5323f, this.f5324g);
    }
}
