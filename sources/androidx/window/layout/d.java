package androidx.window.layout;

import androidx.window.layout.SidecarWindowBackend;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f2831e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ WindowLayoutInfo f2832f;

    public /* synthetic */ d(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
        this.f2831e = windowLayoutChangeCallbackWrapper;
        this.f2832f = windowLayoutInfo;
    }

    public final void run() {
        SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m6accept$lambda0(this.f2831e, this.f2832f);
    }
}
