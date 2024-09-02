package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.k0;
import d.j;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f1203a;

    /* renamed from: b  reason: collision with root package name */
    private final j f1204b;

    /* renamed from: c  reason: collision with root package name */
    private int f1205c = -1;

    /* renamed from: d  reason: collision with root package name */
    private i1 f1206d;

    /* renamed from: e  reason: collision with root package name */
    private i1 f1207e;

    /* renamed from: f  reason: collision with root package name */
    private i1 f1208f;

    e(View view) {
        this.f1203a = view;
        this.f1204b = j.b();
    }

    private boolean a(Drawable drawable) {
        if (this.f1208f == null) {
            this.f1208f = new i1();
        }
        i1 i1Var = this.f1208f;
        i1Var.a();
        ColorStateList l5 = k0.l(this.f1203a);
        if (l5 != null) {
            i1Var.f1290d = true;
            i1Var.f1287a = l5;
        }
        PorterDuff.Mode m5 = k0.m(this.f1203a);
        if (m5 != null) {
            i1Var.f1289c = true;
            i1Var.f1288b = m5;
        }
        if (!i1Var.f1290d && !i1Var.f1289c) {
            return false;
        }
        j.i(drawable, i1Var, this.f1203a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f1206d != null;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f1203a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            i1 i1Var = this.f1207e;
            if (i1Var != null) {
                j.i(background, i1Var, this.f1203a.getDrawableState());
                return;
            }
            i1 i1Var2 = this.f1206d;
            if (i1Var2 != null) {
                j.i(background, i1Var2, this.f1203a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        i1 i1Var = this.f1207e;
        if (i1Var != null) {
            return i1Var.f1287a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        i1 i1Var = this.f1207e;
        if (i1Var != null) {
            return i1Var.f1288b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i5) {
        Context context = this.f1203a.getContext();
        int[] iArr = j.A3;
        k1 u5 = k1.u(context, attributeSet, iArr, i5, 0);
        View view = this.f1203a;
        k0.M(view, view.getContext(), iArr, attributeSet, u5.q(), i5, 0);
        try {
            int i6 = j.B3;
            if (u5.r(i6)) {
                this.f1205c = u5.m(i6, -1);
                ColorStateList f5 = this.f1204b.f(this.f1203a.getContext(), this.f1205c);
                if (f5 != null) {
                    h(f5);
                }
            }
            int i7 = j.C3;
            if (u5.r(i7)) {
                k0.Q(this.f1203a, u5.c(i7));
            }
            int i8 = j.D3;
            if (u5.r(i8)) {
                k0.R(this.f1203a, o0.c(u5.j(i8, -1), (PorterDuff.Mode) null));
            }
        } finally {
            u5.v();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f1205c = -1;
        h((ColorStateList) null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i5) {
        this.f1205c = i5;
        j jVar = this.f1204b;
        h(jVar != null ? jVar.f(this.f1203a.getContext(), i5) : null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1206d == null) {
                this.f1206d = new i1();
            }
            i1 i1Var = this.f1206d;
            i1Var.f1287a = colorStateList;
            i1Var.f1290d = true;
        } else {
            this.f1206d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f1207e == null) {
            this.f1207e = new i1();
        }
        i1 i1Var = this.f1207e;
        i1Var.f1287a = colorStateList;
        i1Var.f1290d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f1207e == null) {
            this.f1207e = new i1();
        }
        i1 i1Var = this.f1207e;
        i1Var.f1288b = mode;
        i1Var.f1289c = true;
        b();
    }
}
