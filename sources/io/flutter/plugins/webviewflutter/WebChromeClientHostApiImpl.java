package io.flutter.plugins.webviewflutter;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class WebChromeClientHostApiImpl implements GeneratedAndroidWebView.WebChromeClientHostApi {
    private final WebChromeClientFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;
    private final WebChromeClientCreator webChromeClientCreator;

    public static class WebChromeClientCreator {
        public WebChromeClientImpl createWebChromeClient(WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl, WebViewClient webViewClient) {
            return new WebChromeClientImpl(webChromeClientFlutterApiImpl, webViewClient);
        }
    }

    public static class WebChromeClientImpl extends WebChromeClient implements Releasable {
        private WebChromeClientFlutterApiImpl flutterApi;
        /* access modifiers changed from: private */
        public WebViewClient webViewClient;

        public WebChromeClientImpl(WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl, WebViewClient webViewClient2) {
            this.flutterApi = webChromeClientFlutterApiImpl;
            this.webViewClient = webViewClient2;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onProgressChanged$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$release$1(Void voidR) {
        }

        /* access modifiers changed from: package-private */
        public boolean onCreateWindow(final WebView webView, Message message, WebView webView2) {
            AnonymousClass1 r02 = new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    if (g2.a(WebChromeClientImpl.this.webViewClient, webView, webResourceRequest)) {
                        return true;
                    }
                    webView.loadUrl(webResourceRequest.getUrl().toString());
                    return true;
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (WebChromeClientImpl.this.webViewClient.shouldOverrideUrlLoading(webView, str)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                }
            };
            if (webView2 == null) {
                webView2 = new WebView(webView.getContext());
            }
            webView2.setWebViewClient(r02);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }

        public boolean onCreateWindow(WebView webView, boolean z4, boolean z5, Message message) {
            return onCreateWindow(webView, message, new WebView(webView.getContext()));
        }

        public void onProgressChanged(WebView webView, int i5) {
            WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl = this.flutterApi;
            if (webChromeClientFlutterApiImpl != null) {
                webChromeClientFlutterApiImpl.onProgressChanged(this, webView, Long.valueOf((long) i5), new f2());
            }
        }

        public void release() {
            WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl = this.flutterApi;
            if (webChromeClientFlutterApiImpl != null) {
                webChromeClientFlutterApiImpl.dispose(this, new e2());
            }
            this.flutterApi = null;
        }

        public void setWebViewClient(WebViewClient webViewClient2) {
            this.webViewClient = webViewClient2;
        }
    }

    public WebChromeClientHostApiImpl(InstanceManager instanceManager2, WebChromeClientCreator webChromeClientCreator2, WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl) {
        this.instanceManager = instanceManager2;
        this.webChromeClientCreator = webChromeClientCreator2;
        this.flutterApi = webChromeClientFlutterApiImpl;
    }

    public void create(Long l5, Long l6) {
        this.instanceManager.addDartCreatedInstance(this.webChromeClientCreator.createWebChromeClient(this.flutterApi, (WebViewClient) this.instanceManager.getInstance(l6.longValue())), l5.longValue());
    }
}
