package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public final class j {

    static class a {
        static Intent a(Activity activity) {
            return activity.getParentActivityIntent();
        }

        static boolean b(Activity activity, Intent intent) {
            return activity.navigateUpTo(intent);
        }

        static boolean c(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }
    }

    public static Intent a(Activity activity) {
        Intent a5 = a.a(activity);
        if (a5 != null) {
            return a5;
        }
        String c5 = c(activity);
        if (c5 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, c5);
        try {
            return d(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + c5 + "' in manifest");
            return null;
        }
    }

    public static Intent b(Context context, ComponentName componentName) {
        String d5 = d(context, componentName);
        if (d5 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), d5);
        return d(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String c(Activity activity) {
        try {
            return d(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public static String d(Context context, ComponentName componentName) {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i5 = Build.VERSION.SDK_INT;
        int i6 = 640;
        if (i5 >= 29) {
            i6 = 269222528;
        } else if (i5 >= 24) {
            i6 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i6);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void e(Activity activity, Intent intent) {
        a.b(activity, intent);
    }

    public static boolean f(Activity activity, Intent intent) {
        return a.c(activity, intent);
    }
}
