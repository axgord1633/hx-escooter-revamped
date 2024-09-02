package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.j0;
import androidx.core.os.g;
import java.io.File;
import java.util.concurrent.Executor;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1635a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f1636b = new Object();

    /* renamed from: androidx.core.content.a$a  reason: collision with other inner class name */
    static class C0022a {
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    static class b {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    static class c {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i5) {
            return context.getDrawable(i5);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class d {
        static int a(Context context, int i5) {
            return context.getColor(i5);
        }

        static <T> T b(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    static class e {
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static int a(Context context, String str) {
        androidx.core.util.c.d(str, "permission must be non-null");
        return (androidx.core.os.a.c() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : j0.c(context).a() ? 0 : -1;
    }

    public static int b(Context context, int i5) {
        return d.a(context, i5);
    }

    public static Drawable c(Context context, int i5) {
        return c.b(context, i5);
    }

    public static File[] d(Context context) {
        return b.a(context);
    }

    public static File[] e(Context context, String str) {
        return b.b(context, str);
    }

    public static Executor f(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? e.a(context) : g.a(new Handler(context.getMainLooper()));
    }

    public static boolean g(Context context, Intent[] intentArr, Bundle bundle) {
        C0022a.a(context, intentArr, bundle);
        return true;
    }

    public static void h(Context context, Intent intent, Bundle bundle) {
        C0022a.b(context, intent, bundle);
    }
}
