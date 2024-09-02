package p4;

import android.os.Build;
import android.util.Log;
import i4.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import r4.e;

class d extends i {

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f6562c;

    /* renamed from: d  reason: collision with root package name */
    private final h<Socket> f6563d;

    /* renamed from: e  reason: collision with root package name */
    private final h<Socket> f6564e;

    /* renamed from: f  reason: collision with root package name */
    private final h<Socket> f6565f;

    /* renamed from: g  reason: collision with root package name */
    private final h<Socket> f6566g;

    /* renamed from: h  reason: collision with root package name */
    private final c f6567h = c.b();

    static final class a extends r4.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f6568a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f6569b;

        a(Object obj, Method method) {
            this.f6568a = obj;
            this.f6569b = method;
        }

        public List<Certificate> a(List<Certificate> list, String str) {
            try {
                return (List) this.f6569b.invoke(this.f6568a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e5) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e5.getMessage());
                sSLPeerUnverifiedException.initCause(e5);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f6570a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f6571b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f6571b = method;
            this.f6570a = x509TrustManager;
        }

        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f6571b.invoke(this.f6570a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e5) {
                throw j4.c.b("unable to get issues and signature", e5);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f6570a.equals(bVar.f6570a) && this.f6571b.equals(bVar.f6571b);
        }

        public int hashCode() {
            return this.f6570a.hashCode() + (this.f6571b.hashCode() * 31);
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f6572a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f6573b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f6574c;

        c(Method method, Method method2, Method method3) {
            this.f6572a = method;
            this.f6573b = method2;
            this.f6574c = method3;
        }

        static c b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new c(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        public Object a(String str) {
            Method method = this.f6572a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, new Object[0]);
                    this.f6573b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f6574c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    d(Class<?> cls, h<Socket> hVar, h<Socket> hVar2, h<Socket> hVar3, h<Socket> hVar4) {
        this.f6562c = cls;
        this.f6563d = hVar;
        this.f6564e = hVar2;
        this.f6565f = hVar3;
        this.f6566g = hVar4;
    }

    private boolean u(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.q(str);
        }
    }

    private boolean v(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return u(str, cls, obj);
        }
    }

    public static i w() {
        Class<?> cls;
        h hVar;
        h hVar2;
        Class<byte[]> cls2 = byte[].class;
        if (!i.p()) {
            return null;
        }
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        h hVar3 = new h((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        h hVar4 = new h((Class<?>) null, "setHostname", String.class);
        if (y()) {
            h hVar5 = new h(cls2, "getAlpnSelectedProtocol", new Class[0]);
            hVar = new h((Class<?>) null, "setAlpnProtocols", cls2);
            hVar2 = hVar5;
        } else {
            hVar2 = null;
            hVar = null;
        }
        return new d(cls3, hVar3, hVar4, hVar2, hVar);
    }

    static int x() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    private static boolean y() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public r4.c c(X509TrustManager x509TrustManager) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls2.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls2.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls, cls}));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    public e d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    public void g(SSLSocket sSLSocket, String str, List<v> list) {
        if (str != null) {
            this.f6563d.e(sSLSocket, Boolean.TRUE);
            this.f6564e.e(sSLSocket, str);
        }
        h<Socket> hVar = this.f6566g;
        if (hVar != null && hVar.g(sSLSocket)) {
            this.f6566g.f(sSLSocket, i.e(list));
        }
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i5) {
        try {
            socket.connect(inetSocketAddress, i5);
        } catch (AssertionError e5) {
            if (j4.c.y(e5)) {
                throw new IOException(e5);
            }
            throw e5;
        } catch (SecurityException e6) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e6);
            throw iOException;
        } catch (ClassCastException e7) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e7);
                throw iOException2;
            }
            throw e7;
        }
    }

    public SSLContext m() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e5) {
            throw new IllegalStateException("No TLS provider", e5);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        byte[] bArr;
        h<Socket> hVar = this.f6565f;
        if (hVar == null || !hVar.g(sSLSocket) || (bArr = (byte[]) this.f6565f.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, j4.c.f5484j);
    }

    public Object o(String str) {
        return this.f6567h.a(str);
    }

    public boolean q(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return v(str, cls, cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.q(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e5) {
            throw j4.c.b("unable to determine cleartext support", e5);
        }
    }

    public void s(int i5, String str, @Nullable Throwable th) {
        int min;
        int i6 = 5;
        if (i5 != 5) {
            i6 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i7 = 0;
        int length = str.length();
        while (i7 < length) {
            int indexOf = str.indexOf(10, i7);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i7 + 4000);
                Log.println(i6, "OkHttp", str.substring(i7, min));
                if (min >= indexOf) {
                    break;
                }
                i7 = min;
            }
            i7 = min + 1;
        }
    }

    public void t(String str, Object obj) {
        if (!this.f6567h.c(obj)) {
            s(5, str, (Throwable) null);
        }
    }
}
