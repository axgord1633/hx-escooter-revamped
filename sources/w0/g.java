package w0;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import t0.c;
import w0.j;
import x0.a;

public class g extends a {
    public static final Parcelable.Creator<g> CREATOR = new c1();

    /* renamed from: s  reason: collision with root package name */
    static final Scope[] f7361s = new Scope[0];

    /* renamed from: t  reason: collision with root package name */
    static final c[] f7362t = new c[0];

    /* renamed from: e  reason: collision with root package name */
    final int f7363e;

    /* renamed from: f  reason: collision with root package name */
    final int f7364f;

    /* renamed from: g  reason: collision with root package name */
    int f7365g;

    /* renamed from: h  reason: collision with root package name */
    String f7366h;

    /* renamed from: i  reason: collision with root package name */
    IBinder f7367i;

    /* renamed from: j  reason: collision with root package name */
    Scope[] f7368j;

    /* renamed from: k  reason: collision with root package name */
    Bundle f7369k;

    /* renamed from: l  reason: collision with root package name */
    Account f7370l;

    /* renamed from: m  reason: collision with root package name */
    c[] f7371m;

    /* renamed from: n  reason: collision with root package name */
    c[] f7372n;

    /* renamed from: o  reason: collision with root package name */
    boolean f7373o;

    /* renamed from: p  reason: collision with root package name */
    int f7374p;

    /* renamed from: q  reason: collision with root package name */
    boolean f7375q;

    /* renamed from: r  reason: collision with root package name */
    private String f7376r;

    g(int i5, int i6, int i7, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z4, int i8, boolean z5, String str2) {
        scopeArr = scopeArr == null ? f7361s : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        cVarArr = cVarArr == null ? f7362t : cVarArr;
        cVarArr2 = cVarArr2 == null ? f7362t : cVarArr2;
        this.f7363e = i5;
        this.f7364f = i6;
        this.f7365g = i7;
        if ("com.google.android.gms".equals(str)) {
            this.f7366h = "com.google.android.gms";
        } else {
            this.f7366h = str;
        }
        if (i5 < 2) {
            this.f7370l = iBinder != null ? a.e(j.a.c(iBinder)) : null;
        } else {
            this.f7367i = iBinder;
            this.f7370l = account;
        }
        this.f7368j = scopeArr;
        this.f7369k = bundle;
        this.f7371m = cVarArr;
        this.f7372n = cVarArr2;
        this.f7373o = z4;
        this.f7374p = i8;
        this.f7375q = z5;
        this.f7376r = str2;
    }

    public final String a() {
        return this.f7376r;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        c1.a(this, parcel, i5);
    }
}
