package n4;

import i4.a0;
import i4.q;
import i4.u;
import i4.x;
import i4.z;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import m4.h;
import m4.k;
import s4.i;
import s4.l;
import s4.r;
import s4.s;
import s4.t;

public final class a implements m4.c {

    /* renamed from: a  reason: collision with root package name */
    final u f6082a;

    /* renamed from: b  reason: collision with root package name */
    final l4.g f6083b;

    /* renamed from: c  reason: collision with root package name */
    final s4.e f6084c;

    /* renamed from: d  reason: collision with root package name */
    final s4.d f6085d;

    /* renamed from: e  reason: collision with root package name */
    int f6086e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f6087f = 262144;

    private abstract class b implements s {

        /* renamed from: e  reason: collision with root package name */
        protected final i f6088e;

        /* renamed from: f  reason: collision with root package name */
        protected boolean f6089f;

        /* renamed from: g  reason: collision with root package name */
        protected long f6090g;

        private b() {
            this.f6088e = new i(a.this.f6084c.c());
            this.f6090g = 0;
        }

        public long K(s4.c cVar, long j5) {
            try {
                long K = a.this.f6084c.K(cVar, j5);
                if (K > 0) {
                    this.f6090g += K;
                }
                return K;
            } catch (IOException e5) {
                b(false, e5);
                throw e5;
            }
        }

        /* access modifiers changed from: protected */
        public final void b(boolean z4, IOException iOException) {
            a aVar = a.this;
            int i5 = aVar.f6086e;
            if (i5 != 6) {
                if (i5 == 5) {
                    aVar.g(this.f6088e);
                    a aVar2 = a.this;
                    aVar2.f6086e = 6;
                    l4.g gVar = aVar2.f6083b;
                    if (gVar != null) {
                        gVar.r(!z4, aVar2, this.f6090g, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + a.this.f6086e);
            }
        }

        public t c() {
            return this.f6088e;
        }
    }

    private final class c implements r {

        /* renamed from: e  reason: collision with root package name */
        private final i f6092e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6093f;

        c() {
            this.f6092e = new i(a.this.f6085d.c());
        }

        public void G(s4.c cVar, long j5) {
            if (this.f6093f) {
                throw new IllegalStateException("closed");
            } else if (j5 != 0) {
                a.this.f6085d.i(j5);
                a.this.f6085d.I("\r\n");
                a.this.f6085d.G(cVar, j5);
                a.this.f6085d.I("\r\n");
            }
        }

        public t c() {
            return this.f6092e;
        }

        public synchronized void close() {
            if (!this.f6093f) {
                this.f6093f = true;
                a.this.f6085d.I("0\r\n\r\n");
                a.this.g(this.f6092e);
                a.this.f6086e = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f6093f) {
                a.this.f6085d.flush();
            }
        }
    }

    private class d extends b {

        /* renamed from: i  reason: collision with root package name */
        private final i4.r f6095i;

        /* renamed from: j  reason: collision with root package name */
        private long f6096j = -1;

        /* renamed from: k  reason: collision with root package name */
        private boolean f6097k = true;

        d(i4.r rVar) {
            super();
            this.f6095i = rVar;
        }

        private void d() {
            if (this.f6096j != -1) {
                a.this.f6084c.r();
            }
            try {
                this.f6096j = a.this.f6084c.L();
                String trim = a.this.f6084c.r().trim();
                if (this.f6096j < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f6096j + trim + "\"");
                } else if (this.f6096j == 0) {
                    this.f6097k = false;
                    m4.e.e(a.this.f6082a.h(), this.f6095i, a.this.n());
                    b(true, (IOException) null);
                }
            } catch (NumberFormatException e5) {
                throw new ProtocolException(e5.getMessage());
            }
        }

        public long K(s4.c cVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f6089f) {
                throw new IllegalStateException("closed");
            } else if (!this.f6097k) {
                return -1;
            } else {
                long j6 = this.f6096j;
                if (j6 == 0 || j6 == -1) {
                    d();
                    if (!this.f6097k) {
                        return -1;
                    }
                }
                long K = super.K(cVar, Math.min(j5, this.f6096j));
                if (K != -1) {
                    this.f6096j -= K;
                    return K;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b(false, protocolException);
                throw protocolException;
            }
        }

        public void close() {
            if (!this.f6089f) {
                if (this.f6097k && !j4.c.n(this, 100, TimeUnit.MILLISECONDS)) {
                    b(false, (IOException) null);
                }
                this.f6089f = true;
            }
        }
    }

    private final class e implements r {

        /* renamed from: e  reason: collision with root package name */
        private final i f6099e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6100f;

        /* renamed from: g  reason: collision with root package name */
        private long f6101g;

        e(long j5) {
            this.f6099e = new i(a.this.f6085d.c());
            this.f6101g = j5;
        }

        public void G(s4.c cVar, long j5) {
            if (!this.f6100f) {
                j4.c.d(cVar.size(), 0, j5);
                if (j5 <= this.f6101g) {
                    a.this.f6085d.G(cVar, j5);
                    this.f6101g -= j5;
                    return;
                }
                throw new ProtocolException("expected " + this.f6101g + " bytes but received " + j5);
            }
            throw new IllegalStateException("closed");
        }

        public t c() {
            return this.f6099e;
        }

