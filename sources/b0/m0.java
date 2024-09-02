package b0;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static Field f2927a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2928b;

    m0() {
    }

    public void a(View view) {
        throw null;
    }

    public float b(View view) {
        throw null;
    }

    public void c(View view) {
        throw null;
    }

    public void d(View view, int i5, int i6, int i7, int i8) {
        throw null;
    }

    public void e(View view, float f5) {
        throw null;
    }

    public void f(View view, int i5) {
        if (!f2928b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2927a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f2928b = true;
        }
        Field field = f2927a;
        if (field != null) {
            try {
                f2927a.setInt(view, i5 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void g(View view, Matrix matrix) {
        throw null;
    }

    public void h(View view, Matrix matrix) {
        throw null;
    }
}
