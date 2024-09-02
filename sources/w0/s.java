package w0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import x0.a;
import x0.c;

public class s extends a {
    public static final Parcelable.Creator<s> CREATOR = new x();

    /* renamed from: e  reason: collision with root package name */
    private final int f7435e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private List f7436f;

    public s(int i5, @Nullable List list) {
        this.f7435e = i5;
        this.f7436f = list;
    }

    public final int a() {
        return this.f7435e;
    }

    public final List b() {
        return this.f7436f;
    }

    public final void c(n nVar) {
        if (this.f7436f == null) {
            this.f7436f = new ArrayList();
        }
        this.f7436f.add(nVar);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f7435e);
        c.n(parcel, 2, this.f7436f, false);
        c.b(parcel, a5);
    }
}
