package androidx.core.view;

import android.view.ViewGroup;

public final class h {

    static class a {
        static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
            marginLayoutParams.resolveLayoutDirection(i5);
        }

        static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
            marginLayoutParams.setLayoutDirection(i5);
        }

        static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
            marginLayoutParams.setMarginEnd(i5);
        }

        static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
            marginLayoutParams.setMarginStart(i5);
        }
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.c(marginLayoutParams);
    }
}
