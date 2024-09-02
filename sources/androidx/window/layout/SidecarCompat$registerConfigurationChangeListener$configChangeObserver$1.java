package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import androidx.window.layout.ExtensionInterfaceCompat;
import kotlin.jvm.internal.k;

public final class SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 implements ComponentCallbacks {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ SidecarCompat this$0;

    SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(SidecarCompat sidecarCompat, Activity activity) {
        this.this$0 = sidecarCompat;
        this.$activity = activity;
    }

    public void onConfigurationChanged(Configuration configuration) {
        k.e(configuration, "newConfig");
        ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = this.this$0.extensionCallback;
        if (access$getExtensionCallback$p != null) {
            Activity activity = this.$activity;
            access$getExtensionCallback$p.onWindowLayoutChanged(activity, this.this$0.getWindowLayoutInfo(activity));
        }
    }

    public void onLowMemory() {
    }
}
