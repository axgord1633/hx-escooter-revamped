package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new b();

    /* renamed from: i  reason: collision with root package name */
    public static final c f538i = new c((g) null);

    /* renamed from: e  reason: collision with root package name */
    private final IntentSender f539e;

    /* renamed from: f  reason: collision with root package name */
    private final Intent f540f;

    /* renamed from: g  reason: collision with root package name */
    private final int f541g;

    /* renamed from: h  reason: collision with root package name */
    private final int f542h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final IntentSender f543a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f544b;

        /* renamed from: c  reason: collision with root package name */
        private int f545c;

        /* renamed from: d  reason: collision with root package name */
        private int f546d;

        public a(IntentSender intentSender) {
            k.e(intentSender, "intentSender");
            this.f543a = intentSender;
        }

        public final e a() {
            return new e(this.f543a, this.f544b, this.f545c, this.f546d);
        }

        public final a b(Intent intent) {
            this.f544b = intent;
            return this;
        }

        public final a c(int i5, int i6) {
            this.f546d = i5;
            this.f545c = i6;
            return this;
        }
    }

    public static final class b implements Parcelable.Creator<e> {
        b() {
        }

        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            k.e(parcel, "inParcel");
            return new e(parcel);
        }

        /* renamed from: b */
        public e[] newArray(int i5) {
            return new e[i5];
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    public e(IntentSender intentSender, Intent intent, int i5, int i6) {
        k.e(intentSender, "intentSender");
        this.f539e = intentSender;
        this.f540f = intent;
        this.f541g = i5;
        this.f542h = i6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.k.e(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            kotlin.jvm.internal.k.b(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.e.<init>(android.os.Parcel):void");
    }

    public final Intent a() {
        return this.f540f;
    }

    public final int b() {
        return this.f541g;
    }

    public final int c() {
        return this.f542h;
    }

    public final IntentSender d() {
        return this.f539e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        k.e(parcel, "dest");
        parcel.writeParcelable(this.f539e, i5);
        parcel.writeParcelable(this.f540f, i5);
        parcel.writeInt(this.f541g);
        parcel.writeInt(this.f542h);
    }
}
