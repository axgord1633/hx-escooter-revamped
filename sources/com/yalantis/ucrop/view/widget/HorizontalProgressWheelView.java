package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.a;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;

public class HorizontalProgressWheelView extends View {
    private final Rect mCanvasClipBounds;
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private Paint mProgressMiddleLinePaint;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    public interface ScrollingListener {
        void onScroll(float f5, float f6);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mCanvasClipBounds = new Rect();
        init();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.mCanvasClipBounds = new Rect();
    }

    private void init() {
        this.mMiddleLineColor = a.b(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.mProgressLinePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth((float) this.mProgressLineWidth);
        this.mProgressLinePaint.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.mProgressLinePaint);
        this.mProgressMiddleLinePaint = paint2;
        paint2.setColor(this.mMiddleLineColor);
        this.mProgressMiddleLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressMiddleLinePaint.setStrokeWidth((float) getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    private void onScrollEvent(MotionEvent motionEvent, float f5) {
        this.mTotalScrollDistance -= f5;
        postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        ScrollingListener scrollingListener = this.mScrollingListener;
        if (scrollingListener != null) {
            scrollingListener.onScroll(-f5, this.mTotalScrollDistance);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint;
        float f5;
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int width = this.mCanvasClipBounds.width();
        int i5 = this.mProgressLineWidth;
        int i6 = this.mProgressLineMargin;
        int i7 = width / (i5 + i6);
        float f6 = this.mTotalScrollDistance % ((float) (i6 + i5));
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = i7 / 4;
            if (i8 < i9) {
                paint = this.mProgressLinePaint;
                f5 = (float) i8;
            } else if (i8 > (i7 * 3) / 4) {
                paint = this.mProgressLinePaint;
                f5 = (float) (i7 - i8);
            } else {
                this.mProgressLinePaint.setAlpha(255);
                float f7 = -f6;
                Rect rect = this.mCanvasClipBounds;
                float f8 = ((float) rect.left) + f7 + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i8));
                float centerY = ((float) rect.centerY()) - (((float) this.mProgressLineHeight) / 4.0f);
                Rect rect2 = this.mCanvasClipBounds;
                canvas.drawLine(f8, centerY, f7 + ((float) rect2.left) + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i8)), ((float) rect2.centerY()) + (((float) this.mProgressLineHeight) / 4.0f), this.mProgressLinePaint);
            }
            paint.setAlpha((int) ((f5 / ((float) i9)) * 255.0f));
            float f72 = -f6;
            Rect rect3 = this.mCanvasClipBounds;
            float f82 = ((float) rect3.left) + f72 + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i8));
            float centerY2 = ((float) rect3.centerY()) - (((float) this.mProgressLineHeight) / 4.0f);
            Rect rect22 = this.mCanvasClipBounds;
            canvas.drawLine(f82, centerY2, f72 + ((float) rect22.left) + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i8)), ((float) rect22.centerY()) + (((float) this.mProgressLineHeight) / 4.0f), this.mProgressLinePaint);
        }
        float centerX = (float) this.mCanvasClipBounds.centerX();
        float centerY3 = ((float) this.mCanvasClipBounds.centerY()) - (((float) this.mProgressLineHeight) / 2.0f);
        Canvas canvas2 = canvas;
        float f9 = centerY3;
        canvas2.drawLine(centerX, f9, (float) this.mCanvasClipBounds.centerX(), (((float) this.mProgressLineHeight) / 2.0f) + ((float) this.mCanvasClipBounds.centerY()), this.mProgressMiddleLinePaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchedPosition = motionEvent.getX();
        } else if (action == 1) {
            ScrollingListener scrollingListener = this.mScrollingListener;
            if (scrollingListener != null) {
                this.mScrollStarted = false;
                scrollingListener.onScrollEnd();
            }
        } else if (action == 2) {
            float x4 = motionEvent.getX() - this.mLastTouchedPosition;
            if (x4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                if (!this.mScrollStarted) {
                    this.mScrollStarted = true;
                    ScrollingListener scrollingListener2 = this.mScrollingListener;
                    if (scrollingListener2 != null) {
                        scrollingListener2.onScrollStart();
                    }
                }
                onScrollEvent(motionEvent, x4);
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i5) {
        this.mMiddleLineColor = i5;
        this.mProgressMiddleLinePaint.setColor(i5);
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }
}
