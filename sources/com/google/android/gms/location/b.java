package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import g1.b0;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int r5 = x0.b.r(parcel);
        WorkSource workSource = new WorkSource();
        String str = null;
        b0 b0Var = null;
        long j5 = Long.MAX_VALUE;
        long j6 = Long.MAX_VALUE;
        boolean z4 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z5 = false;
        int i7 = 102;
        long j7 = 3600000;
        long j8 = 600000;
        long j9 = 0;
        int i8 = Integer.MAX_VALUE;
        float f5 = 0.0f;
        long j10 = -1;
        while (parcel.dataPosition() < r5) {
            int l5 = x0.b.l(parcel);
            switch (x0.b.i(l5)) {
                case 1:
                    i7 = x0.b.n(parcel2, l5);
                    break;
                case 2:
                    j7 = x0.b.o(parcel2, l5);
                    break;
                case 3:
                    j8 = x0.b.o(parcel2, l5);
                    break;
                case 5:
                    j5 = x0.b.o(parcel2, l5);
                    break;
                case 6:
                    i8 = x0.b.n(parcel2, l5);
                    break;
                case 7:
                    f5 = x0.b.k(parcel2, l5);
                    break;
                case 8:
                    j9 = x0.b.o(parcel2, l5);
                    break;
                case 9:
                    z4 = x0.b.j(parcel2, l5);
                    break;
                case 10:
                    j6 = x0.b.o(parcel2, l5);
                    break;
                case 11:
                    j10 = x0.b.o(parcel2, l5);
                    break;
                case 12:
                    i5 = x0.b.n(parcel2, l5);
                    break;
                case 13:
                    i6 = x0.b.n(parcel2, l5);
                    break;
                case 14:
                    str = x0.b.d(parcel2, l5);
                    break;
                case 15:
                    z5 = x0.b.j(parcel2, l5);
                    break;
                case 16:
                    workSource = (WorkSource) x0.b.c(parcel2, l5, WorkSource.CREATOR);
                    break;
                case 17:
                    b0Var = (b0) x0.b.c(parcel2, l5, b0.CREATOR);
                    break;
                default:
                    x0.b.q(parcel2, l5);
                    break;
            }
        }
        x0.b.h(parcel2, r5);
        return new LocationRequest(i7, j7, j8, j9, j5, j6, i8, f5, z4, j10, i5, i6, str, z5, workSource, b0Var);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new LocationRequest[i5];
    }
}
