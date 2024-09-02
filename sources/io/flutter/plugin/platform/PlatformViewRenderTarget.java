package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.view.Surface;

public interface PlatformViewRenderTarget {
    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    boolean isReleased();

    Canvas lockHardwareCanvas();

    void release();

    void resize(int i5, int i6);

    void unlockCanvasAndPost(Canvas canvas);
}
