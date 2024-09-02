package k1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import x0.b;

public final class i implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i5 = b.i(l5);
            if (i5 == 1) {
                arrayList = b.e(parcel, l5);
            } else if (i5 != 2) {
                b.q(parcel, l5);
            } else {
                str = b.d(parcel, l5);
            }
        }
        b.h(parcel, r5);
        return new h(arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new h[i5];
    }
}
