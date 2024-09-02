package g1;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class i0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        f0 f0Var = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        String str = null;
        int i5 = 1;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    i5 = b.n(parcel, l5);
                    break;
                case 2:
                    f0Var = (f0) b.c(parcel, l5, f0.CREATOR);
                    break;
                case 3:
                    iBinder = b.m(parcel, l5);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) b.c(parcel, l5, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = b.m(parcel, l5);
                    break;
                case 6:
                    iBinder3 = b.m(parcel, l5);
                    break;
                case 8:
                    str = b.d(parcel, l5);
                    break;
                default:
                    b.q(parcel, l5);
                    break;
            }
        }
        b.h(parcel, r5);
        return new h0(i5, f0Var, iBinder, iBinder2, pendingIntent, iBinder3, str);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new h0[i5];
    }
}
