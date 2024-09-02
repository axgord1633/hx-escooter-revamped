package g1;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class e1 extends e implements f1 {
    public e1() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 1) {
            return false;
        }
        n.b(parcel);
        h((Status) n.a(parcel, Status.CREATOR), (Location) n.a(parcel, Location.CREATOR));
        return true;
    }
}
