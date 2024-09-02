package g1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class e extends Binder implements IInterface {
    protected e(String str) {
        attachInterface(this, str);
    }

    /* access modifiers changed from: protected */
    public boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        throw null;
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i5, parcel, parcel2, i6)) {
            return true;
        }
        return a(i5, parcel, parcel2, i6);
    }
}
