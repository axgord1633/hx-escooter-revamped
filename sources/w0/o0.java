package w0;

import android.os.Bundle;
import android.os.Parcel;
import f1.b;
import f1.c;

public abstract class o0 extends b implements l {
    public o0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            c.b(parcel);
            x(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
        } else if (i5 == 2) {
            c.b(parcel);
            n(parcel.readInt(), (Bundle) c.a(parcel, Bundle.CREATOR));
        } else if (i5 != 3) {
            return false;
        } else {
            c.b(parcel);
            q(parcel.readInt(), parcel.readStrongBinder(), (z0) c.a(parcel, z0.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
