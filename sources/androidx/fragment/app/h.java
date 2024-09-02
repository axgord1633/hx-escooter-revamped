package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.k0;
import androidx.core.view.o1;
import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import u.c;

public final class h extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<View> f2312e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<View> f2313f;

    /* renamed from: g  reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f2314g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2315h = true;

    h(Context context, AttributeSet attributeSet, n nVar) {
        super(context, attributeSet);
        String str;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.f7064h);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(c.f7065i) : classAttribute;
        String string = obtainStyledAttributes.getString(c.f7066j);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment h02 = nVar.h0(id);
        if (classAttribute != null && h02 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = BuildConfig.FLAVOR;
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a5 = nVar.q0().a(context.getClassLoader(), classAttribute);
            a5.onInflate(context, attributeSet, (Bundle) null);
            nVar.m().l(true).c(this, a5, string).h();
        }
        nVar.U0(this);
    }

    private void a(View view) {
        ArrayList<View> arrayList = this.f2313f;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.f2312e == null) {
                this.f2312e = new ArrayList<>();
            }
            this.f2312e.add(view);
        }
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (n.z0(view) != null) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i5, ViewGroup.LayoutParams layoutParams, boolean z4) {
        if (n.z0(view) != null) {
            return super.addViewInLayout(view, i5, layoutParams, z4);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        o1 v5 = o1.v(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2314g;
        o1 v6 = onApplyWindowInsetsListener != null ? o1.v(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : k0.F(this, v5);
        if (!v6.n()) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                k0.e(getChildAt(i5), v6);
            }
        }
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f2315h && this.f2312e != null) {
            for (int i5 = 0; i5 < this.f2312e.size(); i5++) {
                super.drawChild(canvas, this.f2312e.get(i5), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j5) {
        ArrayList<View> arrayList;
        if (!this.f2315h || (arrayList = this.f2312e) == null || arrayList.size() <= 0 || !this.f2312e.contains(view)) {
            return super.drawChild(canvas, view, j5);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f2313f;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f2312e;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f2315h = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z4) {
        if (z4) {
            a(view);
        }
        super.removeDetachedView(view, z4);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i5) {
        a(getChildAt(i5));
        super.removeViewAt(i5);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            a(getChildAt(i7));
        }
        super.removeViews(i5, i6);
    }

    public void removeViewsInLayout(int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            a(getChildAt(i7));
        }
        super.removeViewsInLayout(i5, i6);
    }

    /* access modifiers changed from: package-private */
    public void setDrawDisappearingViewsLast(boolean z4) {
        this.f2315h = z4;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f2314g = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f2313f == null) {
                this.f2313f = new ArrayList<>();
            }
            this.f2313f.add(view);
        }
        super.startViewTransition(view);
    }
}
