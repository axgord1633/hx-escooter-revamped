package io.flutter.plugins.webviewflutter;

import android.webkit.WebSettings;
import android.webkit.WebView;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class WebSettingsHostApiImpl implements GeneratedAndroidWebView.WebSettingsHostApi {
    private final InstanceManager instanceManager;
    private final WebSettingsCreator webSettingsCreator;

    public static class WebSettingsCreator {
        public WebSettings createWebSettings(WebView webView) {
            return webView.getSettings();
        }
    }

    public WebSettingsHostApiImpl(InstanceManager instanceManager2, WebSettingsCreator webSettingsCreator2) {
        this.instanceManager = instanceManager2;
        this.webSettingsCreator = webSettingsCreator2;
    }

    public void create(Long l5, Long l6) {
        this.instanceManager.addDartCreatedInstance(this.webSettingsCreator.createWebSettings((WebView) this.instanceManager.getInstance(l6.longValue())), l5.longValue());
    }

    public void dispose(Long l5) {
        this.instanceManager.remove(l5.longValue());
    }

    public void setAllowFileAccess(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setAllowFileAccess(bool.booleanValue());
    }

    public void setBuiltInZoomControls(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setBuiltInZoomControls(bool.booleanValue());
    }

    public void setDisplayZoomControls(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setDisplayZoomControls(bool.booleanValue());
    }

    public void setDomStorageEnabled(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setDomStorageEnabled(bool.booleanValue());
    }

    public void setJavaScriptCanOpenWindowsAutomatically(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setJavaScriptCanOpenWindowsAutomatically(bool.booleanValue());
    }

    public void setJavaScriptEnabled(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setJavaScriptEnabled(bool.booleanValue());
    }

    public void setLoadWithOverviewMode(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setLoadWithOverviewMode(bool.booleanValue());
    }

    public void setMediaPlaybackRequiresUserGesture(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setMediaPlaybackRequiresUserGesture(bool.booleanValue());
    }

    public void setSupportMultipleWindows(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setSupportMultipleWindows(bool.booleanValue());
    }

    public void setSupportZoom(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setSupportZoom(bool.booleanValue());
    }

    public void setUseWideViewPort(Long l5, Boolean bool) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setUseWideViewPort(bool.booleanValue());
    }

    public void setUserAgentString(Long l5, String str) {
        ((WebSettings) this.instanceManager.getInstance(l5.longValue())).setUserAgentString(str);
    }
}
