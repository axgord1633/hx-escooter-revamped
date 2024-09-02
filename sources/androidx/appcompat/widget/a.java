package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.k0;
import androidx.core.view.k1;
import androidx.core.view.l1;
import com.yalantis.ucrop.view.CropImageView;
import d.j;

abstract class a extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    protected final C0017a f1128e;

    /* renamed from: f  reason: collision with root package name */
    protected final Context f1129f;

    /* renamed from: g  reason: collision with root package name */
    protected ActionMenuView f1130g;

    /* renamed from: h  reason: collision with root package name */
    protected c f1131h;

    /* renamed from: i  reason: collision with root package name */
    protected int f1132i;

    /* renamed from: j  reason: collision with root package name */
    protected k1 f1133j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1134k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1135l;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0017a implements l1 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1136a = false;

        /* renamed from: b  reason: collision with root package name */
        int f1137b;

        protected C0017a() {
        }

        public void a(View view) {
            this.f1136a = true;
        }

        public void b(View view) {
            if (!this.f1136a) {
                a aVar = a.this;
                aVar.f1133j = null;
                a.super.setVisibility(this.f1137b);
            }
        }

        public void c(View view) {
            a.super.setVisibility(0);
            this.f1136a = false;
        }

        public C0017a d(k1 k1Var, int i5) {
            a.this.f1133j = k1Var;
            this.f1137b = i5;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f1128e = new C0017a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(d.a.f3962a, typedValue, true) || typedValue.resourceId == 0) {
            this.f1129f = context;
        } else {
            this.f1129f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i5, int i6, boolean z4) {
        return z4 ? i5 - i6 : i5 + i6;
    }

    /* access modifiers changed from: protected */
    public int c(View view, int i5, int i6, int i7) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), i6);
        return Math.max(0, (i5 - view.getMeasuredWidth()) - i7);
    }

    /* access modifiers changed from: protected */
    public int e(View view, int i5, int i6, int i7, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i6 + ((i7 - measuredHeight) / 2);
        if (z4) {
            view.layout(i5 - measuredWidth, i8, i5, measuredHeight + i8);
        } else {
            view.layout(i5, i8, i5 + measuredWidth, measuredHeight + i8);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public k1 f(int i5, long j5) {
        k1 b5;
        k1 k1Var = this.f1133j;
        if (k1Var != null) {
            k1Var.c();
        }
        if (i5 == 0) {
            if (getVisibility() != 0) {
                setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            }
            b5 = k0.c(this).b(1.0f);
        } else {
            b5 = k0.c(this).b(CropImageView.DEFAULT_ASPECT_RATIO);
        }
        b5.f(j5);
        b5.h(this.f1128e.d(b5, i5));
        return b5;
    }

    public int getAnimatedVisibility() {
        return this.f1133j != null ? this.f1128e.f1137b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1132i;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, j.f4100a, d.a.f3964c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.f4145j, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f1131h;
        if (cVar != null) {
            cVar.F(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1135l = false;
        }
        if (!this.f1135l) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1135l = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1135l = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1134k = false;
        }
        if (!this.f1134k) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1134k = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1134k = false;
        }
        return true;
    }

    public void setContentHeight(int i5) {
        this.f1132i = i5;
        requestLayout();
    }

    public void setVisibility(int i5) {
        if (i5 != getVisibility()) {
            k1 k1Var = this.f1133j;
            if (k1Var != null) {
                k1Var.c();
            }
            super.setVisibility(i5);
        }
    }
}
