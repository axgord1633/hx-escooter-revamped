package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.h0;
import androidx.core.content.a;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Locale;

public class AspectRatioTextView extends h0 {
    private final float MARGIN_MULTIPLIER;
    private float mAspectRatio;
    private String mAspectRatioTitle;
    private float mAspectRatioX;
    private float mAspectRatioY;
    private final Rect mCanvasClipBounds;
    private Paint mDotPaint;
    private int mDotSize;

    public AspectRatioTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    private void applyActiveColor(int i5) {
        Paint paint = this.mDotPaint;
        if (paint != null) {
            paint.setColor(i5);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i5, a.b(getContext(), R.color.ucrop_color_widget)}));
    }

    private void init(TypedArray typedArray) {
        setGravity(1);
        this.mAspectRatioTitle = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.mAspectRatioX = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, CropImageView.DEFAULT_ASPECT_RATIO);
        float f5 = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, CropImageView.DEFAULT_ASPECT_RATIO);
        this.mAspectRatioY = f5;
        float f6 = this.mAspectRatioX;
        if (f6 == CropImageView.DEFAULT_ASPECT_RATIO || f5 == CropImageView.DEFAULT_ASPECT_RATIO) {
            this.mAspectRatio = CropImageView.DEFAULT_ASPECT_RATIO;
        } else {
            this.mAspectRatio = f6 / f5;
        }
        this.mDotSize = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.mDotPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        setTitle();
        applyActiveColor(getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void setTitle() {
        String str;
        if (!TextUtils.isEmpty(this.mAspectRatioTitle)) {
            str = this.mAspectRatioTitle;
        } else {
            str = String.format(Locale.US, "%d:%d", new Object[]{Integer.valueOf((int) this.mAspectRatioX), Integer.valueOf((int) this.mAspectRatioY)});
        }
        setText(str);
    }

    private void toggleAspectRatio() {
        if (this.mAspectRatio != CropImageView.DEFAULT_ASPECT_RATIO) {
            float f5 = this.mAspectRatioX;
            float f6 = this.mAspectRatioY;
            this.mAspectRatioX = f6;
            this.mAspectRatioY = f5;
            this.mAspectRatio = f6 / f5;
        }
    }

    public float getAspectRatio(boolean z4) {
        if (z4) {
            toggleAspectRatio();
            setTitle();
        }
        return this.mAspectRatio;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            Rect rect = this.mCanvasClipBounds;
            float f5 = ((float) rect.bottom) - (((float) rect.top) / 2.0f);
            int i5 = this.mDotSize;
            canvas.drawCircle(((float) (rect.right - rect.left)) / 2.0f, f5 - (((float) i5) * 1.5f), ((float) i5) / 2.0f, this.mDotPaint);
        }
    }

    public void setActiveColor(int i5) {
        applyActiveColor(i5);
        invalidate();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.mAspectRatioTitle = aspectRatio.getAspectRatioTitle();
        this.mAspectRatioX = aspectRatio.getAspectRatioX();
        float aspectRatioY = aspectRatio.getAspectRatioY();
        this.mAspectRatioY = aspectRatioY;
        float f5 = this.mAspectRatioX;
        if (f5 == CropImageView.DEFAULT_ASPECT_RATIO || aspectRatioY == CropImageView.DEFAULT_ASPECT_RATIO) {
            this.mAspectRatio = CropImageView.DEFAULT_ASPECT_RATIO;
        } else {
            this.mAspectRatio = f5 / aspectRatioY;
        }
        setTitle();
    }
}
