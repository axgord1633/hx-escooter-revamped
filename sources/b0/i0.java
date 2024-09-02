package b0;

import android.view.View;

class i0 extends g0 {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2892f = true;

    i0() {
    }

    public void d(View view, int i5, int i6, int i7, int i8) {
        if (f2892f) {
            try {
                view.setLeftTopRightBottom(i5, i6, i7, i8);
            } catch (NoSuchMethodError unused) {
                f2892f = false;
            }
        }
    }
}
