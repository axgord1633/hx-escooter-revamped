package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.FlutterAssetManagerHostApi f5375a;

    public /* synthetic */ k(GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi) {
        this.f5375a = flutterAssetManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        l.c(this.f5375a, obj, reply);
    }
}
