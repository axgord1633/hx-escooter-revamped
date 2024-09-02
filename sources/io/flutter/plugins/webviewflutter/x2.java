package io.flutter.plugins.webviewflutter;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class x2 implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.Result f5410a;

    public /* synthetic */ x2(GeneratedAndroidWebView.Result result) {
        this.f5410a = result;
    }

    public final void onReceiveValue(Object obj) {
        this.f5410a.success((String) obj);
    }
}
