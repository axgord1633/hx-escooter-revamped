package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import x0.b;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        List list = LocationResult.f3461f;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            if (b.i(l5) != 1) {
                b.q(parcel, l5);
            } else {
                list = b.g(parcel, l5, Location.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new LocationResult(list);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new LocationResult[i5];
    }
}
