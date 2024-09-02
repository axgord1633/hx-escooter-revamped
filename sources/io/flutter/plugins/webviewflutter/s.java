package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class s implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.JavaScriptChannelHostApi f5394a;

    public /* synthetic */ s(GeneratedAndroidWebView.JavaScriptChannelHostApi javaScriptChannelHostApi) {
        this.f5394a = javaScriptChannelHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        t.b(this.f5394a, obj, reply);
    }
}
