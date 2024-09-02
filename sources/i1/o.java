package i1;

import android.os.Parcel;
import android.os.Parcelable;
import x0.a;
import x0.c;

@Deprecated
public final class o extends a {
    public static final Parcelable.Creator<o> CREATOR = new p();

    /* renamed from: e  reason: collision with root package name */
    public final int f4934e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4935f;

    /* renamed from: g  reason: collision with root package name */
    public final long f4936g;

    /* renamed from: h  reason: collision with root package name */
    public final long f4937h;

    o(int i5, int i6, long j5, long j6) {
        this.f4934e = i5;
        this.f4935f = i6;
        this.f4936g = j5;
        this.f4937h = j6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            return this.f4934e == oVar.f4934e && this.f4935f == oVar.f4935f && this.f4936g == oVar.f4936g && this.f4937h == oVar.f4937h;
        }
    }

    public final int hashCode() {
        return w0.o.b(Integer.valueOf(this.f4935f), Integer.valueOf(this.f4934e), Long.valueOf(this.f4937h), Long.valueOf(this.f4936g));
    }

    public final String toString() {
        int i5 = this.f4934e;
        int i6 = this.f4935f;
        long j5 = this.f4937h;
        long j6 = this.f4936g;
        return "NetworkLocationStatus: Wifi status: " + i5 + " Cell status: " + i6 + " elapsed time NS: " + j5 + " system time ms: " + j6;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f4934e);
        c.g(parcel, 2, this.f4935f);
        c.i(parcel, 3, this.f4936g);
        c.i(parcel, 4, this.f4937h);
        c.b(parcel, a5);
    }
}
