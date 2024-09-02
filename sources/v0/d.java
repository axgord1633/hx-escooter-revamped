package v0;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e1.b;
import e1.c;

public interface d extends IInterface {

    public static abstract class a extends b implements d {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        /* access modifiers changed from: protected */
        public final boolean z(int i5, Parcel parcel, Parcel parcel2, int i6) {
            if (i5 != 1) {
                return false;
            }
            c.b(parcel);
            m((Status) c.a(parcel, Status.CREATOR));
            return true;
        }
    }

    void m(Status status);
}
