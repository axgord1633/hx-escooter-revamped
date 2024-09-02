package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.k0;
import d.f;
import d.j;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    private boolean f962e;

    /* renamed from: f  reason: collision with root package name */
    private View f963f;

    /* renamed from: g  reason: collision with root package name */
    private View f964g;

    /* renamed from: h  reason: collision with root package name */
    private View f965h;

    /* renamed from: i  reason: collision with root package name */
    Drawable f966i;

    /* renamed from: j  reason: collision with root package name */
    Drawable f967j;

    /* renamed from: k  reason: collision with root package name */
    Drawable f968k;

    /* renamed from: l  reason: collision with root package name */
    boolean f969l;

    /* renamed from: m  reason: collision with root package name */
    boolean f970m;

    /* renamed from: n  reason: collision with root package name */
    private int f971n;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k0.P(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f4100a);
        this.f966i = obtainStyledAttributes.getDrawable(j.f4105b);
        this.f967j = obtainStyledAttributes.getDrawable(j.f4115d);
        this.f971n = obtainStyledAttributes.getDimensionPixelSize(j.f4145j, -1);
        boolean z4 = true;
        if (getId() == f.H) {
            this.f969l = true;
            this.f968k = obtainStyledAttributes.getDrawable(j.f4110c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f969l ? !(this.f966i == null && this.f967j == null) : this.f968k != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f966i;
        if (drawable != null && drawable.isStateful()) {
            this.f966i.setState(getDrawableState());
        }
        Drawable drawable2 = this.f967j;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f967j.setState(getDrawableState());
        }
        Drawable drawable3 = this.f968k;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f968k.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f963f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f966i;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f967j;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f968k;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f964g = findViewById(f.f4038a);
        this.f965h = findViewById(f.f4043f);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f962e || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.f963f
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L_0x0013
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L_0x0013
            r1 = r9
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r5 == 0) goto L_0x0033
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L_0x0033
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L_0x0033:
            boolean r6 = r4.f969l
            if (r6 == 0) goto L_0x004a
            android.graphics.drawable.Drawable r5 = r4.f968k
            if (r5 == 0) goto L_0x0048
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto L_0x00b6
        L_0x0048:
            r9 = r0
            goto L_0x00b6
        L_0x004a:
            android.graphics.drawable.Drawable r6 = r4.f966i
            if (r6 == 0) goto L_0x009b
            android.view.View r6 = r4.f964g
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0074
            android.graphics.drawable.Drawable r6 = r4.f966i
            android.view.View r7 = r4.f964g
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f964g
            int r8 = r8.getTop()
            android.view.View r0 = r4.f964g
            int r0 = r0.getRight()
            android.view.View r2 = r4.f964g
        L_0x006c:
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x009a
        L_0x0074:
            android.view.View r6 = r4.f965h
            if (r6 == 0) goto L_0x0095
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0095
            android.graphics.drawable.Drawable r6 = r4.f966i
            android.view.View r7 = r4.f965h
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f965h
            int r8 = r8.getTop()
            android.view.View r0 = r4.f965h
            int r0 = r0.getRight()
            android.view.View r2 = r4.f965h
            goto L_0x006c
        L_0x0095:
            android.graphics.drawable.Drawable r6 = r4.f966i
            r6.setBounds(r0, r0, r0, r0)
        L_0x009a:
            r0 = r9
        L_0x009b:
            r4.f970m = r1
            if (r1 == 0) goto L_0x0048
            android.graphics.drawable.Drawable r6 = r4.f967j
            if (r6 == 0) goto L_0x0048
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        L_0x00b6:
            if (r9 == 0) goto L_0x00bb
            r4.invalidate()
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f964g
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x001c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L_0x001c
            int r0 = r3.f971n
            if (r0 < 0) goto L_0x001c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L_0x001c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f964g
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f963f
            if (r0 == 0) goto L_0x006f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x006f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L_0x006f
            android.view.View r0 = r3.f964g
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L_0x0047
            android.view.View r0 = r3.f964g
        L_0x0042:
            int r0 = r3.a(r0)
            goto L_0x0053
        L_0x0047:
            android.view.View r0 = r3.f965h
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L_0x0052
            android.view.View r0 = r3.f965h
            goto L_0x0042
        L_0x0052:
            r0 = 0
        L_0x0053:
            if (r4 != r1) goto L_0x005a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L_0x005d
        L_0x005a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x005d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f963f
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f966i;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f966i);
        }
        this.f966i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f964g;
            if (view != null) {
                this.f966i.setBounds(view.getLeft(), this.f964g.getTop(), this.f964g.getRight(), this.f964g.getBottom());
            }
        }
        boolean z4 = true;
        if (!this.f969l ? !(this.f966i == null && this.f967j == null) : this.f968k != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f968k;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f968k);
        }
        this.f968k = drawable;
        boolean z4 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f969l && (drawable2 = this.f968k) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f969l ? this.f966i == null && this.f967j == null : this.f968k == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f967j;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f967j);
        }
        this.f967j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f970m && (drawable2 = this.f967j) != null) {
                drawable2.setBounds(this.f963f.getLeft(), this.f963f.getTop(), this.f963f.getRight(), this.f963f.getBottom());
            }
        }
        boolean z4 = true;
        if (!this.f969l ? !(this.f966i == null && this.f967j == null) : this.f968k != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(d1 d1Var) {
        View view = this.f963f;
        if (view != null) {
            removeView(view);
        }
        this.f963f = d1Var;
        if (d1Var != null) {
            addView(d1Var);
            ViewGroup.LayoutParams layoutParams = d1Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            d1Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z4) {
        this.f962e = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z4 = i5 == 0;
        Drawable drawable = this.f966i;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f967j;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f968k;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i5) {
        if (i5 != 0) {
            return super.startActionModeForChild(view, callback, i5);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f966i && !this.f969l) || (drawable == this.f967j && this.f970m) || ((drawable == this.f968k && this.f969l) || super.verifyDrawable(drawable));
    }
}
