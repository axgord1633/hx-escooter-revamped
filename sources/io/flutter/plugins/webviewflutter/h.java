package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class h implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.DownloadListenerHostApi f5367a;

    public /* synthetic */ h(GeneratedAndroidWebView.DownloadListenerHostApi downloadListenerHostApi) {
        this.f5367a = downloadListenerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        i.b(this.f5367a, obj, reply);
    }
}
