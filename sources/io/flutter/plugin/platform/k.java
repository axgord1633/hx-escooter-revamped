package io.flutter.plugin.platform;

import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f5307e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ VirtualDisplayController f5308f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f5309g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewBufferResized f5310h;

    public /* synthetic */ k(PlatformViewsController.AnonymousClass1 r12, VirtualDisplayController virtualDisplayController, float f5, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
        this.f5307e = r12;
        this.f5308f = virtualDisplayController;
        this.f5309g = f5;
        this.f5310h = platformViewBufferResized;
    }

    public final void run() {
        this.f5307e.lambda$resize$0(this.f5308f, this.f5309g, this.f5310h);
    }
}
