package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

public final class j {

    static class a {
        static void a(PopupWindow popupWindow, View view, int i5, int i6, int i7) {
            popupWindow.showAsDropDown(view, i5, i6, i7);
        }
    }

    static class b {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z4) {
            popupWindow.setOverlapAnchor(z4);
        }

        static void d(PopupWindow popupWindow, int i5) {
            popupWindow.setWindowLayoutType(i5);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z4) {
        b.c(popupWindow, z4);
    }

    public static void b(PopupWindow popupWindow, int i5) {
        b.d(popupWindow, i5);
    }

    public static void c(PopupWindow popupWindow, View view, int i5, int i6, int i7) {
        a.a(popupWindow, view, i5, i6, i7);
    }
}
