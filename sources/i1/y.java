package i1;

import android.os.IBinder;
import android.os.IInterface;
import g1.e;

public abstract class y extends e implements z {
    public static z c(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof z ? (z) queryLocalInterface : new x(iBinder);
    }
}
