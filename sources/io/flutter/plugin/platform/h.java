package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;

public final /* synthetic */ class h implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f5302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f5303b;

    public /* synthetic */ h(PlatformViewsController platformViewsController, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f5302a = platformViewsController;
        this.f5303b = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z4) {
        this.f5302a.lambda$configureForTextureLayerComposition$1(this.f5303b, view, z4);
    }
}
