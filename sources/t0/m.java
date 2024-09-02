package t0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class m implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        String str = null;
        int i5 = 0;
        long j5 = -1;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i6 = b.i(l5);
            if (i6 == 1) {
                str = b.d(parcel, l5);
            } else if (i6 == 2) {
                i5 = b.n(parcel, l5);
            } else if (i6 != 3) {
                b.q(parcel, l5);
            } else {
                j5 = b.o(parcel, l5);
            }
        }
        b.h(parcel, r5);
        return new c(str, i5, j5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new c[i5];
    }
}
