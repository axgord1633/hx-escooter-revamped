package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import kotlin.jvm.internal.k;

final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f1781a = new b();

    private b() {
    }

    public static final void a(Bundle bundle, String str, IBinder iBinder) {
        k.e(bundle, "bundle");
        k.e(str, "key");
        bundle.putBinder(str, iBinder);
    }
}
