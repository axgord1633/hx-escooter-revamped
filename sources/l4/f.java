package l4;

import i4.b0;
import i4.d;
import i4.o;
import i4.r;
import j4.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final i4.a f5792a;

    /* renamed from: b  reason: collision with root package name */
    private final d f5793b;

    /* renamed from: c  reason: collision with root package name */
    private final d f5794c;

    /* renamed from: d  reason: collision with root package name */
    private final o f5795d;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f5796e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private int f5797f;

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f5798g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    private final List<b0> f5799h = new ArrayList();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b0> f5800a;

        /* renamed from: b  reason: collision with root package name */
        private int f5801b = 0;

        a(List<b0> list) {
            this.f5800a = list;
        }

        public List<b0> a() {
            return new ArrayList(this.f5800a);
        }

        public boolean b() {
            return this.f5801b < this.f5800a.size();
        }

        public b0 c() {
            if (b()) {
                List<b0> list = this.f5800a;
                int i5 = this.f5801b;
                this.f5801b = i5 + 1;
                return list.get(i5);
            }
            throw new NoSuchElementException();
        }
    }

    public f(i4.a aVar, d dVar, d dVar2, o oVar) {
        this.f5792a = aVar;
        this.f5793b = dVar;
        this.f5794c = dVar2;
        this.f5795d = oVar;
        h(aVar.l(), aVar.g());
    }

    static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean d() {
        return this.f5797f < this.f5796e.size();
    }

    private Proxy f() {
        if (d()) {
            List<Proxy> list = this.f5796e;
            int i5 = this.f5797f;
            this.f5797f = i5 + 1;
            Proxy proxy = list.get(i5);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f5792a.l().l() + "; exhausted proxy configurations: " + this.f5796e);
    }

    private void g(Proxy proxy) {
        String str;
        int i5;
        this.f5798g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f5792a.l().l();
            i5 = this.f5792a.l().w();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = b(inetSocketAddress);
                i5 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i5 < 1 || i5 > 65535) {
            throw new SocketException("No route to " + str + ":" + i5 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f5798g.add(InetSocketAddress.createUnresolved(str, i5));
        } else {
            this.f5795d.j(this.f5794c, str);
            List<InetAddress> a5 = this.f5792a.c().a(str);
            if (!a5.isEmpty()) {
                this.f5795d.i(this.f5794c, str, a5);
                int size = a5.size();
                for (int i6 = 0; i6 < size; i6++) {
                    this.f5798g.add(new InetSocketAddress(a5.get(i6), i5));
                }
                return;
            }
            throw new UnknownHostException(this.f5792a.c() + " returned no addresses for " + str);
        }
    }

    private void h(r rVar, Proxy proxy) {
        List<Proxy> s5;
        if (proxy != null) {
            s5 = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f5792a.i().select(rVar.C());
            if (select == null || select.isEmpty()) {
                s5 = c.s(Proxy.NO_PROXY);
            } else {
                s5 = c.r(select);
            }
        }
        this.f5796e = s5;
        this.f5797f = 0;
    }

    public void a(b0 b0Var, IOException iOException) {
        if (!(b0Var.b().type() == Proxy.Type.DIRECT || this.f5792a.i() == null)) {
            this.f5792a.i().connectFailed(this.f5792a.l().C(), b0Var.b().address(), iOException);
        }
        this.f5793b.b(b0Var);
    }

    public boolean c() {
        return d() || !this.f5799h.isEmpty();
    }

    public a e() {
        if (c()) {
            ArrayList arrayList = new ArrayList();
            while (d()) {
                Proxy f5 = f();
                int size = this.f5798g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    b0 b0Var = new b0(this.f5792a, f5, this.f5798g.get(i5));
                    if (this.f5793b.c(b0Var)) {
                        this.f5799h.add(b0Var);
                    } else {
                        arrayList.add(b0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f5799h);
                this.f5799h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
