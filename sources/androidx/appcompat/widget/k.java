package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.c;
import androidx.core.view.h0;
import androidx.core.view.k0;
import androidx.core.widget.o;
import d.a;
import r.b;

public class k extends EditText implements h0 {

    /* renamed from: e  reason: collision with root package name */
    private final e f1301e;

    /* renamed from: f  reason: collision with root package name */
    private final g0 f1302f;

    /* renamed from: g  reason: collision with root package name */
    private final z f1303g;

    /* renamed from: h  reason: collision with root package name */
    private final o f1304h;

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.A);
    }

    public k(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        f1.a(this, getContext());
        e eVar = new e(this);
        this.f1301e = eVar;
        eVar.e(attributeSet, i5);
        g0 g0Var = new g0(this);
        this.f1302f = g0Var;
        g0Var.m(attributeSet, i5);
        g0Var.b();
        this.f1303g = new z(this);
        this.f1304h = new o();
    }

    public c a(c cVar) {
        return this.f1304h.a(this, cVar);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1301e;
        if (eVar != null) {
            eVar.b();
        }
        g0 g0Var = this.f1302f;
        if (g0Var != null) {
            g0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1301e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1301e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.f1303g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.z r0 = r2.f1303g
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        L_0x0010:
            android.view.textclassifier.TextClassifier r0 = super.getTextClassifier()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1302f.r(this, onCreateInputConnection, editorInfo);
        InputConnection a5 = l.a(onCreateInputConnection, editorInfo, this);
        String[] s5 = k0.s(this);
        if (a5 == null || s5 == null) {
            return a5;
        }
        b.d(editorInfo, s5);
        return r.c.a(a5, editorInfo, u.a(this));
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (u.b(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public boolean onTextContextMenuItem(int i5) {
        if (u.c(this, i5)) {
            return true;
        }
        return super.onTextContextMenuItem(i5);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1301e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.f1301e;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.m(this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1301e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1301e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        g0 g0Var = this.f1302f;
        if (g0Var != null) {
            g0Var.q(context, i5);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.f1303g) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            zVar.b(textClassifier);
        }
    }
}
