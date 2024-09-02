package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.yalantis.ucrop.BuildConfig;
import java.lang.reflect.Method;
import m.a;

class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f2814d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f2815e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2816f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2817g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2818h;

    /* renamed from: i  reason: collision with root package name */
    private int f2819i;

    /* renamed from: j  reason: collision with root package name */
    private int f2820j;

    /* renamed from: k  reason: collision with root package name */
    private int f2821k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR, new a(), new a(), new a());
    }

    private b(Parcel parcel, int i5, int i6, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2814d = new SparseIntArray();
        this.f2819i = -1;
        this.f2821k = -1;
        this.f2815e = parcel;
        this.f2816f = i5;
        this.f2817g = i6;
        this.f2820j = i5;
        this.f2818h = str;
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f2815e.writeInt(bArr.length);
            this.f2815e.writeByteArray(bArr);
            return;
        }
        this.f2815e.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2815e, 0);
    }

    public void E(int i5) {
        this.f2815e.writeInt(i5);
    }

    public void G(Parcelable parcelable) {
        this.f2815e.writeParcelable(parcelable, 0);
    }

    public void I(String str) {
        this.f2815e.writeString(str);
    }

    public void a() {
        int i5 = this.f2819i;
        if (i5 >= 0) {
            int i6 = this.f2814d.get(i5);
            int dataPosition = this.f2815e.dataPosition();
            this.f2815e.setDataPosition(i6);
            this.f2815e.writeInt(dataPosition - i6);
            this.f2815e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public a b() {
        Parcel parcel = this.f2815e;
        int dataPosition = parcel.dataPosition();
        int i5 = this.f2820j;
        if (i5 == this.f2816f) {
            i5 = this.f2817g;
        }
        int i6 = i5;
        return new b(parcel, dataPosition, i6, this.f2818h + "  ", this.f2811a, this.f2812b, this.f2813c);
    }

    public boolean g() {
        return this.f2815e.readInt() != 0;
    }

    public byte[] i() {
        int readInt = this.f2815e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2815e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2815e);
    }

    public boolean m(int i5) {
        while (this.f2820j < this.f2817g) {
            int i6 = this.f2821k;
            if (i6 == i5) {
                return true;
            }
            if (String.valueOf(i6).compareTo(String.valueOf(i5)) > 0) {
                return false;
            }
            this.f2815e.setDataPosition(this.f2820j);
            int readInt = this.f2815e.readInt();
            this.f2821k = this.f2815e.readInt();
            this.f2820j += readInt;
        }
        return this.f2821k == i5;
    }

    public int o() {
        return this.f2815e.readInt();
    }

    public <T extends Parcelable> T q() {
        return this.f2815e.readParcelable(getClass().getClassLoader());
    }

    public String s() {
        return this.f2815e.readString();
    }

    public void w(int i5) {
        a();
        this.f2819i = i5;
        this.f2814d.put(i5, this.f2815e.dataPosition());
        E(0);
        E(i5);
    }

    public void y(boolean z4) {
        this.f2815e.writeInt(z4 ? 1 : 0);
    }
}
