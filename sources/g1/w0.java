package g1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import t0.c;
import x0.b;

public final class w0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        List r6 = s0.r();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        b0 b0Var = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    i5 = b.n(parcel, l5);
                    break;
                case 2:
                    i6 = b.n(parcel, l5);
                    break;
                case 3:
                    str = b.d(parcel, l5);
                    break;
                case 4:
                    str2 = b.d(parcel, l5);
                    break;
                case 5:
                    i7 = b.n(parcel, l5);
                    break;
                case 6:
                    str3 = b.d(parcel, l5);
                    break;
                case 7:
                    b0Var = (b0) b.c(parcel, l5, b0.CREATOR);
                    break;
                case 8:
                    r6 = b.g(parcel, l5, c.CREATOR);
                    break;
                default:
                    b.q(parcel, l5);
                    break;
            }
        }
        b.h(parcel, r5);
        return new b0(i5, i6, str, str2, str3, i7, r6, b0Var);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new b0[i5];
    }
}
