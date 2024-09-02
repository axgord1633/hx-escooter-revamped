package g1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import java.util.Arrays;
import java.util.List;
import x0.a;
import x0.c;

public final class b0 extends a {
    public static final Parcelable.Creator<b0> CREATOR = new w0();

    /* renamed from: e  reason: collision with root package name */
    private final int f4669e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4670f;

    /* renamed from: g  reason: collision with root package name */
    private final String f4671g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4672h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4673i;

    /* renamed from: j  reason: collision with root package name */
    private final String f4674j;

    /* renamed from: k  reason: collision with root package name */
    private final b0 f4675k;

    /* renamed from: l  reason: collision with root package name */
    private final List f4676l;

    static {
        Process.myUid();
        Process.myPid();
    }

    b0(int i5, int i6, String str, String str2, String str3, int i7, List list, b0 b0Var) {
        this.f4669e = i5;
        this.f4670f = i6;
        this.f4671g = str;
        this.f4672h = str2;
        this.f4674j = str3;
        this.f4673i = i7;
        this.f4676l = s0.q(list);
        this.f4675k = b0Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            return this.f4669e == b0Var.f4669e && this.f4670f == b0Var.f4670f && this.f4673i == b0Var.f4673i && this.f4671g.equals(b0Var.f4671g) && l0.a(this.f4672h, b0Var.f4672h) && l0.a(this.f4674j, b0Var.f4674j) && l0.a(this.f4675k, b0Var.f4675k) && this.f4676l.equals(b0Var.f4676l);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4669e), this.f4671g, this.f4672h, this.f4674j});
    }

    public final String toString() {
        int length = this.f4671g.length() + 18;
        String str = this.f4672h;
        if (str != null) {
            length += str.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(this.f4669e);
        sb.append("/");
        sb.append(this.f4671g);
        if (this.f4672h != null) {
            sb.append("[");
            if (this.f4672h.startsWith(this.f4671g)) {
                sb.append(this.f4672h, this.f4671g.length(), this.f4672h.length());
            } else {
                sb.append(this.f4672h);
            }
            sb.append("]");
        }
        if (this.f4674j != null) {
            sb.append("/");
            sb.append(Integer.toHexString(this.f4674j.hashCode()));
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f4669e);
        c.g(parcel, 2, this.f4670f);
        c.k(parcel, 3, this.f4671g, false);
        c.k(parcel, 4, this.f4672h, false);
        c.g(parcel, 5, this.f4673i);
        c.k(parcel, 6, this.f4674j, false);
        c.j(parcel, 7, this.f4675k, i5, false);
        c.n(parcel, 8, this.f4676l, false);
        c.b(parcel, a5);
    }
}
