package i1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x0.c;

public final class g extends x0.a {
    public static final Parcelable.Creator<g> CREATOR = new b0();

    /* renamed from: e  reason: collision with root package name */
    private final List f4920e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4921f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4922g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f4923a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private boolean f4924b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4925c = false;

        public a a(LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.f4923a.add(locationRequest);
            }
            return this;
        }

        public g b() {
            return new g(this.f4923a, this.f4924b, this.f4925c);
        }
    }

    g(List list, boolean z4, boolean z5) {
        this.f4920e = list;
        this.f4921f = z4;
        this.f4922g = z5;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.n(parcel, 1, Collections.unmodifiableList(this.f4920e), false);
        c.c(parcel, 2, this.f4921f);
        c.c(parcel, 3, this.f4922g);
        c.b(parcel, a5);
    }
}
