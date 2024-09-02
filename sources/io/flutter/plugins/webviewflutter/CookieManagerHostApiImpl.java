package io.flutter.plugins.webviewflutter;

import android.webkit.CookieManager;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

class CookieManagerHostApiImpl implements GeneratedAndroidWebView.CookieManagerHostApi {
    CookieManagerHostApiImpl() {
    }

    public void clearCookies(GeneratedAndroidWebView.Result<Boolean> result) {
        CookieManager instance = CookieManager.getInstance();
        Objects.requireNonNull(result);
        instance.removeAllCookies(new a(result));
    }

    public void setCookie(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
    }
}
