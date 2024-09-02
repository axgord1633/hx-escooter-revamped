package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import kotlin.jvm.internal.k;

public final class DisplayCompatHelperApi17 {
    public static final DisplayCompatHelperApi17 INSTANCE = new DisplayCompatHelperApi17();

    private DisplayCompatHelperApi17() {
    }

    public final void getRealSize(Display display, Point point) {
        k.e(display, "display");
        k.e(point, "point");
        display.getRealSize(point);
    }
}
