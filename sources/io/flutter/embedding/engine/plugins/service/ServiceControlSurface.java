package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.f;

public interface ServiceControlSurface {
    void attachToService(Service service, f fVar, boolean z4);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
