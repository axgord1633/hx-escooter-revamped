package i4;

import i4.r;
import j4.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final r f4961a;

    /* renamed from: b  reason: collision with root package name */
    final n f4962b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f4963c;

    /* renamed from: d  reason: collision with root package name */
    final b f4964d;

    /* renamed from: e  reason: collision with root package name */
    final List<v> f4965e;

    /* renamed from: f  reason: collision with root package name */
    final List<j> f4966f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f4967g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    final Proxy f4968h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f4969i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f4970j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    final f f4971k;

    public a(String str, int i5, n nVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable f fVar, b bVar, @Nullable Proxy proxy, List<v> list, List<j> list2, ProxySelector proxySelector) {
        this.f4961a = new r.a().q(sSLSocketFactory != null ? "https" : "http").e(str).l(i5).a();
        if (nVar != null) {
            this.f4962b = nVar;
            if (socketFactory != null) {
                this.f4963c = socketFactory;
                if (bVar != null) {
                    this.f4964d = bVar;
                    if (list != null) {
                        this.f4965e = c.r(list);
                        if (list2 != null) {
                            this.f4966f = c.r(list2);
                            if (proxySelector != null) {
                                this.f4967g = proxySelector;
                                this.f4968h = proxy;
                                this.f4969i = sSLSocketFactory;
                                this.f4970j = hostnameVerifier;
                                this.f4971k = fVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    @Nullable
    public f a() {
        return this.f4971k;
    }

    public List<j> b() {
        return this.f4966f;
    }

    public n c() {
        return this.f4962b;
    }

    /* access modifiers changed from: package-private */
    public boolean d(a aVar) {
        return this.f4962b.equals(aVar.f4962b) && this.f4964d.equals(aVar.f4964d) && this.f4965e.equals(aVar.f4965e) && this.f4966f.equals(aVar.f4966f) && this.f4967g.equals(aVar.f4967g) && c.o(this.f4968h, aVar.f4968h) && c.o(this.f4969i, aVar.f4969i) && c.o(this.f4970j, aVar.f4970j) && c.o(this.f4971k, aVar.f4971k) && l().w() == aVar.l().w();
    }

    @Nullable
    public HostnameVerifier e() {
        return this.f4970j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f4961a.equals(aVar.f4961a) && d(aVar);
        }
    }

    public List<v> f() {
        return this.f4965e;
    }

    @Nullable
    public Proxy g() {
        return this.f4968h;
    }

    public b h() {
        return this.f4964d;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f4961a.hashCode()) * 31) + this.f4962b.hashCode()) * 31) + this.f4964d.hashCode()) * 31) + this.f4965e.hashCode()) * 31) + this.f4966f.hashCode()) * 31) + this.f4967g.hashCode()) * 31;
        Proxy proxy = this.f4968h;
        int i5 = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f4969i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f4970j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        f fVar = this.f4971k;
        if (fVar != null) {
            i5 = fVar.hashCode();
        }
        return hashCode4 + i5;
    }

    public ProxySelector i() {
        return this.f4967g;
    }

    public SocketFactory j() {
        return this.f4963c;
    }

    @Nullable
    public SSLSocketFactory k() {
        return this.f4969i;
    }

    public r l() {
        return this.f4961a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f4961a.l());
        sb.append(":");
        sb.append(this.f4961a.w());
        if (this.f4968h != null) {
            sb.append(", proxy=");
            obj = this.f4968h;
        } else {
            sb.append(", proxySelector=");
            obj = this.f4967g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
