package io.flutter.plugins.webviewflutter;

public final /* synthetic */ class d2 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ JavaScriptChannel f5356e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f5357f;

    public /* synthetic */ d2(JavaScriptChannel javaScriptChannel, String str) {
        this.f5356e = javaScriptChannel;
        this.f5357f = str;
    }

    public final void run() {
        this.f5356e.lambda$postMessage$1(this.f5357f);
    }
}
