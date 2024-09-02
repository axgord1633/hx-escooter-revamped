package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.k0;
import androidx.core.view.k1;
import androidx.core.view.m1;
import com.yalantis.ucrop.view.CropImageView;
import d.e;
import d.f;
import d.h;
import d.j;

public class l1 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1310a;

    /* renamed from: b  reason: collision with root package name */
    private int f1311b;

    /* renamed from: c  reason: collision with root package name */
    private View f1312c;

    /* renamed from: d  reason: collision with root package name */
    private View f1313d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1314e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1315f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1316g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1317h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f1318i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f1319j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f1320k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f1321l;

    /* renamed from: m  reason: collision with root package name */
    boolean f1322m;

    /* renamed from: n  reason: collision with root package name */
    private c f1323n;

    /* renamed from: o  reason: collision with root package name */
    private int f1324o;

    /* renamed from: p  reason: collision with root package name */
    private int f1325p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1326q;

    class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        final i.a f1327e;

        a() {
            this.f1327e = new i.a(l1.this.f1310a.getContext(), 0, 16908332, 0, 0, l1.this.f1318i);
        }

        public void onClick(View view) {
            l1 l1Var = l1.this;
            Window.Callback callback = l1Var.f1321l;
            if (callback != null && l1Var.f1322m) {
                callback.onMenuItemSelected(0, this.f1327e);
            }
        }
    }

    class b extends m1 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1329a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1330b;

        b(int i5) {
            this.f1330b = i5;
        }

        public void a(View view) {
            this.f1329a = true;
        }

        public void b(View view) {
            if (!this.f1329a) {
                l1.this.f1310a.setVisibility(this.f1330b);
            }
        }

        public void c(View view) {
            l1.this.f1310a.setVisibility(0);
        }
    }

    public l1(Toolbar toolbar, boolean z4) {
        this(toolbar, z4, h.f4084a, e.f4025n);
    }

    public l1(Toolbar toolbar, boolean z4, int i5, int i6) {
        Drawable drawable;
        this.f1324o = 0;
        this.f1325p = 0;
        this.f1310a = toolbar;
        this.f1318i = toolbar.getTitle();
        this.f1319j = toolbar.getSubtitle();
        this.f1317h = this.f1318i != null;
        this.f1316g = toolbar.getNavigationIcon();
        k1 u5 = k1.u(toolbar.getContext(), (AttributeSet) null, j.f4100a, d.a.f3964c, 0);
        this.f1326q = u5.f(j.f4155l);
        if (z4) {
            CharSequence o5 = u5.o(j.f4185r);
            if (!TextUtils.isEmpty(o5)) {
                F(o5);
            }
            CharSequence o6 = u5.o(j.f4175p);
            if (!TextUtils.isEmpty(o6)) {
                E(o6);
            }
            Drawable f5 = u5.f(j.f4165n);
            if (f5 != null) {
                A(f5);
            }
            Drawable f6 = u5.f(j.f4160m);
            if (f6 != null) {
                setIcon(f6);
            }
            if (this.f1316g == null && (drawable = this.f1326q) != null) {
                D(drawable);
            }
            o(u5.j(j.f4135h, 0));
            int m5 = u5.m(j.f4130g, 0);
            if (m5 != 0) {
                y(LayoutInflater.from(this.f1310a.getContext()).inflate(m5, this.f1310a, false));
                o(this.f1311b | 16);
            }
            int l5 = u5.l(j.f4145j, 0);
            if (l5 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1310a.getLayoutParams();
                layoutParams.height = l5;
                this.f1310a.setLayoutParams(layoutParams);
            }
            int d5 = u5.d(j.f4125f, -1);
            int d6 = u5.d(j.f4120e, -1);
            if (d5 >= 0 || d6 >= 0) {
                this.f1310a.H(Math.max(d5, 0), Math.max(d6, 0));
            }
            int m6 = u5.m(j.f4190s, 0);
            if (m6 != 0) {
                Toolbar toolbar2 = this.f1310a;
                toolbar2.L(toolbar2.getContext(), m6);
            }
            int m7 = u5.m(j.f4180q, 0);
            if (m7 != 0) {
                Toolbar toolbar3 = this.f1310a;
                toolbar3.K(toolbar3.getContext(), m7);
            }
            int m8 = u5.m(j.f4170o, 0);
            if (m8 != 0) {
                this.f1310a.setPopupTheme(m8);
            }
        } else {
            this.f1311b = x();
        }
        u5.v();
        z(i5);
        this.f1320k = this.f1310a.getNavigationContentDescription();
        this.f1310a.setNavigationOnClickListener(new a());
    }

    private void G(CharSequence charSequence) {
        this.f1318i = charSequence;
        if ((this.f1311b & 8) != 0) {
            this.f1310a.setTitle(charSequence);
        }
    }

    private void H() {
        if ((this.f1311b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1320k)) {
            this.f1310a.setNavigationContentDescription(this.f1325p);
        } else {
            this.f1310a.setNavigationContentDescription(this.f1320k);
        }
    }

    private void I() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.f1311b & 4) != 0) {
            toolbar = this.f1310a;
            drawable = this.f1316g;
            if (drawable == null) {
                drawable = this.f1326q;
            }
        } else {
            toolbar = this.f1310a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void J() {
        Drawable drawable;
        int i5 = this.f1311b;
        if ((i5 & 2) == 0) {
            drawable = null;
        } else if ((i5 & 1) == 0 || (drawable = this.f1315f) == null) {
            drawable = this.f1314e;
        }
        this.f1310a.setLogo(drawable);
    }

    private int x() {
        if (this.f1310a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1326q = this.f1310a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f1315f = drawable;
        J();
    }

    public void B(int i5) {
        C(i5 == 0 ? null : getContext().getString(i5));
    }

    public void C(CharSequence charSequence) {
        this.f1320k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.f1316g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.f1319j = charSequence;
        if ((this.f1311b & 8) != 0) {
            this.f1310a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.f1317h = true;
        G(charSequence);
    }

    public void a(Menu menu, j.a aVar) {
        if (this.f1323n == null) {
            c cVar = new c(this.f1310a.getContext());
            this.f1323n = cVar;
            cVar.p(f.f4044g);
        }
        this.f1323n.j(aVar);
        this.f1310a.I((androidx.appcompat.view.menu.e) menu, this.f1323n);
    }

    public boolean b() {
        return this.f1310a.A();
    }

    public void c() {
        this.f1322m = true;
    }

    public void collapseActionView() {
        this.f1310a.e();
    }

    public boolean d() {
        return this.f1310a.z();
    }

    public boolean e() {
        return this.f1310a.w();
    }

    public boolean f() {
        return this.f1310a.O();
    }

    public boolean g() {
        return this.f1310a.d();
    }

    public Context getContext() {
        return this.f1310a.getContext();
    }

    public CharSequence getTitle() {
        return this.f1310a.getTitle();
    }

    public void h() {
        this.f1310a.f();
    }

    public void i(j.a aVar, e.a aVar2) {
        this.f1310a.J(aVar, aVar2);
    }

    public void j(int i5) {
        this.f1310a.setVisibility(i5);
    }

    public void k(d1 d1Var) {
        Toolbar toolbar;
        View view = this.f1312c;
        if (view != null && view.getParent() == (toolbar = this.f1310a)) {
            toolbar.removeView(this.f1312c);
        }
        this.f1312c = d1Var;
        if (d1Var != null && this.f1324o == 2) {
            this.f1310a.addView(d1Var, 0);
            Toolbar.e eVar = (Toolbar.e) this.f1312c.getLayoutParams();
            eVar.width = -2;
            eVar.height = -2;
            eVar.f617a = 8388691;
            d1Var.setAllowCollapse(true);
        }
    }

    public ViewGroup l() {
        return this.f1310a;
    }

    public void m(boolean z4) {
    }

    public boolean n() {
        return this.f1310a.v();
    }

    public void o(int i5) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i6 = this.f1311b ^ i5;
        this.f1311b = i5;
        if (i6 != 0) {
            if ((i6 & 4) != 0) {
                if ((i5 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i6 & 3) != 0) {
                J();
            }
            if ((i6 & 8) != 0) {
                if ((i5 & 8) != 0) {
                    this.f1310a.setTitle(this.f1318i);
                    toolbar = this.f1310a;
                    charSequence = this.f1319j;
                } else {
                    charSequence = null;
                    this.f1310a.setTitle((CharSequence) null);
                    toolbar = this.f1310a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i6 & 16) != 0 && (view = this.f1313d) != null) {
                if ((i5 & 16) != 0) {
                    this.f1310a.addView(view);
                } else {
                    this.f1310a.removeView(view);
                }
            }
        }
    }

    public int p() {
        return this.f1311b;
    }

    public Menu q() {
        return this.f1310a.getMenu();
    }

    public void r(int i5) {
        A(i5 != 0 ? e.a.b(getContext(), i5) : null);
    }

    public int s() {
        return this.f1324o;
    }

    public void setIcon(int i5) {
        setIcon(i5 != 0 ? e.a.b(getContext(), i5) : null);
    }

    public void setIcon(Drawable drawable) {
        this.f1314e = drawable;
        J();
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f1321l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1317h) {
            G(charSequence);
        }
    }

    public k1 t(int i5, long j5) {
        return k0.c(this.f1310a).b(i5 == 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO).f(j5).h(new b(i5));
    }

    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void w(boolean z4) {
        this.f1310a.setCollapsible(z4);
    }

    public void y(View view) {
        View view2 = this.f1313d;
        if (!(view2 == null || (this.f1311b & 16) == 0)) {
            this.f1310a.removeView(view2);
        }
        this.f1313d = view;
        if (view != null && (this.f1311b & 16) != 0) {
            this.f1310a.addView(view);
        }
    }

    public void z(int i5) {
        if (i5 != this.f1325p) {
            this.f1325p = i5;
            if (TextUtils.isEmpty(this.f1310a.getNavigationContentDescription())) {
                B(this.f1325p);
            }
        }
    }
}
