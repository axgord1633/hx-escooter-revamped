package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class WebChromeClientFlutterApiImpl extends GeneratedAndroidWebView.WebChromeClientFlutterApi {
    private final InstanceManager instanceManager;

    public WebChromeClientFlutterApiImpl(BinaryMessenger binaryMessenger, InstanceManager instanceManager2) {
        super(binaryMessenger);
        this.instanceManager = instanceManager2;
    }

    private long getIdentifierForClient(WebChromeClient webChromeClient) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for WebChromeClient.");
    }

    public void dispose(WebChromeClient webChromeClient, GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        if (this.instanceManager.containsInstance(webChromeClient)) {
            dispose(Long.valueOf(getIdentifierForClient(webChromeClient)), reply);
        } else {
            reply.reply(null);
        }
    }

    public void onProgressChanged(WebChromeClient webChromeClient, WebView webView, Long l5, GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        if (identifierForStrongReference != null) {
            super.onProgressChanged(Long.valueOf(getIdentifierForClient(webChromeClient)), identifierForStrongReference, l5, reply);
            return;
        }
        throw new IllegalStateException("Could not find identifier for WebView.");
    }
}
