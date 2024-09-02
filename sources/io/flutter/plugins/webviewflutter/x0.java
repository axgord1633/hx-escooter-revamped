package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class x0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewClientHostApi f5408a;

    public /* synthetic */ x0(GeneratedAndroidWebView.WebViewClientHostApi webViewClientHostApi) {
        this.f5408a = webViewClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        y0.b(this.f5408a, obj, reply);
    }
}
