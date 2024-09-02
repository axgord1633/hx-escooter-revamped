package t1;

import m2.k;
import m2.n;
import p1.e0;
import r1.q;
import r2.h;
import y1.f0;

class y implements z {

    /* renamed from: a  reason: collision with root package name */
    private final o1.b<q1.f> f7018a;

    /* renamed from: b  reason: collision with root package name */
    private final k<q1.f> f7019b;

    /* renamed from: c  reason: collision with root package name */
    private final k<Object> f7020c;

    class a implements r2.e<Throwable> {
        a() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            q.e(th, "Failed to monitor adapter state.", new Object[0]);
        }
    }

    class b implements r2.e<q1.f> {
        b() {
        }

        /* renamed from: a */
        public void accept(q1.f fVar) {
            q.p("An exception received, indicating that the adapter has became unusable.", new Object[0]);
        }
    }

    class c implements r2.f<Boolean, q1.f> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f7023e;

        c(String str) {
            this.f7023e = str;
        }

        /* renamed from: a */
        public q1.f apply(Boolean bool) {
            return q1.e.a(this.f7023e);
        }
    }

    class d implements r2.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p2.c f7025a;

        d(p2.c cVar) {
            this.f7025a = cVar;
        }

        public void run() {
            this.f7025a.dispose();
        }
    }

    class e implements r2.f<q1.f, n<?>> {
        e() {
        }

        /* renamed from: a */
        public n<?> apply(q1.f fVar) {
            return k.G(fVar);
        }
    }

    class f implements h<Boolean> {
        f() {
        }

        /* renamed from: a */
        public boolean test(Boolean bool) {
            return !bool.booleanValue();
        }
    }

    class g implements r2.f<e0.b, Boolean> {
        g() {
        }

        /* renamed from: a */
        public Boolean apply(e0.b bVar) {
            return Boolean.valueOf(bVar.a());
        }
    }

    y(String str, f0 f0Var, k<e0.b> kVar) {
        o1.b<q1.f> R0 = o1.b.R0();
        this.f7018a = R0;
        k<q1.f> O0 = R0.K().h().B(new d(c(f0Var, kVar).Z(new c(str)).z(new b()).t0(R0, new a()))).l0().O0(0);
        this.f7019b = O0;
        this.f7020c = O0.M(new e());
    }

    private static k<Boolean> c(f0 f0Var, k<e0.b> kVar) {
        return kVar.Z(new g()).r0(Boolean.valueOf(f0Var.c())).I(new f());
    }

    public k<q1.f> a() {
        return this.f7019b;
    }

    public <T> k<T> b() {
        return this.f7020c;
    }

    public void d(q1.e eVar) {
        this.f7018a.accept(eVar);
    }

    public void e(q1.k kVar) {
        this.f7018a.accept(kVar);
    }
}
