package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.core.app.f;
import androidx.core.util.c;

public final class d {
    public static int a(Context context, String str, int i5, int i6, String str2) {
        if (context.checkPermission(str, i5, i6) == -1) {
            return -1;
        }
        String c5 = f.c(str);
        if (c5 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i6);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return (Process.myUid() == i6 && c.a(context.getPackageName(), str2) ? f.a(context, i6, c5, str2) : f.b(context, c5, str2)) == 0 ? 0 : -2;
    }

    public static int b(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
