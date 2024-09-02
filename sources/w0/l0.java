package w0;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import w0.j;
import x0.a;
import x0.c;

public final class l0 extends a {
    public static final Parcelable.Creator<l0> CREATOR = new m0();

    /* renamed from: e  reason: collision with root package name */
    final int f7399e;

    /* renamed from: f  reason: collision with root package name */
    final IBinder f7400f;

    /* renamed from: g  reason: collision with root package name */
    private final t0.a f7401g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f7402h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f7403i;

    l0(int i5, IBinder iBinder, t0.a aVar, boolean z4, boolean z5) {
        this.f7399e = i5;
        this.f7400f = iBinder;
        this.f7401g = aVar;
        this.f7402h = z4;
        this.f7403i = z5;
    }

    public final t0.a a() {
        return this.f7401g;
    }

    public final j b() {
        IBinder iBinder = this.f7400f;
        if (iBinder == null) {
            return null;
        }
        return j.a.c(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f7401g.equals(l0Var.f7401g) && o.a(b(), l0Var.b());
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f7399e);
        c.f(parcel, 2, this.f7400f, false);
        c.j(parcel, 3, this.f7401g, i5, false);
        c.c(parcel, 4, this.f7402h);
        c.c(parcel, 5, this.f7403i);
        c.b(parcel, a5);
    }
}
