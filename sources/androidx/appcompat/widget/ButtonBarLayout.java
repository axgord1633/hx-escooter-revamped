package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.k0;
import d.f;
import d.j;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    private boolean f1026e;

    /* renamed from: f  reason: collision with root package name */
    private int f1027f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f1028g = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr = j.O0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        k0.M(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f1026e = obtainStyledAttributes.getBoolean(j.P0, true);
        obtainStyledAttributes.recycle();
    }

    private int a(int i5) {
        int childCount = getChildCount();
        while (i5 < childCount) {
            if (getChildAt(i5).getVisibility() == 0) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private boolean b() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z4) {
        setOrientation(z4 ? 1 : 0);
        setGravity(z4 ? 8388613 : 80);
        View findViewById = findViewById(f.G);
        if (findViewById != null) {
            findViewById.setVisibility(z4 ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    public int getMinimumHeight() {
        return Math.max(this.f1028g, super.getMinimumHeight());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        boolean z4;
        int i7;
        int size = View.MeasureSpec.getSize(i5);
        int i8 = 0;
        if (this.f1026e) {
            if (size > this.f1027f && b()) {
                setStacked(false);
            }
            this.f1027f = size;
        }
        if (b() || View.MeasureSpec.getMode(i5) != 1073741824) {
            i7 = i5;
            z4 = false;
        } else {
            i7 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z4 = true;
        }
        super.onMeasure(i7, i6);
        if (this.f1026e && !b()) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                setStacked(true);
                z4 = true;
            }
        }
        if (z4) {
            super.onMeasure(i5, i6);
        }
        int a5 = a(0);
        if (a5 >= 0) {
            View childAt = getChildAt(a5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int a6 = a(a5 + 1);
                if (a6 >= 0) {
                    paddingTop += getChildAt(a6).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i8 = paddingTop;
            } else {
                i8 = paddingTop + getPaddingBottom();
            }
        }
        if (k0.r(this) != i8) {
            setMinimumHeight(i8);
        }
    }

    public void setAllowStacking(boolean z4) {
        if (this.f1026e != z4) {
            this.f1026e = z4;
            if (!z4 && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
