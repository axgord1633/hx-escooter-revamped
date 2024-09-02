package c1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f3077a;

    public c(Context context) {
        this.f3077a = context;
    }

    public ApplicationInfo a(String str, int i5) {
        return this.f3077a.getPackageManager().getApplicationInfo(str, i5);
    }

    public CharSequence b(String str) {
        return this.f3077a.getPackageManager().getApplicationLabel(this.f3077a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo c(String str, int i5) {
        return this.f3077a.getPackageManager().getPackageInfo(str, i5);
    }
}
