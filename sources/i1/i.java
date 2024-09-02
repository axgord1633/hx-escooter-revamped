package i1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import u0.k;
import x0.a;
import x0.c;

public final class i extends a implements k {
    public static final Parcelable.Creator<i> CREATOR = new m();

    /* renamed from: e  reason: collision with root package name */
    private final Status f4926e;

    /* renamed from: f  reason: collision with root package name */
    private final j f4927f;

    public i(Status status, j jVar) {
        this.f4926e = status;
        this.f4927f = jVar;
    }

    public j a() {
        return this.f4927f;
    }

    public Status getStatus() {
        return this.f4926e;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.j(parcel, 1, getStatus(), i5, false);
        c.j(parcel, 2, a(), i5, false);
        c.b(parcel, a5);
    }
}
