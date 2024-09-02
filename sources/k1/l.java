package k1;

import android.os.Parcel;
import android.os.Parcelable;
import w0.l0;
import x0.a;
import x0.c;

public final class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* renamed from: e  reason: collision with root package name */
    final int f5517e;

    /* renamed from: f  reason: collision with root package name */
    private final t0.a f5518f;

    /* renamed from: g  reason: collision with root package name */
    private final l0 f5519g;

    l(int i5, t0.a aVar, l0 l0Var) {
        this.f5517e = i5;
        this.f5518f = aVar;
        this.f5519g = l0Var;
    }

    public final t0.a a() {
        return this.f5518f;
    }

    public final l0 b() {
        return this.f5519g;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f5517e);
        c.j(parcel, 2, this.f5518f, i5, false);
        c.j(parcel, 3, this.f5519g, i5, false);
        c.b(parcel, a5);
    }
}
