package g1;

import a1.f;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.location.LocationRequest;
import java.util.Iterator;
import java.util.List;
import w0.d;
import w0.o;
import x0.a;
import x0.c;

@Deprecated
public final class f0 extends a {
    public static final Parcelable.Creator<f0> CREATOR = new g0();

    /* renamed from: e  reason: collision with root package name */
    LocationRequest f4687e;

    f0(LocationRequest locationRequest, List list, boolean z4, boolean z5, String str, boolean z6, boolean z7, String str2, long j5) {
        WorkSource workSource;
        LocationRequest.a aVar = new LocationRequest.a(locationRequest);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    f.a(workSource, dVar.f7322e, dVar.f7323f);
                }
            }
            aVar.l(workSource);
        }
        if (z4) {
            aVar.b(1);
        }
        if (z5) {
            aVar.k(2);
        }
        if (str != null) {
            aVar.j(str);
        } else if (str2 != null) {
            aVar.j(str2);
        }
        if (z6) {
            aVar.i(true);
        }
        if (z7) {
            aVar.h(true);
        }
        if (j5 != Long.MAX_VALUE) {
            aVar.d(j5);
        }
        this.f4687e = aVar.a();
    }

    @Deprecated
    public static f0 a(String str, LocationRequest locationRequest) {
        return new f0(locationRequest, (List) null, false, false, (String) null, false, false, (String) null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f0) {
            return o.a(this.f4687e, ((f0) obj).f4687e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4687e.hashCode();
    }

    public final String toString() {
        return this.f4687e.toString();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.j(parcel, 1, this.f4687e, i5, false);
        c.b(parcel, a5);
    }
}
