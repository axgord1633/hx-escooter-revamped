package io.flutter.plugins;

import com.mr.flutter.plugin.filepicker.FilePickerPlugin;
import com.signify.hue.flutterreactiveble.ReactiveBlePlugin;
import d2.c0;
import g2.g;
import h2.c;
import i2.a;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
import j0.b;
import q0.m;

public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new c());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin application_icon, de.ju.application_icon.ApplicationIconPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new a());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin device_info_plus, dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FilePickerPlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin file_picker, com.mr.flutter.plugin.filepicker.FilePickerPlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterAndroidLifecyclePlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new b());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin geocoding_android, com.baseflow.geocoding.GeocodingPlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new com.baseflow.geolocator.a());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin geolocator_android, com.baseflow.geolocator.GeolocatorPlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new l2.a());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin google_api_headers, io.github.zeshuaro.google_api_headers.GoogleApiHeadersPlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new v4.c());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin image_cropper, vn.hunghd.flutter.plugins.imagecropper.ImageCropperPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ImagePickerPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin image_picker_android, io.flutter.plugins.imagepicker.ImagePickerPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new i0.a());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin map_launcher, com.alexmiller.map_launcher.MapLauncherPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new j2.c());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PathProviderPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new m());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ReactiveBlePlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin reactive_ble_mobile, com.signify.hue.flutterreactiveble.ReactiveBlePlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new c0());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new g());
        } catch (Exception e20) {
            Log.e(TAG, "Error registering plugin wakelock, creativemaybeno.wakelock.WakelockPlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new WebViewFlutterPlugin());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e21);
        }
    }
}
