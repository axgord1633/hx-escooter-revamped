package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import t0.a;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = x0.b.r(parcel);
        int i5 = 0;
        int i6 = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        while (parcel.dataPosition() < r5) {
            int l5 = x0.b.l(parcel);
            int i7 = x0.b.i(l5);
            if (i7 == 1) {
                i6 = x0.b.n(parcel, l5);
            } else if (i7 == 2) {
                str = x0.b.d(parcel, l5);
            } else if (i7 == 3) {
                pendingIntent = (PendingIntent) x0.b.c(parcel, l5, PendingIntent.CREATOR);
            } else if (i7 == 4) {
                aVar = (a) x0.b.c(parcel, l5, a.CREATOR);
            } else if (i7 != 1000) {
                x0.b.q(parcel, l5);
            } else {
                i5 = x0.b.n(parcel, l5);
            }
        }
        x0.b.h(parcel, r5);
        return new Status(i5, i6, str, pendingIntent, aVar);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new Status[i5];
    }
}
