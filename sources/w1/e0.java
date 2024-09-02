package w1;

import m2.k;
import m2.o;
import v1.q;
import y1.f0;
import z1.d;
import z1.g;

public class e0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final f0 f7491a;

    /* renamed from: b  reason: collision with root package name */
    private final g f7492b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f7493c;

    class a implements o<q, q> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f7494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f7495b;

        a(o oVar, o oVar2) {
            this.f7494a = oVar;
            this.f7495b = oVar2;
        }

        /* renamed from: b */
        public k<q> a(k<q> kVar) {
            return kVar.j(this.f7494a).j(this.f7495b);
        }
    }

    e0(f0 f0Var, g gVar, a0 a0Var) {
        this.f7491a = f0Var;
        this.f7492b = gVar;
        this.f7493c = a0Var;
    }

    public c0 a(g gVar, d... dVarArr) {
        return new c0(new q(this.f7491a, this.f7492b, new f(dVarArr)), new a(this.f7493c.b(gVar.g()), this.f7493c.a(gVar.b())));
    }
}
