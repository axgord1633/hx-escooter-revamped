package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.b;
import androidx.core.widget.k;
import androidx.core.widget.p;
import d.a;

public class f extends Button implements b, p {

    /* renamed from: e  reason: collision with root package name */
    private final e f1225e;

    /* renamed from: f  reason: collision with root package name */
    private final g0 f1226f;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f3978q);
    }

    public f(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        f1.a(this, getContext());
        e eVar = new e(this);
        this.f1225e = eVar;
        eVar.e(attributeSet, i5);
        g0 g0Var = new g0(this);
        this.f1226f = g0Var;
        g0Var.m(attributeSet, i5);
        g0Var.b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1225e;
        if (eVar != null) {
            eVar.b();
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f2053a) {
            return super.getAutoSizeMaxTextSize();
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            return g0Var.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f2053a) {
            return super.getAutoSizeMinTextSize();
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            return g0Var.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f2053a) {
            return super.getAutoSizeStepGranularity();
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            return g0Var.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f2053a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        g0 g0Var = this.f1226f;
        return g0Var != null ? g0Var.h() : new int[0];
    }

    public int getAutoSizeTextType() {
        if (b.f2053a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            return g0Var.i();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1225e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1225e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1226f.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1226f.k();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.o(z4, i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        g0 g0Var = this.f1226f;
        if (g0Var != null && !b.f2053a && g0Var.l()) {
            this.f1226f.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        if (b.f2053a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
            return;
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.t(i5, i6, i7, i8);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        if (b.f2053a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
            return;
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.u(iArr, i5);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i5) {
        if (b.f2053a) {
            super.setAutoSizeTextTypeWithDefaults(i5);
            return;
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.v(i5);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1225e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.f1225e;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.m(this, callback));
    }

    public void setSupportAllCaps(boolean z4) {
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.s(z4);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1225e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1225e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1226f.w(colorStateList);
        this.f1226f.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1226f.x(mode);
        this.f1226f.b();
    }

    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.q(context, i5);
        }
    }

    public void setTextSize(int i5, float f5) {
        if (b.f2053a) {
            super.setTextSize(i5, f5);
            return;
        }
        g0 g0Var = this.f1226f;
        if (g0Var != null) {
            g0Var.A(i5, f5);
        }
    }
}
