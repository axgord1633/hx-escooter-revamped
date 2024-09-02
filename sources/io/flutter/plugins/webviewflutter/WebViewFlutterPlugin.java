package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugins.webviewflutter.DownloadListenerHostApiImpl;
import io.flutter.plugins.webviewflutter.FlutterAssetManager;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.JavaScriptChannelHostApiImpl;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import io.flutter.plugins.webviewflutter.WebSettingsHostApiImpl;
import io.flutter.plugins.webviewflutter.WebStorageHostApiImpl;
import io.flutter.plugins.webviewflutter.WebViewClientHostApiImpl;
import io.flutter.plugins.webviewflutter.WebViewHostApiImpl;

public class WebViewFlutterPlugin implements FlutterPlugin, ActivityAware {
    private InstanceManager instanceManager;
    private JavaScriptChannelHostApiImpl javaScriptChannelHostApi;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private WebViewHostApiImpl webViewHostApi;

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUp$0(long j5) {
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new WebViewFlutterPlugin().setUp(registrar.messenger(), registrar.platformViewRegistry(), registrar.activity(), registrar.view(), new FlutterAssetManager.RegistrarFlutterAssetManager(registrar.context().getAssets(), registrar));
    }

    private void setUp(BinaryMessenger binaryMessenger, PlatformViewRegistry platformViewRegistry, Context context, View view, FlutterAssetManager flutterAssetManager) {
        InstanceManager open = InstanceManager.open(new w2());
        this.instanceManager = open;
        platformViewRegistry.registerViewFactory("plugins.flutter.io/webview", new FlutterWebViewFactory(open));
        this.webViewHostApi = new WebViewHostApiImpl(this.instanceManager, new WebViewHostApiImpl.WebViewProxy(), context, view);
        this.javaScriptChannelHostApi = new JavaScriptChannelHostApiImpl(this.instanceManager, new JavaScriptChannelHostApiImpl.JavaScriptChannelCreator(), new JavaScriptChannelFlutterApiImpl(binaryMessenger, this.instanceManager), new Handler(context.getMainLooper()));
        GeneratedAndroidWebView.WebViewHostApi.CC.C(binaryMessenger, this.webViewHostApi);
        t.c(binaryMessenger, this.javaScriptChannelHostApi);
        y0.c(binaryMessenger, new WebViewClientHostApiImpl(this.instanceManager, new WebViewClientHostApiImpl.WebViewClientCreator(), new WebViewClientFlutterApiImpl(binaryMessenger, this.instanceManager)));
        x.c(binaryMessenger, new WebChromeClientHostApiImpl(this.instanceManager, new WebChromeClientHostApiImpl.WebChromeClientCreator(), new WebChromeClientFlutterApiImpl(binaryMessenger, this.instanceManager)));
        i.c(binaryMessenger, new DownloadListenerHostApiImpl(this.instanceManager, new DownloadListenerHostApiImpl.DownloadListenerCreator(), new DownloadListenerFlutterApiImpl(binaryMessenger, this.instanceManager)));
        m0.p(binaryMessenger, new WebSettingsHostApiImpl(this.instanceManager, new WebSettingsHostApiImpl.WebSettingsCreator()));
        l.d(binaryMessenger, new FlutterAssetManagerHostApiImpl(flutterAssetManager));
        GeneratedAndroidWebView.CookieManagerHostApi.CC.d(binaryMessenger, new CookieManagerHostApiImpl());
        p0.d(binaryMessenger, new WebStorageHostApiImpl(this.instanceManager, new WebStorageHostApiImpl.WebStorageCreator()));
    }

    private void updateContext(Context context) {
        this.webViewHostApi.setContext(context);
        this.javaScriptChannelHostApi.setPlatformThreadHandler(new Handler(context.getMainLooper()));
    }

    public InstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        updateContext(activityPluginBinding.getActivity());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
        setUp(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getPlatformViewRegistry(), flutterPluginBinding.getApplicationContext(), (View) null, new FlutterAssetManager.PluginBindingFlutterAssetManager(flutterPluginBinding.getApplicationContext().getAssets(), flutterPluginBinding.getFlutterAssets()));
    }

    public void onDetachedFromActivity() {
        updateContext(this.pluginBinding.getApplicationContext());
    }

    public void onDetachedFromActivityForConfigChanges() {
        updateContext(this.pluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.instanceManager.close();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        updateContext(activityPluginBinding.getActivity());
    }
}
