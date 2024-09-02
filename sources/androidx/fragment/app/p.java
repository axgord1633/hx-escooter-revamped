package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.n;
import java.util.ArrayList;

final class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<t> f2378e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<String> f2379f;

    /* renamed from: g  reason: collision with root package name */
    b[] f2380g;

    /* renamed from: h  reason: collision with root package name */
    int f2381h;

    /* renamed from: i  reason: collision with root package name */
    String f2382i = null;

    /* renamed from: j  reason: collision with root package name */
    ArrayList<String> f2383j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    ArrayList<Bundle> f2384k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    ArrayList<n.l> f2385l;

    class a implements Parcelable.Creator<p> {
        a() {
        }

        /* renamed from: a */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        /* renamed from: b */
        public p[] newArray(int i5) {
            return new p[i5];
        }
    }

    public p() {
    }

    public p(Parcel parcel) {
        this.f2378e = parcel.createTypedArrayList(t.CREATOR);
        this.f2379f = parcel.createStringArrayList();
        this.f2380g = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f2381h = parcel.readInt();
        this.f2382i = parcel.readString();
        this.f2383j = parcel.createStringArrayList();
        this.f2384k = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f2385l = parcel.createTypedArrayList(n.l.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeTypedList(this.f2378e);
        parcel.writeStringList(this.f2379f);
        parcel.writeTypedArray(this.f2380g, i5);
        parcel.writeInt(this.f2381h);
        parcel.writeString(this.f2382i);
        parcel.writeStringList(this.f2383j);
        parcel.writeTypedList(this.f2384k);
        parcel.writeTypedList(this.f2385l);
    }
}
