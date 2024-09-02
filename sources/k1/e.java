package k1;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import e1.b;
import e1.c;
import t0.a;

public abstract class e extends b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean z(int i5, Parcel parcel, Parcel parcel2, int i6) {
        switch (i5) {
            case 3:
                a aVar = (a) c.a(parcel, a.CREATOR);
                b bVar = (b) c.a(parcel, b.CREATOR);
                break;
            case 4:
            case 6:
                Status status = (Status) c.a(parcel, Status.CREATOR);
                break;
            case 7:
                Status status2 = (Status) c.a(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                c.b(parcel);
                s((l) c.a(parcel, l.CREATOR));
                break;
            case 9:
                h hVar = (h) c.a(parcel, h.CREATOR);
                break;
            default:
                return false;
        }
        c.b(parcel);
        parcel2.writeNoException();
        return true;
    }
}
