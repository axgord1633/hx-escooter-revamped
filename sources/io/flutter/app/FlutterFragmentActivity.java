package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.e;
import io.flutter.app.FlutterActivityDelegate;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

@Deprecated
public class FlutterFragmentActivity extends e implements FlutterView.Provider, PluginRegistry, FlutterActivityDelegate.ViewFactory {
    private final FlutterActivityDelegate delegate;
    private final FlutterActivityEvents eventDelegate;
    private final PluginRegistry pluginRegistry;
    private final FlutterView.Provider viewProvider;

    public FlutterFragmentActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.delegate = flutterActivityDelegate;
        this.eventDelegate = flutterActivityDelegate;
        this.viewProvider = flutterActivityDelegate;
        this.pluginRegistry = flutterActivityDelegate;
    }

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public FlutterView getFlutterView() {
        return this.viewProvider.getFlutterView();
    }

    public final boolean hasPlugin(String str) {
        return this.pluginRegistry.hasPlugin(str);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (!this.eventDelegate.onActivityResult(i5, i6, intent)) {
            super.onActivityResult(i5, i6, intent);
        }
    }

    public void onBackPressed() {
        if (!this.eventDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eventDelegate.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eventDelegate.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.eventDelegate.onDestroy();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.eventDelegate.onLowMemory();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.eventDelegate.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.eventDelegate.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.eventDelegate.onPostResume();
    }

    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        this.eventDelegate.onRequestPermissionsResult(i5, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.eventDelegate.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.eventDelegate.onStop();
        super.onStop();
    }

    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        this.eventDelegate.onTrimMemory(i5);
    }

    public void onUserLeaveHint() {
        this.eventDelegate.onUserLeaveHint();
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        this.eventDelegate.onWindowFocusChanged(z4);
    }

    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.pluginRegistry.registrarFor(str);
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    public final <T> T valuePublishedByPlugin(String str) {
        return this.pluginRegistry.valuePublishedByPlugin(str);
    }
}
