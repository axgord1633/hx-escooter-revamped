package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.view.TextureRegistry;
import java.util.concurrent.atomic.AtomicLong;

public class SurfaceTexturePlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final String TAG = "SurfaceTexturePlatformViewRenderTarget";
    private int bufferHeight = 0;
    private int bufferWidth = 0;
    private final TextureRegistry.OnFrameConsumedListener frameConsumedListener;
    /* access modifiers changed from: private */
    public final AtomicLong pendingFramesCount = new AtomicLong(0);
    /* access modifiers changed from: private */
    public boolean shouldRecreateSurfaceForLowMemory;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TextureRegistry.SurfaceTextureEntry surfaceTextureEntry;
    private final TextureRegistry.OnTrimMemoryListener trimMemoryListener;

    public SurfaceTexturePlatformViewRenderTarget(TextureRegistry.SurfaceTextureEntry surfaceTextureEntry2) {
        AnonymousClass1 r12 = new TextureRegistry.OnFrameConsumedListener() {
            public void onFrameConsumed() {
                if (Build.VERSION.SDK_INT == 29) {
                    SurfaceTexturePlatformViewRenderTarget.this.pendingFramesCount.decrementAndGet();
                }
            }
        };
        this.frameConsumedListener = r12;
        this.shouldRecreateSurfaceForLowMemory = false;
        AnonymousClass2 r02 = new TextureRegistry.OnTrimMemoryListener() {
            public void onTrimMemory(int i5) {
                if (i5 == 80 && Build.VERSION.SDK_INT >= 29) {
                    boolean unused = SurfaceTexturePlatformViewRenderTarget.this.shouldRecreateSurfaceForLowMemory = true;
                }
            }
        };
        this.trimMemoryListener = r02;
        this.surfaceTextureEntry = surfaceTextureEntry2;
        this.surfaceTexture = surfaceTextureEntry2.surfaceTexture();
        surfaceTextureEntry2.setOnFrameConsumedListener(r12);
        surfaceTextureEntry2.setOnTrimMemoryListener(r02);
        init();
    }

    private void init() {
        int i5;
        int i6 = this.bufferWidth;
        if (i6 > 0 && (i5 = this.bufferHeight) > 0) {
            this.surfaceTexture.setDefaultBufferSize(i6, i5);
        }
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
        this.surface = createSurface();
        Canvas lockHardwareCanvas = lockHardwareCanvas();
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } finally {
            unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    private void onFrameProduced() {
        if (Build.VERSION.SDK_INT == 29) {
            this.pendingFramesCount.incrementAndGet();
        }
    }

    private void recreateSurfaceIfNeeded() {
        if (this.shouldRecreateSurfaceForLowMemory) {
            Surface surface2 = this.surface;
            if (surface2 != null) {
                surface2.release();
                this.surface = null;
            }
            this.surface = createSurface();
            this.shouldRecreateSurfaceForLowMemory = false;
        }
    }

    /* access modifiers changed from: protected */
    public Surface createSurface() {
        return new Surface(this.surfaceTexture);
    }

    public int getHeight() {
        return this.bufferHeight;
    }

    public long getId() {
        return this.surfaceTextureEntry.id();
    }

    public Surface getSurface() {
        recreateSurfaceIfNeeded();
        return this.surface;
    }

    public int getWidth() {
        return this.bufferWidth;
    }

    public boolean isReleased() {
        return this.surfaceTexture == null;
    }

    public Canvas lockHardwareCanvas() {
        recreateSurfaceIfNeeded();
        if (Build.VERSION.SDK_INT == 29 && this.pendingFramesCount.get() > 0) {
            return null;
        }
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 == null || surfaceTexture2.isReleased()) {
            Log.e(TAG, "Invalid RenderTarget: null or already released SurfaceTexture");
            return null;
        }
        onFrameProduced();
        return this.surface.lockHardwareCanvas();
    }

    public void release() {
        this.surfaceTexture = null;
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
    }

    public void resize(int i5, int i6) {
        this.bufferWidth = i5;
        this.bufferHeight = i6;
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.setDefaultBufferSize(i5, i6);
        }
    }

    public void unlockCanvasAndPost(Canvas canvas) {
        this.surface.unlockCanvasAndPost(canvas);
    }
}
