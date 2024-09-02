package b0;

import android.os.Build;
import android.view.ViewGroup;

class x {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2967a = true;

    static v a(ViewGroup viewGroup) {
        return new u(viewGroup);
    }

    private static void b(ViewGroup viewGroup, boolean z4) {
        if (f2967a) {
            try {
                viewGroup.suppressLayout(z4);
            } catch (NoSuchMethodError unused) {
                f2967a = false;
            }
        }
    }

    static void c(ViewGroup viewGroup, boolean z4) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z4);
        } else {
            b(viewGroup, z4);
        }
    }
}
