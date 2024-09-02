package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Arrays;

final class ImagePickerUtils {
    ImagePickerUtils() {
    }

    private static boolean isPermissionPresentInManifest(Context context, String str) {
        try {
            return Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return false;
        }
    }

    static boolean needRequestCameraPermission(Context context) {
        return isPermissionPresentInManifest(context, "android.permission.CAMERA");
    }
}
