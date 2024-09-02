package k1;

import android.os.Parcel;
import android.os.Parcelable;
import t0.a;
import w0.l0;
import x0.b;

public final class m implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        a aVar = null;
        int i5 = 0;
        l0 l0Var = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i6 = b.i(l5);
            if (i6 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i6 == 2) {
                aVar = (a) b.c(parcel, l5, a.CREATOR);
            } else if (i6 != 3) {
                b.q(parcel, l5);
            } else {
                l0Var = (l0) b.c(parcel, l5, l0.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new l(i5, aVar, l0Var);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new l[i5];
    }
}
