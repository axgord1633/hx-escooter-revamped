package io.flutter.plugins.webviewflutter;

import android.webkit.WebStorage;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class WebStorageHostApiImpl implements GeneratedAndroidWebView.WebStorageHostApi {
    private final InstanceManager instanceManager;
    private final WebStorageCreator webStorageCreator;

    public static class WebStorageCreator {
        public WebStorage createWebStorage() {
            return WebStorage.getInstance();
        }
    }

    public WebStorageHostApiImpl(InstanceManager instanceManager2, WebStorageCreator webStorageCreator2) {
        this.instanceManager = instanceManager2;
        this.webStorageCreator = webStorageCreator2;
    }

    public void create(Long l5) {
        this.instanceManager.addDartCreatedInstance(this.webStorageCreator.createWebStorage(), l5.longValue());
    }

    public void deleteAllData(Long l5) {
        ((WebStorage) this.instanceManager.getInstance(l5.longValue())).deleteAllData();
    }
}
