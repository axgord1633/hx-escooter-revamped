package w0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import t0.c;
import x0.b;

public final class a1 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        Bundle bundle = null;
        f fVar = null;
        int i5 = 0;
        c[] cVarArr = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i6 = b.i(l5);
            if (i6 == 1) {
                bundle = b.a(parcel, l5);
            } else if (i6 == 2) {
                cVarArr = (c[]) b.f(parcel, l5, c.CREATOR);
            } else if (i6 == 3) {
                i5 = b.n(parcel, l5);
            } else if (i6 != 4) {
                b.q(parcel, l5);
            } else {
                fVar = (f) b.c(parcel, l5, f.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new z0(bundle, cVarArr, i5, fVar);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new z0[i5];
    }
}
