package io.flutter.embedding.engine.plugins.util;

import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class GeneratedPluginRegister {
    private static final String TAG = "GeneratedPluginsRegister";

    public static void registerGeneratedPlugins(FlutterEngine flutterEngine) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", new Class[]{FlutterEngine.class}).invoke((Object) null, new Object[]{flutterEngine});
        } catch (Exception e5) {
            Log.e(TAG, "Tried to automatically register plugins with FlutterEngine (" + flutterEngine + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.e(TAG, "Received exception while registering", e5);
        }
    }
}
