package w0;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import w0.j;

public class a extends j.a {
    public static Account e(j jVar) {
        Account account = null;
        if (jVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = jVar.d();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
                throw th;
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return account;
    }
}
