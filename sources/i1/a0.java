package i1;

import android.os.Parcel;
import android.os.Parcelable;
import g1.b0;
import x0.b;

public final class a0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        String str = null;
        b0 b0Var = null;
        int i5 = 0;
        boolean z4 = false;
        long j5 = Long.MAX_VALUE;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i6 = b.i(l5);
            if (i6 == 1) {
                j5 = b.o(parcel, l5);
            } else if (i6 == 2) {
                i5 = b.n(parcel, l5);
            } else if (i6 == 3) {
                z4 = b.j(parcel, l5);
            } else if (i6 == 4) {
                str = b.d(parcel, l5);
            } else if (i6 != 5) {
                b.q(parcel, l5);
            } else {
                b0Var = (b0) b.c(parcel, l5, b0.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new d(j5, i5, z4, str, b0Var);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new d[i5];
    }
}
