package w0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import c1.d;

public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f7426a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f7427b;

    /* renamed from: c  reason: collision with root package name */
    private static String f7428c;

    /* renamed from: d  reason: collision with root package name */
    private static int f7429d;

    public static int a(Context context) {
        b(context);
        return f7429d;
    }

    private static void b(Context context) {
        synchronized (f7426a) {
            if (!f7427b) {
                f7427b = true;
                try {
                    Bundle bundle = d.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f7428c = bundle.getString("com.google.app.id");
                        f7429d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e5) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e5);
                }
            }
        }
    }
}
