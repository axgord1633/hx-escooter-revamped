package io.flutter.plugins.imagepicker;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5325e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5326f;

    public /* synthetic */ f(ImagePickerDelegate imagePickerDelegate, int i5) {
        this.f5325e = imagePickerDelegate;
        this.f5326f = i5;
    }

    public final void run() {
        this.f5325e.lambda$onActivityResult$5(this.f5326f);
    }
}
