package w1;

import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.TimeUnit;
import m2.k;
import m2.n;
import m2.o;
import m2.q;
import y1.d0;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    final q f7455a;

    /* renamed from: b  reason: collision with root package name */
    final o<q, q> f7456b;

    /* renamed from: c  reason: collision with root package name */
    final o<q, q> f7457c = new e();

    /* renamed from: d  reason: collision with root package name */
    private final o<q, q> f7458d = new g();

    class a implements o<q, q> {

        /* renamed from: a  reason: collision with root package name */
        final r2.f<q, q> f7459a = a0.g();

        /* renamed from: b  reason: collision with root package name */
        final k<Long> f7460b;

        /* renamed from: c  reason: collision with root package name */
        final r2.f<q, k<?>> f7461c;

        /* renamed from: d  reason: collision with root package name */
        final r2.f<k<q>, k<q>> f7462d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ q f7463e;

        /* renamed from: w1.a0$a$a  reason: collision with other inner class name */
        class C0120a implements r2.f<q, k<?>> {
            C0120a() {
            }

            /* renamed from: a */
            public k<?> apply(q qVar) {
                return a.this.f7460b;
            }
        }

        class b implements r2.f<k<q>, k<q>> {
            b() {
            }

            /* renamed from: a */
            public k<q> apply(k<q> kVar) {
                return kVar.B0(1);
            }
        }

        class c implements r2.f<k<q>, n<q>> {
            c() {
            }

            /* renamed from: a */
            public n<q> apply(k<q> kVar) {
                return kVar.L0(kVar.y0(a.this.f7461c)).M(a.this.f7462d).Z(a.this.f7459a);
            }
        }

        a(q qVar) {
            this.f7463e = qVar;
            this.f7460b = k.J0(10, TimeUnit.SECONDS, qVar);
            this.f7461c = new C0120a();
            this.f7462d = new b();
        }

        /* renamed from: b */
        public k<q> a(k<q> kVar) {
            return kVar.j0(new c());
        }
    }

    class b implements o<q, q> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7468a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f7469b;

        class a implements r2.f<k<Object>, n<?>> {
            a() {
            }

            /* renamed from: a */
            public n<?> apply(k<Object> kVar) {
                b bVar = b.this;
                return kVar.q(bVar.f7469b, TimeUnit.MILLISECONDS, a0.this.f7455a);
            }
        }

        b(int i5, long j5) {
            this.f7468a = i5;
            this.f7469b = j5;
        }

        /* renamed from: b */
        public k<q> a(k<q> kVar) {
            return kVar.C0((long) this.f7468a, TimeUnit.MILLISECONDS, a0.this.f7455a).k0(new a());
        }
    }

    class c implements o<q, q> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f7472a;

        class a implements r2.f<h3.b<String, q>, k<q>> {
            a() {
            }

            /* renamed from: a */
            public k<q> apply(h3.b<String, q> bVar) {
                return bVar.j(c.this.f7472a);
            }
        }

        class b implements r2.f<q, String> {
            b() {
            }

            /* renamed from: a */
            public String apply(q qVar) {
                return qVar.d().getAddress();
            }
        }

        c(o oVar) {
            this.f7472a = oVar;
        }

        /* renamed from: b */
        public k<q> a(k<q> kVar) {
            return kVar.U(new b()).M(new a());
        }
    }

    class d implements r2.f<q, q> {
        d() {
        }

        /* renamed from: a */
        public q apply(q qVar) {
            return new q(qVar.d(), qVar.e(), qVar.g(), qVar.b(), z1.c.CALLBACK_TYPE_FIRST_MATCH, qVar.h());
        }
    }

    class e implements o<q, q> {
        e() {
        }

        /* renamed from: b */
        public k<q> a(k<q> kVar) {
            return kVar.n(10, TimeUnit.SECONDS, a0.this.f7455a).Z(a0.h());
        }
    }

    class f implements r2.f<q, q> {
        f() {
        }

        /* renamed from: a */
        public q apply(q qVar) {
            return new q(qVar.d(), qVar.e(), qVar.g(), qVar.b(), z1.c.CALLBACK_TYPE_MATCH_LOST, qVar.h());
        }
    }

    class g implements o<q, q> {

        class a implements r2.f<k<q>, k<q>> {
            a() {
            }

            /* renamed from: a */
            public k<q> apply(k<q> kVar) {
                return k.a0(kVar.j(a0.this.f7456b), kVar.j(a0.this.f7457c));
            }
        }

        g() {
        }

        /* renamed from: b */
        public k<q> a(k<q> kVar) {
            return kVar.j0(new a());
        }
    }

    public a0(q qVar) {
        this.f7455a = qVar;
        this.f7456b = new a(qVar);
    }

    private o<q, q> c(int i5) {
        return new b(i5, Math.max(TimeUnit.SECONDS.toMillis(5) - ((long) i5), 0));
    }

    private o<q, q> d() {
        return c(2500);
    }

    private o<q, q> e() {
        return c(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
    }

    private static o<q, q> f(o<q, q> oVar) {
        return new c(oVar);
    }

    static r2.f<q, q> g() {
        return new d();
    }

    static r2.f<q, q> h() {
        return new f();
    }

    /* access modifiers changed from: package-private */
    public o<q, q> a(int i5) {
        o<q, q> oVar;
        if (i5 == 2) {
            oVar = this.f7456b;
        } else if (i5 == 4) {
            oVar = this.f7457c;
        } else if (i5 != 6) {
            return d0.a();
        } else {
            oVar = this.f7458d;
        }
        return f(oVar);
    }

    /* access modifiers changed from: package-private */
    public o<q, q> b(int i5) {
        if (i5 == -1) {
            r1.q.q("Cannot emulate opportunistic scan mode since it is OS dependent - fallthrough to low power", new Object[0]);
        } else if (i5 != 0) {
            return i5 != 1 ? d0.a() : d();
        }
        return e();
    }
}
