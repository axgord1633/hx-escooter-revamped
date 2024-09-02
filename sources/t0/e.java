package t0;

import a1.d;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import w0.k1;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6822a = g.f6825a;

    /* renamed from: b  reason: collision with root package name */
    private static final e f6823b = new e();

    e() {
    }

    public Intent a(Context context, int i5, String str) {
        if (i5 == 1 || i5 == 2) {
            if (context != null && d.c(context)) {
                return k1.a();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("gcore_");
            sb.append(f6822a);
            sb.append("-");
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            sb.append("-");
            if (context != null) {
                sb.append(context.getPackageName());
            }
            sb.append("-");
            if (context != null) {
                try {
                    sb.append(c1.d.a(context).c(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return k1.b("com.google.android.gms", sb.toString());
        } else if (i5 != 3) {
            return null;
        } else {
            return k1.c("com.google.android.gms");
        }
    }

    public PendingIntent b(Context context, int i5, int i6) {
        return c(context, i5, i6, (String) null);
    }

    public PendingIntent c(Context context, int i5, int i6, String str) {
        Intent a5 = a(context, i5, str);
        if (a5 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i6, a5, f1.d.f4600a | 134217728);
    }

    public String d(int i5) {
        return g.a(i5);
    }

    public int e(Context context) {
        return f(context, f6822a);
    }

    public int f(Context context, int i5) {
        int c5 = g.c(context, i5);
        if (g.d(context, c5)) {
            return 18;
        }
        return c5;
    }

    public boolean g(Context context, String str) {
        return g.g(context, str);
    }

    public boolean h(int i5) {
        return g.f(i5);
    }
}
