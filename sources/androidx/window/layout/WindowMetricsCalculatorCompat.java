package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.k;

public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();
    private static final String TAG;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        k.d(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = simpleName;
    }

    private WindowMetricsCalculatorCompat() {
    }

    private final DisplayCutout getCutoutForDisplay(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{newInstance.getClass()});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, new Object[]{newInstance});
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e5) {
            Log.w(TAG, e5);
        }
        return null;
    }

    private final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void getRectSizeFromDisplay(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    public WindowMetrics computeCurrentWindowMetrics(Activity activity) {
        k.e(activity, "activity");
        int i5 = Build.VERSION.SDK_INT;
        return new WindowMetrics(i5 >= 30 ? ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(activity) : i5 >= 29 ? computeWindowBoundsQ$window_release(activity) : i5 >= 28 ? computeWindowBoundsP$window_release(activity) : i5 >= 24 ? computeWindowBoundsN$window_release(activity) : computeWindowBoundsIceCreamSandwich$window_release(activity));
    }

    public WindowMetrics computeMaximumWindowMetrics(Activity activity) {
        Rect rect;
        k.e(activity, "activity");
        if (Build.VERSION.SDK_INT >= 30) {
            rect = ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(activity);
        } else {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            k.d(defaultDisplay, "display");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            rect = new Rect(0, 0, realSizeForDisplay$window_release.x, realSizeForDisplay$window_release.y);
        }
        return new WindowMetrics(rect);
    }

    public final Rect computeWindowBoundsIceCreamSandwich$window_release(Activity activity) {
        int i5;
        k.e(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        k.d(defaultDisplay, "defaultDisplay");
        Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
        Rect rect = new Rect();
        int i6 = realSizeForDisplay$window_release.x;
        if (i6 == 0 || (i5 = realSizeForDisplay$window_release.y) == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = i6;
            rect.bottom = i5;
        }
        return rect;
    }

    public final Rect computeWindowBoundsN$window_release(Activity activity) {
        k.e(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            k.d(defaultDisplay, "defaultDisplay");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i5 = rect.bottom;
            if (i5 + navigationBarHeight == realSizeForDisplay$window_release.y) {
                rect.bottom = i5 + navigationBarHeight;
            } else {
                int i6 = rect.right;
                if (i6 + navigationBarHeight == realSizeForDisplay$window_release.x) {
                    rect.right = i6 + navigationBarHeight;
                }
            }
        }
        return rect;
    }

    public final Rect computeWindowBoundsP$window_release(Activity activity) {
        DisplayCutout cutoutForDisplay;
        Rect rect;
        k.e(activity, "activity");
        Rect rect2 = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                if (invoke != null) {
                    rect = (Rect) invoke;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                if (invoke2 != null) {
                    rect = (Rect) invoke2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            }
            rect2.set(rect);
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e5) {
            Log.w(TAG, e5);
            getRectSizeFromDisplay(activity, rect2);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayCompatHelperApi17 displayCompatHelperApi17 = DisplayCompatHelperApi17.INSTANCE;
        k.d(defaultDisplay, "currentDisplay");
        displayCompatHelperApi17.getRealSize(defaultDisplay, point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.INSTANCE;
        if (!activityCompatHelperApi24.isInMultiWindowMode(activity)) {
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i5 = rect2.bottom;
            if (i5 + navigationBarHeight == point.y) {
                rect2.bottom = i5 + navigationBarHeight;
            } else {
                int i6 = rect2.right;
                if (i6 + navigationBarHeight == point.x) {
                    rect2.right = i6 + navigationBarHeight;
                } else if (rect2.left == navigationBarHeight) {
                    rect2.left = 0;
                }
            }
        }
        if ((rect2.width() < point.x || rect2.height() < point.y) && !activityCompatHelperApi24.isInMultiWindowMode(activity) && (cutoutForDisplay = getCutoutForDisplay(defaultDisplay)) != null) {
            int i7 = rect2.left;
            DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.INSTANCE;
            if (i7 == displayCompatHelperApi28.safeInsetLeft(cutoutForDisplay)) {
                rect2.left = 0;
            }
            if (point.x - rect2.right == displayCompatHelperApi28.safeInsetRight(cutoutForDisplay)) {
                rect2.right += displayCompatHelperApi28.safeInsetRight(cutoutForDisplay);
            }
            if (rect2.top == displayCompatHelperApi28.safeInsetTop(cutoutForDisplay)) {
                rect2.top = 0;
            }
            if (point.y - rect2.bottom == displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay)) {
                rect2.bottom += displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay);
            }
        }
        return rect2;
    }

    public final Rect computeWindowBoundsQ$window_release(Activity activity) {
        k.e(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            if (invoke != null) {
                return new Rect((Rect) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e5) {
            Log.w(TAG, e5);
            return computeWindowBoundsP$window_release(activity);
        }
    }

    public final Point getRealSizeForDisplay$window_release(Display display) {
        k.e(display, "display");
        Point point = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(display, point);
        return point;
    }
}
