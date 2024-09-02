package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

class c extends androidx.appcompat.view.menu.a implements b.a {
    private int A;
    private final SparseBooleanArray B = new SparseBooleanArray();
    e C;
    a D;
    C0018c E;
    private b F;
    final f G = new f();
    int H;

    /* renamed from: o  reason: collision with root package name */
    d f1151o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f1152p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1153q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1154r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1155s;

    /* renamed from: t  reason: collision with root package name */
    private int f1156t;

    /* renamed from: u  reason: collision with root package name */
    private int f1157u;

    /* renamed from: v  reason: collision with root package name */
    private int f1158v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1159w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1160x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f1161y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1162z;

    private class a extends i {
        public a(Context context, m mVar, View view) {
            super(context, mVar, view, false, d.a.f3973l);
            if (!((g) mVar.getItem()).l()) {
                View view2 = c.this.f1151o;
                f(view2 == null ? (View) c.this.f818m : view2);
            }
            j(c.this.G);
        }

        /* access modifiers changed from: protected */
        public void e() {
            c cVar = c.this;
            cVar.D = null;
            cVar.H = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        public i.e a() {
            a aVar = c.this.D;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    private class C0018c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        private e f1165e;

        public C0018c(e eVar) {
            this.f1165e = eVar;
        }

        public void run() {
            if (c.this.f812g != null) {
                c.this.f812g.d();
            }
            View view = (View) c.this.f818m;
            if (!(view == null || view.getWindowToken() == null || !this.f1165e.m())) {
                c.this.C = this.f1165e;
            }
            c.this.E = null;
        }
    }

    private class d extends o implements ActionMenuView.a {

        class a extends r0 {

            /* renamed from: n  reason: collision with root package name */
            final /* synthetic */ c f1168n;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(View view, c cVar) {
                super(view);
                this.f1168n = cVar;
            }

            public i.e b() {
                e eVar = c.this.C;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            public boolean c() {
                c.this.K();
                return true;
            }

            public boolean d() {
                c cVar = c.this;
                if (cVar.E != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, (AttributeSet) null, d.a.f3972k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            n1.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        public boolean b() {
            return false;
        }

        public boolean c() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i5, int i6, int i7, int i8) {
            boolean frame = super.setFrame(i5, i6, i7, i8);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.k(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class e extends i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z4) {
            super(context, eVar, view, z4, d.a.f3973l);
            h(8388613);
            j(c.this.G);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (c.this.f812g != null) {
                c.this.f812g.close();
            }
            c.this.C = null;
            super.e();
        }
    }

    private class f implements j.a {
        f() {
        }

        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
            if (eVar instanceof m) {
                eVar.D().e(false);
            }
            j.a m5 = c.this.m();
            if (m5 != null) {
                m5.a(eVar, z4);
            }
        }

        public boolean b(androidx.appcompat.view.menu.e eVar) {
            if (eVar == c.this.f812g) {
                return false;
            }
            c.this.H = ((m) eVar).getItem().getItemId();
            j.a m5 = c.this.m();
            if (m5 != null) {
                return m5.b(eVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, d.g.f4066c, d.g.f4065b);
    }

    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f818m;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f1151o;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1153q) {
            return this.f1152p;
        }
        return null;
    }

    public boolean B() {
        k kVar;
        C0018c cVar = this.E;
        if (cVar == null || (kVar = this.f818m) == null) {
            e eVar = this.C;
            if (eVar == null) {
                return false;
            }
            eVar.b();
            return true;
        }
        ((View) kVar).removeCallbacks(cVar);
        this.E = null;
        return true;
    }

    public boolean C() {
        a aVar = this.D;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.E != null || E();
    }

    public boolean E() {
        e eVar = this.C;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f1159w) {
            this.f1158v = h.a.b(this.f811f).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f812g;
        if (eVar != null) {
            eVar.K(true);
        }
    }

    public void G(boolean z4) {
        this.f1162z = z4;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f818m = actionMenuView;
        actionMenuView.b(this.f812g);
    }

    public void I(Drawable drawable) {
        d dVar = this.f1151o;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f1153q = true;
        this.f1152p = drawable;
    }

    public void J(boolean z4) {
        this.f1154r = z4;
        this.f1155s = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f1154r || E() || (eVar = this.f812g) == null || this.f818m == null || this.E != null || eVar.z().isEmpty()) {
            return false;
        }
        C0018c cVar = new C0018c(new e(this.f811f, this.f812g, this.f1151o, true));
        this.E = cVar;
        ((View) this.f818m).post(cVar);
        return true;
    }

    public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
        y();
        super.a(eVar, z4);
    }

    public void c(Context context, androidx.appcompat.view.menu.e eVar) {
        super.c(context, eVar);
        Resources resources = context.getResources();
        h.a b5 = h.a.b(context);
        if (!this.f1155s) {
            this.f1154r = b5.h();
        }
        if (!this.f1161y) {
            this.f1156t = b5.c();
        }
        if (!this.f1159w) {
            this.f1158v = b5.d();
        }
        int i5 = this.f1156t;
        if (this.f1154r) {
            if (this.f1151o == null) {
                d dVar = new d(this.f810e);
                this.f1151o = dVar;
                if (this.f1153q) {
                    dVar.setImageDrawable(this.f1152p);
                    this.f1152p = null;
                    this.f1153q = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1151o.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i5 -= this.f1151o.getMeasuredWidth();
        } else {
            this.f1151o = null;
        }
        this.f1157u = i5;
        this.A = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean d(m mVar) {
        boolean z4 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        m mVar2 = mVar;
        while (mVar2.e0() != this.f812g) {
            mVar2 = (m) mVar2.e0();
        }
        View z5 = z(mVar2.getItem());
        if (z5 == null) {
            return false;
        }
        this.H = mVar.getItem().getItemId();
        int size = mVar.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i5);
            if (item.isVisible() && item.getIcon() != null) {
                z4 = true;
                break;
            }
            i5++;
        }
        a aVar = new a(this.f811f, mVar, z5);
        this.D = aVar;
        aVar.g(z4);
        this.D.k();
        super.d(mVar);
        return true;
    }

    public void e(boolean z4) {
        k kVar;
        super.e(z4);
        ((View) this.f818m).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f812g;
        boolean z5 = false;
        if (eVar != null) {
            ArrayList<g> s5 = eVar.s();
            int size = s5.size();
            for (int i5 = 0; i5 < size; i5++) {
                androidx.core.view.b b5 = s5.get(i5).b();
                if (b5 != null) {
                    b5.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f812g;
        ArrayList<g> z6 = eVar2 != null ? eVar2.z() : null;
        if (this.f1154r && z6 != null) {
            int size2 = z6.size();
            if (size2 == 1) {
                z5 = !z6.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z5 = true;
            }
        }
        d dVar = this.f1151o;
        if (z5) {
            if (dVar == null) {
                this.f1151o = new d(this.f810e);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1151o.getParent();
            if (viewGroup != this.f818m) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1151o);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f818m;
                actionMenuView.addView(this.f1151o, actionMenuView.B());
            }
        } else if (dVar != null && dVar.getParent() == (kVar = this.f818m)) {
            ((ViewGroup) kVar).removeView(this.f1151o);
        }
        ((ActionMenuView) this.f818m).setOverflowReserved(this.f1154r);
    }

    public void f(g gVar, k.a aVar) {
        aVar.d(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f818m);
        if (this.F == null) {
            this.F = new b();
        }
        actionMenuItemView.setPopupCallback(this.F);
    }

    public boolean g() {
        int i5;
        ArrayList<g> arrayList;
        int i6;
        int i7;
        int i8;
        boolean z4;
        c cVar = this;
        androidx.appcompat.view.menu.e eVar = cVar.f812g;
        View view = null;
        boolean z5 = false;
        if (eVar != null) {
            arrayList = eVar.E();
            i5 = arrayList.size();
        } else {
            arrayList = null;
            i5 = 0;
        }
        int i9 = cVar.f1158v;
        int i10 = cVar.f1157u;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f818m;
        boolean z6 = false;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i5; i13++) {
            g gVar = arrayList.get(i13);
            if (gVar.o()) {
                i11++;
            } else if (gVar.n()) {
                i12++;
            } else {
                z6 = true;
            }
            if (cVar.f1162z && gVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (cVar.f1154r && (z6 || i12 + i11 > i9)) {
            i9--;
        }
        int i14 = i9 - i11;
        SparseBooleanArray sparseBooleanArray = cVar.B;
        sparseBooleanArray.clear();
        if (cVar.f1160x) {
            int i15 = cVar.A;
            i6 = i10 / i15;
            i7 = i15 + ((i10 % i15) / i6);
        } else {
            i7 = 0;
            i6 = 0;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < i5) {
            g gVar2 = arrayList.get(i16);
            if (gVar2.o()) {
                View n5 = cVar.n(gVar2, view, viewGroup);
                if (cVar.f1160x) {
                    i6 -= ActionMenuView.H(n5, i7, i6, makeMeasureSpec, z5 ? 1 : 0);
                } else {
                    n5.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n5.getMeasuredWidth();
                i10 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z4 = z5;
                i8 = i5;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z7 = sparseBooleanArray.get(groupId2);
                boolean z8 = (i14 > 0 || z7) && i10 > 0 && (!cVar.f1160x || i6 > 0);
                boolean z9 = z8;
                i8 = i5;
                if (z8) {
                    View n6 = cVar.n(gVar2, (View) null, viewGroup);
                    if (cVar.f1160x) {
                        int H2 = ActionMenuView.H(n6, i7, i6, makeMeasureSpec, 0);
                        i6 -= H2;
                        if (H2 == 0) {
                            z9 = false;
                        }
                    } else {
                        n6.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z10 = z9;
                    int measuredWidth2 = n6.getMeasuredWidth();
                    i10 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z8 = z10 & (!cVar.f1160x ? i10 + i17 > 0 : i10 >= 0);
                }
                if (z8 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z7) {
                    sparseBooleanArray.put(groupId2, false);
                    int i18 = 0;
                    while (i18 < i16) {
                        g gVar3 = arrayList.get(i18);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i14++;
                            }
                            gVar3.u(false);
                        }
                        i18++;
                    }
                }
                if (z8) {
                    i14--;
                }
                gVar2.u(z8);
                z4 = false;
            } else {
                z4 = z5;
                i8 = i5;
                gVar2.u(z4);
            }
            i16++;
            z5 = z4;
            i5 = i8;
            view = null;
            cVar = this;
        }
        return true;
    }

    public boolean l(ViewGroup viewGroup, int i5) {
        if (viewGroup.getChildAt(i5) == this.f1151o) {
            return false;
        }
        return super.l(viewGroup, i5);
    }

    public View n(g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.k(layoutParams));
        }
        return actionView;
    }

    public k o(ViewGroup viewGroup) {
        k kVar = this.f818m;
        k o5 = super.o(viewGroup);
        if (kVar != o5) {
            ((ActionMenuView) o5).setPresenter(this);
        }
        return o5;
    }

    public boolean q(int i5, g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
