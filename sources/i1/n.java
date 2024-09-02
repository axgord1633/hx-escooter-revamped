package i1;

import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class n implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    z4 = b.j(parcel, l5);
                    break;
                case 2:
                    z5 = b.j(parcel, l5);
                    break;
                case 3:
                    z6 = b.j(parcel, l5);
                    break;
                case 4:
                    z7 = b.j(parcel, l5);
                    break;
                case 5:
                    z8 = b.j(parcel, l5);
                    break;
                case 6:
                    z9 = b.j(parcel, l5);
                    break;
                default:
                    b.q(parcel, l5);
                    break;
            }
        }
        b.h(parcel, r5);
        return new j(z4, z5, z6, z7, z8, z9);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new j[i5];
    }
}
