package w0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.b;

public final class i0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int r5 = b.r(parcel);
        String str = null;
        String str2 = null;
        long j5 = 0;
        long j6 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
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
                    i7 = b.n(parcel2, l5);
                    break;
                case 4:
                    j5 = b.o(parcel2, l5);
                    break;
                case 5:
                    j6 = b.o(parcel2, l5);
                    break;
                case 6:
                    str = b.d(parcel2, l5);
                    break;
                case 7:
                    str2 = b.d(parcel2, l5);
                    break;
                case 8:
                    i8 = b.n(parcel2, l5);
                    break;
                case 9:
                    i9 = b.n(parcel2, l5);
                    break;
                default:
                    b.q(parcel2, l5);
                    break;
            }
        }
        b.h(parcel2, r5);
        return new n(i5, i6, i7, j5, j6, str, str2, i8, i9);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new n[i5];
    }
}
