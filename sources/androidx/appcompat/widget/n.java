package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.k0;
import androidx.core.widget.g;
import d.j;
import e.a;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1334a;

    /* renamed from: b  reason: collision with root package name */
    private i1 f1335b;

    /* renamed from: c  reason: collision with root package name */
    private i1 f1336c;

    /* renamed from: d  reason: collision with root package name */
    private i1 f1337d;

    public n(ImageView imageView) {
        this.f1334a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1337d == null) {
            this.f1337d = new i1();
        }
        i1 i1Var = this.f1337d;
        i1Var.a();
        ColorStateList a5 = g.a(this.f1334a);
        if (a5 != null) {
            i1Var.f1290d = true;
            i1Var.f1287a = a5;
        }
        PorterDuff.Mode b5 = g.b(this.f1334a);
        if (b5 != null) {
            i1Var.f1289c = true;
            i1Var.f1288b = b5;
        }
        if (!i1Var.f1290d && !i1Var.f1289c) {
            return false;
        }
        j.i(drawable, i1Var, this.f1334a.getDrawableState());
        return true;
    }

    private boolean j() {
        return this.f1335b != null;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1334a.getDrawable();
        if (drawable != null) {
            o0.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!j() || !a(drawable)) {
            i1 i1Var = this.f1336c;
            if (i1Var != null) {
                j.i(drawable, i1Var, this.f1334a.getDrawableState());
                return;
            }
            i1 i1Var2 = this.f1335b;
            if (i1Var2 != null) {
                j.i(drawable, i1Var2, this.f1334a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        i1 i1Var = this.f1336c;
        if (i1Var != null) {
            return i1Var.f1287a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        i1 i1Var = this.f1336c;
        if (i1Var != null) {
            return i1Var.f1288b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return !(this.f1334a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i5) {
        int m5;
        Context context = this.f1334a.getContext();
        int[] iArr = j.R;
        k1 u5 = k1.u(context, attributeSet, iArr, i5, 0);
        ImageView imageView = this.f1334a;
        k0.M(imageView, imageView.getContext(), iArr, attributeSet, u5.q(), i5, 0);
        try {
            Drawable drawable = this.f1334a.getDrawable();
            if (!(drawable != null || (m5 = u5.m(j.S, -1)) == -1 || (drawable = a.b(this.f1334a.getContext(), m5)) == null)) {
                this.f1334a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                o0.b(drawable);
            }
            int i6 = j.T;
            if (u5.r(i6)) {
                g.c(this.f1334a, u5.c(i6));
            }
            int i7 = j.U;
            if (u5.r(i7)) {
                g.d(this.f1334a, o0.c(u5.j(i7, -1), (PorterDuff.Mode) null));
            }
        } finally {
            u5.v();
        }
    }

    public void g(int i5) {
        if (i5 != 0) {
            Drawable b5 = a.b(this.f1334a.getContext(), i5);
            if (b5 != null) {
                o0.b(b5);
            }
            this.f1334a.setImageDrawable(b5);
        } else {
            this.f1334a.setImageDrawable((Drawable) null);
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f1336c == null) {
            this.f1336c = new i1();
        }
        i1 i1Var = this.f1336c;
        i1Var.f1287a = colorStateList;
        i1Var.f1290d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f1336c == null) {
            this.f1336c = new i1();
        }
        i1 i1Var = this.f1336c;
        i1Var.f1288b = mode;
        i1Var.f1289c = true;
        b();
    }
}
