package io.flutter.plugins.webviewflutter;

import android.content.Context;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

class FlutterWebViewFactory extends PlatformViewFactory {
    private final InstanceManager instanceManager;

    FlutterWebViewFactory(InstanceManager instanceManager2) {
        super(StandardMessageCodec.INSTANCE);
        this.instanceManager = instanceManager2;
    }

    public PlatformView create(Context context, int i5, Object obj) {
        PlatformView platformView = (PlatformView) this.instanceManager.getInstance((long) ((Integer) obj).intValue());
        if (platformView != null) {
            return platformView;
        }
        throw new IllegalStateException("Unable to find WebView instance: " + obj);
    }
}
