package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.lifecycle.f;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

public class FlutterLifecycleAdapter {
    public static f getActivityLifecycle(ActivityPluginBinding activityPluginBinding) {
        return ((HiddenLifecycleReference) activityPluginBinding.getLifecycle()).getLifecycle();
    }
}
