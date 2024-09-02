package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class n implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.JavaObjectHostApi f5382a;

    public /* synthetic */ n(GeneratedAndroidWebView.JavaObjectHostApi javaObjectHostApi) {
        this.f5382a = javaObjectHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        o.b(this.f5382a, obj, reply);
    }
}
