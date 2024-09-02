package w0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class b1 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        boolean z4 = false;
        boolean z5 = false;
        int i5 = 0;
        r rVar = null;
        int[] iArr = null;
        int[] iArr2 = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    rVar = (r) b.c(parcel, l5, r.CREATOR);
                    break;
                case 2:
                    z4 = b.j(parcel, l5);
                    break;
                case 3:
                    z5 = b.j(parcel, l5);
                    break;
                case 4:
                    iArr = b.b(parcel, l5);
                    break;
                case 5:
                    i5 = b.n(parcel, l5);
                    break;
                case 6:
                    iArr2 = b.b(parcel, l5);
                    break;
                default:
                    b.q(parcel, l5);
                    break;
            }
        }
        b.h(parcel, r5);
        return new f(rVar, z4, z5, iArr, i5, iArr2);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new f[i5];
    }
}
