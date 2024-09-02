package k1;

import android.os.Parcel;
import android.os.Parcelable;
import w0.j0;
import x0.b;

public final class k implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        int i5 = 0;
        j0 j0Var = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i6 = b.i(l5);
            if (i6 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i6 != 2) {
                b.q(parcel, l5);
            } else {
                j0Var = (j0) b.c(parcel, l5, j0.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new j(i5, j0Var);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new j[i5];
    }
}
