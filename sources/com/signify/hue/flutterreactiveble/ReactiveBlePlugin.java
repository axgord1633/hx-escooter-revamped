package com.signify.hue.flutterreactiveble;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class ReactiveBlePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final Companion Companion = new Companion((g) null);
    public static PluginController pluginController;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final void deinitializePlugin() {
            getPluginController().deinitialize$reactive_ble_mobile_release();
        }

        /* access modifiers changed from: private */
        public final void initializePlugin(BinaryMessenger binaryMessenger, Context context, ReactiveBlePlugin reactiveBlePlugin) {
            new MethodChannel(binaryMessenger, "flutter_reactive_ble_method").setMethodCallHandler(reactiveBlePlugin);
            setPluginController(new PluginController());
            getPluginController().initialize$reactive_ble_mobile_release(binaryMessenger, context);
        }

        public final PluginController getPluginController() {
            PluginController pluginController = ReactiveBlePlugin.pluginController;
            if (pluginController != null) {
                return pluginController;
            }
            k.o("pluginController");
            return null;
        }

        public final void setPluginController(PluginController pluginController) {
            k.e(pluginController, "<set-?>");
            ReactiveBlePlugin.pluginController = pluginController;
        }
    }

    private static final void deinitializePlugin() {
        Companion.deinitializePlugin();
    }

    private static final void initializePlugin(BinaryMessenger binaryMessenger, Context context, ReactiveBlePlugin reactiveBlePlugin) {
        Companion.initializePlugin(binaryMessenger, context, reactiveBlePlugin);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        Companion companion = Companion;
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        k.d(binaryMessenger, "binding.binaryMessenger");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        k.d(applicationContext, "binding.applicationContext");
        companion.initializePlugin(binaryMessenger, applicationContext, this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k.e(flutterPluginBinding, "binding");
        Companion.deinitializePlugin();
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        k.e(methodCall, "call");
        k.e(result, "result");
        Companion.getPluginController().execute$reactive_ble_mobile_release(methodCall, result);
    }
}
