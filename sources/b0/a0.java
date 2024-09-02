package b0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.k0;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static final m0 f2836a = (Build.VERSION.SDK_INT >= 29 ? new l0() : new k0());

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f2837b = new a(Float.class, "translationAlpha");

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Rect> f2838c = new b(Rect.class, "clipBounds");

    class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(a0.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f5) {
            a0.g(view, f5.floatValue());
        }
    }

    class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return k0.n(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            k0.S(view, rect);
        }
    }

    static void a(View view) {
        f2836a.a(view);
    }

    static z b(View view) {
        return new y(view);
    }

    static float c(View view) {
        return f2836a.b(view);
    }

    static p0 d(View view) {
        return new o0(view);
    }

    static void e(View view) {
        f2836a.c(view);
    }

    static void f(View view, int i5, int i6, int i7, int i8) {
        f2836a.d(view, i5, i6, i7, i8);
    }

    static void g(View view, float f5) {
        f2836a.e(view, f5);
    }

    static void h(View view, int i5) {
        f2836a.f(view, i5);
    }

    static void i(View view, Matrix matrix) {
        f2836a.g(view, matrix);
    }

    static void j(View view, Matrix matrix) {
        f2836a.h(view, matrix);
    }
}
