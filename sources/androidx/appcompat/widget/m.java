package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import d.a;

public class m extends ImageButton {

    /* renamed from: e  reason: collision with root package name */
    private final e f1332e;

    /* renamed from: f  reason: collision with root package name */
    private final n f1333f;

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.B);
    }

    public m(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        f1.a(this, getContext());
        e eVar = new e(this);
        this.f1332e = eVar;
        eVar.e(attributeSet, i5);
        n nVar = new n(this);
        this.f1333f = nVar;
        nVar.f(attributeSet, i5);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1332e;
        if (eVar != null) {
            eVar.b();
        }
        n nVar = this.f1333f;
        if (nVar != null) {
            nVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1332e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1332e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        n nVar = this.f1333f;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.f1333f;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1333f.e() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1332e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.f1332e;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.f1333f;
        if (nVar != null) {
            nVar.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.f1333f;
        if (nVar != null) {
            nVar.b();
        }
    }

    public void setImageResource(int i5) {
        this.f1333f.g(i5);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.f1333f;
        if (nVar != null) {
            nVar.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1332e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1332e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.f1333f;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.f1333f;
        if (nVar != null) {
            nVar.i(mode);
        }
    }
}
