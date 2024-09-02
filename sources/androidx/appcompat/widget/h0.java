package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.graphics.d;
import androidx.core.widget.b;
import androidx.core.widget.k;
import androidx.core.widget.p;
import e.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import q.c;

public class h0 extends TextView implements p, b {
    private final e mBackgroundTintHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<c> mPrecomputedTextFuture;
    private final z mTextClassifierHelper;
    private final g0 mTextHelper;

    public h0(Context context) {
        this(context, (AttributeSet) null);
    }

    public h0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public h0(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        this.mIsSetTypefaceProcessing = false;
        f1.a(this, getContext());
        e eVar = new e(this);
        this.mBackgroundTintHelper = eVar;
        eVar.e(attributeSet, i5);
        g0 g0Var = new g0(this);
        this.mTextHelper = g0Var;
        g0Var.m(attributeSet, i5);
        g0Var.b();
        this.mTextClassifierHelper = new z(this);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<c> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                k.k(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.b();
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f2053a) {
            return super.getAutoSizeMaxTextSize();
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            return g0Var.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f2053a) {
            return super.getAutoSizeMinTextSize();
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            return g0Var.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f2053a) {
            return super.getAutoSizeStepGranularity();
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            return g0Var.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f2053a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        g0 g0Var = this.mTextHelper;
        return g0Var != null ? g0Var.h() : new int[0];
    }

    public int getAutoSizeTextType() {
        if (b.f2053a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            return g0Var.i();
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return k.a(this);
    }

    public int getLastBaselineToBottomHeight() {
        return k.b(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.mTextClassifierHelper;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.z r0 = r2.mTextClassifierHelper
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        L_0x0010:
            android.view.textclassifier.TextClassifier r0 = super.getTextClassifier()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h0.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public c.a getTextMetricsParamsCompat() {
        return k.e(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.r(this, onCreateInputConnection, editorInfo);
        return l.a(onCreateInputConnection, editorInfo, this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.o(z4, i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i5, i6);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null && !b.f2053a && g0Var.l()) {
            this.mTextHelper.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        if (b.f2053a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
            return;
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.t(i5, i6, i7, i8);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        if (b.f2053a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
            return;
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.u(iArr, i5);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i5) {
        if (b.f2053a) {
            super.setAutoSizeTextTypeWithDefaults(i5);
            return;
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.v(i5);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b5 = i5 != 0 ? a.b(context, i5) : null;
        Drawable b6 = i6 != 0 ? a.b(context, i6) : null;
        Drawable b7 = i7 != 0 ? a.b(context, i7) : null;
        if (i8 != 0) {
            drawable = a.b(context, i8);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b5, b6, b7, drawable);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b5 = i5 != 0 ? a.b(context, i5) : null;
        Drawable b6 = i6 != 0 ? a.b(context, i6) : null;
        Drawable b7 = i7 != 0 ? a.b(context, i7) : null;
        if (i8 != 0) {
            drawable = a.b(context, i8);
        }
        setCompoundDrawablesWithIntrinsicBounds(b5, b6, b7, drawable);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.m(this, callback));
    }

    public void setFirstBaselineToTopHeight(int i5) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i5);
        } else {
            k.h(this, i5);
        }
    }

    public void setLastBaselineToBottomHeight(int i5) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i5);
        } else {
            k.i(this, i5);
        }
    }

    public void setLineHeight(int i5) {
        k.j(this, i5);
    }

    public void setPrecomputedText(c cVar) {
        k.k(this, cVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.w(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.x(mode);
        this.mTextHelper.b();
    }

    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.q(context, i5);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            zVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<c> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        k.l(this, aVar);
    }

    public void setTextSize(int i5, float f5) {
        if (b.f2053a) {
            super.setTextSize(i5, f5);
            return;
        }
        g0 g0Var = this.mTextHelper;
        if (g0Var != null) {
            g0Var.A(i5, f5);
        }
    }

    public void setTypeface(Typeface typeface, int i5) {
        if (!this.mIsSetTypefaceProcessing) {
            Typeface typeface2 = null;
            if (typeface != null && i5 > 0) {
                typeface2 = d.a(getContext(), typeface, i5);
            }
            this.mIsSetTypefaceProcessing = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i5);
            } finally {
                this.mIsSetTypefaceProcessing = false;
            }
        }
    }
}
