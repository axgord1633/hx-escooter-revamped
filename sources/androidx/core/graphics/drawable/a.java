package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class a {

    /* renamed from: androidx.core.graphics.drawable.a$a  reason: collision with other inner class name */
    static class C0025a {
        static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i5) {
            return drawableContainerState.getChild(i5);
        }

        static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        static void e(Drawable drawable, boolean z4) {
            drawable.setAutoMirrored(z4);
        }
    }

    static class b {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f5, float f6) {
            drawable.setHotspot(f5, f6);
        }

        static void f(Drawable drawable, int i5, int i6, int i7, int i8) {
            drawable.setHotspotBounds(i5, i6, i7, i8);
        }

        static void g(Drawable drawable, int i5) {
            drawable.setTint(i5);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class c {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i5) {
            return drawable.setLayoutDirection(i5);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        b.a(drawable, theme);
    }

    public static boolean b(Drawable drawable) {
        return b.b(drawable);
    }

    public static int c(Drawable drawable) {
        return C0025a.a(drawable);
    }

    public static ColorFilter d(Drawable drawable) {
        return b.c(drawable);
    }

    public static int e(Drawable drawable) {
        return c.a(drawable);
    }

    public static void f(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean g(Drawable drawable) {
        return C0025a.d(drawable);
    }

    @Deprecated
    public static void h(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void i(Drawable drawable, boolean z4) {
        C0025a.e(drawable, z4);
    }

    public static void j(Drawable drawable, float f5, float f6) {
        b.e(drawable, f5, f6);
    }

    public static void k(Drawable drawable, int i5, int i6, int i7, int i8) {
        b.f(drawable, i5, i6, i7, i8);
    }

    public static boolean l(Drawable drawable, int i5) {
        return c.b(drawable, i5);
    }

    public static void m(Drawable drawable, int i5) {
        b.g(drawable, i5);
    }

    public static void n(Drawable drawable, ColorStateList colorStateList) {
        b.h(drawable, colorStateList);
    }

    public static void o(Drawable drawable, PorterDuff.Mode mode) {
        b.i(drawable, mode);
    }

    public static Drawable p(Drawable drawable) {
        return drawable;
    }
}
