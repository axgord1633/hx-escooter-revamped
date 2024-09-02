package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.errorprone.annotations.CheckReturnValue;
import u0.d;
import u0.k;
import w0.o;
import w0.p;
import x0.a;
import x0.c;

public final class Status extends a implements k, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new b();

    /* renamed from: j  reason: collision with root package name */
    public static final Status f3273j = new Status(-1);

    /* renamed from: k  reason: collision with root package name */
    public static final Status f3274k = new Status(0);

    /* renamed from: l  reason: collision with root package name */
    public static final Status f3275l = new Status(14);

    /* renamed from: m  reason: collision with root package name */
    public static final Status f3276m = new Status(8);

    /* renamed from: n  reason: collision with root package name */
    public static final Status f3277n = new Status(15);

    /* renamed from: o  reason: collision with root package name */
    public static final Status f3278o = new Status(16);

    /* renamed from: p  reason: collision with root package name */
    public static final Status f3279p = new Status(18);

    /* renamed from: q  reason: collision with root package name */
    public static final Status f3280q = new Status(17);

    /* renamed from: e  reason: collision with root package name */
    final int f3281e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3282f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3283g;

    /* renamed from: h  reason: collision with root package name */
    private final PendingIntent f3284h;

    /* renamed from: i  reason: collision with root package name */
    private final t0.a f3285i;

    public Status(int i5) {
        this(i5, (String) null);
    }

    Status(int i5, int i6, String str, PendingIntent pendingIntent, t0.a aVar) {
        this.f3281e = i5;
        this.f3282f = i6;
        this.f3283g = str;
        this.f3284h = pendingIntent;
        this.f3285i = aVar;
    }

    public Status(int i5, String str) {
        this(1, i5, str, (PendingIntent) null, (t0.a) null);
    }

    public Status(t0.a aVar, String str) {
        this(aVar, str, 17);
    }

    @Deprecated
    public Status(t0.a aVar, String str, int i5) {
        this(1, i5, str, aVar.c(), aVar);
    }

    public t0.a a() {
        return this.f3285i;
    }

    public int b() {
        return this.f3282f;
    }

    public String c() {
        return this.f3283g;
    }

    public boolean d() {
        return this.f3284h != null;
    }

    @CheckReturnValue
    public boolean e() {
        return this.f3282f <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f3281e == status.f3281e && this.f3282f == status.f3282f && o.a(this.f3283g, status.f3283g) && o.a(this.f3284h, status.f3284h) && o.a(this.f3285i, status.f3285i);
    }

    public void f(Activity activity, int i5) {
        if (d()) {
            PendingIntent pendingIntent = this.f3284h;
            p.g(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i5, (Intent) null, 0, 0, 0);
        }
    }

    public final String g() {
        String str = this.f3283g;
        return str != null ? str : d.a(this.f3282f);
    }

    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return o.b(Integer.valueOf(this.f3281e), Integer.valueOf(this.f3282f), this.f3283g, this.f3284h, this.f3285i);
    }

    public String toString() {
        o.a c5 = o.c(this);
        c5.a("statusCode", g());
        c5.a("resolution", this.f3284h);
        return c5.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, b());
        c.k(parcel, 2, c(), false);
        c.j(parcel, 3, this.f3284h, i5, false);
        c.j(parcel, 4, a(), i5, false);
        c.g(parcel, 1000, this.f3281e);
        c.b(parcel, a5);
    }
}
