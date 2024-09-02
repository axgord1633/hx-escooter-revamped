package y1;

import java.util.concurrent.TimeUnit;
import m2.k;
import m2.p;
import m2.q;
import p1.e0;
import p1.g0;
import r2.f;
import r2.h;

public class r extends k<g0.a> {

    /* renamed from: e  reason: collision with root package name */
    final f0 f7769e;

    /* renamed from: f  reason: collision with root package name */
    final k<e0.b> f7770f;

    /* renamed from: g  reason: collision with root package name */
    final k<Boolean> f7771g;

    /* renamed from: h  reason: collision with root package name */
    private final w f7772h;

    /* renamed from: i  reason: collision with root package name */
    private final q f7773i;

    class a implements f<Long, Boolean> {
        a() {
        }

        /* renamed from: a */
        public Boolean apply(Long l5) {
            return Boolean.valueOf(l5.longValue() == 0);
        }
    }

    class b implements h<Long> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w f7774e;

        b(w wVar) {
            this.f7774e = wVar;
        }

        /* renamed from: a */
        public boolean test(Long l5) {
            return !this.f7774e.a();
        }
    }

    class c implements f<e0.b, k<g0.a>> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f7775e;

        class a implements f<Boolean, g0.a> {
            a() {
            }

            /* renamed from: a */
            public g0.a apply(Boolean bool) {
                return bool.booleanValue() ? g0.a.READY : g0.a.LOCATION_SERVICES_NOT_ENABLED;
            }
        }

        c(k kVar) {
            this.f7775e = kVar;
        }

        /* renamed from: a */
        public k<g0.a> apply(e0.b bVar) {
            return bVar != e0.b.f6447c ? k.Y(g0.a.BLUETOOTH_NOT_ENABLED) : this.f7775e.Z(new a());
        }
    }

    class d implements f<Boolean, k<g0.a>> {
        d() {
        }

        /* renamed from: a */
        public k<g0.a> apply(Boolean bool) {
            r rVar = r.this;
            k<g0.a> t5 = r.O0(rVar.f7769e, rVar.f7770f, rVar.f7771g).t();
            return bool.booleanValue() ? t5.q0(1) : t5;
        }
    }

    protected r(f0 f0Var, k<e0.b> kVar, k<Boolean> kVar2, w wVar, q qVar) {
        this.f7769e = f0Var;
        this.f7770f = kVar;
        this.f7771g = kVar2;
        this.f7772h = wVar;
        this.f7773i = qVar;
    }

    static k<g0.a> O0(f0 f0Var, k<e0.b> kVar, k<Boolean> kVar2) {
        return kVar.r0(f0Var.c() ? e0.b.f6447c : e0.b.f6448d).y0(new c(kVar2));
    }

    private static m2.r<Boolean> P0(w wVar, q qVar) {
        return k.X(0, 1, TimeUnit.SECONDS, qVar).F0(new b(wVar)).l().v(new a());
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super g0.a> pVar) {
        if (!this.f7769e.b()) {
            pVar.c(p2.d.b());
            pVar.a();
            return;
        }
        P0(this.f7772h, this.f7773i).s(new d()).g(pVar);
    }
}
