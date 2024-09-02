package g1;

import android.os.Parcel;

public abstract class a1 extends e implements b1 {
    public a1() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            n.b(parcel);
            o((x0) n.a(parcel, x0.CREATOR));
        } else if (i5 != 2) {
            return false;
        } else {
            k();
        }
        return true;
    }
}
