package z1;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import w1.r;

public class d implements Parcelable, r {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: q  reason: collision with root package name */
    private static final d f7848q = new b().a();

    /* renamed from: e  reason: collision with root package name */
    private final String f7849e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7850f;

    /* renamed from: g  reason: collision with root package name */
    private final ParcelUuid f7851g;

    /* renamed from: h  reason: collision with root package name */
    private final ParcelUuid f7852h;

    /* renamed from: i  reason: collision with root package name */
    private final ParcelUuid f7853i;

    /* renamed from: j  reason: collision with root package name */
    private final ParcelUuid f7854j;

    /* renamed from: k  reason: collision with root package name */
    private final ParcelUuid f7855k;

    /* renamed from: l  reason: collision with root package name */
    private final byte[] f7856l;

    /* renamed from: m  reason: collision with root package name */
    private final byte[] f7857m;

    /* renamed from: n  reason: collision with root package name */
    private final int f7858n;

    /* renamed from: o  reason: collision with root package name */
    private final byte[] f7859o;

    /* renamed from: p  reason: collision with root package name */
    private final byte[] f7860p;

    class a implements Parcelable.Creator<d> {
        a() {
        }

        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            b bVar = new b();
            if (parcel.readInt() == 1) {
                bVar.c(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                bVar.b(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                bVar.j(parcelUuid);
                if (parcel.readInt() == 1) {
                    bVar.k(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                bVar.h(parcelUuid2);
                if (parcel.readInt() == 1) {
                    bVar.i(parcelUuid2, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid3 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() == 0) {
                        bVar.f(parcelUuid3, bArr);
                    } else {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        bVar.g(parcelUuid3, bArr, bArr2);
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() == 0) {
                    bVar.d(readInt, bArr3);
                } else {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    bVar.e(readInt, bArr3, bArr4);
                }
            }
            return bVar.a();
        }

        /* renamed from: b */
        public d[] newArray(int i5) {
            return new d[i5];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f7861a;

        /* renamed from: b  reason: collision with root package name */
        private String f7862b;

        /* renamed from: c  reason: collision with root package name */
        private ParcelUuid f7863c;

        /* renamed from: d  reason: collision with root package name */
        private ParcelUuid f7864d;

        /* renamed from: e  reason: collision with root package name */
        private ParcelUuid f7865e;

        /* renamed from: f  reason: collision with root package name */
        private ParcelUuid f7866f;

        /* renamed from: g  reason: collision with root package name */
        private ParcelUuid f7867g;

        /* renamed from: h  reason: collision with root package name */
        private byte[] f7868h;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f7869i;

        /* renamed from: j  reason: collision with root package name */
        private int f7870j = -1;

        /* renamed from: k  reason: collision with root package name */
        private byte[] f7871k;

        /* renamed from: l  reason: collision with root package name */
        private byte[] f7872l;

        public d a() {
            return new d(this.f7861a, this.f7862b, this.f7863c, this.f7864d, this.f7865e, this.f7866f, this.f7867g, this.f7868h, this.f7869i, this.f7870j, this.f7871k, this.f7872l);
        }

        public b b(String str) {
            if (str == null || BluetoothAdapter.checkBluetoothAddress(str)) {
                this.f7862b = str;
                return this;
            }
            throw new IllegalArgumentException("invalid device address " + str);
        }

        public b c(String str) {
            this.f7861a = str;
            return this;
        }

        public b d(int i5, byte[] bArr) {
            if (bArr == null || i5 >= 0) {
                this.f7870j = i5;
                this.f7871k = bArr;
                this.f7872l = null;
                return this;
            }
            throw new IllegalArgumentException("invalid manufacture id");
        }

        public b e(int i5, byte[] bArr, byte[] bArr2) {
            if (bArr == null || i5 >= 0) {
                byte[] bArr3 = this.f7872l;
                if (bArr3 != null) {
                    byte[] bArr4 = this.f7871k;
                    if (bArr4 == null) {
                        throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                    } else if (bArr4.length != bArr3.length) {
                        throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    }
                }
                this.f7870j = i5;
                this.f7871k = bArr;
                this.f7872l = bArr2;
                return this;
            }
            throw new IllegalArgumentException("invalid manufacture id");
        }

        public b f(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid != null) {
                this.f7867g = parcelUuid;
                this.f7868h = bArr;
                this.f7869i = null;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public b g(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid != null) {
                byte[] bArr3 = this.f7869i;
                if (bArr3 != null) {
                    byte[] bArr4 = this.f7868h;
                    if (bArr4 == null) {
                        throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    } else if (bArr4.length != bArr3.length) {
                        throw new IllegalArgumentException("size mismatch for service data and service data mask");
                    }
                }
                this.f7867g = parcelUuid;
                this.f7868h = bArr;
                this.f7869i = bArr2;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public b h(ParcelUuid parcelUuid) {
            this.f7865e = parcelUuid;
            this.f7866f = null;
            return this;
        }

        public b i(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (parcelUuid2 == null || parcelUuid != null) {
                this.f7865e = parcelUuid;
                this.f7866f = parcelUuid2;
                return this;
            }
            throw new IllegalArgumentException("SolicitationUuid is null while SolicitationUuidMask is not null!");
        }

        public b j(ParcelUuid parcelUuid) {
            this.f7863c = parcelUuid;
            this.f7864d = null;
            return this;
        }

        public b k(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (this.f7864d == null || this.f7863c != null) {
                this.f7863c = parcelUuid;
                this.f7864d = parcelUuid2;
                return this;
            }
            throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
        }
    }

    d(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, ParcelUuid parcelUuid4, ParcelUuid parcelUuid5, byte[] bArr, byte[] bArr2, int i5, byte[] bArr3, byte[] bArr4) {
        this.f7849e = str;
        this.f7851g = parcelUuid;
        this.f7852h = parcelUuid2;
        this.f7853i = parcelUuid3;
        this.f7854j = parcelUuid4;
        this.f7850f = str2;
        this.f7855k = parcelUuid5;
        this.f7856l = bArr;
        this.f7857m = bArr2;
        this.f7858n = i5;
        this.f7859o = bArr3;
        this.f7860p = bArr4;
    }

    private static boolean c(byte[] bArr, byte[] bArr2) {
        return bArr == bArr2 || !(bArr == null || bArr2 == null || !Arrays.equals(bArr, bArr2));
    }

    private static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static boolean o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i5 = 0; i5 < bArr.length; i5++) {
                if (bArr3[i5] != bArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        for (int i6 = 0; i6 < bArr.length; i6++) {
            byte b5 = bArr2[i6];
            if ((bArr3[i6] & b5) != (b5 & bArr[i6])) {
                return false;
            }
        }
        return true;
    }

    private static boolean p(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List<ParcelUuid> list) {
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (ParcelUuid uuid : list) {
            if (q(parcelUuid.getUuid(), parcelUuid2 == null ? null : parcelUuid2.getUuid(), uuid.getUuid())) {
                return true;
            }
        }
        return false;
    }

    private static boolean q(UUID uuid, UUID uuid2, UUID uuid3) {
        if (uuid2 == null) {
            return uuid.equals(uuid3);
        }
        if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            return false;
        }
        return (uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid2.getMostSignificantBits() & uuid3.getMostSignificantBits());
    }

    private static boolean r(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List<ParcelUuid> list) {
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (ParcelUuid uuid : list) {
            if (q(parcelUuid.getUuid(), parcelUuid2 == null ? null : parcelUuid2.getUuid(), uuid.getUuid())) {
                return true;
            }
        }
        return false;
    }

    public boolean a(r1.r rVar) {
        if (rVar == null) {
            return false;
        }
        String c5 = rVar.c();
        String str = this.f7850f;
        if (str != null && !str.equals(c5)) {
            return false;
        }
        e b5 = rVar.b();
        String str2 = this.f7849e;
        if (str2 != null && !str2.equals(rVar.a()) && (b5 == null || !this.f7849e.equals(b5.a()))) {
            return false;
        }
        if (b5 == null) {
            return this.f7851g == null && this.f7859o == null && this.f7856l == null;
        }
        ParcelUuid parcelUuid = this.f7851g;
        if (parcelUuid != null && !r(parcelUuid, this.f7852h, b5.b())) {
            return false;
        }
        ParcelUuid parcelUuid2 = this.f7853i;
        if (parcelUuid2 != null && !p(parcelUuid2, this.f7854j, b5.g())) {
            return false;
        }
        ParcelUuid parcelUuid3 = this.f7855k;
        if (parcelUuid3 != null && !o(this.f7856l, this.f7857m, b5.e(parcelUuid3))) {
            return false;
        }
        int i5 = this.f7858n;
        return i5 < 0 || o(this.f7859o, this.f7860p, b5.f(i5));
    }

    public boolean b() {
        return equals(f7848q);
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f7850f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return d(this.f7849e, dVar.f7849e) && d(this.f7850f, dVar.f7850f) && this.f7858n == dVar.f7858n && c(this.f7859o, dVar.f7859o) && c(this.f7860p, dVar.f7860p) && d(this.f7855k, dVar.f7855k) && c(this.f7856l, dVar.f7856l) && c(this.f7857m, dVar.f7857m) && d(this.f7851g, dVar.f7851g) && d(this.f7852h, dVar.f7852h) && d(this.f7853i, dVar.f7853i) && d(this.f7854j, dVar.f7854j);
    }

    public String f() {
        return this.f7849e;
    }

    public byte[] g() {
        return this.f7859o;
    }

    public byte[] h() {
        return this.f7860p;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7849e, this.f7850f, Integer.valueOf(this.f7858n), Integer.valueOf(Arrays.hashCode(this.f7859o)), Integer.valueOf(Arrays.hashCode(this.f7860p)), this.f7855k, Integer.valueOf(Arrays.hashCode(this.f7856l)), Integer.valueOf(Arrays.hashCode(this.f7857m)), this.f7851g, this.f7852h, this.f7853i, this.f7854j});
    }

    public int i() {
        return this.f7858n;
    }

    public byte[] j() {
        return this.f7856l;
    }

    public byte[] k() {
        return this.f7857m;
    }

    public ParcelUuid l() {
        return this.f7855k;
    }

    public ParcelUuid m() {
        return this.f7851g;
    }

    public ParcelUuid n() {
        return this.f7852h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BluetoothLeScanFilter [mDeviceName=");
        sb.append(this.f7849e);
        sb.append(", ");
        sb.append(u1.b.d(this.f7850f));
        sb.append(", mUuid=");
        ParcelUuid parcelUuid = this.f7851g;
        String str = null;
        sb.append(parcelUuid == null ? null : u1.b.g(parcelUuid.getUuid()));
        sb.append(", mUuidMask=");
        ParcelUuid parcelUuid2 = this.f7852h;
        sb.append(parcelUuid2 == null ? null : u1.b.g(parcelUuid2.getUuid()));
        sb.append(", mSolicitedUuid=");
        ParcelUuid parcelUuid3 = this.f7853i;
        sb.append(parcelUuid3 == null ? null : u1.b.g(parcelUuid3.getUuid()));
        sb.append(", mSolicitedUuidMask=");
        ParcelUuid parcelUuid4 = this.f7854j;
        sb.append(parcelUuid4 == null ? null : u1.b.g(parcelUuid4.getUuid()));
        sb.append(", mServiceDataUuid=");
        ParcelUuid parcelUuid5 = this.f7855k;
        if (parcelUuid5 != null) {
            str = u1.b.g(parcelUuid5.getUuid());
        }
        sb.append(str);
        sb.append(", mServiceData=");
        sb.append(Arrays.toString(this.f7856l));
        sb.append(", mServiceDataMask=");
        sb.append(Arrays.toString(this.f7857m));
        sb.append(", mManufacturerId=");
        sb.append(this.f7858n);
        sb.append(", mManufacturerData=");
        sb.append(Arrays.toString(this.f7859o));
        sb.append(", mManufacturerDataMask=");
        sb.append(Arrays.toString(this.f7860p));
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int i6 = 0;
        parcel.writeInt(this.f7849e == null ? 0 : 1);
        String str = this.f7849e;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.f7850f == null ? 0 : 1);
        String str2 = this.f7850f;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.f7851g == null ? 0 : 1);
        ParcelUuid parcelUuid = this.f7851g;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i5);
            parcel.writeInt(this.f7852h == null ? 0 : 1);
            ParcelUuid parcelUuid2 = this.f7852h;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i5);
            }
        }
        parcel.writeInt(this.f7853i == null ? 0 : 1);
        ParcelUuid parcelUuid3 = this.f7853i;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i5);
            parcel.writeInt(this.f7854j == null ? 0 : 1);
            ParcelUuid parcelUuid4 = this.f7854j;
            if (parcelUuid4 != null) {
                parcel.writeParcelable(parcelUuid4, i5);
            }
        }
        parcel.writeInt(this.f7855k == null ? 0 : 1);
        ParcelUuid parcelUuid5 = this.f7855k;
        if (parcelUuid5 != null) {
            parcel.writeParcelable(parcelUuid5, i5);
            parcel.writeInt(this.f7856l == null ? 0 : 1);
            byte[] bArr = this.f7856l;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.f7856l);
                parcel.writeInt(this.f7857m == null ? 0 : 1);
                byte[] bArr2 = this.f7857m;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.f7857m);
                }
            }
        }
        parcel.writeInt(this.f7858n);
        parcel.writeInt(this.f7859o == null ? 0 : 1);
        byte[] bArr3 = this.f7859o;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.f7859o);
            if (this.f7860p != null) {
                i6 = 1;
            }
            parcel.writeInt(i6);
            byte[] bArr4 = this.f7860p;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.f7860p);
            }
        }
    }
}
