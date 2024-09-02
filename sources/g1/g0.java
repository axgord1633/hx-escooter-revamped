package g1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import w0.d;
import x0.b;

public final class g0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int r5 = b.r(parcel);
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        LocationRequest locationRequest = null;
        ArrayList<d> arrayList = null;
        String str = null;
        String str2 = null;
        long j5 = Long.MAX_VALUE;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i5 = b.i(l5);
            if (i5 == 1) {
                locationRequest = (LocationRequest) b.c(parcel2, l5, LocationRequest.CREATOR);
            } else if (i5 != 5) {
                switch (i5) {
                    case 8:
                        z4 = b.j(parcel2, l5);
                        break;
                    case 9:
                        z5 = b.j(parcel2, l5);
                        break;
                    case 10:
                        str = b.d(parcel2, l5);
                        break;
                    case 11:
                        z6 = b.j(parcel2, l5);
                        break;
                    case 12:
                        z7 = b.j(parcel2, l5);
                        break;
                    case 13:
                        str2 = b.d(parcel2, l5);
                        break;
                    case 14:
                        j5 = b.o(parcel2, l5);
                        break;
                    default:
                        b.q(parcel2, l5);
                        break;
                }
            } else {
                arrayList = b.g(parcel2, l5, d.CREATOR);
            }
        }
        b.h(parcel2, r5);
        return new f0(locationRequest, arrayList, z4, z5, str, z6, z7, str2, j5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new f0[i5];
    }
}
