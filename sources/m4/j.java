package m4;

import i4.a;
import i4.a0;
import i4.b0;
import i4.d;
import i4.f;
import i4.o;
import i4.r;
import i4.s;
import i4.u;
import i4.x;
import i4.y;
import i4.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import l4.c;
import l4.e;
import l4.g;

public final class j implements s {

    /* renamed from: a  reason: collision with root package name */
    private final u f5928a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5929b;

    /* renamed from: c  reason: collision with root package name */
    private volatile g f5930c;

    /* renamed from: d  reason: collision with root package name */
    private Object f5931d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f5932e;

    public j(u uVar, boolean z4) {
        this.f5928a = uVar;
        this.f5929b = z4;
    }

    private a c(r rVar) {
        f fVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (rVar.m()) {
            SSLSocketFactory B = this.f5928a.B();
            hostnameVerifier = this.f5928a.n();
            sSLSocketFactory = B;
            fVar = this.f5928a.c();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            fVar = null;
        }
        return new a(rVar.l(), rVar.w(), this.f5928a.j(), this.f5928a.A(), sSLSocketFactory, hostnameVerifier, fVar, this.f5928a.w(), this.f5928a.v(), this.f5928a.u(), this.f5928a.g(), this.f5928a.x());
    }

    private x d(z zVar, b0 b0Var) {
        String g5;
        r A;
        if (zVar != null) {
            int e5 = zVar.e();
            String f5 = zVar.p().f();
            y yVar = null;
            if (e5 == 307 || e5 == 308) {
                if (!f5.equals("GET") && !f5.equals("HEAD")) {
                    return null;
                }
            } else if (e5 == 401) {
                return this.f5928a.a().a(b0Var, zVar);
            } else {
                if (e5 != 503) {
                    if (e5 != 407) {
                        if (e5 != 408) {
                            switch (e5) {
                                case 300:
                                case 301:
                                case 302:
                                case 303:
                                    break;
                                default:
                                    return null;
                            }
                        } else if (!this.f5928a.z()) {
                            return null;
                        } else {
                            zVar.p().a();
                            if ((zVar.m() == null || zVar.m().e() != 408) && i(zVar, 0) <= 0) {
                                return zVar.p();
                            }
                            return null;
                        }
                    } else if (b0Var.b().type() == Proxy.Type.HTTP) {
                        return this.f5928a.w().a(b0Var, zVar);
                    } else {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                } else if ((zVar.m() == null || zVar.m().e() != 503) && i(zVar, Integer.MAX_VALUE) == 0) {
                    return zVar.p();
                } else {
                    return null;
                }
            }
            if (!this.f5928a.l() || (g5 = zVar.g("Location")) == null || (A = zVar.p().h().A(g5)) == null) {
                return null;
            }
            if (!A.B().equals(zVar.p().h().B()) && !this.f5928a.m()) {
                return null;
            }
            x.a g6 = zVar.p().g();
            if (f.b(f5)) {
                boolean d5 = f.d(f5);
                if (f.c(f5)) {
                    g6.d("GET", (y) null);
                } else {
                    if (d5) {
                        yVar = zVar.p().a();
                    }
                    g6.d(f5, yVar);
                }
                if (!d5) {
                    g6.e("Transfer-Encoding");
                    g6.e("Content-Length");
                    g6.e("Content-Type");
                }
            }
            if (!j(zVar, A)) {
                g6.e("Authorization");
            }
            return g6.f(A).a();
        }
        throw new IllegalStateException();
    }

    private boolean f(IOException iOException, boolean z4) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z4 : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    private boolean g(IOException iOException, g gVar, boolean z4, x xVar) {
        gVar.q(iOException);
        if (!this.f5928a.z()) {
            return false;
        }
        return (!z4 || !h(iOException, xVar)) && f(iOException, z4) && gVar.h();
    }

    private boolean h(IOException iOException, x xVar) {
        xVar.a();
        return iOException instanceof FileNotFoundException;
    }

    private int i(z zVar, int i5) {
        String g5 = zVar.g("Retry-After");
        if (g5 == null) {
            return i5;
        }
        if (g5.matches("\\d+")) {
            return Integer.valueOf(g5).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean j(z zVar, r rVar) {
        r h5 = zVar.p().h();
        return h5.l().equals(rVar.l()) && h5.w() == rVar.w() && h5.B().equals(rVar.B());
    }

    public z a(s.a aVar) {
        x e5 = aVar.e();
        g gVar = (g) aVar;
        d f5 = gVar.f();
        o h5 = gVar.h();
        g gVar2 = new g(this.f5928a.f(), c(e5.h()), f5, h5, this.f5931d);
        this.f5930c = gVar2;
        int i5 = 0;
        z zVar = null;
        while (!this.f5932e) {
            try {
                z j5 = gVar.j(e5, gVar2, (c) null, (c) null);
                if (zVar != null) {
                    j5 = j5.l().m(zVar.l().b((a0) null).c()).c();
                }
                try {
                    x d5 = d(j5, gVar2.o());
                    if (d5 == null) {
                        gVar2.k();
                        return j5;
                    }
                    j4.c.e(j5.b());
                    int i6 = i5 + 1;
                    if (i6 <= 20) {
                        d5.a();
                        if (!j(j5, d5.h())) {
                            gVar2.k();
                            gVar2 = new g(this.f5928a.f(), c(d5.h()), f5, h5, this.f5931d);
                            this.f5930c = gVar2;
                        } else if (gVar2.c() != null) {
                            throw new IllegalStateException("Closing the body of " + j5 + " didn't close its backing stream. Bad interceptor?");
                        }
                        zVar = j5;
                        e5 = d5;
                        i5 = i6;
                    } else {
                        gVar2.k();
                        throw new ProtocolException("Too many follow-up requests: " + i6);
                    }
                } catch (IOException e6) {
                    gVar2.k();
                    throw e6;
                }
            } catch (e e7) {
                if (!g(e7.c(), gVar2, false, e5)) {
                    throw e7.b();
                }
            } catch (IOException e8) {
                if (!g(e8, gVar2, !(e8 instanceof o4.a), e5)) {
                    throw e8;
                }
            } catch (Throwable th) {
                gVar2.q((IOException) null);
                gVar2.k();
                throw th;
            }
        }
        gVar2.k();
        throw new IOException("Canceled");
    }

    public void b() {
        this.f5932e = true;
        g gVar = this.f5930c;
        if (gVar != null) {
            gVar.b();
        }
    }

    public boolean e() {
        return this.f5932e;
    }

    public void k(Object obj) {
        this.f5931d = obj;
    }
}
