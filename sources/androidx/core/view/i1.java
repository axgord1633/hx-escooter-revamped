package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class i1 {

    static class a {
        static boolean a(ViewParent viewParent, View view, float f5, float f6, boolean z4) {
            return viewParent.onNestedFling(view, f5, f6, z4);
        }

        static boolean b(ViewParent viewParent, View view, float f5, float f6) {
            return viewParent.onNestedPreFling(view, f5, f6);
        }

        static void c(ViewParent viewParent, View view, int i5, int i6, int[] iArr) {
            viewParent.onNestedPreScroll(view, i5, i6, iArr);
        }

        static void d(ViewParent viewParent, View view, int i5, int i6, int i7, int i8) {
            viewParent.onNestedScroll(view, i5, i6, i7, i8);
        }

        static void e(ViewParent viewParent, View view, View view2, int i5) {
            viewParent.onNestedScrollAccepted(view, view2, i5);
        }

        static boolean f(ViewParent viewParent, View view, View view2, int i5) {
            return viewParent.onStartNestedScroll(view, view2, i5);
        }

        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f5, float f6, boolean z4) {
        try {
            return a.a(viewParent, view, f5, f6, z4);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f5, float f6) {
        try {
            return a.b(viewParent, view, f5, f6);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i5, int i6, int[] iArr, int i7) {
        if (viewParent instanceof c0) {
            ((c0) viewParent).j(view, i5, i6, iArr, i7);
        } else if (i7 == 0) {
            try {
                a.c(viewParent, view, i5, i6, iArr);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e5);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof d0) {
            ((d0) viewParent2).m(view, i5, i6, i7, i8, i9, iArr);
            return;
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (viewParent2 instanceof c0) {
            ((c0) viewParent2).n(view, i5, i6, i7, i8, i9);
        } else if (i9 == 0) {
            try {
                a.d(viewParent, view, i5, i6, i7, i8);
            } catch (AbstractMethodError e5) {
                AbstractMethodError abstractMethodError = e5;
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", abstractMethodError);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i5, int i6) {
        if (viewParent instanceof c0) {
            ((c0) viewParent).h(view, view2, i5, i6);
        } else if (i6 == 0) {
            try {
                a.e(viewParent, view, view2, i5);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e5);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i5, int i6) {
        if (viewParent instanceof c0) {
            return ((c0) viewParent).o(view, view2, i5, i6);
        }
        if (i6 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i5);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e5);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i5) {
        if (viewParent instanceof c0) {
            ((c0) viewParent).i(view, i5);
        } else if (i5 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e5);
            }
        }
    }
}
