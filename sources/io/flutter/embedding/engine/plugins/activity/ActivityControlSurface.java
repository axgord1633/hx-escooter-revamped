package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.f;
import io.flutter.embedding.android.ExclusiveAppComponent;

public interface ActivityControlSurface {
    void attachToActivity(ExclusiveAppComponent<Activity> exclusiveAppComponent, f fVar);

    void detachFromActivity();

    void detachFromActivityForConfigChanges();

    boolean onActivityResult(int i5, int i6, Intent intent);

    void onNewIntent(Intent intent);

    boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr);

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    void onUserLeaveHint();
}
