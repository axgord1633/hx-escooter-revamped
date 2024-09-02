package com.google.android.gms.auth.api.signin;

import a1.b;
import a1.c;
import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import w0.p;
import x0.a;

public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* renamed from: r  reason: collision with root package name */
    public static b f3255r = c.a();

    /* renamed from: e  reason: collision with root package name */
    final int f3256e;

    /* renamed from: f  reason: collision with root package name */
    private String f3257f;

    /* renamed from: g  reason: collision with root package name */
    private String f3258g;

    /* renamed from: h  reason: collision with root package name */
    private String f3259h;

    /* renamed from: i  reason: collision with root package name */
    private String f3260i;

    /* renamed from: j  reason: collision with root package name */
    private Uri f3261j;

    /* renamed from: k  reason: collision with root package name */
    private String f3262k;

    /* renamed from: l  reason: collision with root package name */
    private long f3263l;

    /* renamed from: m  reason: collision with root package name */
    private String f3264m;

    /* renamed from: n  reason: collision with root package name */
    List f3265n;

    /* renamed from: o  reason: collision with root package name */
    private String f3266o;

    /* renamed from: p  reason: collision with root package name */
    private String f3267p;

    /* renamed from: q  reason: collision with root package name */
    private Set f3268q = new HashSet();

    GoogleSignInAccount(int i5, String str, String str2, String str3, String str4, Uri uri, String str5, long j5, String str6, List list, String str7, String str8) {
        this.f3256e = i5;
        this.f3257f = str;
        this.f3258g = str2;
        this.f3259h = str3;
        this.f3260i = str4;
        this.f3261j = uri;
        this.f3262k = str5;
        this.f3263l = j5;
        this.f3264m = str6;
        this.f3265n = list;
        this.f3266o = str7;
        this.f3267p = str8;
    }

    public static GoogleSignInAccount k(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l5, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l5.longValue(), p.e(str7), new ArrayList((Collection) p.g(set)), str5, str6);
    }

    public static GoogleSignInAccount l(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            hashSet.add(new Scope(jSONArray.getString(i5)));
        }
        GoogleSignInAccount k5 = k(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str2 = jSONObject.optString("serverAuthCode");
        }
        k5.f3262k = str2;
        return k5;
    }

    public Account a() {
        String str = this.f3259h;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String b() {
        return this.f3260i;
    }

    public String c() {
        return this.f3259h;
    }

    public String d() {
        return this.f3267p;
    }

    public String e() {
        return this.f3266o;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f3264m.equals(this.f3264m) && googleSignInAccount.i().equals(i());
    }

    public String f() {
        return this.f3257f;
    }

    public String g() {
        return this.f3258g;
    }

    public Uri h() {
        return this.f3261j;
    }

    public int hashCode() {
        return ((this.f3264m.hashCode() + 527) * 31) + i().hashCode();
    }

    public Set<Scope> i() {
        HashSet hashSet = new HashSet(this.f3265n);
        hashSet.addAll(this.f3268q);
        return hashSet;
    }

    public String j() {
        return this.f3262k;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = x0.c.a(parcel);
        x0.c.g(parcel, 1, this.f3256e);
        x0.c.k(parcel, 2, f(), false);
        x0.c.k(parcel, 3, g(), false);
        x0.c.k(parcel, 4, c(), false);
        x0.c.k(parcel, 5, b(), false);
        x0.c.j(parcel, 6, h(), i5, false);
        x0.c.k(parcel, 7, j(), false);
        x0.c.i(parcel, 8, this.f3263l);
        x0.c.k(parcel, 9, this.f3264m, false);
        x0.c.n(parcel, 10, this.f3265n, false);
        x0.c.k(parcel, 11, e(), false);
        x0.c.k(parcel, 12, d(), false);
        x0.c.b(parcel, a5);
    }
}
