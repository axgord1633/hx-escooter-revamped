package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.f;
import io.flutter.plugins.webviewflutter.DownloadListenerHostApiImpl;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import io.flutter.plugins.webviewflutter.WebViewClientHostApiImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WebViewHostApiImpl implements GeneratedAndroidWebView.WebViewHostApi {
    private final View containerView;
    private Context context;
    private final InstanceManager instanceManager;
    private final WebViewProxy webViewProxy;

    public static class InputAwareWebViewPlatformView extends InputAwareWebView implements PlatformView, Releasable {
        private final ReleasableValue<DownloadListenerHostApiImpl.DownloadListenerImpl> currentDownloadListener = new ReleasableValue<>();
        private final ReleasableValue<WebChromeClientHostApiImpl.WebChromeClientImpl> currentWebChromeClient = new ReleasableValue<>();
        private final ReleasableValue<WebViewClientHostApiImpl.ReleasableWebViewClient> currentWebViewClient = new ReleasableValue<>();
        private final Map<String, ReleasableValue<JavaScriptChannel>> javaScriptInterfaces = new HashMap();

        public InputAwareWebViewPlatformView(Context context, View view) {
            super(context, view);
        }

        public void addJavascriptInterface(Object obj, String str) {
            super.addJavascriptInterface(obj, str);
            if (obj instanceof JavaScriptChannel) {
                ReleasableValue releasableValue = this.javaScriptInterfaces.get(str);
                if (!(releasableValue == null || releasableValue.get() == obj)) {
                    releasableValue.release();
                }
                this.javaScriptInterfaces.put(str, new ReleasableValue((JavaScriptChannel) obj));
            }
        }

        public /* bridge */ /* synthetic */ boolean checkInputConnectionProxy(View view) {
            return super.checkInputConnectionProxy(view);
        }

        public /* bridge */ /* synthetic */ void clearFocus() {
            super.clearFocus();
        }

        public void dispose() {
            super.dispose();
            destroy();
        }

        public View getView() {
            return this;
        }

        public void onFlutterViewAttached(View view) {
            setContainerView(view);
        }

        public void onFlutterViewDetached() {
            setContainerView((View) null);
        }

        public void onInputConnectionLocked() {
            lockInputConnection();
        }

        public void onInputConnectionUnlocked() {
            unlockInputConnection();
        }

        public void release() {
            this.currentWebViewClient.release();
            this.currentDownloadListener.release();
            this.currentWebChromeClient.release();
            for (ReleasableValue<JavaScriptChannel> release : this.javaScriptInterfaces.values()) {
                release.release();
            }
            this.javaScriptInterfaces.clear();
        }

        public void removeJavascriptInterface(String str) {
            super.removeJavascriptInterface(str);
            this.javaScriptInterfaces.get(str).release();
            this.javaScriptInterfaces.remove(str);
        }

        public void setDownloadListener(DownloadListener downloadListener) {
            super.setDownloadListener(downloadListener);
            this.currentDownloadListener.set((DownloadListenerHostApiImpl.DownloadListenerImpl) downloadListener);
        }

        public void setWebChromeClient(WebChromeClient webChromeClient) {
            super.setWebChromeClient(webChromeClient);
            this.currentWebChromeClient.set((WebChromeClientHostApiImpl.WebChromeClientImpl) webChromeClient);
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.currentWebViewClient.set((WebViewClientHostApiImpl.ReleasableWebViewClient) webViewClient);
            WebChromeClientHostApiImpl.WebChromeClientImpl webChromeClientImpl = this.currentWebChromeClient.get();
            if (webChromeClientImpl != null) {
                webChromeClientImpl.setWebViewClient(webViewClient);
            }
        }
    }

    private static class ReleasableValue<T extends Releasable> {
        private T value;

        ReleasableValue() {
        }

        ReleasableValue(T t5) {
            this.value = t5;
        }

        /* access modifiers changed from: package-private */
        public T get() {
            return this.value;
        }

        /* access modifiers changed from: package-private */
        public void release() {
            T t5 = this.value;
            if (t5 != null) {
                t5.release();
            }
            this.value = null;
        }

        /* access modifiers changed from: package-private */
        public void set(T t5) {
            release();
            this.value = t5;
        }
    }

    public static class WebViewPlatformView extends WebView implements PlatformView, Releasable {
        private final ReleasableValue<DownloadListenerHostApiImpl.DownloadListenerImpl> currentDownloadListener = new ReleasableValue<>();
        private final ReleasableValue<WebChromeClientHostApiImpl.WebChromeClientImpl> currentWebChromeClient = new ReleasableValue<>();
        private final ReleasableValue<WebViewClientHostApiImpl.ReleasableWebViewClient> currentWebViewClient = new ReleasableValue<>();
        private final Map<String, ReleasableValue<JavaScriptChannel>> javaScriptInterfaces = new HashMap();

        public WebViewPlatformView(Context context) {
            super(context);
        }

        public void addJavascriptInterface(Object obj, String str) {
            super.addJavascriptInterface(obj, str);
            if (obj instanceof JavaScriptChannel) {
                ReleasableValue releasableValue = this.javaScriptInterfaces.get(str);
                if (!(releasableValue == null || releasableValue.get() == obj)) {
                    releasableValue.release();
                }
                this.javaScriptInterfaces.put(str, new ReleasableValue((JavaScriptChannel) obj));
            }
        }

        public void dispose() {
            destroy();
        }

        public View getView() {
            return this;
        }

        public /* synthetic */ void onFlutterViewAttached(View view) {
            f.a(this, view);
        }

        public /* synthetic */ void onFlutterViewDetached() {
            f.b(this);
        }

        public /* synthetic */ void onInputConnectionLocked() {
            f.c(this);
        }

        public /* synthetic */ void onInputConnectionUnlocked() {
            f.d(this);
        }

        public void release() {
            this.currentWebViewClient.release();
            this.currentDownloadListener.release();
            this.currentWebChromeClient.release();
            for (ReleasableValue<JavaScriptChannel> release : this.javaScriptInterfaces.values()) {
                release.release();
            }
            this.javaScriptInterfaces.clear();
        }

        public void removeJavascriptInterface(String str) {
            super.removeJavascriptInterface(str);
            this.javaScriptInterfaces.get(str).release();
            this.javaScriptInterfaces.remove(str);
        }

        public void setDownloadListener(DownloadListener downloadListener) {
            super.setDownloadListener(downloadListener);
            this.currentDownloadListener.set((DownloadListenerHostApiImpl.DownloadListenerImpl) downloadListener);
        }

        public void setWebChromeClient(WebChromeClient webChromeClient) {
            super.setWebChromeClient(webChromeClient);
            this.currentWebChromeClient.set((WebChromeClientHostApiImpl.WebChromeClientImpl) webChromeClient);
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.currentWebViewClient.set((WebViewClientHostApiImpl.ReleasableWebViewClient) webViewClient);
            WebChromeClientHostApiImpl.WebChromeClientImpl webChromeClientImpl = this.currentWebChromeClient.get();
            if (webChromeClientImpl != null) {
                webChromeClientImpl.setWebViewClient(webViewClient);
            }
        }
    }

    public static class WebViewProxy {
        public InputAwareWebViewPlatformView createInputAwareWebView(Context context, View view) {
            return new InputAwareWebViewPlatformView(context, view);
        }

        public WebViewPlatformView createWebView(Context context) {
            return new WebViewPlatformView(context);
        }

        public void setWebContentsDebuggingEnabled(boolean z4) {
            WebView.setWebContentsDebuggingEnabled(z4);
        }
    }

    public WebViewHostApiImpl(InstanceManager instanceManager2, WebViewProxy webViewProxy2, Context context2, View view) {
        this.instanceManager = instanceManager2;
        this.webViewProxy = webViewProxy2;
        this.context = context2;
        this.containerView = view;
    }

    public void addJavaScriptChannel(Long l5, Long l6) {
        JavaScriptChannel javaScriptChannel = (JavaScriptChannel) this.instanceManager.getInstance(l6.longValue());
        ((WebView) this.instanceManager.getInstance(l5.longValue())).addJavascriptInterface(javaScriptChannel, javaScriptChannel.javaScriptChannelName);
    }

    public Boolean canGoBack(Long l5) {
        return Boolean.valueOf(((WebView) this.instanceManager.getInstance(l5.longValue())).canGoBack());
    }

    public Boolean canGoForward(Long l5) {
        return Boolean.valueOf(((WebView) this.instanceManager.getInstance(l5.longValue())).canGoForward());
    }

    public void clearCache(Long l5, Boolean bool) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).clearCache(bool.booleanValue());
    }

    public void create(Long l5, Boolean bool) {
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) this.context.getSystemService("display");
        displayListenerProxy.onPreWebViewInitialization(displayManager);
        Object createWebView = bool.booleanValue() ? this.webViewProxy.createWebView(this.context) : this.webViewProxy.createInputAwareWebView(this.context, this.containerView);
        displayListenerProxy.onPostWebViewInitialization(displayManager);
        this.instanceManager.addDartCreatedInstance(createWebView, l5.longValue());
    }

    public void dispose(Long l5) {
        WebView webView = (WebView) this.instanceManager.getInstance(l5.longValue());
        if (webView != null) {
            ((Releasable) webView).release();
            this.instanceManager.remove(l5.longValue());
        }
    }

    public void evaluateJavascript(Long l5, String str, GeneratedAndroidWebView.Result<String> result) {
        Objects.requireNonNull(result);
        ((WebView) this.instanceManager.getInstance(l5.longValue())).evaluateJavascript(str, new x2(result));
    }

    public InstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    public GeneratedAndroidWebView.WebViewPoint getScrollPosition(Long l5) {
        WebView webView = (WebView) this.instanceManager.getInstance(l5.longValue());
        Objects.requireNonNull(webView);
        WebView webView2 = webView;
        return new GeneratedAndroidWebView.WebViewPoint.Builder().setX(Long.valueOf((long) webView.getScrollX())).setY(Long.valueOf((long) webView.getScrollY())).build();
    }

    public Long getScrollX(Long l5) {
        return Long.valueOf((long) ((WebView) this.instanceManager.getInstance(l5.longValue())).getScrollX());
    }

    public Long getScrollY(Long l5) {
        return Long.valueOf((long) ((WebView) this.instanceManager.getInstance(l5.longValue())).getScrollY());
    }

    public String getTitle(Long l5) {
        return ((WebView) this.instanceManager.getInstance(l5.longValue())).getTitle();
    }

    public String getUrl(Long l5) {
        return ((WebView) this.instanceManager.getInstance(l5.longValue())).getUrl();
    }

    public void goBack(Long l5) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).goBack();
    }

    public void goForward(Long l5) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).goForward();
    }

    public void loadData(Long l5, String str, String str2, String str3) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).loadData(str, str2, str3);
    }

    public void loadDataWithBaseUrl(Long l5, String str, String str2, String str3, String str4, String str5) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(Long l5, String str, Map<String, String> map) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).loadUrl(str, map);
    }

    public void postUrl(Long l5, String str, byte[] bArr) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).postUrl(str, bArr);
    }

    public void reload(Long l5) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).reload();
    }

    public void removeJavaScriptChannel(Long l5, Long l6) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).removeJavascriptInterface(((JavaScriptChannel) this.instanceManager.getInstance(l6.longValue())).javaScriptChannelName);
    }

    public void scrollBy(Long l5, Long l6, Long l7) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).scrollBy(l6.intValue(), l7.intValue());
    }

    public void scrollTo(Long l5, Long l6, Long l7) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).scrollTo(l6.intValue(), l7.intValue());
    }

    public void setBackgroundColor(Long l5, Long l6) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).setBackgroundColor(l6.intValue());
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setDownloadListener(Long l5, Long l6) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).setDownloadListener((DownloadListener) this.instanceManager.getInstance(l6.longValue()));
    }

    public void setWebChromeClient(Long l5, Long l6) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).setWebChromeClient((WebChromeClient) this.instanceManager.getInstance(l6.longValue()));
    }

    public void setWebContentsDebuggingEnabled(Boolean bool) {
        this.webViewProxy.setWebContentsDebuggingEnabled(bool.booleanValue());
    }

    public void setWebViewClient(Long l5, Long l6) {
        ((WebView) this.instanceManager.getInstance(l5.longValue())).setWebViewClient((WebViewClient) this.instanceManager.getInstance(l6.longValue()));
    }
}
