package l4;

import i4.b0;
import i4.h;
import i4.i;
import i4.o;
import i4.p;
import i4.r;
import i4.s;
import i4.u;
import i4.v;
import i4.x;
import i4.y;
import i4.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import n4.a;
import o4.b;
import o4.f;
import o4.g;
import s4.d;
import s4.e;
import s4.l;
import s4.s;

public final class c extends g.j implements h {

    /* renamed from: b  reason: collision with root package name */
    private final i f5775b;

    /* renamed from: c  reason: collision with root package name */
    private final b0 f5776c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f5777d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f5778e;

    /* renamed from: f  reason: collision with root package name */
    private p f5779f;

    /* renamed from: g  reason: collision with root package name */
    private v f5780g;

    /* renamed from: h  reason: collision with root package name */
    private g f5781h;

    /* renamed from: i  reason: collision with root package name */
    private e f5782i;

    /* renamed from: j  reason: collision with root package name */
    private d f5783j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5784k;

    /* renamed from: l  reason: collision with root package name */
    public int f5785l;

    /* renamed from: m  reason: collision with root package name */
    public int f5786m = 1;

    /* renamed from: n  reason: collision with root package name */
    public final List<Reference<g>> f5787n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public long f5788o = Long.MAX_VALUE;

    public c(i iVar, b0 b0Var) {
        this.f5775b = iVar;
        this.f5776c = b0Var;
    }

