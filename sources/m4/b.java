package m4;

import i4.a0;
import i4.s;
import i4.x;
import i4.z;
import java.net.ProtocolException;
import s4.c;
import s4.d;
import s4.g;
import s4.l;
import s4.r;

public final class b implements s {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5906a;

    static final class a extends g {

        /* renamed from: f  reason: collision with root package name */
        long f5907f;

        a(r rVar) {
            super(rVar);
        }

        public void G(c cVar, long j5) {
            super.G(cVar, j5);
            this.f5907f += j5;
        }
    }

    public b(boolean z4) {
        this.f5906a = z4;
    }

    public z a(s.a aVar) {
        z.a aVar2;
        a0 a0Var;
        g gVar = (g) aVar;
        c i5 = gVar.i();
        l4.g k5 = gVar.k();
        l4.c cVar = (l4.c) gVar.g();
        x e5 = gVar.e();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.h().o(gVar.f());
        i5.d(e5);
        gVar.h().n(gVar.f(), e5);
        z.a aVar3 = null;
        if (f.b(e5.f()) && e5.a() != null) {
            if ("100-continue".equalsIgnoreCase(e5.c("Expect"))) {
                i5.c();
                gVar.h().s(gVar.f());
                aVar3 = i5.f(true);
            }
            if (aVar3 == null) {
                gVar.h().m(gVar.f());
                a aVar4 = new a(i5.a(e5, e5.a().a()));
                d a5 = l.a(aVar4);
                e5.a().e(a5);
                a5.close();
                gVar.h().l(gVar.f(), aVar4.f5907f);
            } else if (!cVar.n()) {
                k5.j();
            }
        }
        i5.b();
        if (aVar3 == null) {
            gVar.h().s(gVar.f());
            aVar3 = i5.f(false);
        }
        z c5 = aVar3.p(e5).h(k5.d().k()).q(currentTimeMillis).o(System.currentTimeMillis()).c();
        int e6 = c5.e();
        if (e6 == 100) {
            c5 = i5.f(false).p(e5).h(k5.d().k()).q(currentTimeMillis).o(System.currentTimeMillis()).c();
            e6 = c5.e();
        }
        gVar.h().r(gVar.f(), c5);
        if (!this.f5906a || e6 != 101) {
            aVar2 = c5.l();
            a0Var = i5.e(c5);
        } else {
            aVar2 = c5.l();
            a0Var = j4.c.f5477c;
        }
        z c6 = aVar2.b(a0Var).c();
        if ("close".equalsIgnoreCase(c6.p().c("Connection")) || "close".equalsIgnoreCase(c6.g("Connection"))) {
            k5.j();
        }
        if ((e6 != 204 && e6 != 205) || c6.b().b() <= 0) {
            return c6;
        }
        throw new ProtocolException("HTTP " + e6 + " had non-zero Content-Length: " + c6.b().b());
    }
}
