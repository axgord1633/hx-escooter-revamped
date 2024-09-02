package w0;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import x0.a;
import x0.c;

public final class j0 extends a {
    public static final Parcelable.Creator<j0> CREATOR = new k0();

    /* renamed from: e  reason: collision with root package name */
    final int f7393e;

    /* renamed from: f  reason: collision with root package name */
    private final Account f7394f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7395g;

    /* renamed from: h  reason: collision with root package name */
    private final GoogleSignInAccount f7396h;

    j0(int i5, Account account, int i6, GoogleSignInAccount googleSignInAccount) {
        this.f7393e = i5;
        this.f7394f = account;
        this.f7395g = i6;
        this.f7396h = googleSignInAccount;
    }

    public j0(Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i5, googleSignInAccount);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f7393e);
        c.j(parcel, 2, this.f7394f, i5, false);
        c.g(parcel, 3, this.f7395g);
        c.j(parcel, 4, this.f7396h, i5, false);
        c.b(parcel, a5);
    }
}
