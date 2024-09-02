package i1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import g1.e;
import g1.n;

public abstract class v extends e implements w {
    public v() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static w c(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof w ? (w) queryLocalInterface : new u(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            n.b(parcel);
            y((LocationResult) n.a(parcel, LocationResult.CREATOR));
        } else if (i5 == 2) {
            n.b(parcel);
            i((LocationAvailability) n.a(parcel, LocationAvailability.CREATOR));
        } else if (i5 != 3) {
            return false;
        } else {
            p();
        }
        return true;
    }
}
