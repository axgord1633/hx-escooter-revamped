package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class OverlayView extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    private final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }

    private int getCurrentTouchIndex(float f5, float f6) {
        double d5 = (double) this.mTouchPointThreshold;
        int i5 = -1;
        for (int i6 = 0; i6 < 8; i6 += 2) {
            double sqrt = Math.sqrt(Math.pow((double) (f5 - this.mCropGridCorners[i6]), 2.0d) + Math.pow((double) (f6 - this.mCropGridCorners[i6 + 1]), 2.0d));
            if (sqrt < d5) {
                i5 = i6 / 2;
                d5 = sqrt;
            }
        }
        if (this.mFreestyleCropMode != 1 || i5 >= 0 || !this.mCropViewRect.contains(f5, f6)) {
            return i5;
        }
        return 4;
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth((float) (dimensionPixelSize * 3));
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void updateCropViewRect(float f5, float f6) {
        this.mTempRect.set(this.mCropViewRect);
        int i5 = this.mCurrentTouchCornerIndex;
        boolean z4 = true;
        if (i5 == 0) {
            RectF rectF = this.mTempRect;
            RectF rectF2 = this.mCropViewRect;
            rectF.set(f5, f6, rectF2.right, rectF2.bottom);
        } else if (i5 == 1) {
            RectF rectF3 = this.mTempRect;
            RectF rectF4 = this.mCropViewRect;
            rectF3.set(rectF4.left, f6, f5, rectF4.bottom);
        } else if (i5 == 2) {
            RectF rectF5 = this.mTempRect;
            RectF rectF6 = this.mCropViewRect;
            rectF5.set(rectF6.left, rectF6.top, f5, f6);
        } else if (i5 == 3) {
            RectF rectF7 = this.mTempRect;
            RectF rectF8 = this.mCropViewRect;
            rectF7.set(f5, rectF8.top, rectF8.right, f6);
        } else if (i5 == 4) {
            this.mTempRect.offset(f5 - this.mPreviousTouchX, f6 - this.mPreviousTouchY);
            if (this.mTempRect.left > ((float) getLeft()) && this.mTempRect.top > ((float) getTop()) && this.mTempRect.right < ((float) getRight()) && this.mTempRect.bottom < ((float) getBottom())) {
                this.mCropViewRect.set(this.mTempRect);
                updateGridPoints();
                postInvalidate();
                return;
            }
            return;
        }
        boolean z5 = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
        if (this.mTempRect.width() < ((float) this.mCropRectMinSize)) {
            z4 = false;
        }
        RectF rectF9 = this.mCropViewRect;
        rectF9.set(z4 ? this.mTempRect.left : rectF9.left, z5 ? this.mTempRect.top : rectF9.top, z4 ? this.mTempRect.right : rectF9.right, z5 ? this.mTempRect.bottom : rectF9.bottom);
        if (z5 || z4) {
            updateGridPoints();
            postInvalidate();
        }
    }

    private void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void drawCropGrid(Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[((this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4))];
                int i5 = 0;
                for (int i6 = 0; i6 < this.mCropGridRowCount; i6++) {
                    float[] fArr = this.mGridPoints;
                    int i7 = i5 + 1;
                    RectF rectF = this.mCropViewRect;
                    fArr[i5] = rectF.left;
                    int i8 = i7 + 1;
                    float f5 = ((float) i6) + 1.0f;
                    float height = rectF.height() * (f5 / ((float) (this.mCropGridRowCount + 1)));
                    RectF rectF2 = this.mCropViewRect;
                    fArr[i7] = height + rectF2.top;
                    float[] fArr2 = this.mGridPoints;
                    int i9 = i8 + 1;
                    fArr2[i8] = rectF2.right;
                    i5 = i9 + 1;
                    fArr2[i9] = (rectF2.height() * (f5 / ((float) (this.mCropGridRowCount + 1)))) + this.mCropViewRect.top;
                }
                for (int i10 = 0; i10 < this.mCropGridColumnCount; i10++) {
                    float[] fArr3 = this.mGridPoints;
                    int i11 = i5 + 1;
                    float f6 = ((float) i10) + 1.0f;
                    float width = this.mCropViewRect.width() * (f6 / ((float) (this.mCropGridColumnCount + 1)));
                    RectF rectF3 = this.mCropViewRect;
                    fArr3[i5] = width + rectF3.left;
                    float[] fArr4 = this.mGridPoints;
                    int i12 = i11 + 1;
                    fArr4[i11] = rectF3.top;
                    int i13 = i12 + 1;
                    float width2 = rectF3.width() * (f6 / ((float) (this.mCropGridColumnCount + 1)));
                    RectF rectF4 = this.mCropViewRect;
                    fArr4[i12] = width2 + rectF4.left;
                    i5 = i13 + 1;
                    this.mGridPoints[i13] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.mGridPoints;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF5 = this.mTempRect;
            int i14 = this.mCropRectCornerTouchAreaLineLength;
            rectF5.inset((float) i14, (float) (-i14));
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF6 = this.mTempRect;
            int i15 = this.mCropRectCornerTouchAreaLineLength;
            rectF6.inset((float) (-i15), (float) i15);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    /* access modifiers changed from: protected */
    public void init() {
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        if (z4) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4 = false;
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int currentTouchIndex = getCurrentTouchIndex(x4, y4);
                this.mCurrentTouchCornerIndex = currentTouchIndex;
                if (currentTouchIndex != -1) {
                    z4 = true;
                }
                if (!z4) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                } else if (this.mPreviousTouchX < CropImageView.DEFAULT_ASPECT_RATIO) {
                    this.mPreviousTouchX = x4;
                    this.mPreviousTouchY = y4;
                }
                return z4;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float min = Math.min(Math.max(x4, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
                float min2 = Math.min(Math.max(y4, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
                updateCropViewRect(min, min2);
                this.mPreviousTouchX = min;
                this.mPreviousTouchY = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void processStyledAttributes(TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedColor = color;
        this.mDimmedStrokePaint.setColor(color);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(1.0f);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean z4) {
        this.mCircleDimmedLayer = z4;
    }

    public void setCropFrameColor(int i5) {
        this.mCropFramePaint.setColor(i5);
    }

    public void setCropFrameStrokeWidth(int i5) {
        this.mCropFramePaint.setStrokeWidth((float) i5);
    }

    public void setCropGridColor(int i5) {
        this.mCropGridPaint.setColor(i5);
    }

    public void setCropGridColumnCount(int i5) {
        this.mCropGridColumnCount = i5;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(int i5) {
        this.mCropGridRowCount = i5;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(int i5) {
        this.mCropGridPaint.setStrokeWidth((float) i5);
    }

    public void setDimmedColor(int i5) {
        this.mDimmedColor = i5;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z4) {
        this.mFreestyleCropMode = z4 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i5) {
        this.mFreestyleCropMode = i5;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z4) {
        this.mShowCropFrame = z4;
    }

    public void setShowCropGrid(boolean z4) {
        this.mShowCropGrid = z4;
    }

    public void setTargetAspectRatio(float f5) {
        this.mTargetAspectRatio = f5;
        if (this.mThisWidth > 0) {
            setupCropBounds();
            postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public void setupCropBounds() {
        int i5 = this.mThisWidth;
        float f5 = this.mTargetAspectRatio;
        int i6 = (int) (((float) i5) / f5);
        int i7 = this.mThisHeight;
        if (i6 > i7) {
            int i8 = (int) (((float) i7) * f5);
            int i9 = (i5 - i8) / 2;
            this.mCropViewRect.set((float) (getPaddingLeft() + i9), (float) getPaddingTop(), (float) (getPaddingLeft() + i8 + i9), (float) (getPaddingTop() + this.mThisHeight));
        } else {
            int i10 = (i7 - i6) / 2;
            this.mCropViewRect.set((float) getPaddingLeft(), (float) (getPaddingTop() + i10), (float) (getPaddingLeft() + this.mThisWidth), (float) (getPaddingTop() + i6 + i10));
        }
        OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }
}
