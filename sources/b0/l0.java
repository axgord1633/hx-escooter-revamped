package b0;

import android.graphics.Matrix;
import android.view.View;

class l0 extends k0 {
    l0() {
    }

    public float b(View view) {
        return view.getTransitionAlpha();
    }

    public void d(View view, int i5, int i6, int i7, int i8) {
        view.setLeftTopRightBottom(i5, i6, i7, i8);
    }

    public void e(View view, float f5) {
        view.setTransitionAlpha(f5);
    }

    public void f(View view, int i5) {
        view.setTransitionVisibility(i5);
    }

    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
