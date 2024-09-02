package io.flutter.plugins.webviewflutter;

import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlutterAssetManagerHostApiImpl implements GeneratedAndroidWebView.FlutterAssetManagerHostApi {
    final FlutterAssetManager flutterAssetManager;

    public FlutterAssetManagerHostApiImpl(FlutterAssetManager flutterAssetManager2) {
        this.flutterAssetManager = flutterAssetManager2;
    }

    public String getAssetFilePathByName(String str) {
        return this.flutterAssetManager.getAssetFilePathByName(str);
    }

    public List<String> list(String str) {
        try {
            String[] list = this.flutterAssetManager.list(str);
            return list == null ? new ArrayList() : Arrays.asList(list);
        } catch (IOException e5) {
            throw new RuntimeException(e5.getMessage());
        }
    }
}
