package g1;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.location.LocationRequest;
import i1.b;
import l1.g;
import u0.a;
import u0.e;
import w0.p;

public final class l extends e implements b {

    /* renamed from: k  reason: collision with root package name */
    static final a.g f4704k;

    /* renamed from: l  reason: collision with root package name */
    public static final a f4705l;

    static {
        a.g gVar = new a.g();
        f4704k = gVar;
        f4705l = new a("LocationServices.API", new i(), gVar);
    }

    public l(Context context) {
        super(context, f4705l, a.d.f7072a, e.a.f7085c);
    }

    private final g q(LocationRequest locationRequest, c cVar) {
        k kVar = new k(this, cVar, c.f4677a);
        return i(f.a().b(new d(kVar, locationRequest)).d(kVar).e(cVar).c(2436).a());
    }

    public final g<Location> b() {
        return h(com.google.android.gms.common.api.internal.g.a().b(g.f4688a).e(2414).a());
    }

    public final g<Void> d(i1.e eVar) {
        return j(d.b(eVar, i1.e.class.getSimpleName()), 2418).e(h.f4689e, f.f4686a);
    }

    public final g<Void> e(LocationRequest locationRequest, i1.e eVar, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            p.h(looper, "invalid null looper");
        }
        return q(locationRequest, d.a(eVar, looper, i1.e.class.getSimpleName()));
    }
}
