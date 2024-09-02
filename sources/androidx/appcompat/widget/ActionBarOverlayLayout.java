package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import androidx.core.view.c0;
import androidx.core.view.d0;
import androidx.core.view.e0;
import androidx.core.view.k0;
import androidx.core.view.o1;
import com.yalantis.ucrop.view.CropImageView;
import d.f;

public class ActionBarOverlayLayout extends ViewGroup implements m0, c0, d0 {
    static final int[] J = {d.a.f3963b, 16842841};
    private o1 A;
    private o1 B;
    private d C;
    private OverScroller D;
    ViewPropertyAnimator E;
    final AnimatorListenerAdapter F;
    private final Runnable G;
    private final Runnable H;
    private final e0 I;

    /* renamed from: e  reason: collision with root package name */
    private int f986e;

    /* renamed from: f  reason: collision with root package name */
    private int f987f = 0;

    /* renamed from: g  reason: collision with root package name */
    private ContentFrameLayout f988g;

    /* renamed from: h  reason: collision with root package name */
    ActionBarContainer f989h;

    /* renamed from: i  reason: collision with root package name */
    private n0 f990i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f991j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f992k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f993l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f994m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f995n;

    /* renamed from: o  reason: collision with root package name */
    boolean f996o;

    /* renamed from: p  reason: collision with root package name */
    private int f997p;

    /* renamed from: q  reason: collision with root package name */
    private int f998q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f999r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    private final Rect f1000s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private final Rect f1001t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    private final Rect f1002u = new Rect();

    /* renamed from: v  reason: collision with root package name */
    private final Rect f1003v = new Rect();

    /* renamed from: w  reason: collision with root package name */
    private final Rect f1004w = new Rect();

    /* renamed from: x  reason: collision with root package name */
    private final Rect f1005x = new Rect();

    /* renamed from: y  reason: collision with root package name */
    private o1 f1006y;

