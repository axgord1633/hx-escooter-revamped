package w0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.a;
import x0.c;

public class n extends a {
    public static final Parcelable.Creator<n> CREATOR = new i0();

    /* renamed from: e  reason: collision with root package name */
    private final int f7408e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7409f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7410g;

    /* renamed from: h  reason: collision with root package name */
    private final long f7411h;

    /* renamed from: i  reason: collision with root package name */
    private final long f7412i;

    /* renamed from: j  reason: collision with root package name */
    private final String f7413j;

    /* renamed from: k  reason: collision with root package name */
    private final String f7414k;

    /* renamed from: l  reason: collision with root package name */
    private final int f7415l;

    /* renamed from: m  reason: collision with root package name */
    private final int f7416m;

    public n(int i5, int i6, int i7, long j5, long j6, String str, String str2, int i8, int i9) {
        this.f7408e = i5;
        this.f7409f = i6;
        this.f7410g = i7;
        this.f7411h = j5;
        this.f7412i = j6;
        this.f7413j = str;
        this.f7414k = str2;
        this.f7415l = i8;
        this.f7416m = i9;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f7408e);
        c.g(parcel, 2, this.f7409f);
        c.g(parcel, 3, this.f7410g);
        c.i(parcel, 4, this.f7411h);
        c.i(parcel, 5, this.f7412i);
        c.k(parcel, 6, this.f7413j, false);
        c.k(parcel, 7, this.f7414k, false);
        c.g(parcel, 8, this.f7415l);
        c.g(parcel, 9, this.f7416m);
        c.b(parcel, a5);
    }
}
