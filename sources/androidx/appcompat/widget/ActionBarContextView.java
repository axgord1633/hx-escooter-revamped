package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.k0;
import androidx.core.view.k1;
import d.f;
import d.g;
import d.j;
import h.b;

public class ActionBarContextView extends a {

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f972m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f973n;

    /* renamed from: o  reason: collision with root package name */
    private View f974o;

    /* renamed from: p  reason: collision with root package name */
    private View f975p;

    /* renamed from: q  reason: collision with root package name */
    private View f976q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f977r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f978s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f979t;

    /* renamed from: u  reason: collision with root package name */
    private int f980u;

    /* renamed from: v  reason: collision with root package name */
    private int f981v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f982w;

    /* renamed from: x  reason: collision with root package name */
    private int f983x;

    class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f984e;

        a(b bVar) {
            this.f984e = bVar;
        }

        public void onClick(View view) {
            this.f984e.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.f3971j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        k1 u5 = k1.u(context, attributeSet, j.f4220y, i5, 0);
        k0.P(this, u5.f(j.f4225z));
        this.f980u = u5.m(j.D, 0);
        this.f981v = u5.m(j.C, 0);
        this.f1132i = u5.l(j.B, 0);
        this.f983x = u5.m(j.A, g.f4067d);
        u5.v();
    }

    private void i() {
        if (this.f977r == null) {
            LayoutInflater.from(getContext()).inflate(g.f4064a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f977r = linearLayout;
            this.f978s = (TextView) linearLayout.findViewById(f.f4042e);
            this.f979t = (TextView) this.f977r.findViewById(f.f4041d);
            if (this.f980u != 0) {
                this.f978s.setTextAppearance(getContext(), this.f980u);
            }
            if (this.f981v != 0) {
                this.f979t.setTextAppearance(getContext(), this.f981v);
            }
        }
        this.f978s.setText(this.f972m);
        this.f979t.setText(this.f973n);
        boolean z4 = !TextUtils.isEmpty(this.f972m);
        boolean z5 = !TextUtils.isEmpty(this.f973n);
        int i5 = 0;
        this.f979t.setVisibility(z5 ? 0 : 8);
        LinearLayout linearLayout2 = this.f977r;
        if (!z4 && !z5) {
            i5 = 8;
        }
        linearLayout2.setVisibility(i5);
        if (this.f977r.getParent() == null) {
            addView(this.f977r);
        }
    }

    public /* bridge */ /* synthetic */ k1 f(int i5, long j5) {
        return super.f(i5, j5);
    }

    public void g() {
        if (this.f974o == null) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f973n;
    }

    public CharSequence getTitle() {
        return this.f972m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(h.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f974o
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.f983x
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f974o = r0
        L_0x0015:
            r3.addView(r0)
            goto L_0x0022
        L_0x0019:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0022
            android.view.View r0 = r3.f974o
            goto L_0x0015
        L_0x0022:
            android.view.View r0 = r3.f974o
            int r1 = d.f.f4046i
            android.view.View r0 = r0.findViewById(r1)
            r3.f975p = r0
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.e r4 = (androidx.appcompat.view.menu.e) r4
            androidx.appcompat.widget.c r0 = r3.f1131h
            if (r0 == 0) goto L_0x0041
            r0.y()
        L_0x0041:
            androidx.appcompat.widget.c r0 = new androidx.appcompat.widget.c
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f1131h = r0
            r1 = 1
            r0.J(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.c r1 = r3.f1131h
            android.content.Context r2 = r3.f1129f
            r4.c(r1, r2)
            androidx.appcompat.widget.c r4 = r3.f1131h
            androidx.appcompat.view.menu.k r4 = r4.o(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f1130g = r4
            r1 = 0
            androidx.core.view.k0.P(r4, r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f1130g
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(h.b):void");
    }

    public boolean j() {
        return this.f982w;
    }

    public void k() {
        removeAllViews();
        this.f976q = null;
        this.f1130g = null;
        this.f1131h = null;
        View view = this.f975p;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean l() {
        c cVar = this.f1131h;
        if (cVar != null) {
            return cVar.K();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f1131h;
        if (cVar != null) {
            cVar.B();
            this.f1131h.C();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f972m);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        boolean b5 = r1.b(this);
        int paddingRight = b5 ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.f974o;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f974o.getLayoutParams();
            int i9 = b5 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i10 = b5 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d5 = a.d(paddingRight, i9, b5);
            paddingRight = a.d(d5 + e(this.f974o, d5, paddingTop, paddingTop2, b5), i10, b5);
        }
        int i11 = paddingRight;
        LinearLayout linearLayout = this.f977r;
        if (!(linearLayout == null || this.f976q != null || linearLayout.getVisibility() == 8)) {
            i11 += e(this.f977r, i11, paddingTop, paddingTop2, b5);
        }
        int i12 = i11;
        View view2 = this.f976q;
        if (view2 != null) {
            e(view2, i12, paddingTop, paddingTop2, b5);
        }
        int paddingLeft = b5 ? getPaddingLeft() : (i7 - i5) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1130g;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7 = 1073741824;
        if (View.MeasureSpec.getMode(i5) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i6) != 0) {
            int size = View.MeasureSpec.getSize(i5);
            int i8 = this.f1132i;
            if (i8 <= 0) {
                i8 = View.MeasureSpec.getSize(i6);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i9 = i8 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE);
            View view = this.f974o;
            if (view != null) {
                int c5 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f974o.getLayoutParams();
                paddingLeft = c5 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f1130g;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f1130g, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f977r;
            if (linearLayout != null && this.f976q == null) {
                if (this.f982w) {
                    this.f977r.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f977r.getMeasuredWidth();
                    boolean z4 = measuredWidth <= paddingLeft;
                    if (z4) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f977r.setVisibility(z4 ? 0 : 8);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f976q;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i10 = layoutParams.width;
                int i11 = i10 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i10 >= 0) {
                    paddingLeft = Math.min(i10, paddingLeft);
                }
                int i12 = layoutParams.height;
                if (i12 == -2) {
                    i7 = Integer.MIN_VALUE;
                }
                if (i12 >= 0) {
                    i9 = Math.min(i12, i9);
                }
                this.f976q.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i11), View.MeasureSpec.makeMeasureSpec(i9, i7));
            }
            if (this.f1132i <= 0) {
                int childCount = getChildCount();
                int i13 = 0;
                for (int i14 = 0; i14 < childCount; i14++) {
                    int measuredHeight = getChildAt(i14).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i13) {
                        i13 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i13);
                return;
            }
            setMeasuredDimension(size, i8);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i5) {
        this.f1132i = i5;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f976q;
        if (view2 != null) {
            removeView(view2);
        }
        this.f976q = view;
        if (!(view == null || (linearLayout = this.f977r) == null)) {
            removeView(linearLayout);
            this.f977r = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f973n = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f972m = charSequence;
        i();
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f982w) {
            requestLayout();
        }
        this.f982w = z4;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i5) {
        super.setVisibility(i5);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
