package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
import java.nio.ByteBuffer;
import java.util.Locale;

public class FlutterImageView extends View implements RenderSurface {
    private static final String TAG = "FlutterImageView";
    private Bitmap currentBitmap;
    private Image currentImage;
    private FlutterRenderer flutterRenderer;
    private ImageReader imageReader;
    private boolean isAttachedToFlutterRenderer;
    private SurfaceKind kind;

    /* renamed from: io.flutter.embedding.android.FlutterImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.embedding.android.FlutterImageView$SurfaceKind[] r0 = io.flutter.embedding.android.FlutterImageView.SurfaceKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind = r0
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = io.flutter.embedding.android.FlutterImageView.SurfaceKind.background     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = io.flutter.embedding.android.FlutterImageView.SurfaceKind.overlay     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public enum SurfaceKind {
        background,
        overlay
    }

    public FlutterImageView(Context context) {
        this(context, 1, 1, SurfaceKind.background);
    }

    public FlutterImageView(Context context, int i5, int i6, SurfaceKind surfaceKind) {
        this(context, createImageReader(i5, i6), surfaceKind);
    }

    FlutterImageView(Context context, ImageReader imageReader2, SurfaceKind surfaceKind) {
        super(context, (AttributeSet) null);
        this.isAttachedToFlutterRenderer = false;
        this.imageReader = imageReader2;
        this.kind = surfaceKind;
        init();
    }

    public FlutterImageView(Context context, AttributeSet attributeSet) {
        this(context, 1, 1, SurfaceKind.background);
    }

    private void closeCurrentImage() {
        Image image = this.currentImage;
        if (image != null) {
            image.close();
            this.currentImage = null;
        }
    }

    private static ImageReader createImageReader(int i5, int i6) {
        int i7;
        int i8;
        if (i5 <= 0) {
            logW("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i5));
            i7 = 1;
        } else {
            i7 = i5;
        }
        if (i6 <= 0) {
            logW("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i6));
            i8 = 1;
        } else {
            i8 = i6;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i7, i8, 1, 3, 768) : ImageReader.newInstance(i7, i8, 1, 3);
    }

    private void init() {
        setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    private static void logW(String str, Object... objArr) {
        Log.w(TAG, String.format(Locale.US, str, objArr));
    }

    private void updateCurrentBitmap() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer a5 = this.currentImage.getHardwareBuffer();
            this.currentBitmap = Bitmap.wrapHardwareBuffer(a5, ColorSpace.get(ColorSpace.Named.SRGB));
            a5.close();
            return;
        }
        Image.Plane[] planes = this.currentImage.getPlanes();
        if (planes.length == 1) {
            Image.Plane plane = planes[0];
            int rowStride = plane.getRowStride() / plane.getPixelStride();
            int height = this.currentImage.getHeight();
            Bitmap bitmap = this.currentBitmap;
            if (!(bitmap != null && bitmap.getWidth() == rowStride && this.currentBitmap.getHeight() == height)) {
                this.currentBitmap = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
            }
            ByteBuffer buffer = plane.getBuffer();
            buffer.rewind();
            this.currentBitmap.copyPixelsFromBuffer(buffer);
        }
    }

    public boolean acquireLatestImage() {
        if (!this.isAttachedToFlutterRenderer) {
            return false;
        }
        Image acquireLatestImage = this.imageReader.acquireLatestImage();
        if (acquireLatestImage != null) {
            closeCurrentImage();
            this.currentImage = acquireLatestImage;
            invalidate();
        }
        return acquireLatestImage != null;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer2) {
        if (AnonymousClass1.$SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[this.kind.ordinal()] == 1) {
            flutterRenderer2.swapSurface(this.imageReader.getSurface());
            flutterRenderer2.SetRenderingToImageView(true);
        }
        setAlpha(1.0f);
        this.flutterRenderer = flutterRenderer2;
        this.isAttachedToFlutterRenderer = true;
    }

    public void closeImageReader() {
        this.imageReader.close();
    }

    public void detachFromRenderer() {
        if (this.isAttachedToFlutterRenderer) {
            setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            acquireLatestImage();
            this.currentBitmap = null;
            closeCurrentImage();
            invalidate();
            this.isAttachedToFlutterRenderer = false;
            if (this.kind == SurfaceKind.background) {
                this.flutterRenderer.SetRenderingToImageView(false);
            }
        }
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    public ImageReader getImageReader() {
        return this.imageReader;
    }

    public Surface getSurface() {
        return this.imageReader.getSurface();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.currentImage != null) {
            updateCurrentBitmap();
        }
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        if (!(i5 == this.imageReader.getWidth() && i6 == this.imageReader.getHeight()) && this.kind == SurfaceKind.background && this.isAttachedToFlutterRenderer) {
            resizeIfNeeded(i5, i6);
            this.flutterRenderer.swapSurface(this.imageReader.getSurface());
        }
    }

    public void pause() {
    }

    public void resizeIfNeeded(int i5, int i6) {
        if (this.flutterRenderer != null) {
            if (i5 != this.imageReader.getWidth() || i6 != this.imageReader.getHeight()) {
                closeCurrentImage();
                closeImageReader();
                this.imageReader = createImageReader(i5, i6);
            }
        }
    }
}
