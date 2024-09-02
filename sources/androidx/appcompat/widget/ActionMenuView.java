package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.s0;
import com.yalantis.ucrop.view.CropImageView;

public class ActionMenuView extends s0 implements e.b, k {
    private boolean A;
    private int B;
    private int C;
    private int D;
    e E;

    /* renamed from: t  reason: collision with root package name */
    private androidx.appcompat.view.menu.e f1011t;

    /* renamed from: u  reason: collision with root package name */
    private Context f1012u;

    /* renamed from: v  reason: collision with root package name */
    private int f1013v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1014w;

    /* renamed from: x  reason: collision with root package name */
    private c f1015x;

    /* renamed from: y  reason: collision with root package name */
    private j.a f1016y;

    /* renamed from: z  reason: collision with root package name */
    e.a f1017z;

    public interface a {
        boolean b();

        boolean c();
    }

    private static class b implements j.a {
        b() {
        }

        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
        }

        public boolean b(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    public static class c extends s0.a {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f1018a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f1019b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f1020c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f1021d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f1022e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1023f;

        public c(int i5, int i6) {
            super(i5, i6);
            this.f1018a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f1018a = cVar.f1018a;
        }
    }

    private class d implements e.a {
        d() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.E;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.f1017z;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.C = (int) (56.0f * f5);
        this.D = (int) (f5 * 4.0f);
        this.f1012u = context;
        this.f1013v = 0;
    }

    static int H(View view, int i5, int i6, int i7, int i8) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i7) - i8, View.MeasureSpec.getMode(i7));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z4 = true;
        boolean z5 = actionMenuItemView != null && actionMenuItemView.e();
        int i9 = 2;
        if (i6 <= 0 || (z5 && i6 < 2)) {
            i9 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i6 * i5, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i10 = measuredWidth / i5;
            if (measuredWidth % i5 != 0) {
                i10++;
            }
            if (!z5 || i10 >= 2) {
                i9 = i10;
            }
        }
        if (cVar.f1018a || !z5) {
            z4 = false;
        }
        cVar.f1021d = z4;
        cVar.f1019b = i9;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i9, 1073741824), makeMeasureSpec);
        return i9;
    }

    private void I(int i5, int i6) {
        int i7;
        boolean z4;
        int i8;
        int i9;
        int i10;
        boolean z5;
        boolean z6;
        int i11;
        boolean z7;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingTop, -2);
        int i12 = size - paddingLeft;
        int i13 = this.C;
        int i14 = i12 / i13;
        int i15 = i12 % i13;
        if (i14 == 0) {
            setMeasuredDimension(i12, 0);
            return;
        }
        int i16 = i13 + (i15 / i14);
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        boolean z8 = false;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        long j5 = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            int i22 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z9 = childAt instanceof ActionMenuItemView;
                int i23 = i19 + 1;
                if (z9) {
                    int i24 = this.D;
                    i11 = i23;
                    z7 = false;
                    childAt.setPadding(i24, 0, i24, 0);
                } else {
                    i11 = i23;
                    z7 = false;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1023f = z7;
                cVar.f1020c = z7 ? 1 : 0;
                cVar.f1019b = z7;
                cVar.f1021d = z7;
                cVar.leftMargin = z7;
                cVar.rightMargin = z7;
                cVar.f1022e = z9 && ((ActionMenuItemView) childAt).e();
                int H = H(childAt, i16, cVar.f1018a ? 1 : i14, childMeasureSpec, paddingTop);
                i20 = Math.max(i20, H);
                if (cVar.f1021d) {
                    i21++;
                }
                if (cVar.f1018a) {
                    z8 = true;
                }
                i14 -= H;
                i17 = Math.max(i17, childAt.getMeasuredHeight());
                if (H == 1) {
                    j5 |= (long) (1 << i18);
                    i17 = i17;
                } else {
                    int i25 = i17;
                }
                i19 = i11;
            }
            i18++;
            size2 = i22;
        }
        int i26 = size2;
        boolean z10 = z8 && i19 == 2;
        boolean z11 = false;
        while (true) {
            if (i21 <= 0 || i14 <= 0) {
                i9 = mode;
                i7 = i12;
                z4 = z11;
                i8 = i17;
            } else {
                int i27 = Integer.MAX_VALUE;
                int i28 = 0;
                int i29 = 0;
                long j6 = 0;
                while (i29 < childCount) {
                    boolean z12 = z11;
                    c cVar2 = (c) getChildAt(i29).getLayoutParams();
                    int i30 = i17;
                    if (cVar2.f1021d) {
                        int i31 = cVar2.f1019b;
                        if (i31 < i27) {
                            j6 = 1 << i29;
                            i27 = i31;
                            i28 = 1;
                        } else if (i31 == i27) {
                            i28++;
                            j6 |= 1 << i29;
                        }
                    }
                    i29++;
                    i17 = i30;
                    z11 = z12;
                }
                z4 = z11;
                i8 = i17;
                j5 |= j6;
                if (i28 > i14) {
                    i9 = mode;
                    i7 = i12;
                    break;
                }
                int i32 = i27 + 1;
                int i33 = 0;
                while (i33 < childCount) {
                    View childAt2 = getChildAt(i33);
                    c cVar3 = (c) childAt2.getLayoutParams();
                    int i34 = i12;
                    int i35 = mode;
                    long j7 = (long) (1 << i33);
                    if ((j6 & j7) == 0) {
                        if (cVar3.f1019b == i32) {
                            j5 |= j7;
                        }
                        z6 = z10;
                    } else {
                        if (!z10 || !cVar3.f1022e || i14 != 1) {
                            z6 = z10;
                        } else {
                            int i36 = this.D;
                            z6 = z10;
                            childAt2.setPadding(i36 + i16, 0, i36, 0);
                        }
                        cVar3.f1019b++;
                        cVar3.f1023f = true;
                        i14--;
                    }
                    i33++;
                    mode = i35;
                    i12 = i34;
                    z10 = z6;
                }
                i17 = i8;
                z11 = true;
            }
        }
        boolean z13 = !z8 && i19 == 1;
        if (i14 <= 0 || j5 == 0 || (i14 >= i19 - 1 && !z13 && i20 <= 1)) {
            i10 = 0;
            z5 = z4;
        } else {
            float bitCount = (float) Long.bitCount(j5);
            if (!z13) {
                i10 = 0;
                if ((j5 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1022e) {
                    bitCount -= 0.5f;
                }
                int i37 = childCount - 1;
                if ((j5 & ((long) (1 << i37))) != 0 && !((c) getChildAt(i37).getLayoutParams()).f1022e) {
                    bitCount -= 0.5f;
                }
            } else {
                i10 = 0;
            }
            int i38 = bitCount > CropImageView.DEFAULT_ASPECT_RATIO ? (int) (((float) (i14 * i16)) / bitCount) : i10;
            z5 = z4;
            for (int i39 = i10; i39 < childCount; i39++) {
                if ((j5 & ((long) (1 << i39))) != 0) {
                    View childAt3 = getChildAt(i39);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1020c = i38;
                        cVar4.f1023f = true;
                        if (i39 == 0 && !cVar4.f1022e) {
                            cVar4.leftMargin = (-i38) / 2;
                        }
                        z5 = true;
                    } else if (cVar4.f1018a) {
                        cVar4.f1020c = i38;
                        cVar4.f1023f = true;
                        cVar4.rightMargin = (-i38) / 2;
                        z5 = true;
                    } else {
                        if (i39 != 0) {
                            cVar4.leftMargin = i38 / 2;
                        }
                        if (i39 != childCount - 1) {
                            cVar4.rightMargin = i38 / 2;
                        }
                    }
                }
            }
        }
        if (z5) {
            for (int i40 = i10; i40 < childCount; i40++) {
                View childAt4 = getChildAt(i40);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1023f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1019b * i16) + cVar5.f1020c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i7, i9 != 1073741824 ? i8 : i26);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public c k(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return i();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.gravity <= 0) {
            cVar.gravity = 16;
        }
        return cVar;
    }

    public c B() {
        c y4 = i();
        y4.f1018a = true;
        return y4;
    }

    /* access modifiers changed from: protected */
    public boolean C(int i5) {
        boolean z4 = false;
        if (i5 == 0) {
            return false;
        }
        View childAt = getChildAt(i5 - 1);
        View childAt2 = getChildAt(i5);
        if (i5 < getChildCount() && (childAt instanceof a)) {
            z4 = false | ((a) childAt).b();
        }
        return (i5 <= 0 || !(childAt2 instanceof a)) ? z4 : z4 | ((a) childAt2).c();
    }

    public boolean D() {
        c cVar = this.f1015x;
        return cVar != null && cVar.B();
    }

    public boolean E() {
        c cVar = this.f1015x;
        return cVar != null && cVar.D();
    }

    public boolean F() {
        c cVar = this.f1015x;
        return cVar != null && cVar.E();
    }

    public boolean G() {
        return this.f1014w;
    }

    public androidx.appcompat.view.menu.e J() {
        return this.f1011t;
    }

    public void K(j.a aVar, e.a aVar2) {
        this.f1016y = aVar;
        this.f1017z = aVar2;
    }

    public boolean L() {
        c cVar = this.f1015x;
        return cVar != null && cVar.K();
    }

    public boolean a(g gVar) {
        return this.f1011t.L(gVar, 0);
    }

    public void b(androidx.appcompat.view.menu.e eVar) {
        this.f1011t = eVar;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f1011t == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.f1011t = eVar;
            eVar.R(new d());
            c cVar = new c(context);
            this.f1015x = cVar;
            cVar.J(true);
            c cVar2 = this.f1015x;
            j.a aVar = this.f1016y;
            if (aVar == null) {
                aVar = new b();
            }
            cVar2.j(aVar);
            this.f1011t.c(this.f1015x, this.f1012u);
            this.f1015x.H(this);
        }
        return this.f1011t;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1015x.A();
    }

    public int getPopupTheme() {
        return this.f1013v;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c cVar = this.f1015x;
        if (cVar != null) {
            cVar.e(false);
            if (this.f1015x.E()) {
                this.f1015x.B();
                this.f1015x.K();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        if (!this.A) {
            super.onLayout(z4, i5, i6, i7, i8);
            return;
        }
        int childCount = getChildCount();
        int i11 = (i8 - i6) / 2;
        int dividerWidth = getDividerWidth();
        int i12 = i7 - i5;
        int paddingRight = (i12 - getPaddingRight()) - getPaddingLeft();
        boolean b5 = r1.b(this);
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1018a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (C(i15)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b5) {
                        i9 = getPaddingLeft() + cVar.leftMargin;
                        i10 = i9 + measuredWidth;
                    } else {
                        i10 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i9 = i10 - measuredWidth;
                    }
                    int i16 = i11 - (measuredHeight / 2);
                    childAt.layout(i9, i16, i10, measuredHeight + i16);
                    paddingRight -= measuredWidth;
                    i13 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    C(i15);
                    i14++;
                }
            }
        }
        if (childCount == 1 && i13 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = (i12 / 2) - (measuredWidth2 / 2);
            int i18 = i11 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth2 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i14 - (i13 ^ 1);
        int max = Math.max(0, i19 > 0 ? paddingRight / i19 : 0);
        if (b5) {
            int width = getWidth() - getPaddingRight();
            for (int i20 = 0; i20 < childCount; i20++) {
                View childAt3 = getChildAt(i20);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1018a) {
                    int i21 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i22 = i11 - (measuredHeight3 / 2);
                    childAt3.layout(i21 - measuredWidth3, i22, i21, measuredHeight3 + i22);
                    width = i21 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt4 = getChildAt(i23);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1018a) {
                int i24 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i25 = i11 - (measuredHeight4 / 2);
                childAt4.layout(i24, i25, i24 + measuredWidth4, measuredHeight4 + i25);
                paddingLeft = i24 + measuredWidth4 + cVar3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        androidx.appcompat.view.menu.e eVar;
        boolean z4 = this.A;
        boolean z5 = View.MeasureSpec.getMode(i5) == 1073741824;
        this.A = z5;
        if (z4 != z5) {
            this.B = 0;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (!(!this.A || (eVar = this.f1011t) == null || size == this.B)) {
            this.B = size;
            eVar.K(true);
        }
        int childCount = getChildCount();
        if (!this.A || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                c cVar = (c) getChildAt(i7).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i5, i6);
            return;
        }
        I(i5, i6);
    }

    public void setExpandedActionViewsExclusive(boolean z4) {
        this.f1015x.G(z4);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.E = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1015x.I(drawable);
    }

    public void setOverflowReserved(boolean z4) {
        this.f1014w = z4;
    }

    public void setPopupTheme(int i5) {
        if (this.f1013v != i5) {
            this.f1013v = i5;
            if (i5 == 0) {
                this.f1012u = getContext();
            } else {
                this.f1012u = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setPresenter(c cVar) {
        this.f1015x = cVar;
        cVar.H(this);
    }

    public void x() {
        c cVar = this.f1015x;
        if (cVar != null) {
            cVar.y();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public c i() {
        c cVar = new c(-2, -2);
        cVar.gravity = 16;
        return cVar;
    }

    /* renamed from: z */
    public c j(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }
}
