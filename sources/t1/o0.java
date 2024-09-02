package t1;

import m2.k;
import p2.g;
import q1.l;
import r2.e;
import r2.h;

class o0 implements m, n0, e<Integer> {

    /* renamed from: e  reason: collision with root package name */
    private Integer f6973e;

    /* renamed from: f  reason: collision with root package name */
    private final k<Integer> f6974f;

    /* renamed from: g  reason: collision with root package name */
    private final g f6975g = new g();

    class a implements h<Throwable> {
        a() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) {
            return (th instanceof q1.k) && ((q1.k) th).b() == l.f6647l;
        }
    }

    o0(i1 i1Var, int i5) {
        this.f6974f = i1Var.g().o0(new a());
        this.f6973e = Integer.valueOf(i5);
    }

    /* renamed from: a */
    public void accept(Integer num) {
        this.f6973e = num;
    }

    public void b() {
        this.f6975g.dispose();
    }

    public void c() {
        this.f6975g.a(this.f6974f.t0(this, t2.a.d()));
    }
}
