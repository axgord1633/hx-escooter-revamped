package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class c {
    public static Interpolator a(Context context, int i5) {
        return AnimationUtils.loadInterpolator(context, i5);
    }
}
