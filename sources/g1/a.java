package g1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a implements IInterface {

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f4666b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4667c;

    protected a(IBinder iBinder, String str) {
        this.f4666b = iBinder;
        this.f4667c = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4667c);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f4666b;
    }

    /* access modifiers changed from: protected */
    public final Parcel c(int i5, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f4666b.transact(i5, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void e(int i5, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f4666b.transact(i5, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
