package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.e;
import androidx.core.view.i0;
import androidx.fragment.app.x;

class f {

    class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f2294a;

        a(Fragment fragment) {
            this.f2294a = fragment;
        }

        public void onCancel() {
            if (this.f2294a.getAnimatingAway() != null) {
                View animatingAway = this.f2294a.getAnimatingAway();
                this.f2294a.setAnimatingAway((View) null);
                animatingAway.clearAnimation();
            }
            this.f2294a.setAnimator((Animator) null);
        }
    }

    class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2295a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f2296b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.g f2297c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f2298d;

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (b.this.f2296b.getAnimatingAway() != null) {
                    b.this.f2296b.setAnimatingAway((View) null);
                    b bVar = b.this;
                    bVar.f2297c.a(bVar.f2296b, bVar.f2298d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, x.g gVar, androidx.core.os.e eVar) {
            this.f2295a = viewGroup;
            this.f2296b = fragment;
            this.f2297c = gVar;
            this.f2298d = eVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2295a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2300a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2301b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f2302c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.g f2303d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f2304e;

        c(ViewGroup viewGroup, View view, Fragment fragment, x.g gVar, androidx.core.os.e eVar) {
            this.f2300a = viewGroup;
            this.f2301b = view;
            this.f2302c = fragment;
            this.f2303d = gVar;
            this.f2304e = eVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2300a.endViewTransition(this.f2301b);
            Animator animator2 = this.f2302c.getAnimator();
            this.f2302c.setAnimator((Animator) null);
            if (animator2 != null && this.f2300a.indexOfChild(this.f2301b) < 0) {
                this.f2303d.a(this.f2302c, this.f2304e);
            }
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f2305a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f2306b;

        d(Animator animator) {
            this.f2305a = null;
            this.f2306b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        d(Animation animation) {
            this.f2305a = animation;
            this.f2306b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    static class e extends AnimationSet implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        private final ViewGroup f2307e;

        /* renamed from: f  reason: collision with root package name */
        private final View f2308f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2309g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f2310h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f2311i = true;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2307e = viewGroup;
            this.f2308f = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j5, Transformation transformation) {
            this.f2311i = true;
            if (this.f2309g) {
                return !this.f2310h;
            }
            if (!super.getTransformation(j5, transformation)) {
                this.f2309g = true;
                i0.a(this.f2307e, this);
            }
            return true;
        }

        public boolean getTransformation(long j5, Transformation transformation, float f5) {
            this.f2311i = true;
            if (this.f2309g) {
                return !this.f2310h;
            }
            if (!super.getTransformation(j5, transformation, f5)) {
                this.f2309g = true;
                i0.a(this.f2307e, this);
            }
            return true;
        }

        public void run() {
            if (this.f2309g || !this.f2311i) {
                this.f2307e.endViewTransition(this.f2308f);
                this.f2310h = true;
                return;
            }
            this.f2311i = false;
            this.f2307e.post(this);
        }
    }

    static void a(Fragment fragment, d dVar, x.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        androidx.core.os.e eVar = new androidx.core.os.e();
        eVar.c(new a(fragment));
        gVar.b(fragment, eVar);
        if (dVar.f2305a != null) {
            e eVar2 = new e(dVar.f2305a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar2.setAnimationListener(new b(viewGroup, fragment, gVar, eVar));
            fragment.mView.startAnimation(eVar2);
            return;
        }
        Animator animator = dVar.f2306b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, eVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z4, boolean z5) {
        return z5 ? z4 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z4 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static d c(Context context, Fragment fragment, boolean z4, boolean z5) {
        int nextTransition = fragment.getNextTransition();
        int b5 = b(fragment, z4, z5);
        boolean z6 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i5 = u.b.f7056c;
            if (viewGroup.getTag(i5) != null) {
                fragment.mContainer.setTag(i5, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z4, b5);
        if (onCreateAnimation != null) {
            return new d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z4, b5);
        if (onCreateAnimator != null) {
            return new d(onCreateAnimator);
        }
        if (b5 == 0 && nextTransition != 0) {
            b5 = d(nextTransition, z4);
        }
        if (b5 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(b5));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, b5);
                    if (loadAnimation != null) {
                        return new d(loadAnimation);
                    }
                    z6 = true;
                } catch (Resources.NotFoundException e5) {
                    throw e5;
                } catch (RuntimeException unused) {
                }
            }
            if (!z6) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, b5);
                    if (loadAnimator != null) {
                        return new d(loadAnimator);
                    }
                } catch (RuntimeException e6) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, b5);
                        if (loadAnimation2 != null) {
                            return new d(loadAnimation2);
                        }
                    } else {
                        throw e6;
                    }
                }
            }
        }
        return null;
    }

    private static int d(int i5, boolean z4) {
        if (i5 == 4097) {
            return z4 ? u.a.f7052e : u.a.f7053f;
        }
        if (i5 == 4099) {
            return z4 ? u.a.f7050c : u.a.f7051d;
        }
        if (i5 != 8194) {
            return -1;
        }
        return z4 ? u.a.f7048a : u.a.f7049b;
    }
}
