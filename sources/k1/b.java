package k1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import u0.k;
import x0.a;
import x0.c;

public final class b extends a implements k {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* renamed from: e  reason: collision with root package name */
    final int f5510e;

    /* renamed from: f  reason: collision with root package name */
    private int f5511f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f5512g;

    public b() {
        this(2, 0, (Intent) null);
    }

    b(int i5, int i6, Intent intent) {
        this.f5510e = i5;
        this.f5511f = i6;
        this.f5512g = intent;
    }

    public final Status getStatus() {
        return this.f5511f == 0 ? Status.f3274k : Status.f3278o;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f5510e);
        c.g(parcel, 2, this.f5511f);
        c.j(parcel, 3, this.f5512g, i5, false);
        c.b(parcel, a5);
    }
}
