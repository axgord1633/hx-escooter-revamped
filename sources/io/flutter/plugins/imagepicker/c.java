package io.flutter.plugins.imagepicker;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5317e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5318f;

    public /* synthetic */ c(ImagePickerDelegate imagePickerDelegate, int i5) {
        this.f5317e = imagePickerDelegate;
        this.f5318f = i5;
    }

    public final void run() {
        this.f5317e.lambda$onActivityResult$2(this.f5318f);
    }
}
