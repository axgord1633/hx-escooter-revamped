package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.a;
import d.j;

public class f1 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1227a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1228b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1229c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1230d = {16843518};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1231e = {16842919};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f1232f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f1233g = {16842913};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f1234h = {-16842919, -16842908};

    /* renamed from: i  reason: collision with root package name */
    static final int[] f1235i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f1236j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(j.f4226z0);
        try {
            if (!obtainStyledAttributes.hasValue(j.E0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i5) {
        ColorStateList e5 = e(context, i5);
        if (e5 != null && e5.isStateful()) {
            return e5.getColorForState(f1228b, e5.getDefaultColor());
        }
        TypedValue f5 = f();
        context.getTheme().resolveAttribute(16842803, f5, true);
        return d(context, i5, f5.getFloat());
    }

    public static int c(Context context, int i5) {
        int[] iArr = f1236j;
        iArr[0] = i5;
        k1 t5 = k1.t(context, (AttributeSet) null, iArr);
        try {
            return t5.b(0, 0);
        } finally {
            t5.v();
        }
    }

    static int d(Context context, int i5, float f5) {
        int c5 = c(context, i5);
        return a.f(c5, Math.round(((float) Color.alpha(c5)) * f5));
    }

    public static ColorStateList e(Context context, int i5) {
        int[] iArr = f1236j;
        iArr[0] = i5;
        k1 t5 = k1.t(context, (AttributeSet) null, iArr);
        try {
            return t5.c(0);
        } finally {
            t5.v();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f1227a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
