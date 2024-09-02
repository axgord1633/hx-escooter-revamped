package io.flutter.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.g;
import k2.b;
import k2.c;

public final class ViewUtils {

    public interface DisplayUpdater {
        void updateDisplayMetrics(float f5, float f6, float f7);
    }

    public interface ViewVisitor {
        boolean run(View view);
    }

    public static void calculateMaximumDisplayMetrics(Context context, DisplayUpdater displayUpdater) {
        Activity activity = getActivity(context);
        if (activity != null) {
            WindowMetrics computeMaximumWindowMetrics = g.a().computeMaximumWindowMetrics(activity);
            displayUpdater.updateDisplayMetrics((float) computeMaximumWindowMetrics.getBounds().width(), (float) computeMaximumWindowMetrics.getBounds().height(), context.getResources().getDisplayMetrics().density);
        }
    }

    public static boolean childHasFocus(View view) {
        return traverseHierarchy(view, new b());
    }

    public static int generateViewId(int i5) {
        return View.generateViewId();
    }

    public static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean hasChildViewOfType(View view, Class<? extends View>[] clsArr) {
        return traverseHierarchy(view, new c(clsArr));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$hasChildViewOfType$1(Class[] clsArr, View view) {
        for (Class isInstance : clsArr) {
            if (isInstance.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean traverseHierarchy(View view, ViewVisitor viewVisitor) {
        if (view == null) {
            return false;
        }
        if (viewVisitor.run(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                if (traverseHierarchy(viewGroup.getChildAt(i5), viewVisitor)) {
                    return true;
                }
            }
        }
        return false;
    }
}
