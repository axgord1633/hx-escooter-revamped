package y0;

import android.content.Context;
import com.google.android.gms.common.api.internal.g;
import e1.f;
import l1.g;
import u0.a;
import u0.e;
import w0.s;
import w0.u;
import w0.v;

public final class d extends e implements u {

    /* renamed from: k  reason: collision with root package name */
    private static final a.g f7710k;

    /* renamed from: l  reason: collision with root package name */
    private static final a.C0113a f7711l;

    /* renamed from: m  reason: collision with root package name */
    private static final a f7712m;

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f7713n = 0;

    static {
        a.g gVar = new a.g();
        f7710k = gVar;
        c cVar = new c();
        f7711l = cVar;
        f7712m = new a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, v vVar) {
        super(context, f7712m, vVar, e.a.f7085c);
    }

    public final g<Void> a(s sVar) {
        g.a a5 = com.google.android.gms.common.api.internal.g.a();
        a5.d(f.f4493a);
        a5.c(false);
        a5.b(new b(sVar));
        return g(a5.a());
    }
}
