package b0;

import android.os.Build;
import android.view.View;

class k0 extends i0 {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f2896g = true;

    k0() {
    }

    public void f(View view, int i5) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i5);
        } else if (f2896g) {
            try {
                view.setTransitionVisibility(i5);
            } catch (NoSuchMethodError unused) {
                f2896g = false;
            }
        }
    }
}
