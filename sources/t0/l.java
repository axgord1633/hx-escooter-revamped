package t0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class l implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        PendingIntent pendingIntent = null;
        int i5 = 0;
        int i6 = 0;
        String str = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i7 = b.i(l5);
            if (i7 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i7 == 2) {
                i6 = b.n(parcel, l5);
            } else if (i7 == 3) {
                pendingIntent = (PendingIntent) b.c(parcel, l5, PendingIntent.CREATOR);
            } else if (i7 != 4) {
                b.q(parcel, l5);
            } else {
                str = b.d(parcel, l5);
            }
        }
        b.h(parcel, r5);
        return new a(i5, i6, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new a[i5];
    }
}
