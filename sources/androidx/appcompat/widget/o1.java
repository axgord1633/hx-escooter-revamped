package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.g1;
import androidx.core.view.k0;

class o1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: n  reason: collision with root package name */
    private static o1 f1342n;

    /* renamed from: o  reason: collision with root package name */
    private static o1 f1343o;

    /* renamed from: e  reason: collision with root package name */
    private final View f1344e;

    /* renamed from: f  reason: collision with root package name */
    private final CharSequence f1345f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1346g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f1347h = new a();

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f1348i = new b();

    /* renamed from: j  reason: collision with root package name */
    private int f1349j;

    /* renamed from: k  reason: collision with root package name */
    private int f1350k;

    /* renamed from: l  reason: collision with root package name */
    private p1 f1351l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1352m;

    class a implements Runnable {
        a() {
        }

        public void run() {
            o1.this.g(false);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            o1.this.c();
        }
    }

    private o1(View view, CharSequence charSequence) {
        this.f1344e = view;
        this.f1345f = charSequence;
        this.f1346g = g1.a(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f1344e.removeCallbacks(this.f1347h);
    }

    private void b() {
        this.f1349j = Integer.MAX_VALUE;
        this.f1350k = Integer.MAX_VALUE;
    }

    private void d() {
        this.f1344e.postDelayed(this.f1347h, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void e(o1 o1Var) {
        o1 o1Var2 = f1342n;
        if (o1Var2 != null) {
            o1Var2.a();
        }
        f1342n = o1Var;
        if (o1Var != null) {
            o1Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        o1 o1Var = f1342n;
        if (o1Var != null && o1Var.f1344e == view) {
            e((o1) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            o1 o1Var2 = f1343o;
            if (o1Var2 != null && o1Var2.f1344e == view) {
                o1Var2.c();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new o1(view, charSequence);
    }

    private boolean h(MotionEvent motionEvent) {
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        if (Math.abs(x4 - this.f1349j) <= this.f1346g && Math.abs(y4 - this.f1350k) <= this.f1346g) {
            return false;
        }
        this.f1349j = x4;
        this.f1350k = y4;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (f1343o == this) {
            f1343o = null;
            p1 p1Var = this.f1351l;
            if (p1Var != null) {
                p1Var.c();
                this.f1351l = null;
                b();
                this.f1344e.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1342n == this) {
            e((o1) null);
        }
        this.f1344e.removeCallbacks(this.f1348i);
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z4) {
        long j5;
        if (k0.A(this.f1344e)) {
            e((o1) null);
            o1 o1Var = f1343o;
            if (o1Var != null) {
                o1Var.c();
            }
            f1343o = this;
            this.f1352m = z4;
            p1 p1Var = new p1(this.f1344e.getContext());
            this.f1351l = p1Var;
            p1Var.e(this.f1344e, this.f1349j, this.f1350k, this.f1352m, this.f1345f);
            this.f1344e.addOnAttachStateChangeListener(this);
            if (this.f1352m) {
                j5 = 2500;
            } else {
                j5 = ((k0.w(this.f1344e) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f1344e.removeCallbacks(this.f1348i);
            this.f1344e.postDelayed(this.f1348i, j5);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1351l != null && this.f1352m) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1344e.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f1344e.isEnabled() && this.f1351l == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1349j = view.getWidth() / 2;
        this.f1350k = view.getHeight() / 2;
        g(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
