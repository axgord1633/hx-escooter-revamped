package w0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import x0.b;

public final class x implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        int i5 = 0;
        ArrayList<n> arrayList = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i6 = b.i(l5);
            if (i6 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i6 != 2) {
                b.q(parcel, l5);
            } else {
                arrayList = b.g(parcel, l5, n.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new s(i5, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new s[i5];
    }
}
