package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

abstract class f extends Drawable {

    /* renamed from: e  reason: collision with root package name */
    Drawable f2740e;

    f() {
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            a.a(drawable, theme);
        }
    }

    public void clearColorFilter() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    public int getMinimumHeight() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            a.h(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i5) {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.setLevel(i5) : super.onLevelChange(i5);
    }

    public void setChangingConfigurations(int i5) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setChangingConfigurations(i5);
        } else {
            super.setChangingConfigurations(i5);
        }
    }

    public void setColorFilter(int i5, PorterDuff.Mode mode) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setColorFilter(i5, mode);
        } else {
            super.setColorFilter(i5, mode);
        }
    }

    public void setFilterBitmap(boolean z4) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setFilterBitmap(z4);
        }
    }

    public void setHotspot(float f5, float f6) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            a.j(drawable, f5, f6);
        }
    }

    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            a.k(drawable, i5, i6, i7, i8);
        }
    }

    public boolean setState(int[] iArr) {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
