package i1;

import android.os.Parcel;
import android.os.Parcelable;
import g1.b0;
import g1.j0;
import org.checkerframework.dataflow.qual.Pure;
import w0.o;
import x0.c;

public final class d extends x0.a {
    public static final Parcelable.Creator<d> CREATOR = new a0();

    /* renamed from: e  reason: collision with root package name */
    private final long f4906e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4907f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4908g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4909h;

    /* renamed from: i  reason: collision with root package name */
    private final b0 f4910i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f4911a = Long.MAX_VALUE;

        /* renamed from: b  reason: collision with root package name */
        private int f4912b = 0;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4913c = false;

        /* renamed from: d  reason: collision with root package name */
        private String f4914d = null;

        /* renamed from: e  reason: collision with root package name */
        private b0 f4915e = null;

        public d a() {
            return new d(this.f4911a, this.f4912b, this.f4913c, this.f4914d, this.f4915e);
        }
    }

    d(long j5, int i5, boolean z4, String str, b0 b0Var) {
        this.f4906e = j5;
        this.f4907f = i5;
        this.f4908g = z4;
        this.f4909h = str;
        this.f4910i = b0Var;
    }

    @Pure
    public int a() {
        return this.f4907f;
    }

    @Pure
    public long b() {
        return this.f4906e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4906e == dVar.f4906e && this.f4907f == dVar.f4907f && this.f4908g == dVar.f4908g && o.a(this.f4909h, dVar.f4909h) && o.a(this.f4910i, dVar.f4910i);
    }

    public int hashCode() {
        return o.b(Long.valueOf(this.f4906e), Integer.valueOf(this.f4907f), Boolean.valueOf(this.f4908g));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LastLocationRequest[");
        if (this.f4906e != Long.MAX_VALUE) {
            sb.append("maxAge=");
            j0.b(this.f4906e, sb);
        }
        if (this.f4907f != 0) {
            sb.append(", ");
            sb.append(t.b(this.f4907f));
        }
        if (this.f4908g) {
            sb.append(", bypass");
        }
        if (this.f4909h != null) {
            sb.append(", moduleId=");
            sb.append(this.f4909h);
        }
        if (this.f4910i != null) {
            sb.append(", impersonation=");
            sb.append(this.f4910i);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, b());
        c.g(parcel, 2, a());
        c.c(parcel, 3, this.f4908g);
        c.k(parcel, 4, this.f4909h, false);
        c.j(parcel, 5, this.f4910i, i5, false);
        c.b(parcel, a5);
    }
}
