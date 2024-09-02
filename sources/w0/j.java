package w0;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import f1.b;

public interface j extends IInterface {

    public static abstract class a extends b implements j {
        public static j c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof j ? (j) queryLocalInterface : new m1(iBinder);
        }
    }

    Account d();
}
