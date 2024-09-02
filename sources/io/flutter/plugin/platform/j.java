package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;

public final /* synthetic */ class j implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f5305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f5306b;

    public /* synthetic */ j(PlatformViewsController platformViewsController, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f5305a = platformViewsController;
        this.f5306b = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z4) {
        this.f5305a.lambda$configureForVirtualDisplay$0(this.f5306b, view, z4);
    }
}
