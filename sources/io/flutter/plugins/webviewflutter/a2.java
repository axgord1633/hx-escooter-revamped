package io.flutter.plugins.webviewflutter;

public final /* synthetic */ class a2 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ InstanceManager f5348e;

    public /* synthetic */ a2(InstanceManager instanceManager) {
        this.f5348e = instanceManager;
    }

    public final void run() {
        this.f5348e.releaseAllFinalizedInstances();
    }
}
