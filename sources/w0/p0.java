package w0;

import android.os.IBinder;
import android.os.Parcel;

final class p0 implements m {

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f7422b;

    p0(IBinder iBinder) {
        this.f7422b = iBinder;
    }

    public final IBinder asBinder() {
        return this.f7422b;
    }

    public final void g(l lVar, g gVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
            if (gVar != null) {
                obtain.writeInt(1);
                c1.a(gVar, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7422b.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
