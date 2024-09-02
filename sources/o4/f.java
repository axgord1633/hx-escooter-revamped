package o4;

import i4.a0;
import i4.q;
import i4.s;
import i4.u;
import i4.v;
import i4.x;
import i4.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import l4.g;
import m4.c;
import m4.e;
import m4.i;
import m4.k;
import s4.h;
import s4.l;
import s4.r;

public final class f implements c {

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f6208f = j4.c.s("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f6209g = j4.c.s("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    private final s.a f6210a;

    /* renamed from: b  reason: collision with root package name */
    final g f6211b;

    /* renamed from: c  reason: collision with root package name */
    private final g f6212c;

    /* renamed from: d  reason: collision with root package name */
    private i f6213d;

    /* renamed from: e  reason: collision with root package name */
    private final v f6214e;

    class a extends h {

        /* renamed from: f  reason: collision with root package name */
        boolean f6215f = false;

        /* renamed from: g  reason: collision with root package name */
        long f6216g = 0;

        a(s4.s sVar) {
            super(sVar);
        }

        private void d(IOException iOException) {
            if (!this.f6215f) {
                this.f6215f = true;
                f fVar = f.this;
                fVar.f6211b.r(false, fVar, this.f6216g, iOException);
            }
        }

        public long K(s4.c cVar, long j5) {
            try {
                long K = b().K(cVar, j5);
                if (K > 0) {
                    this.f6216g += K;
                }
                return K;
            } catch (IOException e5) {
                d(e5);
                throw e5;
            }
        }

        public void close() {
            super.close();
            d((IOException) null);
        }
    }

    public f(u uVar, s.a aVar, g gVar, g gVar2) {
        this.f6210a = aVar;
        this.f6211b = gVar;
        this.f6212c = gVar2;
        List<v> u5 = uVar.u();
        v vVar = v.H2_PRIOR_KNOWLEDGE;
        this.f6214e = !u5.contains(vVar) ? v.HTTP_2 : vVar;
    }

    public static List<c> g(x xVar) {
        q d5 = xVar.d();
        ArrayList arrayList = new ArrayList(d5.g() + 4);
        arrayList.add(new c(c.f6177f, xVar.f()));
        arrayList.add(new c(c.f6178g, i.c(xVar.h())));
        String c5 = xVar.c("Host");
        if (c5 != null) {
            arrayList.add(new c(c.f6180i, c5));
        }
        arrayList.add(new c(c.f6179h, xVar.h().B()));
        int g5 = d5.g();
        for (int i5 = 0; i5 < g5; i5++) {
            s4.f o5 = s4.f.o(d5.e(i5).toLowerCase(Locale.US));
            if (!f6208f.contains(o5.B())) {
                arrayList.add(new c(o5, d5.h(i5)));
            }
        }
        return arrayList;
    }

    public static z.a h(q qVar, v vVar) {
        q.a aVar = new q.a();
        int g5 = qVar.g();
        k kVar = null;
        for (int i5 = 0; i5 < g5; i5++) {
            String e5 = qVar.e(i5);
            String h5 = qVar.h(i5);
            if (e5.equals(":status")) {
                kVar = k.a("HTTP/1.1 " + h5);
            } else if (!f6209g.contains(e5)) {
                j4.a.f5473a.b(aVar, e5, h5);
            }
        }
        if (kVar != null) {
            return new z.a().n(vVar).g(kVar.f5934b).k(kVar.f5935c).j(aVar.d());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public r a(x xVar, long j5) {
        return this.f6213d.j();
    }

    public void b() {
        this.f6213d.j().close();
    }

    public void c() {
        this.f6212c.flush();
    }

    public void cancel() {
        i iVar = this.f6213d;
        if (iVar != null) {
            iVar.h(b.CANCEL);
        }
    }

    public void d(x xVar) {
        if (this.f6213d == null) {
            i D = this.f6212c.D(g(xVar), xVar.a() != null);
            this.f6213d = D;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            D.n().g((long) this.f6210a.c(), timeUnit);
            this.f6213d.u().g((long) this.f6210a.d(), timeUnit);
        }
    }

    public a0 e(z zVar) {
        g gVar = this.f6211b;
        gVar.f5807f.q(gVar.f5806e);
        return new m4.h(zVar.g("Content-Type"), e.b(zVar), l.b(new a(this.f6213d.k())));
    }

    public z.a f(boolean z4) {
        z.a h5 = h(this.f6213d.s(), this.f6214e);
        if (!z4 || j4.a.f5473a.d(h5) != 100) {
            return h5;
        }
        return null;
    }
}
