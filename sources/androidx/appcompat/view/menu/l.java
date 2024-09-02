package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.z0;
import androidx.core.view.k0;
import d.d;
import d.g;

final class l extends h implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: z  reason: collision with root package name */
    private static final int f939z = g.f4076m;

    /* renamed from: f  reason: collision with root package name */
    private final Context f940f;

    /* renamed from: g  reason: collision with root package name */
    private final e f941g;

    /* renamed from: h  reason: collision with root package name */
    private final d f942h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f943i;

    /* renamed from: j  reason: collision with root package name */
    private final int f944j;

    /* renamed from: k  reason: collision with root package name */
    private final int f945k;

    /* renamed from: l  reason: collision with root package name */
    private final int f946l;

    /* renamed from: m  reason: collision with root package name */
    final z0 f947m;

    /* renamed from: n  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f948n = new a();

    /* renamed from: o  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f949o = new b();

    /* renamed from: p  reason: collision with root package name */
    private PopupWindow.OnDismissListener f950p;

    /* renamed from: q  reason: collision with root package name */
    private View f951q;

    /* renamed from: r  reason: collision with root package name */
    View f952r;

    /* renamed from: s  reason: collision with root package name */
    private j.a f953s;

    /* renamed from: t  reason: collision with root package name */
    ViewTreeObserver f954t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f955u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f956v;

    /* renamed from: w  reason: collision with root package name */
    private int f957w;

    /* renamed from: x  reason: collision with root package name */
    private int f958x = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f959y;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (l.this.b() && !l.this.f947m.w()) {
                View view = l.this.f952r;
                if (view == null || !view.isShown()) {
                    l.this.dismiss();
                } else {
                    l.this.f947m.show();
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f954t;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f954t = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f954t.removeGlobalOnLayoutListener(lVar.f948n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i5, int i6, boolean z4) {
        this.f940f = context;
        this.f941g = eVar;
        this.f943i = z4;
        this.f942h = new d(eVar, LayoutInflater.from(context), z4, f939z);
        this.f945k = i5;
        this.f946l = i6;
        Resources resources = context.getResources();
        this.f944j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.f4000d));
        this.f951q = view;
        this.f947m = new z0(context, (AttributeSet) null, i5, i6);
        eVar.c(this, context);
    }

    private boolean y() {
        View view;
        if (b()) {
            return true;
        }
        if (this.f955u || (view = this.f951q) == null) {
            return false;
        }
        this.f952r = view;
        this.f947m.F(this);
        this.f947m.G(this);
        this.f947m.E(true);
        View view2 = this.f952r;
        boolean z4 = this.f954t == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f954t = viewTreeObserver;
        if (z4) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f948n);
        }
        view2.addOnAttachStateChangeListener(this.f949o);
        this.f947m.y(view2);
        this.f947m.B(this.f958x);
        if (!this.f956v) {
            this.f957w = h.n(this.f942h, (ViewGroup) null, this.f940f, this.f944j);
            this.f956v = true;
        }
        this.f947m.A(this.f957w);
        this.f947m.D(2);
        this.f947m.C(m());
        this.f947m.show();
        ListView f5 = this.f947m.f();
        f5.setOnKeyListener(this);
        if (this.f959y && this.f941g.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f940f).inflate(g.f4075l, f5, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f941g.x());
            }
            frameLayout.setEnabled(false);
            f5.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f947m.o(this.f942h);
        this.f947m.show();
        return true;
    }

    public void a(e eVar, boolean z4) {
        if (eVar == this.f941g) {
            dismiss();
            j.a aVar = this.f953s;
            if (aVar != null) {
                aVar.a(eVar, z4);
            }
        }
    }

    public boolean b() {
        return !this.f955u && this.f947m.b();
    }

    public boolean d(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f940f, mVar, this.f952r, this.f943i, this.f945k, this.f946l);
            iVar.j(this.f953s);
            iVar.g(h.w(mVar));
            iVar.i(this.f950p);
            this.f950p = null;
            this.f941g.e(false);
            int c5 = this.f947m.c();
            int m5 = this.f947m.m();
            if ((Gravity.getAbsoluteGravity(this.f958x, k0.q(this.f951q)) & 7) == 5) {
                c5 += this.f951q.getWidth();
            }
            if (iVar.n(c5, m5)) {
                j.a aVar = this.f953s;
                if (aVar == null) {
                    return true;
                }
                aVar.b(mVar);
                return true;
            }
        }
        return false;
    }

    public void dismiss() {
        if (b()) {
            this.f947m.dismiss();
        }
    }

    public void e(boolean z4) {
        this.f956v = false;
        d dVar = this.f942h;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    public ListView f() {
        return this.f947m.f();
    }

    public boolean g() {
        return false;
    }

    public void j(j.a aVar) {
        this.f953s = aVar;
    }

    public void k(e eVar) {
    }

    public void o(View view) {
        this.f951q = view;
    }

    public void onDismiss() {
        this.f955u = true;
        this.f941g.close();
        ViewTreeObserver viewTreeObserver = this.f954t;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f954t = this.f952r.getViewTreeObserver();
            }
            this.f954t.removeGlobalOnLayoutListener(this.f948n);
            this.f954t = null;
        }
        this.f952r.removeOnAttachStateChangeListener(this.f949o);
        PopupWindow.OnDismissListener onDismissListener = this.f950p;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i5 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void q(boolean z4) {
        this.f942h.d(z4);
    }

    public void r(int i5) {
        this.f958x = i5;
    }

    public void s(int i5) {
        this.f947m.k(i5);
    }

    public void show() {
        if (!y()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f950p = onDismissListener;
    }

    public void u(boolean z4) {
        this.f959y = z4;
    }

    public void v(int i5) {
        this.f947m.i(i5);
    }
}
