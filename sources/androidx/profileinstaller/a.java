package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class a {

    /* renamed from: androidx.profileinstaller.a$a  reason: collision with other inner class name */
    private static class C0046a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class b {
        static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            int length = listFiles.length;
            boolean z4 = true;
            for (int i5 = 0; i5 < length; i5++) {
                z4 = a(listFiles[i5]) && z4;
            }
            return z4;
        }
        file.delete();
        return true;
    }

    static void b(Context context, ProfileInstallReceiver.a aVar) {
        aVar.b(a(Build.VERSION.SDK_INT >= 24 ? b.a(context) : C0046a.a(context)) ? 14 : 15, (Object) null);
    }
}
