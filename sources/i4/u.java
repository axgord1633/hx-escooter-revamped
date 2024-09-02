package i4;

import i4.o;
import i4.q;
import i4.z;
import j4.c;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import k4.d;
import l4.g;
import p4.i;

public class u implements Cloneable {
    static final List<v> F = c.s(v.HTTP_2, v.HTTP_1_1);
    static final List<j> G = c.s(j.f5097h, j.f5099j);
    final int A;
    final int B;
    final int C;
    final int D;
    final int E;

    /* renamed from: e  reason: collision with root package name */
    final m f5156e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    final Proxy f5157f;

    /* renamed from: g  reason: collision with root package name */
    final List<v> f5158g;

    /* renamed from: h  reason: collision with root package name */
    final List<j> f5159h;

    /* renamed from: i  reason: collision with root package name */
    final List<s> f5160i;

    /* renamed from: j  reason: collision with root package name */
    final List<s> f5161j;

    /* renamed from: k  reason: collision with root package name */
    final o.c f5162k;

    /* renamed from: l  reason: collision with root package name */
    final ProxySelector f5163l;

    /* renamed from: m  reason: collision with root package name */
    final l f5164m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    final d f5165n;

    /* renamed from: o  reason: collision with root package name */
    final SocketFactory f5166o;

    /* renamed from: p  reason: collision with root package name */
    final SSLSocketFactory f5167p;

    /* renamed from: q  reason: collision with root package name */
    final r4.c f5168q;

    /* renamed from: r  reason: collision with root package name */
    final HostnameVerifier f5169r;

    /* renamed from: s  reason: collision with root package name */
    final f f5170s;

    /* renamed from: t  reason: collision with root package name */
    final b f5171t;

    /* renamed from: u  reason: collision with root package name */
    final b f5172u;

    /* renamed from: v  reason: collision with root package name */
    final i f5173v;

    /* renamed from: w  reason: collision with root package name */
    final n f5174w;

    /* renamed from: x  reason: collision with root package name */
    final boolean f5175x;

    /* renamed from: y  reason: collision with root package name */
    final boolean f5176y;

    /* renamed from: z  reason: collision with root package name */
    final boolean f5177z;

    class a extends j4.a {
        a() {
        }

        public void a(q.a aVar, String str) {
            aVar.b(str);
        }

        public void b(q.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        public void c(j jVar, SSLSocket sSLSocket, boolean z4) {
            jVar.a(sSLSocket, z4);
        }

        public int d(z.a aVar) {
            return aVar.f5251c;
        }

        public boolean e(i iVar, l4.c cVar) {
            return iVar.b(cVar);
        }

        public Socket f(i iVar, a aVar, g gVar) {
            return iVar.c(aVar, gVar);
        }

        public boolean g(a aVar, a aVar2) {
            return aVar.d(aVar2);
        }

        public l4.c h(i iVar, a aVar, g gVar, b0 b0Var) {
            return iVar.d(aVar, gVar, b0Var);
        }

        public void i(i iVar, l4.c cVar) {
            iVar.f(cVar);
        }

        public l4.d j(i iVar) {
            return iVar.f5091e;
        }

        @Nullable
        public IOException k(d dVar, @Nullable IOException iOException) {
            return ((w) dVar).j(iOException);
        }
    }

    public static final class b {
        int A;

        /* renamed from: a  reason: collision with root package name */
        m f5178a = new m();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        Proxy f5179b;

        /* renamed from: c  reason: collision with root package name */
        List<v> f5180c = u.F;

        /* renamed from: d  reason: collision with root package name */
        List<j> f5181d = u.G;

        /* renamed from: e  reason: collision with root package name */
        final List<s> f5182e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List<s> f5183f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        o.c f5184g = o.k(o.f5130a);

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f5185h;

        /* renamed from: i  reason: collision with root package name */
        l f5186i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        d f5187j;

        /* renamed from: k  reason: collision with root package name */
        SocketFactory f5188k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        SSLSocketFactory f5189l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        r4.c f5190m;

        /* renamed from: n  reason: collision with root package name */
        HostnameVerifier f5191n;

        /* renamed from: o  reason: collision with root package name */
        f f5192o;

        /* renamed from: p  reason: collision with root package name */
        b f5193p;

        /* renamed from: q  reason: collision with root package name */
        b f5194q;

        /* renamed from: r  reason: collision with root package name */
        i f5195r;

        /* renamed from: s  reason: collision with root package name */
        n f5196s;

        /* renamed from: t  reason: collision with root package name */
        boolean f5197t;

        /* renamed from: u  reason: collision with root package name */
        boolean f5198u;

        /* renamed from: v  reason: collision with root package name */
        boolean f5199v;

        /* renamed from: w  reason: collision with root package name */
        int f5200w;

