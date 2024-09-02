package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

public final class i0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private final View f1919e;

    /* renamed from: f  reason: collision with root package name */
    private ViewTreeObserver f1920f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f1921g;

    private i0(View view, Runnable runnable) {
        this.f1919e = view;
        this.f1920f = view.getViewTreeObserver();
        this.f1921g = runnable;
    }

    public static i0 a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            i0 i0Var = new i0(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(i0Var);
            view.addOnAttachStateChangeListener(i0Var);
            return i0Var;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public void b() {
        (this.f1920f.isAlive() ? this.f1920f : this.f1919e.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f1919e.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f1921g.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f1920f = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
