package p1;

import android.content.Context;
import android.location.LocationManager;
import g0.c;
import g0.e;
import h0.a;
import p1.a;

public final class r implements c<LocationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f6521a;

    public r(a<Context> aVar) {
        this.f6521a = aVar;
    }

    public static r a(a<Context> aVar) {
        return new r(aVar);
    }

    public static LocationManager c(Context context) {
        return (LocationManager) e.d(a.c.q(context));
    }

    /* renamed from: b */
    public LocationManager get() {
        return c(this.f6521a.get());
    }
}
