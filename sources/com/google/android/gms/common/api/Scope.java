package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import w0.p;
import x0.a;
import x0.c;

public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    final int f3271e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3272f;

    Scope(int i5, String str) {
        p.f(str, "scopeUri must not be null or empty");
        this.f3271e = i5;
        this.f3272f = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String a() {
        return this.f3272f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f3272f.equals(((Scope) obj).f3272f);
    }

    public int hashCode() {
        return this.f3272f.hashCode();
    }

    public String toString() {
        return this.f3272f;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f3271e);
        c.k(parcel, 2, a(), false);
        c.b(parcel, a5);
    }
}
