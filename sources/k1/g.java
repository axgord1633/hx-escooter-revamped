package k1;

import android.os.IBinder;
import android.os.Parcel;
import e1.a;
import e1.c;

public final class g extends a {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void z(j jVar, f fVar) {
        Parcel a5 = a();
        c.c(a5, jVar);
        c.d(a5, fVar);
        c(12, a5);
    }
}
