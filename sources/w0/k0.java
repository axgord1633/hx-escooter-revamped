package w0;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import x0.b;

public final class k0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int r5 = b.r(parcel);
        Account account = null;
        int i5 = 0;
        int i6 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            int i7 = b.i(l5);
            if (i7 == 1) {
                i5 = b.n(parcel, l5);
            } else if (i7 == 2) {
                account = (Account) b.c(parcel, l5, Account.CREATOR);
            } else if (i7 == 3) {
                i6 = b.n(parcel, l5);
            } else if (i7 != 4) {
                b.q(parcel, l5);
            } else {
                googleSignInAccount = (GoogleSignInAccount) b.c(parcel, l5, GoogleSignInAccount.CREATOR);
            }
        }
        b.h(parcel, r5);
        return new j0(i5, account, i6, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new j0[i5];
    }
}
