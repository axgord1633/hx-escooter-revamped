package g1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import u0.k;
import x0.a;
import x0.c;

public final class x0 extends a implements k {
    public static final Parcelable.Creator<x0> CREATOR = new y0();

    /* renamed from: f  reason: collision with root package name */
    public static final x0 f4728f = new x0(Status.f3274k);

    /* renamed from: e  reason: collision with root package name */
    private final Status f4729e;

    public x0(Status status) {
        this.f4729e = status;
    }

    public final Status getStatus() {
        return this.f4729e;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.j(parcel, 1, this.f4729e, i5, false);
        c.b(parcel, a5);
    }
}