    private void e(int i5, int i6, i4.d dVar, o oVar) {
        Proxy b5 = this.f5776c.b();
        this.f5777d = (b5.type() == Proxy.Type.DIRECT || b5.type() == Proxy.Type.HTTP) ? this.f5776c.a().j().createSocket() : new Socket(b5);
        oVar.f(dVar, this.f5776c.d(), b5);
        this.f5777d.setSoTimeout(i6);
        try {
            p4.i.l().h(this.f5777d, this.f5776c.d(), i5);
            try {
                this.f5782i = l.b(l.i(this.f5777d));
                this.f5783j = l.a(l.f(this.f5777d));
            } catch (NullPointerException e5) {
                if ("throw with null exception".equals(e5.getMessage())) {
                    throw new IOException(e5);
                }
            }
        } catch (ConnectException e6) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f5776c.d());
            connectException.initCause(e6);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0135 A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013b A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(l4.b r8) {
        /*
            r7 = this;
            i4.b0 r0 = r7.f5776c
            i4.a r0 = r0.a()
            javax.net.ssl.SSLSocketFactory r1 = r0.k()
            r2 = 0
            java.net.Socket r3 = r7.f5777d     // Catch:{ AssertionError -> 0x012e }
            i4.r r4 = r0.l()     // Catch:{ AssertionError -> 0x012e }
            java.lang.String r4 = r4.l()     // Catch:{ AssertionError -> 0x012e }
            i4.r r5 = r0.l()     // Catch:{ AssertionError -> 0x012e }
            int r5 = r5.w()     // Catch:{ AssertionError -> 0x012e }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x012e }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x012e }
            i4.j r8 = r8.a(r1)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r3 = r8.f()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r3 == 0) goto L_0x0041
            p4.i r3 = p4.i.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            i4.r r4 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r4 = r4.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.util.List r5 = r0.f()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r3.g(r1, r4, r5)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            i4.p r4 = i4.p.b(r3)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            javax.net.ssl.HostnameVerifier r5 = r0.e()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            i4.r r6 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r6 = r6.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r3 != 0) goto L_0x00d8
            java.util.List r8 = r4.c()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r2 = r8.isEmpty()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r3 = "Hostname "
            if (r2 != 0) goto L_0x00b6
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.<init>()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r3)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            i4.r r0 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = i4.f.c(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = "\n    DN: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.util.List r8 = r4.d.a(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r8 = r4.toString()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            throw r2     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x00b6:
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.<init>()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.append(r3)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            i4.r r0 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r2.toString()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            throw r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x00d8:
            i4.f r3 = r0.a()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            i4.r r0 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.util.List r5 = r4.c()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r3.a(r0, r5)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r8 = r8.f()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r8 == 0) goto L_0x00f9
            p4.i r8 = p4.i.l()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r2 = r8.n(r1)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x00f9:
            r7.f5778e = r1     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            s4.s r8 = s4.l.i(r1)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            s4.e r8 = s4.l.b(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r7.f5782i = r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.net.Socket r8 = r7.f5778e     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            s4.r r8 = s4.l.f(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            s4.d r8 = s4.l.a(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r7.f5783j = r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r7.f5779f = r4     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r2 == 0) goto L_0x011a
            i4.v r8 = i4.v.c(r2)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            goto L_0x011c
        L_0x011a:
            i4.v r8 = i4.v.HTTP_1_1     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x011c:
            r7.f5780g = r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            p4.i r8 = p4.i.l()
            r8.a(r1)
            return
        L_0x0126:
            r8 = move-exception
            r2 = r1
            goto L_0x013c
        L_0x0129:
            r8 = move-exception
            r2 = r1
            goto L_0x012f
        L_0x012c:
            r8 = move-exception
            goto L_0x013c
        L_0x012e:
            r8 = move-exception
        L_0x012f:
            boolean r0 = j4.c.y(r8)     // Catch:{ all -> 0x012c }
            if (r0 == 0) goto L_0x013b
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012c }
            r0.<init>(r8)     // Catch:{ all -> 0x012c }
            throw r0     // Catch:{ all -> 0x012c }
        L_0x013b:
            throw r8     // Catch:{ all -> 0x012c }
        L_0x013c:
            if (r2 == 0) goto L_0x0145
            p4.i r0 = p4.i.l()
            r0.a(r2)
        L_0x0145:
            j4.c.f(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.c.f(l4.b):void");
    }

    private void g(int i5, int i6, int i7, i4.d dVar, o oVar) {
        x i8 = i();
        r h5 = i8.h();
        int i9 = 0;
        while (i9 < 21) {
            e(i5, i6, dVar, oVar);
            i8 = h(i6, i7, i8, h5);
            if (i8 != null) {
                j4.c.f(this.f5777d);
                this.f5777d = null;
                this.f5783j = null;
                this.f5782i = null;
                oVar.d(dVar, this.f5776c.d(), this.f5776c.b(), (v) null);
                i9++;
            } else {
                return;
            }
        }
    }

    private x h(int i5, int i6, x xVar, r rVar) {
        String str = "CONNECT " + j4.c.q(rVar, true) + " HTTP/1.1";
        while (true) {
            a aVar = new a((u) null, (g) null, this.f5782i, this.f5783j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f5782i.c().g((long) i5, timeUnit);
            this.f5783j.c().g((long) i6, timeUnit);
            aVar.o(xVar.d(), str);
            aVar.b();
            z c5 = aVar.f(false).p(xVar).c();
            long b5 = m4.e.b(c5);
            if (b5 == -1) {
                b5 = 0;
            }
            s k5 = aVar.k(b5);
            j4.c.B(k5, Integer.MAX_VALUE, timeUnit);
            k5.close();
            int e5 = c5.e();
            if (e5 != 200) {
                if (e5 == 407) {
                    x a5 = this.f5776c.a().h().a(this.f5776c, c5);
                    if (a5 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(c5.g("Connection"))) {
                        return a5;
                    } else {
                        xVar = a5;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c5.e());
                }
            } else if (this.f5782i.a().t() && this.f5783j.a().t()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private x i() {
        x a5 = new x.a().f(this.f5776c.a().l()).d("CONNECT", (y) null).b("Host", j4.c.q(this.f5776c.a().l(), true)).b("Proxy-Connection", "Keep-Alive").b("User-Agent", j4.d.a()).a();
        x a6 = this.f5776c.a().h().a(this.f5776c, new z.a().p(a5).n(v.HTTP_1_1).g(407).k("Preemptive Authenticate").b(j4.c.f5477c).q(-1).o(-1).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return a6 != null ? a6 : a5;
    }

    private void j(b bVar, int i5, i4.d dVar, o oVar) {
        if (this.f5776c.a().k() == null) {
            List<v> f5 = this.f5776c.a().f();
            v vVar = v.H2_PRIOR_KNOWLEDGE;
            if (f5.contains(vVar)) {
                this.f5778e = this.f5777d;
                this.f5780g = vVar;
                r(i5);
                return;
            }
            this.f5778e = this.f5777d;
            this.f5780g = v.HTTP_1_1;
            return;
        }
        oVar.u(dVar);
        f(bVar);
        oVar.t(dVar, this.f5779f);
        if (this.f5780g == v.HTTP_2) {
            r(i5);
        }
    }

    private void r(int i5) {
        this.f5778e.setSoTimeout(0);
        g a5 = new g.h(true).d(this.f5778e, this.f5776c.a().l().l(), this.f5782i, this.f5783j).b(this).c(i5).a();
        this.f5781h = a5;
        a5.T();
    }

    public void a(g gVar) {
        synchronized (this.f5775b) {
            this.f5786m = gVar.B();
        }
    }

    public void b(o4.i iVar) {
        iVar.f(b.REFUSED_STREAM);
    }

    public void c() {
        j4.c.f(this.f5777d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(int r17, int r18, int r19, int r20, boolean r21, i4.d r22, i4.o r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            i4.v r0 = r7.f5780g
            if (r0 != 0) goto L_0x0150
            i4.b0 r0 = r7.f5776c
            i4.a r0 = r0.a()
            java.util.List r0 = r0.b()
            l4.b r10 = new l4.b
            r10.<init>(r0)
            i4.b0 r1 = r7.f5776c
            i4.a r1 = r1.a()
            javax.net.ssl.SSLSocketFactory r1 = r1.k()
            if (r1 != 0) goto L_0x0074
            i4.j r1 = i4.j.f5099j
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            i4.b0 r0 = r7.f5776c
            i4.a r0 = r0.a()
            i4.r r0 = r0.l()
            java.lang.String r0 = r0.l()
            p4.i r1 = p4.i.l()
            boolean r1 = r1.q(r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0086
        L_0x0046:
            l4.e r1 = new l4.e
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            l4.e r0 = new l4.e
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            i4.b0 r0 = r7.f5776c
            i4.a r0 = r0.a()
            java.util.List r0 = r0.f()
            i4.v r1 = i4.v.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0143
        L_0x0086:
            r11 = 0
            r12 = r11
        L_0x0088:
            i4.b0 r0 = r7.f5776c     // Catch:{ IOException -> 0x00f9 }
            boolean r0 = r0.c()     // Catch:{ IOException -> 0x00f9 }
            if (r0 == 0) goto L_0x00a9
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.g(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f9 }
            java.net.Socket r0 = r7.f5777d     // Catch:{ IOException -> 0x00f9 }
            if (r0 != 0) goto L_0x00a4
            goto L_0x00c6
        L_0x00a4:
            r13 = r17
            r14 = r18
            goto L_0x00b0
        L_0x00a9:
            r13 = r17
            r14 = r18
            r7.e(r13, r14, r8, r9)     // Catch:{ IOException -> 0x00f7 }
        L_0x00b0:
            r15 = r20
            r7.j(r10, r15, r8, r9)     // Catch:{ IOException -> 0x00f5 }
            i4.b0 r0 = r7.f5776c     // Catch:{ IOException -> 0x00f5 }
            java.net.InetSocketAddress r0 = r0.d()     // Catch:{ IOException -> 0x00f5 }
            i4.b0 r1 = r7.f5776c     // Catch:{ IOException -> 0x00f5 }
            java.net.Proxy r1 = r1.b()     // Catch:{ IOException -> 0x00f5 }
            i4.v r2 = r7.f5780g     // Catch:{ IOException -> 0x00f5 }
            r9.d(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f5 }
        L_0x00c6:
            i4.b0 r0 = r7.f5776c
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x00e0
            java.net.Socket r0 = r7.f5777d
            if (r0 == 0) goto L_0x00d3
            goto L_0x00e0
        L_0x00d3:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            l4.e r1 = new l4.e
            r1.<init>(r0)
            throw r1
        L_0x00e0:
            o4.g r0 = r7.f5781h
            if (r0 == 0) goto L_0x00f4
            i4.i r1 = r7.f5775b
            monitor-enter(r1)
            o4.g r0 = r7.f5781h     // Catch:{ all -> 0x00f1 }
            int r0 = r0.B()     // Catch:{ all -> 0x00f1 }
            r7.f5786m = r0     // Catch:{ all -> 0x00f1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            throw r0
        L_0x00f4:
            return
        L_0x00f5:
            r0 = move-exception
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00fe:
            r15 = r20
        L_0x0100:
            java.net.Socket r1 = r7.f5778e
            j4.c.f(r1)
            java.net.Socket r1 = r7.f5777d
            j4.c.f(r1)
            r7.f5778e = r11
            r7.f5777d = r11
            r7.f5782i = r11
            r7.f5783j = r11
            r7.f5779f = r11
            r7.f5780g = r11
            r7.f5781h = r11
            i4.b0 r1 = r7.f5776c
            java.net.InetSocketAddress r3 = r1.d()
            i4.b0 r1 = r7.f5776c
            java.net.Proxy r4 = r1.b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.e(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0135
            l4.e r12 = new l4.e
            r12.<init>(r0)
            goto L_0x0138
        L_0x0135:
            r12.a(r0)
        L_0x0138:
            if (r21 == 0) goto L_0x0142
            boolean r0 = r10.b(r0)
            if (r0 == 0) goto L_0x0142
            goto L_0x0088
        L_0x0142:
            throw r12
        L_0x0143:
            l4.e r0 = new l4.e
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.c.d(int, int, int, int, boolean, i4.d, i4.o):void");
    }

    public p k() {
        return this.f5779f;
    }

    public boolean l(i4.a aVar, @Nullable b0 b0Var) {
        if (this.f5787n.size() >= this.f5786m || this.f5784k || !j4.a.f5473a.g(this.f5776c.a(), aVar)) {
            return false;
        }
        if (aVar.l().l().equals(p().a().l().l())) {
            return true;
        }
        if (this.f5781h == null || b0Var == null || b0Var.b().type() != Proxy.Type.DIRECT || this.f5776c.b().type() != Proxy.Type.DIRECT || !this.f5776c.d().equals(b0Var.d()) || b0Var.a().e() != r4.d.f6716a || !s(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().l(), k().c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean m(boolean z4) {
        int soTimeout;
        if (this.f5778e.isClosed() || this.f5778e.isInputShutdown() || this.f5778e.isOutputShutdown()) {
            return false;
        }
        g gVar = this.f5781h;
        if (gVar != null) {
            return gVar.z(System.nanoTime());
        }
        if (z4) {
            try {
                soTimeout = this.f5778e.getSoTimeout();
                this.f5778e.setSoTimeout(1);
                if (this.f5782i.t()) {
                    this.f5778e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f5778e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f5778e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean n() {
        return this.f5781h != null;
    }

    public m4.c o(u uVar, s.a aVar, g gVar) {
        if (this.f5781h != null) {
            return new f(uVar, aVar, gVar, this.f5781h);
        }
        this.f5778e.setSoTimeout(aVar.c());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f5782i.c().g((long) aVar.c(), timeUnit);
        this.f5783j.c().g((long) aVar.d(), timeUnit);
        return new a(uVar, gVar, this.f5782i, this.f5783j);
    }

    public b0 p() {
        return this.f5776c;
    }

    public Socket q() {
        return this.f5778e;
    }

    public boolean s(r rVar) {
        if (rVar.w() != this.f5776c.a().l().w()) {
            return false;
        }
        if (!rVar.l().equals(this.f5776c.a().l().l())) {
            return this.f5779f != null && r4.d.f6716a.c(rVar.l(), (X509Certificate) this.f5779f.c().get(0));
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f5776c.a().l().l());
        sb.append(":");
        sb.append(this.f5776c.a().l().w());
        sb.append(", proxy=");
        sb.append(this.f5776c.b());
        sb.append(" hostAddress=");
        sb.append(this.f5776c.d());
        sb.append(" cipherSuite=");
        p pVar = this.f5779f;
        sb.append(pVar != null ? pVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f5780g);
        sb.append('}');
        return sb.toString();
    }
}
