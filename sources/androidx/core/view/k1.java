package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class k1 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<View> f1952a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f1953b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f1954c = null;

    /* renamed from: d  reason: collision with root package name */
    int f1955d = -1;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l1 f1956a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f1957b;

        a(l1 l1Var, View view) {
            this.f1956a = l1Var;
            this.f1957b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f1956a.a(this.f1957b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f1956a.b(this.f1957b);
        }

        public void onAnimationStart(Animator animator) {
            this.f1956a.c(this.f1957b);
        }
    }

    static class b {
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    k1(View view) {
        this.f1952a = new WeakReference<>(view);
    }

    private void i(View view, l1 l1Var) {
        if (l1Var != null) {
            view.animate().setListener(new a(l1Var, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public k1 b(float f5) {
        View view = this.f1952a.get();
        if (view != null) {
            view.animate().alpha(f5);
        }
        return this;
    }

    public void c() {
        View view = this.f1952a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f1952a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public k1 f(long j5) {
        View view = this.f1952a.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
        return this;
    }

    public k1 g(Interpolator interpolator) {
        View view = this.f1952a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public k1 h(l1 l1Var) {
        View view = this.f1952a.get();
        if (view != null) {
            i(view, l1Var);
        }
        return this;
    }

    public k1 j(long j5) {
        View view = this.f1952a.get();
        if (view != null) {
            view.animate().setStartDelay(j5);
        }
        return this;
    }

    public k1 k(n1 n1Var) {
        View view = this.f1952a.get();
        if (view != null) {
            j1 j1Var = null;
            if (n1Var != null) {
                j1Var = new j1(n1Var, view);
            }
            b.a(view.animate(), j1Var);
        }
        return this;
    }

    public void l() {
        View view = this.f1952a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public k1 m(float f5) {
        View view = this.f1952a.get();
        if (view != null) {
            view.animate().translationY(f5);
        }
        return this;
    }
}
