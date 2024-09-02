package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

public class b extends androidx.core.content.a {

    /* renamed from: c  reason: collision with root package name */
    private static f f1520c;

    static class a {
        static void a(Activity activity) {
            activity.finishAffinity();
        }

        static void b(Activity activity, Intent intent, int i5, Bundle bundle) {
            activity.startActivityForResult(intent, i5, bundle);
        }

        static void c(Activity activity, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
            activity.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
        }
    }

    /* renamed from: androidx.core.app.b$b  reason: collision with other inner class name */
    static class C0021b {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class c {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i5) {
            activity.requestPermissions(strArr, i5);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    static class d {
        static boolean a(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        static boolean b(Activity activity, String str) {
            try {
                PackageManager packageManager = activity.getApplication().getPackageManager();
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(packageManager, new Object[]{str})).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    static class e {
        static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface f {
        boolean a(Activity activity, String[] strArr, int i5);
    }

    public interface g {
        void validateRequestPermissionsRequestCode(int i5);
    }

    public static void j(Activity activity) {
        a.a(activity);
    }

    public static void k(Activity activity) {
        C0021b.a(activity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void l(Activity activity) {
        if (!activity.isFinishing() && !e.i(activity)) {
            activity.recreate();
        }
    }

    public static void m(Activity activity) {
        C0021b.b(activity);
    }

    public static void n(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new a(activity));
        }
    }

    public static void o(Activity activity, String[] strArr, int i5) {
        f fVar = f1520c;
        if (fVar == null || !fVar.a(activity, strArr, i5)) {
            HashSet hashSet = new HashSet();
            int i6 = 0;
            while (i6 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i6])) {
                    if (!androidx.core.os.a.c() && TextUtils.equals(strArr[i6], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i6));
                    }
                    i6++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[(strArr.length - size)] : strArr;
            if (size > 0) {
                if (size != strArr.length) {
                    int i7 = 0;
                    for (int i8 = 0; i8 < strArr.length; i8++) {
                        if (!hashSet.contains(Integer.valueOf(i8))) {
                            strArr2[i7] = strArr[i8];
                            i7++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (activity instanceof g) {
                ((g) activity).validateRequestPermissionsRequestCode(i5);
            }
            c.b(activity, strArr, i5);
        }
    }

    public static void p(Activity activity, w0 w0Var) {
        C0021b.c(activity, (SharedElementCallback) null);
    }

    public static void q(Activity activity, w0 w0Var) {
        C0021b.d(activity, (SharedElementCallback) null);
    }

    public static boolean r(Activity activity, String str) {
        if (!androidx.core.os.a.c() && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        int i5 = Build.VERSION.SDK_INT;
        return i5 >= 32 ? e.a(activity, str) : i5 == 31 ? d.b(activity, str) : c.c(activity, str);
    }

    public static void s(Activity activity, Intent intent, int i5, Bundle bundle) {
        a.b(activity, intent, i5, bundle);
    }

    public static void t(Activity activity, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        a.c(activity, intentSender, i5, intent, i6, i7, i8, bundle);
    }

    public static void u(Activity activity) {
        C0021b.e(activity);
    }
}
