package w0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public final class d1 {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f7326f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    private final String f7327a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7328b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f7329c = null;

    /* renamed from: d  reason: collision with root package name */
    private final int f7330d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7331e;

    public d1(String str, String str2, int i5, boolean z4) {
        p.e(str);
        this.f7327a = str;
        p.e(str2);
        this.f7328b = str2;
        this.f7330d = i5;
        this.f7331e = z4;
    }

    public final int a() {
        return this.f7330d;
    }

    public final ComponentName b() {
        return this.f7329c;
    }

    public final Intent c(Context context) {
        Bundle bundle;
        if (this.f7327a == null) {
            return new Intent().setComponent(this.f7329c);
        }
        Intent intent = null;
        if (this.f7331e) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f7327a);
            try {
                bundle = context.getContentResolver().call(f7326f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e5) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e5.toString()));
                bundle = null;
            }
            if (bundle != null) {
                intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
            }
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f7327a)));
            }
        }
        return intent != null ? intent : new Intent(this.f7327a).setPackage(this.f7328b);
    }

    public final String d() {
        return this.f7328b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return o.a(this.f7327a, d1Var.f7327a) && o.a(this.f7328b, d1Var.f7328b) && o.a(this.f7329c, d1Var.f7329c) && this.f7330d == d1Var.f7330d && this.f7331e == d1Var.f7331e;
    }

    public final int hashCode() {
        return o.b(this.f7327a, this.f7328b, this.f7329c, Integer.valueOf(this.f7330d), Boolean.valueOf(this.f7331e));
    }

    public final String toString() {
        String str = this.f7327a;
        if (str != null) {
            return str;
        }
        p.g(this.f7329c);
        return this.f7329c.flattenToString();
    }
}
