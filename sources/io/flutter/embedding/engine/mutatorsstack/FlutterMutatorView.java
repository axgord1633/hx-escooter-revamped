package io.flutter.embedding.engine.mutatorsstack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.util.ViewUtils;

public class FlutterMutatorView extends FrameLayout {
    ViewTreeObserver.OnGlobalFocusChangeListener activeFocusListener;
    private final AndroidTouchProcessor androidTouchProcessor;
    private int left;
    private FlutterMutatorsStack mutatorsStack;
    private int prevLeft;
    private int prevTop;
    private float screenDensity;
    private int top;

    public FlutterMutatorView(Context context) {
        this(context, 1.0f, (AndroidTouchProcessor) null);
    }

    public FlutterMutatorView(Context context, float f5, AndroidTouchProcessor androidTouchProcessor2) {
        super(context, (AttributeSet) null);
        this.screenDensity = f5;
        this.androidTouchProcessor = androidTouchProcessor2;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.mutatorsStack.getFinalMatrix());
        float f5 = this.screenDensity;
        matrix.preScale(1.0f / f5, 1.0f / f5);
        matrix.postTranslate((float) (-this.left), (float) (-this.top));
        return matrix;
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.mutatorsStack.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset((float) (-this.left), (float) (-this.top));
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i5;
        float f5;
        if (this.androidTouchProcessor == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i6 = this.left;
            this.prevLeft = i6;
            i5 = this.top;
            this.prevTop = i5;
            f5 = (float) i6;
        } else if (action != 2) {
            f5 = (float) this.left;
            i5 = this.top;
        } else {
            matrix.postTranslate((float) this.prevLeft, (float) this.prevTop);
            this.prevLeft = this.left;
            this.prevTop = this.top;
            return this.androidTouchProcessor.onTouchEvent(motionEvent, matrix);
        }
        matrix.postTranslate(f5, (float) i5);
        return this.androidTouchProcessor.onTouchEvent(motionEvent, matrix);
    }

    public void readyToDisplay(FlutterMutatorsStack flutterMutatorsStack, int i5, int i6, int i7, int i8) {
        this.mutatorsStack = flutterMutatorsStack;
        this.left = i5;
        this.top = i6;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
        layoutParams.leftMargin = i5;
        layoutParams.topMargin = i6;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(final View.OnFocusChangeListener onFocusChangeListener) {
        unsetOnDescendantFocusChangeListener();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.activeFocusListener == null) {
            AnonymousClass1 r12 = new ViewTreeObserver.OnGlobalFocusChangeListener() {
                public void onGlobalFocusChanged(View view, View view2) {
                    View.OnFocusChangeListener onFocusChangeListener = onFocusChangeListener;
                    View view3 = this;
                    onFocusChangeListener.onFocusChange(view3, ViewUtils.childHasFocus(view3));
                }
            };
            this.activeFocusListener = r12;
            viewTreeObserver.addOnGlobalFocusChangeListener(r12);
        }
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (onGlobalFocusChangeListener = this.activeFocusListener) != null) {
            this.activeFocusListener = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }
}
