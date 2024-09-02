package b0;

import android.view.View;

class d0 extends m0 {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2869c = true;

    d0() {
    }

    public void a(View view) {
    }

    public float b(View view) {
        if (f2869c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2869c = false;
            }
        }
        return view.getAlpha();
    }

    public void c(View view) {
    }

    public void e(View view, float f5) {
        if (f2869c) {
            try {
                view.setTransitionAlpha(f5);
                return;
            } catch (NoSuchMethodError unused) {
                f2869c = false;
            }
        }
        view.setAlpha(f5);
    }
}
