package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import d.j;

class q extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f1381b = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1382a;

    public q(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        a(context, attributeSet, i5, i6);
    }

    private void a(Context context, AttributeSet attributeSet, int i5, int i6) {
        k1 u5 = k1.u(context, attributeSet, j.f4108b2, i5, i6);
        int i7 = j.f4118d2;
        if (u5.r(i7)) {
            b(u5.a(i7, false));
        }
        setBackgroundDrawable(u5.f(j.f4113c2));
        u5.v();
    }

    private void b(boolean z4) {
        if (f1381b) {
            this.f1382a = z4;
        } else {
            androidx.core.widget.j.a(this, z4);
        }
    }

    public void showAsDropDown(View view, int i5, int i6) {
        if (f1381b && this.f1382a) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6);
    }

    public void showAsDropDown(View view, int i5, int i6, int i7) {
        if (f1381b && this.f1382a) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6, i7);
    }

    public void update(View view, int i5, int i6, int i7, int i8) {
        if (f1381b && this.f1382a) {
            i6 -= view.getHeight();
        }
        super.update(view, i5, i6, i7, i8);
    }
}
