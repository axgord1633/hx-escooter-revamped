package w0;

import android.os.Parcel;
import android.os.Parcelable;
import x0.a;
import x0.c;

public class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new b1();

    /* renamed from: e  reason: collision with root package name */
    private final r f7347e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f7348f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7349g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f7350h;

    /* renamed from: i  reason: collision with root package name */
    private final int f7351i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f7352j;

    public f(r rVar, boolean z4, boolean z5, int[] iArr, int i5, int[] iArr2) {
        this.f7347e = rVar;
        this.f7348f = z4;
        this.f7349g = z5;
        this.f7350h = iArr;
        this.f7351i = i5;
        this.f7352j = iArr2;
    }

    public int a() {
        return this.f7351i;
    }

    public int[] b() {
        return this.f7350h;
    }

    public int[] c() {
        return this.f7352j;
    }

    public boolean d() {
        return this.f7348f;
    }

    public boolean e() {
        return this.f7349g;
    }

    public final r f() {
        return this.f7347e;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.j(parcel, 1, this.f7347e, i5, false);
        c.c(parcel, 2, d());
        c.c(parcel, 3, e());
        c.h(parcel, 4, b(), false);
        c.g(parcel, 5, a());
        c.h(parcel, 6, c(), false);
        c.b(parcel, a5);
    }
}
