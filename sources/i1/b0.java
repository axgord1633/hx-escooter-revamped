package i1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import x0.b;

public final class b0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        boolean z4 = false;
        ArrayList<LocationRequest> arrayList = null;
        boolean z5 = false;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i5 = b.i(l5);
            if (i5 == 1) {
                arrayList = b.g(parcel, l5, LocationRequest.CREATOR);
            } else if (i5 == 2) {
                z4 = b.j(parcel, l5);
            } else if (i5 != 3) {
                b.q(parcel, l5);
            } else {
                z5 = b.j(parcel, l5);
            }
        }
        b.h(parcel, r5);
        return new g(arrayList, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new g[i5];
    }
}