        public void close() {
            if (!this.f6100f) {
                this.f6100f = true;
                if (this.f6101g <= 0) {
                    a.this.g(this.f6099e);
                    a.this.f6086e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() {
            if (!this.f6100f) {
                a.this.f6085d.flush();
            }
        }
    }

    private class f extends b {

        /* renamed from: i  reason: collision with root package name */
        private long f6103i;

        f(long j5) {
            super();
            this.f6103i = j5;
            if (j5 == 0) {
                b(true, (IOException) null);
            }
        }

        public long K(s4.c cVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (!this.f6089f) {
                long j6 = this.f6103i;
                if (j6 == 0) {
                    return -1;
                }
                long K = super.K(cVar, Math.min(j6, j5));
                if (K != -1) {
                    long j7 = this.f6103i - K;
                    this.f6103i = j7;
                    if (j7 == 0) {
                        b(true, (IOException) null);
                    }
                    return K;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() {
            if (!this.f6089f) {
                if (this.f6103i != 0 && !j4.c.n(this, 100, TimeUnit.MILLISECONDS)) {
                    b(false, (IOException) null);
                }
                this.f6089f = true;
            }
        }
    }

    private class g extends b {

        /* renamed from: i  reason: collision with root package name */
        private boolean f6105i;

        g() {
            super();
        }

        public long K(s4.c cVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f6089f) {
                throw new IllegalStateException("closed");
            } else if (this.f6105i) {
                return -1;
            } else {
                long K = super.K(cVar, j5);
                if (K != -1) {
                    return K;
                }
                this.f6105i = true;
                b(true, (IOException) null);
                return -1;
            }
        }

        public void close() {
            if (!this.f6089f) {
                if (!this.f6105i) {
                    b(false, (IOException) null);
                }
                this.f6089f = true;
            }
        }
    }

    public a(u uVar, l4.g gVar, s4.e eVar, s4.d dVar) {
        this.f6082a = uVar;
        this.f6083b = gVar;
        this.f6084c = eVar;
        this.f6085d = dVar;
    }

    private String m() {
        String A = this.f6084c.A(this.f6087f);
        this.f6087f -= (long) A.length();
        return A;
    }

    public r a(x xVar, long j5) {
        if ("chunked".equalsIgnoreCase(xVar.c("Transfer-Encoding"))) {
            return h();
        }
        if (j5 != -1) {
            return j(j5);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void b() {
        this.f6085d.flush();
    }

    public void c() {
        this.f6085d.flush();
    }

    public void cancel() {
        l4.c d5 = this.f6083b.d();
        if (d5 != null) {
            d5.c();
        }
    }

    public void d(x xVar) {
        o(xVar.d(), m4.i.a(xVar, this.f6083b.d().p().b().type()));
    }

    public a0 e(z zVar) {
        l4.g gVar = this.f6083b;
        gVar.f5807f.q(gVar.f5806e);
        String g5 = zVar.g("Content-Type");
        if (!m4.e.c(zVar)) {
            return new h(g5, 0, l.b(k(0)));
        }
        if ("chunked".equalsIgnoreCase(zVar.g("Transfer-Encoding"))) {
            return new h(g5, -1, l.b(i(zVar.p().h())));
        }
        long b5 = m4.e.b(zVar);
        return b5 != -1 ? new h(g5, b5, l.b(k(b5))) : new h(g5, -1, l.b(l()));
    }

    public z.a f(boolean z4) {
        int i5 = this.f6086e;
        if (i5 == 1 || i5 == 3) {
            try {
                k a5 = k.a(m());
                z.a j5 = new z.a().n(a5.f5933a).g(a5.f5934b).k(a5.f5935c).j(n());
                if (z4 && a5.f5934b == 100) {
                    return null;
                }
                if (a5.f5934b == 100) {
                    this.f6086e = 3;
                    return j5;
                }
                this.f6086e = 4;
                return j5;
            } catch (EOFException e5) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f6083b);
                iOException.initCause(e5);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f6086e);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(i iVar) {
        t i5 = iVar.i();
        iVar.j(t.f6800d);
        i5.a();
        i5.b();
    }

    public r h() {
        if (this.f6086e == 1) {
            this.f6086e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f6086e);
    }

    public s i(i4.r rVar) {
        if (this.f6086e == 4) {
            this.f6086e = 5;
            return new d(rVar);
        }
        throw new IllegalStateException("state: " + this.f6086e);
    }

    public r j(long j5) {
        if (this.f6086e == 1) {
            this.f6086e = 2;
            return new e(j5);
        }
        throw new IllegalStateException("state: " + this.f6086e);
    }

    public s k(long j5) {
        if (this.f6086e == 4) {
            this.f6086e = 5;
            return new f(j5);
        }
        throw new IllegalStateException("state: " + this.f6086e);
    }

    public s l() {
        if (this.f6086e == 4) {
            l4.g gVar = this.f6083b;
            if (gVar != null) {
                this.f6086e = 5;
                gVar.j();
                return new g();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f6086e);
    }

    public q n() {
        q.a aVar = new q.a();
        while (true) {
            String m5 = m();
            if (m5.length() == 0) {
                return aVar.d();
            }
            j4.a.f5473a.a(aVar, m5);
        }
    }

    public void o(q qVar, String str) {
        if (this.f6086e == 0) {
            this.f6085d.I(str).I("\r\n");
            int g5 = qVar.g();
            for (int i5 = 0; i5 < g5; i5++) {
                this.f6085d.I(qVar.e(i5)).I(": ").I(qVar.h(i5)).I("\r\n");
            }
            this.f6085d.I("\r\n");
            this.f6086e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f6086e);
    }
}
