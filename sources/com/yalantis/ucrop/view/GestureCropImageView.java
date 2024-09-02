package com.yalantis.ucrop.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;

public class GestureCropImageView extends CropImageView {
    private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
    private int mDoubleTapScaleSteps;
    private GestureDetector mGestureDetector;
    private boolean mIsGestureEnabled;
    private boolean mIsRotateEnabled;
    private boolean mIsScaleEnabled;
    /* access modifiers changed from: private */
    public float mMidPntX;
    /* access modifiers changed from: private */
    public float mMidPntY;
    private RotationGestureDetector mRotateDetector;
    private ScaleGestureDetector mScaleDetector;

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.zoomImageToPosition(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200);
            return super.onDoubleTap(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
            GestureCropImageView.this.postTranslate(-f5, -f6);
            return true;
        }
    }

    private class RotateListener extends RotationGestureDetector.SimpleOnRotationGestureListener {
        private RotateListener() {
        }

        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            GestureCropImageView.this.postRotate(rotationGestureDetector.getAngle(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
            return true;
        }
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.postScale(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mIsGestureEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mIsGestureEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    private void setupGestureListeners() {
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(), (Handler) null, true);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        this.mRotateDetector = new RotationGestureDetector(new RotateListener());
    }

    public int getDoubleTapScaleSteps() {
        return this.mDoubleTapScaleSteps;
    }

    /* access modifiers changed from: protected */
    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow((double) (getMaxScale() / getMinScale()), (double) (1.0f / ((float) this.mDoubleTapScaleSteps))));
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        setupGestureListeners();
    }

    public boolean isGestureEnabled() {
        return this.mIsGestureEnabled;
    }

    public boolean isRotateEnabled() {
        return this.mIsRotateEnabled;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mMidPntX = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.mMidPntY = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        if (this.mIsGestureEnabled) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsScaleEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsRotateEnabled) {
            this.mRotateDetector.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i5) {
        this.mDoubleTapScaleSteps = i5;
    }

    public void setGestureEnabled(boolean z4) {
        this.mIsGestureEnabled = z4;
    }

    public void setRotateEnabled(boolean z4) {
        this.mIsRotateEnabled = z4;
    }

    public void setScaleEnabled(boolean z4) {
        this.mIsScaleEnabled = z4;
    }
}
