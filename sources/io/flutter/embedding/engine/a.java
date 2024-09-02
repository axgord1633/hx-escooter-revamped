package io.flutter.embedding.engine;

import android.graphics.ImageDecoder;

public final /* synthetic */ class a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5270a;

    public /* synthetic */ a(long j5) {
        this.f5270a = j5;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        FlutterJNI.lambda$decodeImage$0(this.f5270a, imageDecoder, imageInfo, source);
    }
}
