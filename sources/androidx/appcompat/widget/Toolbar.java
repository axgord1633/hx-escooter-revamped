package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.h;
import androidx.core.view.k0;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private CharSequence B;
    private CharSequence C;
    private ColorStateList D;
    private ColorStateList E;
    private boolean F;
    private boolean G;
    private final ArrayList<View> H;
    private final ArrayList<View> I;
    private final int[] J;
    f K;
    private final ActionMenuView.e L;
    private l1 M;
    private c N;
    private d O;
    private j.a P;
    private e.a Q;
    private boolean R;
    private final Runnable S;

    /* renamed from: e  reason: collision with root package name */
    private ActionMenuView f1092e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f1093f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f1094g;

    /* renamed from: h  reason: collision with root package name */
    private ImageButton f1095h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f1096i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f1097j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f1098k;

    /* renamed from: l  reason: collision with root package name */
    ImageButton f1099l;

    /* renamed from: m  reason: collision with root package name */
    View f1100m;

    /* renamed from: n  reason: collision with root package name */
    private Context f1101n;

    /* renamed from: o  reason: collision with root package name */
    private int f1102o;

    /* renamed from: p  reason: collision with root package name */
    private int f1103p;

    /* renamed from: q  reason: collision with root package name */
    private int f1104q;

    /* renamed from: r  reason: collision with root package name */
    int f1105r;

    /* renamed from: s  reason: collision with root package name */
    private int f1106s;

    /* renamed from: t  reason: collision with root package name */
    private int f1107t;

    /* renamed from: u  reason: collision with root package name */
    private int f1108u;

    /* renamed from: v  reason: collision with root package name */
    private int f1109v;

    /* renamed from: w  reason: collision with root package name */
    private int f1110w;

    /* renamed from: x  reason: collision with root package name */
    private c1 f1111x;

    /* renamed from: y  reason: collision with root package name */
    private int f1112y;

    /* renamed from: z  reason: collision with root package name */
    private int f1113z;

    class a implements ActionMenuView.e {
        a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.K;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Toolbar.this.O();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements j {

        /* renamed from: e  reason: collision with root package name */
        androidx.appcompat.view.menu.e f1117e;

        /* renamed from: f  reason: collision with root package name */
        androidx.appcompat.view.menu.g f1118f;

        d() {
        }

        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
        }

        public void c(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1117e;
            if (!(eVar2 == null || (gVar = this.f1118f) == null)) {
                eVar2.f(gVar);
            }
            this.f1117e = eVar;
        }

        public boolean d(m mVar) {
            return false;
        }

        public void e(boolean z4) {
            if (this.f1118f != null) {
                androidx.appcompat.view.menu.e eVar = this.f1117e;
                boolean z5 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        } else if (this.f1117e.getItem(i5) == this.f1118f) {
                            z5 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                if (!z5) {
                    h(this.f1117e, this.f1118f);
                }
            }
        }

        public boolean g() {
            return false;
        }

        public boolean h(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            View view = Toolbar.this.f1100m;
            if (view instanceof h.c) {
                ((h.c) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1100m);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1099l);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1100m = null;
            toolbar3.a();
            this.f1118f = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            return true;
        }

        public boolean i(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f1099l.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1099l);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1099l);
            }
            Toolbar.this.f1100m = gVar.getActionView();
            this.f1118f = gVar;
            ViewParent parent2 = Toolbar.this.f1100m.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1100m);
                }
                e m5 = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                m5.f617a = 8388611 | (toolbar4.f1105r & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle);
                m5.f1120b = 2;
                toolbar4.f1100m.setLayoutParams(m5);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1100m);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            gVar.r(true);
            View view = Toolbar.this.f1100m;
            if (view instanceof h.c) {
                ((h.c) view).onActionViewExpanded();
            }
            return true;
        }
    }

    public static class e extends a.C0014a {

        /* renamed from: b  reason: collision with root package name */
        int f1120b = 0;

        public e(int i5, int i6) {
            super(i5, i6);
            this.f617a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public e(a.C0014a aVar) {
            super(aVar);
        }

        public e(e eVar) {
            super((a.C0014a) eVar);
            this.f1120b = eVar.f1120b;
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class g extends t.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: g  reason: collision with root package name */
        int f1121g;

        /* renamed from: h  reason: collision with root package name */
        boolean f1122h;

        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            /* renamed from: c */
            public g[] newArray(int i5) {
                return new g[i5];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1121g = parcel.readInt();
            this.f1122h = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f1121g);
            parcel.writeInt(this.f1122h ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.L);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.A = 8388627;
        this.H = new ArrayList<>();
        this.I = new ArrayList<>();
        this.J = new int[2];
        this.L = new a();
        this.S = new b();
        Context context2 = getContext();
        int[] iArr = d.j.T2;
        k1 u5 = k1.u(context2, attributeSet, iArr, i5, 0);
        k0.M(this, context, iArr, attributeSet, u5.q(), i5, 0);
        this.f1103p = u5.m(d.j.f4209v3, 0);
        this.f1104q = u5.m(d.j.f4164m3, 0);
        this.A = u5.k(d.j.U2, this.A);
        this.f1105r = u5.k(d.j.V2, 48);
        int d5 = u5.d(d.j.f4179p3, 0);
        int i6 = d.j.f4204u3;
        d5 = u5.r(i6) ? u5.d(i6, d5) : d5;
        this.f1110w = d5;
        this.f1109v = d5;
        this.f1108u = d5;
        this.f1107t = d5;
        int d6 = u5.d(d.j.f4194s3, -1);
        if (d6 >= 0) {
            this.f1107t = d6;
        }
        int d7 = u5.d(d.j.f4189r3, -1);
        if (d7 >= 0) {
            this.f1108u = d7;
        }
        int d8 = u5.d(d.j.f4199t3, -1);
        if (d8 >= 0) {
            this.f1109v = d8;
        }
        int d9 = u5.d(d.j.f4184q3, -1);
        if (d9 >= 0) {
            this.f1110w = d9;
        }
        this.f1106s = u5.e(d.j.f4134g3, -1);
        int d10 = u5.d(d.j.f4114c3, Integer.MIN_VALUE);
        int d11 = u5.d(d.j.Y2, Integer.MIN_VALUE);
        int e5 = u5.e(d.j.f4104a3, 0);
        int e6 = u5.e(d.j.f4109b3, 0);
        h();
        this.f1111x.e(e5, e6);
        if (!(d10 == Integer.MIN_VALUE && d11 == Integer.MIN_VALUE)) {
            this.f1111x.g(d10, d11);
        }
        this.f1112y = u5.d(d.j.f4119d3, Integer.MIN_VALUE);
        this.f1113z = u5.d(d.j.Z2, Integer.MIN_VALUE);
        this.f1097j = u5.f(d.j.X2);
        this.f1098k = u5.o(d.j.W2);
        CharSequence o5 = u5.o(d.j.f4174o3);
        if (!TextUtils.isEmpty(o5)) {
            setTitle(o5);
        }
        CharSequence o6 = u5.o(d.j.f4159l3);
        if (!TextUtils.isEmpty(o6)) {
            setSubtitle(o6);
        }
        this.f1101n = getContext();
        setPopupTheme(u5.m(d.j.f4154k3, 0));
        Drawable f5 = u5.f(d.j.f4149j3);
        if (f5 != null) {
            setNavigationIcon(f5);
        }
        CharSequence o7 = u5.o(d.j.f4144i3);
        if (!TextUtils.isEmpty(o7)) {
            setNavigationContentDescription(o7);
        }
        Drawable f6 = u5.f(d.j.f4124e3);
        if (f6 != null) {
            setLogo(f6);
        }
        CharSequence o8 = u5.o(d.j.f4129f3);
        if (!TextUtils.isEmpty(o8)) {
            setLogoDescription(o8);
        }
        int i7 = d.j.f4214w3;
        if (u5.r(i7)) {
            setTitleTextColor(u5.c(i7));
        }
        int i8 = d.j.f4169n3;
        if (u5.r(i8)) {
            setSubtitleTextColor(u5.c(i8));
        }
        int i9 = d.j.f4139h3;
        if (u5.r(i9)) {
            x(u5.m(i9, 0));
        }
        u5.v();
    }

    private int B(View view, int i5, int[] iArr, int i6) {
        e eVar = (e) view.getLayoutParams();
        int i7 = eVar.leftMargin - iArr[0];
        int max = i5 + Math.max(0, i7);
        iArr[0] = Math.max(0, -i7);
        int q5 = q(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q5, max + measuredWidth, view.getMeasuredHeight() + q5);
        return max + measuredWidth + eVar.rightMargin;
    }

    private int C(View view, int i5, int[] iArr, int i6) {
        e eVar = (e) view.getLayoutParams();
        int i7 = eVar.rightMargin - iArr[1];
        int max = i5 - Math.max(0, i7);
        iArr[1] = Math.max(0, -i7);
        int q5 = q(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q5, max, view.getMeasuredHeight() + q5);
        return max - (measuredWidth + eVar.leftMargin);
    }

    private int D(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = marginLayoutParams.leftMargin - iArr[0];
        int i10 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i9) + Math.max(0, i10);
        iArr[0] = Math.max(0, -i9);
        iArr[1] = Math.max(0, -i10);
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + max + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void E(View view, int i5, int i6, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i9 >= 0) {
            if (mode != 0) {
                i9 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i9);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.S);
        post(this.S);
    }

    private boolean M() {
        if (!this.R) {
            return false;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (N(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean N(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i5) {
        boolean z4 = k0.q(this) == 1;
        int childCount = getChildCount();
        int a5 = androidx.core.view.e.a(i5, k0.q(this));
        list.clear();
        if (z4) {
            for (int i6 = childCount - 1; i6 >= 0; i6--) {
                View childAt = getChildAt(i6);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f1120b == 0 && N(childAt) && p(eVar.f617a) == a5) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f1120b == 0 && N(childAt2) && p(eVar2.f617a) == a5) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e m5 = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        m5.f1120b = 1;
        if (!z4 || this.f1100m == null) {
            addView(view, m5);
            return;
        }
        view.setLayoutParams(m5);
        this.I.add(view);
    }

    private MenuInflater getMenuInflater() {
        return new h.g(getContext());
    }

    private void h() {
        if (this.f1111x == null) {
            this.f1111x = new c1();
        }
    }

    private void i() {
        if (this.f1096i == null) {
            this.f1096i = new o(getContext());
        }
    }

    private void j() {
        k();
        if (this.f1092e.J() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f1092e.getMenu();
            if (this.O == null) {
                this.O = new d();
            }
            this.f1092e.setExpandedActionViewsExclusive(true);
            eVar.c(this.O, this.f1101n);
        }
    }

    private void k() {
        if (this.f1092e == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1092e = actionMenuView;
            actionMenuView.setPopupTheme(this.f1102o);
            this.f1092e.setOnMenuItemClickListener(this.L);
            this.f1092e.K(this.P, this.Q);
            e m5 = generateDefaultLayoutParams();
            m5.f617a = 8388613 | (this.f1105r & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle);
            this.f1092e.setLayoutParams(m5);
            c(this.f1092e, false);
        }
    }

    private void l() {
        if (this.f1095h == null) {
            this.f1095h = new m(getContext(), (AttributeSet) null, d.a.K);
            e m5 = generateDefaultLayoutParams();
            m5.f617a = 8388611 | (this.f1105r & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle);
            this.f1095h.setLayoutParams(m5);
        }
    }

    private int p(int i5) {
        int q5 = k0.q(this);
        int a5 = androidx.core.view.e.a(i5, q5) & 7;
        return (a5 == 1 || a5 == 3 || a5 == 5) ? a5 : q5 == 1 ? 5 : 3;
    }

    private int q(View view, int i5) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i5 > 0 ? (measuredHeight - i5) / 2 : 0;
        int r5 = r(eVar.f617a);
        if (r5 == 48) {
            return getPaddingTop() - i6;
        }
        if (r5 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin) - i6;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i7 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i8 = eVar.topMargin;
        if (i7 < i8) {
            i7 = i8;
        } else {
            int i9 = (((height - paddingBottom) - measuredHeight) - i7) - paddingTop;
            int i10 = eVar.bottomMargin;
            if (i9 < i10) {
                i7 = Math.max(0, i7 - (i10 - i9));
            }
        }
        return paddingTop + i7;
    }

    private int r(int i5) {
        int i6 = i5 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        return (i6 == 16 || i6 == 48 || i6 == 80) ? i6 : this.A & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return h.b(marginLayoutParams) + h.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i5 = iArr[0];
        int i6 = iArr[1];
        int size = list.size();
        int i7 = 0;
        int i8 = 0;
        while (i7 < size) {
            View view = list.get(i7);
            e eVar = (e) view.getLayoutParams();
            int i9 = eVar.leftMargin - i5;
            int i10 = eVar.rightMargin - i6;
            int max = Math.max(0, i9);
            int max2 = Math.max(0, i10);
            int max3 = Math.max(0, -i9);
            int max4 = Math.max(0, -i10);
            i8 += max + view.getMeasuredWidth() + max2;
            i7++;
            i6 = max4;
            i5 = max3;
        }
        return i8;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.I.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f1092e;
        return actionMenuView != null && actionMenuView.F();
    }

    /* access modifiers changed from: package-private */
    public void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((e) childAt.getLayoutParams()).f1120b == 2 || childAt == this.f1092e)) {
                removeViewAt(childCount);
                this.I.add(childAt);
            }
        }
    }

    public void H(int i5, int i6) {
        h();
        this.f1111x.g(i5, i6);
    }

    public void I(androidx.appcompat.view.menu.e eVar, c cVar) {
        if (eVar != null || this.f1092e != null) {
            k();
            androidx.appcompat.view.menu.e J2 = this.f1092e.J();
            if (J2 != eVar) {
                if (J2 != null) {
                    J2.O(this.N);
                    J2.O(this.O);
                }
                if (this.O == null) {
                    this.O = new d();
                }
                cVar.G(true);
                if (eVar != null) {
                    eVar.c(cVar, this.f1101n);
                    eVar.c(this.O, this.f1101n);
                } else {
                    cVar.c(this.f1101n, (androidx.appcompat.view.menu.e) null);
                    this.O.c(this.f1101n, (androidx.appcompat.view.menu.e) null);
                    cVar.e(true);
                    this.O.e(true);
                }
                this.f1092e.setPopupTheme(this.f1102o);
                this.f1092e.setPresenter(cVar);
                this.N = cVar;
            }
        }
    }

    public void J(j.a aVar, e.a aVar2) {
        this.P = aVar;
        this.Q = aVar2;
        ActionMenuView actionMenuView = this.f1092e;
        if (actionMenuView != null) {
            actionMenuView.K(aVar, aVar2);
        }
    }

    public void K(Context context, int i5) {
        this.f1104q = i5;
        TextView textView = this.f1094g;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public void L(Context context, int i5) {
        this.f1103p = i5;
        TextView textView = this.f1093f;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public boolean O() {
        ActionMenuView actionMenuView = this.f1092e;
        return actionMenuView != null && actionMenuView.L();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.I.size() - 1; size >= 0; size--) {
            addView(this.I.get(size));
        }
        this.I.clear();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f1092e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f1092e
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.G()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.d():boolean");
    }

    public void e() {
        d dVar = this.O;
        androidx.appcompat.view.menu.g gVar = dVar == null ? null : dVar.f1118f;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1092e;
        if (actionMenuView != null) {
            actionMenuView.x();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f1099l == null) {
            m mVar = new m(getContext(), (AttributeSet) null, d.a.K);
            this.f1099l = mVar;
            mVar.setImageDrawable(this.f1097j);
            this.f1099l.setContentDescription(this.f1098k);
            e m5 = generateDefaultLayoutParams();
            m5.f617a = 8388611 | (this.f1105r & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle);
            m5.f1120b = 2;
            this.f1099l.setLayoutParams(m5);
            this.f1099l.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1099l;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1099l;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        c1 c1Var = this.f1111x;
        if (c1Var != null) {
            return c1Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i5 = this.f1113z;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        c1 c1Var = this.f1111x;
        if (c1Var != null) {
            return c1Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        c1 c1Var = this.f1111x;
        if (c1Var != null) {
            return c1Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        c1 c1Var = this.f1111x;
        if (c1Var != null) {
            return c1Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i5 = this.f1112y;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.J();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.f1092e
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.e r0 = r0.J()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.f1113z
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.getContentInsetEnd()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        return k0.q(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return k0.q(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1112y, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1096i;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1096i;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f1092e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1095h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1095h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public c getOuterActionMenuPresenter() {
        return this.N;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f1092e.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f1101n;
    }

    public int getPopupTheme() {
        return this.f1102o;
    }

    public CharSequence getSubtitle() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public final TextView getSubtitleTextView() {
        return this.f1094g;
    }

    public CharSequence getTitle() {
        return this.B;
    }

    public int getTitleMarginBottom() {
        return this.f1110w;
    }

    public int getTitleMarginEnd() {
        return this.f1108u;
    }

    public int getTitleMarginStart() {
        return this.f1107t;
    }

    public int getTitleMarginTop() {
        return this.f1109v;
    }

    /* access modifiers changed from: package-private */
    public final TextView getTitleTextView() {
        return this.f1093f;
    }

    public n0 getWrapper() {
        if (this.M == null) {
            this.M = new l1(this, true);
        }
        return this.M;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    /* renamed from: n */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0014a ? new e((a.C0014a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.S);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.G = false;
        }
        if (!this.G) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0295 A[LOOP:0: B:106:0x0293->B:107:0x0295, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02b7 A[LOOP:1: B:109:0x02b5->B:110:0x02b7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02f0 A[LOOP:2: B:117:0x02ee->B:118:0x02f0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x021d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.view.k0.q(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = r2
            goto L_0x000d
        L_0x000c:
            r1 = r3
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.J
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.view.k0.r(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = r3
        L_0x003b:
            android.widget.ImageButton r13 = r0.f1095h
            boolean r13 = r0.N(r13)
            if (r13 == 0) goto L_0x0053
            android.widget.ImageButton r13 = r0.f1095h
            if (r1 == 0) goto L_0x004e
            int r13 = r0.C(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0055
        L_0x004e:
            int r13 = r0.B(r13, r6, r11, r12)
            goto L_0x0054
        L_0x0053:
            r13 = r6
        L_0x0054:
            r14 = r10
        L_0x0055:
            android.widget.ImageButton r15 = r0.f1099l
            boolean r15 = r0.N(r15)
            if (r15 == 0) goto L_0x006a
            android.widget.ImageButton r15 = r0.f1099l
            if (r1 == 0) goto L_0x0066
            int r14 = r0.C(r15, r14, r11, r12)
            goto L_0x006a
        L_0x0066:
            int r13 = r0.B(r15, r13, r11, r12)
        L_0x006a:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1092e
            boolean r15 = r0.N(r15)
            if (r15 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1092e
            if (r1 == 0) goto L_0x007b
            int r13 = r0.B(r15, r13, r11, r12)
            goto L_0x007f
        L_0x007b:
            int r14 = r0.C(r15, r14, r11, r12)
        L_0x007f:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f1100m
            boolean r13 = r0.N(r13)
            if (r13 == 0) goto L_0x00ba
            android.view.View r13 = r0.f1100m
            if (r1 == 0) goto L_0x00b6
            int r10 = r0.C(r13, r10, r11, r12)
            goto L_0x00ba
        L_0x00b6:
            int r2 = r0.B(r13, r2, r11, r12)
        L_0x00ba:
            android.widget.ImageView r13 = r0.f1096i
            boolean r13 = r0.N(r13)
            if (r13 == 0) goto L_0x00cf
            android.widget.ImageView r13 = r0.f1096i
            if (r1 == 0) goto L_0x00cb
            int r10 = r0.C(r13, r10, r11, r12)
            goto L_0x00cf
        L_0x00cb:
            int r2 = r0.B(r13, r2, r11, r12)
        L_0x00cf:
            android.widget.TextView r13 = r0.f1093f
            boolean r13 = r0.N(r13)
            android.widget.TextView r14 = r0.f1094g
            boolean r14 = r0.N(r14)
            if (r13 == 0) goto L_0x00f6
            android.widget.TextView r15 = r0.f1093f
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r15 = (androidx.appcompat.widget.Toolbar.e) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f1093f
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x00f9
        L_0x00f6:
            r23 = r7
            r3 = 0
        L_0x00f9:
            if (r14 == 0) goto L_0x0113
            android.widget.TextView r7 = r0.f1094g
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r7 = (androidx.appcompat.widget.Toolbar.e) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f1094g
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x0115
        L_0x0113:
            r16 = r4
        L_0x0115:
            if (r13 != 0) goto L_0x0121
            if (r14 == 0) goto L_0x011a
            goto L_0x0121
        L_0x011a:
            r18 = r6
            r22 = r12
        L_0x011e:
            r1 = 0
            goto L_0x0286
        L_0x0121:
            if (r13 == 0) goto L_0x0126
            android.widget.TextView r4 = r0.f1093f
            goto L_0x0128
        L_0x0126:
            android.widget.TextView r4 = r0.f1094g
        L_0x0128:
            if (r14 == 0) goto L_0x012d
            android.widget.TextView r7 = r0.f1094g
            goto L_0x012f
        L_0x012d:
            android.widget.TextView r7 = r0.f1093f
        L_0x012f:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r4 = (androidx.appcompat.widget.Toolbar.e) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r7 = (androidx.appcompat.widget.Toolbar.e) r7
            if (r13 == 0) goto L_0x0145
            android.widget.TextView r15 = r0.f1093f
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x014f
        L_0x0145:
            if (r14 == 0) goto L_0x0152
            android.widget.TextView r15 = r0.f1094g
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x0152
        L_0x014f:
            r17 = 1
            goto L_0x0154
        L_0x0152:
            r17 = 0
        L_0x0154:
            int r15 = r0.A
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x019c
            r6 = 80
            if (r15 == r6) goto L_0x018e
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.f1109v
            r24 = r2
            int r2 = r15 + r12
            if (r6 >= r2) goto L_0x0177
            int r6 = r15 + r12
            goto L_0x018c
        L_0x0177:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.f1110w
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x018c
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x018c:
            int r8 = r8 + r6
            goto L_0x01ab
        L_0x018e:
            r24 = r2
            r22 = r12
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.f1110w
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01ab
        L_0x019c:
            r24 = r2
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.f1109v
            int r8 = r2 + r3
        L_0x01ab:
            if (r1 == 0) goto L_0x021d
            if (r17 == 0) goto L_0x01b2
            int r1 = r0.f1107t
            goto L_0x01b3
        L_0x01b2:
            r1 = 0
        L_0x01b3:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01ea
            android.widget.TextView r1 = r0.f1093f
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r1 = (androidx.appcompat.widget.Toolbar.e) r1
            android.widget.TextView r2 = r0.f1093f
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.f1093f
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1093f
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.f1108u
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01eb
        L_0x01ea:
            r2 = r10
        L_0x01eb:
            if (r14 == 0) goto L_0x0211
            android.widget.TextView r1 = r0.f1094g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r1 = (androidx.appcompat.widget.Toolbar.e) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.f1094g
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.f1094g
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1094g
            r4.layout(r1, r8, r10, r3)
            int r1 = r0.f1108u
            int r1 = r10 - r1
            goto L_0x0212
        L_0x0211:
            r1 = r10
        L_0x0212:
            if (r17 == 0) goto L_0x0219
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x0219:
            r2 = r24
            goto L_0x011e
        L_0x021d:
            if (r17 == 0) goto L_0x0223
            int r7 = r0.f1107t
            r1 = 0
            goto L_0x0225
        L_0x0223:
            r1 = 0
            r7 = 0
        L_0x0225:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r2 = r24 + r2
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x025a
            android.widget.TextView r3 = r0.f1093f
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r3 = (androidx.appcompat.widget.Toolbar.e) r3
            android.widget.TextView r4 = r0.f1093f
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.f1093f
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1093f
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.f1108u
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x025b
        L_0x025a:
            r4 = r2
        L_0x025b:
            if (r14 == 0) goto L_0x027f
            android.widget.TextView r3 = r0.f1094g
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r3 = (androidx.appcompat.widget.Toolbar.e) r3
            int r3 = r3.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.f1094g
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r2
            android.widget.TextView r5 = r0.f1094g
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1094g
            r6.layout(r2, r8, r3, r5)
            int r5 = r0.f1108u
            int r3 = r3 + r5
            goto L_0x0280
        L_0x027f:
            r3 = r2
        L_0x0280:
            if (r17 == 0) goto L_0x0286
            int r2 = java.lang.Math.max(r4, r3)
        L_0x0286:
            java.util.ArrayList<android.view.View> r3 = r0.H
            r4 = 3
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.H
            int r3 = r3.size()
            r7 = r1
        L_0x0293:
            if (r7 >= r3) goto L_0x02a6
            java.util.ArrayList<android.view.View> r4 = r0.H
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.B(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x0293
        L_0x02a6:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.H
            r4 = 5
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.H
            int r3 = r3.size()
            r7 = r1
        L_0x02b5:
            if (r7 >= r3) goto L_0x02c6
            java.util.ArrayList<android.view.View> r4 = r0.H
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.C(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02b5
        L_0x02c6:
            java.util.ArrayList<android.view.View> r3 = r0.H
            r4 = 1
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.H
            int r3 = r0.u(r3, r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02e1
            goto L_0x02e8
        L_0x02e1:
            if (r3 <= r10) goto L_0x02e7
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02e8
        L_0x02e7:
            r2 = r6
        L_0x02e8:
            java.util.ArrayList<android.view.View> r3 = r0.H
            int r3 = r3.size()
        L_0x02ee:
            if (r1 >= r3) goto L_0x02ff
            java.util.ArrayList<android.view.View> r4 = r0.H
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.B(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02ee
        L_0x02ff:
            java.util.ArrayList<android.view.View> r1 = r0.H
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr = this.J;
        char b5 = r1.b(this);
        int i14 = 0;
        char c5 = b5 ^ 1;
        if (N(this.f1095h)) {
            E(this.f1095h, i5, 0, i6, 0, this.f1106s);
            i9 = this.f1095h.getMeasuredWidth() + s(this.f1095h);
            i8 = Math.max(0, this.f1095h.getMeasuredHeight() + t(this.f1095h));
            i7 = View.combineMeasuredStates(0, this.f1095h.getMeasuredState());
        } else {
            i9 = 0;
            i8 = 0;
            i7 = 0;
        }
        if (N(this.f1099l)) {
            E(this.f1099l, i5, 0, i6, 0, this.f1106s);
            i9 = this.f1099l.getMeasuredWidth() + s(this.f1099l);
            i8 = Math.max(i8, this.f1099l.getMeasuredHeight() + t(this.f1099l));
            i7 = View.combineMeasuredStates(i7, this.f1099l.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i9);
        iArr[b5] = Math.max(0, currentContentInsetStart - i9);
        if (N(this.f1092e)) {
            E(this.f1092e, i5, max, i6, 0, this.f1106s);
            i10 = this.f1092e.getMeasuredWidth() + s(this.f1092e);
            i8 = Math.max(i8, this.f1092e.getMeasuredHeight() + t(this.f1092e));
            i7 = View.combineMeasuredStates(i7, this.f1092e.getMeasuredState());
        } else {
            i10 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i10);
        iArr[c5] = Math.max(0, currentContentInsetEnd - i10);
        if (N(this.f1100m)) {
            max2 += D(this.f1100m, i5, max2, i6, 0, iArr);
            i8 = Math.max(i8, this.f1100m.getMeasuredHeight() + t(this.f1100m));
            i7 = View.combineMeasuredStates(i7, this.f1100m.getMeasuredState());
        }
        if (N(this.f1096i)) {
            max2 += D(this.f1096i, i5, max2, i6, 0, iArr);
            i8 = Math.max(i8, this.f1096i.getMeasuredHeight() + t(this.f1096i));
            i7 = View.combineMeasuredStates(i7, this.f1096i.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (((e) childAt.getLayoutParams()).f1120b == 0 && N(childAt)) {
                max2 += D(childAt, i5, max2, i6, 0, iArr);
                i8 = Math.max(i8, childAt.getMeasuredHeight() + t(childAt));
                i7 = View.combineMeasuredStates(i7, childAt.getMeasuredState());
            }
        }
        int i16 = this.f1109v + this.f1110w;
        int i17 = this.f1107t + this.f1108u;
        if (N(this.f1093f)) {
            D(this.f1093f, i5, max2 + i17, i6, i16, iArr);
            int measuredWidth = this.f1093f.getMeasuredWidth() + s(this.f1093f);
            i11 = this.f1093f.getMeasuredHeight() + t(this.f1093f);
            i13 = View.combineMeasuredStates(i7, this.f1093f.getMeasuredState());
            i12 = measuredWidth;
        } else {
            i11 = 0;
            i13 = i7;
            i12 = 0;
        }
        if (N(this.f1094g)) {
            i12 = Math.max(i12, D(this.f1094g, i5, max2 + i17, i6, i11 + i16, iArr));
            i11 += this.f1094g.getMeasuredHeight() + t(this.f1094g);
            i13 = View.combineMeasuredStates(i13, this.f1094g.getMeasuredState());
        } else {
            int i18 = i13;
        }
        int max3 = Math.max(i8, i11);
        int paddingLeft = max2 + i12 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i5, -16777216 & i13);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i6, i13 << 16);
        if (!M()) {
            i14 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i14);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        ActionMenuView actionMenuView = this.f1092e;
        androidx.appcompat.view.menu.e J2 = actionMenuView != null ? actionMenuView.J() : null;
        int i5 = gVar.f1121g;
        if (!(i5 == 0 || this.O == null || J2 == null || (findItem = J2.findItem(i5)) == null)) {
            findItem.expandActionView();
        }
        if (gVar.f1122h) {
            F();
        }
    }

    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        h();
        c1 c1Var = this.f1111x;
        boolean z4 = true;
        if (i5 != 1) {
            z4 = false;
        }
        c1Var.f(z4);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        g gVar2 = new g(super.onSaveInstanceState());
        d dVar = this.O;
        if (!(dVar == null || (gVar = dVar.f1118f) == null)) {
            gVar2.f1121g = gVar.getItemId();
        }
        gVar2.f1122h = A();
        return gVar2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.F = false;
        }
        if (!this.F) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.F = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.F = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i5) {
        setCollapseContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f1099l;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i5) {
        setCollapseIcon(e.a.b(getContext(), i5));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f1099l.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f1099l;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f1097j);
        }
    }

    public void setCollapsible(boolean z4) {
        this.R = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.f1113z) {
            this.f1113z = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.f1112y) {
            this.f1112y = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i5) {
        setLogo(e.a.b(getContext(), i5));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f1096i)) {
                c(this.f1096i, true);
            }
        } else {
            ImageView imageView = this.f1096i;
            if (imageView != null && y(imageView)) {
                removeView(this.f1096i);
                this.I.remove(this.f1096i);
            }
        }
        ImageView imageView2 = this.f1096i;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i5) {
        setLogoDescription(getContext().getText(i5));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f1096i;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i5) {
        setNavigationContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f1095h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i5) {
        setNavigationIcon(e.a.b(getContext(), i5));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f1095h)) {
                c(this.f1095h, true);
            }
        } else {
            ImageButton imageButton = this.f1095h;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f1095h);
                this.I.remove(this.f1095h);
            }
        }
        ImageButton imageButton2 = this.f1095h;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f1095h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.K = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f1092e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i5) {
        if (this.f1102o != i5) {
            this.f1102o = i5;
            if (i5 == 0) {
                this.f1101n = getContext();
            } else {
                this.f1101n = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setSubtitle(int i5) {
        setSubtitle(getContext().getText(i5));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1094g == null) {
                Context context = getContext();
                h0 h0Var = new h0(context);
                this.f1094g = h0Var;
                h0Var.setSingleLine();
                this.f1094g.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f1104q;
                if (i5 != 0) {
                    this.f1094g.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f1094g.setTextColor(colorStateList);
                }
            }
            if (!y(this.f1094g)) {
                c(this.f1094g, true);
            }
        } else {
            TextView textView = this.f1094g;
            if (textView != null && y(textView)) {
                removeView(this.f1094g);
                this.I.remove(this.f1094g);
            }
        }
        TextView textView2 = this.f1094g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setSubtitleTextColor(int i5) {
        setSubtitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        TextView textView = this.f1094g;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i5) {
        setTitle(getContext().getText(i5));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1093f == null) {
                Context context = getContext();
                h0 h0Var = new h0(context);
                this.f1093f = h0Var;
                h0Var.setSingleLine();
                this.f1093f.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f1103p;
                if (i5 != 0) {
                    this.f1093f.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.D;
                if (colorStateList != null) {
                    this.f1093f.setTextColor(colorStateList);
                }
            }
            if (!y(this.f1093f)) {
                c(this.f1093f, true);
            }
        } else {
            TextView textView = this.f1093f;
            if (textView != null && y(textView)) {
                removeView(this.f1093f);
                this.I.remove(this.f1093f);
            }
        }
        TextView textView2 = this.f1093f;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.B = charSequence;
    }

    public void setTitleMarginBottom(int i5) {
        this.f1110w = i5;
        requestLayout();
    }

    public void setTitleMarginEnd(int i5) {
        this.f1108u = i5;
        requestLayout();
    }

    public void setTitleMarginStart(int i5) {
        this.f1107t = i5;
        requestLayout();
    }

    public void setTitleMarginTop(int i5) {
        this.f1109v = i5;
        requestLayout();
    }

    public void setTitleTextColor(int i5) {
        setTitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        TextView textView = this.f1093f;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean v() {
        d dVar = this.O;
        return (dVar == null || dVar.f1118f == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f1092e;
        return actionMenuView != null && actionMenuView.D();
    }

    public void x(int i5) {
        getMenuInflater().inflate(i5, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f1092e;
        return actionMenuView != null && actionMenuView.E();
    }
}
