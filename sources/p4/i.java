package p4;

import i4.u;
import i4.v;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import r4.a;
import r4.b;
import r4.e;
import s4.c;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final i f6588a = k();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f6589b = Logger.getLogger(u.class.getName());

    public static List<String> b(List<v> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            v vVar = list.get(i5);
            if (vVar != v.HTTP_1_0) {
                arrayList.add(vVar.toString());
            }
        }
        return arrayList;
    }

    static byte[] e(List<v> list) {
        c cVar = new c();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            v vVar = list.get(i5);
            if (vVar != v.HTTP_1_0) {
                cVar.writeByte(vVar.toString().length());
                cVar.I(vVar.toString());
            }
        }
        return cVar.m();
    }

    private static i i() {
        i w4 = c.w();
        if (w4 != null) {
            return w4;
        }
        i w5 = d.w();
        if (w5 != null) {
            return w5;
        }
        throw new NullPointerException("No platform found on Android");
    }

    private static i j() {
        e u5;
        if (r() && (u5 = e.u()) != null) {
            return u5;
        }
        f u6 = f.u();
        if (u6 != null) {
            return u6;
        }
        i u7 = g.u();
        return u7 != null ? u7 : new i();
    }

    private static i k() {
        return p() ? i() : j();
    }

    public static i l() {
        return f6588a;
    }

    public static boolean p() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean r() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void a(SSLSocket sSLSocket) {
    }

    public r4.c c(X509TrustManager x509TrustManager) {
        return new a(d(x509TrustManager));
    }

    public e d(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void g(SSLSocket sSLSocket, @Nullable String str, List<v> list) {
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i5) {
        socket.connect(inetSocketAddress, i5);
    }

    public SSLContext m() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e5) {
            throw new IllegalStateException("No TLS provider", e5);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        return null;
    }

    public Object o(String str) {
        if (f6589b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean q(String str) {
        return true;
    }

    public void s(int i5, String str, @Nullable Throwable th) {
        f6589b.log(i5 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void t(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        s(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
