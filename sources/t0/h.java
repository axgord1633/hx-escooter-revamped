package t0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import javax.annotation.Nullable;
import w0.p;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@CheckReturnValue
public class h {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static h f6828b;

    /* renamed from: a  reason: collision with root package name */
    private final Context f6829a;

    public h(Context context) {
        this.f6829a = context.getApplicationContext();
    }

    public static h a(Context context) {
        p.g(context);
        synchronized (h.class) {
            if (f6828b == null) {
                v.a(context);
                f6828b = new h(context);
            }
        }
        return f6828b;
    }

    @Nullable
    static final r b(PackageInfo packageInfo, r... rVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        s sVar = new s(packageInfo.signatures[0].toByteArray());
        for (int i5 = 0; i5 < rVarArr.length; i5++) {
            if (rVarArr[i5].equals(sVar)) {
                return rVarArr[i5];
            }
        }
        return null;
    }

    public static final boolean c(PackageInfo packageInfo, boolean z4) {
        if (z4 && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z4 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if ((z4 ? b(packageInfo, u.f6839a) : b(packageInfo, u.f6839a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
