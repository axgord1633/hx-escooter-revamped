package x0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class b {

    public static class a extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r3, android.os.Parcel r4) {
            /*
                r2 = this;
                int r0 = r4.dataPosition()
                int r4 = r4.dataSize()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = " size="
                r1.append(r3)
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: x0.b.a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static Bundle a(Parcel parcel, int i5) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + p5);
        return readBundle;
    }

    public static int[] b(Parcel parcel, int i5) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + p5);
        return createIntArray;
    }

    public static <T extends Parcelable> T c(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        T t5 = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + p5);
        return t5;
    }

    public static String d(Parcel parcel, int i5) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + p5);
        return readString;
    }

    public static ArrayList<String> e(Parcel parcel, int i5) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + p5);
        return createStringArrayList;
    }

    public static <T> T[] f(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + p5);
        return createTypedArray;
    }

    public static <T> ArrayList<T> g(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + p5);
        return createTypedArrayList;
    }

    public static void h(Parcel parcel, int i5) {
        if (parcel.dataPosition() != i5) {
            throw new a("Overread allowed size end=" + i5, parcel);
        }
    }

    public static int i(int i5) {
        return (char) i5;
    }

    public static boolean j(Parcel parcel, int i5) {
        s(parcel, i5, 4);
        return parcel.readInt() != 0;
    }

    public static float k(Parcel parcel, int i5) {
        s(parcel, i5, 4);
        return parcel.readFloat();
    }

    public static int l(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder m(Parcel parcel, int i5) {
        int p5 = p(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (p5 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + p5);
        return readStrongBinder;
    }

    public static int n(Parcel parcel, int i5) {
        s(parcel, i5, 4);
        return parcel.readInt();
    }

    public static long o(Parcel parcel, int i5) {
        s(parcel, i5, 8);
        return parcel.readLong();
    }

    public static int p(Parcel parcel, int i5) {
        return (i5 & -65536) != -65536 ? (char) (i5 >> 16) : parcel.readInt();
    }

    public static void q(Parcel parcel, int i5) {
        parcel.setDataPosition(parcel.dataPosition() + p(parcel, i5));
    }

    public static int r(Parcel parcel) {
        int l5 = l(parcel);
        int p5 = p(parcel, l5);
        int dataPosition = parcel.dataPosition();
        if (i(l5) == 20293) {
            int i5 = p5 + dataPosition;
            if (i5 >= dataPosition && i5 <= parcel.dataSize()) {
                return i5;
            }
            throw new a("Size read is invalid start=" + dataPosition + " end=" + i5, parcel);
        }
        throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(l5))), parcel);
    }

    private static void s(Parcel parcel, int i5, int i6) {
        int p5 = p(parcel, i5);
        if (p5 != i6) {
            String hexString = Integer.toHexString(p5);
            throw new a("Expected size " + i6 + " got " + p5 + " (0x" + hexString + ")", parcel);
        }
    }
}
