package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.k;
import e.a;

public class h extends CheckedTextView {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f1261f = {16843016};

    /* renamed from: e  reason: collision with root package name */
    private final g0 f1262e;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public h(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        f1.a(this, getContext());
        g0 g0Var = new g0(this);
        this.f1262e = g0Var;
        g0Var.m(attributeSet, i5);
        g0Var.b();
        k1 u5 = k1.u(getContext(), attributeSet, f1261f, i5, 0);
        setCheckMarkDrawable(u5.f(0));
        u5.v();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        g0 g0Var = this.f1262e;
        if (g0Var != null) {
            g0Var.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCheckMarkDrawable(int i5) {
        setCheckMarkDrawable(a.b(getContext(), i5));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.m(this, callback));
    }

    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        g0 g0Var = this.f1262e;
        if (g0Var != null) {
            g0Var.q(context, i5);
        }
    }
}
