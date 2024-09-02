package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.core.widget.k;
import d.a;

public class d extends AutoCompleteTextView {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f1180g = {16843126};

    /* renamed from: e  reason: collision with root package name */
    private final e f1181e;

    /* renamed from: f  reason: collision with root package name */
    private final g0 f1182f;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f3977p);
    }

    public d(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        f1.a(this, getContext());
        k1 u5 = k1.u(getContext(), attributeSet, f1180g, i5, 0);
        if (u5.r(0)) {
            setDropDownBackgroundDrawable(u5.f(0));
        }
        u5.v();
        e eVar = new e(this);
        this.f1181e = eVar;
        eVar.e(attributeSet, i5);
        g0 g0Var = new g0(this);
        this.f1182f = g0Var;
        g0Var.m(attributeSet, i5);
        g0Var.b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1181e;
        if (eVar != null) {
            eVar.b();
        }
        g0 g0Var = this.f1182f;
        if (g0Var != null) {
            g0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1181e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1181e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1181e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.f1181e;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.m(this, callback));
    }

    public void setDropDownBackgroundResource(int i5) {
        setDropDownBackgroundDrawable(e.a.b(getContext(), i5));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1181e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1181e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        g0 g0Var = this.f1182f;
        if (g0Var != null) {
            g0Var.q(context, i5);
        }
    }
}
