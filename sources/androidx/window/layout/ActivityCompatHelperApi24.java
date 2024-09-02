package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.k;

public final class ActivityCompatHelperApi24 {
    public static final ActivityCompatHelperApi24 INSTANCE = new ActivityCompatHelperApi24();

    private ActivityCompatHelperApi24() {
    }

    public final boolean isInMultiWindowMode(Activity activity) {
        k.e(activity, "activity");
        return activity.isInMultiWindowMode();
    }
}
