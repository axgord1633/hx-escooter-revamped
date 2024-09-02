package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class o extends ImageView {
    private final e mBackgroundTintHelper;
    private final n mImageHelper;

    public o(Context context) {
        this(context, (AttributeSet) null);
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o(Context context, AttributeSet attributeSet, int i5) {
        super(h1.b(context), attributeSet, i5);
        f1.a(this, getContext());
        e eVar = new e(this);
        this.mBackgroundTintHelper = eVar;
        eVar.e(attributeSet, i5);
        n nVar = new n(this);
        this.mImageHelper = nVar;
        nVar.f(attributeSet, i5);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.b();
        }
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.b();
        }
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

    public ColorStateList getSupportImageTintList() {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.e() && super.hasOverlappingRendering();
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

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.b();
        }
    }

    public void setImageResource(int i5) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.g(i5);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.b();
        }
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.i(mode);
        }
    }
}
