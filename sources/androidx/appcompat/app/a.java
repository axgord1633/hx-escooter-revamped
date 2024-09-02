package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import d.j;
import h.b;

public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    public static class C0014a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f617a = 8388627;

        public C0014a(int i5, int i6) {
            super(i5, i6);
        }

        public C0014a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f4195t);
            this.f617a = obtainStyledAttributes.getInt(j.f4200u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0014a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0014a(C0014a aVar) {
            super(aVar);
            this.f617a = aVar.f617a;
        }
    }

    public interface b {
        void onMenuVisibilityChanged(boolean z4);
    }

    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z4);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    /* access modifiers changed from: package-private */
    public void n() {
    }

    public abstract boolean o(int i5, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z4);

    public abstract void s(boolean z4);

    public abstract void t(boolean z4);

    public abstract void u(CharSequence charSequence);

    public h.b v(b.a aVar) {
        return null;
    }
}
