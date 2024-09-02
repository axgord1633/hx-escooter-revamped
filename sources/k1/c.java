package k1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        int i5 = 0;
        Intent intent = null;
        int i6 = 0;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i7 = b.i(l5);
            if (i7 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i7 == 2) {
                i6 = b.n(parcel, l5);
            } else if (i7 != 3) {
                b.q(parcel, l5);
            } else {
                intent = (Intent) b.c(parcel, l5, Intent.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new b(i5, i6, intent);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new b[i5];
    }
}
