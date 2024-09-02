package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    final String f2394e;

    /* renamed from: f  reason: collision with root package name */
    final String f2395f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f2396g;

    /* renamed from: h  reason: collision with root package name */
    final int f2397h;

    /* renamed from: i  reason: collision with root package name */
    final int f2398i;

    /* renamed from: j  reason: collision with root package name */
    final String f2399j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f2400k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f2401l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f2402m;

    /* renamed from: n  reason: collision with root package name */
    final Bundle f2403n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f2404o;

    /* renamed from: p  reason: collision with root package name */
    final int f2405p;

    /* renamed from: q  reason: collision with root package name */
    Bundle f2406q;

    class a implements Parcelable.Creator<t> {
        a() {
        }

        /* renamed from: a */
        public t createFromParcel(Parcel parcel) {
            return new t(parcel);
        }

        /* renamed from: b */
        public t[] newArray(int i5) {
            return new t[i5];
        }
    }

    t(Parcel parcel) {
        this.f2394e = parcel.readString();
        this.f2395f = parcel.readString();
        boolean z4 = true;
        this.f2396g = parcel.readInt() != 0;
        this.f2397h = parcel.readInt();
        this.f2398i = parcel.readInt();
        this.f2399j = parcel.readString();
        this.f2400k = parcel.readInt() != 0;
        this.f2401l = parcel.readInt() != 0;
        this.f2402m = parcel.readInt() != 0;
        this.f2403n = parcel.readBundle();
        this.f2404o = parcel.readInt() == 0 ? false : z4;
        this.f2406q = parcel.readBundle();
        this.f2405p = parcel.readInt();
    }

    t(Fragment fragment) {
        this.f2394e = fragment.getClass().getName();
        this.f2395f = fragment.mWho;
        this.f2396g = fragment.mFromLayout;
        this.f2397h = fragment.mFragmentId;
        this.f2398i = fragment.mContainerId;
        this.f2399j = fragment.mTag;
        this.f2400k = fragment.mRetainInstance;
        this.f2401l = fragment.mRemoving;
        this.f2402m = fragment.mDetached;
        this.f2403n = fragment.mArguments;
        this.f2404o = fragment.mHidden;
        this.f2405p = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2394e);
        sb.append(" (");
        sb.append(this.f2395f);
        sb.append(")}:");
        if (this.f2396g) {
            sb.append(" fromLayout");
        }
        if (this.f2398i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2398i));
        }
        String str = this.f2399j;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2399j);
        }
        if (this.f2400k) {
            sb.append(" retainInstance");
        }
        if (this.f2401l) {
            sb.append(" removing");
        }
        if (this.f2402m) {
            sb.append(" detached");
        }
        if (this.f2404o) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f2394e);
        parcel.writeString(this.f2395f);
        parcel.writeInt(this.f2396g ? 1 : 0);
        parcel.writeInt(this.f2397h);
        parcel.writeInt(this.f2398i);
        parcel.writeString(this.f2399j);
        parcel.writeInt(this.f2400k ? 1 : 0);
        parcel.writeInt(this.f2401l ? 1 : 0);
        parcel.writeInt(this.f2402m ? 1 : 0);
        parcel.writeBundle(this.f2403n);
        parcel.writeInt(this.f2404o ? 1 : 0);
        parcel.writeBundle(this.f2406q);
        parcel.writeInt(this.f2405p);
    }
}
