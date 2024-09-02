package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.w;
import androidx.lifecycle.f;
import java.util.ArrayList;

final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    final int[] f2182e;

    /* renamed from: f  reason: collision with root package name */
    final ArrayList<String> f2183f;

    /* renamed from: g  reason: collision with root package name */
    final int[] f2184g;

    /* renamed from: h  reason: collision with root package name */
    final int[] f2185h;

    /* renamed from: i  reason: collision with root package name */
    final int f2186i;

    /* renamed from: j  reason: collision with root package name */
    final String f2187j;

    /* renamed from: k  reason: collision with root package name */
    final int f2188k;

    /* renamed from: l  reason: collision with root package name */
    final int f2189l;

    /* renamed from: m  reason: collision with root package name */
    final CharSequence f2190m;

    /* renamed from: n  reason: collision with root package name */
    final int f2191n;

    /* renamed from: o  reason: collision with root package name */
    final CharSequence f2192o;

    /* renamed from: p  reason: collision with root package name */
    final ArrayList<String> f2193p;

    /* renamed from: q  reason: collision with root package name */
    final ArrayList<String> f2194q;

    /* renamed from: r  reason: collision with root package name */
    final boolean f2195r;

    class a implements Parcelable.Creator<b> {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b */
        public b[] newArray(int i5) {
            return new b[i5];
        }
    }

    public b(Parcel parcel) {
        this.f2182e = parcel.createIntArray();
        this.f2183f = parcel.createStringArrayList();
        this.f2184g = parcel.createIntArray();
        this.f2185h = parcel.createIntArray();
        this.f2186i = parcel.readInt();
        this.f2187j = parcel.readString();
        this.f2188k = parcel.readInt();
        this.f2189l = parcel.readInt();
        this.f2190m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2191n = parcel.readInt();
        this.f2192o = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2193p = parcel.createStringArrayList();
        this.f2194q = parcel.createStringArrayList();
        this.f2195r = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.f2420c.size();
        this.f2182e = new int[(size * 5)];
        if (aVar.f2426i) {
            this.f2183f = new ArrayList<>(size);
            this.f2184g = new int[size];
            this.f2185h = new int[size];
            int i5 = 0;
            int i6 = 0;
            while (i5 < size) {
                w.a aVar2 = aVar.f2420c.get(i5);
                int i7 = i6 + 1;
                this.f2182e[i6] = aVar2.f2437a;
                ArrayList<String> arrayList = this.f2183f;
                Fragment fragment = aVar2.f2438b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f2182e;
                int i8 = i7 + 1;
                iArr[i7] = aVar2.f2439c;
                int i9 = i8 + 1;
                iArr[i8] = aVar2.f2440d;
                int i10 = i9 + 1;
                iArr[i9] = aVar2.f2441e;
                iArr[i10] = aVar2.f2442f;
                this.f2184g[i5] = aVar2.f2443g.ordinal();
                this.f2185h[i5] = aVar2.f2444h.ordinal();
                i5++;
                i6 = i10 + 1;
            }
            this.f2186i = aVar.f2425h;
            this.f2187j = aVar.f2428k;
            this.f2188k = aVar.f2177v;
            this.f2189l = aVar.f2429l;
            this.f2190m = aVar.f2430m;
            this.f2191n = aVar.f2431n;
            this.f2192o = aVar.f2432o;
            this.f2193p = aVar.f2433p;
            this.f2194q = aVar.f2434q;
            this.f2195r = aVar.f2435r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public a a(n nVar) {
        a aVar = new a(nVar);
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.f2182e.length) {
            w.a aVar2 = new w.a();
            int i7 = i5 + 1;
            aVar2.f2437a = this.f2182e[i5];
            if (n.F0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i6 + " base fragment #" + this.f2182e[i7]);
            }
            String str = this.f2183f.get(i6);
            aVar2.f2438b = str != null ? nVar.g0(str) : null;
            aVar2.f2443g = f.b.values()[this.f2184g[i6]];
            aVar2.f2444h = f.b.values()[this.f2185h[i6]];
            int[] iArr = this.f2182e;
            int i8 = i7 + 1;
            int i9 = iArr[i7];
            aVar2.f2439c = i9;
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            aVar2.f2440d = i11;
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            aVar2.f2441e = i13;
            int i14 = iArr[i12];
            aVar2.f2442f = i14;
            aVar.f2421d = i9;
            aVar.f2422e = i11;
            aVar.f2423f = i13;
            aVar.f2424g = i14;
            aVar.e(aVar2);
            i6++;
            i5 = i12 + 1;
        }
        aVar.f2425h = this.f2186i;
        aVar.f2428k = this.f2187j;
        aVar.f2177v = this.f2188k;
        aVar.f2426i = true;
        aVar.f2429l = this.f2189l;
        aVar.f2430m = this.f2190m;
        aVar.f2431n = this.f2191n;
        aVar.f2432o = this.f2192o;
        aVar.f2433p = this.f2193p;
        aVar.f2434q = this.f2194q;
        aVar.f2435r = this.f2195r;
        aVar.m(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeIntArray(this.f2182e);
        parcel.writeStringList(this.f2183f);
        parcel.writeIntArray(this.f2184g);
        parcel.writeIntArray(this.f2185h);
        parcel.writeInt(this.f2186i);
        parcel.writeString(this.f2187j);
        parcel.writeInt(this.f2188k);
        parcel.writeInt(this.f2189l);
        TextUtils.writeToParcel(this.f2190m, parcel, 0);
        parcel.writeInt(this.f2191n);
        TextUtils.writeToParcel(this.f2192o, parcel, 0);
        parcel.writeStringList(this.f2193p);
        parcel.writeStringList(this.f2194q);
        parcel.writeInt(this.f2195r ? 1 : 0);
    }
}
