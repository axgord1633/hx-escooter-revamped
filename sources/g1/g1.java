package g1;

import android.os.Parcel;
import i1.i;

public abstract class g1 extends e implements h1 {
    public g1() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 1) {
            return false;
        }
        n.b(parcel);
        u((i) n.a(parcel, i.CREATOR));
        return true;
    }
}
