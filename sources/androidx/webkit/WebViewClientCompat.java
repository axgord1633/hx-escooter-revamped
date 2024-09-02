package androidx.webkit;

import android.app.PendingIntent;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import d0.a;
import d0.e;
import d0.g;
import e0.b;
import e0.m;
import e0.o;
import e0.p;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;

public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};

    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    public void onPageCommitVisible(WebView webView, String str) {
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        onReceivedError(webView, webResourceRequest, (e) new o(webResourceError));
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, e eVar) {
        if (g.a("WEB_RESOURCE_ERROR_GET_CODE") && g.a("WEB_RESOURCE_ERROR_GET_DESCRIPTION") && b.b(webResourceRequest)) {
            onReceivedError(webView, eVar.b(), eVar.a().toString(), b.a(webResourceRequest).toString());
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, InvocationHandler invocationHandler) {
        onReceivedError(webView, webResourceRequest, (e) new o(invocationHandler));
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i5, SafeBrowsingResponse safeBrowsingResponse) {
        onSafeBrowsingHit(webView, webResourceRequest, i5, (a) new m(safeBrowsingResponse));
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i5, a aVar) {
        if (g.a("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
            aVar.a(true);
            return;
        }
        throw p.a();
    }

    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i5, InvocationHandler invocationHandler) {
        onSafeBrowsingHit(webView, webResourceRequest, i5, (a) new m(invocationHandler));
    }

    public boolean onWebAuthnIntent(WebView webView, PendingIntent pendingIntent, InvocationHandler invocationHandler) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, b.a(webResourceRequest).toString());
    }
}
