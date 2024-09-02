package io.flutter.plugins.webviewflutter;

import android.webkit.DownloadListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class DownloadListenerFlutterApiImpl extends GeneratedAndroidWebView.DownloadListenerFlutterApi {
    private final InstanceManager instanceManager;

    public DownloadListenerFlutterApiImpl(BinaryMessenger binaryMessenger, InstanceManager instanceManager2) {
        super(binaryMessenger);
        this.instanceManager = instanceManager2;
    }

    private long getIdentifierForListener(DownloadListener downloadListener) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(downloadListener);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for DownloadListener.");
    }

    public void dispose(DownloadListener downloadListener, GeneratedAndroidWebView.DownloadListenerFlutterApi.Reply<Void> reply) {
        if (this.instanceManager.containsInstance(downloadListener)) {
            dispose(Long.valueOf(getIdentifierForListener(downloadListener)), reply);
        } else {
            reply.reply(null);
        }
    }

    public void onDownloadStart(DownloadListener downloadListener, String str, String str2, String str3, String str4, long j5, GeneratedAndroidWebView.DownloadListenerFlutterApi.Reply<Void> reply) {
        onDownloadStart(Long.valueOf(getIdentifierForListener(downloadListener)), str, str2, str3, str4, Long.valueOf(j5), reply);
    }
}
