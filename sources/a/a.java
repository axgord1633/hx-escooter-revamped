package a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public interface a extends IInterface {

    /* renamed from: a  reason: collision with root package name */
    public static final String f0a = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* renamed from: a.a$a  reason: collision with other inner class name */
    public static abstract class C0000a extends Binder implements a {

        /* renamed from: a.a$a$a  reason: collision with other inner class name */
        private static class C0001a implements a {

            /* renamed from: b  reason: collision with root package name */
            private IBinder f1b;

            C0001a(IBinder iBinder) {
                this.f1b = iBinder;
            }

            public IBinder asBinder() {
                return this.f1b;
            }

            public void t(String str, int i5, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f0a);
                    obtain.writeString(str);
                    obtain.writeInt(i5);
                    obtain.writeString(str2);
                    b.b(obtain, notification, 0);
                    this.f1b.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f0a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0001a(iBinder) : (a) queryLocalInterface;
        }
    }

    public static class b {
        /* access modifiers changed from: private */
        public static <T extends Parcelable> void b(Parcel parcel, T t5, int i5) {
            if (t5 != null) {
                parcel.writeInt(1);
                t5.writeToParcel(parcel, i5);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void t(String str, int i5, String str2, Notification notification);
}
