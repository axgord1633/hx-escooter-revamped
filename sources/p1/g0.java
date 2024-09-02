package p1;

import android.content.Context;
import m2.k;
import r1.q;
import z1.d;
import z1.f;
import z1.g;

public abstract class g0 {

    public enum a {
        BLUETOOTH_NOT_AVAILABLE,
        LOCATION_PERMISSION_NOT_GRANTED,
        BLUETOOTH_NOT_ENABLED,
        LOCATION_SERVICES_NOT_ENABLED,
        READY
    }

    public static g0 a(Context context) {
        return a0.a().a(context.getApplicationContext()).build().a();
    }

    public static void f(c0 c0Var) {
        q.o(c0Var);
    }

    public abstract p0 b(String str);

    public abstract a c();

    public abstract k<a> d();

    public abstract k<f> e(g gVar, d... dVarArr);
}