        /* renamed from: x  reason: collision with root package name */
        int f5201x;

        /* renamed from: y  reason: collision with root package name */
        int f5202y;

        /* renamed from: z  reason: collision with root package name */
        int f5203z;

        public b() {
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f5185h = proxySelector;
            if (proxySelector == null) {
                this.f5185h = new q4.a();
            }
            this.f5186i = l.f5121a;
            this.f5188k = SocketFactory.getDefault();
            this.f5191n = r4.d.f6716a;
            this.f5192o = f.f5008c;
            b bVar = b.f4974a;
            this.f5193p = bVar;
            this.f5194q = bVar;
            this.f5195r = new i();
            this.f5196s = n.f5129a;
            this.f5197t = true;
            this.f5198u = true;
            this.f5199v = true;
            this.f5200w = 0;
            this.f5201x = 10000;
            this.f5202y = 10000;
            this.f5203z = 10000;
            this.A = 0;
        }
    }

    static {
        j4.a.f5473a = new a();
    }

    public u() {
        this(new b());
    }

    u(b bVar) {
        boolean z4;
        r4.c cVar;
        this.f5156e = bVar.f5178a;
        this.f5157f = bVar.f5179b;
        this.f5158g = bVar.f5180c;
        List<j> list = bVar.f5181d;
        this.f5159h = list;
        this.f5160i = c.r(bVar.f5182e);
        this.f5161j = c.r(bVar.f5183f);
        this.f5162k = bVar.f5184g;
        this.f5163l = bVar.f5185h;
        this.f5164m = bVar.f5186i;
        this.f5165n = bVar.f5187j;
        this.f5166o = bVar.f5188k;
        Iterator<j> it = list.iterator();
        loop0:
        while (true) {
            z4 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                j next = it.next();
                if (z4 || next.d()) {
                    z4 = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f5189l;
        if (sSLSocketFactory != null || !z4) {
            this.f5167p = sSLSocketFactory;
            cVar = bVar.f5190m;
        } else {
            X509TrustManager A2 = c.A();
            this.f5167p = s(A2);
            cVar = r4.c.b(A2);
        }
        this.f5168q = cVar;
        if (this.f5167p != null) {
            i.l().f(this.f5167p);
        }
        this.f5169r = bVar.f5191n;
        this.f5170s = bVar.f5192o.f(this.f5168q);
        this.f5171t = bVar.f5193p;
        this.f5172u = bVar.f5194q;
        this.f5173v = bVar.f5195r;
        this.f5174w = bVar.f5196s;
        this.f5175x = bVar.f5197t;
        this.f5176y = bVar.f5198u;
        this.f5177z = bVar.f5199v;
        this.A = bVar.f5200w;
        this.B = bVar.f5201x;
        this.C = bVar.f5202y;
        this.D = bVar.f5203z;
        this.E = bVar.A;
        if (this.f5160i.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f5160i);
        } else if (this.f5161j.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f5161j);
        }
    }

    private static SSLSocketFactory s(X509TrustManager x509TrustManager) {
        try {
            SSLContext m5 = i.l().m();
            m5.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return m5.getSocketFactory();
        } catch (GeneralSecurityException e5) {
            throw c.b("No System TLS", e5);
        }
    }

    public SocketFactory A() {
        return this.f5166o;
    }

    public SSLSocketFactory B() {
        return this.f5167p;
    }

    public int C() {
        return this.D;
    }

    public b a() {
        return this.f5172u;
    }

    public int b() {
        return this.A;
    }

    public f c() {
        return this.f5170s;
    }

    public int d() {
        return this.B;
    }

    public i f() {
        return this.f5173v;
    }

    public List<j> g() {
        return this.f5159h;
    }

    public l h() {
        return this.f5164m;
    }

    public m i() {
        return this.f5156e;
    }

    public n j() {
        return this.f5174w;
    }

    public o.c k() {
        return this.f5162k;
    }

    public boolean l() {
        return this.f5176y;
    }

    public boolean m() {
        return this.f5175x;
    }

    public HostnameVerifier n() {
        return this.f5169r;
    }

    public List<s> o() {
        return this.f5160i;
    }

    /* access modifiers changed from: package-private */
    public d p() {
        return this.f5165n;
    }

    public List<s> q() {
        return this.f5161j;
    }

    public d r(x xVar) {
        return w.h(this, xVar, false);
    }

    public int t() {
        return this.E;
    }

    public List<v> u() {
        return this.f5158g;
    }

    @Nullable
    public Proxy v() {
        return this.f5157f;
    }

    public b w() {
        return this.f5171t;
    }

    public ProxySelector x() {
        return this.f5163l;
    }

    public int y() {
        return this.C;
    }

    public boolean z() {
        return this.f5177z;
    }
}
