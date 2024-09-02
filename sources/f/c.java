package f;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class c extends Drawable implements Drawable.Callback {

    /* renamed from: e  reason: collision with root package name */
    private Drawable f4594e;

    public c(Drawable drawable) {
        b(drawable);
    }

    public Drawable a() {
        return this.f4594e;
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.f4594e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f4594e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f4594e.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f4594e.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f4594e.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f4594e.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f4594e.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f4594e.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f4594e.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f4594e.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f4594e.getPadding(rect);
    }

    public int[] getState() {
        return this.f4594e.getState();
    }

    public Region getTransparentRegion() {
        return this.f4594e.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.g(this.f4594e);
    }

    public boolean isStateful() {
        return this.f4594e.isStateful();
    }

    public void jumpToCurrentState() {
        this.f4594e.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f4594e.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i5) {
        return this.f4594e.setLevel(i5);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        scheduleSelf(runnable, j5);
    }

    public void setAlpha(int i5) {
        this.f4594e.setAlpha(i5);
    }

    public void setAutoMirrored(boolean z4) {
        a.i(this.f4594e, z4);
    }

    public void setChangingConfigurations(int i5) {
        this.f4594e.setChangingConfigurations(i5);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4594e.setColorFilter(colorFilter);
    }

    public void setDither(boolean z4) {
        this.f4594e.setDither(z4);
    }

    public void setFilterBitmap(boolean z4) {
        this.f4594e.setFilterBitmap(z4);
    }

    public void setHotspot(float f5, float f6) {
        a.j(this.f4594e, f5, f6);
    }

    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        a.k(this.f4594e, i5, i6, i7, i8);
    }

    public boolean setState(int[] iArr) {
        return this.f4594e.setState(iArr);
    }

    public void setTint(int i5) {
        a.m(this.f4594e, i5);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.n(this.f4594e, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.o(this.f4594e, mode);
    }

    public boolean setVisible(boolean z4, boolean z5) {
        return super.setVisible(z4, z5) || this.f4594e.setVisible(z4, z5);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
