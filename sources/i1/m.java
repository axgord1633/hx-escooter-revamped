package i1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import x0.b;

public final class m implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        Status status = null;
        j jVar = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i5 = b.i(l5);
            if (i5 == 1) {
                status = (Status) b.c(parcel, l5, Status.CREATOR);
            } else if (i5 != 2) {
                b.q(parcel, l5);
            } else {
                jVar = (j) b.c(parcel, l5, j.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new i(status, jVar);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new i[i5];
    }
}
