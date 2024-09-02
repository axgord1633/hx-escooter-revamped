package i1;

import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class p implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        long j5 = -1;
        long j6 = -1;
        int i5 = 1;
        int i6 = 1;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i7 = b.i(l5);
            if (i7 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i7 == 2) {
                i6 = b.n(parcel, l5);
            } else if (i7 == 3) {
                j5 = b.o(parcel, l5);
            } else if (i7 != 4) {
                b.q(parcel, l5);
            } else {
                j6 = b.o(parcel, l5);
            }
        }
        b.h(parcel, r5);
        return new o(i5, i6, j5, j6);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new o[i5];
    }
}
