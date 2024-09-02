package o0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class d {
    private static PackageInfo a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        return Build.VERSION.SDK_INT < 33 ? packageManager.getPackageInfo(packageName, 4096) : packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096));
    }

    public static boolean b(Context context, String str) {
        try {
            String[] strArr = a(context).requestedPermissions;
            if (strArr != null) {
                for (String equals : strArr) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }
}
