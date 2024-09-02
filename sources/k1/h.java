package k1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;
import u0.k;
import x0.a;
import x0.c;

public final class h extends a implements k {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* renamed from: e  reason: collision with root package name */
    private final List f5513e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5514f;

    public h(List list, String str) {
        this.f5513e = list;
        this.f5514f = str;
    }

    public final Status getStatus() {
        return this.f5514f != null ? Status.f3274k : Status.f3278o;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.l(parcel, 1, this.f5513e, false);
        c.k(parcel, 2, this.f5514f, false);
        c.b(parcel, a5);
    }
}
