package b0;

import android.graphics.Matrix;
import android.view.View;

class g0 extends d0 {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2888d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2889e = true;

    g0() {
    }

    public void g(View view, Matrix matrix) {
        if (f2888d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2888d = false;
            }
        }
    }

    public void h(View view, Matrix matrix) {
        if (f2889e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2889e = false;
            }
        }
    }
}
