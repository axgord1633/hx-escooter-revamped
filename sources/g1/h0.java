package g1;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import i1.v;
import i1.w;
import i1.y;
import i1.z;
import x0.a;
import x0.c;

@Deprecated
public final class h0 extends a {
    public static final Parcelable.Creator<h0> CREATOR = new i0();

    /* renamed from: e  reason: collision with root package name */
    private final int f4690e;

    /* renamed from: f  reason: collision with root package name */
    private final f0 f4691f;

    /* renamed from: g  reason: collision with root package name */
    private final z f4692g;

    /* renamed from: h  reason: collision with root package name */
    private final w f4693h;

    /* renamed from: i  reason: collision with root package name */
    private final PendingIntent f4694i;

    /* renamed from: j  reason: collision with root package name */
    private final b1 f4695j;

    /* renamed from: k  reason: collision with root package name */
    private final String f4696k;

    h0(int i5, f0 f0Var, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.f4690e = i5;
        this.f4691f = f0Var;
        b1 b1Var = null;
        this.f4692g = iBinder != null ? y.c(iBinder) : null;
        this.f4694i = pendingIntent;
        this.f4693h = iBinder2 != null ? v.c(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            b1Var = queryLocalInterface instanceof b1 ? (b1) queryLocalInterface : new z0(iBinder3);
        }
        this.f4695j = b1Var;
        this.f4696k = str;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f4690e);
        c.j(parcel, 2, this.f4691f, i5, false);
        z zVar = this.f4692g;
        IBinder iBinder = null;
        c.f(parcel, 3, zVar == null ? null : zVar.asBinder(), false);
        c.j(parcel, 4, this.f4694i, i5, false);
        w wVar = this.f4693h;
        c.f(parcel, 5, wVar == null ? null : wVar.asBinder(), false);
        b1 b1Var = this.f4695j;
        if (b1Var != null) {
            iBinder = b1Var.asBinder();
        }
        c.f(parcel, 6, iBinder, false);
        c.k(parcel, 8, this.f4696k, false);
        c.b(parcel, a5);
    }
}
