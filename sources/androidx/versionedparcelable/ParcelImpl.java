package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    private final c0.a f2810e;

    static class a implements Parcelable.Creator<ParcelImpl> {
        a() {
        }

        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b */
        public ParcelImpl[] newArray(int i5) {
            return new ParcelImpl[i5];
        }
    }

    protected ParcelImpl(Parcel parcel) {
        this.f2810e = new b(parcel).u();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        new b(parcel).L(this.f2810e);
    }
}
