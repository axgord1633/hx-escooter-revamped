package io.flutter.plugins.webviewflutter;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.PluginRegistry;

abstract class FlutterAssetManager {
    final AssetManager assetManager;

    static class PluginBindingFlutterAssetManager extends FlutterAssetManager {
        final FlutterPlugin.FlutterAssets flutterAssets;

        PluginBindingFlutterAssetManager(AssetManager assetManager, FlutterPlugin.FlutterAssets flutterAssets2) {
            super(assetManager);
            this.flutterAssets = flutterAssets2;
        }

        public String getAssetFilePathByName(String str) {
            return this.flutterAssets.getAssetFilePathByName(str);
        }
    }

    @Deprecated
    static class RegistrarFlutterAssetManager extends FlutterAssetManager {
        final PluginRegistry.Registrar registrar;

        RegistrarFlutterAssetManager(AssetManager assetManager, PluginRegistry.Registrar registrar2) {
            super(assetManager);
            this.registrar = registrar2;
        }

        public String getAssetFilePathByName(String str) {
            return this.registrar.lookupKeyForAsset(str);
        }
    }

    public FlutterAssetManager(AssetManager assetManager2) {
        this.assetManager = assetManager2;
    }

    /* access modifiers changed from: package-private */
    public abstract String getAssetFilePathByName(String str);

    public String[] list(String str) {
        return this.assetManager.list(str);
    }
}
