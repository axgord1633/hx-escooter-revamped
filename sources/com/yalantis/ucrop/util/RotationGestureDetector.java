package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import com.yalantis.ucrop.view.CropImageView;

public class RotationGestureDetector {
    private static final int INVALID_POINTER_INDEX = -1;
    private float fX;
    private float fY;
    private float mAngle;
    private boolean mIsFirstTouch;
    private OnRotationGestureListener mListener;
    private int mPointerIndex1 = -1;
    private int mPointerIndex2 = -1;
    private float sX;
    private float sY;

    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);
    }

    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
    }

    private float calculateAngleBetweenLines(float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        return calculateAngleDelta((float) Math.toDegrees((double) ((float) Math.atan2((double) (f6 - f8), (double) (f5 - f7)))), (float) Math.toDegrees((double) ((float) Math.atan2((double) (f10 - f12), (double) (f9 - f11)))));
    }

    private float calculateAngleDelta(float f5, float f6) {
        float f7;
        float f8 = (f6 % 360.0f) - (f5 % 360.0f);
        this.mAngle = f8;
        if (f8 < -180.0f) {
            f7 = f8 + 360.0f;
        } else {
            if (f8 > 180.0f) {
                f7 = f8 - 360.0f;
            }
            return this.mAngle;
        }
        this.mAngle = f7;
        return this.mAngle;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.mPointerIndex1 = -1;
            } else if (actionMasked != 2) {
                if (actionMasked == 5) {
                    this.fX = motionEvent.getX();
                    this.fY = motionEvent.getY();
                    this.mPointerIndex2 = motionEvent2.findPointerIndex(motionEvent2.getPointerId(motionEvent.getActionIndex()));
                } else if (actionMasked == 6) {
                    this.mPointerIndex2 = -1;
                }
            } else if (!(this.mPointerIndex1 == -1 || this.mPointerIndex2 == -1 || motionEvent.getPointerCount() <= this.mPointerIndex2)) {
                float x4 = motionEvent2.getX(this.mPointerIndex1);
                float y4 = motionEvent2.getY(this.mPointerIndex1);
                float x5 = motionEvent2.getX(this.mPointerIndex2);
                float y5 = motionEvent2.getY(this.mPointerIndex2);
                if (this.mIsFirstTouch) {
                    this.mAngle = CropImageView.DEFAULT_ASPECT_RATIO;
                    this.mIsFirstTouch = false;
                } else {
                    calculateAngleBetweenLines(this.fX, this.fY, this.sX, this.sY, x5, y5, x4, y4);
                }
                OnRotationGestureListener onRotationGestureListener = this.mListener;
                if (onRotationGestureListener != null) {
                    onRotationGestureListener.onRotation(this);
                }
                this.fX = x5;
                this.fY = y5;
                this.sX = x4;
                this.sY = y4;
            }
            return true;
        }
        this.sX = motionEvent.getX();
        this.sY = motionEvent.getY();
        this.mPointerIndex1 = motionEvent2.findPointerIndex(motionEvent2.getPointerId(0));
        this.mAngle = CropImageView.DEFAULT_ASPECT_RATIO;
        this.mIsFirstTouch = true;
        return true;
    }
}
