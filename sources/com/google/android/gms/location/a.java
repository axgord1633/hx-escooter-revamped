package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import i1.o;
import x0.b;

public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int r5 = b.r(parcel);
        int i5 = 1;
        int i6 = 1;
        int i7 = 1000;
        long j5 = 0;
        o[] oVarArr = null;
        boolean z4 = false;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    i5 = b.n(parcel2, l5);
                    break;
                case 2:
                    i6 = b.n(parcel2, l5);
                    break;
                case 3:
                    j5 = b.o(parcel2, l5);
                    break;
                case 4:
                    i7 = b.n(parcel2, l5);
                    break;
                case 5:
                    oVarArr = (o[]) b.f(parcel2, l5, o.CREATOR);
                    break;
                case 6:
                    z4 = b.j(parcel2, l5);
                    break;
                default:
                    b.q(parcel2, l5);
                    break;
            }
        }
        b.h(parcel2, r5);
        return new LocationAvailability(i7, i5, i6, j5, oVarArr, z4);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new LocationAvailability[i5];
    }
}
