package k1;

import android.os.Parcel;
import android.os.Parcelable;
import w0.j0;
import x0.a;
import x0.c;

public final class j extends a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* renamed from: e  reason: collision with root package name */
    final int f5515e;

    /* renamed from: f  reason: collision with root package name */
    final j0 f5516f;

    j(int i5, j0 j0Var) {
        this.f5515e = i5;
        this.f5516f = j0Var;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f5515e);
        c.j(parcel, 2, this.f5516f, i5, false);
        c.b(parcel, a5);
    }
}
