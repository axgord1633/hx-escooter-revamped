package t;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: f  reason: collision with root package name */
    public static final a f6805f = new C0110a();

    /* renamed from: e  reason: collision with root package name */
    private final Parcelable f6806e;

    /* renamed from: t.a$a  reason: collision with other inner class name */
    static class C0110a extends a {
        C0110a() {
            super((C0110a) null);
        }
    }

    static class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f6805f;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public a[] newArray(int i5) {
            return new a[i5];
        }
    }

    private a() {
        this.f6806e = null;
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f6806e = readParcelable == null ? f6805f : readParcelable;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f6806e = parcelable == f6805f ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* synthetic */ a(C0110a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.f6806e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f6806e, i5);
    }
}
