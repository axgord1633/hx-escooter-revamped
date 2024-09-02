package io.flutter.plugin.platform;

import io.flutter.plugin.platform.PlatformPlugin;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PlatformPlugin.AnonymousClass2 f5298e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5299f;

    public /* synthetic */ d(PlatformPlugin.AnonymousClass2 r12, int i5) {
        this.f5298e = r12;
        this.f5299f = i5;
    }

    public final void run() {
        this.f5298e.lambda$onSystemUiVisibilityChange$0(this.f5299f);
    }
}
