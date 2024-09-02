package t0;

import android.os.Parcel;
import android.os.Parcelable;
import w0.o;
import x0.a;

public class c extends a {
    public static final Parcelable.Creator<c> CREATOR = new m();

    /* renamed from: e  reason: collision with root package name */
    private final String f6815e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    private final int f6816f;

    /* renamed from: g  reason: collision with root package name */
    private final long f6817g;

    public c(String str, int i5, long j5) {
        this.f6815e = str;
        this.f6816f = i5;
        this.f6817g = j5;
    }

    public c(String str, long j5) {
        this.f6815e = str;
        this.f6817g = j5;
        this.f6816f = -1;
    }

    public String a() {
        return this.f6815e;
    }

    public long b() {
        long j5 = this.f6817g;
        return j5 == -1 ? (long) this.f6816f : j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return ((a() != null && a().equals(cVar.a())) || (a() == null && cVar.a() == null)) && b() == cVar.b();
        }
    }

    public final int hashCode() {
        return o.b(a(), Long.valueOf(b()));
    }

    public final String toString() {
        o.a c5 = o.c(this);
        c5.a("name", a());
        c5.a("version", Long.valueOf(b()));
        return c5.toString();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = x0.c.a(parcel);
        x0.c.k(parcel, 1, a(), false);
        x0.c.g(parcel, 2, this.f6816f);
        x0.c.i(parcel, 3, b());
        x0.c.b(parcel, a5);
    }
}
