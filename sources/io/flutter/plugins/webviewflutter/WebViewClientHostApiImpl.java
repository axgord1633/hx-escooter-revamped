package io.flutter.plugins.webviewflutter;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewClientCompat;
import d0.e;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class WebViewClientHostApiImpl implements GeneratedAndroidWebView.WebViewClientHostApi {
    private final WebViewClientFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;
    private final WebViewClientCreator webViewClientCreator;

    public interface ReleasableWebViewClient extends Releasable {
    }

    public static class WebViewClientCompatImpl extends WebViewClientCompat implements ReleasableWebViewClient {
        private WebViewClientFlutterApiImpl flutterApi;
        private final boolean shouldOverrideUrlLoading;

        public WebViewClientCompatImpl(WebViewClientFlutterApiImpl webViewClientFlutterApiImpl, boolean z4) {
            this.shouldOverrideUrlLoading = z4;
            this.flutterApi = webViewClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$release$6(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$5(Void voidR) {
        }

        public void onPageFinished(WebView webView, String str) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onPageFinished(this, webView, str, new i2());
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onPageStarted(this, webView, str, new o2());
            }
        }

        public void onReceivedError(WebView webView, int i5, String str, String str2) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onReceivedError(this, webView, Long.valueOf((long) i5), str, str2, new n2());
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, e eVar) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onReceivedRequestError((WebViewClient) this, webView, webResourceRequest, eVar, (GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void>) new j2());
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        }

        public void release() {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.dispose(this, new m2());
            }
            this.flutterApi = null;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.requestLoading(this, webView, webResourceRequest, new l2());
            }
            return this.shouldOverrideUrlLoading;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.urlLoading(this, webView, str, new k2());
            }
            return this.shouldOverrideUrlLoading;
        }
    }

    public static class WebViewClientCreator {
        public WebViewClient createWebViewClient(WebViewClientFlutterApiImpl webViewClientFlutterApiImpl, boolean z4) {
            return Build.VERSION.SDK_INT >= 24 ? new WebViewClientImpl(webViewClientFlutterApiImpl, z4) : new WebViewClientCompatImpl(webViewClientFlutterApiImpl, z4);
        }
    }

    public static class WebViewClientImpl extends WebViewClient implements ReleasableWebViewClient {
        private WebViewClientFlutterApiImpl flutterApi;
        private final boolean shouldOverrideUrlLoading;

        public WebViewClientImpl(WebViewClientFlutterApiImpl webViewClientFlutterApiImpl, boolean z4) {
            this.shouldOverrideUrlLoading = z4;
            this.flutterApi = webViewClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$release$6(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$5(Void voidR) {
        }

        public void onPageFinished(WebView webView, String str) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onPageFinished(this, webView, str, new r2());
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onPageStarted(this, webView, str, new p2());
            }
        }

        public void onReceivedError(WebView webView, int i5, String str, String str2) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onReceivedError(this, webView, Long.valueOf((long) i5), str, str2, new s2());
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.onReceivedRequestError((WebViewClient) this, webView, webResourceRequest, webResourceError, (GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void>) new v2());
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        }

        public void release() {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.dispose(this, new q2());
            }
            this.flutterApi = null;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.requestLoading(this, webView, webResourceRequest, new u2());
            }
            return this.shouldOverrideUrlLoading;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClientFlutterApiImpl webViewClientFlutterApiImpl = this.flutterApi;
            if (webViewClientFlutterApiImpl != null) {
                webViewClientFlutterApiImpl.urlLoading(this, webView, str, new t2());
            }
            return this.shouldOverrideUrlLoading;
        }
    }

    public WebViewClientHostApiImpl(InstanceManager instanceManager2, WebViewClientCreator webViewClientCreator2, WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
        this.instanceManager = instanceManager2;
        this.webViewClientCreator = webViewClientCreator2;
        this.flutterApi = webViewClientFlutterApiImpl;
    }

    public void create(Long l5, Boolean bool) {
        this.instanceManager.addDartCreatedInstance(this.webViewClientCreator.createWebViewClient(this.flutterApi, bool.booleanValue()), l5.longValue());
    }
}
