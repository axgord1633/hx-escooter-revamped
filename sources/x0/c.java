package x0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class c {
    public static int a(Parcel parcel) {
        return o(parcel, 20293);
    }

    public static void b(Parcel parcel, int i5) {
        p(parcel, i5);
    }

    public static void c(Parcel parcel, int i5, boolean z4) {
        q(parcel, i5, 4);
        parcel.writeInt(z4 ? 1 : 0);
    }

    public static void d(Parcel parcel, int i5, Bundle bundle, boolean z4) {
        if (bundle != null) {
            int o5 = o(parcel, i5);
            parcel.writeBundle(bundle);
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    public static void e(Parcel parcel, int i5, float f5) {
        q(parcel, i5, 4);
        parcel.writeFloat(f5);
    }

    public static void f(Parcel parcel, int i5, IBinder iBinder, boolean z4) {
        if (iBinder != null) {
            int o5 = o(parcel, i5);
            parcel.writeStrongBinder(iBinder);
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    public static void g(Parcel parcel, int i5, int i6) {
        q(parcel, i5, 4);
        parcel.writeInt(i6);
    }

    public static void h(Parcel parcel, int i5, int[] iArr, boolean z4) {
        if (iArr != null) {
            int o5 = o(parcel, i5);
            parcel.writeIntArray(iArr);
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    public static void i(Parcel parcel, int i5, long j5) {
        q(parcel, i5, 8);
        parcel.writeLong(j5);
    }

    public static void j(Parcel parcel, int i5, Parcelable parcelable, int i6, boolean z4) {
        if (parcelable != null) {
            int o5 = o(parcel, i5);
            parcelable.writeToParcel(parcel, i6);
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    public static void k(Parcel parcel, int i5, String str, boolean z4) {
        if (str != null) {
            int o5 = o(parcel, i5);
            parcel.writeString(str);
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    public static void l(Parcel parcel, int i5, List<String> list, boolean z4) {
        if (list != null) {
            int o5 = o(parcel, i5);
            parcel.writeStringList(list);
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    public static <T extends Parcelable> void m(Parcel parcel, int i5, T[] tArr, int i6, boolean z4) {
        if (tArr != null) {
            int o5 = o(parcel, i5);
            parcel.writeInt(r7);
            for (T t5 : tArr) {
                if (t5 == null) {
                    parcel.writeInt(0);
                } else {
                    r(parcel, t5, i6);
                }
            }
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    public static <T extends Parcelable> void n(Parcel parcel, int i5, List<T> list, boolean z4) {
        if (list != null) {
            int o5 = o(parcel, i5);
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                Parcelable parcelable = (Parcelable) list.get(i6);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    r(parcel, parcelable, 0);
                }
            }
            p(parcel, o5);
        } else if (z4) {
            q(parcel, i5, 0);
        }
    }

    private static int o(Parcel parcel, int i5) {
        parcel.writeInt(i5 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void p(Parcel parcel, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(dataPosition - i5);
        parcel.setDataPosition(dataPosition);
    }

    private static void q(Parcel parcel, int i5, int i6) {
        parcel.writeInt(i5 | (i6 << 16));
    }

    private static void r(Parcel parcel, Parcelable parcelable, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i5);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
