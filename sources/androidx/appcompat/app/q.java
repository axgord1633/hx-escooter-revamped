package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.n0;
import androidx.core.view.k0;
import androidx.core.view.k1;
import androidx.core.view.l1;
import androidx.core.view.m1;
import androidx.core.view.n1;
import com.yalantis.ucrop.view.CropImageView;
import d.f;
import d.j;
import h.b;
import h.g;
import h.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class q extends a implements ActionBarOverlayLayout.d {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;
    final l1 B = new a();
    final l1 C = new b();
    final n1 D = new c();

    /* renamed from: a  reason: collision with root package name */
    Context f744a;

    /* renamed from: b  reason: collision with root package name */
    private Context f745b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f746c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarOverlayLayout f747d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f748e;

    /* renamed from: f  reason: collision with root package name */
    n0 f749f;

    /* renamed from: g  reason: collision with root package name */
    ActionBarContextView f750g;

    /* renamed from: h  reason: collision with root package name */
    View f751h;

    /* renamed from: i  reason: collision with root package name */
    d1 f752i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Object> f753j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private int f754k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f755l;

    /* renamed from: m  reason: collision with root package name */
    d f756m;

    /* renamed from: n  reason: collision with root package name */
    h.b f757n;

    /* renamed from: o  reason: collision with root package name */
    b.a f758o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f759p;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<a.b> f760q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private boolean f761r;

    /* renamed from: s  reason: collision with root package name */
    private int f762s = 0;

    /* renamed from: t  reason: collision with root package name */
    boolean f763t = true;

    /* renamed from: u  reason: collision with root package name */
    boolean f764u;

    /* renamed from: v  reason: collision with root package name */
    boolean f765v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f766w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f767x = true;

    /* renamed from: y  reason: collision with root package name */
    h f768y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f769z;

    class a extends m1 {
        a() {
        }

        public void b(View view) {
            View view2;
            q qVar = q.this;
            if (qVar.f763t && (view2 = qVar.f751h) != null) {
                view2.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                q.this.f748e.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            }
            q.this.f748e.setVisibility(8);
            q.this.f748e.setTransitioning(false);
            q qVar2 = q.this;
            qVar2.f768y = null;
            qVar2.y();
            ActionBarOverlayLayout actionBarOverlayLayout = q.this.f747d;
            if (actionBarOverlayLayout != null) {
                k0.L(actionBarOverlayLayout);
            }
        }
    }

    class b extends m1 {
        b() {
        }

        public void b(View view) {
            q qVar = q.this;
            qVar.f768y = null;
            qVar.f748e.requestLayout();
        }
    }

    class c implements n1 {
        c() {
        }

        public void a(View view) {
            ((View) q.this.f748e.getParent()).invalidate();
        }
    }

    public class d extends h.b implements e.a {

        /* renamed from: g  reason: collision with root package name */
        private final Context f773g;

        /* renamed from: h  reason: collision with root package name */
        private final e f774h;

        /* renamed from: i  reason: collision with root package name */
        private b.a f775i;

        /* renamed from: j  reason: collision with root package name */
        private WeakReference<View> f776j;

        public d(Context context, b.a aVar) {
            this.f773g = context;
            this.f775i = aVar;
            e S = new e(context).S(1);
            this.f774h = S;
            S.R(this);
        }

        public boolean a(e eVar, MenuItem menuItem) {
            b.a aVar = this.f775i;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        public void b(e eVar) {
            if (this.f775i != null) {
                k();
                q.this.f750g.l();
            }
        }

        public void c() {
            q qVar = q.this;
            if (qVar.f756m == this) {
                if (!q.x(qVar.f764u, qVar.f765v, false)) {
                    q qVar2 = q.this;
                    qVar2.f757n = this;
                    qVar2.f758o = this.f775i;
                } else {
                    this.f775i.d(this);
                }
                this.f775i = null;
                q.this.w(false);
                q.this.f750g.g();
                q.this.f749f.l().sendAccessibilityEvent(32);
                q qVar3 = q.this;
                qVar3.f747d.setHideOnContentScrollEnabled(qVar3.A);
                q.this.f756m = null;
            }
        }

        public View d() {
            WeakReference<View> weakReference = this.f776j;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public Menu e() {
            return this.f774h;
        }

        public MenuInflater f() {
            return new g(this.f773g);
        }

        public CharSequence g() {
            return q.this.f750g.getSubtitle();
        }

        public CharSequence i() {
            return q.this.f750g.getTitle();
        }

        public void k() {
            if (q.this.f756m == this) {
                this.f774h.d0();
                try {
                    this.f775i.c(this, this.f774h);
                } finally {
                    this.f774h.c0();
                }
            }
        }

        public boolean l() {
            return q.this.f750g.j();
        }

        public void m(View view) {
            q.this.f750g.setCustomView(view);
            this.f776j = new WeakReference<>(view);
        }

        public void n(int i5) {
            o(q.this.f744a.getResources().getString(i5));
        }

        public void o(CharSequence charSequence) {
            q.this.f750g.setSubtitle(charSequence);
        }

        public void q(int i5) {
            r(q.this.f744a.getResources().getString(i5));
        }

        public void r(CharSequence charSequence) {
            q.this.f750g.setTitle(charSequence);
        }

        public void s(boolean z4) {
            super.s(z4);
            q.this.f750g.setTitleOptional(z4);
        }

        public boolean t() {
            this.f774h.d0();
            try {
                return this.f775i.b(this, this.f774h);
            } finally {
                this.f774h.c0();
            }
        }
    }

    public q(Activity activity, boolean z4) {
        this.f746c = activity;
        View decorView = activity.getWindow().getDecorView();
        E(decorView);
        if (!z4) {
            this.f751h = decorView.findViewById(16908290);
        }
    }

    public q(Dialog dialog) {
        E(dialog.getWindow().getDecorView());
    }

    private n0 B(View view) {
        if (view instanceof n0) {
            return (n0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void D() {
        if (this.f766w) {
            this.f766w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f747d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            N(false);
        }
    }

    private void E(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(f.f4053p);
        this.f747d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f749f = B(view.findViewById(f.f4038a));
        this.f750g = (ActionBarContextView) view.findViewById(f.f4043f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(f.f4040c);
        this.f748e = actionBarContainer;
        n0 n0Var = this.f749f;
        if (n0Var == null || this.f750g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f744a = n0Var.getContext();
        boolean z4 = (this.f749f.p() & 4) != 0;
        if (z4) {
            this.f755l = true;
        }
        h.a b5 = h.a.b(this.f744a);
        K(b5.a() || z4);
        I(b5.g());
        TypedArray obtainStyledAttributes = this.f744a.obtainStyledAttributes((AttributeSet) null, j.f4100a, d.a.f3964c, 0);
        if (obtainStyledAttributes.getBoolean(j.f4150k, false)) {
            J(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.f4140i, 0);
        if (dimensionPixelSize != 0) {
            H((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void I(boolean z4) {
        this.f761r = z4;
        if (!z4) {
            this.f749f.k((d1) null);
            this.f748e.setTabContainer(this.f752i);
        } else {
            this.f748e.setTabContainer((d1) null);
            this.f749f.k(this.f752i);
        }
        boolean z5 = true;
        boolean z6 = C() == 2;
        d1 d1Var = this.f752i;
        if (d1Var != null) {
            if (z6) {
                d1Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f747d;
                if (actionBarOverlayLayout != null) {
                    k0.L(actionBarOverlayLayout);
                }
            } else {
                d1Var.setVisibility(8);
            }
        }
        this.f749f.w(!this.f761r && z6);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f747d;
        if (this.f761r || !z6) {
            z5 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z5);
    }

    private boolean L() {
        return k0.B(this.f748e);
    }

    private void M() {
        if (!this.f766w) {
            this.f766w = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f747d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            N(false);
        }
    }

    private void N(boolean z4) {
        if (x(this.f764u, this.f765v, this.f766w)) {
            if (!this.f767x) {
                this.f767x = true;
                A(z4);
            }
        } else if (this.f767x) {
            this.f767x = false;
            z(z4);
        }
    }

    static boolean x(boolean z4, boolean z5, boolean z6) {
        if (z6) {
            return true;
        }
        return !z4 && !z5;
    }

    public void A(boolean z4) {
        View view;
        View view2;
        h hVar = this.f768y;
        if (hVar != null) {
            hVar.a();
        }
        this.f748e.setVisibility(0);
        if (this.f762s != 0 || (!this.f769z && !z4)) {
            this.f748e.setAlpha(1.0f);
            this.f748e.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            if (this.f763t && (view = this.f751h) != null) {
                view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            }
            this.C.b((View) null);
        } else {
            this.f748e.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            float f5 = (float) (-this.f748e.getHeight());
            if (z4) {
                int[] iArr = {0, 0};
                this.f748e.getLocationInWindow(iArr);
                f5 -= (float) iArr[1];
            }
            this.f748e.setTranslationY(f5);
            h hVar2 = new h();
            k1 m5 = k0.c(this.f748e).m(CropImageView.DEFAULT_ASPECT_RATIO);
            m5.k(this.D);
            hVar2.c(m5);
            if (this.f763t && (view2 = this.f751h) != null) {
                view2.setTranslationY(f5);
                hVar2.c(k0.c(this.f751h).m(CropImageView.DEFAULT_ASPECT_RATIO));
            }
            hVar2.f(F);
            hVar2.e(250);
            hVar2.g(this.C);
            this.f768y = hVar2;
            hVar2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f747d;
        if (actionBarOverlayLayout != null) {
            k0.L(actionBarOverlayLayout);
        }
    }

    public int C() {
        return this.f749f.s();
    }

    public void F(boolean z4) {
        G(z4 ? 4 : 0, 4);
    }

    public void G(int i5, int i6) {
        int p5 = this.f749f.p();
        if ((i6 & 4) != 0) {
            this.f755l = true;
        }
        this.f749f.o((i5 & i6) | ((~i6) & p5));
    }

    public void H(float f5) {
        k0.T(this.f748e, f5);
    }

    public void J(boolean z4) {
        if (!z4 || this.f747d.w()) {
            this.A = z4;
            this.f747d.setHideOnContentScrollEnabled(z4);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void K(boolean z4) {
        this.f749f.m(z4);
    }

    public void a() {
        if (this.f765v) {
            this.f765v = false;
            N(true);
        }
    }

    public void b() {
        h hVar = this.f768y;
        if (hVar != null) {
            hVar.a();
            this.f768y = null;
        }
    }

    public void c(int i5) {
        this.f762s = i5;
    }

    public void d() {
    }

    public void e(boolean z4) {
        this.f763t = z4;
    }

    public void f() {
        if (!this.f765v) {
            this.f765v = true;
            N(true);
        }
    }

    public boolean h() {
        n0 n0Var = this.f749f;
        if (n0Var == null || !n0Var.n()) {
            return false;
        }
        this.f749f.collapseActionView();
        return true;
    }

    public void i(boolean z4) {
        if (z4 != this.f759p) {
            this.f759p = z4;
            int size = this.f760q.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f760q.get(i5).onMenuVisibilityChanged(z4);
            }
        }
    }

    public int j() {
        return this.f749f.p();
    }

    public Context k() {
        if (this.f745b == null) {
            TypedValue typedValue = new TypedValue();
            this.f744a.getTheme().resolveAttribute(d.a.f3968g, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                this.f745b = new ContextThemeWrapper(this.f744a, i5);
            } else {
                this.f745b = this.f744a;
            }
        }
        return this.f745b;
    }

    public void m(Configuration configuration) {
        I(h.a.b(this.f744a).g());
    }

    public boolean o(int i5, KeyEvent keyEvent) {
        Menu e5;
        d dVar = this.f756m;
        if (dVar == null || (e5 = dVar.e()) == null) {
            return false;
        }
        boolean z4 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z4 = false;
        }
        e5.setQwertyMode(z4);
        return e5.performShortcut(i5, keyEvent, 0);
    }

    public void r(boolean z4) {
        if (!this.f755l) {
            F(z4);
        }
    }

    public void s(boolean z4) {
        G(z4 ? 8 : 0, 8);
    }

    public void t(boolean z4) {
        h hVar;
        this.f769z = z4;
        if (!z4 && (hVar = this.f768y) != null) {
            hVar.a();
        }
    }

    public void u(CharSequence charSequence) {
        this.f749f.setWindowTitle(charSequence);
    }

    public h.b v(b.a aVar) {
        d dVar = this.f756m;
        if (dVar != null) {
            dVar.c();
        }
        this.f747d.setHideOnContentScrollEnabled(false);
        this.f750g.k();
        d dVar2 = new d(this.f750g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f756m = dVar2;
        dVar2.k();
        this.f750g.h(dVar2);
        w(true);
        this.f750g.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void w(boolean z4) {
        k1 k1Var;
        k1 k1Var2;
        if (z4) {
            M();
        } else {
            D();
        }
        if (L()) {
            if (z4) {
                k1Var = this.f749f.t(4, 100);
                k1Var2 = this.f750g.f(0, 200);
            } else {
                k1Var2 = this.f749f.t(0, 200);
                k1Var = this.f750g.f(8, 100);
            }
            h hVar = new h();
            hVar.d(k1Var, k1Var2);
            hVar.h();
        } else if (z4) {
            this.f749f.j(4);
            this.f750g.setVisibility(0);
        } else {
            this.f749f.j(0);
            this.f750g.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void y() {
        b.a aVar = this.f758o;
        if (aVar != null) {
            aVar.d(this.f757n);
            this.f757n = null;
            this.f758o = null;
        }
    }

    public void z(boolean z4) {
        View view;
        h hVar = this.f768y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f762s != 0 || (!this.f769z && !z4)) {
            this.B.b((View) null);
            return;
        }
        this.f748e.setAlpha(1.0f);
        this.f748e.setTransitioning(true);
        h hVar2 = new h();
        float f5 = (float) (-this.f748e.getHeight());
        if (z4) {
            int[] iArr = {0, 0};
            this.f748e.getLocationInWindow(iArr);
            f5 -= (float) iArr[1];
        }
        k1 m5 = k0.c(this.f748e).m(f5);
        m5.k(this.D);
        hVar2.c(m5);
        if (this.f763t && (view = this.f751h) != null) {
            hVar2.c(k0.c(view).m(f5));
        }
        hVar2.f(E);
        hVar2.e(250);
        hVar2.g(this.B);
        this.f768y = hVar2;
        hVar2.h();
    }
}
