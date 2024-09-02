package e1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a implements IInterface {

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f4490b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4491c;

    protected a(IBinder iBinder, String str) {
        this.f4490b = iBinder;
        this.f4491c = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4491c);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f4490b;
    }

    /* access modifiers changed from: protected */
    public final void c(int i5, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f4490b.transact(i5, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void e(int i5, Parcel parcel) {
        try {
            this.f4490b.transact(1, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
