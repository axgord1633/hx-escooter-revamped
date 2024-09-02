package g1;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationRequest;
import i1.g;
import v0.d;

public final class c1 extends a implements d1 {
    c1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final Location b() {
        Parcel c5 = c(7, a());
        Location location = (Location) n.a(c5, Location.CREATOR);
        c5.recycle();
        return location;
    }

    public final void f(g gVar, h1 h1Var, String str) {
        Parcel a5 = a();
        n.c(a5, gVar);
        n.d(a5, h1Var);
        a5.writeString((String) null);
        e(63, a5);
    }

    public final void j(d0 d0Var, d dVar) {
        Parcel a5 = a();
        n.c(a5, d0Var);
        n.d(a5, dVar);
        e(89, a5);
    }

    public final void l(d0 d0Var, LocationRequest locationRequest, d dVar) {
        Parcel a5 = a();
        n.c(a5, d0Var);
        n.c(a5, locationRequest);
        n.d(a5, dVar);
        e(88, a5);
    }

    public final void r(h0 h0Var) {
        Parcel a5 = a();
        n.c(a5, h0Var);
        e(59, a5);
    }

    public final void w(i1.d dVar, f1 f1Var) {
        Parcel a5 = a();
        n.c(a5, dVar);
        n.d(a5, f1Var);
        e(82, a5);
    }
}
