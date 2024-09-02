package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import d.a;

public class s extends RadioButton {

    /* renamed from: e  reason: collision with root package name */
    private final i f1400e;

    /* renamed from: f  reason: collision with root package name */
    private final e f1401f;

    /* renamed from: g  reason: collision with root package name */
    private final g0 f1402g;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.E);
    }

    public s(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        f1.a(this, getContext());
        i iVar = new i(this);
        this.f1400e = iVar;
        iVar.e(attributeSet, i5);
        e eVar = new e(this);
        this.f1401f = eVar;
        eVar.e(attributeSet, i5);
        g0 g0Var = new g0(this);
        this.f1402g = g0Var;
        g0Var.m(attributeSet, i5);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1401f;
        if (eVar != null) {
            eVar.b();
        }
        g0 g0Var = this.f1402g;
        if (g0Var != null) {
            g0Var.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f1400e;
        return iVar != null ? iVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1401f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1401f;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f1400e;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f1400e;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1401f;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.f1401f;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setButtonDrawable(int i5) {
        setButtonDrawable(e.a.b(getContext(), i5));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f1400e;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1401f;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1401f;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f1400e;
        if (iVar != null) {
            iVar.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f1400e;
        if (iVar != null) {
            iVar.h(mode);
        }
    }
}
