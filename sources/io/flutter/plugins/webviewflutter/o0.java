package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class o0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebStorageHostApi f5385a;

    public /* synthetic */ o0(GeneratedAndroidWebView.WebStorageHostApi webStorageHostApi) {
        this.f5385a = webStorageHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        p0.c(this.f5385a, obj, reply);
    }
}
