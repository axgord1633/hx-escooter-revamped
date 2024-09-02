package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0012a();

    /* renamed from: e  reason: collision with root package name */
    private final int f536e;

    /* renamed from: f  reason: collision with root package name */
    private final Intent f537f;

    /* renamed from: androidx.activity.result.a$a  reason: collision with other inner class name */
    class C0012a implements Parcelable.Creator<a> {
        C0012a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b */
        public a[] newArray(int i5) {
            return new a[i5];
        }
    }

    public a(int i5, Intent intent) {
        this.f536e = i5;
        this.f537f = intent;
    }

    a(Parcel parcel) {
        this.f536e = parcel.readInt();
        this.f537f = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String c(int i5) {
        return i5 != -1 ? i5 != 0 ? String.valueOf(i5) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f537f;
    }

    public int b() {
        return this.f536e;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f536e) + ", data=" + this.f537f + '}';
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f536e);
        parcel.writeInt(this.f537f == null ? 0 : 1);
        Intent intent = this.f537f;
        if (intent != null) {
            intent.writeToParcel(parcel, i5);
        }
    }
}
