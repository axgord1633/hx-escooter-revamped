package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;

public interface TextureRegistry {

    public interface ImageTextureEntry extends TextureEntry {
        Image acquireLatestImage();

        long id();

        void pushImage(Image image);

        void release();
    }

    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    public interface OnTrimMemoryListener {
        void onTrimMemory(int i5);
    }

    public interface SurfaceTextureEntry extends TextureEntry {
        long id();

        void release();

        void setOnFrameConsumedListener(OnFrameConsumedListener onFrameConsumedListener);

        void setOnTrimMemoryListener(OnTrimMemoryListener onTrimMemoryListener);

        SurfaceTexture surfaceTexture();
    }

    public interface TextureEntry {
        long id();

        void release();
    }

    ImageTextureEntry createImageTexture();

    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i5);

    SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture);
}
