package io.flutter.plugin.platform;

import android.view.View;

public final /* synthetic */ class g implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f5300a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5301b;

    public /* synthetic */ g(PlatformViewsController platformViewsController, int i5) {
        this.f5300a = platformViewsController;
        this.f5301b = i5;
    }

    public final void onFocusChange(View view, boolean z4) {
        this.f5300a.lambda$initializePlatformViewIfNeeded$2(this.f5301b, view, z4);
    }
}
