package w0;

import android.os.Parcel;
import d1.a;
import f1.b;
import f1.c;

public abstract class n1 extends b implements o1 {
    public n1() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            a b5 = b();
            parcel2.writeNoException();
            c.c(parcel2, b5);
        } else if (i5 != 2) {
            return false;
        } else {
            int v5 = v();
            parcel2.writeNoException();
            parcel2.writeInt(v5);
        }
        return true;
    }
}
