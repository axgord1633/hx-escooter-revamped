package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.a0;
import androidx.core.view.accessibility.f;
import androidx.core.view.accessibility.h;
import androidx.core.view.b0;
import androidx.core.view.d0;
import androidx.core.view.e0;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements d0 {
    private static final float F = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final a G = new a();
    private static final int[] H = {16843130};
    private d A;
    private final e0 B;
    private final b0 C;
    private float D;
    private c E;

    /* renamed from: e  reason: collision with root package name */
    private final float f2000e;

    /* renamed from: f  reason: collision with root package name */
    private long f2001f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f2002g;

    /* renamed from: h  reason: collision with root package name */
    private OverScroller f2003h;

    /* renamed from: i  reason: collision with root package name */
    public EdgeEffect f2004i;

    /* renamed from: j  reason: collision with root package name */
    public EdgeEffect f2005j;

    /* renamed from: k  reason: collision with root package name */
    private int f2006k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2007l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2008m;

    /* renamed from: n  reason: collision with root package name */
    private View f2009n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2010o;

    /* renamed from: p  reason: collision with root package name */
    private VelocityTracker f2011p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2012q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2013r;

    /* renamed from: s  reason: collision with root package name */
    private int f2014s;

    /* renamed from: t  reason: collision with root package name */
    private int f2015t;

    /* renamed from: u  reason: collision with root package name */
    private int f2016u;

    /* renamed from: v  reason: collision with root package name */
    private int f2017v;

    /* renamed from: w  reason: collision with root package name */
    private final int[] f2018w;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f2019x;

    /* renamed from: y  reason: collision with root package name */
    private int f2020y;

    /* renamed from: z  reason: collision with root package name */
    private int f2021z;

    static class a extends androidx.core.view.a {
        a() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            h.a(accessibilityEvent, nestedScrollView.getScrollX());
            h.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void g(View view, f fVar) {
            int scrollRange;
            super.g(view, fVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            fVar.I(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                fVar.M(true);
                if (nestedScrollView.getScrollY() > 0) {
                    fVar.a(f.a.f1872r);
                    fVar.a(f.a.C);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    fVar.a(f.a.f1871q);
                    fVar.a(f.a.E);
                }
            }
        }

        public boolean j(View view, int i5, Bundle bundle) {
            if (super.j(view, i5, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i5 != 4096) {
                if (i5 == 8192 || i5 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.V(0, max, true);
                    return true;
                } else if (i5 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.V(0, min, true);
            return true;
        }
    }

    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public interface c {
        void a(NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8);
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f2022e;

        class a implements Parcelable.Creator<d> {
            a() {
            }

            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* renamed from: b */
            public d[] newArray(int i5) {
                return new d[i5];
            }
        }

        d(Parcel parcel) {
            super(parcel);
            this.f2022e = parcel.readInt();
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2022e + "}";
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f2022e);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, n.a.f5938c);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f2002g = new Rect();
        this.f2007l = true;
        this.f2008m = false;
        this.f2009n = null;
        this.f2010o = false;
        this.f2013r = true;
        this.f2017v = -1;
        this.f2018w = new int[2];
        this.f2019x = new int[2];
        this.f2004i = d.a(context, attributeSet);
        this.f2005j = d.a(context, attributeSet);
        this.f2000e = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        A();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H, i5, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.B = new e0(this);
        this.C = new b0(this);
        setNestedScrollingEnabled(true);
        k0.O(this, G);
    }

    private void A() {
        this.f2003h = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2014s = viewConfiguration.getScaledTouchSlop();
        this.f2015t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2016u = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void B() {
        if (this.f2011p == null) {
            this.f2011p = VelocityTracker.obtain();
        }
    }

    private void C(int i5, int i6) {
        this.f2006k = i5;
        this.f2017v = i6;
        W(2, 0);
    }

    private boolean D(View view) {
        return !F(view, 0, getHeight());
    }

    private static boolean E(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && E((View) parent, view2);
    }

    private boolean F(View view, int i5, int i6) {
        view.getDrawingRect(this.f2002g);
        offsetDescendantRectToMyCoords(view, this.f2002g);
        return this.f2002g.bottom + i5 >= getScrollY() && this.f2002g.top - i5 <= getScrollY() + i6;
    }

    private void G(int i5, int i6, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.C.d(0, scrollY2, 0, i5 - scrollY2, (int[]) null, i6, iArr);
    }

    private void H(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2017v) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.f2006k = (int) motionEvent.getY(i5);
            this.f2017v = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.f2011p;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void K() {
        VelocityTracker velocityTracker = this.f2011p;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2011p = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int L(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f2004i
            float r0 = androidx.core.widget.d.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            android.widget.EdgeEffect r0 = r3.f2004i
            float r4 = -r4
            float r4 = androidx.core.widget.d.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f2004i
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.f2004i
        L_0x002c:
            r5.onRelease()
        L_0x002f:
            r1 = r4
            goto L_0x0051
        L_0x0031:
            android.widget.EdgeEffect r0 = r3.f2005j
            float r0 = androidx.core.widget.d.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0051
            android.widget.EdgeEffect r0 = r3.f2005j
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.d.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f2005j
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.f2005j
            goto L_0x002c
        L_0x0051:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L_0x0060
            r3.invalidate()
        L_0x0060:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.L(int, float):int");
    }

    private void M(boolean z4) {
        if (z4) {
            W(2, 1);
        } else {
            Y(1);
        }
        this.f2021z = getScrollY();
        k0.I(this);
    }

    private boolean N(int i5, int i6, int i7) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = height + scrollY;
        boolean z4 = false;
        boolean z5 = i5 == 33;
        View t5 = t(z5, i6, i7);
        if (t5 == null) {
            t5 = this;
        }
        if (i6 < scrollY || i7 > i8) {
            O(z5 ? i6 - scrollY : i7 - i8, 0, 1, true);
            z4 = true;
        }
        if (t5 != findFocus()) {
            t5.requestFocus(i5);
        }
        return z4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int O(int r22, int r23, int r24, boolean r25) {
        /*
            r21 = this;
            r10 = r21
            r11 = r23
            r12 = r24
            r13 = 1
            if (r12 != r13) goto L_0x000d
            r0 = 2
            r10.W(r0, r12)
        L_0x000d:
            r1 = 0
            int[] r3 = r10.f2019x
            int[] r4 = r10.f2018w
            r0 = r21
            r2 = r22
            r5 = r24
            boolean r0 = r0.k(r1, r2, r3, r4, r5)
            r14 = 0
            if (r0 == 0) goto L_0x002e
            int[] r0 = r10.f2019x
            r0 = r0[r13]
            int r0 = r22 - r0
            int[] r1 = r10.f2018w
            r1 = r1[r13]
            int r1 = r1 + r14
            r15 = r0
            r16 = r1
            goto L_0x0032
        L_0x002e:
            r15 = r22
            r16 = r14
        L_0x0032:
            int r17 = r21.getScrollY()
            int r9 = r21.getScrollRange()
            boolean r0 = r21.c()
            if (r0 == 0) goto L_0x0045
            if (r25 != 0) goto L_0x0045
            r18 = r13
            goto L_0x0047
        L_0x0045:
            r18 = r14
        L_0x0047:
            r1 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r19 = 1
            r0 = r21
            r2 = r15
            r4 = r17
            r6 = r9
            r20 = r9
            r9 = r19
            boolean r0 = r0.I(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0066
            boolean r0 = r10.x(r12)
            if (r0 != 0) goto L_0x0066
            r8 = r13
            goto L_0x0067
        L_0x0066:
            r8 = r14
        L_0x0067:
            int r0 = r21.getScrollY()
            int r2 = r0 - r17
            int r4 = r15 - r2
            int[] r7 = r10.f2019x
            r7[r13] = r14
            r1 = 0
            r3 = 0
            int[] r5 = r10.f2018w
            r0 = r21
            r6 = r24
            r0.l(r1, r2, r3, r4, r5, r6, r7)
            int[] r0 = r10.f2018w
            r0 = r0[r13]
            int r16 = r16 + r0
            int[] r0 = r10.f2019x
            r0 = r0[r13]
            int r15 = r15 - r0
            int r0 = r17 + r15
            if (r0 >= 0) goto L_0x00b1
            if (r18 == 0) goto L_0x00d8
            android.widget.EdgeEffect r0 = r10.f2004i
            int r1 = -r15
            float r1 = (float) r1
            int r2 = r21.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            float r2 = (float) r11
            int r3 = r21.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.d.d(r0, r1, r2)
            android.widget.EdgeEffect r0 = r10.f2005j
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00d8
            android.widget.EdgeEffect r0 = r10.f2005j
        L_0x00ad:
            r0.onRelease()
            goto L_0x00d8
        L_0x00b1:
            r1 = r20
            if (r0 <= r1) goto L_0x00d8
            if (r18 == 0) goto L_0x00d8
            android.widget.EdgeEffect r0 = r10.f2005j
            float r1 = (float) r15
            int r2 = r21.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = (float) r11
            int r4 = r21.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            float r2 = r2 - r3
            androidx.core.widget.d.d(r0, r1, r2)
            android.widget.EdgeEffect r0 = r10.f2004i
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00d8
            android.widget.EdgeEffect r0 = r10.f2004i
            goto L_0x00ad
        L_0x00d8:
            android.widget.EdgeEffect r0 = r10.f2004i
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x00eb
            android.widget.EdgeEffect r0 = r10.f2005j
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00e9
            goto L_0x00eb
        L_0x00e9:
            r14 = r8
            goto L_0x00ee
        L_0x00eb:
            androidx.core.view.k0.I(r21)
        L_0x00ee:
            if (r14 == 0) goto L_0x00f7
            if (r12 != 0) goto L_0x00f7
            android.view.VelocityTracker r0 = r10.f2011p
            r0.clear()
        L_0x00f7:
            if (r12 != r13) goto L_0x0106
            r10.Y(r12)
            android.widget.EdgeEffect r0 = r10.f2004i
            r0.onRelease()
            android.widget.EdgeEffect r0 = r10.f2005j
            r0.onRelease()
        L_0x0106:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.O(int, int, int, boolean):int");
    }

    private void P(View view) {
        view.getDrawingRect(this.f2002g);
        offsetDescendantRectToMyCoords(view, this.f2002g);
        int f5 = f(this.f2002g);
        if (f5 != 0) {
            scrollBy(0, f5);
        }
    }

    private boolean Q(Rect rect, boolean z4) {
        int f5 = f(rect);
        boolean z5 = f5 != 0;
        if (z5) {
            if (z4) {
                scrollBy(0, f5);
            } else {
                S(0, f5);
            }
        }
        return z5;
    }

    private boolean R(EdgeEffect edgeEffect, int i5) {
        if (i5 > 0) {
            return true;
        }
        return w(-i5) < d.b(edgeEffect) * ((float) getHeight());
    }

    private void T(int i5, int i6, int i7, boolean z4) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2001f > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f2003h;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i6 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i7);
                M(z4);
            } else {
                if (!this.f2003h.isFinished()) {
                    a();
                }
                scrollBy(i5, i6);
            }
            this.f2001f = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private boolean X(MotionEvent motionEvent) {
        boolean z4;
        if (d.b(this.f2004i) != CropImageView.DEFAULT_ASPECT_RATIO) {
            d.d(this.f2004i, CropImageView.DEFAULT_ASPECT_RATIO, motionEvent.getX() / ((float) getWidth()));
            z4 = true;
        } else {
            z4 = false;
        }
        if (d.b(this.f2005j) == CropImageView.DEFAULT_ASPECT_RATIO) {
            return z4;
        }
        d.d(this.f2005j, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void a() {
        this.f2003h.abortAnimation();
        Y(1);
    }

    private boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int e(int i5, int i6, int i7) {
        if (i6 >= i7 || i5 < 0) {
            return 0;
        }
        return i6 + i5 > i7 ? i7 - i6 : i5;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.D == CropImageView.DEFAULT_ASPECT_RATIO) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.D = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.D;
    }

    private void p(int i5) {
        if (i5 == 0) {
            return;
        }
        if (this.f2013r) {
            S(0, i5);
        } else {
            scrollBy(0, i5);
        }
    }

    private boolean q(int i5) {
        EdgeEffect edgeEffect;
        if (d.b(this.f2004i) != CropImageView.DEFAULT_ASPECT_RATIO) {
            if (R(this.f2004i, i5)) {
                edgeEffect = this.f2004i;
            } else {
                i5 = -i5;
                u(i5);
                return true;
            }
        } else if (d.b(this.f2005j) == CropImageView.DEFAULT_ASPECT_RATIO) {
            return false;
        } else {
            i5 = -i5;
            if (R(this.f2005j, i5)) {
                edgeEffect = this.f2005j;
            }
            u(i5);
            return true;
        }
        edgeEffect.onAbsorb(i5);
        return true;
    }

    private void r() {
        this.f2017v = -1;
        this.f2010o = false;
        K();
        Y(0);
        this.f2004i.onRelease();
        this.f2005j.onRelease();
    }

    private View t(boolean z4, int i5, int i6) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z5 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = focusables.get(i7);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i5 < bottom && top < i6) {
                boolean z6 = i5 < top && bottom < i6;
                if (view == null) {
                    view = view2;
                    z5 = z6;
                } else {
                    boolean z7 = (z4 && top < view.getTop()) || (!z4 && bottom > view.getBottom());
                    if (z5) {
                        if (z6) {
                            if (!z7) {
                            }
                        }
                    } else if (z6) {
                        view = view2;
                        z5 = true;
                    } else if (!z7) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private float w(int i5) {
        double log = Math.log((double) ((((float) Math.abs(i5)) * 0.35f) / (this.f2000e * 0.015f)));
        float f5 = F;
        return (float) (((double) (this.f2000e * 0.015f)) * Math.exp((((double) f5) / (((double) f5) - 1.0d)) * log));
    }

    private boolean y(int i5, int i6) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i6 >= childAt.getTop() - scrollY && i6 < childAt.getBottom() - scrollY && i5 >= childAt.getLeft() && i5 < childAt.getRight();
    }

    private void z() {
        VelocityTracker velocityTracker = this.f2011p;
        if (velocityTracker == null) {
            this.f2011p = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z4) {
        boolean z5;
        boolean z6;
        int overScrollMode = getOverScrollMode();
        boolean z7 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z8 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z9 = overScrollMode == 0 || (overScrollMode == 1 && z7);
        boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && z8);
        int i13 = i7 + i5;
        int i14 = !z9 ? 0 : i11;
        int i15 = i8 + i6;
        int i16 = !z10 ? 0 : i12;
        int i17 = -i14;
        int i18 = i14 + i9;
        int i19 = -i16;
        int i20 = i16 + i10;
        if (i13 > i18) {
            i13 = i18;
            z5 = true;
        } else if (i13 < i17) {
            z5 = true;
            i13 = i17;
        } else {
            z5 = false;
        }
        if (i15 > i20) {
            i15 = i20;
            z6 = true;
        } else if (i15 < i19) {
            z6 = true;
            i15 = i19;
        } else {
            z6 = false;
        }
        if (z6 && !x(1)) {
            this.f2003h.springBack(i13, i15, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i13, i15, z5, z6);
        return z5 || z6;
    }

    public boolean J(int i5) {
        boolean z4 = i5 == 130;
        int height = getHeight();
        if (z4) {
            this.f2002g.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2002g;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2002g.top = getScrollY() - height;
            Rect rect2 = this.f2002g;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2002g;
        int i6 = rect3.top;
        int i7 = height + i6;
        rect3.bottom = i7;
        return N(i5, i6, i7);
    }

    public final void S(int i5, int i6) {
        T(i5, i6, 250, false);
    }

    /* access modifiers changed from: package-private */
    public void U(int i5, int i6, int i7, boolean z4) {
        T(i5 - getScrollX(), i6 - getScrollY(), i7, z4);
    }

    /* access modifiers changed from: package-private */
    public void V(int i5, int i6, boolean z4) {
        U(i5, i6, 250, z4);
    }

    public boolean W(int i5, int i6) {
        return this.C.m(i5, i6);
    }

    public void Y(int i5) {
        this.C.n(i5);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i5) {
        if (getChildCount() <= 0) {
            super.addView(view, i5);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i5) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i5);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !F(findNextFocus, maxScrollAmount, getHeight())) {
            if (i5 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i5 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i5 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            O(maxScrollAmount, 0, 1, true);
        } else {
            findNextFocus.getDrawingRect(this.f2002g);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2002g);
            O(f(this.f2002g), 0, 1, true);
            findNextFocus.requestFocus(i5);
        }
        if (findFocus != null && findFocus.isFocused() && D(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.f2003h.isFinished()) {
            this.f2003h.computeScrollOffset();
            int currY = this.f2003h.getCurrY();
            int g5 = g(currY - this.f2021z);
            this.f2021z = currY;
            int[] iArr = this.f2019x;
            boolean z4 = false;
            iArr[1] = 0;
            k(0, g5, iArr, (int[]) null, 1);
            int i5 = g5 - this.f2019x[1];
            int scrollRange = getScrollRange();
            if (i5 != 0) {
                int scrollY = getScrollY();
                I(0, i5, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i6 = i5 - scrollY2;
                int[] iArr2 = this.f2019x;
                iArr2[1] = 0;
                l(0, scrollY2, 0, i6, this.f2018w, 1, iArr2);
                i5 = i6 - this.f2019x[1];
            }
            if (i5 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z4 = true;
                }
                if (z4) {
                    if (i5 < 0) {
                        if (this.f2004i.isFinished()) {
                            edgeEffect = this.f2004i;
                        }
                    } else if (this.f2005j.isFinished()) {
                        edgeEffect = this.f2005j;
                    }
                    edgeEffect.onAbsorb((int) this.f2003h.getCurrVelocity());
                }
                a();
            }
            if (!this.f2003h.isFinished()) {
                k0.I(this);
            } else {
                Y(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    public boolean dispatchNestedFling(float f5, float f6, boolean z4) {
        return this.C.a(f5, f6, z4);
    }

    public boolean dispatchNestedPreFling(float f5, float f6) {
        return this.C.b(f5, f6);
    }

    public boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2) {
        return k(i5, i6, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr) {
        return this.C.e(i5, i6, i7, i8, iArr);
    }

    public void draw(Canvas canvas) {
        int i5;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i6 = 0;
        if (!this.f2004i.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i5 = getPaddingLeft() + 0;
            } else {
                i5 = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate((float) i5, (float) min);
            this.f2004i.setSize(width, height);
            if (this.f2004i.draw(canvas)) {
                k0.I(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.f2005j.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (b.a(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i6 = 0 + getPaddingLeft();
            }
            if (b.a(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i6 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, CropImageView.DEFAULT_ASPECT_RATIO);
            this.f2005j.setSize(width2, height2);
            if (this.f2005j.draw(canvas)) {
                k0.I(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* access modifiers changed from: protected */
    public int f(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i6 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i5 - verticalFadingEdgeLength : i5;
        int i7 = rect.bottom;
        if (i7 > i6 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i6) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        } else if (rect.top >= scrollY || i7 >= i6) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i6 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    /* access modifiers changed from: package-private */
    public int g(int i5) {
        int height = getHeight();
        if (i5 > 0 && d.b(this.f2004i) != CropImageView.DEFAULT_ASPECT_RATIO) {
            int round = Math.round((((float) (-height)) / 4.0f) * d.d(this.f2004i, (((float) (-i5)) * 4.0f) / ((float) height), 0.5f));
            if (round != i5) {
                this.f2004i.finish();
            }
            return i5 - round;
        } else if (i5 >= 0 || d.b(this.f2005j) == CropImageView.DEFAULT_ASPECT_RATIO) {
            return i5;
        } else {
            float f5 = (float) height;
            int round2 = Math.round((f5 / 4.0f) * d.d(this.f2005j, (((float) i5) * 4.0f) / f5, 0.5f));
            if (round2 != i5) {
                this.f2005j.finish();
            }
            return i5 - round2;
        }
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public void h(View view, View view2, int i5, int i6) {
        this.B.c(view, view2, i5, i6);
        W(2, i6);
    }

    public boolean hasNestedScrollingParent() {
        return x(0);
    }

    public void i(View view, int i5) {
        this.B.d(view, i5);
        Y(i5);
    }

    public boolean isNestedScrollingEnabled() {
        return this.C.j();
    }

    public void j(View view, int i5, int i6, int[] iArr, int i7) {
        k(i5, i6, iArr, (int[]) null, i7);
    }

    public boolean k(int i5, int i6, int[] iArr, int[] iArr2, int i7) {
        return this.C.c(i5, i6, iArr, iArr2, i7);
    }

    public void l(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        this.C.d(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    public void m(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        G(i8, i9, iArr);
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i5, int i6) {
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(View view, int i5, int i6, int i7, int i8, int i9) {
        G(i8, i9, (int[]) null);
    }

    public boolean o(View view, View view2, int i5, int i6) {
        return (i5 & 2) != 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2008m = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i5;
        float f5;
        if (motionEvent.getAction() != 8 || this.f2010o) {
            return false;
        }
        if (a0.a(motionEvent, 2)) {
            f5 = motionEvent.getAxisValue(9);
            i5 = (int) motionEvent.getX();
        } else if (a0.a(motionEvent, 4194304)) {
            float axisValue = motionEvent.getAxisValue(26);
            i5 = getWidth() / 2;
            f5 = axisValue;
        } else {
            i5 = 0;
            f5 = 0.0f;
        }
        if (f5 == CropImageView.DEFAULT_ASPECT_RATIO) {
            return false;
        }
        O(-((int) (f5 * getVerticalScrollFactorCompat())), i5, 1, a0.a(motionEvent, 8194));
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z4 = true;
        if (action == 2 && this.f2010o) {
            return true;
        }
        int i5 = action & 255;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = this.f2017v;
                    if (i6 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i6);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i6 + " in onInterceptTouchEvent");
                        } else {
                            int y4 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y4 - this.f2006k) > this.f2014s && (2 & getNestedScrollAxes()) == 0) {
                                this.f2010o = true;
                                this.f2006k = y4;
                                B();
                                this.f2011p.addMovement(motionEvent);
                                this.f2020y = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i5 != 3) {
                    if (i5 == 6) {
                        H(motionEvent);
                    }
                }
            }
            this.f2010o = false;
            this.f2017v = -1;
            K();
            if (this.f2003h.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                k0.I(this);
            }
            Y(0);
        } else {
            int y5 = (int) motionEvent.getY();
            if (!y((int) motionEvent.getX(), y5)) {
                if (!X(motionEvent) && this.f2003h.isFinished()) {
                    z4 = false;
                }
                this.f2010o = z4;
                K();
            } else {
                this.f2006k = y5;
                this.f2017v = motionEvent.getPointerId(0);
                z();
                this.f2011p.addMovement(motionEvent);
                this.f2003h.computeScrollOffset();
                if (!X(motionEvent) && this.f2003h.isFinished()) {
                    z4 = false;
                }
                this.f2010o = z4;
                W(2, 0);
            }
        }
        return this.f2010o;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        int i9 = 0;
        this.f2007l = false;
        View view = this.f2009n;
        if (view != null && E(view, this)) {
            P(this.f2009n);
        }
        this.f2009n = null;
        if (!this.f2008m) {
            if (this.A != null) {
                scrollTo(getScrollX(), this.A.f2022e);
                this.A = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i9 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e5 = e(scrollY, paddingTop, i9);
            if (e5 != scrollY) {
                scrollTo(getScrollX(), e5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2008m = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f2012q && View.MeasureSpec.getMode(i6) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(CropImageView.DEFAULT_ASPECT_RATIO, f6, true);
        u((int) f6);
        return true;
    }

    public boolean onNestedPreFling(View view, float f5, float f6) {
        return dispatchNestedPreFling(f5, f6);
    }

    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        j(view, i5, i6, iArr, 0);
    }

    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        G(i8, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i5) {
        h(view, view2, i5, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i5, int i6, boolean z4, boolean z5) {
        super.scrollTo(i5, i6);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        if (i5 == 2) {
            i5 = 130;
        } else if (i5 == 1) {
            i5 = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        View findNextFocus = rect == null ? instance.findNextFocus(this, (View) null, i5) : instance.findNextFocusFromRect(this, rect, i5);
        if (findNextFocus != null && !D(findNextFocus)) {
            return findNextFocus.requestFocus(i5, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.A = dVar;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f2022e = getScrollY();
        return dVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i5, int i6, int i7, int i8) {
        super.onScrollChanged(i5, i6, i7, i8);
        c cVar = this.E;
        if (cVar != null) {
            cVar.a(this, i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && F(findFocus, 0, i8)) {
            findFocus.getDrawingRect(this.f2002g);
            offsetDescendantRectToMyCoords(findFocus, this.f2002g);
            p(f(this.f2002g));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i5) {
        return o(view, view2, i5, 0);
    }

    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r12.f2003h.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012a, code lost:
        if (r12.f2003h.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            r12.B()
            int r0 = r13.getActionMasked()
            r1 = 0
            if (r0 != 0) goto L_0x000c
            r12.f2020y = r1
        L_0x000c:
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r13)
            int r3 = r12.f2020y
            float r3 = (float) r3
            r4 = 0
            r2.offsetLocation(r4, r3)
            r3 = 1
            if (r0 == 0) goto L_0x012e
            if (r0 == r3) goto L_0x00e6
            r4 = 2
            if (r0 == r4) goto L_0x0078
            r1 = 3
            if (r0 == r1) goto L_0x004f
            r1 = 5
            if (r0 == r1) goto L_0x003c
            r1 = 6
            if (r0 == r1) goto L_0x002a
            goto L_0x0159
        L_0x002a:
            r12.H(r13)
            int r0 = r12.f2017v
            int r0 = r13.findPointerIndex(r0)
            float r13 = r13.getY(r0)
            int r13 = (int) r13
            r12.f2006k = r13
            goto L_0x0159
        L_0x003c:
            int r0 = r13.getActionIndex()
            float r1 = r13.getY(r0)
            int r1 = (int) r1
            r12.f2006k = r1
            int r13 = r13.getPointerId(r0)
            r12.f2017v = r13
            goto L_0x0159
        L_0x004f:
            boolean r13 = r12.f2010o
            if (r13 == 0) goto L_0x0073
            int r13 = r12.getChildCount()
            if (r13 <= 0) goto L_0x0073
            android.widget.OverScroller r4 = r12.f2003h
            int r5 = r12.getScrollX()
            int r6 = r12.getScrollY()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r12.getScrollRange()
            boolean r13 = r4.springBack(r5, r6, r7, r8, r9, r10)
            if (r13 == 0) goto L_0x0073
        L_0x0070:
            androidx.core.view.k0.I(r12)
        L_0x0073:
            r12.r()
            goto L_0x0159
        L_0x0078:
            int r0 = r12.f2017v
            int r0 = r13.findPointerIndex(r0)
            r4 = -1
            if (r0 != r4) goto L_0x00a0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Invalid pointerId="
            r13.append(r0)
            int r0 = r12.f2017v
            r13.append(r0)
            java.lang.String r0 = " in onTouchEvent"
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "NestedScrollView"
            android.util.Log.e(r0, r13)
            goto L_0x0159
        L_0x00a0:
            float r4 = r13.getY(r0)
            int r4 = (int) r4
            int r5 = r12.f2006k
            int r5 = r5 - r4
            float r6 = r13.getX(r0)
            int r6 = r12.L(r5, r6)
            int r5 = r5 - r6
            boolean r6 = r12.f2010o
            if (r6 != 0) goto L_0x00cf
            int r6 = java.lang.Math.abs(r5)
            int r7 = r12.f2014s
            if (r6 <= r7) goto L_0x00cf
            android.view.ViewParent r6 = r12.getParent()
            if (r6 == 0) goto L_0x00c6
            r6.requestDisallowInterceptTouchEvent(r3)
        L_0x00c6:
            r12.f2010o = r3
            int r6 = r12.f2014s
            if (r5 <= 0) goto L_0x00ce
            int r5 = r5 - r6
            goto L_0x00cf
        L_0x00ce:
            int r5 = r5 + r6
        L_0x00cf:
            boolean r6 = r12.f2010o
            if (r6 == 0) goto L_0x0159
            float r13 = r13.getX(r0)
            int r13 = (int) r13
            int r13 = r12.O(r5, r13, r1, r1)
            int r4 = r4 - r13
            r12.f2006k = r4
            int r0 = r12.f2020y
            int r0 = r0 + r13
            r12.f2020y = r0
            goto L_0x0159
        L_0x00e6:
            android.view.VelocityTracker r13 = r12.f2011p
            r0 = 1000(0x3e8, float:1.401E-42)
            int r1 = r12.f2016u
            float r1 = (float) r1
            r13.computeCurrentVelocity(r0, r1)
            int r0 = r12.f2017v
            float r13 = r13.getYVelocity(r0)
            int r13 = (int) r13
            int r0 = java.lang.Math.abs(r13)
            int r1 = r12.f2015t
            if (r0 < r1) goto L_0x0115
            boolean r0 = r12.q(r13)
            if (r0 != 0) goto L_0x0073
            int r13 = -r13
            float r0 = (float) r13
            boolean r1 = r12.dispatchNestedPreFling(r4, r0)
            if (r1 != 0) goto L_0x0073
            r12.dispatchNestedFling(r4, r0, r3)
            r12.u(r13)
            goto L_0x0073
        L_0x0115:
            android.widget.OverScroller r5 = r12.f2003h
            int r6 = r12.getScrollX()
            int r7 = r12.getScrollY()
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            boolean r13 = r5.springBack(r6, r7, r8, r9, r10, r11)
            if (r13 == 0) goto L_0x0073
            goto L_0x0070
        L_0x012e:
            int r0 = r12.getChildCount()
            if (r0 != 0) goto L_0x0135
            return r1
        L_0x0135:
            boolean r0 = r12.f2010o
            if (r0 == 0) goto L_0x0142
            android.view.ViewParent r0 = r12.getParent()
            if (r0 == 0) goto L_0x0142
            r0.requestDisallowInterceptTouchEvent(r3)
        L_0x0142:
            android.widget.OverScroller r0 = r12.f2003h
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x014d
            r12.a()
        L_0x014d:
            float r0 = r13.getY()
            int r0 = (int) r0
            int r13 = r13.getPointerId(r1)
            r12.C(r0, r13)
        L_0x0159:
            android.view.VelocityTracker r13 = r12.f2011p
            if (r13 == 0) goto L_0x0160
            r13.addMovement(r2)
        L_0x0160:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f2007l) {
            P(view2);
        } else {
            this.f2009n = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return Q(rect, z4);
    }

    public void requestDisallowInterceptTouchEvent(boolean z4) {
        if (z4) {
            K();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    public void requestLayout() {
        this.f2007l = true;
        super.requestLayout();
    }

    public boolean s(KeyEvent keyEvent) {
        this.f2002g.setEmpty();
        int i5 = 130;
        if (!d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return !keyEvent.isAltPressed() ? b(33) : v(33);
            }
            if (keyCode == 20) {
                return !keyEvent.isAltPressed() ? b(130) : v(130);
            }
            if (keyCode != 62) {
                return false;
            }
            if (keyEvent.isShiftPressed()) {
                i5 = 33;
            }
            J(i5);
            return false;
        }
    }

    public void scrollTo(int i5, int i6) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int e5 = e(i5, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int e6 = e(i6, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (e5 != getScrollX() || e6 != getScrollY()) {
                super.scrollTo(e5, e6);
            }
        }
    }

    public void setFillViewport(boolean z4) {
        if (z4 != this.f2012q) {
            this.f2012q = z4;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z4) {
        this.C.k(z4);
    }

    public void setOnScrollChangeListener(c cVar) {
        this.E = cVar;
    }

    public void setSmoothScrollingEnabled(boolean z4) {
        this.f2013r = z4;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i5) {
        return W(i5, 0);
    }

    public void stopNestedScroll() {
        Y(0);
    }

    public void u(int i5) {
        if (getChildCount() > 0) {
            this.f2003h.fling(getScrollX(), getScrollY(), 0, i5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            M(true);
        }
    }

    public boolean v(int i5) {
        int childCount;
        boolean z4 = i5 == 130;
        int height = getHeight();
        Rect rect = this.f2002g;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2002g.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2002g;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2002g;
        return N(i5, rect3.top, rect3.bottom);
    }

    public boolean x(int i5) {
        return this.C.i(i5);
    }
}
