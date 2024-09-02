package g1;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import x0.a;
import x0.c;

public final class d0 extends a {
    public static final Parcelable.Creator<d0> CREATOR = new e0();

    /* renamed from: e  reason: collision with root package name */
    private final int f4680e;

    /* renamed from: f  reason: collision with root package name */
    private final IBinder f4681f;

    /* renamed from: g  reason: collision with root package name */
    private final IBinder f4682g;

    /* renamed from: h  reason: collision with root package name */
    private final PendingIntent f4683h;

    /* renamed from: i  reason: collision with root package name */
    private final String f4684i;

    /* renamed from: j  reason: collision with root package name */
    private final String f4685j;

    d0(int i5, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str, String str2) {
        this.f4680e = i5;
        this.f4681f = iBinder;
        this.f4682g = iBinder2;
        this.f4683h = pendingIntent;
        this.f4684i = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.f4685j = str2;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.IBinder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static g1.d0 a(android.os.IInterface r7, i1.w r8, java.lang.String r9, java.lang.String r10) {
        /*
            g1.d0 r9 = new g1.d0
            if (r7 != 0) goto L_0x0005
            r7 = 0
        L_0x0005:
            r2 = r7
            r1 = 2
            r4 = 0
            r5 = 0
            r0 = r9
            r3 = r8
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.d0.a(android.os.IInterface, i1.w, java.lang.String, java.lang.String):g1.d0");
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f4680e);
        c.f(parcel, 2, this.f4681f, false);
        c.f(parcel, 3, this.f4682g, false);
        c.j(parcel, 4, this.f4683h, i5, false);
        c.k(parcel, 5, this.f4684i, false);
        c.k(parcel, 6, this.f4685j, false);
        c.b(parcel, a5);
    }
}
