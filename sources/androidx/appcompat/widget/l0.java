package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class l0 extends ToggleButton {

    /* renamed from: e  reason: collision with root package name */
    private final e f1308e;

    /* renamed from: f  reason: collision with root package name */
    private final g0 f1309f;

    public l0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public l0(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        f1.a(this, getContext());
        e eVar = new e(this);
        this.f1308e = eVar;
        eVar.e(attributeSet, i5);
        g0 g0Var = new g0(this);
        this.f1309f = g0Var;
        g0Var.m(attributeSet, i5);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1308e;
        if (eVar != null) {
            eVar.b();
        }
        g0 g0Var = this.f1309f;
        if (g0Var != null) {
            g0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1308e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1308e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1308e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.f1308e;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1308e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1308e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }
}
