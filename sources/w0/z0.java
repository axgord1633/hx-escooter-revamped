package w0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import t0.c;
import x0.a;

public final class z0 extends a {
    public static final Parcelable.Creator<z0> CREATOR = new a1();

    /* renamed from: e  reason: collision with root package name */
    Bundle f7451e;

    /* renamed from: f  reason: collision with root package name */
    c[] f7452f;

    /* renamed from: g  reason: collision with root package name */
    int f7453g;

    /* renamed from: h  reason: collision with root package name */
    f f7454h;

    public z0() {
    }

    z0(Bundle bundle, c[] cVarArr, int i5, f fVar) {
        this.f7451e = bundle;
        this.f7452f = cVarArr;
        this.f7453g = i5;
        this.f7454h = fVar;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = x0.c.a(parcel);
        x0.c.d(parcel, 1, this.f7451e, false);
        x0.c.m(parcel, 2, this.f7452f, i5, false);
        x0.c.g(parcel, 3, this.f7453g);
        x0.c.j(parcel, 4, this.f7454h, i5, false);
        x0.c.b(parcel, a5);
    }
}
