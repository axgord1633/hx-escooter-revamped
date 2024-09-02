package w0;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import v0.f;

public abstract class e0 implements DialogInterface.OnClickListener {
    public static e0 b(Activity activity, Intent intent, int i5) {
        return new c0(intent, activity, i5);
    }

    public static e0 c(f fVar, Intent intent, int i5) {
        return new d0(intent, fVar, 2);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void onClick(DialogInterface dialogInterface, int i5) {
        try {
            a();
        } catch (ActivityNotFoundException e5) {
            String str = "Failed to start resolution intent.";
            if (true == Build.FINGERPRINT.contains("generic")) {
                str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
            }
            Log.e("DialogRedirect", str, e5);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
