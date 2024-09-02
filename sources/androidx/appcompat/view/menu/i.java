package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import androidx.core.view.e;
import androidx.core.view.k0;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f926a;

    /* renamed from: b  reason: collision with root package name */
    private final e f927b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f928c;

    /* renamed from: d  reason: collision with root package name */
    private final int f929d;

    /* renamed from: e  reason: collision with root package name */
    private final int f930e;

    /* renamed from: f  reason: collision with root package name */
    private View f931f;

    /* renamed from: g  reason: collision with root package name */
    private int f932g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f933h;

    /* renamed from: i  reason: collision with root package name */
    private j.a f934i;

    /* renamed from: j  reason: collision with root package name */
    private h f935j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f936k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f937l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z4, int i5) {
        this(context, eVar, view, z4, i5, 0);
    }

    public i(Context context, e eVar, View view, boolean z4, int i5, int i6) {
        this.f932g = 8388611;
        this.f937l = new a();
        this.f926a = context;
        this.f927b = eVar;
        this.f931f = view;
        this.f928c = z4;
        this.f929d = i5;
        this.f930e = i6;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.h, androidx.appcompat.view.menu.j] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.l] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.h a() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f926a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            r0.getRealSize(r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f926a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = d.d.f3999c
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 == 0) goto L_0x0042
            androidx.appcompat.view.menu.b r0 = new androidx.appcompat.view.menu.b
            android.content.Context r2 = r14.f926a
            android.view.View r3 = r14.f931f
            int r4 = r14.f929d
            int r5 = r14.f930e
            boolean r6 = r14.f928c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0054
        L_0x0042:
            androidx.appcompat.view.menu.l r0 = new androidx.appcompat.view.menu.l
            android.content.Context r8 = r14.f926a
            androidx.appcompat.view.menu.e r9 = r14.f927b
            android.view.View r10 = r14.f931f
            int r11 = r14.f929d
            int r12 = r14.f930e
            boolean r13 = r14.f928c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0054:
            androidx.appcompat.view.menu.e r1 = r14.f927b
            r0.k(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f937l
            r0.t(r1)
            android.view.View r1 = r14.f931f
            r0.o(r1)
            androidx.appcompat.view.menu.j$a r1 = r14.f934i
            r0.j(r1)
            boolean r1 = r14.f933h
            r0.q(r1)
            int r1 = r14.f932g
            r0.r(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.i.a():androidx.appcompat.view.menu.h");
    }

    private void l(int i5, int i6, boolean z4, boolean z5) {
        h c5 = c();
        c5.u(z5);
        if (z4) {
            if ((e.a(this.f932g, k0.q(this.f931f)) & 7) == 5) {
                i5 -= this.f931f.getWidth();
            }
            c5.s(i5);
            c5.v(i6);
            int i7 = (int) ((this.f926a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c5.p(new Rect(i5 - i7, i6 - i7, i5 + i7, i6 + i7));
        }
        c5.show();
    }

    public void b() {
        if (d()) {
            this.f935j.dismiss();
        }
    }

    public h c() {
        if (this.f935j == null) {
            this.f935j = a();
        }
        return this.f935j;
    }

    public boolean d() {
        h hVar = this.f935j;
        return hVar != null && hVar.b();
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f935j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f936k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f931f = view;
    }

    public void g(boolean z4) {
        this.f933h = z4;
        h hVar = this.f935j;
        if (hVar != null) {
            hVar.q(z4);
        }
    }

    public void h(int i5) {
        this.f932g = i5;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f936k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f934i = aVar;
        h hVar = this.f935j;
        if (hVar != null) {
            hVar.j(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f931f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i5, int i6) {
        if (d()) {
            return true;
        }
        if (this.f931f == null) {
            return false;
        }
        l(i5, i6, true, true);
        return true;
    }
}
