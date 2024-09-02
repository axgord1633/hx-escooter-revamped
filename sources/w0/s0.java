package w0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class s0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        int i5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i8 = b.i(l5);
            if (i8 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i8 == 2) {
                z4 = b.j(parcel, l5);
            } else if (i8 == 3) {
                z5 = b.j(parcel, l5);
            } else if (i8 == 4) {
                i6 = b.n(parcel, l5);
            } else if (i8 != 5) {
                b.q(parcel, l5);
            } else {
                i7 = b.n(parcel, l5);
            }
        }
        b.h(parcel, r5);
        return new r(i5, z4, z5, i6, i7);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new r[i5];
    }
}
