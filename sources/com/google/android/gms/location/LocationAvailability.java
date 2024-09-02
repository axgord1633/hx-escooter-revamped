package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import i1.o;
import java.util.Arrays;
import x0.a;
import x0.c;

public final class LocationAvailability extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new a();

    /* renamed from: j  reason: collision with root package name */
    public static final LocationAvailability f3424j = new LocationAvailability(0, 1, 1, 0, (o[]) null, true);

    /* renamed from: k  reason: collision with root package name */
    public static final LocationAvailability f3425k = new LocationAvailability(1000, 1, 1, 0, (o[]) null, false);

    /* renamed from: e  reason: collision with root package name */
    private final int f3426e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3427f;

    /* renamed from: g  reason: collision with root package name */
    private final long f3428g;

    /* renamed from: h  reason: collision with root package name */
    int f3429h;

    /* renamed from: i  reason: collision with root package name */
    private final o[] f3430i;

    LocationAvailability(int i5, int i6, int i7, long j5, o[] oVarArr, boolean z4) {
        this.f3429h = i5 < 1000 ? 0 : 1000;
        this.f3426e = i6;
        this.f3427f = i7;
        this.f3428g = j5;
        this.f3430i = oVarArr;
    }

    public boolean a() {
        return this.f3429h < 1000;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            return this.f3426e == locationAvailability.f3426e && this.f3427f == locationAvailability.f3427f && this.f3428g == locationAvailability.f3428g && this.f3429h == locationAvailability.f3429h && Arrays.equals(this.f3430i, locationAvailability.f3430i);
        }
    }

    public int hashCode() {
        return w0.o.b(Integer.valueOf(this.f3429h));
    }

    public String toString() {
        boolean a5 = a();
        return "LocationAvailability[" + a5 + "]";
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f3426e);
        c.g(parcel, 2, this.f3427f);
        c.i(parcel, 3, this.f3428g);
        c.g(parcel, 4, this.f3429h);
        c.m(parcel, 5, this.f3430i, i5, false);
        c.c(parcel, 6, a());
        c.b(parcel, a5);
    }
}
