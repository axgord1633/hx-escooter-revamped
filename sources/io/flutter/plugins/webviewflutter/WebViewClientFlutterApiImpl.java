package io.flutter.plugins.webviewflutter;

import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import d0.e;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.HashMap;

public class WebViewClientFlutterApiImpl extends GeneratedAndroidWebView.WebViewClientFlutterApi {
    private final InstanceManager instanceManager;

    public WebViewClientFlutterApiImpl(BinaryMessenger binaryMessenger, InstanceManager instanceManager2) {
        super(binaryMessenger);
        this.instanceManager = instanceManager2;
    }

    static GeneratedAndroidWebView.WebResourceErrorData createWebResourceErrorData(WebResourceError webResourceError) {
        return new GeneratedAndroidWebView.WebResourceErrorData.Builder().setErrorCode(Long.valueOf((long) webResourceError.getErrorCode())).setDescription(webResourceError.getDescription().toString()).build();
    }

    static GeneratedAndroidWebView.WebResourceErrorData createWebResourceErrorData(e eVar) {
        return new GeneratedAndroidWebView.WebResourceErrorData.Builder().setErrorCode(Long.valueOf((long) eVar.b())).setDescription(eVar.a().toString()).build();
    }

    static GeneratedAndroidWebView.WebResourceRequestData createWebResourceRequestData(WebResourceRequest webResourceRequest) {
        GeneratedAndroidWebView.WebResourceRequestData.Builder requestHeaders = new GeneratedAndroidWebView.WebResourceRequestData.Builder().setUrl(webResourceRequest.getUrl().toString()).setIsForMainFrame(Boolean.valueOf(webResourceRequest.isForMainFrame())).setHasGesture(Boolean.valueOf(webResourceRequest.hasGesture())).setMethod(webResourceRequest.getMethod()).setRequestHeaders(webResourceRequest.getRequestHeaders() != null ? webResourceRequest.getRequestHeaders() : new HashMap());
        if (Build.VERSION.SDK_INT >= 24) {
            requestHeaders.setIsRedirect(Boolean.valueOf(webResourceRequest.isRedirect()));
        }
        return requestHeaders.build();
    }

    private long getIdentifierForClient(WebViewClient webViewClient) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webViewClient);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for WebViewClient.");
    }

    public void dispose(WebViewClient webViewClient, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        if (this.instanceManager.containsInstance(webViewClient)) {
            dispose(Long.valueOf(getIdentifierForClient(webViewClient)), reply);
        } else {
            reply.reply(null);
        }
    }

    public void onPageFinished(WebViewClient webViewClient, WebView webView, String str, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            onPageFinished(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }

    public void onPageStarted(WebViewClient webViewClient, WebView webView, String str, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            onPageStarted(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }

    public void onReceivedError(WebViewClient webViewClient, WebView webView, Long l5, String str, String str2, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            onReceivedError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, l5, str, str2, reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }

    public void onReceivedRequestError(WebViewClient webViewClient, WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            onReceivedRequestError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, createWebResourceRequestData(webResourceRequest), createWebResourceErrorData(webResourceError), reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }

    public void onReceivedRequestError(WebViewClient webViewClient, WebView webView, WebResourceRequest webResourceRequest, e eVar, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            onReceivedRequestError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, createWebResourceRequestData(webResourceRequest), createWebResourceErrorData(eVar), reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }

    public void requestLoading(WebViewClient webViewClient, WebView webView, WebResourceRequest webResourceRequest, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            requestLoading(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, createWebResourceRequestData(webResourceRequest), reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }

    public void urlLoading(WebViewClient webViewClient, WebView webView, String str, GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            urlLoading(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }
}
