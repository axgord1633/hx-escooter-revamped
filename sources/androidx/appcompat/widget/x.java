package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;
import d.j;

class x extends r {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1450d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1451e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f1452f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f1453g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1454h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1455i = false;

    x(SeekBar seekBar) {
        super(seekBar);
        this.f1450d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1451e;
        if (drawable == null) {
            return;
        }
        if (this.f1454h || this.f1455i) {
            Drawable p5 = a.p(drawable.mutate());
            this.f1451e = p5;
            if (this.f1454h) {
                a.n(p5, this.f1452f);
            }
            if (this.f1455i) {
                a.o(this.f1451e, this.f1453g);
            }
            if (this.f1451e.isStateful()) {
                this.f1451e.setState(this.f1450d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i5) {
        super.c(attributeSet, i5);
        Context context = this.f1450d.getContext();
        int[] iArr = j.V;
        k1 u5 = k1.u(context, attributeSet, iArr, i5, 0);
        SeekBar seekBar = this.f1450d;
        k0.M(seekBar, seekBar.getContext(), iArr, attributeSet, u5.q(), i5, 0);
        Drawable g5 = u5.g(j.W);
        if (g5 != null) {
            this.f1450d.setThumb(g5);
        }
        j(u5.f(j.X));
        int i6 = j.Z;
        if (u5.r(i6)) {
            this.f1453g = o0.c(u5.j(i6, -1), this.f1453g);
            this.f1455i = true;
        }
        int i7 = j.Y;
        if (u5.r(i7)) {
            this.f1452f = u5.c(i7);
            this.f1454h = true;
        }
        u5.v();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f1451e != null) {
            int max = this.f1450d.getMax();
            int i5 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1451e.getIntrinsicWidth();
                int intrinsicHeight = this.f1451e.getIntrinsicHeight();
                int i6 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i5 = intrinsicHeight / 2;
                }
                this.f1451e.setBounds(-i6, -i5, i6, i5);
                float width = ((float) ((this.f1450d.getWidth() - this.f1450d.getPaddingLeft()) - this.f1450d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1450d.getPaddingLeft(), (float) (this.f1450d.getHeight() / 2));
                for (int i7 = 0; i7 <= max; i7++) {
                    this.f1451e.draw(canvas);
                    canvas.translate(width, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1451e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1450d.getDrawableState())) {
            this.f1450d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1451e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Drawable drawable) {
        Drawable drawable2 = this.f1451e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1451e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1450d);
            a.l(drawable, k0.q(this.f1450d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1450d.getDrawableState());
            }
            f();
        }
        this.f1450d.invalidate();
    }
}
