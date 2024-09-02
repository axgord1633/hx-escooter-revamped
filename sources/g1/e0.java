package g1;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class e0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        int i5 = 0;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    i5 = b.n(parcel, l5);
                    break;
                case 2:
                    iBinder = b.m(parcel, l5);
                    break;
                case 3:
                    iBinder2 = b.m(parcel, l5);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) b.c(parcel, l5, PendingIntent.CREATOR);
                    break;
                case 5:
                    str = b.d(parcel, l5);
                    break;
                case 6:
                    str2 = b.d(parcel, l5);
                    break;
                default:
                    b.q(parcel, l5);
                    break;
            }
        }
        b.h(parcel, r5);
        return new d0(i5, iBinder, iBinder2, pendingIntent, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new d0[i5];
    }
}
