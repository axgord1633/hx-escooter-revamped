package w0;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import t0.a;
import x0.b;

public final class m0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i6 = b.i(l5);
            if (i6 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i6 == 2) {
                iBinder = b.m(parcel, l5);
            } else if (i6 == 3) {
                aVar = (a) b.c(parcel, l5, a.CREATOR);
            } else if (i6 == 4) {
                z4 = b.j(parcel, l5);
            } else if (i6 != 5) {
                b.q(parcel, l5);
            } else {
                z5 = b.j(parcel, l5);
            }
        }
        b.h(parcel, r5);
        return new l0(i5, iBinder, aVar, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new l0[i5];
    }
}
