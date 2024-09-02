package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class j1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n1 f1925a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1926b;

    public /* synthetic */ j1(n1 n1Var, View view) {
        this.f1925a = n1Var;
        this.f1926b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1925a.a(this.f1926b);
    }
}
