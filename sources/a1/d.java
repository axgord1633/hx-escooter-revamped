package a1;

import android.content.Context;
import android.content.pm.PackageManager;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f7a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f8b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f9c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f10d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f10d == null) {
            boolean z4 = false;
            if (e.f() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z4 = true;
            }
            f10d = Boolean.valueOf(z4);
        }
        return f10d.booleanValue();
    }

    public static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f7a == null) {
            boolean z4 = false;
            if (e.c() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z4 = true;
            }
            f7a = Boolean.valueOf(z4);
        }
        return f7a.booleanValue();
    }

    public static boolean c(Context context) {
        if (b(context) && !e.e()) {
            return true;
        }
        if (d(context)) {
            return !e.f() || e.i();
        }
        return false;
    }

    public static boolean d(Context context) {
        if (f8b == null) {
            boolean z4 = false;
            if (e.d() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z4 = true;
            }
            f8b = Boolean.valueOf(z4);
        }
        return f8b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f9c == null) {
            boolean z4 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z4 = false;
            }
            f9c = Boolean.valueOf(z4);
        }
        return f9c.booleanValue();
    }
}
