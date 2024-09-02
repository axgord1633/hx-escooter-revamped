package w0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.a;
import x0.c;

public class r extends a {
    public static final Parcelable.Creator<r> CREATOR = new s0();

    /* renamed from: e  reason: collision with root package name */
    private final int f7430e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f7431f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7432g;

    /* renamed from: h  reason: collision with root package name */
    private final int f7433h;

    /* renamed from: i  reason: collision with root package name */
    private final int f7434i;

    public r(int i5, boolean z4, boolean z5, int i6, int i7) {
        this.f7430e = i5;
        this.f7431f = z4;
        this.f7432g = z5;
        this.f7433h = i6;
        this.f7434i = i7;
    }

    public int a() {
        return this.f7433h;
    }

    public int b() {
        return this.f7434i;
    }

    public boolean c() {
        return this.f7431f;
    }

    public boolean d() {
        return this.f7432g;
    }

    public int e() {
        return this.f7430e;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, e());
        c.c(parcel, 2, c());
        c.c(parcel, 3, d());
        c.g(parcel, 4, a());
        c.g(parcel, 5, b());
        c.b(parcel, a5);
    }
}
