package f1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a implements IInterface {

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f4597b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4598c;

    protected a(IBinder iBinder, String str) {
        this.f4597b = iBinder;
        this.f4598c = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i5, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f4597b.transact(i5, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f4597b;
    }

    /* access modifiers changed from: protected */
    public final Parcel c() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4598c);
        return obtain;
    }
}
