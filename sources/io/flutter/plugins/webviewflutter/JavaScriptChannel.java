package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;

public class JavaScriptChannel implements Releasable {
    private JavaScriptChannelFlutterApiImpl flutterApi;
    final String javaScriptChannelName;
    private final Handler platformThreadHandler;

    public JavaScriptChannel(JavaScriptChannelFlutterApiImpl javaScriptChannelFlutterApiImpl, String str, Handler handler) {
        this.flutterApi = javaScriptChannelFlutterApiImpl;
        this.javaScriptChannelName = str;
        this.platformThreadHandler = handler;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$postMessage$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$1(String str) {
        JavaScriptChannelFlutterApiImpl javaScriptChannelFlutterApiImpl = this.flutterApi;
        if (javaScriptChannelFlutterApiImpl != null) {
            javaScriptChannelFlutterApiImpl.postMessage(this, str, new b2());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$release$2(Void voidR) {
    }

    @JavascriptInterface
    public void postMessage(String str) {
        d2 d2Var = new d2(this, str);
        if (this.platformThreadHandler.getLooper() == Looper.myLooper()) {
            d2Var.run();
        } else {
            this.platformThreadHandler.post(d2Var);
        }
    }

    public void release() {
        JavaScriptChannelFlutterApiImpl javaScriptChannelFlutterApiImpl = this.flutterApi;
        if (javaScriptChannelFlutterApiImpl != null) {
            javaScriptChannelFlutterApiImpl.dispose(this, new c2());
        }
        this.flutterApi = null;
    }
}
