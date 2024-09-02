package w0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.a;
import x0.c;

public class d extends a {
    public static final Parcelable.Creator<d> CREATOR = new w();

    /* renamed from: e  reason: collision with root package name */
    public final int f7322e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7323f;

    public d(int i5, String str) {
        this.f7322e = i5;
        this.f7323f = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f7322e == this.f7322e && o.a(dVar.f7323f, this.f7323f);
    }

    public final int hashCode() {
        return this.f7322e;
    }

    public final String toString() {
        int i5 = this.f7322e;
        String str = this.f7323f;
        return i5 + ":" + str;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f7322e);
        c.k(parcel, 2, this.f7323f, false);
        c.b(parcel, a5);
    }
}
