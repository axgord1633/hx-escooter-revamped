package k4;

import i4.a0;
import i4.q;
import i4.s;
import i4.v;
import i4.x;
import i4.z;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import k4.c;
import m4.f;
import m4.h;
import s4.c;
import s4.d;
import s4.e;
import s4.l;
import s4.r;
import s4.t;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    final d f5530a;

    /* renamed from: k4.a$a  reason: collision with other inner class name */
    class C0085a implements s4.s {

        /* renamed from: e  reason: collision with root package name */
        boolean f5531e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ e f5532f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f5533g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ d f5534h;

        C0085a(e eVar, b bVar, d dVar) {
            this.f5532f = eVar;
            this.f5533g = bVar;
            this.f5534h = dVar;
        }

        public long K(c cVar, long j5) {
            try {
                long K = this.f5532f.K(cVar, j5);
                if (K == -1) {
                    if (!this.f5531e) {
                        this.f5531e = true;
                        this.f5534h.close();
                    }
                    return -1;
                }
                cVar.g(this.f5534h.a(), cVar.size() - K, K);
                this.f5534h.y();
                return K;
            } catch (IOException e5) {
                if (!this.f5531e) {
                    this.f5531e = true;
                    this.f5533g.b();
                }
                throw e5;
            }
        }

        public t c() {
            return this.f5532f.c();
        }

        public void close() {
            if (!this.f5531e && !j4.c.n(this, 100, TimeUnit.MILLISECONDS)) {
                this.f5531e = true;
                this.f5533g.b();
            }
            this.f5532f.close();
        }
    }

    public a(d dVar) {
        this.f5530a = dVar;
    }

    private z b(b bVar, z zVar) {
        r a5;
        if (bVar == null || (a5 = bVar.a()) == null) {
            return zVar;
        }
        C0085a aVar = new C0085a(zVar.b().f(), bVar, l.a(a5));
        return zVar.l().b(new h(zVar.g("Content-Type"), zVar.b().b(), l.b(aVar))).c();
    }

    private static q c(q qVar, q qVar2) {
        q.a aVar = new q.a();
        int g5 = qVar.g();
        for (int i5 = 0; i5 < g5; i5++) {
            String e5 = qVar.e(i5);
            String h5 = qVar.h(i5);
            if ((!"Warning".equalsIgnoreCase(e5) || !h5.startsWith("1")) && (d(e5) || !e(e5) || qVar2.c(e5) == null)) {
                j4.a.f5473a.b(aVar, e5, h5);
            }
        }
        int g6 = qVar2.g();
        for (int i6 = 0; i6 < g6; i6++) {
            String e6 = qVar2.e(i6);
            if (!d(e6) && e(e6)) {
                j4.a.f5473a.b(aVar, e6, qVar2.h(i6));
            }
        }
        return aVar.d();
    }

    static boolean d(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean e(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    private static z f(z zVar) {
        return (zVar == null || zVar.b() == null) ? zVar : zVar.l().b((a0) null).c();
    }

    public z a(s.a aVar) {
        d dVar = this.f5530a;
        z c5 = dVar != null ? dVar.c(aVar.e()) : null;
        c c6 = new c.a(System.currentTimeMillis(), aVar.e(), c5).c();
        x xVar = c6.f5536a;
        z zVar = c6.f5537b;
        d dVar2 = this.f5530a;
        if (dVar2 != null) {
            dVar2.e(c6);
        }
        if (c5 != null && zVar == null) {
            j4.c.e(c5.b());
        }
        if (xVar == null && zVar == null) {
            return new z.a().p(aVar.e()).n(v.HTTP_1_1).g(504).k("Unsatisfiable Request (only-if-cached)").b(j4.c.f5477c).q(-1).o(System.currentTimeMillis()).c();
        }
        if (xVar == null) {
            return zVar.l().d(f(zVar)).c();
        }
        try {
            z b5 = aVar.b(xVar);
            if (b5 == null && c5 != null) {
            }
            if (zVar != null) {
                if (b5.e() == 304) {
                    z c7 = zVar.l().j(c(zVar.j(), b5.j())).q(b5.q()).o(b5.n()).d(f(zVar)).l(f(b5)).c();
                    b5.b().close();
                    this.f5530a.b();
                    this.f5530a.f(zVar, c7);
                    return c7;
                }
                j4.c.e(zVar.b());
            }
            z c8 = b5.l().d(f(zVar)).l(f(b5)).c();
            if (this.f5530a != null) {
                if (m4.e.c(c8) && c.a(c8, xVar)) {
                    return b(this.f5530a.a(c8), c8);
                }
                if (f.a(xVar.f())) {
                    try {
                        this.f5530a.d(xVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return c8;
        } finally {
            if (c5 != null) {
                j4.c.e(c5.b());
            }
        }
    }
}
