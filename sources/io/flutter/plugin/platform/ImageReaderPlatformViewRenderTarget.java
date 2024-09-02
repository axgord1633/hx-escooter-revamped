package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.view.TextureRegistry;

public class ImageReaderPlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final int MAX_IMAGES = 3;
    private static final String TAG = "ImageReaderPlatformViewRenderTarget";
    private int bufferHeight = 0;
    private int bufferWidth = 0;
    private final Handler onImageAvailableHandler = new Handler();
    private final ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                image = imageReader.acquireLatestImage();
            } catch (IllegalStateException e5) {
                Log.e(ImageReaderPlatformViewRenderTarget.TAG, "New image available but it could not be acquired: " + e5.toString());
                image = null;
            }
            if (image != null) {
                ImageReaderPlatformViewRenderTarget.this.textureEntry.pushImage(image);
            }
        }
    };
    private ImageReader reader;
    /* access modifiers changed from: private */
    public TextureRegistry.ImageTextureEntry textureEntry;

    public ImageReaderPlatformViewRenderTarget(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.textureEntry = imageTextureEntry;
            return;
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    private void closeReader() {
        if (this.reader != null) {
            this.textureEntry.pushImage((Image) null);
            this.reader.close();
            this.reader = null;
        }
    }

    /* access modifiers changed from: protected */
    public ImageReader createImageReader() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            return createImageReader33();
        }
        if (i5 >= 29) {
            return createImageReader29();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    /* access modifiers changed from: protected */
    public ImageReader createImageReader29() {
        ImageReader a5 = ImageReader.newInstance(this.bufferWidth, this.bufferHeight, 34, 3, 256);
        a5.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
        return a5;
    }

    /* access modifiers changed from: protected */
    public ImageReader createImageReader33() {
        ImageReader.Builder builder = new ImageReader.Builder(this.bufferWidth, this.bufferHeight);
        builder.setMaxImages(3);
        builder.setImageFormat(34);
        builder.setUsage(256);
        ImageReader build = builder.build();
        build.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
        return build;
    }

    public int getHeight() {
        return this.bufferHeight;
    }

    public long getId() {
        return this.textureEntry.id();
    }

    public Surface getSurface() {
        return this.reader.getSurface();
    }

    public int getWidth() {
        return this.bufferWidth;
    }

    public boolean isReleased() {
        return this.textureEntry == null;
    }

    public Canvas lockHardwareCanvas() {
        return getSurface().lockHardwareCanvas();
    }

    public void release() {
        closeReader();
        this.textureEntry = null;
    }

    public void resize(int i5, int i6) {
        if (this.reader == null || this.bufferWidth != i5 || this.bufferHeight != i6) {
            closeReader();
            this.bufferWidth = i5;
            this.bufferHeight = i6;
            this.reader = createImageReader();
        }
    }

    public void unlockCanvasAndPost(Canvas canvas) {
        getSurface().unlockCanvasAndPost(canvas);
    }
}