    /* renamed from: z  reason: collision with root package name */
    private o1 f1007z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = null;
            actionBarOverlayLayout.f996o = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = null;
            actionBarOverlayLayout.f996o = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = actionBarOverlayLayout.f989h.animate().translationY(CropImageView.DEFAULT_ASPECT_RATIO).setListener(ActionBarOverlayLayout.this.F);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = actionBarOverlayLayout.f989h.animate().translationY((float) (-ActionBarOverlayLayout.this.f989h.getHeight())).setListener(ActionBarOverlayLayout.this.F);
        }
    }

    public interface d {
        void a();

        void b();

        void c(int i5);

        void d();

        void e(boolean z4);

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i5, int i6) {
            super(i5, i6);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o1 o1Var = o1.f1959b;
        this.f1006y = o1Var;
        this.f1007z = o1Var;
        this.A = o1Var;
        this.B = o1Var;
        this.F = new a();
        this.G = new b();
        this.H = new c();
        v(context);
        this.I = new e0(this);
    }

    private void A() {
        u();
        this.G.run();
    }

    private boolean B(float f5) {
        this.D.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.D.getFinalY() > this.f989h.getHeight();
    }

    private void p() {
        u();
        this.H.run();
    }

    private boolean q(View view, Rect rect, boolean z4, boolean z5, boolean z6, boolean z7) {
        boolean z8;
        int i5;
        int i6;
        int i7;
        int i8;
        e eVar = (e) view.getLayoutParams();
        if (!z4 || eVar.leftMargin == (i8 = rect.left)) {
            z8 = false;
        } else {
            eVar.leftMargin = i8;
            z8 = true;
        }
        if (z5 && eVar.topMargin != (i7 = rect.top)) {
            eVar.topMargin = i7;
            z8 = true;
        }
        if (z7 && eVar.rightMargin != (i6 = rect.right)) {
            eVar.rightMargin = i6;
            z8 = true;
        }
        if (!z6 || eVar.bottomMargin == (i5 = rect.bottom)) {
            return z8;
        }
        eVar.bottomMargin = i5;
        return true;
    }

    private n0 t(View view) {
        if (view instanceof n0) {
            return (n0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(J);
        boolean z4 = false;
        this.f986e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f991j = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z4 = true;
        }
        this.f992k = z4;
        this.D = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.H, 600);
    }

    private void y() {
        u();
        postDelayed(this.G, 600);
    }

    public void a(Menu menu, j.a aVar) {
        z();
        this.f990i.a(menu, aVar);
    }

    public boolean b() {
        z();
        return this.f990i.b();
    }

    public void c() {
        z();
        this.f990i.c();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public boolean d() {
        z();
        return this.f990i.d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f991j != null && !this.f992k) {
            int bottom = this.f989h.getVisibility() == 0 ? (int) (((float) this.f989h.getBottom()) + this.f989h.getTranslationY() + 0.5f) : 0;
            this.f991j.setBounds(0, bottom, getWidth(), this.f991j.getIntrinsicHeight() + bottom);
            this.f991j.draw(canvas);
        }
    }

    public boolean e() {
        z();
        return this.f990i.e();
    }

    public boolean f() {
        z();
        return this.f990i.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public boolean g() {
        z();
        return this.f990i.g();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f989h;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.I.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f990i.getTitle();
    }

    public void h(View view, View view2, int i5, int i6) {
        if (i6 == 0) {
            onNestedScrollAccepted(view, view2, i5);
        }
    }

    public void i(View view, int i5) {
        if (i5 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void j(View view, int i5, int i6, int[] iArr, int i7) {
        if (i7 == 0) {
            onNestedPreScroll(view, i5, i6, iArr);
        }
    }

    public void k(int i5) {
        z();
        if (i5 == 2) {
            this.f990i.u();
        } else if (i5 == 5) {
            this.f990i.v();
        } else if (i5 == 109) {
            setOverlayMode(true);
        }
    }

    public void l() {
        z();
        this.f990i.h();
    }

    public void m(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        n(view, i5, i6, i7, i8, i9);
    }

    public void n(View view, int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            onNestedScroll(view, i5, i6, i7, i8);
        }
    }

    public boolean o(View view, View view2, int i5, int i6) {
        return i6 == 0 && onStartNestedScroll(view, view2, i5);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        o1 w4 = o1.w(windowInsets, this);
        boolean q5 = q(this.f989h, new Rect(w4.i(), w4.k(), w4.j(), w4.h()), true, true, false, true);
        k0.d(this, w4, this.f999r);
        Rect rect = this.f999r;
        o1 l5 = w4.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f1006y = l5;
        boolean z4 = true;
        if (!this.f1007z.equals(l5)) {
            this.f1007z = this.f1006y;
            q5 = true;
        }
        if (!this.f1000s.equals(this.f999r)) {
            this.f1000s.set(this.f999r);
        } else {
            z4 = q5;
        }
        if (z4) {
            requestLayout();
        }
        return w4.a().c().b().u();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        k0.L(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = eVar.leftMargin + paddingLeft;
                int i11 = eVar.topMargin + paddingTop;
                childAt.layout(i10, i11, measuredWidth + i10, measuredHeight + i11);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        o1 o1Var;
        z();
        measureChildWithMargins(this.f989h, i5, 0, i6, 0);
        e eVar = (e) this.f989h.getLayoutParams();
        int max = Math.max(0, this.f989h.getMeasuredWidth() + eVar.leftMargin + eVar.rightMargin);
        int max2 = Math.max(0, this.f989h.getMeasuredHeight() + eVar.topMargin + eVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f989h.getMeasuredState());
        boolean z4 = (k0.w(this) & 256) != 0;
        if (z4) {
            i7 = this.f986e;
            if (this.f994m && this.f989h.getTabContainer() != null) {
                i7 += this.f986e;
            }
        } else {
            i7 = this.f989h.getVisibility() != 8 ? this.f989h.getMeasuredHeight() : 0;
        }
        this.f1001t.set(this.f999r);
        o1 o1Var2 = this.f1006y;
        this.A = o1Var2;
        if (this.f993l || z4) {
            o1Var = new o1.b(this.A).c(androidx.core.graphics.b.b(o1Var2.i(), this.A.k() + i7, this.A.j(), this.A.h() + 0)).a();
        } else {
            Rect rect = this.f1001t;
            rect.top += i7;
            rect.bottom += 0;
            o1Var = o1Var2.l(0, i7, 0, 0);
        }
        this.A = o1Var;
        q(this.f988g, this.f1001t, true, true, true, true);
        if (!this.B.equals(this.A)) {
            o1 o1Var3 = this.A;
            this.B = o1Var3;
            k0.e(this.f988g, o1Var3);
        }
        measureChildWithMargins(this.f988g, i5, 0, i6, 0);
        e eVar2 = (e) this.f988g.getLayoutParams();
        int max3 = Math.max(max, this.f988g.getMeasuredWidth() + eVar2.leftMargin + eVar2.rightMargin);
        int max4 = Math.max(max2, this.f988g.getMeasuredHeight() + eVar2.topMargin + eVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f988g.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        if (!this.f995n || !z4) {
            return false;
        }
        if (B(f6)) {
            p();
        } else {
            A();
        }
        this.f996o = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f5, float f6) {
        return false;
    }

    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
    }

    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        int i9 = this.f997p + i6;
        this.f997p = i9;
        setActionBarHideOffset(i9);
    }

    public void onNestedScrollAccepted(View view, View view2, int i5) {
        this.I.b(view, view2, i5);
        this.f997p = getActionBarHideOffset();
        u();
        d dVar = this.C;
        if (dVar != null) {
            dVar.b();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i5) {
        if ((i5 & 2) == 0 || this.f989h.getVisibility() != 0) {
            return false;
        }
        return this.f995n;
    }

    public void onStopNestedScroll(View view) {
        if (this.f995n && !this.f996o) {
            if (this.f997p <= this.f989h.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.C;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i5) {
        super.onWindowSystemUiVisibilityChanged(i5);
        z();
        int i6 = this.f998q ^ i5;
        this.f998q = i5;
        boolean z4 = false;
        boolean z5 = (i5 & 4) == 0;
        if ((i5 & 256) != 0) {
            z4 = true;
        }
        d dVar = this.C;
        if (dVar != null) {
            dVar.e(!z4);
            if (z5 || !z4) {
                this.C.a();
            } else {
                this.C.f();
            }
        }
        if ((i6 & 256) != 0 && this.C != null) {
            k0.L(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        this.f987f = i5;
        d dVar = this.C;
        if (dVar != null) {
            dVar.c(i5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* renamed from: s */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i5) {
        u();
        this.f989h.setTranslationY((float) (-Math.max(0, Math.min(i5, this.f989h.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.C = dVar;
        if (getWindowToken() != null) {
            this.C.c(this.f987f);
            int i5 = this.f998q;
            if (i5 != 0) {
                onWindowSystemUiVisibilityChanged(i5);
                k0.L(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
        this.f994m = z4;
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.f995n) {
            this.f995n = z4;
            if (!z4) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i5) {
        z();
        this.f990i.setIcon(i5);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f990i.setIcon(drawable);
    }

    public void setLogo(int i5) {
        z();
        this.f990i.r(i5);
    }

    public void setOverlayMode(boolean z4) {
        this.f993l = z4;
        this.f992k = z4 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setUiOptions(int i5) {
    }

    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f990i.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f990i.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        removeCallbacks(this.G);
        removeCallbacks(this.H);
        ViewPropertyAnimator viewPropertyAnimator = this.E;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f993l;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.f988g == null) {
            this.f988g = (ContentFrameLayout) findViewById(f.f4039b);
            this.f989h = (ActionBarContainer) findViewById(f.f4040c);
            this.f990i = t(findViewById(f.f4038a));
        }
    }
}
