package io.flutter.plugins.webviewflutter;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class a implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.Result f5345a;

    public /* synthetic */ a(GeneratedAndroidWebView.Result result) {
        this.f5345a = result;
    }

    public final void onReceiveValue(Object obj) {
        this.f5345a.success((Boolean) obj);
    }
}
