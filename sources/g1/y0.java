package g1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import x0.b;

public final class y0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        Status status = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            if (b.i(l5) != 1) {
                b.q(parcel, l5);
            } else {
                status = (Status) b.c(parcel, l5, Status.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new x0(status);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new x0[i5];
    }
}
