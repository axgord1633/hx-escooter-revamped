package z1;

import android.os.Parcel;
import android.os.Parcelable;

public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    private int f7879e;

    /* renamed from: f  reason: collision with root package name */
    private int f7880f;

    /* renamed from: g  reason: collision with root package name */
    private long f7881g;

    /* renamed from: h  reason: collision with root package name */
    private int f7882h;

    /* renamed from: i  reason: collision with root package name */
    private int f7883i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7884j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7885k;

    class a implements Parcelable.Creator<g> {
        a() {
        }

        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* renamed from: b */
        public g[] newArray(int i5) {
            return new g[i5];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f7886a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f7887b = 1;

        /* renamed from: c  reason: collision with root package name */
        private long f7888c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f7889d = 1;

        /* renamed from: e  reason: collision with root package name */
        private int f7890e = 3;

        /* renamed from: f  reason: collision with root package name */
        private boolean f7891f = true;

        /* renamed from: g  reason: collision with root package name */
        private boolean f7892g = true;

        private static boolean b(int i5) {
            return i5 == 1 || i5 == 2 || i5 == 4 || i5 == 6;
        }

        public g a() {
            return new g(this.f7886a, this.f7887b, this.f7888c, this.f7889d, this.f7890e, this.f7891f, this.f7892g);
        }

        public b c(int i5) {
            if (b(i5)) {
                this.f7887b = i5;
                return this;
            }
            throw new IllegalArgumentException("invalid callback type - " + i5);
        }

        public b d(boolean z4) {
            this.f7891f = z4;
            return this;
        }

        public b e(int i5) {
            if (i5 < -1 || i5 > 2) {
                throw new IllegalArgumentException("invalid scan mode " + i5);
            }
            this.f7886a = i5;
            return this;
        }

        public b f(boolean z4) {
            this.f7892g = z4;
            return this;
        }
    }

    g(int i5, int i6, long j5, int i7, int i8, boolean z4, boolean z5) {
        this.f7879e = i5;
        this.f7880f = i6;
        this.f7881g = j5;
        this.f7883i = i8;
        this.f7882h = i7;
        this.f7884j = z4;
        this.f7885k = z5;
    }

    g(Parcel parcel) {
        this.f7879e = parcel.readInt();
        this.f7880f = parcel.readInt();
        this.f7881g = parcel.readLong();
        this.f7882h = parcel.readInt();
        this.f7883i = parcel.readInt();
        boolean z4 = true;
        this.f7884j = parcel.readInt() != 0;
        this.f7885k = parcel.readInt() == 0 ? false : z4;
    }

    public g a(int i5) {
        return new g(this.f7879e, i5, this.f7881g, this.f7882h, this.f7883i, this.f7884j, this.f7885k);
    }

    public int b() {
        return this.f7880f;
    }

    public boolean c() {
        return this.f7884j;
    }

    public int d() {
        return this.f7882h;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f7883i;
    }

    public long f() {
        return this.f7881g;
    }

    public int g() {
        return this.f7879e;
    }

    public boolean h() {
        return this.f7885k;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f7879e);
        parcel.writeInt(this.f7880f);
        parcel.writeLong(this.f7881g);
        parcel.writeInt(this.f7882h);
        parcel.writeInt(this.f7883i);
        parcel.writeInt(this.f7884j ? 1 : 0);
        parcel.writeInt(this.f7885k ? 1 : 0);
    }
}
