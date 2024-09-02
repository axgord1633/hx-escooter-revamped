package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import androidx.core.graphics.drawable.h;
import f.c;

public class o0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1338a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1339b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f1340c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private static Class<?> f1341d;

    static {
        try {
            f1341d = Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean a(Drawable drawable) {
        Drawable drawable2;
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable a5 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!a(a5)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof h) {
            drawable2 = ((h) drawable).b();
        } else if (drawable instanceof c) {
            drawable2 = ((c) drawable).a();
        } else if (!(drawable instanceof ScaleDrawable)) {
            return true;
        } else {
            drawable2 = ((ScaleDrawable) drawable).getDrawable();
        }
        return a(drawable2);
    }

    static void b(Drawable drawable) {
    }

    public static PorterDuff.Mode c(int i5, PorterDuff.Mode mode) {
        if (i5 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i5 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i5 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i5) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
