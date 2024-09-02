package w0;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import f1.a;
import f1.c;

public final class m1 extends a implements j {
    m1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account d() {
        Parcel a5 = a(2, c());
        Account account = (Account) c.a(a5, Account.CREATOR);
        a5.recycle();
        return account;
    }
}
