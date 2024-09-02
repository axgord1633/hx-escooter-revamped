package i4;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    final a f4975a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f4976b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f4977c;

    public b0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f4975a = aVar;
            this.f4976b = proxy;
            this.f4977c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public a a() {
        return this.f4975a;
    }

    public Proxy b() {
        return this.f4976b;
    }

    public boolean c() {
        return this.f4975a.f4969i != null && this.f4976b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f4977c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            return b0Var.f4975a.equals(this.f4975a) && b0Var.f4976b.equals(this.f4976b) && b0Var.f4977c.equals(this.f4977c);
        }
    }

    public int hashCode() {
        return ((((527 + this.f4975a.hashCode()) * 31) + this.f4976b.hashCode()) * 31) + this.f4977c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f4977c + "}";
    }
}
