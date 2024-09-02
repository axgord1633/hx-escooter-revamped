package i1;

import android.os.Parcel;
import android.os.Parcelable;
import x0.a;
import x0.c;

public final class j extends a {
    public static final Parcelable.Creator<j> CREATOR = new n();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4928e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4929f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4930g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f4931h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f4932i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f4933j;

    public j(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f4928e = z4;
        this.f4929f = z5;
        this.f4930g = z6;
        this.f4931h = z7;
        this.f4932i = z8;
        this.f4933j = z9;
    }

    public boolean a() {
        return this.f4933j;
    }

    public boolean b() {
        return this.f4930g;
    }

    public boolean c() {
        return this.f4931h;
    }

    public boolean d() {
        return this.f4928e;
    }

    public boolean e() {
        return this.f4932i;
    }

    public boolean f() {
        return this.f4929f;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.c(parcel, 1, d());
        c.c(parcel, 2, f());
        c.c(parcel, 3, b());
        c.c(parcel, 4, c());
        c.c(parcel, 5, e());
        c.c(parcel, 6, a());
        c.b(parcel, a5);
    }
}
