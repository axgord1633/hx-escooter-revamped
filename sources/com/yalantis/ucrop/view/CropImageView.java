package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    /* access modifiers changed from: private */
    public final RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix;
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable;

    private static class WrapCropBoundsRunnable implements Runnable {
        private final float mCenterDiffX;
        private final float mCenterDiffY;
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final long mDurationMs;
        private final float mOldScale;
        private final float mOldX;
        private final float mOldY;
        private final long mStartTime = System.currentTimeMillis();
        private final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j5, float f5, float f6, float f7, float f8, float f9, float f10, boolean z4) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j5;
            this.mOldX = f5;
            this.mOldY = f6;
            this.mCenterDiffX = f7;
            this.mCenterDiffY = f8;
            this.mOldScale = f9;
            this.mDeltaScale = f10;
            this.mWillBeImageInBoundsAfterTranslate = z4;
        }

        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float easeOut = CubicEasing.easeOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mCenterDiffX, (float) this.mDurationMs);
                float easeOut2 = CubicEasing.easeOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mCenterDiffY, (float) this.mDurationMs);
                float easeInOut = CubicEasing.easeInOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mDeltaScale, (float) this.mDurationMs);
                if (min < ((float) this.mDurationMs)) {
                    float[] fArr = cropImageView.mCurrentImageCenter;
                    cropImageView.postTranslate(easeOut - (fArr[0] - this.mOldX), easeOut2 - (fArr[1] - this.mOldY));
                    if (!this.mWillBeImageInBoundsAfterTranslate) {
                        cropImageView.zoomInImage(this.mOldScale + easeInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                    }
                    if (!cropImageView.isImageWrapCropBounds()) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    private static class ZoomImageToPosition implements Runnable {
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final float mDestX;
        private final float mDestY;
        private final long mDurationMs;
        private final float mOldScale;
        private final long mStartTime = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j5, float f5, float f6, float f7, float f8) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j5;
            this.mOldScale = f5;
            this.mDeltaScale = f6;
            this.mDestX = f7;
            this.mDestY = f8;
        }

        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float easeInOut = CubicEasing.easeInOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mDeltaScale, (float) this.mDurationMs);
                if (min < ((float) this.mDurationMs)) {
                    cropImageView.zoomInImage(this.mOldScale + easeInOut, this.mDestX, this.mDestY);
                    cropImageView.post(this);
                    return;
                }
                cropImageView.setImageToWrapCropBounds();
            }
        }
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500;
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArr = this.mCurrentImageCorners;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        this.mTempMatrix.mapPoints(cornersFromRect);
        RectF trapToRect = RectUtils.trapToRect(copyOf);
        RectF trapToRect2 = RectUtils.trapToRect(cornersFromRect);
        float f5 = trapToRect.left - trapToRect2.left;
        float f6 = trapToRect.top - trapToRect2.top;
        float f7 = trapToRect.right - trapToRect2.right;
        float f8 = trapToRect.bottom - trapToRect2.bottom;
        float[] fArr2 = new float[4];
        if (f5 <= DEFAULT_ASPECT_RATIO) {
            f5 = 0.0f;
        }
        fArr2[0] = f5;
        if (f6 <= DEFAULT_ASPECT_RATIO) {
            f6 = 0.0f;
        }
        fArr2[1] = f6;
        if (f7 >= DEFAULT_ASPECT_RATIO) {
            f7 = 0.0f;
        }
        fArr2[2] = f7;
        if (f8 >= DEFAULT_ASPECT_RATIO) {
            f8 = 0.0f;
        }
        fArr2[3] = f8;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapPoints(fArr2);
        return fArr2;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            calculateImageScaleBounds((float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
    }

    private void calculateImageScaleBounds(float f5, float f6) {
        float min = Math.min(Math.min(this.mCropRect.width() / f5, this.mCropRect.width() / f6), Math.min(this.mCropRect.height() / f6, this.mCropRect.height() / f5));
        this.mMinScale = min;
        this.mMaxScale = min * this.mMaxScaleMultiplier;
    }

    private void setupInitialImagePosition(float f5, float f6) {
        float width = this.mCropRect.width();
        float height = this.mCropRect.height();
        float max = Math.max(this.mCropRect.width() / f5, this.mCropRect.height() / f6);
        RectF rectF = this.mCropRect;
        float f7 = ((height - (f6 * max)) / 2.0f) + rectF.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(max, max);
        this.mCurrentImageMatrix.postTranslate(((width - (f5 * max)) / 2.0f) + rectF.left, f7);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(Bitmap.CompressFormat compressFormat, int i5, BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        ImageState imageState = new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle());
        CropParameters cropParameters = new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, i5, getImageInputPath(), getImageOutputPath(), getExifInfo());
        cropParameters.setContentImageInputUri(getImageInputUri());
        cropParameters.setContentImageOutputUri(getImageOutputUri());
        new BitmapCropTask(getContext(), getViewBitmap(), imageState, cropParameters, bitmapCropCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    /* access modifiers changed from: protected */
    public boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    /* access modifiers changed from: protected */
    public boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(copyOf);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return RectUtils.trapToRect(copyOf).contains(RectUtils.trapToRect(cornersFromRect));
    }

    /* access modifiers changed from: protected */
    public void onImageLaidOut() {
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (this.mTargetAspectRatio == DEFAULT_ASPECT_RATIO) {
                this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
            }
            int i5 = this.mThisWidth;
            float f5 = this.mTargetAspectRatio;
            int i6 = (int) (((float) i5) / f5);
            int i7 = this.mThisHeight;
            if (i6 > i7) {
                int i8 = (int) (((float) i7) * f5);
                int i9 = (i5 - i8) / 2;
                this.mCropRect.set((float) i9, DEFAULT_ASPECT_RATIO, (float) (i8 + i9), (float) i7);
            } else {
                int i10 = (i7 - i6) / 2;
                this.mCropRect.set(DEFAULT_ASPECT_RATIO, (float) i10, (float) i5, (float) (i6 + i10));
            }
            calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
            setupInitialImagePosition(intrinsicWidth, intrinsicHeight);
            CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
            if (cropBoundsChangeListener != null) {
                cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
            }
            TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onScale(getCurrentScale());
                this.mTransformImageListener.onRotate(getCurrentAngle());
            }
        }
    }

    public void postRotate(float f5) {
        postRotate(f5, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void postScale(float f5, float f6, float f7) {
        if ((f5 > 1.0f && getCurrentScale() * f5 <= getMaxScale()) || (f5 < 1.0f && getCurrentScale() * f5 >= getMinScale())) {
            super.postScale(f5, f6, f7);
        }
    }

    /* access modifiers changed from: protected */
    public void processStyledAttributes(TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, DEFAULT_ASPECT_RATIO));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, DEFAULT_ASPECT_RATIO));
        if (abs == DEFAULT_ASPECT_RATIO || abs2 == DEFAULT_ASPECT_RATIO) {
            this.mTargetAspectRatio = DEFAULT_ASPECT_RATIO;
        } else {
            this.mTargetAspectRatio = abs / abs2;
        }
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - ((float) getPaddingLeft()), rectF.top - ((float) getPaddingTop()), rectF.right - ((float) getPaddingRight()), rectF.bottom - ((float) getPaddingBottom()));
        calculateImageScaleBounds();
        setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z4) {
        float f5;
        float f6;
        float f7;
        if (this.mBitmapLaidOut && !isImageWrapCropBounds()) {
            float[] fArr = this.mCurrentImageCenter;
            float f8 = fArr[0];
            float f9 = fArr[1];
            float currentScale = getCurrentScale();
            float centerX = this.mCropRect.centerX() - f8;
            float centerY = this.mCropRect.centerY() - f9;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(centerX, centerY);
            float[] fArr2 = this.mCurrentImageCorners;
            float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
            this.mTempMatrix.mapPoints(copyOf);
            boolean isImageWrapCropBounds = isImageWrapCropBounds(copyOf);
            if (isImageWrapCropBounds) {
                float[] calculateImageIndents = calculateImageIndents();
                f6 = -(calculateImageIndents[1] + calculateImageIndents[3]);
                f7 = -(calculateImageIndents[0] + calculateImageIndents[2]);
                f5 = 0.0f;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(getCurrentAngle());
                this.mTempMatrix.mapRect(rectF);
                float[] rectSidesFromCorners = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
                f7 = centerX;
                f5 = (Math.max(rectF.width() / rectSidesFromCorners[0], rectF.height() / rectSidesFromCorners[1]) * currentScale) - currentScale;
                f6 = centerY;
            }
            if (z4) {
                WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f8, f9, f7, f6, currentScale, f5, isImageWrapCropBounds);
                this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
                post(wrapCropBoundsRunnable);
                return;
            }
            postTranslate(f7, f6);
            if (!isImageWrapCropBounds) {
                zoomInImage(currentScale + f5, this.mCropRect.centerX(), this.mCropRect.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long j5) {
        if (j5 > 0) {
            this.mImageToWrapCropBoundsAnimDuration = j5;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(int i5) {
        this.mMaxResultImageSizeX = i5;
    }

    public void setMaxResultImageSizeY(int i5) {
        this.mMaxResultImageSizeY = i5;
    }

    public void setMaxScaleMultiplier(float f5) {
        this.mMaxScaleMultiplier = f5;
    }

    public void setTargetAspectRatio(float f5) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.mTargetAspectRatio = f5;
            return;
        }
        if (f5 == DEFAULT_ASPECT_RATIO) {
            f5 = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        }
        this.mTargetAspectRatio = f5;
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    /* access modifiers changed from: protected */
    public void zoomImageToPosition(float f5, float f6, float f7, long j5) {
        if (f5 > getMaxScale()) {
            f5 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j5, currentScale, f5 - currentScale, f6, f7);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public void zoomInImage(float f5) {
        zoomInImage(f5, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f5, float f6, float f7) {
        if (f5 <= getMaxScale()) {
            postScale(f5 / getCurrentScale(), f6, f7);
        }
    }

    public void zoomOutImage(float f5) {
        zoomOutImage(f5, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f5, float f6, float f7) {
        if (f5 >= getMinScale()) {
            postScale(f5 / getCurrentScale(), f6, f7);
        }
    }
}
