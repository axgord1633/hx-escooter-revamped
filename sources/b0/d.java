package b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;

public class d extends n0 {

    class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f2865a;

        a(View view) {
            this.f2865a = view;
        }

        public void b(l lVar) {
            a0.g(this.f2865a, 1.0f);
            a0.a(this.f2865a);
            lVar.Q(this);
        }
    }

    private static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f2867a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2868b = false;

        b(View view) {
            this.f2867a = view;
        }

        public void onAnimationEnd(Animator animator) {
            a0.g(this.f2867a, 1.0f);
            if (this.f2868b) {
                this.f2867a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (k0.y(this.f2867a) && this.f2867a.getLayerType() == 0) {
                this.f2868b = true;
                this.f2867a.setLayerType(2, (Paint) null);
            }
        }
    }

    public d(int i5) {
        j0(i5);
    }

    private Animator k0(View view, float f5, float f6) {
        if (f5 == f6) {
            return null;
        }
        a0.g(view, f5);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, a0.f2837b, new float[]{f6});
        ofFloat.addListener(new b(view));
        a(new a(view));
        return ofFloat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f2959a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float l0(b0.s r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f2959a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.d.l0(b0.s, float):float");
    }

    public Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
        float l02 = l0(sVar, CropImageView.DEFAULT_ASPECT_RATIO);
        if (l02 != 1.0f) {
            f5 = l02;
        }
        return k0(view, f5, 1.0f);
    }

    public Animator h0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        a0.e(view);
        return k0(view, l0(sVar, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public void k(s sVar) {
        super.k(sVar);
        sVar.f2959a.put("android:fade:transitionAlpha", Float.valueOf(a0.c(sVar.f2960b)));
    }
}
