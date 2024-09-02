package io.flutter.plugins.webviewflutter;

import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class JavaObjectHostApiImpl implements GeneratedAndroidWebView.JavaObjectHostApi {
    private final InstanceManager instanceManager;

    public JavaObjectHostApiImpl(InstanceManager instanceManager2) {
        this.instanceManager = instanceManager2;
    }

    public void dispose(Long l5) {
        this.instanceManager.remove(l5.longValue());
    }
}
