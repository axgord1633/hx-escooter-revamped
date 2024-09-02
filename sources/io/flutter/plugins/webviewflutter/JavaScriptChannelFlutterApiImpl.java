package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class JavaScriptChannelFlutterApiImpl extends GeneratedAndroidWebView.JavaScriptChannelFlutterApi {
    private final InstanceManager instanceManager;

    public JavaScriptChannelFlutterApiImpl(BinaryMessenger binaryMessenger, InstanceManager instanceManager2) {
        super(binaryMessenger);
        this.instanceManager = instanceManager2;
    }

    private long getIdentifierForJavaScriptChannel(JavaScriptChannel javaScriptChannel) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(javaScriptChannel);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for JavaScriptChannel.");
    }

    public void dispose(JavaScriptChannel javaScriptChannel, GeneratedAndroidWebView.JavaScriptChannelFlutterApi.Reply<Void> reply) {
        if (this.instanceManager.containsInstance(javaScriptChannel)) {
            dispose(Long.valueOf(getIdentifierForJavaScriptChannel(javaScriptChannel)), reply);
        } else {
            reply.reply(null);
        }
    }

    public void postMessage(JavaScriptChannel javaScriptChannel, String str, GeneratedAndroidWebView.JavaScriptChannelFlutterApi.Reply<Void> reply) {
        super.postMessage(Long.valueOf(getIdentifierForJavaScriptChannel(javaScriptChannel)), str, reply);
    }
}
